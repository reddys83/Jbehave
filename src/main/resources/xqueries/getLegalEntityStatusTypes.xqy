let $legalEntityStatusType := collection("source-trusted")/lookup[@fid="STATUS"]/lookupBody/entry/@id/string()
let $types := for $x in $legalEntityStatusType
              return <status>{$x}</status>
return <statustype>{$types}</statustype>