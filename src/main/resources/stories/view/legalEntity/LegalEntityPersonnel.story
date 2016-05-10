Meta:@LegalEntityPersonnel @LegalEntity @View

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal
JIRA ID - ZEUS-399 - User can view legal entity personnel

Scenario: Verify legal entity's personnel
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
When the user clicks on the legal entity personnel link in the navigation bar

Then the user should see the legal entity's personnel as:
|TYPE|VALUE|
|InstitutionEmployees|46628|


Examples:
|entity|searchBy|fid|
|1124|FID|1124|

Scenario: Verify no legal entity's personnel
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
When the user clicks on the legal entity personnel link in the navigation bar
Then the user should not see the legal entity's personnel

Examples:
|entity|searchBy|fid|
|1038|FID|1038|