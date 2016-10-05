Meta:@LegalEntityBasicInfo @LegalEntity @View @AllStories

Narrative:
In order to view and edit the legalEntity
As a user
I want to cover the requirements mentioned in
JIRA ID - ZEUS-350 - User can view legal entity's basic info
JIRA ID - ZEUS-382 - User will see head office address & legal entity title in header of legal entity screen
JIRA ID - ZEUS-491 - User can follow link to head office from legal entity
JIRA ID - ZEUS-384 - User can view websites of legal entity
JIRA ID - ZEUS-735 - Code shouldn't assume head office fid is of a specific format
JIRA ID - ZEUS-624 - Legal Entity Basic Info - The head office address should respect the UseInAddress.
JIRA ID - ZEUS-793 - Legal Entity Basic Info - Head Office address should respect the @position for displaying the postal code.
JIRA ID - ZEUS-877 - View Legal Entity - Lead Institution

Scenario: Verify the basic info for legalEntity (BUG : ZEUS-950)
Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
Then the user should see the search results for the institution
When the user clicks on the search results card with fid <fid>
Then the user should see the basic info label for selected legal entity
Then the user verifies basic info for legal entity left column <fid> from trusted document

And the user should see the legalEntity names for <fid> in the legalEntity basic info

And the user should see the legalEntity types for <fid> in the legalEntity basic info

And the user should see the legal entity's virtual presence as:
|TYPE|RANK|INFO|VALUE|
|Website||dnb.no|http://www.dnb.no|

And the user should see the legal entity corporate statement as Ultimate Parent Company: The Bank of Nova Scotia 1709 Hollis Street, Halifax, NS B3J 3B7, Canada

Examples:
|entity|searchBy|headOfficeAddress|fid|tfpid|
|DNB Bank ASA|Name|Dronning Eufemias gate 300191|4537|96664340|

Scenario: Verify legal entity header with UseInAddress = False
Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
Then the user should see the search results for the institution
When the user clicks on the search results card with fid <fid>

Examples:
|entity|searchBy|headOfficeAddress|fid|tfpid|
|Berliner Volksbank eG|Name|Budapester Strasse 35, 10787, Berlin, Germany|1717|20205500|

Scenario: Verify the User can follow link to head office from legal entity

Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
Then the user should see the search results for the institution
When the user clicks on the search results card with fid <fid>

Then the user should see the legal entity header with <entity>, <headOfficeAddress>, <fid> and <tfpid>
And the user should see the basic info label for selected legal entity
Then the user verifies basic info for legal entity left column <fid> from trusted document

When the user clicks on the view head office <viewHeadOffice> link for the selected legal entity
Then the user should see the office header with <entity>, <headOfficeAddress>, <officeFid> and <officeTfpid>

Examples:
|entity|searchBy|headOfficeAddress|fid|tfpid|viewHeadOffice|officeAddress|officeFid|officeTfpid|
|Berliner Volksbank eG|Name|Berlin, Germany|1717|20205500|(View Head Office)|Berlin, Germany|1717-0|20205500-0|

Scenario: Verify the User cannot follow link to head office from legal entity when legal entity has no head office
Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
Then the user should see the search results for the institution
When the user clicks on the search results card with fid <fid>
Then the user should see the basic info label for selected legal entity
Then the user should not see the legalEntity's headOffice link

Examples:
|entity|searchBy|headOfficeAddress|fid|tfpid|
|Collins Stewart Europe Limited|Name||271690||

Scenario: Verify the basic info for legalEntity - multiple telecoms
Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
Then the user should see the search results for the institution
When the user clicks on the search results card with fid <fid>
Then the user should see the legal entity's virtual presence as:
|TYPE|RANK|INFO|VALUE|
|Website||bip.b.br|http://www.bip.b.br|
|Website||indusval.com.br|http://www.indusval.com.br|

Examples:
|entity|searchBy|fid|
|Banco Indusval SA|Name|732|

Scenario: Verify legal entity headers
Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
Then the user should see the search results for the institution
When the user clicks on the search results card with fid <fid>

Then the user should see the legal entity header with <entity>, <headOfficeAddress>, <fid> and <tfpid>

Examples:
|entity|searchBy|headOfficeAddress|fid|tfpid|
|Banque Tarneaud|Name||1645|20172300|
|Berliner Volksbank eG|Name|Berlin, Germany|1717|20205500|
|Collins Stewart Europe Limited|Name||271690||

Scenario: Verify legal entity sections list
Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
Then the user should see the search results for the institution
When the user clicks on the search results card with fid <fid>
Then the user should see the below legal entity sections
|SECTIONS|
|ALL|
|BASIC INFO|
|LOCATIONS|
|BOARD MEETINGS|
|SERVICES|
|CREDIT RATINGS|
|STATISTICS|
|TRUST POWERS|
|IDENTIFIERS|
|HISTORY|
|OWNERSHIP|
|PERSONNEL|

Examples:
|entity|searchBy|headOfficeAddress|fid|tfpid|
|Bank of America National Association|Name||1038||

Scenario: Verify the head office address for legalEntity with head office not like -0
Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
Then the user should see the search results for the institution
When the user clicks on the search results card with fid <fid>
Then the user verifies basic info for legal entity left column <fid> from trusted document

Examples:
|entity|searchBy|fid|
|1038|fid|1038|


Scenario: Verifing data displayed on legal entity page left column with database.
Scenario: Verify the lead institution is been displayed only when there is relatinoship with other legal entity.
Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
Then the user should see the search results for the institution
When the user clicks on the search results card with fid <fid>
Then the user verifies basic info for legal entity left column <fid> from trusted document

Examples:
|entity|searchBy|fid|
|1038|fid|1038|
|1717|fid|1717|

Scenario: Verify the charter type is displayed properly (without case transformation) from trusted document (Bug - ZEUS-950)
Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
Then the user verifies basic info for legal entity left column <fid> from trusted document

Examples:
|entity|searchBy|fid|
|930|fid|930|
