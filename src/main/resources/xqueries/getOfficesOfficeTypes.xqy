let $officesOfficeType := collection("source-trusted")/lookup[@fid="OFFICE_TYPE"]/lookupBody/entry/@id/string()
let $types := for $x in $officesOfficeType
              return <OfficeType>{$x}</OfficeType>
return <OfficeType>{$types}</OfficeType>