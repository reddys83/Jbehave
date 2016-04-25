let $countryPlacesType := collection("source-trusted")/lookup[@fid="COUNTRY_RELATED_PLACE_TYPE"]/lookupBody/entry/@id/string()
let $types := for $x in $countryPlacesType
return <type>{$x}</type>
return <types><type></type>{$types}</types>