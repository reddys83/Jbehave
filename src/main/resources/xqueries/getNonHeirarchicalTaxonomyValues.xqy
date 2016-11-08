let $taxonomy := xs:string(xdmp:get-request-field("taxonomy"))
let $source := xs:string(xdmp:get-request-field("source"))
let $headers := collection(fn:concat("source-", $source))/lookup[@fid=$taxonomy]

let $taxonomyColumns:= for $field in $headers/lookupFields/field
let $columName := fn:data($field/@label)

return 
<name>{$columName}</name>

let $entry := for $entry in $headers/lookupBody/entry
let $taxonomyCategory:= for $field in $entry/@*
let $columName := name($field)
let $valueOfField := string($field)
return 
<value>{$valueOfField}</value>
return<entryValues> {$taxonomyCategory }</entryValues> 

return
<taxonomyTable>
<columnHeaders>{$taxonomyColumns}</columnHeaders>
{$entry}
</taxonomyTable>
