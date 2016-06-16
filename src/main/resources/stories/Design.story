Meta:@Design

Scenario: User can edit Legal Entity's identifiers- Verifying existing row should be deleted by clicking on the yes button in delete confirmation section.
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
|1010|FID|1010|OCC|

