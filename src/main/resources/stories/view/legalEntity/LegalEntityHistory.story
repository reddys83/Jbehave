Meta:@LegalEntityHistory @LegalEntity @View @AllStories

Narrative:
In order to view and edit the legalEntity
As a user
I want to cover the requirements mentioned in
JIRA ID - ZEUS-400 User can view legalEntity history

Scenario: Verify legal entity's history
Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the legal entity history link in the navigation bar

Then the user should see the legal entity's history as:
|SUMMARY|
|On June 30, 2007 Mellon Funds Distributor LP and MBSC LLC merged into Dreyfus Service Corporation and name changed as above. On December 1, 2009 Founders Asset Management LLC merged into the above|


Examples:
|entity|searchBy|fid|
|MBSC Securities Corporation|Name|94365|


Scenario: Verify no history for legalEntity

Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the legal entity history link in the navigation bar
Then the user should not see the legal entity's history

Examples:
|entity|searchBy|fid|
|Associated Commercial Finance Inc|Name|91832|

Scenario: Verify that the history is the default section for an inactive legal entity. User can select other sections

Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
Then the user should see the history for the legal entity
When the user clicks on the basic info link in the navigation bar
Then the user should see the basic info label for selected legal entity

Examples:
|entity|searchBy|fid|
|295783|FID|295783|
