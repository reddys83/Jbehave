declare variable $getDepartment := function($routing as element()) {
    let $department :=cts:search(fn:collection('current')/department[@source='trusted'],
            cts:and-query((
                cts:element-attribute-range-query(xs:QName("department"),xs:QName("resource"), "=", $routing/department/link/@href)
            )))

    return $department
};

declare variable $getOffice := function($routing as element()) {
    let $Office :=cts:search(fn:collection('current')/office[@source='trusted'],
            cts:and-query((
                cts:element-attribute-range-query(xs:QName("office"),xs:QName("resource"), "=", $routing/presence/link/@href)
            )))

    return $Office
};



let $rc :=  xs:string(xdmp:get-request-field('code'))
let $rcType := xs:string(xdmp:get-request-field('codeType'))

let $routingCodes:= (for $x in cts:search(fn:collection('current')/routingCode[@source='trusted'],
        cts:and-query((
            cts:path-range-query("/routingCode/codeValue","=",$rc, "collation=http://marklogic.com/collation//S1"),
            cts:path-range-query("/routingCode/codeType", "=", $rcType, "collation=http://marklogic.com/collation//S1")
        ))) return $x)/usageLocations/usageLocation

let $usages:= (
    for $x in $routingCodes

    let $owned:= $x/@primaryAssignee/string()
    let $rank:= $x/@rankAtLocation/string()
    let $description := $x/description/text()
    let $addInfo:=$x/additionalInfo/text()


    let $name:= if(exists($x/department/link))

    then (string-join(($getDepartment($x)/summary/names/name[type='Department Name']/value/text(),$getOffice($x)/summary/names/name[type='Office Name']/value/text()),(',')))

    else $getOffice($x)/summary/names/name[type='Office Name']/value/text()

    let $City:= if((exists($x/department/link)) and (exists($getDepartment($x)/locations/location[@primary='true']/address[type='physical']/city/link)))
    then ($getDepartment($x)/locations/location[@primary='true']/address[type='physical']/city/name/text())

    else ($getOffice($x)/locations/location[@primary='true']/address[type='physical']/city/name/text())


    let $Area:= if((exists($x/department/link)) and (exists($getDepartment($x)/locations/location[@primary='true']/address[type='physical']/city/link)))
    then ($getDepartment($x)/locations/location[@primary='true']/address[type='physical']/area/name/text())

    else ($getOffice($x)/locations/location[@primary='true']/address[type='physical']/area/name/text())
    return <results>
        <owned>{$owned}</owned>
        <rank>{$rank}</rank>
        <name>{$name}</name>
        <city>{$City}</city>
        <area>{$Area}</area>
        <description>{$description}</description>
        <addInfo>{$addInfo}</addInfo>
    </results> )

let $primaryOwned := $usages[owned='true']
let $secondaryOwned := for $x in $usages where $x/owned != 'true' order by $x/name return $x
return <usages>
    {$primaryOwned}
    {$secondaryOwned}
</usages>


 
