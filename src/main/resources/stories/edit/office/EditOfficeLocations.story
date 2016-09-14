Meta:@EditOfficeLocations @Edit @Office @AllStories

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

JIRA ID - ZEUS-1075 - User can select to edit Office's Locations
!--and
!--JIRA ID - ZEUS-1299 - User can edit Office's Locations(Addresses)
!--and
!--JIRA ID - ZEUS-1300 - User can edit Office's Locations(Telecoms)

Scenario: Verify that the add button is disabled for the first row of office location when there is a location

Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
And the user clicks on the office locations link in the navigation bar
And the user clicks on the office update link
And the user gets the document with get id for offices with the <officeFid> from the database
Then the user should see the office_first_row_existing_location_add_button in disabled state in locations section

Examples:
|entity|searchBy|fid|officeFid|
|1010|FID|1010|1010-44|

Scenario: Verify that the user should be able to add a new row when there is no location with no values and verify the added row is not added in UI and Zeus

Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
And the user clicks on the office locations link in the navigation bar
And the user clicks on the office update link
And the user gets the document with get id for offices with the <officeFid> from the database
And the user clicks on the add new office location button in the office page
!--Then the user should see the save confirmation modal
!--And the user should see the below summary changes in confirmation modal
!--|Summary|
!--|Basic Info|
!--When the user clicks on the confirm button
!-- Then the user should see the successful update message at top of the office page
!-- And the user should not see the newly added locations row in the office locations page
!-- Then the user verifies that the deleted row for office locations does not exist in zeus document
!-- And the user reverts the changes to the document

Examples:
|entity|searchBy|fid|officeFid|
|50900|FID|50900|50900-0|

Scenario: Verify that the user should be able to edit an existing office location row
a) - Verify if User can prevent deleting the location row by clicking on 'No'.
b) - Verify if User can delete the location row by clicking on 'Yes'.

Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
And the user clicks on the office locations link in the navigation bar
And the user clicks on the office update link
And the user gets the document with get id for offices with the <officeFid> from the database
And the user clicks on delete office locations row button for the row office_first_existing_row_location_delete_button
Then the user should see the delete row confirmation modal in the office locations
When the user clicks on the cancel no button
!-- The below three steps are the extra steps as the save functionality is not implemented in this story. These steps can be removed for 1299 and 1300
And the user clicks on the cancel button
Then the user should see the cancel update confirmation modal
When the user clicks on the cancel yes button
!-- When the user clicks on the save button
!-- When the user clicks on the confirm button
!-- Then the user verifies that the row values exists in the office locations page
When the user clicks on the office update link
And the user gets the document with get id for offices with the <officeFid> from the database
And the user clicks on delete office locations row button for the row office_first_existing_row_location_delete_button
Then the user should see the delete row confirmation modal in the office locations
When the user clicks on the Yes button to confirm the deletion of row in office locations section
!-- And the user clicks on the save button
!-- Then the user should see the save confirmation modal
!-- And the user should see the below summary changes in confirmation modal
!-- |Summary|
!-- |Basic Info|
!-- When the user clicks on the confirm button
!-- Then the user should not see the office address row in the locations office page
!-- And the user verifies that the deleted row for office locations does not exist in zeus document
!-- And the user reverts the changes to the document


Examples:
|entity|searchBy|fid|officeFid|
|299676|FID|299676|299676-0|

Scenario: Verify that the user should be able to edit a new office location row
a) - Verify if User can prevent deleting the location row by clicking on 'No'.
b) - Verify if User can delete the location row by clicking on 'Yes'.

Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
And the user clicks on the office locations link in the navigation bar
And the user clicks on the office update link
And the user gets the document with get id for offices with the <officeFid> from the database
And the user clicks on the add new office location button in the office page
And the user clicks on delete office locations row button for the row office_first_new_row_location_delete_button
Then the user should see the delete row confirmation modal in the office locations
When the user clicks on the cancel no button
!-- The below three steps are the extra steps as the save functionality is not implemented in this story. These steps can be removed for 1299 and 1300
And the user clicks on the cancel button
Then the user should see the cancel update confirmation modal
When the user clicks on the cancel yes button
!-- When the user clicks on the save button
!-- When the user clicks on the confirm button
!-- Then the user verifies that the row values exists in the office locations page
When the user clicks on the office update link
And the user gets the document with get id for offices with the <officeFid> from the database
And the user clicks on the add new office location button in the office page
And the user clicks on delete office locations row button for the row office_first_new_row_location_delete_button
Then the user should see the delete row confirmation modal in the office locations
When the user clicks on the Yes button to confirm the deletion of row in office locations section
!-- And the user clicks on the save button
!-- Then the user should see the save confirmation modal
!-- And the user should see the below summary changes in confirmation modal
!-- |Summary|
!-- |Basic Info|
!-- When the user clicks on the confirm button
!-- Then the user should not see the office location row in the locations office page
!-- And the user verifies that the deleted row for office locations does not exist in zeus document
!-- And the user reverts the changes to the document

