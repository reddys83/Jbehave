let $name :=xs:string(xdmp:get-request-field("fid"))

for $x in collection('current')/office[@source='zeus']
where $x/@fid=$name
return <documentIdwithEndpoint>
    {$x/@resource}
</documentIdwithEndpoint>