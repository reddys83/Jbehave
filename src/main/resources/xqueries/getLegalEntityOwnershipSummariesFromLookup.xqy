let $lookupfid := xs:string(xdmp:get-request-field("lookupfid"))
let $legalEntityOwnershipType := collection("source-trusted")/lookup[@fid=$lookupfid]/lookupBody/entry/@id/string()
let $types := for $x in $legalEntityOwnershipType
              return <OwnershipType>{$x}</OwnershipType>
return <OwnershipType>{$types}</OwnershipType>
