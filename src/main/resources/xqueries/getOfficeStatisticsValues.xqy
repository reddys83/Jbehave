let $fid := xs:string(xdmp:get-request-field("fid"))
let $source := xs:string(xdmp:get-request-field("source"))
let $office := (/office[@fid=$fid][@source=$source])

let $totalAtms := ($office/summary/numberOfATMs/text())
let $totalCheckingAccounts := ($office/summary/numberOfCheckingAccounts/text())
let $totalSavingsAccounts := ($office/summary/numberOfSavingsAccounts/text())

return <office>    
    <numberOfAtms>{$totalAtms}</numberOfAtms>
    <numberOfCheckingAccounts>{$totalCheckingAccounts}</numberOfCheckingAccounts>
    <numberOfSavingsAccounts>{$totalSavingsAccounts}</numberOfSavingsAccounts>
    </office>

