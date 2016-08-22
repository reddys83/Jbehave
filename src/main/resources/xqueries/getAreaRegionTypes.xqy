let $legalCityRegionTypes := collection("source-trusted")/lookup[@fid="AREA_ALTERNATIVE_REGION"]/lookupBody/entry/@id/string()
let $types := for $x in $legalCityRegionTypes
              return <regiontype>{$x}</regiontype>
return <regiontypes><regiontype></regiontype>{$types}</regiontypes>