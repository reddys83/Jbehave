Meta:@EditLegalEntityIdentifiers @Edit @LegalEntity @AllStories

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario:User can edit Legal Entity's identifiers
Verify Legal Entity's identifiers Type and Status dropdown values are
from lookup THIRD_PARTY_IDENTIFIER_LEGAL_ENTITY and STATUS respectively in the same order as taxonomy
a) Verify for an existing Legal Entity's identifiers row, the Legal Entity's identifier Type values are from THIRD_PARTY_IDENTIFIER_LEGAL_ENTITY
b) Verify for an existing Legal Entity's identifiers row, the Legal Entity's identifier Status values are from STATUS
c) Verify for a new Legal Entity's identifiers row, the Legal Entity's identifier Type values are from THIRD_PARTY_IDENTIFIER_LEGAL_ENTITY
c) Verify for a new Legal Entity's identifiers row, the Legal Entity's identifier Status values are from STATUS

Meta:@runraju
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the legalEntity update link
And the user clicks on the legal entity identifier link in the navigation bar
And the user clicks on the first_row_existing_identifier_type_dropdown in the legalentity identifier type section
Then the user should see the identifier values for first_row_existing_identifier_type_dropdown from lookup THIRD_PARTY_IDENTIFIER_LEGAL_ENTITY except the values that are selected already
When the user clicks on the first_row_existing_identifier_status_dropdown in the legalentity identifier status section
Then the user should see the status values for first_row_existing_identifier_status_dropdown from lookup STATUS

Examples:
|entity|searchBy|fid|
|1010|fid|1010|

Scenario: Update and Save existing legal Entity identifier type
a) Select a non-Blank value and Save. Verify the value is saved in Zeus document
b) Select a null value and Save. Verify that null value is not saved.

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the legal entity identifier link in the navigation bar
And the user clicks on the update link
When the user gets the document with get Id for legalentity with the fid as <entity> from the database
And the user selects Identifier type value as <identifierTypeValue> from first_new_entitytype_dropdown in the legalentity page
And the user clicks on the save button
Then the user should see the save confirmation modal
And the user should see the below summary changes in confirmation modal
|Summary|
|Basic Info /identifier Types|
|Basic Info|

When the user clicks on the confirm button
Then the user should see identifierType value as <identifierTypeValue> for fid <fid> in zeus document
Then the user should not see the deleted entity type value Bank in the zeus document for fid <fid>
Then the user reverts the changes to the document

Examples:
|entity|searchBy|fid|identifierTypeValue|
|1010|FID|1010|CUNA ID Number|
|1010|FID|1010||

Scenario: Add a new legal entity type row and Save
a) Select a non-Blank value and Save. Verify the value is saved in Zeus document
b) Select a null value and Save. Verify that null value is not saved.
Meta:@runraju1
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the legal entity identifier link in the navigation bar
And the user clicks on the update link
When the user gets the document with get Id for legalentity with the fid as <entity> from the database
And the user clicks on the add new identifiers button
And the user selects Identifier type value as <identifierTypeValue> from first_new_entitytype_dropdown in the legalentity page
And the user clicks on the save button
And the user clicks on the confirm button
Then the user should see identifierType value as <identifierTypeValue> for fid <fid> in zeus document
Then the user reverts the changes to the document

Examples:
|entity|searchBy|fid|identifierTypeValue|
|1010|FID|1010|The Global Markets Entity Identifier (GMEI)|
|1010|FID|1010||


Scenario: Update and Save existing credit ratings-User selects a new value for Type, Value,and Status and click Save. Updated Identifier should be saved in Zeus document

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the legal entity identifier link in the navigation bar
And the user clicks on the update link
Then the user should see the identifier type as in trusted document with fid <fid>
When the user gets the document with get Id for legalentity with the fid as <entity> from the database
And the user selects Identifier type value as <identifierTypeValue> from first_new_entitytype_dropdown in the legalentity page
And the user selects identifier status as <identifierStatus> from first_row_existing_status_dropdown in the legalentity page
And the user enters identifier value $identifierValueRowIdentifier value as <value>
And the user clicks on the save button
Then the user should see the save confirmation modal
When the user clicks on the confirm button
Then the user should see identifier values as <type><value><status> for fid <fid> in zeus document
Then the user reverts the changes to the document

Examples:
|entity|searchBy|fid|type|value|status
|1010|FID|1010|The Global Markets Entity Identifier (GMEI)|Z01RQ8BXBEV51Q8XKV43|Active


