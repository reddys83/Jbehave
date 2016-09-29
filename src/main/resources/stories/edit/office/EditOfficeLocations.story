Meta:@EditOfficeLocations @Edit @Office @AllStories

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

JIRA ID - ZEUS-1075 - User can select to edit Office's Locations
JIRA ID - ZEUS-1299 - User can edit Office's Locations(Addresses)

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
!-- verify trusted doc 
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
When the user clicks on the save button
Then the user should see the below summary changes in confirmation modal
|Summary|
|Basic Info|
When the user clicks on the confirm button
Then the user should see the successful update message at top of the office page
And the user should not see the newly added locations row in the office locations page
Then the user verifies that blank office locations row is not added in zeus document
And the user reverts the changes to the document

Examples:
|entity|searchBy|fid|officeFid|
|1000|FID|1000|1000-9|

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
And the user clicks on delete office locations 1 delete button
Then the user should see the delete row confirmation modal in the office locations
When the user clicks on the cancel no button
And the user clicks on the cancel button
Then the user should see the cancel update confirmation modal
When the user clicks on the cancel yes button
When the user clicks on the save button
When the user clicks on the confirm button
Then the user verifies that the row values exists in the office locations page
When the user clicks on the office update link
And the user clicks on delete office locations 1 delete button
Then the user should see the delete row confirmation modal in the office locations
When the user clicks on the Yes button to confirm the deletion of row in office locations section
And the user clicks on the save button
Then the user should see the save confirmation modal
And the user should see the below summary changes in confirmation modal
|Summary|
|Basic Info|
When the user clicks on the confirm button
Then the user should not see the office address row in the locations office page
And the user verifies that the deleted row for office locations does not exist in zeus document
And the user reverts the changes to the document

Examples:
|entity|searchBy|fid|officeFid|
|299676|FID|299676|299676-0|

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
Then the user should see the address type values in office location's section from lookup ADDRESS_TYPE

Examples:
|entity|searchBy|fid|officeFid|
|1010|FID|1010|1010-44|

Scenario: a)Verify that the user should be able to Add new address row for an office location
          b)Verify User can select and save values for Type, Address Line 1, Address Line 2, Address Line 3, Address Line 4, Country,Area, Subarea, City, PostalCode, PostalCodeSuffix and Info
Meta: @testRun
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
When the user clicks on the add new office location button in the office page
When the user clicks on add new office address button in the office locations
And the user selects office address type value as <Type> in row 1
And the user enters office address <AddressLine1> in row 1
And the user enters office address <AddressLine2> in row 1
And the user enters office address <AddressLine3> in row 1
And the user enters office address <AddressLine4> in row 1
When the user clicks on the choose a country option in the office locations
When the user enters the office country <Country> in the type-ahead box
When the user clicks on the choose an area option in the office locations
Then the user should see the list of all existing area for the selected country by full name in office address
When the user enters the office area <Area> in the type-ahead box
When the user clicks on the choose a subarea option in the office locations
Then the user should see the list of all existing subarea for the selected area by full name in office address
When the user enters the office subarea <subArea> in the type-ahead box
When the user clicks on the choose a city option in the office locations
Then the user should see the list of all existing city for the selected area by full name in office address
When the user enters the office city <City> in the type-ahead box
When the user enters office address postal code value as <PostalCode> in location 1
And the user enters office address postal code suffix value as <PostalCodeSuffix> in location 1
And the user enters office address info value as <Info> in location 1
When the user clicks on the save button
Then the user should see the save confirmation modal
And the user should see the below summary changes in confirmation modal
|Summary|
|Locations|
When the user clicks on the confirm button
Then the user should see the successful update message at top of the office page
And the user verifies that the office address lines addresses are entered in the office locations page
And the user should see the office address lines addresses as in zeus document
And the user reverts the changes to the document

Examples:
|entity|searchBy|fid|officeFid|Type|AddressLine1|AddressLine2|AddressLine3|AddressLine4|Country|Area|subArea|City|PostalCode|PostalCodeSuffix|Info|
|50900|FID|50900|50900-0|mailing|123 Marie Ln|345 Palmer Dr|456 Franklin Ln|789 Apple Valley|USA|Illinois|Warren|Alexis|60126|123|adhsbd|

