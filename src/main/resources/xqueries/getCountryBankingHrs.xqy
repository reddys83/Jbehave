let $country := xs:string(xdmp:get-request-field("name")) 
let $source := xs:string(xdmp:get-request-field("source"))

(:let $country := "Qatar"
let $source := "trusted":)

let $countryDoc := collection("current")/country[@source=$source][summary/names/name[type = "Country Name"]/value = $country]
let $countryBankingHrs := $countryDoc/summary/businessHours/day
let $countryBankingHrsDetails := for $x in $countryBankingHrs
  let $countryBankingHrsDay := $x/name
  let $countryBankingHrsStartHrs := tokenize($x/hours, '-')[1]
  let $countryBankingHrsEndHrs := tokenize($x/hours, '-')[2]
return <day>{$countryBankingHrsDay}<startTime>{$countryBankingHrsStartHrs}</startTime><endTime>{$countryBankingHrsEndHrs}</endTime></day>

return <days>{$countryBankingHrsDetails}</days>
