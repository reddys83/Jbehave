let $country := xs:string(xdmp:get-request-field("name"))
let $source := xs:string(xdmp:get-request-field("source"))

(:let $country := "Qatar"
let $source := "trusted":)

let $countryDoc := collection("current")/country[@source=$source][summary/names/name[type = "Country Name"]/value = $country]
let $countryRoutingCode := $countryDoc/routingCodeTypes
let $countryPaymentInfo := for $x in $countryRoutingCode/routingCodeType/text()
return <code>{$x}</code>
return <routingCodes>{$countryPaymentInfo}</routingCodes>