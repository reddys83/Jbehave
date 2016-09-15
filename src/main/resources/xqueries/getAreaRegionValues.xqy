let $fid := xs:string(xdmp:get-request-field("fid"))
let $areaRegionValues := collection("source-trusted")/lookup[@fid=$fid]/lookupBody/entry/@id/string()
let $values := for $x in $areaRegionValues
              return <regionValue>{$x}</regionValue>
return <regionValues><regionValue></regionValue>{$values}</regionValues>