Examples:
|entity|searchBy|fid|officeFid|
|249093|FID|249093|249093-0|

Scenario: Verify the default Edit value and change Primary flag Office value for an office
Select the value as True for Primary flag when the default value if False

Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
And the user clicks on the office locations link in the navigation bar
And the user clicks on the office update link
When the user gets the document with get id for offices with the <officeFid> from the database
And the user selects primary flag  value <primaryFlag> in the office locations
!-- And the user clicks on the save button
!-- Then the user should see the save confirmation modal
!-- And the user should see the below summary changes in confirmation modal
!-- |Summary|
!-- |Office Locations|
!-- When the user clicks on the confirm button
!-- Then the user should see the successful update message at top of the office page
!-- And the user should see office location primary flag value as <primaryFlag> for fid <officeFid> in zeus document and in zeus UI

Examples:
|entity|searchBy|fid|officeFid|primaryFlag|
|17649|FID|17649|17649-0|true|

Scenario: a)Verify that the user should be able to Add new address row for an office location
          b)Verify User can select and save values for Type, Address Line 1,Address Line 2,Address Line 3,Address Line 4,Country,Area, Subarea,City,PostalCode,PostalCodeSuffix and Info
Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
And the user clicks on the office locations link in the navigation bar
And the user clicks on the office update link
When the user gets the document with get id for offices with the <officeFid> from the database
And the user clicks on add new office address button in the office locations
And the user selects office address type office_addressType_first_row_new_address_type_dropdown value as <Type>
And the user enters office address address line 1 office_address_first_row_new_addressLine1 value as <AddressLine1>
And the user enters office address address line 2 office_address_first_row_new_addressLine2 value as <AddressLine2>
And the user enters office address address line 3 office_address_first_row_new_addressLine3 value as <AddressLine3>
And the user enters office address address line 4 office_address_first_row_new_addressLine4 value as <AddressLine4>
When the user clicks on the choose a country option in the office locations
When the user enters the office country <Country> in the type-ahead box
Then the user should see the list of all existing area for the selected country by full name in office address
When the user clicks on the choose an area option in the office locations
When the user enters the office area <Area> in the type-ahead box
Then the user should see the list of all existing subarea for the selected area by full name in office address
When the user clicks on the choose a subarea option in the office locations
When the user enters the office subarea <subArea> in the type-ahead box
When the user clicks on the choose a city option in the office locations
When the user enters the office city <City> in the type-ahead box
Then the user should see the list of all existing city for the selected area by full name in office address
When the user enters office address postal code office_address_first_row_new_postalCode value as <PostalCode>
And the user enters office address postal code suffix office_address_first_row_new_postalCodeSuffix value as <PostalCodeSuffix>
And the user enters office address info office_address_first_row_new_info value as <Info>
!-- And the user clicks on the save button
!-- Then the user should see the save confirmation modal
!-- And the user should see the below summary changes in confirmation modal
!-- |Summary|
!-- |Office Locations|
!-- When the user clicks on the confirm button
!-- Then the user should see the successful update message at top of the office page
!-- And the user verifies that the office address lines addresses are entered in the office locations page
!-- And the user should see the office address lines addresses as in zeus document
!-- And the user reverts the changes to the document

Examples:
|entity|searchBy|fid|officeFid|Type|AddressLine1|AddressLine2|AddressLine3|AddressLine4|Country|Area|subArea|City|PostalCode|PostalCodeSuffix|Info|
|1010|FID|1010|1010-45|mailing|123 Marie Ln|345 Palmer Dr|456 Franklin Ln|789 Apple Valley|USA|Illinois|Warren|Alexis|60126|123|adhsbd|

Scenario: Verify return all cities.

Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
And the user clicks on the office locations link in the navigation bar
And the user clicks on the office update link
And the user clicks on add new office address button in the office locations
When the user gets the document with get id for offices with the <officeFid> from the database
When the user clicks on the choose a country option in the office locations
When the user enters the office country <Country> in the type-ahead box
When the user clicks on the choose an area option in the office locations
Then the user should see the below office states for the selected country:
|AREAS|
|No Area|
|Return All Cities|
When the user enters the office area <Area> in the type-ahead box
When the user clicks on the choose a city option in the office locations
Then the user should see the list of all existing city for the selected area by full name in office address

Examples:
|entity|searchBy|fid|officeFid|Country|Area|
|1010|FID|1010|1010-45|USA|Return All Cities|

Scenario: Verify return cities wth no area

Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
And the user clicks on the office locations link in the navigation bar
And the user clicks on the office update link
And the user clicks on add new office address button in the office locations
When the user gets the document with get id for offices with the <officeFid> from the database
When the user clicks on the choose a country option in the office locations
When the user enters the office country <Country> in the type-ahead box
When the user clicks on the choose an area option in the office locations
When the user enters the office area <Area> in the type-ahead box
And the user clicks on the choose a city option in the office locations
Then the user should see the list of all existing city for the selected area by full name in office address

