let $routingCode := xs:string(xdmp:get-request-field("officeFid"))
let $routingCodeType := xs:string(xdmp:get-request-field("routingCodeType"))
let $routingCodeId := collection('current')/routingCode[@source='trusted' and codeValue= $routingCode and codeType = $routingCodeType]/@resource
let $routingCodeDoc := fn:concat($routingCodeId,"_CURR_SRC~trusted") 

return xdmp:node-insert-child(doc($routingCodeDoc)/routingCode,
<codeHistory>
	<codeEvent>
	<eventType>Reinstatement</eventType>
	<eventDate accuracy="day">2013-08-09</eventDate>
		<historicUsageLocations>
			<historicUsageLocation>
				<presence>
					<link href="/office/id/f97ece20-9eaa-4df7-ac7e-b82e1c61118b" rel="ref">
					</link>
					<institution>
						<link href="/legalEntity/id/b8d0f49c-6bc4-4886-9a00-2d36f491ba48" rel="ref">
						</link>
					</institution>
					<legalTitle>Family Security CU</legalTitle>
					<address>
						<streetAddress>
							<addressLine1>2204 Family Security Pl SW</addressLine1>
						</streetAddress>
						<postalCode>35603</postalCode>
						<city>
							<link href="/city/id/b6f2255f-6817-4c27-bb3d-52440622fe2b" rel="ref">
							</link>
							<displayName>DECATUR</displayName>
							<placeType>city</placeType>
						</city>
						<area>
							<link href="/area/id/f5d48e59-e052-41f9-aefb-4c9e1fad2ed8" rel="ref">
							</link>
							<fullName>Alabama</fullName>
							<displayName>AL</displayName>
							<placeType>area</placeType>
						</area>
						<country>
							<link href="/country/id/a244f883-0cf2-4c95-a65a-3416877f18b4" rel="ref">
							</link>
							<iso2>US</iso2>
							<name>USA</name>
							<placeType>country</placeType>
						</country>
					</address>
					<presenceType>office</presenceType>
				</presence>
			</historicUsageLocation>
		</historicUsageLocations>
	</codeEvent>
  <codeEvent>
		<eventType>Began use and number retired</eventType>
		<eventDate accuracy="day">2007-10-04</eventDate>
		<eventDescription>This code is assigned</eventDescription>
			<historicUsageLocations>
				<historicUsageLocation>
					<presence>
						<link href="/office/id/ce501d9a-1fa9-45ed-b040-dbca30264afb" rel="ref">
						</link>
					<institution>
						<link href="/legalEntity/id/b8d0f49c-6bc4-4886-9a00-2d36f491ba48" rel="ref">
						</link>
					</institution>
					<legalTitle>Family Security CU</legalTitle>
					<address>
					<streetAddress>
					<addressLine1>Pine Hill Industrial Park</addressLine1>
					</streetAddress>
					<postalCode>36769</postalCode>
					<city>
						<link href="/city/id/a14ec715-e0c2-43ce-b2d5-3025cf998ed4" rel="ref">
						</link>
					<displayName>PINE HILL</displayName>
					<placeType>city</placeType>
					</city>
					<area>
						<link href="/area/id/f5d48e59-e052-41f9-aefb-4c9e1fad2ed8" rel="ref">
						</link>
						<fullName>Alabama</fullName>
						<displayName>AL</displayName>
						<placeType>area</placeType>
					</area>
					<country>
						<link href="/country/id/a244f883-0cf2-4c95-a65a-3416877f18b4" rel="ref">
						</link>
						<iso2>US</iso2>
						<name>USA</name>
						<placeType>country</placeType>
					</country>
					</address>
						<presenceType>office</presenceType>
						</presence>
						</historicUsageLocation>
						<historicUsageLocation>
						<presence>
						<link href="/office/id/5c205ae5-db57-44ba-8f3b-a8c85a4486c3" rel="ref">
						</link>
						<institution>
							<link href="/legalEntity/id/b8d0f49c-6bc4-4886-9a00-2d36f491ba48" rel="ref">
							</link>
						</institution>
						<legalTitle>Family Security CU</legalTitle>
					<address>
						<streetAddress>
							<addressLine1>2204 Family Security Pl SW</addressLine1>
						</streetAddress>
						<postalCode>35603</postalCode>
						<city>
							<link href="/city/id/b6f2255f-6817-4c27-bb3d-52440622fe2b" rel="ref">
							</link>
							<displayName>DECATUR</displayName>
							<placeType>city</placeType>
						</city>
						<area>
							<link href="/area/id/f5d48e59-e052-41f9-aefb-4c9e1fad2ed8" rel="ref">
							</link>
							<fullName>Alabama</fullName>
							<displayName>AL</displayName>
							<placeType>area</placeType>
						</area>
						<country>
							<link href="/country/id/a244f883-0cf2-4c95-a65a-3416877f18b4" rel="ref">
							</link>
							<iso2>US</iso2>
							<name>USA</name>
							<placeType>country</placeType>
						</country>
					</address>
					<presenceType>office</presenceType>
					</presence>
				<additionalInfo>Testing</additionalInfo>
				</historicUsageLocation>
			</historicUsageLocations>
		<replacedBy>
		<link href="/routingCode/id/d1f86ce1-a1a8-469a-b5cf-b528b1a5f114" rel="src">
		</link>
		</replacedBy>
	</codeEvent>
</codeHistory>

)