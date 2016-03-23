let $area := xs:string(xdmp:get-request-field("name"))
let $source := xs:string(xdmp:get-request-field("source"))

let $areaRelation:= /area[@source=$source][summary/names/name/value=$area]/relatedPlaces/relation
let $areaRelationDetails := for $x in $areaRelation
let $type := $x/type
let $details := $x/details/detail
let $place := fn:doc($x/place/link/@href || '_CURR_SRC~trusted')//summary/names/name[type="Full Name" or type="Country Name"]/value
return <relation>{$type}{$details}{$place}</relation>
return <relations>{$areaRelationDetails}</relations>