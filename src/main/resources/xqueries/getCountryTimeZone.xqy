let $countryTimeZones := collection("source-trusted")/lookup[@fid="TIME_ZONE"]/lookupBody/entry/@id/string()
let $timeZones := for $x in $countryTimeZones
              return <timeZone>{$x}</timeZone>
return <timeZones><timeZone> </timeZone>{$timeZones}</timeZones>