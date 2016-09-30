let $fidNumber := xs:string(xdmp:get-request-field("officeFid"))
let $locationType := xs:string(xdmp:get-request-field("location"))
let $documentType := xs:string(xdmp:get-request-field("documentType"))
let $resource :=  fn:concat(collection('current')/office[@source=$documentType and @fid = $fidNumber]/@resource/string(), "*")
let $fdbDocument := cts:uri-match(fn:concat($resource, $documentType))
let $locationsNode := doc($fdbDocument)/office/locations/location/*[fn:name()=$locationType]
return xdmp:node-delete($locationsNode)