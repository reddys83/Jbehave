let $officeNameTypes := collection("source-trusted")/lookup[@fid="OFFICE_NAME_TYPE"]/lookupBody/entry/@id/string()
let $types := for $x in $officeNameTypes
              return <officeNameTypes>{$x}</officeNameTypes>
return <officeNameTypes>{$types}</officeNameTypes>
