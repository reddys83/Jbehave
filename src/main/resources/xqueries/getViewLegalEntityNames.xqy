let $fid :=  xs:string(xdmp:get-request-field("fid"))
let $source := xs:string(xdmp:get-request-field("source"))
let $legalEntityS := (/legalEntity[@fid=$fid][@source=$source])


let $legalEntityType:= for $x in $legalEntityS/summary/names/name
return <type>{$x/type/text()}</type>
let $legalEntityValue:= for $x in $legalEntityS/summary/names/name
return <value>{$x/value/text()}</value>
return <legalEntity>
    <legalEntityType>{$legalEntityType}</legalEntityType>
    <legalEntityValue>{$legalEntityValue}</legalEntityValue>
</legalEntity>

