let $fid := xs:string(xdmp:get-request-field("fid"))
let $legalEntity := cts:search(fn:collection('source-trusted')/legalEntity,
        cts:and-query((
            cts:element-attribute-range-query(xs:QName("legalEntity"), xs:QName("fid"), "=", $fid)
        )))

let $offices := (for $x in cts:search(fn:collection('source-trusted')/office,
        cts:and-query((
            cts:path-range-query("/office/summary/institution/link/@href", "=", $legalEntity/@resource, "collation=http://marklogic.com/collation/")
                      ))) order by $x/summary/status return $x) [1 to 25]

let $officeResults := (
    let $officeInfo := for $x in $offices
    return <fid>{$x/summary/status/string()}</fid>
    return $officeInfo)

return <offices>{$officeResults}</offices>

