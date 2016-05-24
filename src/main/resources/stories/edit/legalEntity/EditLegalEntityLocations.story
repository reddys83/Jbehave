Meta:@EditLegalEntityLocations @Edit @LegalEntity @AllStories

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal
JIRA ID - ZEUS-909 - User can edit Legal Entity's Location Summaries

Scenario: Verify legalEntity location summary type values are coming from LOCATION_SUMMARY_TEXT_TYPE look up table for new and existing row
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
When the user clicks on the legal entity locations link in the navigation bar
And the user clicks on the legalEntity update link
And the user clicks on the type dropdown in legalEntity locations
Then the user should see the legalentity's location summary type values from lookup LOCATION_SUMMARY_TEXT_TYPE
When the user clicks on the add new location summary button in legalentity location
And the user clicks on the type dropdown in legalEntity locations
Then the user should see the legalentity's location summary type values from lookup LOCATION_SUMMARY_TEXT_TYPE

Examples:
|entity|searchBy|fid|
|1717|FID|1717|

Scenario: Verify the Required error message for legalEntity location type drop down for new and existing row
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
When the user clicks on the legal entity locations link in the navigation bar
And the user clicks on the legalEntity update link
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

Scenario: Verify the Enter up to 10000 valid characters error message for legalEntity location value textbox for new and existing row
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
When the user clicks on the legal entity locations link in the navigation bar
And the user clicks on the legalEntity update link
And the user enters more than 10000 characters in value for legalEntity location summary
And the user clicks on the save button
Then the user should see the error message enter up to 10000 valid characters for value in the legalentity location
When the user clicks on the add new location summary button in legalentity location
And the user enters more than 10000 characters in value for legalEntity location summary
And the user clicks on the save button
Then the user should see the error message enter up to 10000 valid characters for value in the legalentity location

Examples:
|entity|searchBy|fid|
|1717|FID|1717|

Scenario: Verify the edits save in ZEUS document upon valid inputs for existing row
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
When the user clicks on the legal entity locations link in the navigation bar
And the user clicks on the legalEntity update link
When the user gets the document with get Id for legalentity with the fid as <entity> from the database
And the user select type as <type> in the legalentity location summary
And the user enters value as <value> in the legalentity location summary
And the user clicks on the save button
Then the user should see the save confirmation modal
When the user clicks on the confirm button
Then the user should see the edits to legal entity location summary for fid <fid> in zeus document
Then the user reverts the changes to the document

Examples:
|entity|searchBy|fid|type|value|
|1717|FID|1717|NumberOfBranches|100|

Scenario: Verify the edits save in zeus upon valid inputs for new row
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
When the user clicks on the legal entity locations link in the navigation bar
And the user clicks on the legalEntity update link
When the user gets the document with get Id for legalentity with the fid as <entity> from the database
When the user clicks on the add new location summary button in legalentity location
And the user select type as <type> in the legalentity location summary
And the user enters value as <value> in the legalentity location summary
And the user clicks on the save button
Then the user should see the save confirmation modal
When the user clicks on the confirm button
Then the user should see the edits to legal entity location summary for fid <fid> in zeus document
Then the user reverts the changes to the document

Examples:
|entity|searchBy|fid|type|value|
|1717|FID|1717|NumberOfBranches|100|

Scenario: The user should see the confirmation modal to delete places row message Please confirm - would you like to delete this row?
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
When the user clicks on the legal entity locations link in the navigation bar
And the user clicks on the legalEntity update link
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

