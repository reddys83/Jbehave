Meta:@EditLegalEntityBasicInfo @Edit @legalEntity

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal
JIRA ID - ZEUS-906 - User can edit Legal Entity's Lead Institution flag

Meta:@Design

Scenario: Verify Legal Entity's Status dropdown values from lookup Status in the same order as taxonomy
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the update link
And the user clicks on the Status drop-down in the basicinfo legalentity page
Then the user should see the status values from lookup Status

Examples:
|entity|searchBy|fid|
|1038|FID|1038|


Scenario: Verify that the Status drop-down list should highlight the values that contain characters input by user
a)Type a matching text "i" in the status dropdown and verify that the status "Active" is selected.
b)Type a matching text "a" in the status dropdown and verify that the status "Inactive" is selected.
c)Type a matching text "p" in the status dropdown and verify that the status "Pending" is selected.
d)Type a unmatching text "x" in the status dropdown and verify that the previously selected status "Pending" is still selected.

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the update link
And the user starts typing the name of a status as i in the Status drop-down
Then the user should see the selected status in the drop-down as Inactive
When the user starts typing the name of a status as a in the Status drop-down
Then the user should see the selected status in the drop-down as Active
When the user starts typing the name of a status as p in the Status drop-down
Then the user should see the selected status in the drop-down as Pending
When the user starts typing the name of a status as x in the Status drop-down
Then the user should see the selected status in the drop-down as Pending
When the user starts typing the name of a status as a in the Status drop-down
Then the user should see the selected status in the drop-down as Active

Examples:
|entity|searchBy|fid|
|1038|FID|1038|
Scenario: User will see summary of changes made in confirmation modal
Meta:
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the update link
And the user selects a non-default value from Status drop-down in the basicinfo legalentity page
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

Scenario: Edit and Save Legal Entity's Status value in the basicinfo legalentity page
a) Veriy that the default value of status during edit matches with the status of the trusted document
b) Upate the status with a new value and verify it is updated in zeus document
c) Upate the status with the same existing value and verify the existing value in zeus document
d) verify that the status can be changed to all 3 values active,inactive and pending

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the update link
Then the user should see the status value as in trusted document with fid <fid>
When the user gets the document with get Id for legalentity with the fid as <entity> from the database
And the user selects value as <status> from Status drop-down in the basicinfo legalentity page
And the user clicks on the save button
Then the user should see the save confirmation modal
When the user clicks on the confirm button
Then the user should see status value as <status> for fid <fid> in zeus document
And the user reverts the changes to the document

Examples:
|entity|searchBy|fid|status|
|1038|FID|1038|inactive|
|1038|FID|1038|active|
|1038|FID|1038|pending|

