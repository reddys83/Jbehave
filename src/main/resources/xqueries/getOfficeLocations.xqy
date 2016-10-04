let $fid := xs:string(xdmp:get-request-field("officeFid"))
let $source := xs:string(xdmp:get-request-field("source"))

let $offices := cts:search(fn:collection(fn:concat('source-', $source))/office,
        cts:and-query((
            cts:element-attribute-range-query(xs:QName("office"), xs:QName("fid"), "=", $fid)
        )))

let $officeLocations:= for $x in $offices/locations/location

let $isPrimary := $x/@primary/string()

let $officeAddresses := for $y in $x/address

let $type := $y/type/text()
let $info := string-join($y/infos/info,',')
let $addressLine1 := $y/streetAddress/addressLine1/text()
let $addressLine2 := $y/streetAddress/addressLine2/text()
let $addressLine3 := $y/streetAddress/addressLine3/text()
let $addressLine4 := $y/streetAddress/addressLine4/text()
let $city := $y/city/name/text()
let $subarea := $y/subarea/name/text()
let $area := $y/area/name/text()
let $country := $y/country/name/text()
let $postalCode := $y/postalCode/text()
let $postalCodePos := $y/postalCode/@position/string()
let $postalSuffix := $y/postalSuffix/text()

return  <address>
    <addressType>{$type}</addressType>
    <info>{$info}</info>
    <addressLine1>{$addressLine1}</addressLine1>
    <addressLine2>{$addressLine2}</addressLine2>
    <addressLine3>{$addressLine3}</addressLine3>
    <addressLine4>{$addressLine4}</addressLine4>
    <city>{$city}</city>
    <subarea>{$subarea}</subarea>
    <area>{$area}</area>
    <country>{$country}</country>
    <postalCode>{$postalCode}</postalCode>
    <postalCodePos>{$postalCodePos}</postalCodePos>
    <postalSuffix>{$postalSuffix}</postalSuffix>
</address>

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

return <location><primary>{$isPrimary}</primary>{$officeAddresses}{$officeTelecoms}</location>

(: To verify Primary Flag and its corresponding Address Line 1 values :)
let $officePrimaryFlag := for $a in $offices/locations/location

let $primaryFlag := $a/@primary/string()

let $officeAddressLine1 := for $b in $a/address

let $addressLine1Value := $b/streetAddress/addressLine1/text()

return <addressLine1Value>{$addressLine1Value}</addressLine1Value>

return <locationPrimaryFlag><primaryFlag>{$primaryFlag}</primaryFlag>{$officeAddressLine1}</locationPrimaryFlag>

return <locations>{$officeLocations}{$officePrimaryFlag}</locations>