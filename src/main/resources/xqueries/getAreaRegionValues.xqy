let $fid := xs:string(xdmp:get-request-field("fid"))
let $AreaRegionValues := collection("source-trusted")/lookup[@fid=$fid]/lookupBody/entry/@id/string()
let $values := for $x in $AreaRegionValues
              return <regionvalue>{$x}</regionvalue>
return <regionvalues><regionvalue></regionvalue>{$values}</regionvalues>