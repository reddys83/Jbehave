let $legalEntityFid := xs:string(xdmp:get-request-field("fid"))
let $periodEndDate := xs:string(xdmp:get-request-field("endDate"))
let $source := xs:string(xdmp:get-request-field("source"))

let $legalEntityId := /legalEntity[@fid = $legalEntityFid]/@id
let $financial :=  /financialStatement[@source = $source and owner/link/@href = fn:concat("/legalEntity/id/",$legalEntityId[1]) and periodEnd = $periodEndDate]
let $missingItems := for $x in ($financial/missingReason)
let $reason := $x/missingReasonType/text()
let $alternateEntity := fn:doc($x/alternateEntity/link/@href || '_CURR_SRC~trusted')//summary/names/name[type="Legal Title"]/value/text()
let $alternateOfStatementLink := ($x/alternateFinancialStatement/link/@href)
let $tokenizeTemp := (tokenize($alternateOfStatementLink,"/financialStatement/id/"))
let $periodEndDate := (/financialStatement[@id=$tokenizeTemp][@source=$source]/periodEnd)
let $statementType := (/financialStatement[@id=$tokenizeTemp][@source=$source]/statementType)

return
<items>
<reason>{$reason}</reason>
<alternateEntity>{$alternateEntity}</alternateEntity>
<statementType>{$statementType}</statementType>
<periodEndDate>{$periodEndDate}</periodEndDate>
</items>

return
<financial>
<lineItems>{$missingItems}</lineItems>
</financial> 