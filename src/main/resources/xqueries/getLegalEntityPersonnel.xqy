let $legalEntityName := xs:string(xdmp:get-request-field("fid"))
let $source := xs:string(xdmp:get-request-field("source"))

let $legalEntityPersonnel := /legalEntity[@source=$source][@fid=$legalEntityName]/personnel
return
    <personnel>
        <type>{$legalEntityPersonnel/summaries/summary/@type/string()}</type>
        <value>{$legalEntityPersonnel/summaries/summary/text()}</value>
    </personnel>