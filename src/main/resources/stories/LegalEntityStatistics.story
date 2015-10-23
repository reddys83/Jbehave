Meta:@LegalEntityStatistics @LegalEntity

Narrative:
In order to view and edit the legalEntities
As a user
I want to cover the requirements mentioned in
JIRA ID - ZEUS - 395 User can view legalEntity statistics

Scenario: Verify legalEntity statistics
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
Then the user should see the message you can search for a legal entity at any time using the header search
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
Then the user should see the search results for the institution
When the user clicks on the search results card with fid <fid>
When the user clicks on the legal entity statistics link in the navigation bar
Then the user should see the legal entity's statistics as:
|TYPE|VALUE|
|Total ATMs:|100|
|Total Checking Accounts:|1000000|
|Total Savings Accounts:|5000|
|Banks in Group:||
|Association Members:||
|Credit Union Members:||
|Credit Union Share Draft:|False|


Examples:
|entity|searchBy|fid|
|The International Holding Bank|Name|93879|