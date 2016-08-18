Meta:@EditOfficeBasicInfo @Edit @Office @AllStories

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal
JIRA ID - ZEUS-1066 - User can edit Office's Opened Date
and
JIRA ID - ZEUS-1068 - User can edit Office's Lead Location flag
and
JIRA ID - ZEUS-1070 - User can edit office's Foreign Office flag
and
JIRA ID - ZEUS-1072 - User can edit Office's Additional Info
and
JIRA ID - ZEUS-1074 - USer can edit Office's Types
and
JIRA ID - ZEUS-1073 - User can edit Office's Names
JIRA ID - ZEUS-1064 - User can edit Office's Prefix, Suffix and Override
JIRA ID - ZEUS-1071 - User can edit Office's Business Hours

Scenario: Update and Save office Opened date
Verify User updates a value for Opened Date and click Save. Updated Office opened date should be saved in Zeus document

Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
And the user clicks on the office update link
And the user updates office Opened <day> <month> <year>
And the user clicks on the save button
Then the user should see the save confirmation modal
When the user clicks on the confirm button
Then the user verifies office opened date from zeus document <officeFid> <day> <month> <year>


Examples:
|entity|searchBy|fid|officeFid|day|month|year|
|1010|FID|1010|1010-44|07|Oct|2014|

Scenario: User updates Office Opened date
Verifying error message Enter a year, month/year or day/month/year. is displaying for invalid date entered.

Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
And the user clicks on the office update link
And the user updates office Opened <day> <month> <year>
And the user clicks on the save button
Then the user should see the error 'Enter a year, month/year or day/month/year.' for opened date
And the user should see the error message at top of page the highlighted fields must be addressed before this update can be saved

Examples:
|entity|searchBy|fid|officeFid|day|month|year|
|1010|FID|1010|1010-44|14|Jan||

Scenario: User updates Office Opened date
Verifying error message Invalid Date is displaying for invalid date entered.

Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
And the user clicks on the office update link
And the user updates office Opened <day> <month> <year>
And the user clicks on the save button
Then the user should see the error 'Invalid Date' for opened date
And the user should see the error message at top of page the highlighted fields must be addressed before this update can be saved

Examples:
|entity|searchBy|fid|officeFid|day|month|year|
|1010|FID|1010|1010-44|32|Oct|1909|

Scenario: Verify that Opened Date can not be later than today
Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
And the user clicks on the office update link
And the user updates office Opened <day> <month> <year>
And the user clicks on the save button
Then the user should see the error 'Must be no later than today.' for opened date
And the user should see the error message at top of page the highlighted fields must be addressed before this update can be saved

Examples:
|entity|searchBy|fid|officeFid|day|month|year|
|1010|FID|1010|1010-44|15|Jan|2020|

Scenario: User updates Office Opened date- Verify null values are allowed for day, month and year

Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
And the user clicks on the office update link
And the user updates office Opened <day> <month> <year>
And the user clicks on the save button
Then the user should see the save confirmation modal
When the user clicks on the confirm button
Then the user verifies office opened date from zeus document <officeFid> <day> <month> <year>


Examples:
|entity|searchBy|fid|officeFid|day|month|year|
|1010|FID|1010|1010-44||||

JIRA ID - ZEUS-1069 - User can edit Principal Office flag
Scenario: User makes a change to the principal office flag where the xml does not have the node principal office node and saves it
1. verify that the confirmation modal displays the change
2. verify that the change is reflected in zeus document
3. verify that the change is reflected on the page

Given a user is on the search page
And the user updates office with fid <entityFid>
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <entityFid>
And the user clicks on the office update link
And the user updates principal office flag to <principalFlag>
And the user clicks on the save button
Then the user should see the below summary changes in confirmation modal
|Summary|
|Basic Info|
When the user clicks on the confirm button
Then the user verifies office principal office is <principalFlag>
And the user verifies office <principalFlag> from zeus document <entityFid>


Examples:
|entity|searchBy|fid|entityFid|principalFlag|
|1010|FID|1010|1010-44|true|

