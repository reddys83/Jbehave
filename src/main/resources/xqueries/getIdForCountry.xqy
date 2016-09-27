let $name :=xs:string(xdmp:get-request-field("name"))

for $x in collection('current')/country[@source='zeus']
where $x/summary/names/name/value=$name
return  <countryDoc><documentIdwithEndpoint>{$x/@resource}</documentIdwithEndpoint> <documentId>{$x/@id}</documentId> </countryDoc>