Examples:
|entity|searchBy|fid|officeFid|Country|Area|
|1010|FID|1010|1010-45|USA|No Area|

Scenario: Verify the values of area,subarea,city should be changed to null when the country value is changed

Meta: @skip
Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
And the user clicks on the office locations link in the navigation bar
And the user clicks on the office update link
When the user gets the document with get id for offices with the <officeFid> from the database
When the user clicks on the choose a country option in the office locations
When the user enters the office country <Country> in the type-ahead box
Then the user should see the area dropdown with Choose an area selected
And the user should see the area dropdown with Choose an area selected
And the user should see the subarea dropdown with Choose a subarea selected
And the user should see the city dropdown with Choose a city selected


Examples:
|entity|searchBy|fid|officeFid|Country|
|1010|FID|1010|1010-45|Canada|


Scenario: Verify the values of subarea,city should be changed to null when the area value is changed

Meta: @skip
Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
And the user clicks on the office locations link in the navigation bar
And the user clicks on the office update link
When the user gets the document with get id for offices with the <officeFid> from the database
And the user clicks on the choose an area option in the office locations
And the user enters the office area <Area> in the type-ahead box
Then the user should see the subarea dropdown with Choose a subarea selected
And the user should see the city dropdown with Choose a city selected


Examples:
|entity|searchBy|fid|officeFid|Area|
|1010|FID|1010|1010-45|

Scenario: Verify the value of city should be changed to null when the subarea value is changed

Meta: @skip
Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
And the user clicks on the office locations link in the navigation bar
And the user clicks on the office update link
When the user gets the document with get id for offices with the <officeFid> from the database
And the user clicks on the choose a subarea option in the office locations
And the user enters the office subarea <subArea> in the type-ahead box
Then the user should see the city dropdown with Choose a city selected


Examples:
|entity|searchBy|fid|officeFid|subArea|
|1010|FID|1010|1010-45|Kings|

Scenario: Verify that the user should be able to edit an existing office address row
a) - Verify if User can prevent deleting the location row by clicking on 'No'.
b) - Verify if User can delete the location row by clicking on 'Yes'.


Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
And the user clicks on the office locations link in the navigation bar
And the user clicks on the office update link
And the user gets the document with get id for offices with the <officeFid> from the database
When the user selects office address type office_addressType_first_row_existing_address_type_dropdown value as <Type>
And the user clicks on delete office address row button for the row office_first_existing_row_address_delete_button
Then the user should see the delete row confirmation modal
When the user clicks on the No button to cancel the deletion of row in office locations page
!-- And the user clicks on the save button
!-- And the user clicks on the confirm button
!-- Then the user verifies that the row values exists in the office locations page
And the user gets the document with get id for offices with the <officeFid> from the database
When the user selects office address type office_addressType_first_row_existing_address_type_dropdown value as <Type>
And the user clicks on delete office address row button for the row office_first_existing_row_address_delete_button
Then the user should see the delete row confirmation modal
When the user clicks on the yes button in the delete row confirmation modal in the office page
!-- And the user clicks on the save button
!--Then the user should see the save confirmation modal
!--And the user should see the below summary changes in confirmation modal
!--|Summary|
!--|Basic Info|
!--When the user clicks on the confirm button
!--Then the user should not see the office address row in the locations office page
!--And the user verifies that the deleted row for office address does not exist in zeus document
!--And the user reverts the changes to the document

Examples:
|entity|searchBy|fid|officeFid|
|1010|FID|1010|1010-54|


Scenario: a)Verify that the delete button is disabled for the office address row where the address type is physical when the Legal Entity is associated with the office is a "deposit taking institution"
          b)Verify that the user should be able to add a new office address when the adddress type is mailing

Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
And the user clicks on the office locations link in the navigation bar
And the user clicks on the office update link
And the user gets the document with get id for offices with the <officeFid> from the database
Then the user should see the office_first_row_existing_delete_address_type_physical_button in disabled state in locations section
When the user selects office address type office_addressType_first_row_existing_address_type_dropdown value as <Type>
And the user clicks on add new office address button in the office locations
When the user selects office address type office_addressType_first_row_new_address_type_dropdown value as <Type1>
Then the user should see the office_first_row_new_delete_address_type_physical_button in disabled state in locations section

Examples:
|entity|searchBy|fid|officeFid|Type|Type1|
|1010|FID|1010|1010-44|mailing|physical|

Scenario:  Verify Office Address Type dropdown values are from lookup ADDRESS_TYPE

Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
And the user clicks on the office locations link in the navigation bar
And the user clicks on the office update link
And the user clicks on add new office address button in the office locations
When the user gets the document with get id for offices with the <officeFid> from the database
Then the user should see the office_addressType_second_row_address_type_dropdown values in office location's section from lookup ADDRESS_TYPE except the values that are selected already

Examples:
|entity|searchBy|fid|officeFid|
|1010|FID|1010|1010-44|

Scenario: a) Verify that the error message required is displayed when the the Address Type dropdown is left blank
          b) Verify that the error message required is not displayed when the Address Line1,Address Line2, Address Line3, Address Line 4, Postal Code, Postal Code Suffix, Info are left blank
