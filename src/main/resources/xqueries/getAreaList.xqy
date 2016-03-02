let $country := xs:string(xdmp:get-request-field("name"))
let $source := xs:string(xdmp:get-request-field("source"))

let $country := /country[@source = $source][summary/names/name[type = "Country Name"]/value = $country]
let $area := /area[@source = $source][within/place/link/@href=$country/@resource]
let $areaList := for $x in $area[summary[type= "area"]] order by $x/summary/names/name[type="Full Name"]/value return <area>{$x/summary/names/name[type="Full Name"]/value/text()}</area>
return <areas>{$areaList}</areas>