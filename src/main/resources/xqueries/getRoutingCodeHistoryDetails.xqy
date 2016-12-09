declare namespace functx = "http://www.functx.com";
declare function functx:month-abbrev-en
( $date as xs:anyAtomicType? )  as xs:string? {

    ('Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec')
    [month-from-date(xs:date($date))]
} ;

declare function functx:day-abbrev-en
( $date as xs:anyAtomicType? )  as xs:string? {
    ('01', '02', '03', '04', '05', '06', '07', '08', '09', '10', '11', '12', '13', '14', '15', '16', '17', '18', '19', '20', '21', '22', '23', '24', '25', '26', '27', '28', '29', '30', '31')
    [day-from-date(xs:date($date))]
} ;

declare function local:getDateAsPerAccuracy
( $date as node() ) {
    switch($date/@accuracy/string())
        case "day" return fn:concat(functx:day-abbrev-en(xs:date($date)), ' ', functx:month-abbrev-en(xs:date($date)), ' ', year-from-date(xs:date($date)))
        case "month" return fn:concat(functx:month-abbrev-en(xs:date($date)), ' ', year-from-date(xs:date($date)))
        case "year"  return year-from-date(xs:date($date))
        default return "date not valid"
};

declare variable $getReplacedBy := function($routing as element()) {
   let $replacedBy :=cts:search(fn:collection('current')/routingCode[@source='trusted'],
   cts:and-query((
   cts:element-attribute-range-query(xs:QName("routingCode"),xs:QName("resource"), "=", $routing/replacedBy/link/@href)
   )))                                      
   return $replacedBy
};

declare variable $getOffice := function($routing as element()) {
    let $Office :=cts:search(fn:collection('current')/office[@source='trusted'],
            cts:and-query((cts:element-attribute-range-query(xs:QName("office"),xs:QName("resource"), "=", $routing/presence/link/@href))))
    return $Office
};

let $rc := xs:string(xdmp:get-request-field("routingCode"))
let $rcType := xs:string(xdmp:get-request-field("routingCodeType"))
let $source := xs:string(xdmp:get-request-field("source"))

let $routingCodes:= (for $x in cts:search(fn:collection('current')/routingCode[@source=$source],
cts:and-query((
cts:path-range-query("/routingCode/codeValue","=",$rc, "collation=http://marklogic.com/collation//S1"),
cts:path-range-query("/routingCode/codeType", "=", $rcType, "collation=http://marklogic.com/collation//S1")
))) return $x)/codeHistory/codeEvent     

let $routingCodeHistory := for $x in $routingCodes  
let $type := $x/eventType/text()
let $date := local:getDateAsPerAccuracy($x/eventDate)
let $description := $x/eventDescription/text()
let $replacedBy := ($getReplacedBy($x))/codeValue/text()
let $details := (for $y in $x return $y)/historicUsageLocations/historicUsageLocation

let $offdetails := for $y in $details
let $name := $getOffice($y)/summary/names/name[type='Office Name']/value/text()
let $address := $y/presence/address/streetAddress/addressLine1/text()
let $city := $y/presence/address/city/displayName/text()
let $area := $y/presence/address/area/fullName/text()
let $subArea := $y/presence/address/subarea/displayName/text()
let $country := $y/presence/address/country/name/text()
let $postalCode := $y/presence/address/postalCode/text()
let $additionalInfo := $y/additionalInfo/text()

return 
<office>
  <name>{$name}</name>
  <address>{$address}</address>
  <city>{$city}</city>
  <area>{$area}</area>
  <subArea>{$subArea}</subArea>
  <country>{$country}</country>
  <postalCode>{$postalCode}</postalCode>
  <additionalInfo>{$additionalInfo}</additionalInfo>
</office>

return 
<historicFields>
<type>{$type}</type>
<date>{$date}</date>
<description>{$description}</description>
<replacedByCode>{$replacedBy}</replacedByCode>
<officeDetails>{$offdetails}</officeDetails>
</historicFields>

return <routingCode><routingCodeHistory>{$routingCodeHistory}</routingCodeHistory></routingCode>