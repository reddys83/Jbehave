let $fid := xs:string(xdmp:get-request-field("officeFid"))
let $source := xs:string(xdmp:get-request-field("source"))
let $office := (/office[@fid=$fid][@source=$source])

let $officeIdentifierList := for $x in ($office/summary/identifiers/identifier)
  let $officeIdentifierType := $x/type/text()
  let $officeIdentifierValue := ($x/value/text())
  let $officeIdentifierStatus := ($x/status/text())
return 
  <identifier>
  <identifierType>{$officeIdentifierType} </identifierType>
  <identifierValue>{$officeIdentifierValue} </identifierValue>
  <identifierStatus>{$officeIdentifierStatus} </identifierStatus>
  </identifier>
  
return 
    <office>
    <identifiers> {$officeIdentifierList} </identifiers> 
    </office>

