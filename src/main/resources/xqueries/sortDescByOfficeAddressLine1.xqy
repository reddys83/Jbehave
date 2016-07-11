let $fid := xs:string(xdmp:get-request-field("fid"))
let $legalEntity := cts:search(fn:collection('source-trusted')/legalEntity,
        cts:and-query((
            cts:element-attribute-range-query(xs:QName("legalEntity"), xs:QName("fid"), "=", $fid)
        )))

let $offices := (for $x in cts:search(fn:collection('source-trusted')/office[@source="trusted"],
        cts:and-query((
                        cts:path-range-query("/office/summary/institution/link/@href", "=", $legalEntity/@resource, "collation=http://marklogic.com/collation/")
        ))) order by  $x/locations/location[@primary="true"]/address/area/name  return $x)

let $officeAddressLine1 := (
    let $addressLine1 := for $x in $offices
    order by $x/locations/location[@primary="true"]/address/streetAddress/addressLine1 descending collation "http://marklogic.com/collation/en/MO"
    return $x/locations/location[@primary="true"]/address/streetAddress/addressLine1
    return $addressLine1) [1 to 25]

return <offices>{$officeAddressLine1}</offices>





