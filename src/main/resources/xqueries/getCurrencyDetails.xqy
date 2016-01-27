let $currency := xs:string(xdmp:get-request-field("name"))
let $source := xs:string(xdmp:get-request-field("source"))

for $x in collection('current')/currency[@source=$source]
where $x/name=$currency
return <currency>
    <iso>{$x/isoCode/text()}</iso>
    <abbr>{$x/symbol/text()}</abbr>
    <name>{$x/name/text()}</name>
    <unit>{$x/subUnits/subUnit/name/text()}</unit>
    <quantity>{$x/subUnits/subUnit/quantity/text()}</quantity>
</currency>
