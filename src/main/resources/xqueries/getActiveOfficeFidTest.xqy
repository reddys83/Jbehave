let $fid := xs:string(xdmp:get-request-field("fid"))
let $fidCount:= xs:int(xdmp:get-request-field("fidCount"))
let $legalEntity := cts:search(fn:collection('source-trusted')/legalEntity,
        cts:and-query((
            cts:element-attribute-range-query(xs:QName("legalEntity"), xs:QName("fid"), "=", $fid)
        )))

let $offices := (for $x in cts:search(fn:collection('source-trusted')/office,
        cts:and-query((
            cts:path-range-query("/office/summary/institution/link/@href", "=", $legalEntity/@resource, "collation=http://marklogic.com/collation/")   
            
        ))) order by xs:long(fn:tokenize($x/@fid, '-')[last()]) return $x) 
let $offices := for $x in $offices return if($x/summary/status eq "active") then $x else ()

let $officeResults := (
    let $officeInfo := for $x in $offices[1 to $fidCount]
    return <fid>{$x/@fid/string()}</fid>
    return $officeInfo)

return <offices>{$officeResults}</offices>  