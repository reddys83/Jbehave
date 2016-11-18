let $rc := xs:string(xdmp:get-request-field('code'))
let $rcWildCard  := if (fn:string-length($rc)>3)
then fn:concat($rc, '*')
else $rc

let $rcValues := cts:value-match(cts:path-reference("/routingCode/codeValue","collation=http://marklogic.com/collation//S1") ,$rcWildCard)

let $routingCodes:= for $x in cts:search(
        fn:collection('source-trusted')/routingCode,
        cts:path-range-query("/routingCode/codeValue","=",$rcValues,"collation=http://marklogic.com/collation//S1"))
return $x

let $routingCodeResults:= (
    for $x in $routingCodes

    let $Code := fn:data($x/codeValue/text())

    let $Type := fn:data($x/codeType/text())



    order by $x/codeValue ascending
    return <results>
        <Code>{$Code}</Code>
        <Type>{$Type}</Type>
    </results>)
return <codeResults>{$routingCodeResults}</codeResults>