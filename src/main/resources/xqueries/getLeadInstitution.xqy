let $fid := xs:string(xdmp:get-request-field("fid"))
let $source := xs:string(xdmp:get-request-field("source"))
let $leadInstitution :=(/legalEntity[@fid=$fid][@source=$source]/summary/leadInstitution)
return $leadInstitution