Meta: @skip
Given a user is on the search page
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
And the user enters office address postal code office_address_first_row_new_postalCode value as <PostalCode>
And the user enters office address postal code suffix office_address_first_row_new_postalCodeSuffix value as <PostalCodeSuffix>
And the user enters office address info office_address_first_row_new_Info value as <Info>
And the user clicks on the save button
Then the user should see the error message Required. for the office address type field
And the user should see the error message at top of page the highlighted fields must be addressed before this update can be saved

Examples:
|entity|searchBy|fid|officeFid|Type|AddressLine1|AddressLine2|AddressLine3|AddressLine4|PostalCode|PostalCodeSuffix|Info|
|1010|FID|1010|1010-44|||||||||

Scenario: Verify office Address Line 1,Address Line 2,Address Line 3,Address Line3,Address Line 4, Postal Code, Postal Code Sufffix,Info field max length
Meta: @skip
Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
And the user clicks on the office update link
When the user gets the document with get id for offices with the <officeFid> from the database
And the user clicks on add new office address button in the office locations
Then the user verifies the office <AddressLine1> maxlength is 70 for the office_address_first_row_new_addressLine1
And the user verifies the office <AddressLine2> maxlength is 70 for the office_address_first_row_new_addressLine2
And the user verifies the office <AddressLine3> maxlength is 70 for the office_address_first_row_new_addressLine3
And the user verifies the office <AddressLine4> maxlength is 70 for the office_address_first_row_new_addressLine4
And the user verifies the office <PostalCode> maxlength is 70 for the office_address_first_row_new_postalCode
And the user verifies the office <PostalCodeSuffix> maxlength is 20 for the office_address_first_row_new_postalCodeSuffix
And the user verifies the office <Info> maxlength is 50 for the office_address_first_row_new_info
Then the user should see the save confirmation modal
When the user clicks on the confirm button
Then the user reverts the changes to the document

Examples:
|entity|searchBy|fid|officeFid|
|1010|FID|1010|1010-44|

Scenario: Verify that the error message "At least one physical address required" is displayed when none of the Address Type is physical
Meta: @skip
Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
And the user clicks on the office update link
When the user gets the document with get id for offices with the <officeFid> from the database
And the user selects office address type office_addressType_first_row_existing_address_type_dropdown value as <Type>
And the user clicks on the save button
Then the user should see the error message At least one physical address required for the office address type field
And the user should see the error message at top of page the highlighted fields must be addressed before this update can be saved

Examples:
|entity|searchBy|fid|officeFid|Type|
|1010|FID|1010|1010-44|Mailing|

Scenario: a)Verify that the error message "required" is displayed when Country is null(Choose a Country) and when the Address Type is not null
          b)Verify that the error message "required" is displayed when City is null(Choose a City) and when the Address Type is not null
Meta: @skip
Given a user is on the search page
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
When the user enters the office country <Country> in the type-ahead box
And the user clicks on the save button
Then the user should see the error message required for the office country field
And the user should see the error message at top of page the highlighted fields must be addressed before this update can be saved
When the user selects office address type office_addressType_first_row_new_address_type_dropdown value as <Type>
When the user enters the office city <City> in the type-ahead box
And the user clicks on the save button
Then the user should see the error message required for the office country field
And the user should see the error message at top of page the highlighted fields must be addressed before this update can be saved

Examples:
|entity|searchBy|fid|officeFid|Type|Country|
|1010|FID|1010|1010-44|Mailing|USA||

Scenario:  Verify Office Telecoms Type dropdown values are from lookup TELECOM_TYPE
Meta: @qatest
Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
And the user clicks on the office locations link in the navigation bar
And the user clicks on the office update link
When the user deletes the existing office telecom locations values in fdb document
And the user clicks on add new office telecoms button in the office locations
Then the user should see the office_locations_telecoms_type_dropdown_options values in office telecoms's section from lookup TELECOM_TYPE
Then the user should see the office telecom values same as in trusted document

Examples:
|entity|searchBy|fid|officeFid|
|1010|FID|1010|1010-44|

