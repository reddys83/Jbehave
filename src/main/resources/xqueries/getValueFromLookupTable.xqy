let $source := xs:string(xdmp:get-request-field("source"))
let $fidValue := xs:string(xdmp:get-request-field("fidValue"))
let $lookupDoc :=collection($source)/lookup[@fid=$fidValue]/lookupBody/entry/@id
let $collection := for $x in $lookupDoc
return <a>{$x/string()}</a>
return <b>{$collection}</b>