JIRA ID - ZEUS-1069 - User can edit Principal Office flag
Scenario: User does not make a change to the principal office flag and saves it
1. verify that the confirmation modal does displays that change has been made to Basic Info
2. verify that the old value is reflected in zeus document
3. verify that the old value is reflected on the page

Given a user is on the search page
And the user updates office with fid <entityFid>
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <entityFid>
And the user clicks on the office update link
And the user updates principal office flag to <principalFlag>
And the user clicks on the save button
Then the user should not see the below summary changes in confirmation modal
|Summary|
|Basic Info|
When the user clicks on the confirm button
Then the user verifies office principal office is <principalFlag>
And the user verifies office <principalFlag> from zeus document <entityFid>


Examples:
|entity|searchBy|fid|entityFid|principalFlag|
|1010|FID|1010|1010-45|false|



Scenario: Verify the default Edit value and Save Lead Location value for an office
a. Select the value as True for Lead Location flag and Save for an office with a default value as True or False
b. Select the value as False for Lead Location flag and Save for an office with a default value as True or False

Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
And the user clicks on the office update link
When the user gets the document with get id for offices with the <officeFid> from the database
And the user selects lead location value <leadLocationflag> in the basicinfo office page
And the user clicks on the save button
Then the user should see the save confirmation modal
When the user clicks on the confirm button
Then the user should see leadLocation value as <leadLocationflag> for fid <officeFid> in zeus document and in zeus UI
And the user reverts the changes to the document

Examples:
|entity|searchBy|fid|officeFid|leadLocationflag|
|1010|FID|1010|1010-44|true|
|1010|FID|1010|1010-44|false|

Scenario: User will see summary of changes made in confirmation modal

Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
And the user clicks on the office update link
And the user selects lead location value other than default value in the basicinfo office page
And the user clicks on the save button
Then the user should see the save confirmation modal
And the user should see the below summary changes in confirmation modal
|Summary|
|Basic Info|
When the user clicks on the return button
Then the user should return to edit office page mode

Examples:
|entity|searchBy|fid|officeFid|
|1010|FID|1010|1010-44|





Scenario: Verify the default Edit value and Save Foreign Office value for an office
       a. Select the value as True for Foreign Office flag and Save for an office
       b. Select the value as False for Foreign Office flag and Save for an office

Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
And the user clicks on the office update link
When the user gets the document with get id for offices with the <officeFid> from the database
And the user selects foreign office value <foreignOfficeflag> in the basicinfo office page
And the user clicks on the save button
Then the user should see the save confirmation modal
When the user clicks on the confirm button
Then the user should see foreignOffice value as <foreignOfficeflag> for fid <officeFid> in zeus document and in zeus UI
And the user reverts the changes to the document

Examples:
|entity|searchBy|fid|officeFid|foreignOfficeflag|
|1010|FID|1010|1010-44|true|
|1010|FID|1010|1010-44|false|

Scenario: User will see summary of changes made in confirmation modal

Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
And the user clicks on the office update link
And the user selects foreign office value other than default value in the basicinfo office page
And the user clicks on the save button
Then the user should see the save confirmation modal
And the user should see the below summary changes in confirmation modal
|Summary|
|Basic Info|
When the user clicks on the return button
Then the user should return to edit office page mode

Examples:
|entity|searchBy|fid|officeFid|
|1010|FID|1010|1010-44|

Scenario: Verify that the Offices's Additional Info can be saved
    a. Save with a new value different from the current value
    b. Save with same value as current

Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
And the user clicks on the office update link
When the user gets the document with get id for offices with the <officeFid> from the database
And the user enters the <additionalInfoText> in the office additional info text area
And the user clicks on the save button
Then the user should see the save confirmation modal
And the user should see the below summary changes in confirmation modal
|Summary|
|Basic Info|
When the user clicks on the confirm button
Then the user should see office additional info text value as <additionalInfoText> for fid <officeFid> in zeus document and in zeus UI
When the user clicks on the office update link
And the user enters the <additionalInfoText> in the office additional info text area
And the user clicks on the save button
Then the user should see the save confirmation modal
And the user should not see the below summary changes in confirmation modal
|Summary|
|Basic Info|
When the user clicks on the confirm button
Then the user should see office additional info text value as <additionalInfoText> for fid <officeFid> in zeus document and in zeus UI
And the user reverts the changes to the document

