let $routingCodeContextTypes := collection("source-trusted")/lookup[@fid="RELATED_CODE_CONTEXT"]/lookupBody/entry/@id/string()
let $types := for $x in $routingCodeContextTypes
return <routingCodeContextType>{$x}</routingCodeContextType>
return <routingCodeContextTypes>{$types}</routingCodeContextTypes>