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

let $country := xs:string(xdmp:get-request-field("name"))
let $source := xs:string(xdmp:get-request-field("source"))

(:let $country := "USA"
let $source := "zeus":)

let $countryDoc := collection("current")/country[@source=$source][summary/names/name[type = "Country Name"]/value = $country]
let $countryHolidays := $countryDoc/holidays/holiday
let $countryHolidaysList := for $x in $countryHolidays
  let $countryHolidayDate := local:getDateAsPerAccuracy($x/date)
  let $countryHolidayName := $x/name
  let $countryHolidayNote := $x/note
return <holiday><date>{$countryHolidayDate}</date>{$countryHolidayName}{$countryHolidayNote}</holiday>

return <holidays>{$countryHolidaysList}</holidays>

