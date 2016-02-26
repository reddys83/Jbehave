let $unit:=xs:string(xdmp:get-request-field("unit"))
let $countryUnitType := for $x in collection('source-trusted')/lookup[@fid='UNIT_OF_MEASUREMENT']/lookupBody/entry[@unitType=$unit]/@id return <unit>{$x/string()}</unit>
let $units := for $x in $countryUnitType
return if ($x = "km2") then <unit>km²</unit>
else if ($x = "miles2") then <unit>mi²</unit>
    else ()
return <units>{$units}</units>
