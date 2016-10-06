let $areaPlacesType := collection("source-trusted")/lookup[@fid="AREA_RELATED_PLACE_TYPE"]/lookupBody/entry/@id/string()
let $types := for $x in $areaPlacesType
return <detail>{$x}</detail>
return <places><detail></detail>{$types}</places>