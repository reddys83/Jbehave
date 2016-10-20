let $routingCode := xs:string(xdmp:get-request-field("routingCode"))
let $routingCodeType := xs:string(xdmp:get-request-field("routingCodeType"))
let $source := xs:string(xdmp:get-request-field("source"))

for $x in (collection('current')/routingCode[@source = $source][codeValue = $routingCode and codeType = $routingCodeType])
return <documentIdwithEndpoint>
    {$x/@resource}
</documentIdwithEndpoint>