Scenario: a)Verify that the user should be able to Add new telecoms row for an office location
          b)Verify user can select a new value for Telecom Type as telephone and Verify that the user can see and select values for the following fields :Rank,TextBefore,Country code,Area code,Number,RangeLimit,Ext,TextAfter
          c)Verify user can select a new value for Telecom Type as fax and Verify that the user can see and select values for the following fields :Rank,TextBefore,Country code,Area code,Number,RangeLimit,Ext,TextAfter

Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
And the user clicks on the office locations link in the navigation bar
And the user clicks on the office update link
When the user gets the document with get id for offices with the <officeFid> from the database
When the user deletes the existing office telecom locations values in fdb document
When the user deletes the existing office telecom locations rows
And the user clicks on add new office telecoms button in the office locations
And the user selects office telecoms type office_telecoms_first_row_new_telecoms_type_dropdown value as <Type>
And the user enters office telecoms rank office_telecoms_first_row_new_rank value as <Rank>
And the user enters office telecoms text before office_telecoms_first_row_new_textBefore value as <TextBefore>
And the user enters office telecoms value office_telecoms_first_row_new_CountryCode value as <CountryCode>
And the user enters office telecoms value office_telecoms_first_row_new_AreaCode value as <AreaCode>
And the user enters office telecoms value office_telecoms_first_row_new_Number value as <Number>
And the user enters office telecoms range limit office_telecoms_first_row_new_rangeLimit value as <RangeLimit>
And the user enters office telecoms ext office_telecoms_first_row_new_ext value as <Ext>
And the user enters office telecoms text after office_telecoms_first_row_new_textAfter value as <TextAfter>
And the user clicks on the save button
When the user clicks on the confirm button
Then the user should see the successful update message at top of the office page
And the user verifies that the office telecom fields for Type(telephone/fax) are entered in the office locations page
Then the user should see the office telecomm fields for Type(telephone/fax) as in zeus document
And the user reverts the changes to the document

Examples:
|entity|searchBy|fid|officeFid|Type|Rank|TextBefore|CountryCode|AreaCode|Number|RangeLimit|Ext|TextAfter|
|1038|FID|1038|1038-51|telephone|1|5 pm|708|298|3125|20|123|9 am|
|1038|FID|1038|1038-51|fax|1|5 pm|708|298|3142|20|123|9 am|

Scenario:User is updating an Office's Locations (Telecom)- For Type - 'Telephone' or 'Fax' 
a) Verify that the error message "Enter up to 4 valid numbers" is displayed when the 'Rank' field is blank.
b) Verify that the error message "Enter up to 20 valid characters" is displayed when the 'Value' field is blank.
c) Verify that the error message "Enter up to 4 valid numbers" is displayed when alphabets are entered for 'Rank' field.
d) Verify that the error message "Numbers and spaces allowed only" is displayed when invalid characters are entered for 'Country Code' field.
e) Verify that the error message "Enter up to 10 valid characters" is displayed when invalid characters are entered for 'Area Code' field.
f) Verify that the error message "Numbers and spaces allowed only" is displayed when invalid characters are entered for 'Number' field.
g) Verify that the error message "Enter up to 20 valid characters" is displayed when invalid characters are entered for 'Range Limit' field.
h) Verify that the error message "Enter up to 10 valid characters" is displayed when invalid characters are entered for 'Ext' field.

Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
And the user clicks on the office locations link in the navigation bar
And the user clicks on the office update link
When the user gets the document with get id for offices with the <officeFid> from the database
When the user deletes the existing office telecom locations rows
And the user clicks on add new office telecoms button in the office locations
And the user selects office telecoms type office_telecoms_first_row_new_telecoms_type_dropdown value as <Type>
Then the user verifies the office Rank maxlength is 4 for the office_telecoms_first_row_new_rank
Then the user verifies the office TextBefore maxlength is 50 for the office_telecoms_first_row_new_textBefore
Then the user verifies the office CountryCode maxlength is 5 for the office_telecoms_first_row_new_CountryCode
Then the user verifies the office AreaCode maxlength is 10 for the office_telecoms_first_row_new_AreaCode
Then the user verifies the office Number maxlength is 20 for the office_telecoms_first_row_new_Number
Then the user verifies the office RangeLimit maxlength is 20 for the office_telecoms_first_row_new_rangeLimit
Then the user verifies the office Ext maxlength is 10 for the office_telecoms_first_row_new_ext
Then the user verifies the office TextAfter maxlength is 50 for the office_telecoms_first_row_new_textAfter
When the user clicks on the save button
Then the user should see the error message Enter up to 4 valid numbers. for the office telecom rank field
Then the user should see the error message Enter up to 20 valid characters. for the office value field
When the user enters office telecoms rank office_telecoms_first_row_new_rank value as <Rank>
And the user enters office telecoms value office_telecoms_first_row_new_CountryCode value as <CountryCode>
And the user enters office telecoms value office_telecoms_first_row_new_AreaCode value as <AreaCode>
And the user enters office telecoms value office_telecoms_first_row_new_Number value as <Number>
When the user enters office telecoms range limit office_telecoms_first_row_new_rangeLimit value as <RangeLimit>
And the user enters office telecoms ext office_telecoms_first_row_new_ext value as <Ext>
And the user clicks on the save button
Then the user should see the error message Enter up to 4 valid numbers. for the office telecom rank field
Then the user should see the error message <errorText> for the office telecom value field
Then the user should see the error message Enter up to 20 valid characters. for the office range limit field
Then the user should see the error message Enter up to 10 valid characters. for the office ext field
And the user should see the error message at top of page the highlighted fields must be addressed before this update can be saved

