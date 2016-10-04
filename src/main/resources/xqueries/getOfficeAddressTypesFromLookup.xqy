let $officeAddressTypes:= collection("source-trusted")/lookup[@fid="ADDRESS_TYPE"]/lookupBody/entry/@id/string()
let $types := for $x in $officeAddressTypes
              return <officeAddressType>{$x}</officeAddressType>
return <officeAddressTypes><officeAddressType></officeAddressType>{$types}</officeAddressTypes>