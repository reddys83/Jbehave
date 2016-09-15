let $fidNumber := xs:string(xdmp:get-request-field("officeFid"))
let $resource :=  fn:concat(collection('current')/office[@source='fdb' and @fid = $fidNumber]/@resource/string(), "*")
let $fdbDocument := cts:uri-match(fn:concat($resource, "fdb"))
let $telecomNode := doc($fdbDocument)/office/locations/location/telecom
return xdmp:node-delete($telecomNode)
