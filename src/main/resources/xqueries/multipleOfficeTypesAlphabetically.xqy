let $fid:= xs:string(xdmp:get-request-field("fid"))

let $offices := cts:search(fn:collection('source-trusted')/office,
        cts:and-query((
            cts:element-attribute-range-query(xs:QName("office"), xs:QName("fid"), "=", $fid)
        )))

let $types:= for $x in $offices/summary/types/type
              order by $x  return $x

return <offices><officeTypes>{fn:string-join($types,', ')}</officeTypes></offices>