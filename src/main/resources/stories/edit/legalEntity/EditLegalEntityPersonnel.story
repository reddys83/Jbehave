Meta:@EditLegalEntityPersonnel @Edit @LegalEntity

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal
JIRA ID - ZEUS-917 - User can edit Legal Entity's Personnel Summaries

Scenario: Verify edit legalEntity personnel TYPE values are from PERSONNEL_SUMMARY_TEXT_TYPE for exisiting field
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
Then the user should see the message you can search for a legal entity at any time using the header search
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
When the user clicks on the legal entity personnel link in the navigation bar
And the user clicks on the legalEntity update link
And the user clicks on the type dropdown in legalEntity personnel for legalEntity_personnel_first_existing_type_dropdown_edit_xpath
Then the user should see the legalEntity personnel type values from lookup PERSONNEL_SUMMARY_TEXT_TYPE

Examples:
|entity|searchBy|fid|
|1165|FID|1165|


Scenario: Verify edit legalEntity personnel TYPE values are from PERSONNEL_SUMMARY_TEXT_TYPE for new field
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
Then the user should see the message you can search for a legal entity at any time using the header search
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
When the user clicks on the legal entity personnel link in the navigation bar
And the user clicks on the legalEntity update link
And the user clicks on the add new personnel button in legalEntity
And the user clicks on the type dropdown in legalEntity personnel for legalEntity_personnel_first_new_type_dropdown_edit_xpath
Then the user should see the legalEntity personnel type values from lookup PERSONNEL_SUMMARY_TEXT_TYPE

Examples:
|entity|searchBy|fid|
|1038|FID|1038|

Scenario: Verify error message for value field
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
Then the user should see the message you can search for a legal entity at any time using the header search
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
When the user clicks on the legal entity personnel link in the navigation bar
And the user clicks on the legalEntity update link
And the user clicks on the add new personnel button in legalEntity
And the user selects type <type> in the legalEntity personnel for legalEntity_personnel_first_new_type_dropdown_edit_xpath
And the user clicks on the save button
Then the user should see the error message enter up to 10000 valid characters for value in legalentity personnel

Examples:
|entity|searchBy|fid|type|
|1038|FID|1038|InstitutionEmployees|


Scenario: Verify the error message for value field for invalid charecter.
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
When the user clicks on the legal entity personnel link in the navigation bar
And the user clicks on the legalEntity update link
And the user clicks on the add new personnel button in legalEntity
And the user enters more than 10000 character in value for legalEntity personnel
And the user clicks on the save button
Then the user should see the error message enter up to 10000 valid characters for value in legalentity personnel

Examples:
|entity|searchBy|fid|
|1165|FID|1165|

Scenario: Verify REQUIRED error message for Type dropdwon
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
Then the user should see the message you can search for a legal entity at any time using the header search
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
When the user clicks on the legal entity personnel link in the navigation bar
And the user clicks on the legalEntity update link
And the user clicks on the add new personnel button in legalEntity
And the user enters value as <value> in the legalEntity personnel
And the user clicks on the save button
Then the user should see the error message required for type in legalEntity personnel

Examples:
|entity|searchBy|fid|value|
|1038|FID|1038|200|

Scenario: Verify successfull save with valid inputs for type and value in legalEntity personnel
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
Then the user should see the message you can search for a legal entity at any time using the header search
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
When the user clicks on the legal entity personnel link in the navigation bar
And the user clicks on the legalEntity update link
When the user gets the document with get Id for legalentity with the fid as <entity> from the database
And the user clicks on the add new personnel button in legalEntity
And the user selects type <type> in the legalEntity personnel for legalEntity_personnel_first_new_type_dropdown_edit_xpath
And the user enters value as <value> in the legalEntity personnel
And the user clicks on the save button
Then the user should see the save confirmation modal
When the user clicks on the confirm button
Then the user should see the edits to legal entity personnel for fid <fid> in zeus document
Then the user reverts the changes to the document


Examples:
|entity|searchBy|fid|type|value|
|1038|FID|1038|InstitutionEmployees|8094|