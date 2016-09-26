declare function local:month-abbrev-en( $date as xs:anyAtomicType? )  as xs:string? {
    ('Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec')
    [month-from-date(xs:date($date))]
} ;

declare function local:day-abbrev-en( $date as xs:anyAtomicType? )  as xs:string? {
    ('01', '02', '03', '04', '05', '06', '07', '08', '09', '10', '11', '12', '13', '14', '15', '16', '17', '18', '19', '20', '21', '22', '23', '24', '25', '26', '27', '28', '29', '30', '31')
    [day-from-date(xs:date($date))]
} ;

declare function local:getDateAsPerAccuracy( $date as node() ) {
    switch($date/@accuracy/string())
        case "day" return fn:concat(local:day-abbrev-en(xs:date($date)), ' ', local:month-abbrev-en(xs:date($date)), ' ', year-from-date(xs:date($date)))
        case "month" return fn:concat(local:month-abbrev-en(xs:date($date)), ' ', year-from-date(xs:date($date)))
        case "year"  return year-from-date(xs:date($date))
        default return "date not valid"
};

let $routingCodeValue := "HLFXGB21K03"
let $codeType := "SWIFT BIC"
let $routingDoc:= (collection('current')/routingCode[@source="trusted"][codeValue = $routingCodeValue and codeType=$codeType])
let $paymentSystemValues:=
    for $p in $routingDoc/paymentSystems/paymentSystem
    let $productvalue1 := collection('current')/product[@source="trusted"][@resource=$p/product/link/@href]/summary/names/name[type='Full Name']/value
    let $dateJoined := <dateJoined>{local:getDateAsPerAccuracy($p/dateBegan)}</dateJoined>
    let $dateLeft := <dateLeft>{local:getDateAsPerAccuracy($p/dateEnded)}</dateLeft>
    let $AlternateFormType := $p/useCodeForm
    let $MembershipType := $p/codeSystemMembership
    let $SystemActivityStatus := $p/codeSystemStatus
    let $RouteViaLink := $p/routeVia/link/@href
    let $RouteVia:=collection('current')/routingCode[@source="trusted"][@resource=$RouteViaLink]/codeValue/text()
    let $Correspondent := for $x in $p/correspondents/correspondent
    return collection('current')/routingCode[@source="trusted"][@resource=collection('current')/ssi[@source="trusted"][@resource=$x/link/@href]/route/clearer/routingCodes/routingCode/link/@href]/codeValue
    return  <paymentSystem>
        {$productvalue1}
        {$dateJoined}
        {$dateLeft}
        {$AlternateFormType}
        {$MembershipType}
        {$SystemActivityStatus}
        <routeViaLink>{$RouteVia}</routeViaLink>
        <correspondentLink>{$Correspondent}</correspondentLink>
    </paymentSystem>
return <paymentSystemValues>{$paymentSystemValues}</paymentSystemValues>
