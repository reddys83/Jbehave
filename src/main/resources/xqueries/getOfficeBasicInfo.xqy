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

let $fid := xs:string(xdmp:get-request-field("fid"))
let $source := xs:string(xdmp:get-request-field("source"))
let $office := (/office[@fid="1010-44"][@source="zeus"])

let $officeSortName := ($office/summary/names/officeSortKey)
let $officeOpenedDate := local:getDateAsPerAccuracy($office/summary/dates/opened)
let $officeTypes := for $x in ($office/summary/names/name/type)
return <officeType>{$x/text()}</officeType>
let $officeValues := for $x in ($office/summary/names/name/value)
return <officeValue>{$x/text()}</officeValue>



return <office>
    <officeOpenedDate>{$officeOpenedDate}</officeOpenedDate>
    <officeTypes>{$officeTypes}</officeTypes>
    <officeValues>{$officeValues}</officeValues>
    <officeSortName>{$officeSortName}</officeSortName>
    </office>

    (:return $office:)