declare namespace functx = "http://www.functx.com";
declare function functx:capitalize-first
( $arg as xs:string? )  as xs:string? {

    concat(upper-case(substring($arg,1,1)),
            substring($arg,2))
} ;

declare variable $getHeadOffice := function($routing as element()) {
    let $headOffice :=cts:search(fn:collection('current')/office[@source='fdb'],
            cts:and-query((
                cts:path-range-query("/office/summary/institution/link/@href", "=", $routing/assignedInstitution/link/@href, "collation=http://marklogic.com/collation/"),
                cts:path-range-query("/office/summary/types/type", "=","Head Office", "collation=http://marklogic.com/collation//S1"
                ))))

    return $headOffice
};




let $rc :=  xs:string(xdmp:get-request-field('code'))
let $rcWildCard  := fn:concat($rc, '*')


let $routingCodes:= (for $x in cts:search(fn:collection('source-trusted')/routingCode,
        cts:element-word-query(xs:QName("codeValue"),$rcWildCard,("wildcarded","case-insensitive"))) return $x)
let $routingCodeResults:= (
    for $x in $routingCodes

    let $Code := fn:data($x/codeValue/text())

    let $Type := fn:data($x/codeType/text())

    let $Status := fn:data(functx:capitalize-first($x/codeStatus/text()))

    let $Entity := if(exists($x/assignedInstitution/link))
    then (doc($x/assignedInstitution/link/@href || '_CURR_SRC~trusted')//summary/names/name[type='Legal Title']/value/text())
    else($x/assignedInstitution/legalName/text())

    let $OFID :=  for $y in $x/usageLocations/usageLocation
    return if($y/@primaryAssignee='true')
    then fn:doc($y/presence/link/@href || '_CURR_SRC~fdb')/office/@fid/string()
    else()

    let $FID := if(exists($OFID))
    then $OFID
    else fn:doc($x/assignedInstitution/link/@href || '_CURR_SRC~fdb')/legalEntity/@fid/string()

    let $OAddress := for $y in $x/usageLocations/usageLocation
    return if($y/@primaryAssignee='true')
    then fn:doc($y/presence/link/@href || '_CURR_SRC~fdb')/office/locations/location[@primary="true"]/address[type='physical']/streetAddress/addressLine1/text()
    else()

    let $Address := if(exists($OAddress))
    then $OAddress
    else let $headOffice := $getHeadOffice($x)
        return $headOffice/locations/location[@primary="true"]/address[type='physical']/streetAddress/addressLine1/text()

    let $City :=  let $officeusageLocation := for $y in $x/usageLocations/usageLocation[@primaryAssignee='true'] return $y

    let $officeHrefs := for $z in $officeusageLocation/presence/link/@href return $z


    let $cityHrefs := cts:search(fn:collection('current')/office[@source="fdb"],
            cts:and-query((
                cts:element-attribute-range-query(xs:QName("office"),xs:QName("resource"), "=", $officeHrefs)
            ))
    )/locations/location[@primary="true"]/address[type='physical']/city/link/@href

    let $OcityName := cts:search(fn:collection('current')/city[@source="fdb"],
            cts:element-attribute-range-query(xs:QName("city"),xs:QName("resource"), "=", $cityHrefs)
    )/summary/names/name[type="Full Name"]/value

    return if(exists($OcityName))
    then $OcityName/text()
    else(let $HeadOfficeCityHrefs := $getHeadOffice($x)/locations/location[@primary="true"]/address[type='physical']/city/link/@href/string()
        let $HeadOfficeCityName := cts:search(fn:collection('current')/city[@source="fdb"],
                cts:element-attribute-range-query(xs:QName("city"),xs:QName("resource"), "=", $HeadOfficeCityHrefs)
        )/summary/names/name[type="Full Name"]/value
        return $HeadOfficeCityName/text())


    let $Area  :=  let $officeHrefs := for $y in $x/usageLocations/usageLocation[@primaryAssignee='true']/presence/link/@href return $y

    let $areaHrefs := cts:search(fn:collection('current')/office[@source="fdb"],
            cts:and-query((
                cts:element-attribute-range-query(xs:QName("office"),xs:QName("resource"), "=", $officeHrefs)
            ))
    )/locations/location[@primary="true"]/address[type='physical']/area/link/@href

    let $OareaName := cts:search(fn:collection('current')/area[@source="fdb"],
            cts:element-attribute-range-query(xs:QName("area"),xs:QName("resource"), "=", $areaHrefs)
    )/summary/names/name[type="Full Name"]/value

    return if(exists($OareaName))
    then $OareaName/text()
    else(let $HeadOfficeAreaHrefs := $getHeadOffice($x)/locations/location[@primary="true"]/address[type='physical']/area/link/@href/string()
        let $HeadOfficeAreaName := cts:search(fn:collection('current')/area[@source="fdb"],
                cts:element-attribute-range-query(xs:QName("area"),xs:QName("resource"), "=", $HeadOfficeAreaHrefs)
        )/summary/names/name[type="Full Name"]/value
        return $HeadOfficeAreaName/text())

    let $Country :=  let $officeHrefs := for $y in $x/usageLocations/usageLocation[@primaryAssignee='true']/presence/link/@href return $y

    let $countryHrefs := cts:search(fn:collection('current')/office[@source="fdb"],
            cts:and-query((
                cts:element-attribute-range-query(xs:QName("office"),xs:QName("resource"), "=", $officeHrefs)
            ))
    )/locations/location[@primary="true"]/address[type='physical']/country/link/@href

    let $OCountryName := cts:search(fn:collection('current')/country[@source="fdb"],
            cts:element-attribute-range-query(xs:QName("country"),xs:QName("resource"), "=", $countryHrefs)
    )/summary/names/name[type="Country Name"]/value

    return if(exists($OCountryName))
    then $OCountryName/text()
    else(let $HeadOfficeCountryHrefs := $getHeadOffice($x)/locations/location[@primary="true"]/address[type='physical']/country/link/@href/string()
        let $HeadOfficeCountryName := cts:search(fn:collection('current')/country[@source="fdb"],
                cts:element-attribute-range-query(xs:QName("country"),xs:QName("resource"), "=", $HeadOfficeCountryHrefs)
        )/summary/names/name[type="Country Name"]/value
        return $HeadOfficeCountryName/text())

    order by $x/codeValue ascending
    return <results>
        <Code>{$Code}</Code>
        <Type>{$Type}</Type>
        <Entity>{$Entity}</Entity>
        <FID>{$FID}</FID>
        <Address>{$Address}</Address>
        <City>{$City}</City>
        <Area>{$Area}</Area>
        <Country>{$Country}</Country>
        <Status>{$Status}</Status>
    </results>)[1 to 25]
return <codeResults>{$routingCodeResults}</codeResults>




