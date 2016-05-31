let $name :=xs:string(xdmp:get-request-field("name"))

for $x in collection('current')/city[@source='zeus']
where $x/summary/names/name/value=$name
return <documentIdwithEndpoint>
    {$x/@resource}
</documentIdwithEndpoint> 