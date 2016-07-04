let $fid := xs:string(xdmp:get-request-field("fid"))
let $legalEntityEntityType := collection("source-trusted")/lookup[@fid=$fid]/lookupBody/entry/@id/string()
let $types := for $x in $legalEntityEntityType
              return <CreditRatings>{$x}</CreditRatings>
return <CreditRatings>{$types}</CreditRatings>