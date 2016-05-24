Meta:@EditLegalEntityCreditRatings @Edit @LegalEntity

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal
JIRA ID - ZEUS-911 - User can edit Legal Entity's Credit Ratings

Scenario: Verify Legal Entity's Credit Ratings Agency and Type dropdown values are
from lookup CREDIT_RATING_AGENCY and CREDIT_RATING_TYPE respectively in the same order as taxonomy
a) Verify for an existing CreditRating's row, the Credit Rating's Agency values are from CREDIT_RATING_AGENCY
b) Verify for an existing CreditRating's row, the Credit Rating's Type values are from CREDIT_RATING_TYPE
c) Verify for a new CreditRating's row, the Credit Rating's Agency values are from CREDIT_RATING_AGENCY
c) Verify for a new CreditRating's row, the Credit Rating's Type values are from CREDIT_RATING_TYPE

Meta:@runme
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the legalEntity update link
And the user clicks on the legal entity credit rating link in the navigation bar
And the user clicks on the first_existing_creditrating_Agency_dropdown in the basicinfo legalentity page
Then the user should see the first_existing_creditrating_Agency_dropdown values in credit rating's section from lookup CREDIT_RATING_AGENCY
Then the user should see the first_existing_creditrating_Agency_dropdown values in credit rating's section from lookup CREDIT_RATING_AGENCY


Examples:
|entity|searchBy|fid|
|1717|FID|1717|

Scenario: Verify for a new row, Legal Entity's Entity Type dropdown values from lookup LEGAL_ENTITY_CATEGORY in the same order as taxonomy except those that have already been selected for this Legal Entity

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the legalEntity update link
And the user clicks on the add new entity type button
And the user clicks on the first_new_entitytype_dropdown in the basicinfo legalentity page
Then the user should see the first_new_entitytype_dropdown values from lookup LEGAL_ENTITY_CATEGORY except the values that are selected already

Examples:
|entity|searchBy|fid|
|1717|FID|1717|

Scenario: Update and Save existing legal Entity type
a) Select a non-Blank value and Save. Verify the value is saved in Zeus document
b) Select a null value and Save. Verify that null value is not saved.

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the legalEntity update link
Then the user should see the entityType value as in trusted document with fid <fid>
When the user gets the document with get Id for legalentity with the fid as <entity> from the database
And the user selects entity type value as <entityTypeValue> from first_existing_entitytype_dropdown in the basicinfo legalentity page
And the user clicks on the save button
Then the user should see the save confirmation modal
And the user should see the below summary changes in confirmation modal
|Summary|
|Basic Info / Entity Types|
|Basic Info|

When the user clicks on the confirm button
Then the user should see entityType value as <entityTypeValue> for fid <fid> in zeus document
Then the user should not see the deleted entity type value Bank in the zeus document for fid <fid>
Then the user reverts the changes to the document

Examples:
|entity|searchBy|fid|entityTypeValue|
|1165|FID|1165|ATM Network|
|1165|FID|1165||

Scenario: Add a new legal entity type row and Save
a) Select a non-Blank value and Save. Verify the value is saved in Zeus document
b) Select a null value and Save. Verify that null value is not saved.

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the legalEntity update link
When the user gets the document with get Id for legalentity with the fid as <entity> from the database
And the user clicks on the add new entity type button
And the user selects entity type value as <entityTypeValue> from first_new_entitytype_dropdown in the basicinfo legalentity page
And the user clicks on the save button
Then the user should see the save confirmation modal
When the user clicks on the confirm button
Then the user should see entityType value as <entityTypeValue> for fid <fid> in zeus document
Then the user reverts the changes to the document

Examples:
|entity|searchBy|fid|entityTypeValue|
|1165|FID|1165|ATM Network|
|1165|FID|1165||

Scenario:
a) Verify that the delete button is disabled for the first row of legal entity type
b) Verify that the user should get the confirmation window for deleting existing entity type rows and user clicks No button
c) Verify that the user should get the confirmation window for deleting existing entity type rows and user clicks Yes button and row should be deleted

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the legalEntity update link
When the user gets the document with get Id for legalentity with the fid as <entity> from the database
Then the user should see the first_row_existing_entitytype_delete_button in disabled state in entity types section
When the user clicks on the second_row_existing_entitytype_delete_button in entity types section
Then the user should see the delete row confirmation modal in the legal entity page
When the user clicks on the no button in the delete row confirmation modal in the legal entity page
Then the user should still see the second_existing_entitytype_dropdown with value Commercial Bank
When the user clicks on the second_row_existing_entitytype_delete_button in entity types section
When the user clicks on the yes button in the delete row confirmation modal in the legal entity page
Then the user should not see the second_existing_entitytype_dropdown with value Commercial Bank
When the user clicks on the save button
Then the user should see the save confirmation modal
When the user clicks on the confirm button
Then the user should not see the deleted entity type value Commercial Bank in the zeus document for fid <fid>
Then the user reverts the changes to the document

Examples:
|entity|searchBy|fid|
|1165|FID|1165|

Scenario:
a) Verify that the user should get the confirmation window for deleting new entity type rows and user clicks No button
b) Verify that the user should get the confirmation window for deleting new entity type rows and user clicks Yes button and row should be deleted

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the legalEntity update link
And the user clicks on the add new entity type button
When the user clicks on the first_new_entitytype_delete_button in entity types section
Then the user should see the delete row confirmation modal in the legal entity page
When the user clicks on the no button in the delete row confirmation modal in the legal entity page
Then the user should still see the first_new_entitytype_dropdown in the new row
When the user clicks on the first_new_entitytype_delete_button in entity types section
When the user clicks on the yes button in the delete row confirmation modal in the legal entity page
Then the user should not see the first_new_entitytype_dropdown in the new row

Examples:
|entity|searchBy|fid|
|1165|FID|1165|

Scenario: Verify that the user should get the Required field message when saving an entity type value to null and that is the only entity type exists on the page.

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the legalEntity update link
And the user selects to delete all the entity type rows except the first one
And the user selects entity type value as <entityTypeValue> from first_existing_entitytype_dropdown in the basicinfo legalentity page
And the user clicks on the save button
Then the user should see the error message for the required entity type field in the basic info legal entity page

Examples:
|entity|searchBy|fid|entityTypeValue|
|1165|FID|1165||

Scenario: Verify that the user should see the Required field message against the first row only when user enters null value for all the entity type rows

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the legalEntity update link
And the user enters null value for all the entity type rows
And the user clicks on the save button
Then the user should see the error message for the required entity type field in the basic info legal entity page

Examples:
|entity|searchBy|fid|entityTypeValue|
|1165|FID|1165||

Scenario: Verify that the user should NOT get the Required field message when user enters null value for all the entity type rows except one row

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the legalEntity update link
When the user gets the document with get Id for legalentity with the fid as <entity> from the database
And the user enters null value for all the entity type rows
And the user selects entity type value as <entityTypeValue> from first_existing_entitytype_dropdown in the basicinfo legalentity page
And the user clicks on the save button
Then the user should see the save confirmation modal
When the user clicks on the confirm button
Then the user should see entityType value as <entityTypeValue> for fid <fid> in zeus document
Then the user reverts the changes to the document

Examples:
|entity|searchBy|fid|entityTypeValue|
|1165|FID|1165|ATM Network|



