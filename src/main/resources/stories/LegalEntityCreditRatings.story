Meta:@LegalEntityCreditRatings  @LegalEntity

Narrative:
In order to view and edit the legalEntity
As a user
I want to cover the requirements mentioned in
JIRA ID - ZEUS-394 - User can view legalEntity credit ratings

Scenario: Verify legalEntity's credit rating.
Meta:
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legalEntity tab in the data area
And the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
Then the user should see the search results for the institution
When the user clicks on the search results card with fid 3125
And the user clicks on the legalEntity credit rating link in the navigation bar

Then the user should see the legalEntity credit ratings as:
|AGENCY|TYPE|VALUE|APPLIED DATE|CONFIRMED DATE|
|Fitch|Long Term Rating|A+|23 Mar 2015|22 Oct 2015|
|Fitch|Short Term Rating|F1+|23 Mar 2015||

Examples:
|entity|searchBy|
|Kreissparkasse Göppingen|Name|

Scenario: Verify no legalEntity credit rating.
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legalEntity tab in the data area
And the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
Then the user should see the search results for the institution
When the user clicks on the search results card with fid 91832
And the user clicks on the legalEntity credit rating link in the navigation bar

Then the user should not see the legalEntity credit ratings

Examples:
|entity|searchBy|
|Associated Commercial Finance Inc|Name|
