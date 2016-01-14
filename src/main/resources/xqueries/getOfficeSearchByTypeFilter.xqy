import module namespace functx = "http://www.functx.com" at "/MarkLogic/functx/functx-1.0-nodoc-2007-01.xqy";

let $fid := xs:string(xdmp:get-request-field("fid"))
let $types:= xs:string(xdmp:get-request-field("types"))

let $legalEntity := cts:search(fn:collection('source-trusted')/legalEntity,
        cts:and-query((
            cts:element-attribute-range-query(xs:QName("legalEntity"), xs:QName("fid"), "=", $fid)
        )))

let $offices :=
    (let $officeFids := for $type in tokenize($types,',')

    let $offices := (for $x in cts:search(fn:collection('source-trusted')/office,
            cts:and-query((
                cts:path-range-query("/office/summary/institution/link/@href", "=", $legalEntity/@resource, "collation=http://marklogic.com/collation/"),
                cts:path-range-query("/office/summary/types/type", "=", $type, "collation=http://marklogic.com/collation//S1")
            ))) return <fid>{$x/@fid/string()}</fid>)

    return $offices

    return <fids>{$officeFids}</fids>)

let $fids := for $x in $offices return functx:distinct-deep($x/fid)
let $orderedFids := for $x in $fids order by xs:long(fn:tokenize($x, '-')[last()]) return $x
return <offices>{$orderedFids}</offices>
