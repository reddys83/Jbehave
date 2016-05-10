Meta:@Design

Scenario: Verify the Required error message for legalEntity location type drop down
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
When the user clicks on the legal entity locations link in the navigation bar
And the user clicks on the update link
And the user select type as <type> in the legalentity location summary
And the user clicks on the save button
Then the user should see the error message required for the type in legalentity location summary
When the user clicks on the add new location summary button in legalentity location
And the user enters value as <value> in the legalentity location summary
And the user clicks on the save button
Then the user should see the error message required for the type in legalentity location summary

Examples:
|entity|searchBy|fid|type|value|
|1717|FID|1717||Berlin/Brandenburg 100|
