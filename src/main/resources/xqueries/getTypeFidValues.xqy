let $fid := xs:string(xdmp:get-request-field("fid"))
let $source := xs:string(xdmp:get-request-field("source"))
let $financial := (/financialStatement[@fid=$fid][@source=$source])
let $itemList := for $x in ($financial/lineItems/item)
let $fid := $x/@fid

return
<items>
<fidType>{fn:data($fid)}</fidType>
</items>

return
<lineItems>{$itemList}</lineItems>
