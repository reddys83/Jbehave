let $legalEntityPersonnel := collection("source-trusted")/lookup[@fid="PERSONNEL_SUMMARY_TEXT_TYPE"]/lookupBody/entry/@id/string()
let $types := for $x in $legalEntityPersonnel
order by $x
return <type>{$x}</type>
return <types><type></type>{$types}</types>
