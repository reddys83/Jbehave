Meta:@EditLegalEntityBasicInfo @Edit @legalEntity

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal
JIRA ID - ZEUS-906 - User can edit Legal Entity's Lead Institution flag
JIRA ID - ZUES- 84 - User can update a legal entity's charter type
JIRA ID - ZEUS- 904 - User can edit legal entity's claimed established date
JIRA ID - ZEUS-903 - User can edit Legal Entity's Status
JIRA ID - ZEUS-905 - User can edit Legal Entity's FATCA status
JIRA ID - ZEUS-908 - User can edit Legal Entity's Corporate Statement


Scenario: Verify the default Edit value and Save Lead Institution value for a legal entity on legalEntity page
       a. Select the value as True for Lead Institution flag and Save for a legalEntity with a default value as True or False
       b. Select the value as False for Lead Institution flag and Save for a legalEntity with a default value as True or False
       c. Select the value as True for Lead Institution flag and Save for a legalEntity with a default value as null
       d. Select the value as False for Lead Institution flag and Save for a legalEntity with a default value as null
       e. Do not select any value and Save for a legalEntity with a default value as null
       f. Verify the save confirmation modal
       g. Verify default Lead Institution value while editing the legal entity

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the update link
Then the user should see the legalentity's lead institution value as in trusted document with fid <fid>
When the user gets the document with get Id for legalentity with the fid as <entity> from the database
And the user selects lead institution value <leadInstitutionflag> in the basicinfo legalentity page
And the user clicks on the save button
Then the user should see the save confirmation modal
When the user clicks on the confirm button
Then the user should see leadInstitution value as <leadInstitutionflag> for fid <fid> in zeus document
And the user reverts the changes to the document

Examples:
|entity|searchBy|fid|leadInstitutionflag|
|1038|FID|1038|true|
|1038|FID|1038|false|
|1165|FID|1165|true|
|1165|FID|1165|false|
|1165|FID|1165||

Scenario: Verify that the Lead Institution label is not shown during edit mode for a legal entity which do not have a lead Institution
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the update link
Then the user should not see lead institution label and value

Examples:
|entity|searchBy|fid|
|128|FID|128|

Scenario:User will get warning if click away from screen they are editing
Meta:
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the update link
When the user clicks on the currency tab in the data area
Then the user should see the cancel update confirmation modal
When the user clicks on the cancel no button
Then the user should return to edit legalentity page mode
When the user clicks on the currency tab in the data area
Then the user should see the cancel update confirmation modal
When the user clicks on the cancel yes button
And the user clicks on the choose a currency option in the currency page
And the user enters the currency <currency> in the typeahead box in the currency page
Then the user should see the currency page

Examples:
|entity|searchBy|fid|leadInstitutionflag|currency|
|1038|FID|1038|true|Rand|


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
And the user selects lead institution value other than default value in the basicinfo legalentity page
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



Scenario: Verifying error message displayed for wrong format of claimes est date
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
Then the user should see the message you can search for a legal entity at any time using the header search
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
Then the user should see the search results for the institution
When the user clicks on the search results card with fid <fid>
And the user clicks on the update link
When the user enters day for claimed est date <day>
And the user enters month for claimed est date <month>
And the user enters year for claimed est date <year>
And the user clicks on the save button
Then the user should see the error message enter a day/month/year on legal entity page
And the user should see the error message at top of page the highlighted fields must be addressed before this update can be saved


Examples:
|entity|searchBy|fid|day|month|year|
|1038|fid|1038|10| ||
|1038|fid|1038|10|2||
|1038|fid|1038||2||
|1038|fid|1038|10||1994|
|1038|fid|1038|10.5| |1994.6|

Scenario: Verifying user can update claimed est date in trusted and zeus document.
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
Then the user should see the message you can search for a legal entity at any time using the header search
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
Then the user should see the search results for the institution
When the user clicks on the search results card with fid <fid>
And the user clicks on the update link
When the user enters day for claimed est date <day>
And the user enters month for claimed est date <month>
And the user enters year for claimed est date <year>
And the user clicks on the save button
Then the user should see the save confirmation modal
When the user clicks on the confirm button
Then the user verifies claimed est date from trusted and zeus document <fid>


Examples:
|entity|searchBy|fid|day|month|year|
|1038|fid|1038|10|1|1989|
|1038|fid|1038||2|1987|
|1038|fid|1038|||1954|




Scenario: User updates Charter type
Veriyfing if charter type values are updated in Zeus and Trusted documents.
Verifying the options displayed for charter type are same as those in lookup document.
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
Then the user should see the message you can search for a legal entity at any time using the header search
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
Then the user should see the search results for the institution
When the user clicks on the search results card with fid <fid>
And the user clicks on the update link
Then the user verifies options displayed for charter type from lookup document
And the user validates default value for charter type from trusted document <fid>
When the user updates charter type value <chartertype>
And the user clicks on the save button
Then the user should see the save confirmation modal
When the user clicks on the confirm button
Then the user verifies charter type from trusted and zeus document <fid>



Examples:
|entity|searchBy|fid|chartertype|
|1038|fid|1038|Private|


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
a)Type a matching text "i" in the status dropdown and verify that the status "Inactive" is selected.
b)Type a matching text "a" in the status dropdown and verify that the status "Active" is selected.
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

Examples:
|entity|searchBy|fid|
|1038|FID|1038|

Scenario: User will see summary of changes made in confirmation modal when update the Legal Entity's status
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
Then the user should see the fatcastatus value as in trusted document with fid <fid>
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


Scenario: Verify that the Legal Entity's Fatca Status field is not a required field

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the update link
And the user clicks on the save button
Then the user should see the save confirmation modal
When the user clicks on the confirm button

Examples:
|entity|searchBy|fid|
|1165|FID|1165|

Scenario: User can edit legal Entity's corporate statement
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
Then the user should see the message you can search for a legal entity at any time using the header search
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
Then the user should see the search results for the institution
When the user clicks on the search results card with fid <fid>
And the user clicks on the update link
When the user updates corporate statement <value>
And the user clicks on the save button
Then the user should see the save confirmation modal
When the user clicks on the confirm button
Then the user verifies corporate summary from zeus document <fid> <value>




Examples:
|entity|searchBy|fid|value|
|1038|fid|1038|CorporateValue|
|1038|fid|1038| |




