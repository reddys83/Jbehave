let $routingCode := xs:string(xdmp:get-request-field("routingCode"))
let $routingCodeType := xs:string(xdmp:get-request-field("routingCodeType"))
let $routingCodeId := collection('current')/routingCode[@source='trusted' and codeValue= $routingCode and codeType = $routingCodeType]/@resource
let $routingCodeDoc := fn:concat($routingCodeId,"_CURR_SRC~trusted") 

return xdmp:node-delete((doc($routingCodeDoc)/routingCode/formerUsageLocations))