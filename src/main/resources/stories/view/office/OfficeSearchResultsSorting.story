Meta:@OfficeSearchResultsSorting @Office @View @AllStories

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

JIRA ID - ZEUS-617 - List offices types alphabetically when multiple for one office
JIRA ID - ZEUS-554 - User can sort office results by status
JIRA ID - ZEUS-554 - User can sort office results by status
JIRA ID - ZEUS-549 - User can sort office results by FID
JIRA ID - ZEUS-553 - User cna sort office results by type
JIRA ID - ZEUS-550 - User can sort office results by name
JIRA ID - ZEUS-551 - User can sort office results by area
JIRA ID - ZEUS-548 - User can sort office results by city
JIRA ID - ZEUS-552 - User can sort office results by country
JIRA ID - ZEUS-561 - User can sort office results by addressline1

Scenario: Verify the list of office multiple types should order alphabetically in office search results page

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
Then the user should see the multiple office types sorted alphabetically with comma separated for office 113461-1

Examples:
|entity|searchBy|fid|
|Petersburg Social Commercial Bank Open Joint Stock Company|Name|113461|

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
Then the user should see the office search results cards sorted descending order by office fid with fid 91832 from the database
When the user clicks on the office search results fid column
Then the user should see the office search results cards sorted ascending order by office fid with fid 91832 from the database

Examples:
|entity|searchBy|fid|headOfficeAddress|tfpid|
|Associated Commercial Finance Inc|Name|91832|112 North Adams St|96691281|

Scenario: Verify the sorting office results by STATUS
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the office search results status column
Then the user should see the office search results cards sorted ascending order by office status
Then the user should see the office search results paginated
And the user should see the offices number of records displayed in the page w.r.t total search results
And the user should see the option to navigate to the desired office search results page
When the user navigates to the 2nd page on the office search results
Then the user should see the office search results paginated
And the user should see the offices number of records displayed in the page w.r.t total search results
And the user should see the option to navigate to the desired office search results page
When the user clicks on the office search results status column
Then the user should see the office search results cards sorted descending order by office status
Then the user should see office search results reset to page 1
Then the user should see the office search results paginated
And the user should see the offices number of records displayed in the page w.r.t total search results
And the user should see the option to navigate to the desired office search results page

Examples:
|entity|searchBy|fid|
|1717|FID|1717|

Scenario: Verify the sorting office results by TYPE
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
Then the office search results should sort by type which sorted ascending order by office type with fid 1717 from the database
When the user navigates to the 2nd page on the office search results
When the user clicks on the office search results type column
Then the user should see office search results reset to page 1
Then the office search results should sort by type which sorted descending order by office type with fid 1717 from the database

Examples:
|entity|searchBy|fid|
|1717|FID|1717|

Scenario: Verify the sorting office results by TYPE where the office has multiple types
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
Then the office search results should sort by type which sorted ascending order by office type with fid 113461 from the database
When the user clicks on the office search results type column
Then the office search results should sort by type which sorted descending order by office type with fid 113461 from the database

Examples:
|entity|searchBy|fid|
|113461|FID|113461|

Scenario: Verify Office Results by name
Meta:
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
When the user clicks on the office search results column name
Then the office search results should sort by name which sorted ascending order by office name with fid 3952 from the database
When the user clicks on the office search results column name
Then the office search results should sort by name which sorted descending order by office name with fid 3952 from the database

Examples:
|entity|searchBy|fid|
|3952|FID|3952|

Scenario: Verify Office Results by Area
Meta:
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
When the user clicks on the office search results column area
Then the office search results should sort by area which sorted ascending order by office area with fid 3125 from the database
When the user clicks on the office search results column area
Then the office search results should sort by area which sorted descending order by office area with fid 3125 from the database

Examples:
|entity|searchBy|fid|
|3125|FID|3125|

Scenario: Verify Office Results by City
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
When the user clicks on the office search results column city
Then the office search results should sort by city which sorted ascending order by office city with fid 3125 from the database
When the user clicks on the office search results column city
Then the office search results should sort by city which sorted descending order by office city with fid 3125 from the database

Examples:
|entity|searchBy|fid|
|3125|FID|3125|

Scenario: Verify the sorting office results by country
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the office search results country column
Then the user should see the office search results cards sorted ascending order by office country
When the user navigates to the 3rd page on the office search results
When the user clicks on the office search results country column
Then the user should see the office search results cards sorted descending order by office country
Then the user should see office search results reset to page 1

Examples:
|entity|searchBy|fid|
|1645|FID|1645|

Scenario: Verify Office Results Pagination and Counter
Meta:@runThis3
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
When the user clicks on address label for sorting offices
Then the user should see the office search results sorted ascending by addressLine1 from trusted document
When the user clicks on address label for sorting offices
Then the user should see the office search results sorted descending by addressLine1 from trusted document
When the user clicks on address label for sorting offices
Then the user should see the office search results sorted ascending by addressLine1 from trusted document



Examples:
|entity|searchBy|fid|
|113461|FID|113461|