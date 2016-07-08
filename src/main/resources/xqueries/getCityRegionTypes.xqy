let $legalCityRegionTypes := collection("source-trusted")/lookup[@fid="CITY_ALTERNATIVE_REGION"]/lookupBody/entry/@id/string()
let $types := for $x in $legalCityRegionTypes
              return <regiontype>{$x}</regiontype>
return <regiontypes>{$types}</regiontypes>