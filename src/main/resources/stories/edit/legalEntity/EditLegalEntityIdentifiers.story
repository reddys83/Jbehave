Meta:@EditLegalEntityIdentifiers @Edit @LegalEntity @AllStories

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal
JIRA ID - ZEUS-914 - User can edit Legal Entity's Identifiers

Scenario: For existing rows verify Legal Entity's identifiers Type and Status dropdown values are from lookup THIRD_PARTY_IDENTIFIER_LEGAL_ENTITY and STATUS respectively in the same order as taxonomy
a) Verify for an existing Legal Entity's identifiers row, the Legal Entity's ientifier Type values are from THIRD_PARTY_IDENTIFIER_LEGAL_ENTITY
b) Verify for an existing Legal Entity's identifiers row, the Legal Entity's identifier Status values are from STATUS
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the legalEntity update link
And the user clicks on the legal entity identifier link in the navigation bar
And the user clicks on the legalEntity_first_row_existing_identifier_type_dropdown in the legalentity identifier type section
Then the user should see the identifier values for legalEntity_first_row_existing_identifier_type_dropdown from lookup THIRD_PARTY_IDENTIFIER_LEGAL_ENTITY except the values that are selected already
When the user clicks on the legalEntity_first_row_existing_identifier_status_dropdown in the legalentity identifier status section
Then the user should see the status values for legalEntity_first_row_existing_identifier_status_dropdown from lookup STATUS


Examples:
|entity|searchBy|fid|
|1010|fid|1010|

Scenario: For new rows verify Legal Entity's identifiers Type and Status dropdown values are from lookup THIRD_PARTY_IDENTIFIER_LEGAL_ENTITY and STATUS respectively in the same order as taxonomy
a) Verify for a new Legal Entity's identifiers row, the Legal Entity's identifier Type values are from THIRD_PARTY_IDENTIFIER_LEGAL_ENTITY
b) Verify for a new Legal Entity's identifiers row, the Legal Entity's identifier Status values are from STATUS

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the legalEntity update link
And the user clicks on the legal entity identifier link in the navigation bar
When the user clicks on the add new identifiers button
And the user clicks on the legalEntity_first_row_new_identifier_type_dropdown in the legalentity identifier type section
Then the user should see the identifier values for legalEntity_first_row_new_identifier_type_dropdown from lookup THIRD_PARTY_IDENTIFIER_LEGAL_ENTITY except the values that are selected already
When the user clicks on the legalEntity_first_row_new_identifier_status_dropdown in the legalentity identifier status section
Then the user should see the status values for legalEntity_first_row_new_identifier_status_dropdown from lookup STATUS

Examples:
|entity|searchBy|fid|
|1010|fid|1010|

Scenario: For existing rows, update the Type, Value,and Status and click Save. Updated Identifier is verified zeus document

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the legal entity identifier link in the navigation bar
And the user clicks on the legalEntity update link
Then the user should see the identifier type as in trusted document with fid <fid>
When the user gets the document with get Id for legalentity with the fid as <entity> from the database
And the user selects identifier type as <identifierType> from legalEntity_first_row_existing_identifier_type_dropdown in the legalentity page
And the user selects identifier status as <identifierStatus> from legalEntity_first_row_existing_identifier_status_dropdown in the legalentity page
And the user enters identifier value as <value> for legalEntity_first_row_existing_identifier_value
And the user clicks on the save button
Then the user should see the save confirmation modal
When the user clicks on the confirm button
Then the user should see identifier values as <identifierType><value><identifierStatus> for fid <fid> in zeus document
Then the user reverts the changes to the document

Examples:
|entity|searchBy|fid|identifierType|value|identifierStatus|
|1010|FID|1010|OCC|Z01RQ8BXBEV51Q8XKV43|active|


Scenario: For new row, add the Type, Value,and Status and click Save. Updated Identifier is verified zeus document

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
And the user selects identifier type as <identifierType> from legalEntity_first_row_new_identifier_type_dropdown in the legalentity page
And the user selects identifier status as <identifierStatus> from legalEntity_first_row_new_identifier_status_dropdown in the legalentity page
And the user enters identifier value as <value> for legalEntity_first_row_new_identifier_value
And the user clicks on the save button
Then the user should see the save confirmation modal
When the user clicks on the confirm button
Then the user should see identifier values as <identifierType><value><identifierStatus> for fid <fid> in zeus document
Then the user reverts the changes to the document

