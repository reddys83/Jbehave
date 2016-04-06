let $fid := xs:string(xdmp:get-request-field("fid"))
let $resourceLink := (/legalEntity[@fid=$fid][@source='trusted'])
let $resourceValue := <resource>{$resourceLink/@resource/string()}</resource>
let $relationshipDoc := (/relationship[@source='trusted'][status='active'][relationshipType='ownership'][parties/party[partyType="owned"]/entityReference/link/@href = $resourceValue])
let $loop := if (fn:exists ($relationshipDoc))
then $relationshipDoc
else ""

return $loop
