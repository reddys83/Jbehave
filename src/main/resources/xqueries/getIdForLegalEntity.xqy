let $fid :=xs:string(xdmp:get-request-field("fid"))

                         for $x in collection('current')/legalEntity[@source='zeus']
                         where $x/@fid=$fid
                         return <documentIdwithEndpoint>
                             {$x/@resource}
                         </documentIdwithEndpoint>