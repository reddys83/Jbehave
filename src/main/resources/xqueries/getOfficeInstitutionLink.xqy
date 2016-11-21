let $officeFid :=  xs:string(xdmp:get-request-field("officeFid"))
let $source := xs:string(xdmp:get-request-field("source"))

let $officeInstitutionLink := collection('current')/office[@source=$source and @fid=$officeFid]/summary/institution/link/@href/string()

return
<officeInstitution>{$officeInstitutionLink}</officeInstitution>