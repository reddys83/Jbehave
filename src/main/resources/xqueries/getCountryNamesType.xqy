let $countryNamesType := collection("source-trusted")/lookup[@fid="COUNTRY_NAME_TYPE"]/lookupBody/entry/@id/string()
let $types := for $x in $countryNamesType 
              return if($x = "Country Name") then () else <type>{$x}</type>
return <types><type></type>{$types}</types>