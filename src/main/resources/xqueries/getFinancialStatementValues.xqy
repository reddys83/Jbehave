declare function local:exchangeRateTo($currencyCode as xs:string,$value as xs:string){
    <exchangeRate>
        <currencyCode>{$currencyCode}</currencyCode>
        <exchangeRateTo>{fn:round-half-to-even(xs:double($value),4)}</exchangeRateTo>
    </exchangeRate>
};

declare function local:exchangeRateToOther($exchangeRateToOther as node()*){
    for $node in $exchangeRateToOther
    let $currencyId := fn:tokenize($node/currency/link/@href, "/")[last()]
    let $currency := /currency[@source = "trusted" and @id=$currencyId]
    return local:exchangeRateTo(fn:data($currency/isoCode),fn:data($node/value))
};


let $legalEntityFid := xs:string(xdmp:get-request-field("fid"))
let $periodEndDate := xs:string(xdmp:get-request-field("periodenddate"))

let $legalEntityId := /legalEntity[@fid = $legalEntityFid]/@id
let $financialStatement :=  /financialStatement[@source = "trusted" and owner/link/@href = fn:concat("/legalEntity/id/",$legalEntityId[1]) and periodEnd = $periodEndDate]
let $auditedBy  := if($financialStatement/audited) then
    let $auditedByHref := $financialStatement/auditedBy/link/@href
    let $legalEntityId := fn:tokenize($auditedByHref, "/")[last()]
    let $legalEntity := /legalEntity[@source = "trusted" and @id=$legalEntityId]
    return <auditedBy>{fn:data($legalEntity/summary/names/name[type="Legal Title"]/value)}</auditedBy>
else ()
let  $documentId :=  fn:tokenize($financialStatement/sourceDocument/link/@href, "/")[last()]
let $document := /document[@source = "trusted" and @id=$documentId]
let $currencyId := fn:tokenize($financialStatement/currency/link/@href, "/")[last()]
let $currency := /currency[@source = "trusted" and @id=$currencyId]

return <results>{
    $financialStatement/statementType,
    $financialStatement/periodStart,
    $financialStatement/periodEnd,
    $financialStatement/financialYearEnd,
    $financialStatement/orderOfMagnitude,
    $financialStatement/consolidated,$financialStatement/accountingStandards,
    $financialStatement/audited,
    $auditedBy,
    <document>{fn:data($document/assets/mergedAsset/assetPath)}</document>,
    <currency>{fn:data($currency/isoCode)}</currency>,
    local:exchangeRateTo("USD",fn:data($financialStatement/exchangeRates/exchangeRateToUSD)),
    local:exchangeRateTo("GBP",fn:data($financialStatement/exchangeRates/exchangeRateToGBP)),
    local:exchangeRateTo("EUR",fn:data($financialStatement/exchangeRates/exchangeRateToEUR)),
    local:exchangeRateToOther($financialStatement/exchangeRates//exchangeRateToOther)
}

</results>
