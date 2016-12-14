declare namespace functx = "http://www.functx.com";
declare function functx:trim
  ( $arg as xs:string? )  as xs:string {
   replace(replace($arg,'\s+$',''),'^\s+','')
 } ;

declare variable $getDepartment := function($routing as element()) {
   let $department :=cts:search(fn:collection('current')/department[@source='trusted'],
   cts:and-query((
   cts:element-attribute-range-query(xs:QName("department"),xs:QName("resource"), "=", $routing/department/link/@href)
   )))                                      
   return $department
};

declare variable $getOffice := function($routing as element()) {
   let $Office :=cts:search(fn:collection('current')/office[@source='trusted'],
   cts:and-query((
   cts:element-attribute-range-query(xs:QName("office"),xs:QName("resource"), "=", $routing/presence/link/@href)
   )))                                      
   return $Office
};

let $rc :=  xs:string(xdmp:get-request-field("routingCode"))
let $rcType := xs:string(xdmp:get-request-field("routingCodeType"))
let $source := xs:string(xdmp:get-request-field("source"))

let $routingCodes:= (for $x in cts:search(fn:collection('current')/routingCode[@source=$source],
cts:and-query((
cts:path-range-query("/routingCode/codeValue","=",$rc, "collation=http://marklogic.com/collation//S1"),
cts:path-range-query("/routingCode/codeType", "=", $rcType, "collation=http://marklogic.com/collation//S1")
))) return $x)/formerUsageLocations/formerUsageLocation
   
let $formerUsages:= (   
for $x in $routingCodes

let $addInfo:=$x/additionalInfo/text()
let $prefix := $getOffice($x)/summary/names/officeTitlePrefix
let $suffix := $getOffice($x)/summary/names/officeTitleSuffix
let $override := $getOffice($x)/summary/names/officeTitleOverride
let $routingCodeAssignedInstitutionLink := fn:collection('current')/routingCode[@source=$source and codeValue=$rc and codeType=$rcType]/assignedInstitution/link/@href/string()
let $officeInstitutionLink := $getOffice($x)/summary/institution/link/@href/string()
let $offName := if(exists($override))
                then ($override)
                else if(exists($prefix) or exists($suffix) or ($routingCodeAssignedInstitutionLink ne $officeInstitutionLink))
                     then ((fn:concat($prefix," ", $getOffice($x)/summary/names/name[type="Legal Title"]/value/text()," ",$suffix)))
                     else $getOffice($x)/summary/names/name[type="Office Name"]/value/text()

let $officeName := $getOffice($x)/summary/names/name[type='Office Name']/value/text()

let $name:= if(exists($x/department/link))
            then (string-join(($getDepartment($x)/summary/names/name[type='Department Name']/value/text(), functx:trim($offName)), (',  ')))    
            
            else functx:trim($offName)
 
let $city:= if((exists($x/department/link)) and (exists($getDepartment($x)/locations/location[@primary='true']/address[type='physical']/city/name)))
             then ($getDepartment($x)/locations/location[@primary='true']/address[type='physical']/city/name/text()) 
             
             else ($getOffice($x)/locations/location[@primary='true']/address[type='physical']/city/name/text())
             
             
let $area:= if((exists($x/department/link)) and (exists($getDepartment($x)/locations/location[@primary='true']/address[type='physical']/city/name)))
             then ($getDepartment($x)/locations/location[@primary='true']/address[type='physical']/area/name/text()) 
             
             else ($getOffice($x)/locations/location[@primary='true']/address[type='physical']/area/name/text())
      order by $name ascending
             
return <results>
        <name>{$name}</name>
        <city>{$city}</city>
        <area>{$area}</area>
        <addInfo>{$addInfo}</addInfo>
        <officeName>{$officeName}</officeName>
      </results> )
        
return <routingCode>
       <formerUsages> {$formerUsages} </formerUsages>
       </routingCode>