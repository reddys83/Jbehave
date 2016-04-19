let $countryPlacesDetails := collection("source-trusted")/lookup[@fid="COUNTRY_RELATED_PLACE_SUBTYPE"]/lookupBody/entry/@id/string()
let $types := for $x in $countryPlacesDetails
return <detail>{$x}</detail>
return <places><detail></detail>{$types}</places>