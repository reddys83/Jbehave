let $routingABACodeSource := collection("source-trusted")/lookup[@fid="ROUTING_CODE_SOURCE"]/lookupBody/entry/@id/string()
let $types := for $x in $routingABACodeSource
              return <routingABACodeSourceTypes>{$x}</routingABACodeSourceTypes>
return <routingABACodeSourceLookupValues>
       {$types}
       </routingABACodeSourceLookupValues>