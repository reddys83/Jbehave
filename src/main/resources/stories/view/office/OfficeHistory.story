Meta:@OfficeHistory @Office @View

Narrative:
In order to view and edit the legalEntity
As a user
I want to cover the requirements mentioned in
JIRA ID - ZEUS-539 - User can view office history

Scenario: Verify office's history
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
And the user clicks on the office history link in the navigation bar

Then the user should see the office's history as:
|SUMMARY|
|Holds a free-text summarisation of the events that have affected this office. Bank was formed blah-di-blah|

Examples:
|entity|searchBy|fid|officeFid|
|299676|FID|299676|299676-0|

Scenario: Verify no history for office
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
And the user clicks on the office history link in the navigation bar

Then the user should not see the office's history

Examples:
|entity|searchBy|fid|officeFid|
|1038|FID|1038|1038-0|
