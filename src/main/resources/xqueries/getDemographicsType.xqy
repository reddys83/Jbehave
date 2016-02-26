let $countryNamesType := collection("source-trusted")/lookup[@fid="DEMOGRAPHIC_METRIC"]/lookupBody/entry/@id/string()
let $types := for $x in $countryNamesType
return <type>{$x}</type>
return <types><type></type>{$types}</types>