Examples:
|entity|searchBy|fid|officeFid|additionalInfoText|
|1010|FID|1010|1010-44|abc|

Scenario: a)Verify that the Offices's Additional Info is not a required field and the value can be blank.
          b)Verify that the Office's Additional Info field max length is 10000 characters only.

Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
And the user clicks on the office update link
When the user gets the document with get id for offices with the <officeFid> from the database
And the user enters the <additionalInfoText> in the office additional info text area
When the user clicks on the save button
Then the user should see the save confirmation modal
And the user should see the below summary changes in confirmation modal
|Summary|
|Basic Info|
When the user clicks on the confirm button
Then the user should see office additional info text value as <additionalInfoText> for fid <officeFid> in zeus document and in zeus UI
And the user reverts the changes to the document
When the user clicks on the office update link
And the user enters 10000 characters in the office additional info text area
Then the user should see the office additional info text area field length as 10000
When the user clicks on the save button
Then the user should see the save confirmation modal
And the user should see the below summary changes in confirmation modal
|Summary|
|Basic Info|
When the user clicks on the confirm button
Then the user should see the office additional info text value with 10000 characters for fid <officeFid> in zeus document
And the user reverts the changes to the document
Examples:
|entity|searchBy|fid|officeFid|additionalInfoText|
|1010|FID|1010|1010-44||
Scenario: Verify Office's Office Type dropdown values from lookup OFFICE_TYPE  except those that have already been selected for this Office

a) Verify for an existing OfficeTypes row, the office type values are from OFFICE_TYPE
b) Verify for a new OfficeTypes row, the office type values are from OFFICE_TYPE

Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
And the user clicks on the office update link
And the user clicks on the first_existing_officetype_dropdown in the basicinfo office page
Then the user should see the first_existing_officetype_dropdown values from lookup OFFICE_TYPE except the values that are selected already in office
When the user clicks on the add new office type button
And the user clicks on the first_new_officetype_dropdown in the basicinfo office page
Then the user should see the first_new_officetype_dropdown values from lookup OFFICE_TYPE except the values that are selected already in office

Examples:
|entity|searchBy|fid|officeFid|
|1010|FID|1010|1010-44|

Scenario: Update and Save existing office type- Select a non-Blank value and Save. Verify the value is saved in Zeus document


Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
And the user clicks on the office update link
Then the user should see the officeType value as in trusted document with fid <officeFid>
When the user gets the document with get id for offices with the <officeFid> from the database
And the user selects office type value as <officeTypeValue> from first_existing_officetype_dropdown in the basicinfo office page
And the user clicks on the save button
Then the user should see the save confirmation modal
And the user should see the below summary changes in confirmation modal
|Summary|
|Basic Info / Office Types|
When the user clicks on the confirm button
Then the user should see officeType value as <officeTypeValue> for fid <officeFid> in zeus document and in UI
And the user reverts the changes to the document

Examples:
|entity|searchBy|fid|officeFid|officeTypeValue|
|1010|FID|1010|1010-44|Agency|



Scenario:Update and Save existing office type-Select a null value and Save. Verify that null value is not saved.

Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
And the user clicks on the office update link
Then the user should see the officeType value as in trusted document with fid <officeFid>
When the user gets the document with get id for offices with the <officeFid> from the database
And the user selects office type value as <officeTypeValue> from first_existing_officetype_dropdown in the basicinfo office page
And the user clicks on the save button
Then the user should see the save confirmation modal
And the user should see the below summary changes in confirmation modal
|Summary|
|Basic Info / Office Types|
When the user clicks on the confirm button
Then the user should not see the deleted office type value <officeTypeValue> in the zeus document and in UI for fid <officeFid>
And the user reverts the changes to the document

Examples:
|entity|searchBy|fid|officeFid|officeTypeValue|
|1010|FID|1010|1010-44||

