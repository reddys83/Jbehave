Meta:@OfficeLocations

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal
JIRA ID - ZEUS-427 - User can view office locations

Scenario: verify office locations
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
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
|43823|FID|43823|43823-1|
