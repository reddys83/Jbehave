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
let $legalEntityS := (/legalEntity[@fid=$fid][@source=$source])

let $status := ($legalEntityS/summary/status/text())
let $claimedEstDate := local:getDateAsPerAccuracy($legalEntityS/summary/dates/established)
let $characteredDate := local:getDateAsPerAccuracy($legalEntityS/summary/dates/chartered)
let $charterType := ($legalEntityS/summary/charterType)
let $insuranceType := ($legalEntityS/summary/insuranceType)
let $ownershipType := ($legalEntityS/summary/organisationType)
let $leadInstitution :=($legalEntityS/summary/leadInstitution)
let $countryOfOperation := ($legalEntityS/summary/countryOfOperations/link/@href)
let $countryDoc := (/country[@source='trusted'])[@resource/string()= $countryOfOperation]
let $countryName := ($countryDoc/summary/names/name[type='Country Name']/value)
let $fatcaStatus := ($legalEntityS/summary/fatcaStatus)
let $additionalinfo := ($legalEntityS/summary/additionalInfos/additionalInfo)
let $headOffice := ($legalEntityS/locations/headOffice/link/@href)
let $officeDoc := (/office[@source='trusted'][@resource=$headOffice])
let $officeAddress := ($officeDoc/locations/location[@primary='true']/address[type='physical'])
let $addressLine1 := ($officeAddress/streetAddress/addressLine1)
let $postalCode := ($officeAddress/postalCode)


return <legalEntity>
    <status>{$status}</status>
    <claimedEstDate>{$claimedEstDate}</claimedEstDate>
    <characteredDate>{$characteredDate}</characteredDate>
    <charterType>{$charterType}</charterType>
    <insuranceType>{$insuranceType}</insuranceType>
    <ownershipType>{$ownershipType}</ownershipType>
    <leadInstitution>{$leadInstitution}</leadInstitution>
    <countryOfOperation>{$countryName}</countryOfOperation>
    <fatcaStatus>{$fatcaStatus}</fatcaStatus>
    <additionalinfo>{$additionalinfo}</additionalinfo>
    <headOfficeaddressLine1>{$addressLine1}</headOfficeaddressLine1>
    <postalCode>{$postalCode}</postalCode>
</legalEntity>