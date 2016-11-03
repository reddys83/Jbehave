let $routingCodeSubtype:= collection("source-trusted")/lookup[@fid="ROUTING_CODE_SUBTYPE"]/lookupBody/category/entry/@id/string()
let $types := for $x in $routingCodeSubtype
              return <routingCodeSubtype>{$x}</routingCodeSubtype>
return <routingCodeSubtypeLookupValues>
       {$types}
       </routingCodeSubtypeLookupValues>