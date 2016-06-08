let $fid := xs:string(xdmp:get-request-field("fid"))
let $source := xs:string(xdmp:get-request-field("source"))
let $types := ("Bank","Building Society","Credit Union","Government","Savings &amp; Loan Association","Savings Bank","Trust Company")

let $countries := for $x in collection('current')/country[@source="trusted"]
where $x/summary/iso2=("US","VI","MP","GU","PR","AS")
return $x/@resource

let $flags := for $x in $countries
return if (fn:contains(collection("current")/legalEntity[@source="trusted"][@fid=$fid]/summary/countryOfOperations/link/@href, $x))
        then if (collection("current")/legalEntity[@source="trusted"][@fid=$fid]/summary/legalEntityType = $types)
              then "true"
              else "false"
        else "false"

return if($flags eq "true")
        then <flag>true</flag>
        else <flag>false</flag>