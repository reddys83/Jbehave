Meta:@LegalEntityIdentifiers @LegalEntity @View @AllStories

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal
JIRA ID - ZEUS-397 - User can view legal entity identifiers

Scenario: Verify legal entity's identifier
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the legal entity identifier link in the navigation bar

Then the user should see the legal entity's identifiers as:
|TYPE|VALUE|STATUS|
|Bronnoysundregistrene (Norwegian LEIs) (EINO)|B4TYDEB6GKMZO031MB27|Active|
|S and P Identification Number (SPID)|105940|Active|
|FDIC|3510|Active|
|US Tax ID|94-1687665|Active|
|Fitch ID|80089060|Active|
|Chinese Bank Serial Number|Lan Testing|Inactive|
|National Settlement Depository (LEIRU)|12345678901234567890123456789012345678901234567890|Pending|
|OCC|13044|Active|
|Irish Stock Exchange (LEIIE)|Lan Iris Stock Exchange|Inactive|

Examples:
|entity|searchBy|fid|
|1038|FID|1038|

Scenario: Verify no legal entity's identifier
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the legal entity identifier link in the navigation bar
Then the user should not see the legal entity's identifiers

Examples:
|entity|searchBy|fid|
|312461|FID|312461|