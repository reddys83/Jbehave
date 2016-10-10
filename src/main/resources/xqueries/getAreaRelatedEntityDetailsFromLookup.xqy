let $areaEntityDetails := collection("source-trusted")/lookup[@fid="AREA_RELATED_PRESENCE_SUBTYPE"]/lookupBody/entry/@id/string()
let $types := for $x in $areaEntityDetails
return <detail>{$x}</detail>
return <entity><detail></detail>{$types}</entity>