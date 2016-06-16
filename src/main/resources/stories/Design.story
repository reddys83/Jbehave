Meta:@Design

Scenario: User can edit Legal Entity's identifiers-Verify error message required for both value and status fields
Verify that the User should see Required error message for both value and status fields when selects a value for type but keeps the value and status as blank
User should see Required error message for both type and status when enters a value for value but keeps the type and status as blank
User should see Required error message for both value and type when selects a status for Value but keeps the Agency and Type as blank

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the legal entity identifier link in the navigation bar
And the user clicks on the legalEntity update link
When the user gets the document with get Id for legalentity with the fid as <entity> from the database
And the user clicks on the add new identifiers button
And the user selects identifier type as <identifierType> from legalEntity_new_row_identifier_type_dropdown in the legalentity page
And the user selects identifier status as <identifierStatus> from legalEntity_new_row_identifier_status_dropdown in the legalentity page
And the user clicks on the save button
Then the user should see the error message Enter up to 50 valid characters for the identifier value field
And the user should see the error message at top of page the highlighted fields must be addressed before this update can be saved
When the user clicks on the delete button legalEntity_first_row_new_delete_identifiers_button in the legal entity identifiers section
And the user clicks on the yes button in the delete row confirmation modal in the legal entity basic info page
And the user clicks on the add new identifiers button
And the user selects identifier type as <identifierType> from legalEntity_first_row_new_identifier_type_dropdown in the legalentity page
And the user enters identifier value as <value> for legalEntity_first_row_new_identifier_value
And the user clicks on the save button
Then the user should see the error message required for the identifier status field
And the user should see the error message at top of page the highlighted fields must be addressed before this update can be saved
When the user clicks on the delete button legalEntity_first_row_new_delete_identifiers_button in the legal entity identifiers section
And the user clicks on the yes button in the delete row confirmation modal in the legal entity basic info page
And the user clicks on the add new identifiers button
And the user enters identifier value as <value> for legalEntity_first_row_new_identifier_value
And the user selects identifier status as <identifierStatus> from legalEntity_first_row_new_identifier_status_dropdown in the legalentity page
And the user clicks on the save button
Then the user should see the error message required for the identifier type field

Examples:
|entity|searchBy|fid|identifierType|value|identifierStatus|
|1010|FID|1010|CertificateNo|dgfjhkjklgk1124|Active|
