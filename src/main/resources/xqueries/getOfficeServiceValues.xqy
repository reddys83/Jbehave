let $fid := xs:string(xdmp:get-request-field("officeFid"))
let $source := xs:string(xdmp:get-request-field("source"))
let $office := (/office[@fid=$fid][@source=$source])

let $officeServicesList := for $x in ($office/services/service)
  let $officeServiceCategory := $x/category/text()
  let $officeServiceOverride := ($x/customDescription/text())
return 
  <service>
  <officeServiceCategory>{$officeServiceCategory} </officeServiceCategory>
  <officeServiceOverride>{$officeServiceOverride} </officeServiceOverride>
  </service>
  
return 
    <office>
    <services> {$officeServicesList} </services> 
    </office>
