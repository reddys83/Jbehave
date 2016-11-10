let $lineItems := collection("source-trusted")/lookup[@fid="FINANCIAL_LINE_ITEM_TYPE"]/lookupBody/entry/@name/string()
let $fidTypes := for $x in $lineItems
return <lineItem>{$x}</lineItem>
return <lineItems>{$fidTypes}</lineItems>