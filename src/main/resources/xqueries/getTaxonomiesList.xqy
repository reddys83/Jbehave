let $taxonomiesList := for $x in collection("source-trusted")/lookup order by $x/lookupName return $x/lookupName
return <taxonomies>{$taxonomiesList}</taxonomies>