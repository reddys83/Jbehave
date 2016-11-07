let $routingCode := xs:string(xdmp:get-request-field("routingCode"))
let $routingCodeType := xs:string(xdmp:get-request-field("routingCodeType"))
let $routingCodeId := collection('current')/routingCode[@source='trusted' and codeValue= $routingCode and codeType = $routingCodeType]/@resource
let $routingCodeDoc := fn:concat($routingCodeId,"_CURR_SRC~trusted")

return xdmp:node-insert-child(doc($routingCodeDoc)/routingCode,
<formerUsageLocations>
  <formerUsageLocation>
    <presence> <link href="/office/id/876923d5-6176-400d-8fbd-ed35ef58b355" rel="src"> </link> </presence>
    <department> <link href="/department/id/8a9cef7e-e8c3-4462-b650-0fa587253b6d" rel="src"> </link> </department>
  </formerUsageLocation>
</formerUsageLocations>)