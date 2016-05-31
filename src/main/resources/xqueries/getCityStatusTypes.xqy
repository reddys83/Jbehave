let $legalCityStatusTypes := collection("source-trusted")/lookup[@fid="STATUS"]/lookupBody/entry/@id/string()
let $types := for $x in $legalCityStatusTypes
              return <status>{$x}</status>
return <statustype>{$types}</statustype>