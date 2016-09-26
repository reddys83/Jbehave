let $fidNumber := xs:string(xdmp:get-request-field("officeFid"))
let $locationType := xs:string(xdmp:get-request-field("location"))
let $resource :=  fn:concat(collection('current')/office[@source='fdb' and @fid = $fidNumber]/@resource/string(), "*")
let $fdbDocument := cts:uri-match(fn:concat($resource, "fdb"))
let $locationsNode := doc($fdbDocument)/office/locations/location/*[fn:name()=$locationType]
return xdmp:node-delete($locationsNode)