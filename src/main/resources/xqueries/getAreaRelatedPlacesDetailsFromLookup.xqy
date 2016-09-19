let $areaPlacesDetails := collection("source-trusted")/lookup[@fid="AREA_RELATED_PLACE_SUBTYPE"]/lookupBody/entry/@id/string()
let $types := for $x in $areaPlacesDetails
return <detail>{$x}</detail>
return <places><detail></detail>{$types}</places>