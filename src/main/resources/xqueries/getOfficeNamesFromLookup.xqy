let $fid := xs:string(xdmp:get-request-field("fid"))
let $OfficeNameTypes := collection("source-trusted")/lookup[@fid=$fid]/lookupBody/entry/@id/string()
let $types := for $x in $OfficeNameTypes
              return <OfficeNameTypes>{$x}</OfficeNameTypes>
return <OfficeNameTypes>{$types}</OfficeNameTypes>