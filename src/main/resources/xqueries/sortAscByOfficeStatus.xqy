let $fid := xs:string(xdmp:get-request-field("fid"))
let $legalEntity := cts:search(fn:collection('source-trusted')/legalEntity,
                          cts:and-query((
                                cts:element-attribute-range-query(xs:QName("legalEntity"), xs:QName("fid"), "=", $fid)
                    )))

let $offices := (for $x in cts:search(fn:collection('source-trusted')/office,
                         cts:and-query((
                               cts:path-range-query("/office/summary/institution/link/@href", "=", $legalEntity/@resource, "collation=http://marklogic.com/collation/")
                                ))) order by $x/office/summary/status return $x)[ 1 to 25]

let $officeResults := (
let $officeInfo := for $x in $offices
  let $fid := $x/@fid/string()
  let $name := $x/summary/names/name[type="Office Name"]/value/text()
  let $address := $x/locations/location[@primary="true"]/address/streetAddress/addressLine1/text()

  let $city := cts:search(fn:collection('source-trusted')/city,
                         cts:and-query((
                               cts:element-attribute-range-query(xs:QName("city"), xs:QName("resource"), "=", $x/locations/location[@primary="true"]/address/city/link/@href)
                                )))

  let $area := cts:search(fn:collection('source-trusted')/area,
                           cts:and-query((
                                 cts:element-attribute-range-query(xs:QName("area"), xs:QName("resource"), "=", $x/locations/location[@primary="true"]/address/area/link/@href)
                                  )))

  let $country := cts:search(fn:collection('source-trusted')/country,
                           cts:and-query((
                                 cts:element-attribute-range-query(xs:QName("country"), xs:QName("resource"), "=", $x/locations/location[@primary="true"]/address/country/link/@href)
                                  )))

  let $cityName := $city/summary/names/name[type="Full Name"]/value/text()
  let $areaName := $area/summary/names/name[type="Full Name"]/value/text()
  let $countryName := $country/summary/names/name[type="Country Name"]/value/text()

  let $type := for $y in $x/summary/types/type return string-join(($y/text()),',')
  let $status := $x/summary/status/text()
  return <office>
          <fid>{$fid}</fid>
          <name>{$name}</name>
          <address>{$address}</address>
          <city>{$cityName}</city>
          <area>{$areaName}</area>
          <country>{$countryName}</country>
          <type>{$type}</type>
          <status>{$status}</status>
         </office>

return $officeInfo) [1 to 25]

return <offices>{$officeResults}</offices>