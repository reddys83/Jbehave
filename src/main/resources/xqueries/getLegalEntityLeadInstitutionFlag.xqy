let $fid := xs:string(xdmp:get-request-field("fid"))
let $source := xs:string(xdmp:get-request-field("source"))
for $x in collection('current')/legalEntity[@source=$source]
where $x/@fid = $fid
return $x/summary/leadInstitution