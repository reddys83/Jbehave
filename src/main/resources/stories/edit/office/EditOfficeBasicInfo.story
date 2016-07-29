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
JIRA ID - ZEUS-1075 - User can select to edit Office's Locations

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
Then the user verifies office opened date from zeus document <officeFid> <day> <month> <year>


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
Then the user verifies office opened date from zeus document <officeFid> <day> <month> <year>


Examples:
|entity|searchBy|fid|officeFid|day|month|year|
|1010|FID|1010|1010-44||||


Scenario: Verify the default Edit value and Save Lead Location value for an office
       a. Select the value as True for Lead Location flag and Save for an office with a default value as True or False
       b. Select the value as False for Lead Location flag and Save for an office with a default value as True or False

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
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
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
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
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


Scenario: Verify that the add button is disabled for the first row of office location when there is a location

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
And the user gets the document with get id for offices with the <officeFid> from the database
Then the user should see the office_first_row_existing_location_add_button in disabled state in locations section

Examples:
|entity|searchBy|fid|officeFid|
|1010|FID|1010|1010-44|



Scenario: Verify that the user should be able to add a new row when there is no location

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
And the user gets the document with get id for offices with the <officeFid> from the database
And the user clicks on the add new office location button in the office page

Examples:
|entity|searchBy|fid|officeFid|
|50900|FID|50900|50900-0|


Scenario: Verify that the user should be able to delete an existing office location row

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
And the user gets the document with get id for offices with the <officeFid> from the database
And the user clicks on delete office locations row button for the row office_first_existing_row_location_delete_button
Then the user should see the delete row confirmation modal in the office page
When the user clicks on the yes button in the delete row confirmation modal in the office page
And the user clicks on the save button
Then the user should see the save confirmation modal
And the user should see the below summary changes in confirmation modal
|Summary|
|Basic Info|
When the user clicks on the confirm button
Then the user should not see the office location row in the locations office page
And the user reverts the changes to the document

Examples:
|entity|searchBy|fid|officeFid|
|299676|FID|299676|299676-0|



Scenario: Verify that the user should be able to delete a new office location row

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
And the user gets the document with get id for offices with the <officeFid> from the database
And the user clicks on the add new office location button in the office page
And the user clicks on delete office locations row button for the row office_first_new_row_location_delete_button
Then the user should see the delete row confirmation modal in the office page
When the user clicks on the yes button in the delete row confirmation modal in the office page
And the user clicks on the save button
Then the user should see the save confirmation modal
And the user should see the below summary changes in confirmation modal
|Summary|
|Basic Info|
When the user clicks on the confirm button
Then the user should not see the office location row in the locations office page
And the user reverts the changes to the document

Examples:
|entity|searchBy|fid|officeFid|
|249093|FID|249093|249093-0|

Scenario: Verify the default Edit value and change Primary flag Office value for an office
Select the value as True for Primary flag when the default value if False


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
And the user selects primary flag  value <primaryFlag> in the office locations


Examples:
|entity|searchBy|fid|officeFid|primaryFlag|
|17649|FID|17649|17649-0|true|


Scenario: a)Verify that the user should be able to Add new address row for an office location
          b)Verify User can select a new value for Type, Address Line 1,Address Line 2,Address Line 3,Address Line 4

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
And the user clicks on add new office address button in the office locations
And the user selects office address type office_addressType_first_row_new_address_type_dropdown value as <Type>
And the user enters office address address line 1 office_address_first_row_new_addressLine1 value as <AddressLine1>
And the user enters office address address line 2 office_address_first_row_new_addressLine2 value as <AddressLine2>
And the user enters office address address line 3 office_address_first_row_new_addressLine3 value as <AddressLine3>
And the user enters office address address line 4 office_address_first_row_new_addressLine4 value as <AddressLine4>

Examples:
|entity|searchBy|fid|officeFid|Type|AddressLine1|AddressLine2|AddressLine3|AddressLine4|
|1010|FID|1010|1010-45|physical|123 Marie Ln|345 Palmer Dr|456 Franklin Ln|789 Apple Valley|

Scenario: Verify User can select a new value for Country,Area,Subarea,City

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
When the user enters the office country <country> in the type-ahead box
Then the user should see the list of all existing area for the selected country by full name in office address
When the user enters the office area <area> in the type-ahead box
Then the user should see the list of all existing subarea for the selected area by full name in office address
When the user enters the office subarea <subarea> in the type-ahead box
Then the user should see the below cities for the selected area:
|CITIES|
|Gibson City|
|Kempton|
|Melvin|
|Paxton|
|Piper City|
|Roberts|
|Stelle|

