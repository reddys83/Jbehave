let $legalEntityIdentifierType := collection("source-trusted")/lookup[@fid="THIRD_PARTY_IDENTIFIER_LEGAL_ENTITY"]/lookupBody/entry/@id/string()
let $types := for $x in $legalEntityIdentifierType
              return <IdentifierType>{$x}</IdentifierType>
return <IdentifierType>{$types}</IdentifierType>