Scenario: Add a new legal entity type row and Save- Select a non-Blank value and Save. Verify the value is saved in Zeus document

Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
And the user clicks on the office update link
Then the user should see the officeType value as in trusted document with fid <officeFid>
When the user gets the document with get id for offices with the <officeFid> from the database
And the user clicks on the add new office type button
And the user selects office type value as <officeTypeValue> from first_existing_officetype_dropdown in the basicinfo office page
And the user clicks on the save button
Then the user should see the save confirmation modal
And the user should see the below summary changes in confirmation modal
|Summary|
|Basic Info / Office Types|
When the user clicks on the confirm button
Then the user should see officeType value as <officeTypeValue> for fid <officeFid> in zeus document and in UI
And the user reverts the changes to the document

Examples:
|entity|searchBy|fid|officeFid|officeTypeValue|
|1010|FID|1010|1010-44|Regional Office|


Scenario: Add a new legal entity type row and Save- Select a null value and Save. Verify that null value is not saved.

Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
And the user clicks on the office update link
Then the user should see the officeType value as in trusted document with fid <officeFid>
When the user gets the document with get id for offices with the <officeFid> from the database
And the user clicks on the add new office type button
And the user selects office type value as <officeTypeValue> from first_existing_officetype_dropdown in the basicinfo office page
And the user clicks on the save button
Then the user should see the save confirmation modal
And the user should see the below summary changes in confirmation modal
|Summary|
|Basic Info / Office Types|
When the user clicks on the confirm button
Then the user should not see the deleted office type value <officeTypeValue> in the zeus document and in UI for fid <officeFid>
And the user reverts the changes to the document

Examples:
|entity|searchBy|fid|officeFid|officeTypeValue|
|1010|FID|1010|1010-44||


Scenario:
a) Verify that the delete button is disabled for the first row of office type
b) Verify that the user should get the confirmation window for deleting existing office type rows and user clicks No button
c) Verify that the user should get the confirmation window for deleting existing office type rows and user clicks Yes button and row should be deleted


Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
And the user clicks on the office update link
When the user gets the document with get id for offices with the <officeFid> from the database
Then the user should see the first_row_existing_officetype_delete_button in disabled state in office types section
When the user clicks on the second_row_existing_officetype_delete_button in office types section
Then the user should see the delete row confirmation modal in the office page
When the user clicks on the no button in the delete row confirmation modal in the office page
Then the user should still see the office second_existing_officetype_dropdown with value Trust Branch in office type in office page
When the user clicks on the second_row_existing_officetype_delete_button in office types section
When the user clicks on the yes button in the delete row confirmation modal in the office page
When the user clicks on the save button
Then the user should see the save confirmation modal
And the user should see the below summary changes in confirmation modal
|Summary|
|Basic Info / Office Types|
When the user clicks on the confirm button
Then the user should not see the deleted office type value <officeTypeValue> in the zeus document and in UI for fid <officeFid>
And the user reverts the changes to the document

Examples:
|entity|searchBy|fid|officeFid|officeTypeValue|
|1010|FID|1010|1010-44|Trust Branch|


Scenario:
a) Verify that the user should get the confirmation window for deleting new office type rows and user clicks No button
b) Verify that the user should get the confirmation window for deleting new office type rows and user clicks Yes button and row should be deleted

Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
And the user clicks on the office update link
When the user gets the document with get id for offices with the <officeFid> from the database
And the user clicks on the add new office type button
When the user clicks on the first_new_row_officetype_delete_button in office types section
Then the user should see the delete row confirmation modal in the office page
When the user clicks on the no button in the delete row confirmation modal in the office page
Then the user should still see the office first_new_officetype_dropdown in the new office type row
When the user clicks on the first_new_row_officetype_delete_button in office types section
When the user clicks on the yes button in the delete row confirmation modal in the office page
Then the user should not see the office first_new_officetype_dropdown in the new office type row
When the user clicks on the save button
When the user clicks on the confirm button
Then the user should not see the deleted office type value <officeTypeValue> in the zeus document and in UI for fid <officeFid>


Examples:
|entity|searchBy|fid|officeFid|
|1010|FID|1010|1010-44|


