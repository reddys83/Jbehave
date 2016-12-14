let $legalEntityFid := xs:string(xdmp:get-request-field("fid"))
let $source := xs:string(xdmp:get-request-field("source"))
let $periodEndDate := xs:string(xdmp:get-request-field("periodEndDate"))
let $legalEntityId := /legalEntity[@fid = $legalEntityFid]/@id
let $financial :=  /financialStatement[@source = $source and owner/link/@href = fn:concat("/legalEntity/id/",$legalEntityId[1]) and periodEnd = $periodEndDate]
let $itemList := for $x in ($financial/lineItems/item)
let $name := $x/name/text()
let $calculated := $x/@calculated
let $value := $x/value/text()
let $normalizedValue := $x/normalizedValue/text()
let $notes := $x/note/text()

return
<items>
<typeName>{$name}</typeName>
<calculated>{fn:data($calculated)}</calculated>
<value>{$value}</value>
<normalizedValue>{$normalizedValue}</normalizedValue>
<notes>{$notes}</notes>
</items>

return
<financial>
<lineItems>{$itemList}</lineItems>
</financial>