Examples:
|entity|searchBy|fid|officeFid|Type|Rank|CountryCode|AreaCode|Number|RangeLimit|Ext|errorText|
|1010|FID|1010|1010-44|telephone|Text|Text|123|456|Text|Text|Numbers and spaces allowed only|
|1010|FID|1010|1010-44|telephone|Text|123|Text|456|Text|Text|Enter up to 10 valid characters.|
|1010|FID|1010|1010-44|telephone|Text|123|456|Text|Text|Text|Numbers and spaces allowed only|
|1010|FID|1010|1010-44|fax|Text||456|123|Text|Text|Enter up to 5 valid characters.|
|1010|FID|1010|1010-44|fax|Text|123|456||Text|Text|Enter up to 20 valid characters.|

Scenario: a)Verify user can select a new value for Telecom Type as telex and Verify that the user can see and select values for the following fields :Rank,TextBefore,Value,TextAfter,AnswerBack
          b)Verify user can select a new value for Telecom Type as reuters and Verify that the user can see and select values for the following fields :Rank,TextBefore,Value,TextAfter,AnswerBack
          c)Verify user can select a new value for Telecom Type as cable and Verify that the user can see and select values for the following fields :Rank,TextBefore,Value,TextAfter,AnswerBack

Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
And the user clicks on the office locations link in the navigation bar
And the user clicks on the office update link
When the user gets the document with get id for offices with the <officeFid> from the database
When the user deletes the existing office telecom locations values in fdb document
When the user deletes the existing office telecom locations rows
And the user clicks on add new office telecoms button in the office locations
And the user selects office telecoms type office_telecoms_first_row_new_telecoms_type_dropdown value as <Type>
And the user enters office telecoms rank office_telecoms_first_row_new_rank value as <Rank>
And the user enters office telecoms text before office_telecoms_first_row_new_textBefore value as <TextBefore>
And the user enters office telecoms value office_telecoms_first_row_new_value value as <Value>
And the user enters office telecoms text after office_telecoms_first_row_new_textAfter value as <TextAfter>
And the user enters office telecoms answer back office_telecoms_first_row_new_answerBack value as <AnswerBack>
And the user clicks on the save button
Then the user should see the save confirmation modal
And the user should see the below summary changes in confirmation modal
|Summary|
|Locations|
When the user clicks on the confirm button
Then the user should see the successful update message at top of the office page
And the user verifies that the office telecom fields for Type(telex/reuters/cable) are entered in the office locations page
And the user should see the office telecomm fields for Type(telex/reuters/cable) as in zeus document
And the user reverts the changes to the document

Examples:
|entity|searchBy|fid|officeFid|Type|Rank|TextBefore|Value|TextAfter|AnswerBack|
|1038|FID|1038|1038-51|telex|1|5 pm|abc|9 am|1 hr|
|1038|FID|1038|1038-51|reuters|1|5 pm|afv|9 am|1 hr|
|1038|FID|1038|1038-51|cable|1|5 pm|hsn|9 am|1 hr|

Scenario:User is updating an Office's Locations (Telecom)- For Type - 'Telex', 'Reuters', 'Cable', 'Website' 
a) Verify that the error message "Enter up to 4 valid numbers" is displayed when the 'Rank' field is blank.
b) Verify that the error message "Enter up to 100 valid characters" is displayed when the 'Value' field is blank.
c) Verify that the error message "Enter up to 4 valid numbers" is displayed when alphabets are entered for 'Rank' field.

Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
And the user clicks on the office locations link in the navigation bar
And the user clicks on the office update link
When the user deletes the existing office telecom locations rows
And the user clicks on add new office telecoms button in the office locations
And the user selects office telecoms type office_telecoms_first_row_new_telecoms_type_dropdown value as <Type>
Then the user verifies the office AnswerBack maxlength is 20 for the office_telecoms_first_row_new_answerBack
Then the user verifies the office Value maxlength is 100 for the office_telecoms_first_row_new_value
When the user clicks on the save button
Then the user should see the error message Enter up to 4 valid numbers. for the office telecom rank field
Then the user should see the error message Enter up to 100 valid characters. for the office value field
When the user enters office telecoms rank office_telecoms_first_row_new_rank value as <Rank>
And the user clicks on the save button
Then the user should see the error message Enter up to 4 valid numbers. for the office telecom rank field
And the user should see the error message at top of page the highlighted fields must be addressed before this update can be saved

Examples:
|entity|searchBy|fid|officeFid|Type|Rank|
|1010|FID|1010|1010-44|telex|Text|
|1010|FID|1010|1010-44|reuters|Text|
|1010|FID|1010|1010-44|cable|Text|
|1010|FID|1010|1010-44|website|Text|

