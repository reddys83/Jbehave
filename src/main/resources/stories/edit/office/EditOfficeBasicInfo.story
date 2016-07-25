Meta:@EditOfficeBasicInfo @Edit @Office @AllStories

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal
JIRA ID - ZEUS-1066 - User can edit Office's Opened Date
and
JIRA ID - ZEUS-1074 - USer can edit Office's Types

Scenario: Update and Save office Opened date
Verify User updates a value for Opened Date and click Save. Updated Office opened date should be saved in Zeus document

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
And the user updates office Opened <day> <month> <year>
And the user clicks on the save button
Then the user should see the save confirmation modal
When the user clicks on the confirm button
Then the user verifies office opened date from zeus document <fid> <day> <month> <year>


Examples:
|entity|searchBy|fid|officeFid|day|month|year|
|1010|FID|1010|1010-44|07|Oct|2014|

Scenario: User updates Office Opened date
Verifying error message Enter a year, month/year or day/month/year. is displaying for invalid date entered.

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
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
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
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
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
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
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
Then the user verifies office opened date from zeus document <fid> <day> <month> <year>


Examples:
|entity|searchBy|fid|officeFid|day|month|year|
|1010|FID|1010|1010-44||||

Scenario: Verify Office's Office Type dropdown values from lookup OFFICE_TYPE  except those that have already been selected for this Office

a) Verify for an existing OfficeTypes row, the office type values are from OFFICE_TYPE
b) Verify for a new OfficeTypes row, the office type values are from OFFICE_TYPE

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
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
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
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
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
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
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
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
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
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
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
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
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
