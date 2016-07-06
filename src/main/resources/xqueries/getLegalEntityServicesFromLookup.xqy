let $fid := xs:string(xdmp:get-request-field("fid"))
let $FinancialCategoryInput:= xs:string(xdmp:get-request-field("financialCategory"))
let $legalEntityServicesCategory := collection("source-trusted")/lookup[@fid=$fid]/lookupBody/entry/@id/string()
let $serviceCategory := for $x in $legalEntityServicesCategory
              return <serviceCategory>{$x}</serviceCategory>


let $legalEntityServicesFinancialCategory := collection("source-trusted")/lookup[@fid=$fid]/lookupBody/category/@id/string()
let $FinancialCategory := for $x in $legalEntityServicesFinancialCategory
              return <FinancialCategory>{$x}</FinancialCategory>

              let $legalEntityServicesFinancialDetails := collection("source-trusted")/lookup[@fid=$fid]/lookupBody/category[@id=$FinancialCategoryInput]/entry/@id/string()
let $FinancialCategoryDetails := for $x in $legalEntityServicesFinancialDetails
              return <FinancialCategoryDetails>{$x}</FinancialCategoryDetails>


              return <LegalEntityServices>{<serviceCategories>{$serviceCategory}</serviceCategories>}{<FinancialCategories>{$FinancialCategory}</FinancialCategories>}{<FinancialCategoryDetails>{$FinancialCategoryDetails}</FinancialCategoryDetails>}</LegalEntityServices>
