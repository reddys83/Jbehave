let $country := xs:string(xdmp:get-request-field("name"))
let $source := xs:string(xdmp:get-request-field("source"))
let $countryDoc := collection("current")/country[@source="trusted"][summary/names/name[type = "Country Name"]/value = "Bermuda"]

let  $offices := for $z in $countryDoc/relatedPresences/relation/presence/link/@href
return if(fn:contains($z,'office'))
                    then collection('current')/office[@source="trusted"][@resource=$z]
                    else ()
let $officelegalTitle:=for $office in $offices
return <legalTitle>{$office/summary/names/name[type="Legal Title"]/value/text()}</legalTitle>

let $city:=for $citylink in $offices/locations/location/address/city/link/@href
return if(fn:contains($citylink,'city'))
                    then collection('current')/city[@source="trusted"][@resource=$citylink]
                    else ()
let $cityname:=for $citylist in $city
return <cityname>{$citylist /summary/names/name[type="Full Name"]/value/text()}</cityname>


let $area:=for $arealink in $offices/locations/location/address/area/link/@href
return if(fn:contains($arealink,'area'))
                    then collection('current')/area[@source="trusted"][@resource=$arealink]
                    else ()
let $areaname:=for $arealist in $area
return if ($arealist/summary/useInAddress='true') then <areaname>{$arealist/summary/names/name[type="Full Name"]/value/text()}</areaname>
else <areaname></areaname>


let  $legalentities := for $z in $countryDoc/relatedPresences/relation/presence/link/@href
return if(fn:contains($z,'legal'))
                    then collection('current')/legalEntity[@source="trusted"][@resource=$z]
                    else ()
let $legalentitylegalTitle:=for $legalentity in $legalentities
return <legalTitle>{$legalentity/summary/names/name[type="Legal Title"]/value/text()}</legalTitle>

return <names>{$officelegalTitle}{$legalentitylegalTitle}{$cityname}{$areaname}</names>
