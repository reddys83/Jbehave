Meta:@EditLegalEntityServices @Edit @LegalEntity @AllStories

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal
JIRA ID - ZEUS-918 - User can edit Legal Entity's Services

Scenario: Verify legalEntity services category,Override,Financial Category and Financial Details values are coming from SERVICE_CATEGORY, FINANCIAL_SERVICE look up tables for new and existing row
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
When the user clicks on the legal entity services link in the navigation bar
And the user clicks on the legalEntity update link
Then the user should see the category dropdown i.e legalEntity_first_row_existing_offeredservices_category_dropdown values from lookup SERVICE_CATEGORY
And the user should see the financial category dropdown i.e legalEntity_first_row_existing_financial_category_dropdown values from lookup FINANCIAL_SERVICE
And the user should see the financial details dropdown i.e legalEntity_first_row_existing_financial_details_dropdown values from lookup FINANCIAL_SERVICE based on the selected value in legalEntity_first_row_existing_financial_category_dropdown
When the user clicks on add new offered services button in the services section of legal Entity page
And the user clicks on add new financial services button in the services section of legal Entity page
Then the user should see the category dropdown i.e legalEntity_first_row_new_offeredservices_category_dropdown values from lookup SERVICE_CATEGORY
And the user should see the financial category dropdown i.e legalEntity_first_row_new_financial_category_dropdown values from lookup FINANCIAL_SERVICE
And the user should see the financial details dropdown i.e legalEntity_first_row_new_financial_details_dropdown values from lookup FINANCIAL_SERVICE based on the selected value in legalEntity_first_row_new_financial_category_dropdown

Examples:
|entity|searchBy|fid|
|1010|FID|1010|


Scenario: Update and Save existing legal Entity services
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
When the user clicks on the legal entity services link in the navigation bar
And the user clicks on the legalEntity update link
Then the user should see the legal entity service values as in trusted document with fid <fid>
When the user gets the document with get Id for legalentity with the fid as <entity> from the database
And the user selects category value as <category> for legalEntity_first_row_existing_offeredservices_category_dropdown
And the user enters override value as <override> for legalEntity_first_row_existing_offeredservices_override_text_field
And the user selects financialCategory value as <financialCategory> for legalEntity_first_row_existing_financial_category_dropdown
And the user selects financialDetails value as <financialDetails> for legalEntity_first_row_existing_financial_details_dropdown
And the user clicks on the save button
Then the user should see the save confirmation modal
When the user clicks on the confirm button
Then the user should see the legal entity service values for fid <fid> in the zeus document as <category><override><financialCategory><financialDetails>
Then the user reverts the changes to the document

Examples:
|entity|searchBy|fid|category|override|financialCategory|financialDetails|
|1010|FID|1010|Swaps|testoverride|Derivatives|Options|

Scenario: Add a new row and Save new legal Entity services
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
When the user clicks on the legal entity services link in the navigation bar
And the user clicks on the legalEntity update link
Then the user should see the legal entity service values as in trusted document with fid <fid>
When the user gets the document with get Id for legalentity with the fid as <entity> from the database
When the user clicks on add new offered services button in the services section of legal Entity page
And the user clicks on add new financial services button in the services section of legal Entity page
And the user selects category value as <category> for legalEntity_first_row_new_offeredservices_category_dropdown
And the user enters override value as <override> for legalEntity_first_row_new_offeredservices_override_text_field
And the user selects financialCategory value as <financialCategory> for legalEntity_first_row_new_financial_category_dropdown
And the user selects financialDetails value as <financialDetails> for legalEntity_first_row_new_financial_details_dropdown
And the user clicks on the save button
Then the user should see the save confirmation modal
When the user clicks on the confirm button
Then the user should see the legal entity service values for fid <fid> in the zeus document as <category><override><financialCategory><financialDetails>
Then the user reverts the changes to the document
Examples:
|entity|searchBy|fid|category|override|financialCategory|financialDetails|
|1010|FID|1010|Swaps|testoverride|Derivatives|Options|

Scenario: Delete and Save existing credit ratings
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
When the user clicks on the legal entity services link in the navigation bar
And the user clicks on the legalEntity update link
When the user gets the document with get Id for legalentity with the fid as <entity> from the database
And the user clicks on delete legal entity offered services button legalEntity_first_row_existing_delete_offeredServices_button
Then the user should see the delete row confirmation modal in the legal entity page
When the user clicks on the yes button in the delete row confirmation modal in the legal entity basic info page
And the user clicks on delete legal entity financial services button legalEntity_first_row_existing_delete_financialServices_button
Then the user should see the delete row confirmation modal in the legal entity page
When the user clicks on the yes button in the delete row confirmation modal in the legal entity basic info page
And the user clicks on the save button
Then the user should see the save confirmation modal
When the user clicks on the confirm button
Then the user should not see legal entity service values for fid <fid> in zeus document as <category><override><financialCategory><financialDetails>
Then the user reverts the changes to the document
Examples:
|entity|searchBy|fid|category|override|financialCategory|financialDetails|
|1010|FID|1010|Correspondent Banking|Banking|Consumer Credit|Visa|

Scenario: Delete newly added services
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
When the user clicks on the legal entity services link in the navigation bar
And the user clicks on the legalEntity update link
When the user gets the document with get Id for legalentity with the fid as <entity> from the database
When the user clicks on add new offered services button in the services section of legal Entity page
And the user clicks on delete legal entity offered services button legalEntity_first_row_new_delete_offeredServices_button
Then the user should see the delete row confirmation modal in the legal entity page
When the user clicks on the yes button in the delete row confirmation modal in the legal entity basic info page
Then the user should not see the new offered services row with legalEntity_first_row_new_offeredservices_category_dropdown
When the user clicks on add new financial services button in the services section of legal Entity page
And the user clicks on delete legal entity financial services button legalEntity_first_row_new_delete_financialServices_button
Then the user should see the delete row confirmation modal in the legal entity page
When the user clicks on the yes button in the delete row confirmation modal in the legal entity basic info page
Then the user should not see the new financial services row with legalEntity_first_row_new_financial_category_dropdown
Examples:
|entity|searchBy|fid|
|1010|FID|1010|

Scenario: Verify Offered Service Category and financial category details fields are required fields.
Override field maximum length is 100 characters.

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
When the user clicks on the legal entity services link in the navigation bar
And the user clicks on the legalEntity update link
When the user gets the document with get Id for legalentity with the fid as <entity> from the database
When the user clicks on add new offered services button in the services section of legal Entity page
When the user clicks on add new financial services button in the services section of legal Entity page
Then the user verifies the override value maxlength is 100 for the row legalEntity_first_row_new_offeredservices_override_text_field
When the user selects category value as <category> for legalEntity_first_row_new_offeredservices_category_dropdown
And the user enters override value as <override> for legalEntity_first_row_new_offeredservices_override_text_field
And the user selects financialCategory value as <financialCategory> for legalEntity_first_row_new_financial_category_dropdown
And the user selects financialDetails value as <financialDetails> for legalEntity_first_row_new_financial_details_dropdown
And the user clicks on the save button
Then the user should see the Required message for offered service category field
And the user should see the Required message for financial details field
Examples:
|entity|searchBy|fid|category|override|financialCategory|financialDetails|
|1010|FID|1010||Banking|Municipal||
