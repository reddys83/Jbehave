Meta:@OfficeLocations @Office @View @AllStories

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal
JIRA ID - ZEUS-427 - User can view office locations

Scenario: verify office locations - addresses, telecom and summary
Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
And the user clicks on the office locations link in the navigation bar
Then the user should see the office locations

Examples:
|entity|searchBy|fid|officeFid|
|68707|FID|68707|68707-0|
|1038|FID|1038|1038-0|

Scenario: verify office locations postal code
Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
And the user clicks on the office locations link in the navigation bar
Then the user should see the office address postal code as 28202

Examples:
|entity|searchBy|fid|officeFid|
|1038|FID|1038|1038-0|