Scenario: a)Verify user can select a new value for Telecom Type as email and Verify that the user can see and select values for the following fields :Rank,TextBefore,Value,TextAfter
          b)Verify user can select a new value for Telecom Type as website and Verify that the user can see and select values for the following fields :Rank,TextBefore,Value,TextAfter

Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
And the user clicks on the office locations link in the navigation bar
And the user clicks on the office update link
When the user gets the document with get id for offices with the <officeFid> from the database
When the user deletes the existing office telecom locations values in fdb document
When the user deletes the existing office telecom locations rows
And the user clicks on add new office telecoms button in the office locations
And the user selects office telecoms type office_telecoms_first_row_new_telecoms_type_dropdown value as <Type>
And the user enters office telecoms rank office_telecoms_first_row_new_rank value as <Rank>
And the user enters office telecoms text before office_telecoms_first_row_new_textBefore value as <TextBefore>
And the user enters office telecoms value office_telecoms_first_row_new_value value as <Value>
And the user enters office telecoms text after office_telecoms_first_row_new_textAfter value as <TextAfter>
And the user clicks on the save button
Then the user should see the save confirmation modal
And the user should see the below summary changes in confirmation modal
|Summary|
|Locations|
When the user clicks on the confirm button
Then the user should see the successful update message at top of the office page
And the user verifies that the office telecom fields for Type(email/website) are entered in the office locations page
And the user should see the office telecomm fields for Type(email/website) as in zeus document
And the user reverts the changes to the document

Examples:
|entity|searchBy|fid|officeFid|Type|Rank|TextBefore|Value|TextAfter|
|1038|FID|1038|1038-60|email|1|5 pm|aft@zeus.com|5 pm|
|1038|FID|1038|1038-60|website|5|3 pm|www.zeus.com|4 pm|


Scenario:User is updating an Office's Locations (Telecom)- For Type - 'Email' 
a) Verify that the error message "Enter up to 4 valid numbers" is displayed when the 'Rank' field is blank.
b) Verify that the error message "Enter up to 100 valid characters" is displayed when the 'Value' field is blank.
c) Verify that the error message "Enter up to 4 valid numbers" is displayed when alphabets are entered for 'Rank' field.
d) Verify that the error message "Enter up to 100 valid characters" is displayed when a text without '@' key is entered for 'Value' field.

Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
And the user clicks on the office locations link in the navigation bar
And the user clicks on the office update link
When the user gets the document with get id for offices with the <officeFid> from the database
When the user deletes the existing office telecom locations rows
And the user clicks on add new office telecoms button in the office locations
And the user selects office telecoms type office_telecoms_first_row_new_telecoms_type_dropdown value as <Type>
And the user clicks on the save button
Then the user should see the error message Enter up to 4 valid numbers. for the office telecom rank field
Then the user should see the error message Enter up to 100 valid characters. for the office value field
When the user enters office telecoms rank office_telecoms_first_row_new_rank value as <Rank>
When the user enters office telecoms value office_telecoms_first_row_new_value value as <Value>
And the user clicks on the save button
Then the user should see the error message Enter up to 4 valid numbers. for the office telecom rank field
Then the user should see the error message Enter up to 100 valid characters. for the office value field
And the user should see the error message at top of page the highlighted fields must be addressed before this update can be saved

Examples:
|entity|searchBy|fid|officeFid|Type|Rank|Value|
|1010|FID|1010|1010-44|email|Text|www.zeus.com|

Scenario: a) Verify that the error message Enter upto 100 valid characters is displayed when the value field is left blank when telecom type is email
Meta: @skip
Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
When the user clicks on the office update link
And the user gets the document with get id for offices with the <officeFid> from the database
And the user clicks on add new office telecoms button in the office locations
And the user selects office address type office_addressType_first_row_new_address_type_dropdown value as <Type>
And the user enters office telecoms rank office_telecoms_first_row_new_rank value as <Rank>
And the user enters office telecoms text before office_telecoms_first_row_new_textBefore value as <TextBefore>
And the user enters office telecoms value office_telecoms_first_row_new_value value as <Value>
And the user clicks on the save button
Then the user should see the error message Enter up to valid 100 characters. for the office value field
And the user should see the error message at top of page the highlighted fields must be addressed before this update can be saved

Examples:
|entity|searchBy|fid|officeFid|Type|Rank|TextBefore|Value|
|1010|FID|1010|1010-44|email|2|||

Scenario: a) Verify that the error message incorrect format is displayed when the value field has incorrect format when telecom type is email
Meta: @skip
Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
When the user clicks on the office update link
And the user gets the document with get id for offices with the <officeFid> from the database
And the user clicks on add new office telecoms button in the office locations
And the user selects office address type office_addressType_first_row_new_address_type_dropdown value as <Type>
And the user enters office telecoms rank office_telecoms_first_row_new_rank value as <Rank>
And the user enters office telecoms text before office_telecoms_first_row_new_textBefore value as <TextBefore>
And the user enters office telecoms value office_telecoms_first_row_new_value value as <Value>
And the user clicks on the save button
Then the user should see the error message Incorrect format. for the office value field
And the user should see the error message at top of page the highlighted fields must be addressed before this update can be saved

Examples:
|entity|searchBy|fid|officeFid|Type|Rank|TextBefore|Value|
|1010|FID|1010|1010-44|email|2||@gkjhnhasdkjlk|


