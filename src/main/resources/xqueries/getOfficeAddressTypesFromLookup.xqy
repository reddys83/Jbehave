let $officeAddressTypes:= collection("source-trusted")/lookup[@fid="ADDRESS_TYPE"]/lookupBody/entry/@id/string()
let $types := for $x in $officeAddressTypes
              return <officeAddressTypes>{$x}</officeAddressTypes>
return <officeAddressTypes>{$types}</officeAddressTypes>