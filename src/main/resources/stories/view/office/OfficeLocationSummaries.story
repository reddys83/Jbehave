Meta:@OfficeLocationSummaries @Office @View

Narrative:
In order to view and edit the office
As a user
I want to cover the requirements mentioned in
JIRA ID - ZEUS-690 - Display Location Summary on Office Search screen

Scenario: Verify a single Office lcoation summaries on Office Search Results page
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
Then the user should see the office's location summary as:

LABEL|TYPE|VALUE|
LOCATION SUMMARY|NumberOfBranches|76|

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
Then the user should see the office's location summary as:

LABEL|TYPE1|VALUE1|TYPE2|VALUE2|
LOCATION SUMMARY|BranchSummary|USA 3|BranchSummary|USA 4|

Examples:
|entity|searchBy|fid|
|26065|FID|26065|

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