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
  
 <formerUsageLocation>
    <presence> <link href="/office/id/4f3d318a-e1fe-4b1a-a73e-af5a084c69f7" rel="src"> </link> </presence>
    <department> <link href="/department/id/a9de4a11-fe8c-4123-a9a0-2e2d88312006" rel="src"> </link> </department>
  </formerUsageLocation>
  
   <formerUsageLocation>
    <presence> <link href="/office/id/657045be-e677-4e46-bcf4-d471a9b65c64" rel="src"> </link> </presence>
    <department> <link href="/department/id/a9de4a11-fe8c-4123-a9a0-2e2d88312006" rel="src"> </link> </department>
    <additionalInfo>testing comment</additionalInfo>
  </formerUsageLocation>
  
   <formerUsageLocation>
    <presence> <link href="/office/id/5cb1de4f-cd18-411f-9bf6-f404c90e8d89" rel="src"> </link> </presence>
    <department> <link href="/department/id/a9de4a11-fe8c-4123-a9a0-2e2d88312006" rel="src"> </link> </department>
    <additionalInfo>testing</additionalInfo>
  </formerUsageLocation>    
</formerUsageLocations>)
