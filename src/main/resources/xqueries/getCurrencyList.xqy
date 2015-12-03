let $currencies := (for $curr in (cts:search(fn:collection('source-trusted')/currency,
        cts:and-query(()))) order by $curr/name return $curr/name)

return <currencies>{$currencies}</currencies>