Scenario: User can edit Legal Entity's identifiers- Verifying existing row should be deleted by clicking on the yes button in delete confirmation section.
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the legal entity identifier link in the navigation bar
And the user clicks on the update link
When the user clicks on the delete identifier row button in the legal entity basic info page
Then the user should see the delete row confirmation modal in the legal entity page
When the user clicks yes button to delete row
Then the user should not see the newly added identifier row in the basic info legal entity page

Examples:
|entity|SearchBy|fid|
|1010|fid|1010|

Scenario: User can edit Legal Entity's identifiers- Verifying existing row should not be deleted by clicking on the no button in delete confirmation section.
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the legal entity identifier link in the navigation bar
And the user clicks on the update link
When the user clicks on the delete identifier row button in the legal entity basic info page
Then the user should see the delete row confirmation modal in the legal entity page
When the user clicks no button not to delete row
Then the user should see the newly added identifier row in the basic info legal entity page

Examples:
|entity|SearchBy|fid|
|1010|fid|1010|

Scenario: User can edit Legal Entity's identifiers- Verifying new row can be deleted by click on enter on the yes button in delete confirmation section.
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the legal entity identifier link in the navigation bar
And the user clicks on the update link
And the user clicks on the add new identifiers button
When the user clicks on the delete identifier row button in the basic info country page
Then the user should see the delete row confirmation modal in the legal entity page
When the user clicks yes button to delete row
Then the user should not see the newly added identifier row in the basic info legal entity page

Examples:
|entity|SearchBy|fid|
|1010|fid|1010|


Scenario: User can edit Legal Entity's identifiers- Verifying new row can be deleted by click on enter on the no button in delete confirmation section.
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the legal entity identifier link in the navigation bar
And the user clicks on the update link
And the user clicks on the add new identifiers button
When the user clicks on the delete identifier row button in the basic info country page
Then the user should see the delete row confirmation modal in the legal entity page
When the user clicks no button not to delete row
Then the user should not see the newly added identifier row in the basic info country page

Examples:
|entity|SearchBy|fid|
|1010|fid|1010|

Scenario: User can edit Legal Entity's identifiers- Verify Legal Entity's identifier value field max length is 50 error message for enter up to 50 unicode characters only
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the legal entity identifier link in the navigation bar
And the user clicks on the update link
Then the user enters 50 characters in the identifier value on the legal entity page
When the user clicks on the save button
Then the user should see the save confirmation modal
When the user clicks on the confirm button
Then the user reverts the changes to the document
When the user clicks on the legalEntity update link
Then the user enters 51 characters in the identifier value on the legal entity page
When the user clicks on the save button
Then the user should see the error message enter only 50 valid characters for identifier value in the legal entity page


Examples:
|entity|SearchBy|fid|
|1010|fid|1010|

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
And the user clicks on the update link
When the user gets the document with get Id for legalentity with the fid as <entity> from the database
And the user clicks on the add new identifiers button
And the user selects Identifier type value as <identifierTypeValue> from first_new_entitytype_dropdown in the legalentity page
And the user clicks on the save button
Then the user should see the error message Enter up to 50 valid characters for the identifier value field
And the user should see the error message required for the identifier status field
And the user should see the error message at top of page the highlighted fields must be addressed before this update can be saved
When the user clicks on new row delete legal entity identifier button for the row deletebutton Row
And the user clicks on the yes button in the delete row confirmation modal in the legal entity basic info page
And the user clicks on the add new identifiers button
And the user enters identifier value identifierValueRowIdentifier value as <value>
And the user clicks on the save button
Then the user should see the error message Enter up to 50 valid characters for the identifier type field
And the user should see the error message required for the identifier status field
When the user clicks on new row delete legal entity identifier button for the row deletebutton Row
And the user clicks on the yes button in the delete row confirmation modal in the legal entity basic info page
And the user clicks on the add new identifiers button
And the user selects identifier status as <identifierStatus> from first_row_existing_status_dropdown in the legalentity page
And the user clicks on the save button
Then the user should see the error message required for the identifier type field
And the user should see the error message Enter up to 50 valid characters for the identifier value field

Examples:
|entity|searchBy|fid|identifierTypeValue|identifierValueValue|identifierstatusValue|
|1010|FID|1010|CertificateNo|||||
|1010|FID|1010|||r4t5b4h544|||
|1010|FID|1010|||||Active|


