let $country := xs:string(xdmp:get-request-field("name"))
let $source :=  xs:string(xdmp:get-request-field("source"))

for $x in collection('current')/country[@source=$source]
where $x/summary/names/name/value=$country
return <country>
    <ISO2>{$x/summary/iso2/text()}</ISO2>
    <ISO3>{$x/summary/iso3/text()}</ISO3>
    <Status>{$x/summary/status/text()}</Status>
    <BeginDate>{$x/summary/dates/dateBegan/text()}</BeginDate>
    <EndDate>{$x/summary/dates/dateCeased/text()}</EndDate>
    <ReplacedBy>{$x/summary/redirectTo/place/link/text()}</ReplacedBy>
    <AddInfo>{$x/summary/additionalInfos/additionalInfo/text()}</AddInfo>
    <Imports>{$x/summary/primaryImports/text()}</Imports>
    <Exports>{$x/summary/primaryExports/text()}</Exports>
    <PoliticalStructure>{$x/summary/politicalStructure/text()}</PoliticalStructure>
    <IntlDialingCode>{$x/summary/telephoneCode/text()}</IntlDialingCode>
</country>