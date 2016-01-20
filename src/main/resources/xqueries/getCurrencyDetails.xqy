let $currency := xs:string(xdmp:get-request-field("name"))

for $x in collection('source-trusted')/currency
where $x/name=$currency
return <currency>
    <ISO>{$x/isoCode/text()}</ISO>
    <Abbr>{$x/symbol/text()}</Abbr>
    <Name>{$x/name/text()}</Name>
    <Unit>{$x/subUnits/subUnit/name/text()}</Unit>
    <Quantity>{$x/subUnits/subUnit/quantity/text()}</Quantity>
</currency>
