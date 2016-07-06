declare namespace functx = "http://www.functx.com";
declare function functx:month-abbrev-en
( $date as xs:anyAtomicType? )  as xs:string? {

    ('Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec')
    [month-from-date(xs:date($date))]
} ;

declare function functx:day-abbrev-en
( $date as xs:anyAtomicType? )  as xs:string? {
    ('1', '2', '3', '4', '5', '6', '7', '8', '9', '10', '11', '12', '13', '14', '15', '16', '17', '18', '19', '20', '21', '22', '23', '24', '25', '26', '27', '28', '29', '30', '31')
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
let $legalEntityS := (/legalEntity[@fid=$fid][@source=$source])


let $legalEntityCreditRatings:=for $CR in $legalEntityS/creditRatings/rating
let $agencyName := ($CR/agencyName)
let $type := ($CR/type)
let $value := ($CR/value)
let $dateApplied := <dateApplied>{local:getDateAsPerAccuracy($CR/dateApplied)}</dateApplied>
let $dateConfirmed:= if(fn:exists(local:getDateAsPerAccuracy($CR/dateConfirmed)))
then <dateConfirmed>{local:getDateAsPerAccuracy($CR/dateConfirmed)}</dateConfirmed>
else <dateConfirmed>null</dateConfirmed>

return
let $legalEntityCR:=$legalEntityS/creditRatings/rating
return <legalEntityCR>{$agencyName}{$type}{$value}{$dateApplied}{$dateConfirmed}</legalEntityCR>

return <legalEntityCRs>{$legalEntityCreditRatings}</legalEntityCRs>