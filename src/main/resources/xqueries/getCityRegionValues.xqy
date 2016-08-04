let $fid := xs:string(xdmp:get-request-field("fid"))
let $legalCityRegionValues := collection("source-trusted")/lookup[@fid=$fid]/lookupBody/entry/@id/string()
let $values := for $x in $legalCityRegionValues
              return <regionvalue>{$x}</regionvalue>
return <regionvalues><regionvalue></regionvalue>{$values}</regionvalues>