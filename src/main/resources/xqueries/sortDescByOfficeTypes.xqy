let $fid := xs:string(xdmp:get-request-field("fid"))
let $legalEntity := cts:search(fn:collection('source-trusted')/legalEntity,
        cts:and-query((
            cts:element-attribute-range-query(xs:QName("legalEntity"), xs:QName("fid"), "=", $fid)
        )))

let $offices := for $x in collection('source-trusted')/office
where $x/summary/institution/link/@href = $legalEntity/@resource
return $x

let $officeTypes := for $x in $offices
let $orderedTypes := for $y in $x/summary/types/type
order by $y
return <types>{fn:string-join($y,', ')}</types>
return <officeTypes>{$orderedTypes}</officeTypes>

let $sortedTypes := for $x in $officeTypes
return <type>{fn:string-join ($x/types,', ')}</type>

let $types:=(for $x in $sortedTypes
order by $x descending  return $x) [position()= 1 to 25]

return <officeTypes> {$types} </officeTypes>