Scenario: 
1- Verify the values of area,subarea,city should be changed to null when the country value is changed
2 -Verify the values of subarea, city should be changed to null when the area value is changed
3- Verify the value of city should be changed to null when the subarea value is changed

Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
And the user clicks on the office locations link in the navigation bar
And the user clicks on the office update link
When the user clicks on the choose a country option in the office locations
When the user enters the office country <Country> in the type-ahead box
Then the user should see the area dropdown with Choose an area selected
And the user should see the area dropdown with Choose an area selected
And the user should see the subarea dropdown with Choose a subarea selected
And the user should see the city dropdown with Choose a city selected
When the user clicks on the choose an area option in the office locations
And the user enters the office area <Area> in the type-ahead box
Then the user should see the city dropdown with Choose a city selected
Then the user should see the subarea dropdown with Choose a subarea selected
When the user clicks on the choose a subarea option in the office locations
When the user enters the office subarea <subArea> in the type-ahead box
Then the user should see the city dropdown with Choose a city selected

Examples:
|entity|searchBy|fid|officeFid|Country|Area|subArea|
|1010|FID|1010|1010-45|Canada||Kings|

Scenario:
1 - Verify that the error message "At least one physical address required" is displayed when none of the Address Type is physical
2 - Verify that the error message "Required" is displayed when Country, City and Type is null         
3 - Verify office Address Line 1,Address Line 2,Address Line 3,Address Line3,Address Line 4, Postal Code, Postal Code Sufffix,Info field max length

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
When the user clicks on the choose a country option in the office locations
When the user selects office address type office_addressType_first_row_existing_address_type_dropdown value as <Type>
When the user enters the office country <Country> in the type-ahead box
And the user enters office address address line 1 office_address_first_row_new_addressLine1 value as <AddressLine1>
And the user clicks on the save button
Then the user should see the error message At least one physical address required for the office address type field
!-- requreid error message for addresss
Then the user should see the error message Required for the office country field
Then the user should see the error message Required for the office city field
Then the user should see the error message Required for the office address type field
And the user should see the error message at top of page the highlighted fields must be addressed before this update can be saved
Then the user verifies the office <AddressLine1> maxlength is 70 for the office_address_first_row_new_addressLine1
And the user verifies the office <AddressLine2> maxlength is 70 for the office_address_first_row_new_addressLine2
And the user verifies the office <AddressLine3> maxlength is 70 for the office_address_first_row_new_addressLine3
And the user verifies the office <AddressLine4> maxlength is 70 for the office_address_first_row_new_addressLine4
And the user verifies the office <PostalCode> maxlength is 70 for the office_address_first_row_new_postalCode
And the user verifies the office <PostalCodeSuffix> maxlength is 20 for the office_address_first_row_new_postalCodeSuffix
And the user verifies the office <Info> maxlength is 50 for the office_address_first_row_new_info
And the user should see the error message at top of page the highlighted fields must be addressed before this update can be saved

Examples:
|entity|searchBy|fid|officeFid|Type|Country|AddressLine1|
|1038|FID|1038|1038-54|mailing|||

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
And the user clicks on the save button
And the user clicks on the confirm button
Then the user verifies that the row values exists in the office locations page
When the user selects office address type office_addressType_first_row_existing_address_type_dropdown value as <Type>
And the user clicks on delete office address row button for the row office_first_existing_row_address_delete_button
Then the user should see the delete row confirmation modal
When the user clicks on the yes button in the delete row confirmation modal in the office page
And the user clicks on the save button
Then the user should see the save confirmation modal
And the user should see the below summary changes in confirmation modal
|Summary|
|Basic Info|
When the user clicks on the confirm button
Then the user should not see the office address row in the locations office page
And the user verifies that the deleted row for office address does not exist in zeus document
And the user reverts the changes to the document

Examples:
|entity|searchBy|fid|officeFid|
|1010|FID|1010|1010-54|






