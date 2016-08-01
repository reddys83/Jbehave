declare function local:month-abbrev-en( $date as xs:anyAtomicType? )  as xs:string? {
    ('Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec')
    [month-from-date(xs:date($date))]
} ;

declare function local:day-abbrev-en( $date as xs:anyAtomicType? )  as xs:string? {
    ('01', '02', '03', '04', '05', '06', '07', '08', '09', '10', '11', '12', '13', '14', '15', '16', '17', '18', '19', '20', '21', '22', '23', '24', '25', '26', '27', '28', '29', '30', '31')
    [day-from-date(xs:date($date))]
} ;

declare function local:getDateAsPerAccuracy( $date as node() ) {
    switch($date/@accuracy/string())
        case "day" return fn:concat(local:day-abbrev-en(xs:date($date)), ' ', local:month-abbrev-en(xs:date($date)), ' ', year-from-date(xs:date($date)))
        case "month" return fn:concat(local:month-abbrev-en(xs:date($date)), ' ', year-from-date(xs:date($date)))
        case "year"  return year-from-date(xs:date($date))
        default return "date not valid"
};


let $country := xs:string(xdmp:get-request-field("country"))
let $area := xs:string(xdmp:get-request-field("area"))
let $subarea := xs:string(xdmp:get-request-field("subarea"))
let $source := xs:string(xdmp:get-request-field("source"))


let $countryDoc := /country[@source = 'trusted'][summary/names/name[type = "Country Name"]/value = $country]
let $areaDoc := /area[@source = 'trusted'][summary/names/name[type = "Full Name"]/value = $area][within/place/link/@href=$countryDoc/@resource]
let $subareaDoc := /area[@source = $source][summary/names/name[type = "Full Name"]/value = $subarea][within/place/link/@href=$areaDoc/@resource]

(: Taking End Date :)        
(: Taking Begin Date :)
let $DateFields :=
    <areaDate>
	    <BeganDate>{local:getDateAsPerAccuracy($areaDoc/summary/dates/dateBegan)}</BeganDate>
		<EndDate>{local:getDateAsPerAccuracy($areaDoc/summary/dates/dateCeased)}</EndDate>        
    </areaDate>
  (: Taking Add Info :)
 let $areaadditionalinfo := ($areaDoc/summary/additionalInfos/additionalInfo/text())
 
 (: Taking Area Interest Rate :)
  let $areaInterestRate := ($areaDoc/summary/maxConsumerRate/text())
 
 (: Get area and Subarea value :) 
let $areavalue := ($areaDoc/summary/names/name[1]/value/text()) 
let $subareavalue := ($subareaDoc/summary/names/name[1]/value/text()) 

(: Get summary and utc value :) 
let $UTClist := for $x in ($areaDoc/summary/timeZones/zone)
let $utc := $x/text()
return 
 <utcvalues>
 <utcvalue>{$utc} </utcvalue>
 </utcvalues>


let $summary := ($areaDoc/summary/timeZones/summaries/summary/text())
let $UTC := ($areaDoc/summary/timeZones/zone/text())

(: Taking identifier List :)
let $areaIdentifierList := for $x in ($areaDoc/summary/identifiers/identifier)
  let $areaIdentifierType := $x/type/text()
  let $areaIdentifierValue := ($x/value/text())
  let $areaIdentifierStatus := ($x/status/text())
return 
  <identifier>
  <identifierType>{$areaIdentifierType} </identifierType>
  <identifierValue>{$areaIdentifierValue} </identifierValue>
  <identifierStatus>{$areaIdentifierStatus} </identifierStatus>
  </identifier>


return
  <Area>
      { $areaDoc/summary/names }
      <dateFields>{$DateFields}</dateFields>
      <AdditionalInfo>{$areaadditionalinfo}</AdditionalInfo>
      <area>{$areavalue}</area>
      <subarea>{$subareavalue}</subarea>
      <identifiers> {$areaIdentifierList} </identifiers> 
      <areaInterestRate>{$areaInterestRate}</areaInterestRate>
      <summary>{$summary}</summary>
      <UTC>{$UTC}</UTC>
      <timezoneutc>{$UTClist}</timezoneutc>      
  </Area>
 