let $areaEntityType := collection("source-trusted")/lookup[@fid="AREA_RELATED_PRESENCE_TYPE"]/lookupBody/entry/@id/string()
let $types := for $x in $areaEntityType
return <type>{$x}</type>
return <entity><type></type>{$types}</entity>