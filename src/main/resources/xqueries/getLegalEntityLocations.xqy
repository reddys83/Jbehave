let $legalEntityName := xs:string(xdmp:get-request-field("fid"))

let $legalEntityNames := /legalEntity[@source='zeus'][@fid=$legalEntityName]/locations/summaries/summary

let $legalEntityLocations := for $x in $legalEntityNames
let $type := for $y in $x return $y/@type/string()
let $value := for $y in $x return $y/text()
return <a><type>{$type}</type><value>{$value}</value></a>

return <location>{$legalEntityLocations}</location>