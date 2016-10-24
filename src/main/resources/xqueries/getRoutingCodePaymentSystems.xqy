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

let $routingCodeValue := xs:string(xdmp:get-request-field("routingCode"))
let $routingCodeTypeValue := xs:string(xdmp:get-request-field("routingCodeType"))
let $source := xs:string(xdmp:get-request-field("source"))

let $routingDoc:= (collection('current')/routingCode[@source=$source][codeValue = $routingCodeValue and codeType=$routingCodeTypeValue])
let $paymentSystemValues:=
    for $p in $routingDoc/paymentSystems/paymentSystem
    let $productvalue1 :=if(fn:exists($p/product/link))
    then collection('current')/product[@source="trusted"][@resource=$p/product/link/@href]/summary/names/name[type='Full Name']/value
    else $p/product/name/value
    let $dateJoined := <dateJoined>{local:getDateAsPerAccuracy($p/dateBegan)}</dateJoined>
    let $dateLeft := <dateLeft>{local:getDateAsPerAccuracy($p/dateEnded)}</dateLeft>
    let $AlternateFormType := $p/useCodeForm
    let $MembershipType := $p/codeSystemMembership
    let $SystemActivityStatus := $p/codeSystemStatus
    let $RouteViaLink := $p/routeVia/link/@href
    let $RouteVia:=collection('current')/routingCode[@source="trusted"][@resource=$RouteViaLink]/codeValue/text()
    let $PaymentSystemAttributes := for $x in $p/attributes/attribute
    return <PaymentSystemAttribute>{$x/name/text()}{$x/value/text()}</PaymentSystemAttribute>
    let $PaymentSystemContactLocations := for $x in $p/contactLocations/contactLocation
    return <ContactLocations><ContactLocationType>{$x/type/text()}</ContactLocationType><ContactOffice>{collection("current")/office[@resource=$x/presence/link/@href][@source="trusted"]/summary/names/name[type="Office Name"]/value/text()}{collection("current")/office[@resource=$x/presence/link/@href][@source="trusted"]/locations/location[@primary="true"]/address[type="physical"]/city/name/text()}</ContactOffice>
        <ContactLocationsSpecialInstructions>{$x/specialInstructions/text()}</ContactLocationsSpecialInstructions></ContactLocations>
    let $Correspondent := for $x in $p/correspondents/correspondent
    return collection('current')/routingCode[@source="trusted"][@resource=collection('current')/ssi[@source="trusted"][@resource=$x/link/@href]/route/clearer/routingCodes/routingCode/link/@href]/codeValue
    return  <paymentSystem>
        <productName>{$productvalue1/text()}</productName>
        {$dateJoined}
        {$dateLeft}
        {$AlternateFormType}
        {$MembershipType}
        {$SystemActivityStatus}
        <routeVia>{$RouteVia}</routeVia>
        <correspondents>{$Correspondent}</correspondents>
        {$PaymentSystemAttributes}
        {$PaymentSystemContactLocations}
    </paymentSystem>
return <paymentSystemValues>{$paymentSystemValues}</paymentSystemValues>
