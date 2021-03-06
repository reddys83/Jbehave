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
let $source := xs:string(xdmp:get-request-field("source")) 

let $countryDoc := /country[@source = 'trusted'][summary/names/name[type = "Country Name"]/value = $country]
let $areaDoc := /area[@source = $source][summary/names/name[type = "Full Name"]/value = $area][within/place/link/@href=$countryDoc/@resource]

let $areaDemographicsList := for $x in ($areaDoc/summary/demographics/metric)
  let $name := $x/name/text()
  let $value := ($x/value/text())
  let $unit := ($x/unit/text())
  let $date := local:getDateAsPerAccuracy($x/date)
return 
  <metrics>
	  <areaDemographicsType>{$name}</areaDemographicsType>
	  <areaDemographicsValue>{$value}</areaDemographicsValue>
	  <areaDemographicsUnit>{$unit}</areaDemographicsUnit>
	  <areaDemographicsDate>{$date}</areaDemographicsDate>
  </metrics>  
 
return
  <area>    
	  <areaDemographics>{$areaDemographicsList}</areaDemographics>
  </area>