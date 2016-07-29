let $cityNameTypes := collection("source-trusted")/lookup[@fid="PLACE_NAME_TYPE"]/lookupBody/entry/@id/string()
let $types := for $x in $cityNameTypes 
              return <type>{$x}</type>
return <types>{$types}</types>