let $countryName := xs:string(xdmp:get-request-field("country"))
let $countryDoc := /country[@source = "trusted"][summary/names/name[type = "Country Name"]/value = $countryName]
return $countryDoc/summary/postalCodePosition