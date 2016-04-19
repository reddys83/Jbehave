let $fid := xs:string(xdmp:get-request-field("26065"))
let $legalEntity:= (/legalEntity[@fid="26065"][@source='trusted'])
let $summaries := for $x in $legalEntity/locations/summaries/summary
let $summaryType := $x/@type/string()
let $summaryValue := $x/text()
return <summaries><summary>
    <summaryType>{$summaryType}</summaryType>
    <summaryValue>{$summaryValue}</summaryValue>
</summary></summaries>
return $summaries