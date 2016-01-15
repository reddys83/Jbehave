Meta:@LegalEntityBasicInfo @LegalEntity

Narrative:
In order to view and edit the legalEntity
As a user
I want to cover the requirements mentioned in
JIRA ID - ZEUS-350 - User can view legal entity's basic info
JIRA ID - ZEUS-382 - User will see head office address & legal entity title in header of legal entity screen
JIRA ID - ZEUS-491 - User can follow link to head office from legal entity


Scenario: Verify the basic info for legalEntity
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
Then the user should see the message you can search for a legal entity at any time using the header search
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
Then the user should see the search results for the institution
When the user clicks on the search results card with fid <fid>

Then the user should see the basic info for selected legal entity

And the user should see the legal entity's names as:
|TYPE|VALUE|
|Legal Title|DNB Bank ASA|
|Former Name|DnB NOR Bank ASA|
|Former Name|Union Bank of Norway|

And the user should see the legal entity's entity types as:
|TYPE|
|Bank|
|Commercial Bank|
|Corporate Bank|
|Investment Bank|
|Merchant Bank|
|Mortgage Bank|
|Private Bank|
|Retail Bank|
|Savings Bank|
|Bank|
|Commercial Bank|
|Universal Bank|

And the user should see the legal entity's telecoms as:
|TYPE|RANK|INFO|VALUE|
|Bank|Bank|Bank|Bank|
|Commercial Bank|Commercial Bank|Commercial Bank|Commercial Bank|
|Corporate Bank|Corporate Bank|Corporate Bank|Corporate Bank|
|Investment Bank|Investment Bank|Investment Bank|Investment Bank|
|Merchant Bank|Merchant Bank|Merchant Bank|Merchant Bank|
|Mortgage Bank|Mortgage Bank|Mortgage Bank|Mortgage Bank|
|Private Bank|Private Bank|Private Bank|Private Bank|
|Retail Bank|Retail Bank|Retail Bank|Retail Bank|
|Savings Bank|Savings Bank|Savings Bank|Savings Bank|

And the user should see the Status of a legal entity as Active
And the user should see the Claimed Est Date of a legal entity as 01 Jul 1990
And the user should see the Chartered Date of a legal entity  as 01 Jul 1990
And the user should see the Charter Type of a legal entity as Us State Chartered Bank
And the user should see the FATCA Status of a legal entity as Inactive
And the user should see the Insurance Type of a legal entity as PSAIC
And the user should see the Ownership Type of a legal entity as Corporate Bank
And the user should see the Lead Institution of a legal entity as False
And the user should see the Add Info of a legal entity as Ultimate Parent Company: The Bank of Nova Scotia 1709 Hollis Street, Halifax, NS B3J 3B7, Canada
And the user should see the Country of Operations of a legal entity as Norway
And the user should see the Head Office of a legal entity as Dronning Eufemias gate 30Oslo, Oslo, 0191Norway(View Head Office)

And the user should see the legal entity corporate statement as Ultimate Parent Company: The Bank of Nova Scotia 1709 Hollis Street, Halifax, NS B3J 3B7, Canada

Examples:
|entity|searchBy|headOfficeAddress|fid|tfpid|
|DNB Bank ASA|Name|Oslo, Oslo, Norway|4537|96664340|

Scenario: Verify legal entity header with UseInAddress = False
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
Then the user should see the message you can search for a legal entity at any time using the header search
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
Then the user should see the search results for the institution
When the user clicks on the search results card with fid <fid>

Then the user should see the legal entity header with <entity>, <headOfficeAddress>, <fid> and <tfpid>

Examples:
|entity|searchBy|headOfficeAddress|fid|tfpid|
|Bank of America National Association|Name|Charlotte, North Carolina, USA|1038|10077420|

Scenario: Verify the User can follow link to head office from legal entity
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
Then the user should see the message you can search for a legal entity at any time using the header search
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
Then the user should see the search results for the institution
When the user clicks on the search results card with fid <fid>

Then the user should see the legal entity header with <entity>, <headOfficeAddress>, <fid> and <tfpid>
And the user should see the basic info for selected legal entity
And the user should see the Head Office of a legal entity as Budapester Strasse 35Berlin, 10787Germany(View Head Office)

When the user clicks on the view head office <viewHeadOffice> link for the selected legal entity
Then the user should see the office header with <entity>, <headOfficeAddress>, <officeFid> and <officeTfpid>

Examples:
|entity|searchBy|headOfficeAddress|fid|tfpid|viewHeadOffice|officeAddress|officeFid|officeTfpid|
|Berliner Volksbank eG|Name|Berlin, Germany|1717|20205500|(View Head Office)|Berlin, Germany|1717-0|20205500-0|

Scenario: Verify the User cannot follow link to head office from legal entity when legal entity has no head office
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
Then the user should see the message you can search for a legal entity at any time using the header search
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
Then the user should see the search results for the institution
When the user clicks on the search results card with fid <fid>

Then the user should see the legal entity header with <entity>, <headOfficeAddress>, <fid> and <tfpid>
And the user should see the basic info for selected legal entity
Then the user should not see the legalEntity's headOffice link

Examples:
|entity|searchBy|headOfficeAddress|fid|tfpid|
|Collins Stewart Europe Limited|Name||271690||
