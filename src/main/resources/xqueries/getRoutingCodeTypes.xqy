let $countryNamesType := collection("source-trusted")/lookup[@fid="ROUTING_CODE_TYPE"]/lookupBody/entry/@id/string()
let $types := for $x in $countryNamesType
order by $x
return <type>{$x}</type>
return <types><type></type>{$types}</types>