let $currency := xs:string(xdmp:get-request-field("name"))

for $x in collection('current')/currency[@source='zeus']
where $x/name=$currency
return <currency>
{$x/@resource}
</currency>