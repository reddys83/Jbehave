declare namespace functx = "http://www.functx.com";
declare function functx:month-abbrev-en
( $date as xs:anyAtomicType? )  as xs:string? {

    ('Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec')
    [month-from-date(xs:date($date))]
} ;

declare function functx:day-abbrev-en
( $date as xs:anyAtomicType? )  as xs:string? {
    ('01', '02', '03', '04', '05', '06', '07', '08', '09', '10', '11', '12', '13', '14', '15', '16', '17', '18', '19', '20', '21', '22', '23', '24', '25', '26', '27', '28', '29', '30', '31')
    [day-from-date(xs:date($date))]
} ;

declare function local:getDateAsPerAccuracy
( $date as node() ) {
    switch($date/@accuracy/string())
        case "day" return fn:concat(functx:day-abbrev-en(xs:date($date)), ' ', functx:month-abbrev-en(xs:date($date)), ' ', year-from-date(xs:date($date)))
        case "month" return fn:concat(functx:month-abbrev-en(xs:date($date)), ' ', year-from-date(xs:date($date)))
        case "year"  return year-from-date(xs:date($date))
        default return "date not valid"
};

let $country := xs:string(xdmp:get-request-field("country"))
let $area := xs:string(xdmp:get-request-field("area"))
let $city := xs:string(xdmp:get-request-field("city"))
let $source := xs:string(xdmp:get-request-field("source")) 

let $country := /country[@source = 'trusted'][summary/names/name[type = "Country Name"]/value = $country]
let $area := /area[@source = 'trusted'][summary/names/name[type = "Full Name"]/value = $area][within/place/link/@href=$country/@resource]
let $city := /city[@source = $source][summary/names/name[type = "Full Name"]/value = $city][within/place/link/@href=$area/@resource] 

(: Taking City Name List :)
let $cityNameList := for $x in ($city/summary/names/name)
  let $cityNameType := $x/type/text()
  let $cityNameValue := ($x/value/text())
return 
  <name>
    <type>{$cityNameType}</type>
    <value>{$cityNameValue}</value>
  </name>
  
(: Taking City Region List :)
let $cityRegionList := for $x in ($city/alternativeRegions/region)
  let $cityRegionType := $x/type/text()
  let $cityRegionValue := ($x/value/text())
return 
  <region>
    <type>{$cityRegionType}</type>
    <value>{$cityRegionValue}</value>
  </region>


(: Taking identifier List :)
let $cityIdentifierList := for $x in ($city/summary/identifiers/identifier)
  let $cityIdentifierType := $x/type/text()
  let $cityIdentifierValue := ($x/value/text())
  let $cityIdentifierStatus := ($x/status/text())
return 
  <identifier>
  <type>{$cityIdentifierType} </type>
  <value>{$cityIdentifierValue} </value>
  <identifierStatus>{$cityIdentifierStatus} </identifierStatus>
  </identifier>
  
(: Taking Begin Date and End Date:)
let $DateFields := for $x in $city
let $BeginDate :=local:getDateAsPerAccuracy($x/summary/dates/dateBegan)
let $EndDate :=local:getDateAsPerAccuracy($x/summary/dates/dateCeased)
return
    <cityDate>     
        <BeginDate>{$BeginDate}</BeginDate>
        <EndDate>{$EndDate}</EndDate>
    </cityDate>
    
let $cityStatus := ($city/summary/status/text())
let $cityadditionalinfo := ($city/summary/additionalInfos/additionalInfo/text())
let $cityPopulation := ($city/summary/demographics/metric/value/text())
let $cityAddressFlag := ($city/summary/useInAddress/text())

let $cityCreditRating := for $x in ($city/creditRatings/rating)
let $cityCreditAgencyName := $x/agencyName/text()
let $cityCreditType := $x/type/text()
let $cityCreditValue := $x/value/text()  
let $cityCreditDateApplied := local:getDateAsPerAccuracy($x/dateApplied)
let $cityCreditDateConfirmed := local:getDateAsPerAccuracy($x/dateConfirmed) 
return
      <creditRating>       
        <creditRatingAgencyName>{$cityCreditAgencyName}</creditRatingAgencyName>
        <creditRatingType>{$cityCreditType}</creditRatingType>
        <creditRatingValue>{$cityCreditValue}</creditRatingValue>
        <creditDateApplied>{$cityCreditDateApplied}</creditDateApplied>
        <creditDateConfirmed>{$cityCreditDateConfirmed}</creditDateConfirmed>
     </creditRating> 


return
  <city>
  <names>{$cityNameList}</names>
  <status>{$cityStatus}</status>  
  <identifiers> {$cityIdentifierList} </identifiers> 
  <dateFields>{$DateFields}</dateFields>
  <additionalinfo>{$cityadditionalinfo}</additionalinfo>
  <population>{$cityPopulation}</population>
  <addressFlag>{$cityAddressFlag}</addressFlag>
  <creditRatings>{$cityCreditRating}</creditRatings>
  <regions>{$cityRegionList}</regions>
  </city>   
