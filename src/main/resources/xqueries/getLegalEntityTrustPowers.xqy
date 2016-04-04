let $fid := xs:string(xdmp:get-request-field("fid"))
for $x in collection('current')/legalEntity[@source="trusted"]
where $x/@fid = "73788"
return $x/summary/trust