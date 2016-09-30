let $officeTelecomTypes:= collection("source-trusted")/lookup[@fid="TELECOM_TYPE"]/lookupBody/entry/@id/string()
let $types := for $x in $officeTelecomTypes
              return <officeTelecomTypes>{$x}</officeTelecomTypes>
return <officeTelecomLookupValues>
       <officeTelecomTypes></officeTelecomTypes>
       {$types}
       </officeTelecomLookupValues>