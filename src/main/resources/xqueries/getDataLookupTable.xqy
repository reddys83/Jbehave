let $lookupDoc :=collection("source-trusted")/lookup[@fid='LEGAL_ENTITY_CHARTER_TYPE']/lookupBody/entry/@id
let $collection := for $x in $lookupDoc
return <a>{$x/string()}</a>
return <b>{$collection}</b>