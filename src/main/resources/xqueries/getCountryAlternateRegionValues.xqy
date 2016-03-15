let $values1 := xs:string(xdmp:get-request-field("regionType"))
let $countryAlternativeRegion := collection("source-trusted")/lookup[@fid=$values1]/lookupBody/entry/@id/string()
let $types := for $x in $countryAlternativeRegion
order by $x
return <value>{$x}</value>
return <values><value></value>{$types}</values>