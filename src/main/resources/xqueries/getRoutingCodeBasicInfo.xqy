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

let $country := xs:string(xdmp:get-request-field("country"))
let $routingCodeValue := xs:string(xdmp:get-request-field("routingCode"))
let $routingCodeTypeValue := xs:string(xdmp:get-request-field("routingCodeType"))
let $source := xs:string(xdmp:get-request-field("source"))
let $routingCodeDoc := for $x in /routingCode[@source = "trusted"] where $x/codeValue ='083905216' and $x/codeType='ABA'
return $x

let $DateFields :=
    <Dates>
        <StartDate>{local:getDateAsPerAccuracy($routingCodeDoc/dates/validFrom)}</StartDate>
        <EndDate>{local:getDateAsPerAccuracy($routingCodeDoc/dates/validTo)}</EndDate>
        <ForthcomingRetirementDate>{local:getDateAsPerAccuracy($routingCodeDoc/dates/retireAt)}</ForthcomingRetirementDate>
        <ConfirmedWithFedDate>{local:getDateAsPerAccuracy($routingCodeDoc/dates/confirmed)}</ConfirmedWithFedDate>
    </Dates>




let $routingcodeType := ($routingCodeDoc/codeType/text())
let $routingcodeDescription := ($routingCodeDoc/codeTypeDescription/text())
let $routingcodeSubtype := ($routingCodeDoc/codeSubtype/text())
let $ABACodeSource := ($routingCodeDoc/codeSource/text())
let $routingcodeValue := ($routingCodeDoc/codeValue/text())
let $routingcodeCheckDigit := ($routingCodeDoc/codeCheckDigit/text())
let $alternateCodeFormType := for $x in $routingCodeDoc/codeAlternateForms/codeAlternateForm
return <alternateCodeFormType>{$x/@type/string()}</alternateCodeFormType>
let $alternateCodeForm := for $x in $routingCodeDoc/codeAlternateForms/codeAlternateForm
return <alternateCodeForm>{$x/text()}</alternateCodeForm>
let $routingcodeStatus := ($routingCodeDoc/codeStatus/text())
let $routingcodeaccountEligibility := ($routingCodeDoc/accountEligible/text())
let $routingcodeassignedInstitutionName := ($routingCodeDoc/assignedInstitution/legalName/text())
let $routingcodeComment := ($routingCodeDoc/comment/text())
let $routingcodeRegistrarFeeSFDCSubscription := ($routingCodeDoc/subscriptionNumber/text())
let $routingcodeInternalUseOnly := ($routingCodeDoc/internalUseOnly/text())
let $routingcodeUseHeadOffice := ($routingCodeDoc/internalUseOnly/@useHeadOffice/string())


return
    <routingcode>
        <routingcodeType>{$routingcodeType}</routingcodeType>
        <routingcodeDescription>{$routingcodeDescription}</routingcodeDescription>
        <routingcodeSubtype>{$routingcodeSubtype}</routingcodeSubtype>
        <ABACodeSource>{$ABACodeSource}</ABACodeSource>
        <routingcodeValue> {$routingcodeValue}</routingcodeValue>
        <routingcodeCheckDigit>{$routingcodeCheckDigit}</routingcodeCheckDigit>
        <alternateCodeFormTypes>{$alternateCodeFormType}</alternateCodeFormTypes>
        <alternateCodeForms>{$alternateCodeForm}</alternateCodeForms>
        <routingcodeStatus>{$routingcodeStatus}</routingcodeStatus>
        <routingcodeaccountEligibility>{$routingcodeaccountEligibility}</routingcodeaccountEligibility>
        <routingcodeassignedInstitutionName>{$routingcodeassignedInstitutionName}</routingcodeassignedInstitutionName>
        <routingcodeComment>{$routingcodeComment}</routingcodeComment>
        <routingcodeRegistrarFeeSFDCSubscription>{$routingcodeRegistrarFeeSFDCSubscription}</routingcodeRegistrarFeeSFDCSubscription>
        <routingcodeInternalUseOnly>{$routingcodeInternalUseOnly}</routingcodeInternalUseOnly>
        <routingcodeUseHeadOffice>{$routingcodeUseHeadOffice}</routingcodeUseHeadOffice>{$DateFields}
    </routingcode>