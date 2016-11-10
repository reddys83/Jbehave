let $fid := xs:string(xdmp:get-request-field("fid"))
let $source := xs:string(xdmp:get-request-field("source"))
let $financial := (/financialStatement[@fid=$fid][@source=$source])
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