Scenario: Verify that the user should get the Required field message when saving an office type value to null and that is the only office type exists on the page.

Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
And the user clicks on the office update link
And the user selects to delete all the office type rows except the first one in office types
And the user selects office type value as <officeTypeValue> from first_existing_officetype_dropdown in the basicinfo office page
And the user clicks on the save button
Then the user should see the error message for the required office type field in the basic info office page
And the user should see the error message at top of page the highlighted fields must be addressed before this update can be saved

Examples:
|entity|searchBy|fid|officeFid|officeTypeValue
|1010|FID|1010|1010-44||


Scenario: Verify that the user should see the Required field message against the first row only when user enters null value for all the office type rows
Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
And the user clicks on the office update link
And the user enters null value for all the office type rows
And the user clicks on the save button
Then the user should see the error message for the required office type field in the basic info office page
And the user should see the error message at top of page the highlighted fields must be addressed before this update can be saved

Examples:
|entity|searchBy|fid|officeFid|officeTypeValue
|1010|FID|1010|1010-44||

Scenario: Verify that the user should NOT get the Required field message when user enters null value for all the office type rows except one row

Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
And the user clicks on the office update link
When the user gets the document with get id for offices with the <officeFid> from the database
And the user enters null value for all the office type rows
And the user selects office type value as <officeTypeValue> from first_existing_officetype_dropdown in the basicinfo office page
And the user clicks on the save button
Then the user should see the save confirmation modal
And the user should see the below summary changes in confirmation modal
|Summary|
|Basic Info / Office Types|
When the user clicks on the confirm button
Then the user should see officeType value as <officeTypeValue> for fid <officeFid> in zeus document and in UI
Then the user reverts the changes to the document

Examples:
|entity|searchBy|fid|officeFid|officeTypeValue|
|1010|FID|1010|1010-44|Agency|

Scenario: Verify Office Name Type dropdown values are from lookup OFFICE_NAME_TYPE
a) Verify for an existing Office Name row, the Office Type values are from OFFICE_NAME_TYPE
b) Verify for a new Office Name row, the Office Type values are from OFFICE_NAME_TYPE

Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
And the user clicks on the office update link
Then the user should see the office_name_second_row_existing_office_type_dropdown values in office's section from lookup OFFICE_NAME_TYPE
When the user clicks on add new office name button in the office name page
Then the user should see the office_name_type_first_row_new_office_name_type_dropdown values in office's section from lookup OFFICE_NAME_TYPE

Examples:
|entity|searchBy|fid|officeFid|
|1010|FID|1010|1010-44|


Scenario: Update and Save office names
User selects a value for an existing row for Type, Value and click Save. Updated office name should be saved in Zeus document

Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
And the user clicks on the office update link
Then the user should see the office name values as in trusted document with fid <officeFid>
When the user gets the document with get id for offices with the <officeFid> from the database
And the user selects office name type office_name_second_row_existing_office_type_dropdown value as <type>
And the user enters office name value office_name_second_row_existing_office_value as <value>
And the user clicks on the save button
Then the user should see the save confirmation modal
And the user should see the below summary changes in confirmation modal
|Summary|
|Basic Info / Names|
When the user clicks on the confirm button
Then the user should see officename values as <type><value> for fid <officeFid> in zeus document and in UI
And the user reverts the changes to the document

Examples:
|entity|searchBy|fid|officeFid|type|value|
|1010|FID|1010|1010-44|Former Name|abc|

Scenario: Update and Save office names
User selects a value for a new row for Type, Value and click Save. Updated office name should be saved in Zeus document

Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
And the user clicks on the office update link
Then the user should see the office name values as in trusted document with fid <officeFid>
When the user gets the document with get id for offices with the <officeFid> from the database
When the user clicks on add new office name button in the office name page
And the user selects office name type office_name_type_first_row_new_office_name_type_dropdown value as <type>
And the user enters office name value office_name_first_row_new_office_value as <value>
And the user clicks on the save button
Then the user should see the save confirmation modal
And the user should see the below summary changes in confirmation modal
|Summary|
|Basic Info / Names|
When the user clicks on the confirm button
Then the user should see officename values as <type><value> for fid <officeFid> in zeus document and in UI
And the user reverts the changes to the document

