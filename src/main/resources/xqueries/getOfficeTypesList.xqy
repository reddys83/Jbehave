import module namespace functx = "http://www.functx.com" at "/MarkLogic/functx/functx-1.0-nodoc-2007-01.xqy";

let $fid := xs:string(xdmp:get-request-field("fid"))
let $legalEntity := cts:search(fn:collection('source-trusted')/legalEntity,
        cts:and-query((
            cts:element-attribute-range-query(xs:QName("legalEntity"), xs:QName("fid"), "=", $fid)
        )))

let $offices := (for $x in cts:search(fn:collection('source-trusted')/office,
        cts:and-query((
            cts:path-range-query("/office/summary/institution/link/@href", "=", $legalEntity/@resource, "collation=http://marklogic.com/collation/")
        )))  return $x)

let $officeResults := (
    let $officeType := for $x in $offices return $x/summary/types/type
    let $orderedOfficeType := for $x in $officeType order by $x return $x
    return functx:distinct-deep($orderedOfficeType))

return <offices>{$officeResults}</offices>
