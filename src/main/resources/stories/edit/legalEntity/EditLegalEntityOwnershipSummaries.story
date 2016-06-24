Meta:@EditLegalEntityOwnershipSummaries @Edit @LegalEntity @AllStories

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal
JIRA ID - ZEUS-916 - User can edit Legal Entity's Ownership Summaries

Scenario: Verify Legal Entity's ownership Type dropdown values are from the lookup OWNERSHIP_SUMMARY_TEXT_TYPE in the same order as taxonomy

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the legalEntity update link
And the user clicks on the legal entity ownership link in the navigation bar
Then the user should see the ownership type values for legalEntity_first_row_existing_ownership_type_dropdown from lookup OWNERSHIP_SUMMARY_TEXT_TYPE
When the user clicks on add new ownership summaries button
Then the user should see the ownership type values for legalEntity_first_row_new_ownership_type_dropdown from lookup OWNERSHIP_SUMMARY_TEXT_TYPE

Examples:
|entity|searchBy|fid|
|1717|fid|1717|

Scenario: For existing ownership summary rows, update the Type,Value and click Save. Updated values are updated in zeus document
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the legalEntity update link
And the user clicks on the legal entity ownership link in the navigation bar
Then the user should see the ownership summary values as in trusted document with fid <fid>
When the user gets the document with get Id for legalentity with the fid as <entity> from the database
And the user selects ownership type as <ownershipType> from legalEntity_first_row_existing_ownership_type_dropdown in the legalentity page
And the user enters ownership value as <value> for legalEntity_first_row_existing_ownership_value_textarea
And the user clicks on the save button
Then the user should see the save confirmation modal
When the user clicks on the confirm button
Then the user should see ownership summary values as <ownershipType><value> for fid <fid> in zeus document
Then the user reverts the changes to the document

Examples:
|entity|searchBy|fid|ownershipType|value|
|1717|FID|1717|additional|Co-operative Banking Society with over 100.000 shareholders.|


Scenario: Add a new ownership summary row with Type,Value and click Save. Values are updated in zeus document
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the legalEntity update link
And the user clicks on the legal entity ownership link in the navigation bar
When the user gets the document with get Id for legalentity with the fid as <entity> from the database
When the user clicks on add new ownership summaries button
And the user selects ownership type as <ownershipType> from legalEntity_first_row_new_ownership_type_dropdown in the legalentity page
And the user enters ownership value as <value> for legalEntity_first_row_new_ownership_value_textarea
And the user clicks on the save button
Then the user should see the save confirmation modal
When the user clicks on the confirm button
Then the user should see ownership summary values as <ownershipType><value> for fid <fid> in zeus document
Then the user reverts the changes to the document

Examples:
|entity|searchBy|fid|ownershipType|value|
|1717|FID|1717|additional|Co-operative Banking Society with over 100.000 shareholders.|

Scenario: For existing rows, verify row can be deleted by clicking on the yes button in delete confirmation section.
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the legalEntity update link
And the user clicks on the legal entity ownership link in the navigation bar
When the user gets the document with get Id for legalentity with the fid as <entity> from the database
When the user clicks on the delete button legalEntity_first_row_existing_ownership_summary_delete_button in the legal entity ownership summary section
Then the user should see the delete row confirmation modal in the legal entity page
When the user clicks on the yes button in the delete row confirmation modal in the legal entity basic info page
And the user clicks on the save button
Then the user should see the save confirmation modal
When the user clicks on the confirm button
Then the user should not see ownership summary values for fid <fid> in zeus document as:
|ownershipType|value|
|replacement|Co-operative Banking Society with over 103,500 shareholders|
Then the user reverts the changes to the document
Examples:
|entity|searchBy|fid|
|1717|FID|1717|

Scenario: User can edit Legal Entity's ownership summaries- Verifying new row can be deleted by click on enter on the yes button in delete confirmation section.
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the legalEntity update link
And the user clicks on the legal entity ownership link in the navigation bar
When the user clicks on add new ownership summaries button
When the user clicks on the delete button legalEntity_first_row_new_ownership_summary_delete_button in the legal entity identifiers section
Then the user should see the delete row confirmation modal in the legal entity page
When the user clicks on the yes button in the delete row confirmation modal in the legal entity basic info page
And the user clicks on the save button

Examples:
|entity|searchBy|fid|
|1717|FID|1717|

Scenario: Verify Legal Entity's ownership summary value field max length is 10000
Verify Legal Entity ownership Summary Type is a required field
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the legalEntity update link
And the user clicks on the legal entity ownership link in the navigation bar
When the user clicks on add new ownership summaries button
Then the user should see the ownership summary text area maxlength as 10000 characters for the legalEntity_first_row_new_ownership_value_textarea
When the user selects ownership type as <ownershipType> from legalEntity_first_row_new_ownership_type_dropdown in the legalentity page
And the user enters ownership value as <value> for legalEntity_first_row_new_ownership_value_textarea
When the user clicks on the save button
Then the user should see the error message Required for the ownership summary field legalEntity_ownership_summary_type_Required_error_message_xpath

Examples:
|entity|searchBy|fid|ownershipType|value|
|1717|FID|1717||Co-operative Banking Society with over 100.000 shareholders.|



Scenario: Verify Legal Entity ownership Summary Value is a required field
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the legalEntity update link
And the user clicks on the legal entity ownership link in the navigation bar
When the user clicks on add new ownership summaries button
When the user selects ownership type as <ownershipType> from legalEntity_first_row_new_ownership_type_dropdown in the legalentity page
And the user enters ownership value as <value> for legalEntity_first_row_new_ownership_value_textarea
When the user clicks on the save button
Then the user should see the error message Required for the ownership summary field legalEntity_ownership_summary_value_Required_error_message_xpath

Examples:
|entity|searchBy|fid|ownershipType|value|
|1717|FID|1717|additional||

Scenario: Verify the changes are recognized when deleted all ownership summary rows and the changes are saved in Zeus document
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the legalEntity update link
And the user clicks on the legal entity ownership link in the navigation bar
And the user deletes all the existing ownership summary rows
And the user clicks on the save button
Then the user should see the save confirmation modal
And the user should see the below summary changes in confirmation modal
|Summary|
|Ownership Summaries|
When the user clicks on the confirm button
Then the user should not see ownership summary values for fid <fid> in zeus document as:
|ownershipType|value|
|replacement|Co-operative Banking Society with over 103,500 shareholders|
Then the user reverts the changes to the document
Examples:
|entity|searchBy|fid|
|1717|FID|1717|
