Meta:@LegalEntityLocationSummaries  @LegalEntity

Narrative:
In order to view and edit the legalEntity
As a user
I want to cover the requirements mentioned in
JIRA ID - ZEUS-391 - User can view legalEntity location summaries

Scenario: Verify the legalEntity lcoation summary
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
When the user clicks on the legal entity locations link in the navigation bar
Then the user should see the legal entity's location summaries as:
|TYPE|VALUE|
|NumberOfBranches|76|


Examples:
|entity|searchBy|fid|
|Kreissparkasse Göppingen|Name|3125|

Scenario: Verify no legalEntity location summary
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
When the user clicks on the legal entity locations link in the navigation bar
Then the user should not see the legal entity's location summaries



Examples:
|entity|searchBy|fid|
|Associated Commercial Finance Inc|Name|91832|