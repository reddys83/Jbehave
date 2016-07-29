Meta:@OfficeSearchResults @Office @View @AllStories

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal
JIRA ID - ZEUS-430 - User view list of offices in legal entity
JIRA ID - ZEUS-549 - User can sort office results by FID [Which includes ZEUS - 666]
JIRA ID - ZEUS-559 - User can open multiple offices in new tabs from results
JIRA ID - ZEUS-617 - list offices types alphabetically when multiple for one office
JIRA ID - ZEUS-690 - Display Location Summary on Office Search screen

Scenario: Verify Office Results
Meta:
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
|951-0|Flughofstrasse|Flughofstrasse 35|Glattbrugg|Zürich|Switzerland|Head Office|Active|
|951-4|Flughofstrasse|Flughofstrasse 35|Glattbrugg|Zürich|Switzerland|Head Office Branch|Active|

Then the user should see the office search results paginated
And the user should see the offices number of records displayed in the page w.r.t total search results
And the user should see the option to navigate to the desired office search results page

Examples:
|entity|searchBy|fid|
|951|FID|951|

Scenario: Verify Office Results Pagination and Counter
Meta:@test40
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
Then the user should see the office search results paginated
And the user should see the click to view tooltip on office search page
And the user should see the offices number of records displayed in the page w.r.t total search results
And the user should see the option to navigate to the desired office search results page

Examples:
|entity|searchBy|fid|
|1038|FID|1038|

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
|189457-0||PO Box 8036|Zürich||Switzerland|Head Office|Active|

Then the user should see the office search results paginated
And the user should see the offices number of records displayed in the page w.r.t total search results
And the user should see the option to navigate to the desired office search results page

When the user clicks on the office search results fid column
Then the user should see the office search results card for the searched legal entity
|ID|NAME|ADDRESS|CITY|AREA|COUNTRY|TYPE|STATUS|
|189457-0||PO Box 8036|Zürich||Switzerland|Head Office|Active|


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
Meta:@test40
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
|1038|FID|1038|

Scenario: Verify pagination next and previous navigation link
Meta:@test40
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
|1038|FID|1038|

Scenario: Navigate through search results and verify pagination
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
When the user navigates to the 5th page on the office search results
When the user clicks on the office search results fid column
Then the user should see the 1st page on the office search results

Examples:
|entity|searchBy|fid|
|1038|FID|1038|1038|


Scenario: Verify the user can open multiple offices in new tabs from results
Meta:
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user right clicks on the office <officeFid> in the office search results
Then the user should see the office header with <entity>, <headOfficeAddress>, <officeFid> and <officeTfpid>

Examples:
|entity|searchBy|fid|officeFid|headOfficeAddress|officeTfpid|
|Bank of America National Association|Name|1038|1038-51|||

Scenario: Verify a single Office lcoation summary on Office Search Results page
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
Then the user should see the office location summaries for fid <fid> from trusted document

Examples:
|entity|searchBy|fid|
|Kreissparkasse Göppingen|Name|3125|


Scenario: Verify multiple Office lcoation summaries on Office Search Results page
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
Then the user should see the office location summaries for fid <fid> from trusted document

Examples:
|entity|searchBy|fid|
|1350|FID|1350|


Scenario: Verify no Office location summary on Office Search Results page
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
Then the user should not see the office's location summary

Examples:
|entity|searchBy|fid|
|Associated Commercial Finance Inc|Name|91832|