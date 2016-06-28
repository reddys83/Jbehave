let $name :=xs:string(xdmp:get-request-field("name"))
let $source :=xs:string(xdmp:get-request-field("source"))

for $x in collection('current')/area[@source = $source]
where $x/summary/names/name/value=$name
return <documentIdwithEndpoint>
    {$x/@resource}
</documentIdwithEndpoint> 