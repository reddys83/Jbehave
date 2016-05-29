let $country := xs:string(xdmp:get-request-field("country"))
let $area := xs:string(xdmp:get-request-field("area"))
let $city := xs:string(xdmp:get-request-field("city"))
let $source := xs:string(xdmp:get-request-field("source")) 


let $country := /country[@source = $source][summary/names/name[type = "Country Name"]/value = $country]
let $area := /area[@source = $source][summary/names/name[type = "Full Name"]/value = $area][within/place/link/@href=$country/@resource]
let $city := /city[@source = $source][summary/names/name[type = "Full Name"]/value = $city][within/place/link/@href=$area/@resource]

let $cityStatus := ($city/summary/status/text())
let $cityIdentifier := ($city/summary/identifiers/identifier)
let $cityadditionalinfo := ($city/summary/additionalInfos/additionalInfo/text())
let $cityPopulation := ($city/summary/demographics/metric/value/text())
return

<city>
<status>{$cityStatus}</status>
<identifier>{$cityIdentifier}</identifier> 
<additionalinfo>{$cityadditionalinfo}</additionalinfo>
<population>{$cityPopulation}</population>
</city>
 