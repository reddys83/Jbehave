Meta:@EditLegalEntityBasicInfo @Edit @legalEntity

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal
JIRA ID - ZEUS-906 - User can edit Legal Entity's Lead Institution flag

Scenario: Verify Legal Entity's Fatca Status dropdown values from lookup LEGAL_ENTITY_FATCA_STATUS in the same order as taxonomy
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the update link
And the user clicks on the Fatca Status drop-down in the basicinfo legalentity page
Then the user should see the Fatca status values from lookup LEGAL_ENTITY_FATCA_STATUS

Examples:
|entity|searchBy|fid|
|1038|FID|1038|


Scenario: Verify that the Fatca Status drop-down list should highlight the values that contain characters input by user
a)Type a matching text "Non-Repo" in the Fatca status dropdown and verify that the Fatca status "Non-Reporting IGA FFI" is selected.
b)Type a matching text "Non-Par" in the Fatca status dropdown and verify that the Fatca status "Non-Participating FFI" is selected.
c)Type a matching text "Reporting" in the Fatca status dropdown and verify that the Fatca status "Reporting Model 1 FFI" is selected.
d)Type a unmatching text "xyz" in the Fatca status dropdown and verify that the previously selected Fatca status "Reporting Model 1 FFI" is still selected.

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the update link
And the user starts typing the name of a status as Non-Repo in the Fatca Status drop-down
Then the user should see the selected Fatca status in the drop-down as Non-Reporting IGA FFI
When the user starts typing the name of a status as Non-Par in the Fatca Status drop-down
Then the user should see the selected Fatca status in the drop-down as Non-Participating FFI
When the user starts typing the name of a status as Reporting in the Fatca Status drop-down
Then the user should see the selected Fatca status in the drop-down as Reporting Model 1 FFI
When the user starts typing the name of a status as xyz in the Fatca Status drop-down
Then the user should see the selected Fatca status in the drop-down as Reporting Model 1 FFI

Examples:
|entity|searchBy|fid|
|1038|FID|1038|

Scenario: User will see summary of changes made for Fatca status in confirmation modal
Meta:
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the update link
And the user selects a non-default value from Fatca Status drop-down in the basicinfo legalentity page
And the user clicks on the save button
Then the user should see the save confirmation modal
And the user should see the below summary changes in confirmation modal
|Summary|
|Basic Info|

When the user clicks on the return button
Then the user should return to edit legalentity page mode

Examples:
|entity|searchBy|fid|
|1038|FID|1038|

Scenario: Edit and Save Legal Entity's Fatca Status value (including blank value) in the basicinfo legalentity page
a) Veriy that the default value of Fatca status during edit matches with the Fatca status of the trusted document
b) Upate the Fatca status with a new value and verify it is updated in zeus document
c) Upate the Fatca status with the same existing value and verify the existing value in zeus document
d) verify that the Fatca status can be changed to different values and can be saved

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the update link
Then the user should see the fatcaStatus value as in trusted document with fid <fid>
When the user gets the document with get Id for legalentity with the fid as <entity> from the database
And the user selects value as <fatcastatus> from Fatca Status drop-down in the basicinfo legalentity page
And the user clicks on the save button
Then the user should see the save confirmation modal
When the user clicks on the confirm button
Then the user should see fatcaStatus value as <fatcastatus> for fid <fid> in zeus document
And the user reverts the changes to the document

Examples:
|entity|searchBy|fid|fatcastatus|
|1038|FID|1038|Participating FFI|
|1038|FID|1038|Owner Documented FFI|
|1038|FID|1038|International Organisation|
|1038|FID|1038||

