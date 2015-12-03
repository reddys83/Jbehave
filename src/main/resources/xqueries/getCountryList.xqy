let $countries := (for $x in (cts:search(fn:collection('source-trusted')/country,
        cts:and-query(()))) order by $x/summary/names/name[type="Country Name"]/value return $x/summary/names/name[type="Country Name"]/value)

return <countries>{$countries}</countries>