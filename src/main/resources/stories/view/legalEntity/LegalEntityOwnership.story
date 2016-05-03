Meta:@LegalEntityOwnership @LegalEntity @View

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal
JIRA ID - ZEUS-394 - User can view legalEntity credit ratings

Scenario: Verify legal entity's ownership.
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the legal entity ownership link in the navigation bar

Then the user should see the legal entity's ownership as:
|TYPE|VALUE|
|replacement|Common shareholders resident in Canada 85.6%; United States 10.4% and other countries 4.0%|


Examples:
|entity|searchBy|fid|
|1124|FID|1124|

Scenario: Verify no legal entity's ownership.
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the legal entity ownership link in the navigation bar
Then the user should not see the legal entity's ownership

Examples:
|entity|searchBy|fid|
|312461|FID|312461|