Meta:@OfficeSearchResultsFiltering @Office

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal
JIRA - ID - ZEUS - 565 - User can filter list of offices by domestic/foreign

Scenario: Filter offices by type - Domestic
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
Then the user should see the office type filter default to all
When the user selects the office type filter domestic
Then the user should see the list of domestic offices in the office search results

Examples:
|entity|searchBy|fid|
|1038|FID|1038|

Scenario: Filter offices by type - Foreign
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
Then the user should see the office type filter default to all
When the user selects the office type filter foreign
Then the user should see the list of foreign offices in the office search results

Examples:
|entity|searchBy|fid|
|1038|FID|1038|

Scenario: Search returned 0 results
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
Then the user should see the office type filter default to all
When the user selects the office type filter foreign
Then the user should see the message your search returned 0 results.

Examples:
|entity|searchBy|fid|
|189457|FID|189457|