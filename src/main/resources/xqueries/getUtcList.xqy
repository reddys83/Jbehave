let $timeZoneUtcId := collection("source-trusted")/lookup[@fid="TIME_ZONE"]/lookupBody/entry/@id/string()
let $utc := for $x in $timeZoneUtcId
              return <utc>{$x}</utc>
return <utcid>{$utc}</utcid>