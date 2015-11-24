Meta:@OfficeSearchResultsSorting @Office

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal
JIRA ID - ZEUS - 554 - User can sort office results by status

Scenario: Verify the sorting office results by FID
Meta:
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
When the user clicks on the office search results fid column
Then the user should see the office search results cards sorted descending order by office fid with fid 1038 from the database
Then the user should see the office search results paginated
And the user should see the offices number of records displayed in the page w.r.t total search results
And the user should see the option to navigate to the desired office search results page
When the user navigates to the 4th page on the office search results
Then the user should see the office search results paginated
And the user should see the offices number of records displayed in the page w.r.t total search results
And the user should see the option to navigate to the desired office search results page
Then the user should see office search results reset to page 1
When the user clicks on the office search results fid column
Then the user should see the office search results cards sorted ascending order by office fid with fid 1038 from the database
Then the user should see the office search results paginated
And the user should see the offices number of records displayed in the page w.r.t total search results
And the user should see the option to navigate to the desired office search results page

Examples:
|entity|searchBy|fid|
|Bank of America National Association|Name|1038|

Scenario: scenario description
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the office search results status column
!--implement below step
Then the user should see the office search results cards sorted ascending order by office status

Then the user should see the office search results paginated
And the user should see the offices number of records displayed in the page w.r.t total search results
And the user should see the option to navigate to the desired office search results page
When the user navigates to the 4th page on the office search results
Then the user should see the office search results paginated
And the user should see the offices number of records displayed in the page w.r.t total search results
And the user should see the option to navigate to the desired office search results page
Then the user should see office search results reset to page 1
When the user clicks on the office search results status column
Then the user should see the office search results cards sorted descending order by office status with fid 1038 from the database
Then the user should see the office search results paginated
And the user should see the offices number of records displayed in the page w.r.t total search results
And the user should see the option to navigate to the desired office search results page

Examples:
|entity|searchBy|fid|
|1038|FID|1038|