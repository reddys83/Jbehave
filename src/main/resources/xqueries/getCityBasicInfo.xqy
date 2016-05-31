let $country := xs:string(xdmp:get-request-field("country"))
let $area := xs:string(xdmp:get-request-field("area"))
let $city := xs:string(xdmp:get-request-field("city"))
let $source := xs:string(xdmp:get-request-field("source")) 


let $country := /country[@source = 'trusted'][summary/names/name[type = "Country Name"]/value = $country]
let $area := /area[@source = 'trusted'][summary/names/name[type = "Full Name"]/value = $area][within/place/link/@href=$country/@resource]
let $city := /city[@source = $source][summary/names/name[type = "Full Name"]/value = $city][within/place/link/@href=$area/@resource]  
  
let $cityIdentifierList := for $x in ($city/summary/identifiers/identifier)
  let $cityIdentifierType := $x/type/text()
  let $cityIdentifierValue := ($x/value/text())
  let $cityIdentifierStatus := ($x/status/text())
return 
  <identifier>
  <type>{$cityIdentifierType} </type>
  <value>{$cityIdentifierValue} </value>
  <identifierStatus>{$cityIdentifierStatus} </identifierStatus>
  </identifier>



let $cityStatus := ($city/summary/status/text())
let $cityadditionalinfo := ($city/summary/additionalInfos/additionalInfo/text())
let $cityPopulation := ($city/summary/demographics/metric/value/text())
return

<city>
<status>{$cityStatus}</status>
<identifiers>
 {$cityIdentifierList}
</identifiers> 
<additionalinfo>{$cityadditionalinfo}</additionalinfo>
<population>{$cityPopulation}</population>
</city>
 