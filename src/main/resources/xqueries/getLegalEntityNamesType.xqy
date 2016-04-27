let $legalEntityTypes := collection('source-trusted')/lookup[@fid="LEGAL_ENTITY_NAME_TYPE"]/lookupBody/entry/@id/string()
let $types:= for $x in $legalEntityTypes
return if($x="Legal Title") then () else <type>{$x}</type>
return <types>{$types}</types>
