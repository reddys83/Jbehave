let $country := xs:string(xdmp:get-request-field("country"))
let $area := xs:string(xdmp:get-request-field("area"))
let $source := xs:string(xdmp:get-request-field("source"))

let $countryDoc := /country[@source = $source][summary/names/name[type = "Country Name"]/value = $country]
let $areaDoc := /area[@source = $source][summary/names/name[type = "Full Name"]/value = $area][within/place/link/@href=$countryDoc/@resource]

(: status :)
   
let $areaStatus := ($areaDoc/summary/status/text()) 
return
<status>{$areaStatus}</status>