Examples:
|entity|searchBy|fid|identifierType|value|identifierStatus|
|1010|FID|1010|OCC|Z01RQ8BXBEV51Q8XKV43|active|



Scenario: For existing rows, verify row can be deleted by clicking on the yes button in delete confirmation section.
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the legal entity identifier link in the navigation bar
And the user clicks on the legalEntity update link
When the user clicks on the delete button legalEntity_first_row_existing_delete_identifiers_button in the legal entity identifiers section
Then the user should see the delete row confirmation modal in the legal entity page
When the user clicks on the yes button in the delete row confirmation modal in the legal entity basic info page
And the user clicks on the save button
Then the user should see the save confirmation modal
When the user clicks on the confirm button
Then the user should not see identifier values for fid <fid> in zeus document as:
|identifierType|value|identifierStatus|
|Japan Exchange Group/ Tokyo Stock Exchange|twsa7chswijvposgvgb|Pending|
Then the user reverts the changes to the document
Examples:
|entity|searchBy|fid|
|1010|FID|1010|

Scenario: User can edit Legal Entity's identifiers- Verifying new row can be deleted by click on enter on the yes button in delete confirmation section.
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the legal entity identifier link in the navigation bar
And the user clicks on the legalEntity update link
And the user clicks on the add new identifiers button
When the user clicks on the delete button legalEntity_first_row_new_delete_identifiers_button in the legal entity identifiers section
Then the user should see the delete row confirmation modal in the legal entity page
When the user clicks on the yes button in the delete row confirmation modal in the legal entity basic info page
And the user clicks on the save button
Then the user should see the save confirmation modal
When the user clicks on the confirm button
Then the user should not see identifier values for fid <fid> in zeus document as:
|identifierType|value|identifierStatus|
|Japan Exchange Group/ Tokyo Stock Exchange|twsa7chswijvposgvgb|Pending|
Then the user reverts the changes to the document
Examples:
|entity|searchBy|fid|
|1010|FID|1010|

Scenario: Verify Legal Entity's identifier value field max length is 50

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the legal entity identifier link in the navigation bar
And the user clicks on the legalEntity update link
Then the user should see the identifier type as in trusted document with fid <fid>
When the user clicks on the add new identifiers button
Then the user verifies the identifier value maxlength is 50 for the legalEntity_first_row_new_identifier_value
When the user clicks on the save button
Then the user should see the save confirmation modal
When the user clicks on the confirm button
Then the user reverts the changes to the document

Examples:
|entity|searchBy|fid|
|1010|FID|1010||

Scenario: Verify that the User should see  Enter up to 50 valid characters error message for value field when user selects a value for type and status and leaves the value field blank
User should see Required error message for type field when user enters a value for value and status and leaves the type field blank
User should see Required error message for status field when user selects a type and enters a value but keeps the status field blank

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
And the user selects identifier type as <identifierType> from legalEntity_first_row_new_identifier_type_dropdown in the legalentity page
And the user selects identifier status as <identifierStatus> from legalEntity_first_row_new_identifier_status_dropdown in the legalentity page
And the user clicks on the save button
Then the user should see the error message Enter up to 50 valid characters. for the identifier value field
And the user should see the error message at top of page the highlighted fields must be addressed before this update can be saved
When the user clicks on the delete button legalEntity_first_row_new_delete_identifiers_button in the legal entity identifiers section
And the user clicks on the yes button in the delete row confirmation modal in the legal entity basic info page
And the user clicks on the add new identifiers button
And the user selects identifier type as <identifierType> from legalEntity_first_row_new_identifier_type_dropdown in the legalentity page
And the user enters identifier value as <value> for legalEntity_first_row_new_identifier_value
And the user clicks on the save button
Then the user should see the error message Required for the identifier status field
And the user should see the error message at top of page the highlighted fields must be addressed before this update can be saved
When the user clicks on the delete button legalEntity_first_row_new_delete_identifiers_button in the legal entity identifiers section
And the user clicks on the yes button in the delete row confirmation modal in the legal entity basic info page
And the user clicks on the add new identifiers button
And the user enters identifier value as <value> for legalEntity_first_row_new_identifier_value
And the user selects identifier status as <identifierStatus> from legalEntity_first_row_new_identifier_status_dropdown in the legalentity page
And the user clicks on the save button
Then the user should see the error message Required for the identifier type field

Examples:
|entity|searchBy|fid|identifierType|value|identifierStatus|
|1010|FID|1010|CertificateNo|dgfjhkjklgk1124|active





