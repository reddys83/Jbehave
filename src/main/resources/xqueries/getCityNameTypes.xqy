let $cityNameTypes := collection("source-trusted")/lookup[@fid="PLACE_NAME_TYPE"]/lookupBody/entry/@id/string()
let $types := for $x in $cityNameTypes 
              return if($x = "Full Name") then () else <type>{$x}</type>
return <types><type> </type>{$types}</types>