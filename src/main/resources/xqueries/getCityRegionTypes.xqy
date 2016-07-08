let $legalCityRegionTypes := collection("source-trusted")/lookup[@fid="STATUS"]/lookupBody/entry/@id/string()
let $types := for $x in $legalCityRegionTypes
              return <regiontype>{$x}</regiontype>
return <regiontypes>
           <regiontype></regiontype>
           <regiontype>Federal Reserve District</regiontype>
           <regiontype>Federal Reserve Sub District</regiontype>
           <regiontype>Federal Home Loan Bank District</regiontype>
           <regiontype>National Credit Union Administration Region</regiontype>
           <regiontype>Metropolitan Statistical Area</regiontype>
       </regiontypes>