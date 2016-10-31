let $locationSummaryType := collection("source-trusted")/lookup[@fid="LOCATION_SUMMARY_TEXT_TYPE"]/lookupBody/entry/@id/string()
let $types := for $x in $locationSummaryType
              return <locationSummaryType>{$x}</locationSummaryType>
return <locationSummaryTypeLookupValues>
       <locationSummaryType></locationSummaryType>
       {$types}
       </locationSummaryTypeLookupValues>