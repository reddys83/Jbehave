let $country := xs:string(xdmp:get-request-field("country"))
let $area := xs:string(xdmp:get-request-field("area"))
let $subarea := xs:string(xdmp:get-request-field("subarea"))
let $source := xs:string(xdmp:get-request-field("source"))


let $countryDoc := /country[@source = $source][summary/names/name[type = "Country Name"]/value = $country]
let $areaDoc := /area[@source = $source][summary/names/name[type = "Full Name"]/value = $area][within/place/link/@href=$countryDoc/@resource]
let $subareaDoc := /area[@source = $source][summary/names/name[type = "Full Name"]/value = $subarea][within/place/link/@href=$areaDoc/@resource]


(:Get subarea documentID:)
return 
      <documentIdwithEndpoint>{$subareaDoc/@resource}</documentIdwithEndpoint>  
  


