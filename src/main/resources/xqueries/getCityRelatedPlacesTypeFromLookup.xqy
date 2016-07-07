let $cityPlacesType := collection("source-trusted")/lookup[@fid="CITY_RELATED_PLACE_TYPE"]/lookupBody/entry/@id/string()
let $types := for $x in $cityPlacesType
return <detail>{$x}</detail>
return <places><detail></detail>{$types}</places>