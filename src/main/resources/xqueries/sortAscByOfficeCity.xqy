let $fid := xs:string(xdmp:get-request-field("fid"))
let $legalEntity := cts:search(fn:collection('source-trusted')/legalEntity,
        cts:and-query((
            cts:element-attribute-range-query(xs:QName("legalEntity"), xs:QName("fid"), "=", $fid)
        )))

let $offices := (for $x in cts:search(fn:collection('source-trusted')/office,
        cts:and-query((
            cts:path-range-query("/office/summary/institution/link/@href", "=", $legalEntity/@resource, "collation=http://marklogic.com/collation/")
        ))) order by  $x/locations/location[@primary="true"]/address/city/citySortKey  return $x) [1 to 25]

let $officeResults := (
    let $officeCity := for $x in $offices
    return <name>{$x/locations/location[@primary="true"]/address/city/name/text()}</name>
    return $officeCity)

return <offices>{$officeResults}</offices>
