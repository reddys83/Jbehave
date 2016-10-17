let $routingCodeValue := xs:string(xdmp:get-request-field("routingCode"))
let $routingCodeType := xs:string(xdmp:get-request-field("routingCodeType"))
let $status := xs:string(xdmp:get-request-field("status"))
let $routingCodeDoc := for $x in /routingCode[@source = "trusted"] where $x/codeValue = $routingCodeValue and $x/codeType=$routingCodeType
return $x
return xdmp:node-replace(($routingCodeDoc/codeStatus) ,<codeStatus>{$status}</codeStatus>)
