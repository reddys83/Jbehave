
let $country := xs:string(xdmp:get-request-field("country"))
let $area := xs:string(xdmp:get-request-field("area"))
let $source := xs:string(xdmp:get-request-field("source")) 
					
let $countryDoc := /country[@source = "trusted"][summary/names/name[type = "Country Name"]/value = $country]
let $areaDoc := /area[@source = $source][summary/names/name[type = "Full Name"]/value = $area][within/place/link/@href=$countryDoc/@resource]
let $relations := $areaDoc/relatedPresences/relation
let $relatedEntityDetails :=
	for $relation in $relations
      let $entityLink := $relation/presence/link/@href
      let $relatedEntity := if(contains($entityLink, "legalEntity"))
      then (
      	let $id := tokenize($entityLink, "/")[last()]
      	return /legalEntity[@source = $source and @id eq $id]/summary/names/name[type="LegalTitle"]/value/text()
      ) else (
      	let $id := tokenize($entityLink, "/")[last()]
                             return /office[@source = $source and @id eq $id]/summary/names/name[type="Legal Title"]/value/text()
      )
      let $entityType := ($relation/type/text())
      let $entityDetail := ($relation/details/detail/text())
      return
      <areaRelatedEntity>
      	<areaRelatedEntityType>{$entityType}</areaRelatedEntityType>
        <areaRelatedEntity>{$relatedEntity}</areaRelatedEntity>
        <areaRelatedEntityDetail>{$entityDetail}</areaRelatedEntityDetail>
      </areaRelatedEntity>
return <relations>{$relatedEntityDetails}</relations>
                    