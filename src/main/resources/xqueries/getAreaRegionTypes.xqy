let $areaRegionTypes := collection("source-trusted")/lookup[@fid="AREA_ALTERNATIVE_REGION"]/lookupBody/entry/@id/string()
let $types := for $x in $areaRegionTypes
              return <regiontype>{$x}</regiontype>
return <regiontypes><regiontype></regiontype>{$types}</regiontypes>