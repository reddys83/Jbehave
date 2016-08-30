let $fid := xs:string(xdmp:get-request-field("officeFid"))
let $source := xs:string(xdmp:get-request-field("source"))
return <office>
      {for $x in /office[@fid=$fid][@source=$source]/personnel/summaries/summary
        return 
        <personnel>
          <type>{data($x/@type)} </type>
          <value>{data($x)} </value>
        </personnel>
      }
      </office>
