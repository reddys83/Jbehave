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

let $countryName := xs:string(xdmp:get-request-field("name"))
let $source := xs:string(xdmp:get-request-field("source"))

let $countryDoc := collection('current')/country[@source=$source][summary/names/name[value = $countryName]]
let $countryDetails := for $x in $countryDoc

let $ISO2 := $x/summary/iso2/text()
let $ISO3 :=$x/summary/iso3/text()
let $Status :=$x/summary/status/text()
let $BeginDate :=local:getDateAsPerAccuracy($x/summary/dates/dateBegan)
let $EndDate :=local:getDateAsPerAccuracy($x/summary/dates/dateCeased)

let $ReplacedBy := for $y in $x/summary/redirectTo/place/link/@href
order by fn:doc($y || '_CURR_SRC~trusted')//summary/names/name[type="Country Name"]/value/text()
return  string-join(fn:doc($y || '_CURR_SRC~trusted')//summary/names/name[type="Country Name"]/value/text())

let $AddInfo :=$x/summary/additionalInfos/additionalInfo/text()

let $Imports :=$x/summary/primaryImports/text()
let $Exports :=$x/summary/primaryExports/text()
let $PoliticalStructure :=$x/summary/politicalStructure/text()
let $IntlDialingCode:=$x/summary/telephoneCode/text()
let $DomesticWith := for $x in /country[@source='trusted'][@resource = $x/summary/domesticWith/place/link/@href]/summary/names/name[type= "Country Name"]/value order by $x return $x


return
    <country>
        <ISO2>{$ISO2}</ISO2>
        <ISO3>{$ISO3}</ISO3>
        <Status>{$Status}</Status>
        <BeginDate>{$BeginDate}</BeginDate>
        <EndDate>{$EndDate}</EndDate>
        <ReplacedBy>{$ReplacedBy}</ReplacedBy>
        <AddInfo>{$AddInfo}</AddInfo>
        <DomesticWith>{$DomesticWith}</DomesticWith>
        <Imports>{$Imports}</Imports>
        <Exports>{$Exports}</Exports>
        <PoliticalStructure>{$PoliticalStructure}</PoliticalStructure>
        <IntlDialingCode>{$IntlDialingCode}</IntlDialingCode>


    </country>

return $countryDetails