Examples:
|entity|searchBy|fid|officeFid|type|value|
|1010|FID|1010|1010-44|Former Name|xyz|

Scenario: verify no required message for office names type, value when both are null for a new row.

Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
And the user clicks on the office update link
Then the user should see the office name values as in trusted document with fid <officeFid>
When the user gets the document with get id for offices with the <officeFid> from the database
When the user clicks on add new office name button in the office name page
And the user selects office name type office_name_type_first_row_new_office_name_type_dropdown value as <type>
And the user enters office name value office_name_first_row_new_office_value as <value>
And the user clicks on the save button
Then the user should see the save confirmation modal
And the user should not see the below summary changes in confirmation modal
|Summary|
|Basic Info / Names|
When the user clicks on the confirm button
Then the user reverts the changes to the document

Examples:
|entity|searchBy|fid|officeFid|type|value|
|1010|FID|1010|1010-44|||

Scenario:
a. Verify that the user should see Required error message for value field when select a value for Type but keeps the Value as blank

Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
And the user clicks on the office update link
Then the user should see the office name values as in trusted document with fid <officeFid>
When the user gets the document with get id for offices with the <officeFid> from the database
When the user clicks on add new office name button in the office name page
And the user selects office name type office_name_type_first_row_new_office_name_type_dropdown value as <type>
And the user enters office name value office_name_first_row_new_office_value as <value>
And the user clicks on the save button
Then the user should see the error message Enter up to 75 valid characters. for the office name value field
And the user should see the error message at top of page the highlighted fields must be addressed before this update can be saved

Examples:
|entity|searchBy|fid|officeFid|type|value|
|1010|FID|1010|1010-44|Former Name||


Scenario: Delete and Save existing office Names
Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
And the user clicks on the office update link
Then the user should see the office name values as in trusted document with fid <officeFid>
When the user gets the document with get id for offices with the <officeFid> from the database
And the user clicks on delete office names row button for the row office_name_second_row_existing_delete_button
Then the user should see the delete row confirmation modal in the office name page
When the user clicks on the yes button in the delete row confirmation modal in the office name basic info page
And the user clicks on the save button
Then the user should see the save confirmation modal
And the user should see the below summary changes in confirmation modal
|Summary|
|Basic Info / Names|
When the user clicks on the confirm button
Then the user should not see officename values for fid <officeFid> in zeus document as:
|type|value|
|Office Name|HEWLETT BRANCH|
Then the user reverts the changes to the document
Examples:
|entity|searchBy|fid|officeFid|
|1010|FID|1010|1010-44|


Scenario: Delete newly added office name row
Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
And the user clicks on the office update link
Then the user should see the office name values as in trusted document with fid <officeFid>
When the user gets the document with get id for offices with the <officeFid> from the database
When the user clicks on add new office name button in the office name page
And the user clicks on delete office names row button for the row office_name_first_row_new_delete_button
Then the user should see the delete row confirmation modal in the office name page
When the user clicks on the yes button in the delete row confirmation modal in the office name basic info page
And the user clicks on the save button
Then the user should see the save confirmation modal
And the user should not see the below summary changes in confirmation modal
|Summary|
|Basic Info / Names|
When the user clicks on the confirm button
Then the user should not see the new office name row with office_name_type_first_row_new_office_name_type_dropdown

Examples:
|entity|searchBy|fid|officeFid|
|1010|FID|1010|1010-44|



Scenario: Verify the delete icon should not present for type Legal Title

Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
And the user clicks on the office update link
Then the user should not see the delete button for legal title in names for office

Examples:
|entity|searchBy|fid|officeFid|
|1010|FID|1010|1010-44|

Scenario: verify the length for value field

Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
When the user gets the document with get id for offices with the <officeFid> from the database
And the user clicks on the office update link
When the user clicks on add new office name button in the office name page
Then the user verifies the office name value maxlength is 75 for the office_name_first_row_new_office_value
When the user clicks on the save button
Then the user should see the save confirmation modal
When the user clicks on the confirm button
Then the user reverts the changes to the document

