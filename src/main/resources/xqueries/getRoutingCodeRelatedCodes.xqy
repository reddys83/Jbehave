let $routingCodeValue :=  xs:string(xdmp:get-request-field("routingCode"))
let $routingCodeType := xs:string(xdmp:get-request-field("routingCodeType"))
let $source := xs:string(xdmp:get-request-field("source"))


let $relation := for $x in /routingCode[@source = $source] where $x/codeValue =$routingCodeValue and $x/codeType=$routingCodeType
return $x/relatedCodes/relation

let $relatedCodes := (

    for $x in $relation

    let $context := $x/context/text()
    let $code := fn:doc($x/routingCode/link/@href || '_CURR_SRC~trusted')//codeValue/text()
    let $type := fn:doc($x/routingCode/link/@href || '_CURR_SRC~trusted')//codeType/text()

    return
        <relatedCodes>
            <context>{$context}</context>
            <code>{$code}</code>
            <type>{$type}</type>
        </relatedCodes>)

return <root>{$relatedCodes}</root>