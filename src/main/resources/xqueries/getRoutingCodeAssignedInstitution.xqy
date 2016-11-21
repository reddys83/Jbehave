let $routingCode :=  xs:string(xdmp:get-request-field("routingCode"))
let $routingCodeType := xs:string(xdmp:get-request-field("routingCodeType"))
let $source := xs:string(xdmp:get-request-field("source"))

let $assignedInstitutionLink:=(collection('current')/routingCode[@source=$source and codeValue=$routingCode and codeType=$routingCodeType])/assignedInstitution/link/@href/string()

return <assignedInstitutionLink>{$assignedInstitutionLink}</assignedInstitutionLink>