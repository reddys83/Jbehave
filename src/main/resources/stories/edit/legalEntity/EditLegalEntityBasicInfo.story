Meta:@EditLegalEntityBasicInfo @Edit @LegalEntity

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal
JIRA ID - ZEUS-906 - User can edit Legal Entity's Lead Institution flag
JIRA ID - ZUES- 84 - User can update a legal entity's charter type
JIRA ID - ZEUS- 904 - User can edit legal entity's claimed established date
JIRA ID - ZEUS-903 - User can edit Legal Entity's Status
JIRA ID - ZEUS-905 - User can edit Legal Entity's FATCA status
JIRA ID - ZEUS-77 - User can update legal entity's names
JIRA ID - ZEUS-908 - User can edit Legal Entity's Corporate Statement
JIRA ID - ZEUS-907 - User can edit Legal Entity's Additional Info
JIRA ID - ZEUS-86 - User can update a legal entity's type
JIRA ID - ZEUS-919 - User can edit Legal Entity's Chartered Date
JIRA ID - ZEUS-85 - User can update legal entity's insurance type
JIRA ID - ZEUS-83 - User can update legal entity's ownership type


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
And the user clicks on the legalEntity update link
Then the user should see the fatcaStatus value as in trusted document with fid <fid>
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
And the user clicks on the legalEntity update link
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
And the user clicks on the legalEntity update link
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

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the legalEntity update link
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
And the user clicks on the legalEntity update link
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
And the user clicks on the legalEntity update link
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
And the user clicks on the legalEntity update link
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
And the user clicks on the legalEntity update link
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
And the user clicks on the legalEntity update link
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

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the legalEntity update link
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
|1717|FID|1717|

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
And the user clicks on the legalEntity update link
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
And the user clicks on the legalEntity update link
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
And the user clicks on the legalEntity update link
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

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the legalEntity update link
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
|1717|FID|1717|

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
And the user clicks on the legalEntity update link
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

Scenario: Verify that the Legal Entity's Fatca Status field is not a required field

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the legalEntity update link
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
And the user clicks on the legalEntity update link
When the user updates corporate statement <value>
And the user clicks on the save button
Then the user should see the save confirmation modal
When the user clicks on the confirm button
Then the user verifies corporate summary from zeus document <fid> <value>




Examples:
|entity|searchBy|fid|value|
|1038|fid|1038|CorporateValue|
|1038|fid|1038| |


Scenario: Verify that the Legal Entity's Corporatea Action field max length is 10000 characters only.

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the legalEntity update link
Then the user verifies corporate action text area field length as 10000
When the user gets the document with get Id for legalentity with the fid as <entity> from the database
Then the user enters 10000 characters in corporate action text area
When the user clicks on the save button
Then the user should see the save confirmation modal
When the user clicks on the confirm button
Then the user reverts the changes to the document
When the user clicks on the legalEntity update link
And the user enters 10001 characters in the corporate action text area
And the user clicks on the save button
Then the user should see the error message enter up to 10000 valid characters for corporate action value in the basic info legal entity page

Examples:
|entity|searchBy|fid|
|1038|FID|1038|


Scenario: Verify that the Legal Entity's Additional Info can be saved
    a. Save with a new value different from the current value
    b. Save with same value as current

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the legalEntity update link
Then the user should see the legalentity's lead institution value as in trusted document with fid <fid>
When the user gets the document with get Id for legalentity with the fid as <entity> from the database
And the user enters the <additionalInfoText> in the additional info text area
And the user clicks on the save button
Then the user should see the save confirmation modal
When the user clicks on the confirm button
Then the user should see additional info text value as <additionalInfoText> for fid <fid> in zeus document
And the user reverts the changes to the document

Examples:
|entity|searchBy|fid|additionalInfoText|
|1165|FID|1165|xyz|
|1165|FID|1165|xyz|

Scenario: Verify that the Legal Entity's Additional Info is not a required field and the value can be blank.

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the legalEntity update link
And the user enters the <additionalInfoText> in the additional info text area
When the user clicks on the save button
Then the user should see the save confirmation modal
When the user clicks on the confirm button
Then the user should see additional info text value as <additionalInfoText> for fid <fid> in zeus document

