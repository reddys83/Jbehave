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

let $currency := xs:string(xdmp:get-request-field("name"))
let $source := xs:string(xdmp:get-request-field("source"))

(:let $currency := "Afghani-test-2":)
(:let $source := "zeus":)

let $currencyUses := collection('current')/currency[@source=$source][name = $currency]/uses/use
let $currencyUse := for $x in $currencyUses
let $countryName := collection('source-trusted')/country[@resource = $x/place/link/@href]/summary/names/name[type = "Country Name"]/value/text()
let $startDate := local:getDateAsPerAccuracy($x/startDate)
let $endDate := local:getDateAsPerAccuracy($x/endDate)
let $primary :=  $x/primary
let $replacedBy := collection('source-trusted')/currency[@resource = $x/replacedBy/link/@href]
let $status := $x/status
order by $status, $countryName
return <currencyUse>
    <countryName>{$countryName}</countryName>
    <startDate>{$x/startDate/@accuracy}{$startDate}</startDate>
    <endDate>{$x/endDate/@accuracy}{$endDate}</endDate>
    {$primary}
    <replacedByISO>{$replacedBy/isoCode/text()}</replacedByISO>
    <replacedByName>{$replacedBy/name/text()}</replacedByName>
    {$status}
</currencyUse>

return <currencyUses>{$currencyUse}</currencyUses>
