let $creditRatingAgencyList := collection("source-trusted")/lookup[@fid="CREDIT_RATING_AGENCY"]/lookupBody/entry/@id/string()
let $agencies := for $x in $creditRatingAgencyList
              return <creditRatingAgency>{$x}</creditRatingAgency>
              
let $creditRatingTypeList := collection("source-trusted")/lookup[@fid="CREDIT_RATING_TYPE"]/lookupBody/entry/@id/string()
let $types := for $x in $creditRatingTypeList
              return <creditRatingType>{$x}</creditRatingType>        

return 
<creditRating>
<creditRatingAgencies>{$agencies}</creditRatingAgencies>
<creditRatingTypes>{$types}</creditRatingTypes>
</creditRating>