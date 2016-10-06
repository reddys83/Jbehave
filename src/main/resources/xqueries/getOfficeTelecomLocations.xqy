let $fid := xs:string(xdmp:get-request-field("fid"))

let $source := xs:string(xdmp:get-request-field("source"))

let $offices := cts:search(fn:collection(fn:concat('source-', $source))/office,
        cts:and-query((
            cts:element-attribute-range-query(xs:QName("office"), xs:QName("fid"), "=", $fid)
        )))

let $officeLocations:= for $x in $offices/locations/location

let $isPrimary := $x/@primary/string()
let $officeTelecoms := for $y in $x/telecom

let $tType := $y/type/text()
let $tRank := $y/@rank/string()
let $tTextBefore := $y/infos/info[@type="desc"]/text()
let $tCountryCode := $y/phoneCountryCode/text()
let $tAreaCode := $y/phoneAreaCode/text()
let $tNumber := $y/phoneNumber/text()

let $tValue := for $x in $tType return if($tType = "fax" or $tType = "telephone")
then string-join(($tCountryCode, $tAreaCode, $tNumber),'-')
else $y/value/text()
let $tRangeLimit := $y/phoneNumberRangeLimit/text()
let $tExt := $y/phoneExtension/text()
let $tTextAfter := $y/infos/info[@type="textAfter"]/text()
let $tAnswerback := $y/answerback/text()
let $tDisplay := $y/value/text()

return <telecom>
    <type>{$tType}</type>
    <rank>{$tRank}</rank>
    <textBefore>{$tTextBefore}</textBefore>
    <value>{$tValue}</value>
    <phoneNumberRangeLimit>{$tRangeLimit}</phoneNumberRangeLimit>
    <phoneExtension>{$tExt}</phoneExtension>
    <textAfter>{$tTextAfter}</textAfter>
    <answerBack>{$tAnswerback}</answerBack>
</telecom>
return <location>{$officeTelecoms}</location>



return <locations>{$officeLocations}</locations>