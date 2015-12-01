let $fid := xs:string(xdmp:get-request-field("fid"))
let $legalEntity := cts:search(fn:collection('source-trusted')/legalEntity,
        cts:and-query((
            cts:element-attribute-range-query(xs:QName("legalEntity"), xs:QName("fid"), "=", $fid)
        )))

let $offices := (for $x in cts:search(fn:collection('source-trusted')/office,
        cts:and-query((
            cts:path-range-query("/office/summary/institution/link/@href", "=", $legalEntity/@resource, "collation=http://marklogic.com/collation/")

        ))) order by
            if(fn:exists($x/summary/names/name[type="Office Name"]/value))  then ($x/summary/names/name[type="Office Name"]/value)  else($x/summary/names/name[type='Legal Title']/value) descending
            return $x) [1 to 25]

let $officeResults := (
    let $officeInfo := for $x in $offices
    return <name>{$x/summary/names/name[type='Office Name']/value/text()}</name>
    return $officeInfo)

return <offices>{$officeResults}</offices>