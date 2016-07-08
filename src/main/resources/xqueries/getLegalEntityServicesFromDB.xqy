let $fid := xs:string(xdmp:get-request-field("fid"))
let $source := xs:string(xdmp:get-request-field("source"))
let $legalEntityS := (/legalEntity[@fid=$fid][@source=$source])

let $serviceCategory:= ($legalEntityS/services/service/category)
let $serviceOverride:= for $x in $legalEntityS/services/service
return if(fn:exists($x/customDescription) and fn:exists($x/category))
then $x/customDescription
else <customDescription>null</customDescription>
let $financialCategory:= ($legalEntityS/financialServices/financialService/category)
let $financialDetails:= ($legalEntityS/financialServices/financialService/detail)

let $serviceCategories:= for $x in $serviceCategory
return <serviceCategory>{$x/text()}</serviceCategory>

let $financialCategories:=for $x in $financialCategory
return <financialCategory>{$x/text()}</financialCategory>

return <services>{$serviceCategories}{$serviceOverride}{$financialCategories}{$financialDetails}</services>


