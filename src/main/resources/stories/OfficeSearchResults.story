Meta:@OfficeSearchResults @Office

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal
JIRA ID - ZEUS-430 - User view list of offices in legal entity

Scenario: Verify Office Results
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
Then the user should see the office search results card for the searched legal entity
|ID|NAME|ADDRESS|CITY|AREA|COUNTRY|TYPE|STATUS|
|951-0|Flughofstrasse|Flughofstrasse 35|Glattbrugg|Zürich|Switzerland|Head Office|active|
|951-4|Flughofstrasse|Flughofstrasse 35|Glattbrugg|Zürich|Switzerland|Head Office Branch|active|

Then the user should see the office search results paginated
And the user should see the offices number of records displayed in the page w.r.t total search results
And the user should see the option to navigate to the desired office search results page

Examples:
|entity|searchBy|fid|
|951|FID|951|

Scenario: Verify Office Results Pagination and Counter
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
Then the user should see the office search results paginated
And the user should see the offices number of records displayed in the page w.r.t total search results
And the user should see the option to navigate to the desired office search results page

Examples:
|entity|searchBy|fid|officeFid|
|1038|FID|951|1038|

Scenario: Verify Only 1 Office Results
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
Then the user should see the office search results card for the searched legal entity
|ID|NAME|ADDRESS|CITY|AREA|COUNTRY|TYPE|STATUS|
|189457-0||PO Box 8036|Zürich||Switzerland|Head Office|active|

Then the user should see the office search results paginated
And the user should see the offices number of records displayed in the page w.r.t total search results
And the user should see the option to navigate to the desired office search results page

Examples:
|entity|searchBy|fid|
|189457|FID|189457|

Scenario: Verify Only 7 Office Results Pages
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
Then the user should see the office search results paginated
And the user should see the option to navigate to the desired office search results page

Examples:
|entity|searchBy|fid|
|41031|FID|41031|

Scenario: Navigate through search results and verify pagination
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
Then the user should see the option to navigate to the desired office search results page
When the user navigates to the 5th page on the office search results
Then the user should see the option to navigate to the desired office search results page
When the user navigates to the last page on the office search results
Then the user should see the option to navigate to the desired office search results page

Examples:
|entity|searchBy|fid|
|1038|FID|1038|1038|

Scenario: Verify pagination next and previous navigation link
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user navigates to the office search results next page
Then the user should see the option to navigate to the desired office search results page
When the user navigates to the office search results previous page
Then the user should see the option to navigate to the desired office search results page

Examples:
|entity|searchBy|fid|
|1038|FID|1038|1038|