let $legalEntityEntityType := collection("source-trusted")/lookup[@fid="LEGAL_ENTITY_CATEGORY"]/lookupBody/entry/@id/string()
let $types := for $x in $legalEntityEntityType
              return <EntityType>{$x}</EntityType>
return <EntityType>{$types}</EntityType>