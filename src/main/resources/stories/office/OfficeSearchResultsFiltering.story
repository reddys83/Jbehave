Meta:@OfficeSearchResultsFiltering @Office

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal
JIRA - ID - ZEUS - 565 - User can filter list of offices by domestic/foreign
JIRA - ID - ZEUS - 555 - User can change number of office results per page
JIRA - ID - ZEUS - 590 - User can filter list of offices by status
JIRA - ID - ZEUS - 596 - User can use a combination of filters for office list
JIRA - ID - ZEUS - 589 - User can filter list of offices by office type
JIRA - ID - ZEUS - 487 - User can refine list of offices by city23

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

Scenario: User can use a combination of filters for office list
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
When the user selects the office status filter active
And the user selects the office type filter domestic
And the user selects the institution type filter Head Office
Then the user should see the office results for the applied filters

Examples:
|entity|searchBy|fid|
|1038|FID|1038|

Scenario: User should see the types in the type filter should be based on the office search results types
1. ZEUS-589
Meta:
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
Then the user should see the types in the type filter should be based on the types of office search results

Examples:
|entity|searchBy|fid|
|3|FID|3|

Scenario: User selects one of the office type filter in left sidebar should show the list the offices with the selected office type
Meta:
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
Then the user should see the office type filter default to all
When the user selects the institution type filter Head Office
And the user selects the institution type filter Branch
Then the user should see all is deselected in the office type filter
Then the user should see the office list for the institution <entity>  with the Head office,Branch office type in the office search results

Examples:
|entity|searchBy|fid|
|3|FID|3|

Scenario: Verify the office type filter, When the office has single office type for the institution it should be selected by default and ALL should not be present
Meta:@RunThis
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
Then the user should see Head Office is selected by default

Examples:
|entity|searchBy|fid|
|189457|FID|189457|

Scenario: User should see the error message if the combination of the selection filter is returning zero results
Meta:
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
When the user selects the institution type filter Head Office
When the user selects the office status filter inactive
Then the user should see the message your search returned 0 results

Examples:
|entity|searchBy|fid|
|267124|FID|267124|

Scenario: User selects a column sort and a filter, Both the coulumn sort and filter are applied to the results list
Meta:
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the office search results type column
And the user selects the institution type filter Marketing Office
And the user selects the institution type filter Head Office Branch

Then the user should see the office search results card for the searched legal entity
|ID|NAME|ADDRESS|CITY|AREA|COUNTRY|TYPE|STATUS|
|3-9|Moorgate|Arab Banking Corporation House||||Branch, Head Office Branch|active|
|3-15||Nordic Region Marketing Office||||Marketing Office|active|
|3-14|Marketing Office|UK & Ireland Marketing Office||||Marketing Office|active|

Examples:
|entity|searchBy|fid|
|3|FID|3|


Scenario: Verify the refine filter for city
Meta:@refineFilterCity
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user enters Boll in the refine results search bar
Then the user should see the office search results for city contains the Boll

Examples:
|entity|searchBy|fid|
|3125|FID|3125|



