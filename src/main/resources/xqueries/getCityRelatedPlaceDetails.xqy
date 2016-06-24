declare namespace functx = "http://www.functx.com";

let $country := xs:string(xdmp:get-request-field("country"))
let $area := xs:string(xdmp:get-request-field("area"))
let $city := xs:string(xdmp:get-request-field("city"))
let $source := xs:string(xdmp:get-request-field("source")) 

let $country := /country[@source = 'trusted'][summary/names/name[type = "Country Name"]/value = $country]
let $area := /area[@source = 'trusted'][summary/names/name[type = "Full Name"]/value = $area][within/place/link/@href=$country/@resource]
let $city := /city[@source = $source][summary/names/name[type = "Full Name"]/value = $city][within/place/link/@href=$area/@resource] 

let $cityRelatedPlaceType := ($city/relatedPlaces/relation/type/text())
let $relatedPlaceLink := ($city/relatedPlaces/relation/place/link/@href)
let $cityRelatedPlacePlace := /area[@source = "trusted"][@resource = $relatedPlaceLink]/summary/names/name[type="Full Name"]/value/text()
let $cityRelatedPlaceDetail := ($city/relatedPlaces/relation/details/detail/text())

return
  <city>
  <RelatedPlaceType>{$cityRelatedPlaceType}</RelatedPlaceType>
  <RelatedPlacePlace>{$cityRelatedPlacePlace}</RelatedPlacePlace>
  <RelatedPlaceDetail>{$cityRelatedPlaceDetail}</RelatedPlaceDetail>
  </city>