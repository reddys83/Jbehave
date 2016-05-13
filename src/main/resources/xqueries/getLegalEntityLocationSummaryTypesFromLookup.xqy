let $legalEntityLocation := collection("source-trusted")/lookup[@fid="LOCATION_SUMMARY_TEXT_TYPE"]/lookupBody/entry/@id/string()
let $types := for $x in $legalEntityLocation
order by $x
return <type>{$x}</type>
return <types><type></type>{$types}</types>