Meta:@Design

Scenario: The user should see the confirmation modal to delete places row message Please confirm - would you like to delete this row?
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
When the user clicks on the legal entity locations link in the navigation bar
And the user clicks on the update link
When the user gets the document with get Id for legalentity with the fid as <entity> from the database
When the user clicks on the add new location summary button in legalentity location
And the user select type as <type> in the legalentity location summary
And the user enters value as <value> in the legalentity location summary
And the user clicks on delete button for legal entity location summary
Then the user should see the delete row confirmation modal in the legalEntity page
When the user clicks on the no button in the delete row confirmation modal in the legalEntity page
Then the user should see the newly added legalentity location summary
When the user clicks on delete button for legal entity location summary
When the user clicks on the yes button in the delete row confirmation modal in the legalEntity page
Then the user should not see the newly added legalentity location summary


Examples:
|entity|searchBy|fid|type|value|
|1717|FID|1717|NumberOfBranches|100|
