Meta:@LegalEntityCreditRatings @LegalEntity @View @AllStories

Narrative:
In order to view and edit the legalEntity
As a user
I want to cover the requirements mentioned in
JIRA ID - ZEUS-394 - User can view legalEntity credit ratings

Scenario: Verify legal entity's credit rating.
Meta:
Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the legal entity credit rating link in the navigation bar

Then the user should see the legal entity's credit ratings as:
|AGENCY|TYPE|VALUE|APPLIED DATE|CONFIRMED DATE|
|Fitch|Long Term Rating|A+|15 Apr 2015||
|Fitch|Short Term Rating|F1+|15 Apr 2015||

Examples:
|entity|searchBy|fid|
|Kreissparkasse Göppingen|Name|3125|

Scenario: Verify no legalEntity credit rating.
Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the legal entity credit rating link in the navigation bar
Then the user should not see the legal entity's credit ratings

Examples:
|entity|searchBy|fid|
|Associated Commercial Finance Inc|Name|91832|
