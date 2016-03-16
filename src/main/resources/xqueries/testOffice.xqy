let $fid := "1717"
let $legalEntity := cts:search(fn:collection('source-trusted')/legalEntity,
        cts:and-query((
            cts:element-attribute-range-query(xs:QName("legalEntity"), xs:QName("fid"), "=", $fid)
        )))

let $offices := (for $x in cts:search(fn:collection('source-trusted')/office,
        cts:and-query((
            cts:path-range-query("/office/@source", "=", "trusted", "collation=http://marklogic.com/collation/"),
            cts:path-range-query("/office/summary/institution/link/@href", "=", $legalEntity/@resource, "collation=http://marklogic.com/collation/")
        ))) order by xs:long(fn:tokenize($x/@fid, '-')[last()]) return $x)

let $officeResults := (
    let $officeInfo := for $x in $offices
        let $officeFid := $x/@fid/string()
        let $officeName := $x/summary/names/name[type="Office Name"]/value/text()
        let $officeSortKey := $x/summary/names/officeSortKey
        let $officeAddress := $x/locations/location[@primary='true']/address/streetAddress/addressLine1
        let $officeCity := $x/locations/location[@primary='true']/address/city/name/text()
        let $officeCitySortKey := $x/locations/location[@primary='true']/address/city/citySortKey
        let $officeArea := $x/locations/location[@primary='true']/address/area/name
        let $officeAreaSortKey := $x/locations/location[@primary='true']/address/area/areaSortKey
        let $officeCountry := $x/locations/location[@primary='true']/address/country/name
        let $officeCountrySortKey := $x/locations/location[@primary='true']/address/country/countrySortKey
        let $orderedOfficeTypes := for $y in $x/summary/types/type order by $y return $y
        let $officeTypes := fn:string-join($orderedOfficeTypes,', ')
        
    return <office>
            <fid>{$officeFid}</fid>
            <officeName>{$officeName}</officeName>
            {$officeSortKey}
            {$officeAddress}
            <officeCity>{$officeCity}</officeCity>
            {$officeCitySortKey}
            <officeArea>{$officeArea}</officeArea>
            {$officeAreaSortKey}
            <officeCountry>{$officeCountry}</officeCountry>
            {$officeCountrySortKey}
            <officeTypes>{$officeTypes}</officeTypes>
           </office>
    return <offices>{$officeInfo}</offices>)

return <offices>{$officeResults}</offices>