let $country := xs:string(xdmp:get-request-field("country"))
let $area := xs:string(xdmp:get-request-field("area"))
let $source := xs:string(xdmp:get-request-field("source"))

let $countryDoc := /country[@source = 'trusted'][summary/names/name[type = "Country Name"]/value = $country]
let $areaDoc := /area[@source = $source][summary/names/name[type = "Full Name"]/value = $area][within/place/link/@href=$countryDoc/@resource]

(: Taking Area Region List :)
   
let $areaRegionList := for $x in ($area/alternativeRegions/region)
let $areaRegionType := $x/type/text()
let $areaRegionValue := ($x/value/text())

return 
  <region>
	<type>{$areaRegionType}</type>
    <value>{$areaRegionValue}</value>
  </region>
  
return
 <area>
	<regions>{$areaRegionList}</regions>
 </area>