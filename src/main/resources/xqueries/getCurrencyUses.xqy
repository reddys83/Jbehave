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

let $currency := xs:string(xdmp:get-request-field("currency"))
let $currencyUses := collection('source-trusted')/currency[name = $currency]/uses/use
let $currencyUse := for $x in $currencyUses
let $countryName := collection('source-trusted')/country[@resource = $x/place/link/@href]/summary/names/name[type = "Country Name"]/value/text()

(: let $startDate := fn:concat(functx:day-abbrev-en(xs:date($x/startDate)), ' ', functx:month-abbrev-en(xs:date($x/startDate)), ' ', year-from-date(xs:date($x/startDate))) :)

let $startDateAccuracy := xs:string($x/startDate/@accuracy)
let $startDate := switch($startDateAccuracy)
        			case "day"   return fn:concat(functx:day-abbrev-en(xs:date($x/startDate)), ' ', functx:month-abbrev-en(xs:date($x/startDate)), ' ', year-from-date(xs:date($x/startDate))) 
        			case "month" return fn:concat(functx:month-abbrev-en(xs:date($x/startDate)), ' ', year-from-date(xs:date($x/startDate))) 
        			case "year"  return xs:string(year-from-date(xs:date($x/startDate)))
        			default return ""
        			
(: let $endDate := fn:concat(functx:day-abbrev-en(xs:date($x/endDate)), ' ', functx:month-abbrev-en(xs:date($x/endDate)), ' ', year-from-date(xs:date($x/endDate))) :)

let $endDateAccuracy := xs:string($x/endDate/@accuracy)
let $endDate := switch($endDateAccuracy)
        			case "day"   return fn:concat(functx:day-abbrev-en(xs:date($x/endDate)), ' ', functx:month-abbrev-en(xs:date($x/endDate)), ' ', year-from-date(xs:date($x/endDate))) 
        			case "month" return fn:concat(functx:month-abbrev-en(xs:date($x/endDate)), ' ', year-from-date(xs:date($x/endDate))) 
        			case "year"  return xs:string(year-from-date(xs:date($x/endDate)))
        			default return ""

let $primary := $x/primary
let $replacedBy := collection('source-trusted')/currency[@resource = $x/replacedBy/link/@href]/isoCode/text()
let $status := $x/status
order by $status, $countryName
return <currencyUse>
    <countryName>{$countryName}</countryName>
    <startDate>{$startDate}</startDate>
    <endDate>{$endDate}</endDate>
    {$primary}
    <replacedBy>{$replacedBy}</replacedBy>
    {$status}
</currencyUse>

return <currencyUses>{$currencyUse}</currencyUses>
