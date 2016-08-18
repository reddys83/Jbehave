let $fid := xs:string(xdmp:get-request-field("officeFid"))
let $source := xs:string(xdmp:get-request-field("source"))
let $office := (/office[@fid=$fid][@source=$source])
let $officeHistory := ($office/history/summaries/summary/text())

return 
<office>
<officeHistory>{$officeHistory}</officeHistory>
</office>
  