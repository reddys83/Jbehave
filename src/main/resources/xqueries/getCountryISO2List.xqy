let $countryIso2List := for $x in collection("source-trusted")/country/summary/iso2
order by $x
return $x
return <iso>{$countryIso2List}</iso>