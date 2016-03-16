let $countryAlternativeRegion := collection("source-trusted")/lookup[@fid="COUNTRY_ALTERNATIVE_REGION"]/lookupBody/entry/@id/string()
let $types := for $x in $countryAlternativeRegion
order by $x
return <type>{$x}</type>
return <types><type>{$types}</type></types>