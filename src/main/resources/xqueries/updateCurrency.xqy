let $currency := xs:string(xdmp:get-request-field("name"))
let $uri := collection('current')/currency[@source='zeus'][name=$currency]/@resource
let $doc := concat($uri,'_CURR_SRC~zeus')
return xdmp:node-replace(doc($doc)/currency,
        <currency deleted="false" fid="AFA" id="7f183895-ee61-4e9b-a6dd-564280b0a0b9" resource="/currency/id/7f183895-ee61-4e9b-a6dd-564280b0a0b9" source="zeus">
            <isoCode>AFA</isoCode>
            <name>afghani</name>
            <symbol>Af</symbol>
            <subUnits>
                <subUnit>
                    <quantity>100</quantity>
                    <name>Puls</name>
                </subUnit>
            </subUnits>
            <uses>
                <use fid="1">
                    <place>
                        <link href="/country/id/f55a7a93-7336-4ff1-b6b3-6df257cd05d0" rel="src"></link>
                        <placeType>country</placeType>
                    </place>
                    <primary>false</primary>
                    <status>inactive</status>
                    <startDate accuracy="day">1980-01-01</startDate>
                    <endDate accuracy="day">2003-01-01</endDate>
                    <replacedBy>
                        <link href="/currency/id/92d1918f-64fb-42e2-bc9e-4f72432a476f" rel="src"></link>
                    </replacedBy>
                </use>
            </uses>
        </currency>)