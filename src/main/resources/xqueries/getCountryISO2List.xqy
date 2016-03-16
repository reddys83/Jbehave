let $countryIso2List := for $x in collection("source-trusted")/country/summary/iso2
order by $x
return $x
return <iso><iso2></iso2>{$countryIso2List}</iso>