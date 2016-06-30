let $legalEntityIdentifierStatus := collection("source-trusted")/lookup[@fid="STATUS"]/lookupBody/entry/@id/string()
let $types := for $x in $legalEntityIdentifierStatus
              return <IdentifierStatus>{$x}</IdentifierStatus>
return <IdentifierStatus>{$types}</IdentifierStatus>
