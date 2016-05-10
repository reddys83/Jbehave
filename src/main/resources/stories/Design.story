Meta:@Design

Scenario: ZEUS-77 - Verify the type dropDown from names in legalEntity basic info

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the update link
When the user gets the document with get Id for legalentity with the fid as <entity> from the database
And the user clicks on the add new name button in the basic info legal entity page
And the user clicks on new legal entity names type drop-down
Then the user should see the legal entity names types from lookup LEGAL_ENTITY_NAME_TYPE
When the user selects names type <legalEntityNameType> in the basic info legal entity page
And the user enters names value <legalEntityNameValue> in the basic info legal entity page
And the user clicks on the save button
Then the user should see the save confirmation modal
When the user clicks on the confirm button
Then the user should see the edits to legal entity names in zeus document
And the user reverts the changes to the document

Examples:
|entity|searchBy|fid|legalEntityNameType|legalEntityNameValue|
|1165|FID|1165|Former Name|Collins|

Scenario: verify the required message for legalEntiy names type, value.
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the update link
And the user clicks on the add new name button in the basic info legal entity page
And the user clicks on new legal entity names type drop-down
When the user selects names type <legalEntityNameType> in the basic info legal entity page
And the user enters names value <legalEntityNameValue> in the basic info legal entity page
And the user clicks on the save button
Then the user should see the error message required for the type and value fields of legal entity names

Examples:
|entity|searchBy|fid|legalEntityNameType|legalEntityNameValue|
|11621|FID|11621|||

Scenario: Verify the delete confirmation modal
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the update link
And the user clicks on the add new name button in the basic info legal entity page
And the user clicks on new legal entity names type drop-down
And the user clicks on delete legal entity names option
Then the user should see the delete row confirmation modal in the legal entity page
When the user clicks on the no button in the delete row confirmation modal in the legal entity basic info page
Then the user should see the newly added names in the legal entity basic info page
When the user clicks on delete legal entity names option
When the user clicks on the yes button in the delete row confirmation modal in the legal entity basic info page
Then the user should not see the newly added names in the legal entity basic info page

Examples:
|entity|searchBy|fid|
|11621|FID|11621|

Scenario: Verify the delete icon should not present for type Legal Title
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the update link
Then the user should not see the delete button for legal tiltle in names for legal entity

Examples:
|entity|searchBy|fid|
|11621|FID|11621|

Scenario: verify the length for value and user should see the validation error when user enters more than 200 charecters
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the update link
And the user clicks on the add new name button in the basic info legal entity page
And the user enters more than 200 characters in legal entity names value
And the user clicks on the save button
Then the user should see the error message enter up to 200 valid characters for value in the legal entity page

Examples:
|entity|searchBy|fid|
|11621|FID|11621|