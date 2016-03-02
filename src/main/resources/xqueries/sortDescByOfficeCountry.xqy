let $fid := xs:string(xdmp:get-request-field("fid"))
let $legalEntity := cts:search(fn:collection('source-trusted')/legalEntity,
        cts:and-query((
            cts:element-attribute-range-query(xs:QName("legalEntity"), xs:QName("fid"), "=", $fid)
        )))

let $offices := (for $x in cts:search(fn:collection('source-trusted')/office,
        cts:and-query((
            cts:path-range-query("/office/summary/institution/link/@href", "=", $legalEntity/@resource, "collation=http://marklogic.com/collation/")
        ))) order by  $x/locations/location[@primary="true"]/address/country/countrySortKey descending return $x) [1 to 25]

let $officeResults := (
    let $officeCountry := for $x in $offices
    return <name>{$x/@fid}{$x/locations/location[@primary="true"]/address/country/name/text()}</name>
    return $officeCountry)

return <offices>{$officeResults}</offices>