Scenario: a)Verify Office telecoms country code, Area code, Number,Rangelimit, allows only number and spaces and verify an error message Invalid characters: "Numbers and spaces allowed only" is displayed
          b) Verify Office ext field allows only numbers,hypens and spaces
Meta: @skip
Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
And the user clicks on the office update link
When the user gets the document with get id for offices with the <officeFid> from the database
And the user clicks on add new office telecoms button in the office locations
And the user selects office telecoms type office_telecoms_first_row_new_telecoms_type_dropdown value as <Type>
And the user enters office telecoms value office_telecoms_first_row_new_CountryCode value as <CountryCode>
And the user enters office telecoms value office_telecoms_first_row_new_AreaCode value as <AreaCode>
And the user enters office telecoms value office_telecoms_first_row_new_Number value as <Number>
And the user enters office telecoms range limit office_telecoms_first_row_new_rangeLimit value as <RangeLimit>
And the user enters office telecoms ext office_telecoms_first_row_new_ext value as <Ext>
And the user clicks on the save button
Then the user should see the error message Invalid characters: "Numbers and spaces allowed only". for the office country code field
And the user should see the error message Invalid characters: "Numbers and spaces allowed only". for the office area code field
And the user should see the error message Invalid characters: "Numbers and spaces allowed only". for the office number field
And the user should see the error message Invalid characters: "Numbers and spaces allowed only". for the office range limit field
And the user should see the error message Invalid characters: "Numbers,hypens and spaces allowed only". for the office ext field

Examples:
|entity|searchBy|fid|officeFid|Type|CountryCode|AreaCode|Number|RangeLimit|Ext|
|1010|FID|1010|1010-44|telephone|hnv 1|qwrgw88ji|gwqeywjij002349=|638-283wesr|gfdin-|

Scenario: Verify that the user should be able to delete an existing office telecoms row

Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
And the user clicks on the office locations link in the navigation bar
And the user clicks on the office update link
And the user gets the document with get id for offices with the <officeFid> from the database
And the user clicks on delete office telecoms row button for the row office_first_row_telecoms_delete_button
When the user clicks on the No button to cancel the deletion of row in office locations page
!-- And the user clicks on the save button
!--And the user clicks on the confirm button
!--Then the user verifies that the row values exists in the office locations page
When the user clicks on delete office telecoms row button for the row office_first_row_telecoms_delete_button
And the user clicks on the yes button in the delete row confirmation modal in the office page
!--And the user clicks on the save button
!--Then the user should see the save confirmation modal
!--And the user should see the below summary changes in confirmation modal
!--|Summary|
!--|Office Locations|
!--When the user clicks on the confirm button
!--Then the user should see the successful update message at top of the office page
!--And the user should not see the office telecoms row in the locations office page
!--And the user verifies that the deleted row for office telecoms does not exist in zeus document
!--And the user reverts the changes to the document

Examples:
|entity|searchBy|fid|officeFid|
|17649|FID|17649|17649-0|

Scenario: Scenario: User is adding/deleting new Office's Locations Telecom -
1 - Verify if User can prevent deleting telecom row by clicking on 'No'.
2 - Verify if User can delete telecom row by clicking on 'Yes' , then after saving it should be removed.
3 - User verifies that UI and Zeus document is updated.

Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
And the user clicks on the office locations link in the navigation bar
And the user clicks on the office update link
And the user gets the document with get id for offices with the <officeFid> from the database
When the user deletes the existing office telecom locations values in fdb document
When the user deletes the existing office telecom locations rows
And the user clicks on add new office telecoms button in the office locations
And the user selects office telecoms type office_telecoms_first_row_new_telecoms_type_dropdown value as <Type>
And the user enters office telecoms rank office_telecoms_first_row_new_rank value as <Rank>
And the user enters office telecoms text before office_telecoms_first_row_new_textBefore value as <TextBefore>
And the user enters office telecoms value office_telecoms_first_row_new_value value as <Value>
And the user enters office telecoms text after office_telecoms_first_row_new_textAfter value as <TextAfter>
And the user enters office telecoms answer back office_telecoms_first_row_new_answerBack value as <AnswerBack>
And the user clicks on the save button
And the user clicks on the confirm button
And the user clicks on the office update link
And the user clicks on delete office telecoms row button for the row office_first_row_telecoms_delete_button
When the user clicks on the No button to cancel the deletion of row in office locations page
Then the user should see the newly added telecom row in the office locations telecom page
When the user clicks on delete office telecoms row button for the row office_first_row_telecoms_delete_button
And the user clicks on the yes button in the delete row confirmation modal in the office page
And the user clicks on the save button
Then the user should see the save confirmation modal
When the user clicks on the confirm button
Then the user should see the successful update message at top of the office page
And the user should not see the office telecoms row in the locations office page
And the user verifies that the deleted row for office telecoms does not exist in zeus document
And the user reverts the changes to the document

Examples:
|entity|searchBy|fid|officeFid|Type|Rank|TextBefore|Value|TextAfter|AnswerBack|
|1038|FID|1038|1038-60|telex|1|5 pm|abc|9 am|1 hr|














