let $cityPlacesDetails := collection("source-trusted")/lookup[@fid="CITY_RELATED_PLACE_SUBTYPE"]/lookupBody/entry/@id/string()
let $types := for $x in $cityPlacesDetails
return <detail>{$x}</detail>
return <places><detail></detail>{$types}</places>