Examples:
|entity|searchBy|fid|additionalInfoText
|1165|FID|1165||


Scenario: Verify that the Legal Entity's Additional Info field max length is 10000 characters only.

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the legalEntity update link
Then the user should see the additional info text area field length as 10000
When the user gets the document with get Id for legalentity with the fid as <entity> from the database
And the user enters 10000 characters in the additional info text area
And the user clicks on the save button
Then the user should see the save confirmation modal
And the user should see the below summary changes in confirmation modal
|Summary|
|Basic Info|

When the user clicks on the confirm button
Then the user should see additional info text value with 10000 characters for fid <fid> in zeus document
And the user reverts the changes to the document
When the user clicks on the legalEntity update link
And the user enters 10001 characters in the additional info text area
And the user clicks on the save button
Then the user should see the error message enter up to 10000 valid characters for additional info value in the basic info legal entity page

Examples:
|entity|searchBy|fid|
|1165|FID|1165|

Scenario: Verify for an existing row, Legal Entity's Entity Type dropdown values from lookup LEGAL_ENTITY_CATEGORY in the same order as taxonomy except those that have already been selected for this Legal Entity

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the legalEntity update link
And the user clicks on the first_existing_entitytype_dropdown in the basicinfo legalentity page
Then the user should see the first_existing_entitytype_dropdown values from lookup LEGAL_ENTITY_CATEGORY except the values that are selected already

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

Scenario: ZEUS-77 - Verify the type dropDown from names in legalEntity basic info

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the legalEntity update link
When the user gets the document with get Id for legalentity with the fid as <entity> from the database
And the user clicks on the add new name button in the basic info legal entity page
And the user clicks on new legal entity names type drop-down
Then the user should see the legal entity names types from lookup LEGAL_ENTITY_NAME_TYPE
When the user selects names type <legalEntityNameType> in the basic info legal entity page
And the user enters names value <legalEntityNameValue> in the basic info legal entity page
And the user clicks on the save button
Then the user should see the save confirmation modal
When the user clicks on the confirm button
Then the user should see the edits to legal entity names in zeus document
And the user reverts the changes to the document

Examples:
|entity|searchBy|fid|legalEntityNameType|legalEntityNameValue|
|1165|FID|1165|Former Name|Collins|

Scenario: verify no required message for legalEntiy names type, value when both are null for a new row.

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the legalEntity update link
And the user clicks on the add new name button in the basic info legal entity page
And the user clicks on new legal entity names type drop-down
When the user selects names type <legalEntityNameType> in the basic info legal entity page
And the user enters names value <legalEntityNameValue> in the basic info legal entity page
And the user clicks on the save button
Then the user should see the save confirmation modal

Examples:
|entity|searchBy|fid|legalEntityNameType|legalEntityNameValue|
|1165|FID|1165|||

Scenario: Verify the delete confirmation modal

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the legalEntity update link
And the user clicks on the add new name button in the basic info legal entity page
And the user clicks on new legal entity names type drop-down
And the user clicks on delete legal entity names option
Then the user should see the delete row confirmation modal in the legal entity page
When the user clicks on the no button in the delete row confirmation modal in the legal entity basic info page
Then the user should see the newly added names in the legal entity basic info page
When the user clicks on delete legal entity names option
When the user clicks on the yes button in the delete row confirmation modal in the legal entity basic info page
Then the user should not see the newly added names in the legal entity basic info page

Examples:
|entity|searchBy|fid|
|1165|FID|1165|

Scenario: Verify the delete icon should not present for type Legal Title

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the legalEntity update link
Then the user should not see the delete button for legal tiltle in names for legal entity

Examples:
|entity|searchBy|fid|
|1165|FID|1165|

Scenario: verify the length for value and user should see the validation error when user enters more than 200 charecters

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the legalEntity update link
And the user clicks on the add new name button in the basic info legal entity page
And the user enters more than 200 characters in legal entity names value
And the user clicks on the save button
Then the user should see the error message enter up to 200 valid characters for value in the legal entity page

