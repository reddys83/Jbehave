let $fid := xs:string(xdmp:get-request-field("officeFid"))
let $source := xs:string(xdmp:get-request-field("source"))

let $offices := cts:search(fn:collection(fn:concat('source-', $source))/office,
        cts:and-query((
            cts:element-attribute-range-query(xs:QName("office"), xs:QName("fid"), "=", $fid)
        )))

let $officeLocations:= for $x in $offices/locations/location

let $isPrimary := $x/@primary/string()

let $officeAddresses := for $y in $x/address

let $type := $y/type/text()
let $addressLine1 := $y/streetAddress/addressLine1/text()

return  <address>
    <type>{$type}</type>
    <addressLine1>{$addressLine1}</addressLine1>
</address>

return <location><primary>{$isPrimary}</primary>{$officeAddresses}</location>

return <locations>{$officeLocations}</locations>