Examples:
|entity|searchBy|fid|officeFid|
|1010|FID|1010|1010-44|

Scenario: Update and Save Sort Name
User selects a value for a sort name and verify the length for sort name field and click Save. Updated sort name should be saved in Zeus document

Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
And the user clicks on the office update link
Then the user should see the office name values as in trusted document with fid <officeFid>
When the user gets the document with get id for offices with the <officeFid> from the database
When the user enters sort name as <sortName> in the office name
Then the user verifies the office name sort name maxlength is 75 for the sortName
When the user clicks on the save button
Then the user should see the save confirmation modal
And the user should see the below summary changes in confirmation modal
|Summary|
|Basic Info / Names|
When the user clicks on the confirm button
Then the user should see the edits to office sort name as <sortName> for fid <officeFid> in zeus document and in UI
And the user reverts the changes to the document

Examples:
|entity|searchBy|fid|officeFid|sortName|
|1010|FID|1010|1010-44|affhjdhskfh|


Scenario: User updates the Prefix, Suffix and Override fields. Verifies that Override value is saved and Prefix and Suffix values are null in Zeus document.
Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
And the user clicks on the office update link
When the user gets the document with get id for offices with the <officeFid> from the database
And the user enters the office prefix value as <prefix>
And the user enters the office suffix value as <suffix>
And the user enters the office override value as <override>
And the user clicks on the save button
Then the user should see the save confirmation modal
When the user clicks on the confirm button
Then the user should verify the prefix,suffix and override values for fid <officeFid> as:
|prefix|suffix|override|
|||testoverride|
And the user reverts the changes to the document

Examples:
|entity|searchBy|fid|officeFid|prefix|suffix|override|
|1165|FID|1165|1165-14|testprefix|testsuffix|testoverride|

Scenario: User updates the Prefix, Suffix fields and keeps override as blank. Verifies that Override value is null and Prefix and Suffix values are saved in Zeus document.
Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
And the user clicks on the office update link
When the user gets the document with get id for offices with the <officeFid> from the database
And the user enters the office prefix value as <prefix>
And the user enters the office suffix value as <suffix>
And the user enters the office override value as <override>
And the user clicks on the save button
Then the user should see the save confirmation modal
When the user clicks on the confirm button
Then the user should verify the prefix,suffix and override values for fid <officeFid> as:
|prefix|suffix|override|
|testprefix|testsuffix||
And the user reverts the changes to the document

Examples:
|entity|searchBy|fid|officeFid|prefix|suffix|override|
|1165|FID|1165|1165-14|testprefix|testsuffix||

Scenario: User updates the suffix value and keeps prefix and Override value as blank. Verifies that suffix value is saved and prefix and Override values are null in Zeus document.
Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
And the user clicks on the office update link
When the user gets the document with get id for offices with the <officeFid> from the database
And the user enters the office prefix value as <prefix>
And the user enters the office suffix value as <suffix>
And the user enters the office override value as <override>
And the user clicks on the save button
Then the user should see the save confirmation modal
When the user clicks on the confirm button
Then the user should verify the prefix,suffix and override values for fid <officeFid> as:
|prefix|suffix|override|
||testsuffix||
And the user reverts the changes to the document

Examples:
|entity|searchBy|fid|officeFid|prefix|suffix|override|
|1165|FID|1165|1165-14||testsuffix||

Scenario: User updates the prefix value and keeps suffix and Override value as blank. Verifies that prefix value is saved and suffix and Override values are null in Zeus document.
Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
And the user clicks on the office update link
When the user gets the document with get id for offices with the <officeFid> from the database
And the user enters the office prefix value as <prefix>
And the user enters the office suffix value as <suffix>
And the user enters the office override value as <override>
And the user clicks on the save button
Then the user should see the save confirmation modal
When the user clicks on the confirm button
Then the user should verify the prefix,suffix and override values for fid <officeFid> as:
|prefix|suffix|override|
|testprefix|||
And the user reverts the changes to the document

Examples:
|entity|searchBy|fid|officeFid|prefix|suffix|override|
|1165|FID|1165|1165-14|testprefix|||

