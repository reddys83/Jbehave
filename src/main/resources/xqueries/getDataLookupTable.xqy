let $source := xs:string(xdmp:get-request-field("source"))
let $lookupDoc :=collection($source)/lookup[@fid='LEGAL_ENTITY_CHARTER_TYPE']/lookupBody/entry/@id
let $collection := for $x in $lookupDoc
return <a>{$x/string()}</a>
return <b>{$collection}</b>