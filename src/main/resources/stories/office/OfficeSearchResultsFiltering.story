Meta:@OfficeSearchResultsFiltering @Office

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal
JIRA - ID - ZEUS - 565 - User can filter list of offices by domestic/foreign
JIRA - ID - ZEUS - 555 - User can change number of office results per page
JIRA - ID - ZEUS - 590 - User can filter list of offices by status

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
Then the user should see the message your search returned 0 results

Examples:
|entity|searchBy|fid|
|189457|FID|189457|

Scenario: Change number of office results per page
Meta:
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
Then the user should see 25 results/page selected by default
Then the user should see the office search results paginated
And the user should see the offices number of records displayed in the page w.r.t total search results
When the user selects the 50 results/page in the office results page
Then the user should see the office search results paginated
And the user should see the offices number of records displayed in the page w.r.t total search results
When the user selects the 100 results/page in the office results page
Then the user should see the office search results paginated
And the user should see the offices number of records displayed in the page w.r.t total search results
When the user selects the 200 results/page in the office results page
Then the user should see the office search results paginated
And the user should see the offices number of records displayed in the page w.r.t total search results
When the user navigates to the 4th page on the office search results
And the user selects the 25 results/page in the office results page
When the user clicks on the office search results status column
Then the user should see the office search results cards sorted ascending order by office status

Examples:
|entity|searchBy|fid|
|1038|FID|1038|

Scenario: Filter offices by status - Active
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
Then the user should see the office status filter default to all
When the user selects the office status filter active
Then the user should see the list of active offices in the office search results

Examples:
|entity|searchBy|fid|
|1038|FID|1038|

Scenario: Filter offices by status - Inactive
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
Then the user should see the office status filter default to all
When the user selects the office status filter inactive
Then the user should see the list of inactive offices in the office search results

Examples:
|entity|searchBy|fid|
|1038|FID|1038|

Scenario: Search returned 0 results for status filter
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
Then the user should see the office type filter default to all
When the user selects the office status filter inactive
Then the user should see the message your search returned 0 results

Examples:
|entity|searchBy|fid|
|189457|FID|189457|