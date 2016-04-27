let $legalEntityName := xs:string(xdmp:get-request-field("fid"))
let $source := xs:string(xdmp:get-request-field("source"))

let $legalEntityNames := /legalEntity[@source=$source][@fid=$legalEntityName]/summary/names/name
let $types := for $x in $legalEntityNames
return if(fn:exists($x[type !='Legal Title'])) then ($x)
else ()
return <names>{$types}</names>