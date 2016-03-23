let $countryName :=  xs:string(xdmp:get-request-field("name"))
let $source :=  xs:string(xdmp:get-request-field("source"))

let $countryRelation:= /country[@source=$source][summary/names/name/value=$countryName]/relatedPlaces/relation
let $countryRelationDetails := for $x in $countryRelation
let $type := string-join($x/type,", ")
let $details := string-join($x/details/detail,", ")
let $place := fn:doc($x/place/link/@href || '_CURR_SRC~trusted')//summary/names/name[type="Full Name" or type="Country Name"]/value
return <relation><type>{$type}</type><details>{$details}</details>{$place}</relation>
return <relations>{$countryRelationDetails}</relations>