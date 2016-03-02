let $area := xs:string(xdmp:get-request-field("name"))
let $source := xs:string(xdmp:get-request-field("source"))
let $area := /area[@source = $source][summary/names/name[type = "Full Name"]/value = $area]
let $subarea := /area[@source = $source][within/place/link/@href=$area/@resource]
let $subAreaList := for $x in $subarea[summary[type= "subarea"]] order by $x/summary/names/name[type="Full Name"]/value return <subarea>{$x/summary/names/name[type="Full Name"]/value/text()}</subarea>
return <subareas>{$subAreaList}</subareas>