Examples:
|entity|searchBy|fid|officeFid|country|area|subarea|
|1010|FID|1010|1010-45|USA|Illinois|Ford|

Scenario: Verify return all cities.

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
And the user enters the office country <country> in the type-ahead box
When the user clicks on the choose an area option
Then the user should see the below states for the selected country:
|AREAS|
|Return All Cities|
|No Area|
When the user enters the office area <area> in the type-ahead box
Then the user should see the list of all existing city for the selected area by full name in office address

Examples:
|entity|searchBy|fid|officeFid|country|area|
|1010|FID|1010|1010-45|Gabon|Return All Cities|

Scenario: Verify User can select a new value for Postal Code, Postal Code Suffix, Info

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
And the user clicks on add new office address button in the office locations
And the user enters office address postal code office_address_first_row_new_postalCode value as <PostalCode>
And the user enters office address postal code suffix office_address_first_row_new_postalCodeSuffix value as <PostalCodeSuffix>
And the user enters office address info office_address_first_row_new_Info value as <Info>
Examples:
|entity|searchBy|fid|officeFid|PostalCode|PostalCodeSuffix|Info|
|1010|FID|1010|1010-45|60126|123|adhsbd|

Scenario: Verify that the user should be able to delete a new office address row

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
And the user gets the document with get id for offices with the <officeFid> from the database
And the user clicks on the add new office location button in the office page
And the user clicks on add new office address button in the office locations
And the user clicks on delete office address row button for the row office_first_new_row_address_delete_button
Then the user should see the delete row confirmation modal in the office page
When the user clicks on the yes button in the delete row confirmation modal in the office page
And the user clicks on the save button
Then the user should see the save confirmation modal
And the user should see the below summary changes in confirmation modal
|Summary|
|Basic Info|
When the user clicks on the confirm button
Then the user should not see the office address row in the locations office page
And the user reverts the changes to the document

Examples:
|entity|searchBy|fid|officeFid|
|249093|FID|249093|249093-0|

Scenario: a)Verify that the user should be able to Add new telecoms row for an office location
          b)Verify User can select a new value for Type,Rank,TextBefore,Value,RangeLimit,Ext,TextAfter,AnswerBack

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
And the user clicks on add new office telecoms button in the office locations
And the user selects office telecoms type office_telecomsType_first_row_new_telecoms_type_dropdown $typeRowIdentifier value as <Type>
And the user enters office telecoms rank office_telecoms_first_row_new_rank value as <Rank>
And the user enters office telecoms text before office_telecoms_first_row_new_textBefore value as <TextBefore>
And the user enters office telecoms value office_telecoms_first_row_new_value value as <Value>
And the user enters office telecoms range limit office_telecoms_first_row_new_rangeLimit value as <RangeLimit>
And the user enters office telecoms ext office_telecoms_first_row_new_ext value as <Ext>
And the user enters office telecoms text after office_telecoms_first_row_new_textAfter value as <TextAfter>
And the user enters office telecoms answer back office_telecoms_first_row_new_answerBack value as <AnswerBack>

Examples:
|entity|searchBy|fid|officeFid|Type|Rank|TextBefore|Value|RangeLimit|Ext|TextAfter|AnswerBack|
|1010|FID|1010|1010-45|telephone|1|5 pm|7081335467|20|123|9 am|1 hr|

Scenario: Verify that the user should be able to delete a new office telecoms row

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
And the user gets the document with get id for offices with the <officeFid> from the database
And the user clicks on add new office telecoms button in the office locations
And the user clicks on delete office telecoms row button for the row office_first_new_row_telecoms_delete_button
Then the user should see the delete row confirmation modal in the office page
When the user clicks on the yes button in the delete row confirmation modal in the office page
And the user clicks on the save button
Then the user should see the save confirmation modal
And the user should see the below summary changes in confirmation modal
|Summary|
|Basic Info|
When the user clicks on the confirm button
Then the user should not see the office telecoms row in the locations office page
And the user reverts the changes to the document

Examples:
|entity|searchBy|fid|officeFid|
|1010|FID|1010|1010-45|




