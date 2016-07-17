Meta:@EditOfficeBasicInfo @Edit @Office @AllStories

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal
JIRA ID - ZEUS-1066 - User can edit Office's Opened Date
and
JIRA ID - ZEUS-1073 - User can edit Office's Names

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

Scenario: Verify Office Name Type dropdown values are from lookup OFFICE_NAME_TYPE
a) Verify for an existing Office Name row, the Office Type values are from OFFICE_NAME_TYPE
b) Verify for a new Office Name row, the Office Type values are from OFFICE_NAME_TYPE

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
Then the user should see the office_name_second_row_existing_office_name_type_dropdown values in office's section from lookup OFFICE_NAME_TYPE
When the user clicks on add new office name button in the office name page
Then the user should see the office_name_first_row_new_office_name_type_dropdown values in office's section from lookup OFFICE_NAME_TYPE

Examples:
|entity|searchBy|fid|officeFid|
|1010|FID|1010|1010-44|


Scenario: Update and Save office names
User selects a value for an existing row for Type, Value and click Save. Updated office name should be saved in Zeus document

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
Then the user should see officename values as <type><value> for fid <officeFid> in zeus document
And the user reverts the changes to the document

Examples:
|entity|searchBy|fid|officeFid|type|value|
|1010|FID|1010|1010-44|Former Name|abc|

Scenario: Update and Save office names
User selects a value for a new row for Type, Value and click Save. Updated office name should be saved in Zeus document

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
Then the user should see officename values as <type><value> for fid <officeFid> in zeus document
And the user reverts the changes to the document

Examples:
|entity|searchBy|fid|officeFid|type|value|
|1010|FID|1010|1010-44|Former Name|xyz|

Scenario: verify no required message for office names type, value when both are null for a new row.

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
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
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
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
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
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
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
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
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

Scenario: verify the length for value and user should see the validation error when user enters more than 75 charecters

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
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