Examples:
|entity|searchBy|fid|
|1165|FID|1165|

Scenario: User updates Chartered date
Verifying updated date is been is saved in zeus document.

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
Then the user should see the message you can search for a legal entity at any time using the header search
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
Then the user should see the search results for the institution
When the user clicks on the search results card with fid <fid>
And the user clicks on the legalEntity update link
Then the user updates Chartered date <day> <month> <year>
When the user clicks on the save button
Then the user should see the save confirmation modal
When the user clicks on the confirm button
Then the user verifies chartered date <fid>



Examples:
|entity|searchBy|fid|day|month|year|
|1038|fid|1038|14|2|1984|


Scenario: User updates Chartered date
Verifying error message displaying Enter a year, month/year or day/month/year. for invalid date entered.

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
Then the user should see the message you can search for a legal entity at any time using the header search
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
Then the user should see the search results for the institution
When the user clicks on the search results card with fid <fid>
And the user clicks on the legalEntity update link
Then the user updates Chartered date <day> <month> <year>
When the user clicks on the save button
Then the user should see the error 'Enter a year, month/year or day/month/year.' for chartered date
And the user should see the error message at top of page the highlighted fields must be addressed before this update can be saved



Examples:
|entity|searchBy|fid|day|month|year|
|1038|fid|1038|14|2||

Scenario: User updates Chartered date
Verifying error message displaying Invalid Date for invalid date entered.

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
Then the user should see the message you can search for a legal entity at any time using the header search
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
Then the user should see the search results for the institution
When the user clicks on the search results card with fid <fid>
And the user clicks on the legalEntity update link
Then the user updates Chartered date <day> <month> <year>
When the user clicks on the save button
Then the user should see the error 'Invalid Date' for chartered date
And the user should see the error message at top of page the highlighted fields must be addressed before this update can be saved



Examples:
|entity|searchBy|fid|day|month|year|
|1038|fid|1038|32|2|1909|


Scenario: User updates Insurance type
Verifying the options displayed for insurance type are same as those in lookup document.

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
Then the user should see the message you can search for a legal entity at any time using the header search
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
Then the user should see the search results for the institution
When the user clicks on the search results card with fid <fid>
And the user clicks on the legalEntity update link
Then the user verifies options displayed for insurance type from lookup document

Examples:
|entity|searchBy|fid|
|1038|fid|1038|

Scenario: User updates Insurance type
Verifying the value updated by user is reflected in Zeus document

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
Then the user should see the message you can search for a legal entity at any time using the header search
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
Then the user should see the search results for the institution
When the user clicks on the search results card with fid <fid>
And the user clicks on the legalEntity update link
Then the user updates the value of insurance type <insuranceValue>
When the user clicks on the save button
Then the user should see the save confirmation modal
When the user clicks on the confirm button
And the user verifies if the update for successful in zeus document <insuranceValue> <fid>

Examples:
|entity|searchBy|fid|insuranceValue|
|1038|fid|1038|American Share Insurance (OH CU's)|
|1038|fid|1038||

Scenario: User updates Ownership type
Verifying the options displayed for Ownership type are same as those in lookup document.

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
Then the user should see the message you can search for a legal entity at any time using the header search
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
Then the user should see the search results for the institution
When the user clicks on the search results card with fid <fid>
And the user clicks on the legalEntity update link
Then the user verifies options displayed for ownership type from lookup document

Examples:
|entity|searchBy|fid|
|1038|fid|1038|

Scenario: User updates Ownership type
Verifying the value updated by user is reflected in Zeus document

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
Then the user should see the message you can search for a legal entity at any time using the header search
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
Then the user should see the search results for the institution
When the user clicks on the search results card with fid <fid>
And the user clicks on the legalEntity update link
Then the user updates the value of insurance type <ownershipType>
When the user clicks on the save button
Then the user should see the save confirmation modal
When the user clicks on the confirm button
And the user verifies if the update for successful in zeus document <ownershipType> <fid>

Examples:
|entity|searchBy|fid|ownershipType|
|1038|fid|1038|Government Bank|
|1038|fid|1038||
|1038|fid|1038|Corporate Bank|