Scenario: User updates the prefix and suffix values and enters blank spaces in the Override field. Verifies that prefix and suffix values are saved and Override value is null in Zeus document.
Verify the max length for prefix, Suffix and override fiels as 200 characters.
Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
And the user clicks on the office update link
When the user gets the document with get id for offices with the <officeFid> from the database
Then the user should see the maxlength of prefix field set to 200
And the user should see the maxlength of suffix field set to 200
And the user should see the maxlength of override field set to 200
When the user enters the office prefix value as <prefix>
And the user enters the office suffix value as <suffix>
And the user enters the office override value as <override>
And the user clicks on the save button
Then the user should see the save confirmation modal
When the user clicks on the confirm button
Then the user should verify the prefix,suffix and override values for fid <officeFid> as:
|prefix|suffix|override|
|testprefix|testsuffix||
And the user reverts the changes to the document

Examples:
|entity|searchBy|fid|officeFid|prefix|suffix|override|
|1165|FID|1165|1165-14|testprefix|testsuffix|     |

Scenario:  To update the Office`s 'Basic Info' by entering a value for 'Business Hours' that is different from the current value
a)User verifies whether current value of Business Hours is same as in trusted document.
b)User verifies Business Hours value is updated in Office basic info page
c)User verifies Business Hours value is updated in Zeus Document
d)User verifies whether blank value for Business Hours is saved successfully in office basic info page
e)User verifies blank Business Hours value updated in Zeus Document

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
And the user clicks on the office update link
When the user gets the document with get id for offices with the <officeFid> from the database
Then the user should see the office's business hours value same as in trusted document
When the user enters the <businessHour> in the office business hour text area
And the user clicks on the save button
Then the user should see the below summary changes in confirmation modal
|Summary|
|Basic Info|
When the user clicks on the confirm button
Then the user should see the successful update message at top of the office page
Then the user should be able to verify the values are entered in the office business hour field
Then the user should see the office business hours value same as in zeus document
Then the user reverts the changes to the document

Examples:
|entity|searchBy|fid|officeFid|businessHour|
|1038|FID|1038|1038-51|Sample texting in Zeus|
|1038|FID|1038|1038-51|12:00|
|1038|FID|1038|1038-51||

Scenario: To view that there is no change in value when the user has entered a value for 'Business Hours' that is no different to the current value in Office Basic Info page
a)User verifies Office Basic Info changes has not been updated in confirmation modal
b)User verifies Business Hours value is updated correctly in office basic info page
c)User verifies Business Hours values in Zeus Document

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
And the user clicks on the office update link
When the user gets the document with get id for offices with the <officeFid> from the database
When the user enters the <businessHour> in the office business hour text area
And the user clicks on the save button
When the user clicks on the confirm button
Then the user should see the successful update message at top of the office page
When the user clicks on the office update link
When the user enters the <businessHour> in the office business hour text area
And the user clicks on the save button
Then the user should not see the below summary changes in confirmation modal
|Summary|
|Basic Info|
When the user clicks on the confirm button
Then the user should see the successful update message at top of the office page
Then the user should be able to verify the values are entered in the office business hour field
Then the user should see the office business hours value same as in zeus document
Then the user reverts the changes to the document

Examples:
|entity|searchBy|fid|officeFid|businessHour|
|1038|FID|1038|1038-51|Sample text|

Scenario: User verifies that business hours field is limited to 200 unicode characters in Office basic info Page
a)User verifies that the maxlength attribute is 200.

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
And the user clicks on the office update link
When the user gets the document with get id for offices with the <officeFid> from the database
When the user enters 200 unicode characters in the office business hours field
Then the user verifies business hours max length attribute is 200
When the user clicks on the save button
And the user clicks on the confirm button
Then the user should see the successful update message at top of the office page
Then the user should be able to view that only 200 unicode characters are saved in office business hours
Then the user should see the office business hours value same as in zeus document
Then the user reverts the changes to the document

Examples:
|entity|searchBy|fid|officeFid|
|1038|FID|1038|1038-51|
