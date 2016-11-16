let $routingCodeAlternateFormType := collection("source-trusted")/lookup[@fid="ROUTING_CODE_ALTERNATE_FORM_TYPE"]/lookupBody/entry/@id/string()
let $types := for $x in $routingCodeAlternateFormType
              return <routingCodeAlternateFormType>{$x}</routingCodeAlternateFormType>
return <routingCodeAlternateFormType>{$types}</routingCodeAlternateFormType>
