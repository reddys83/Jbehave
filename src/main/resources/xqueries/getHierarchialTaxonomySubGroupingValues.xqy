declare function local:getEntry($node as node()*, $columnIds as xs:string*){
  for $id in $columnIds
      let $value :=  for $field in $node/@*
                        let $columName := name($field)
                        let $valueOfField := string($field)
                        return if($columName eq $id) then
                                  (<value>{$valueOfField}</value>)
                                else ()
                                   return if(fn:empty($value)) then (<value/>) else $value
};

declare function local:getCategory($category as node()*,$level as xs:int,$columnIds as xs:string*)
{
  
   if($category/entry) then 
     
     let $entryValues := for $entry in $category/entry return 
                          <entryValues>{local:getEntry($entry,$columnIds)}</entryValues> 
     return element subCategory{ 
         attribute level {$level},
         $entryValues
       } 
   else 
    for $cat in  $category/category
       let $categoryValues :=  <entryValues>{local:getEntry($cat,$columnIds)}</entryValues>  
       return element subCategory{ 
         attribute level {$level},
          $categoryValues,
         local:getCategory($cat,$level+1,$columnIds)
     } 
 };

let $taxonomy := xs:string(xdmp:get-request-field("taxonomy"))
let $headers := collection("source-trusted")/lookup[lookupName=$taxonomy]

let $taxonomyColumns:= for $field in $headers/lookupFields/field
                           let $columName := fn:data($field/@label)
                           return 
                           <label>{$columName}</label>
let $columnIds := fn:data($headers/lookupFields/field/@name)

return
<taxonomyTable>
<columnHeaders>{$taxonomyColumns}</columnHeaders>
<category>{(<entryValues>{local:getEntry($headers/lookupBody/category,$columnIds)}</entryValues>,local:getCategory($headers/lookupBody/category,1,$columnIds))}</category>

</taxonomyTable>