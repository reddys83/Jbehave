let $fid := xs:string(xdmp:get-request-field("fid"))
let $source := xs:string(xdmp:get-request-field("source"))

let $legalEntityResource:= for $x in collection('current')/legalEntity[@source=$source]
where $x/@fid=$fid
return $x/@resource

let $financia:= for $x in collection('current')/financialStatement[@source=$source]
where $x/owner/link/@href=$legalEntityResource
order by $x/periodEnd descending
return <periodEnd>{$x/periodEnd/text()}</periodEnd>

return <financials>{$financia}</financials>