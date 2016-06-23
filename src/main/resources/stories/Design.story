Meta:@Design



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