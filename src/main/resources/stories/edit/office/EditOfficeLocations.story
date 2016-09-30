Meta:@EditOfficeLocations @Edit @Office @AllStories

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

JIRA ID - ZEUS-1075 - User can select to edit Office's Locations
JIRA ID - ZEUS-1300 - User can edit Office's Locations(Telecoms)
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
Then the user should see the office_add_locations_id in disabled state in locations section

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
|Locations|
When the user clicks on the confirm button
Then the user should see the successful update message at top of the office page
And the user should not see the newly added locations row in the office locations page
Then the user verifies that blank office locations row is not added in zeus document
And the user reverts the changes to the document

Examples:
|entity|searchBy|fid|officeFid|
|249093|FID|249093|249093-0|


Scenario: Verify that the user should be able to edit an existing office location row
a) - Verify if User can prevent deleting the location row by clicking on 'No'.
b) - Verify if User can delete the location row by clicking on 'Yes'.
Meta:@sureshtest
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
When the user clicks on the No button to cancel the deletion of row in office locations section
Then the user verifies that the location row exists in the office locations page
When the user clicks on delete office locations 1 delete button
When the user clicks on the Yes button to confirm the deletion of row in office locations section
When the user clicks on the save button
Then the user should see the save confirmation modal
And the user should see the below summary changes in confirmation modal
|Summary|
|Locations|
When the user clicks on the confirm button
Then the user verifies that the location row does not exist in the office locations page
And the user verifies that the deleted row for office locations does not exist in zeus document
And the user reverts the changes to the document

Examples:
|entity|searchBy|fid|officeFid|
|444|FID|444|444-505|


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

Scenario: Adding new location and location address for both depositing entity type ana non depositing entity type.
a)Verify that the user should be able to Add new address row for an office location
          b)Verify User can select and save values for Type, Address Line 1, Address Line 2, Address Line 3, Address Line 4, Country,Area, Subarea, City, PostalCode, PostalCodeSuffix and Info

Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
And the user clicks on the office locations link in the navigation bar
And the user clicks on the office update link
When the user deletes the existing office locations rows
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
Then the user verifies that the office address lines addresses are entered in the office locations page
And the user should see the office address lines addresses as in zeus document


Examples:
|entity|searchBy|fid|officeFid|Type|AddressLine1|AddressLine2|AddressLine3|AddressLine4|Country|Area|subArea|City|PostalCode|PostalCodeSuffix|Info|
|951|FID|951|951-4|mailing|123 Marie Ln|345 Palmer Dr|456 Franklin Ln|789 Apple Valley|USA|Illinois|Warren|Alexis|60126|123|adhsbd|
|444|FID|444|444-499|physical|123 Marie Ln|345 Palmer Dr|456 Franklin Ln|789 Apple Valley|USA|Illinois|Warren|Alexis|60126|123|adhsbd|


Scenario: Adding updates location and location address for both depositing entity type ana non depositing entity type.
a)Verify that the user should be able to Add new address row for an office location
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
Then the user verifies that the office address lines addresses are entered in the office locations page
And the user should see the office address lines addresses as in zeus document
And the user reverts the changes to the document

Examples:
|entity|searchBy|fid|officeFid|Type|AddressLine1|AddressLine2|AddressLine3|AddressLine4|Country|Area|subArea|City|PostalCode|PostalCodeSuffix|Info|
|951|FID|951|951-4|physical|123 Marie Ln|34 Palmer Dr|45 Frank|789 Valley|USA|Illinois|Warren|Alexis|60126|123|adhsbd|

Scenario: Location Address default value validation 
1- Verify the values of area, subarea, city should be changed to null when the country value is changed
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
When the user deletes the existing office locations rows
When the user clicks on the add new office location button in the office page
When the user clicks on add new office address button in the office locations
When the user clicks on the choose a country option in the office locations
When the user enters the office country <Country> in the type-ahead box
Then the user should see the area dropdown with Choose an Area selected
And the user should see the subarea dropdown with Choose a Subarea selected
And the user should see the city dropdown with Choose a City selected
When the user clicks on the choose an area option in the office locations
And the user enters the office area <Area> in the type-ahead box
Then the user should see the city dropdown with Choose a City selected
Then the user should see the subarea dropdown with Choose a Subarea selected
When the user clicks on the choose a subarea option in the office locations
When the user enters the office subarea <subArea> in the type-ahead box
Then the user should see the city dropdown with Choose a City selected

Examples:
|entity|searchBy|fid|officeFid|Country|Area|subArea|
|1010|FID|1010|1010-45|USA|Illinois|Warren|

Scenario: User is updating Office's Locations (Address) in the Office Page. 
1 - Verify that error message 'Required' is displayed after saving when Type field is blank for an office fid which is not a deposit taking institution.
2 - Verify Office Address Line 1, Address Line 2, Address Line 3, Address Line3, Address Line 4, Postal Code, Postal Code Sufffix, Info field max length attributes

Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
And the user clicks on the office locations link in the navigation bar
And the user clicks on the office update link
When the user deletes the existing office locations rows
When the user clicks on the add new office location button in the office page
And the user clicks on add new office address button in the office locations
Then the user verifies the office <AddressLine1> maxlength is 70 for the office_location_addressLine1
And the user verifies the office <AddressLine2> maxlength is 70 for the office_location_addressLine2
And the user verifies the office <AddressLine3> maxlength is 70 for the office_location_addressLine3
And the user verifies the office <AddressLine4> maxlength is 70 for the office_location_addressLine4
And the user verifies the office <PostalCode> maxlength is 70 for the office_address_first_row_new_postalCode
And the user verifies the office <PostalCodeSuffix> maxlength is 20 for the office_address_first_row_new_postalCodeSuffix
And the user verifies the office <Info> maxlength is 50 for the office_address_first_row_new_info
When the user clicks on the save button
Then the user should see the error message Required for the office address type field
And the user should see the error message at top of page the highlighted fields must be addressed before this update can be saved

Examples:
|entity|searchBy|fid|officeFid|Type|
|951|FID|951|951-4||

Scenario: User is updating Office's Locations (Address) in the Office Page. 
1 - Verify that error message 'At least one physical address required' is displayed when Type field is blank for an office fid which is a deposit taking institution.
2 - Verify previously selected Address Type is not listed in Address dropdown of next row.
3 - Verify that the error message 'Required' is displayed after saving when Type is blank for a new row.
4 - Verify that the error message 'Required' is displayed after saving when Address Line 1 is blank provided that either one of Address Line 2, Address Line 3 or Address Line 4 has a value.

Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
And the user clicks on the office locations link in the navigation bar
And the user clicks on the office update link
When the user deletes the existing office locations rows
When the user clicks on the add new office location button in the office page
And the user clicks on add new office address button in the office locations
When the user clicks on the save button
Then the user should see the error message At least one physical address required for the office address type field
When the user selects office address type value as <Type> in row 1
And the user clicks on add new office address button in the office locations
Then the user verifies that previously selected <Type> is not present in the new address row
When the user enters office address <AddressLine2> in row 2
When the user clicks on the save button
Then the user should see the error message Required for the office address type field for the second address row
Then the user should see the error message Enter up to 70 valid characters. for the office address addressLine1 field
And the user should see the error message at top of page the highlighted fields must be addressed before this update can be saved

Examples:
|entity|searchBy|fid|officeFid|Type|AddressLine2|
|444|FID|444|444-499|physical|Sample Text|


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
When the user deletes the existing office locations rows
When the user clicks on the add new office location button in the office page
And the user clicks on add new office address button in the office locations
When the user selects office address type value as <Type> in row 1
When the user clicks on the choose a country option in the office locations
When the user enters the office country <Country> in the type-ahead box
When the user clicks on the choose an area option in the office locations
When the user enters the office area <Area> in the type-ahead box
When the user clicks on the choose a subarea option in the office locations
When the user enters the office subarea <subArea> in the type-ahead box
When the user clicks on the choose a city option in the office locations
When the user enters the office city <City> in the type-ahead box
And the user clicks on delete office address row button for the row office_first_existing_row_address_delete_button
Then the user should see the delete row confirmation modal
When the user clicks on the No button to cancel the deletion of row in office locations page
Then the user verifies that the newly added address row exists in the office locations page
When the user clicks on delete office address row button for the row office_first_existing_row_address_delete_button
Then the user should see the delete row confirmation modal
When the user clicks on the yes button in the delete row confirmation modal in the office page
And the user clicks on the save button
Then the user should see the save confirmation modal
And the user should see the below summary changes in confirmation modal
|Summary|
|Locations|
When the user clicks on the confirm button
Then the user should not see the office address row in the locations office page
And the user verifies that the deleted row for office address does not exist in zeus document
And the user reverts the changes to the document

Examples:
|entity|searchBy|fid|officeFid|Type|Country|Area|subArea|City|
|444|FID|444|444-676|mailing|USA|Illinois|Warren|Alexis|

Scenario: User is viewing Office's Locations (Telecom) - 
a) Verify Office Telecoms Type dropdown values are from lookup TELECOM_TYPE
b) Verify Office Telecoms existing values are trusted document.

Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
And the user clicks on the office locations link in the navigation bar
And the user clicks on the office update link
Then the user should see the office telecom values same as in trusted document
When the user deletes the existing office telecom locations values in fdb document
When the user deletes the existing office telecom locations rows
And the user clicks on add new office telecoms button in the office locations
Then the user should see the office_locations_telecoms_type_dropdown_options values in office telecoms's section from lookup TELECOM_TYPE

Examples:
|entity|searchBy|fid|officeFid|
|1038|FID|1038|1038-60|

Scenario: User is updating an Office's Locations (Telecom) -  
a) Verify user can select a new value for Telecom Type as telephone/fax and Verify that the user can see and select values for the following fields: 
   Rank, TextBefore, Country Code, Area code, Number, RangeLimit, Ext, TextAfter.
b) Verify that UI and Zeus document is updated.

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
And the user selects office telecoms type office_telecoms_first_row_new_telecoms_type_dropdown value as <type>
And the user enters office telecoms rank office_telecoms_first_row_new_rank value as <rank>
And the user enters office telecoms text before office_telecoms_first_row_new_textBefore value as <textBefore>
And the user enters office telecoms value office_telecoms_first_row_new_countryCode value as <countryCode>
And the user enters office telecoms value office_telecoms_first_row_new_areaCode value as <areaCode>
And the user enters office telecoms value office_telecoms_first_row_new_number value as <number>
And the user enters office telecoms range limit office_telecoms_first_row_new_rangeLimit value as <rangeLimit>
And the user enters office telecoms ext office_telecoms_first_row_new_ext value as <ext>
And the user enters office telecoms text after office_telecoms_first_row_new_textAfter value as <textAfter>
And the user clicks on the save button
Then the user should see the save confirmation modal
And the user should see the below summary changes in confirmation modal
|Summary|
|Locations|
When the user clicks on the confirm button
Then the user should see the successful update message at top of the office page
And the user verifies that the office telecom fields for Type(telephone/fax) are entered in the office locations page
Then the user should see the office telecomm fields for Type(telephone/fax) as in zeus document
And the user reverts the changes to the document

Examples:
|entity|searchBy|fid|officeFid|type|rank|textBefore|countryCode|areaCode|number|rangeLimit|ext|textAfter|
|1038|FID|1038|1038-51|telephone|1|5 pm|708|298|3125|20|123|9 am|
|1038|FID|1038|1038-51|fax|1|5 pm|708|298|3142|20|123|9 am|

Scenario:User is updating an Office's Locations (Telecom)- For Type - 'Telephone', 'Fax' 
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
When the user deletes the existing office telecom locations rows
And the user clicks on add new office telecoms button in the office locations
And the user selects office telecoms type office_telecoms_first_row_new_telecoms_type_dropdown value as <type>
Then the user verifies the office Rank maxlength is 4 for the office_telecoms_first_row_new_rank
Then the user verifies the office TextBefore maxlength is 50 for the office_telecoms_first_row_new_textBefore
Then the user verifies the office CountryCode maxlength is 5 for the office_telecoms_first_row_new_countryCode
Then the user verifies the office AreaCode maxlength is 10 for the office_telecoms_first_row_new_areaCode
Then the user verifies the office Number maxlength is 20 for the office_telecoms_first_row_new_number
Then the user verifies the office RangeLimit maxlength is 20 for the office_telecoms_first_row_new_rangeLimit
Then the user verifies the office Ext maxlength is 10 for the office_telecoms_first_row_new_ext
Then the user verifies the office TextAfter maxlength is 50 for the office_telecoms_first_row_new_textAfter
When the user clicks on the save button
Then the user should see the error message Enter up to 4 valid numbers. for the office telecom rank field
Then the user should see the error message Enter up to 20 valid characters. for the office value field
When the user enters office telecoms rank office_telecoms_first_row_new_rank value as <rank>
And the user enters office telecoms value office_telecoms_first_row_new_countryCode value as <countryCode>
And the user enters office telecoms value office_telecoms_first_row_new_areaCode value as <areaCode>
And the user enters office telecoms value office_telecoms_first_row_new_number value as <number>
When the user enters office telecoms range limit office_telecoms_first_row_new_rangeLimit value as <rangeLimit>
And the user enters office telecoms ext office_telecoms_first_row_new_ext value as <ext>
And the user clicks on the save button
Then the user should see the error message Enter up to 4 valid numbers. for the office telecom rank field
Then the user should see the error message <errorText> for the office telecom value field
Then the user should see the error message Enter up to 20 valid characters. for the office range limit field
Then the user should see the error message Enter up to 10 valid characters. for the office ext field
And the user should see the error message at top of page the highlighted fields must be addressed before this update can be saved

Examples:
|entity|searchBy|fid|officeFid|type|rank|countryCode|areaCode|number|rangeLimit|ext|errorText|
|1010|FID|1010|1010-44|telephone|Text|Text|123|456|Text|Text|Numbers and spaces allowed only|
|1010|FID|1010|1010-44|telephone|Text|123|Text|456|Text|Text|Enter up to 10 valid characters.|
|1010|FID|1010|1010-44|telephone|Text|123|456|Text|Text|Text|Numbers and spaces allowed only|
|1010|FID|1010|1010-44|fax|Text||456|123|Text|Text|Enter up to 5 valid characters.|
|1010|FID|1010|1010-44|fax|Text|123|456||Text|Text|Enter up to 20 valid characters.|

Scenario: User is updating an Office's Locations (Telecom) - 
a) Verify user can select a new value for Telecom Type as telex/reuters/cable and Verify that the user can see and select values for the following fields: 
   Rank, TextBefore, Value, TextAfter, AnswerBack
b) Verify that UI and Zeus document is updated.
      
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
And the user selects office telecoms type office_telecoms_first_row_new_telecoms_type_dropdown value as <type>
And the user enters office telecoms rank office_telecoms_first_row_new_rank value as <rank>
And the user enters office telecoms text before office_telecoms_first_row_new_textBefore value as <textBefore>
And the user enters office telecoms value office_telecoms_first_row_new_value value as <value>
And the user enters office telecoms text after office_telecoms_first_row_new_textAfter value as <textAfter>
And the user enters office telecoms answer back office_telecoms_first_row_new_answerBack value as <answerBack>
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
|entity|searchBy|fid|officeFid|type|rank|textBefore|value|textAfter|answerBack|
|1038|FID|1038|1038-51|telex|1|5 pm|abc|9 am|1 hr|
|1038|FID|1038|1038-51|reuters|1|5 pm|afv|9 am|1 hr|
|1038|FID|1038|1038-51|cable|1|5 pm|hsn|9 am|1 hr|

Scenario:User is updating an Office's Locations (Telecom)- For Type - 'Telex', 'Reuters' and 'Cable' 
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
And the user selects office telecoms type office_telecoms_first_row_new_telecoms_type_dropdown value as <type>
Then the user verifies the office AnswerBack maxlength is 20 for the office_telecoms_first_row_new_answerBack
Then the user verifies the office Value maxlength is 100 for the office_telecoms_first_row_new_value
When the user clicks on the save button
Then the user should see the error message Enter up to 4 valid numbers. for the office telecom rank field
Then the user should see the error message Enter up to 100 valid characters. for the office value field
When the user enters office telecoms rank office_telecoms_first_row_new_rank value as <rank>
And the user clicks on the save button
Then the user should see the error message Enter up to 4 valid numbers. for the office telecom rank field
And the user should see the error message at top of page the highlighted fields must be addressed before this update can be saved

Examples:
|entity|searchBy|fid|officeFid|type|rank|
|1010|FID|1010|1010-44|telex|Text|
|1010|FID|1010|1010-44|reuters|Text|
|1010|FID|1010|1010-44|cable|Text|

Scenario: User is updating an Office's Locations (Telecom) -  
a) Verify user can select a new value for Telecom Type as email/website and Verify that the user can see and select values for the following fields: 
   Rank, TextBefore, Value, TextAfter
b) Verify that UI and Zeus document is updated correctly.
 
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
And the user selects office telecoms type office_telecoms_first_row_new_telecoms_type_dropdown value as <type>
And the user enters office telecoms rank office_telecoms_first_row_new_rank value as <rank>
And the user enters office telecoms text before office_telecoms_first_row_new_textBefore value as <textBefore>
And the user enters office telecoms value office_telecoms_first_row_new_value value as <value>
And the user enters office telecoms text after office_telecoms_first_row_new_textAfter value as <textAfter>
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
|entity|searchBy|fid|officeFid|type|rank|textBefore|value|textAfter|
|1038|FID|1038|1038-60|email|1|5 pm|aft@zeus.com|5 pm|
|1038|FID|1038|1038-60|website|5|3 pm|www.zeus.com|4 pm|

Scenario:User is updating an Office's Locations (Telecom)- For Type - 'Email' and 'Website'
a) Verify that the error message "Enter up to 4 valid numbers" is displayed when the 'Rank' field is blank.
b) Verify that the error message "Enter up to 100 valid characters" is displayed when the 'Value' field is blank.
c) Verify that the error message "Enter up to 4 valid numbers" is displayed when alphabets are entered for 'Rank' field.
d) Verify that the error message "Enter up to 100 valid characters" is displayed for Type - 'Email' when a text without '@' character is entered for 'Value' field.

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
And the user selects office telecoms type office_telecoms_first_row_new_telecoms_type_dropdown value as <type>
And the user clicks on the save button
Then the user should see the error message Enter up to 4 valid numbers. for the office telecom rank field
Then the user should see the error message Enter up to 100 valid characters. for the office value field
When the user enters office telecoms rank office_telecoms_first_row_new_rank value as <rank>
When the user enters office telecoms value office_telecoms_first_row_new_value value as <value>
And the user clicks on the save button
Then the user should see the error message Enter up to 4 valid numbers. for the office telecom rank field
Then the user should see the error message Enter up to 100 valid characters. for the office value field
And the user should see the error message at top of page the highlighted fields must be addressed before this update can be saved

Examples:
|entity|searchBy|fid|officeFid|type|rank|value|
|1010|FID|1010|1010-44|email|Text|www.zeus.com|
|1010|FID|1010|1010-44|website|Text||

Scenario: Scenario: User is adding/deleting new Office's Locations Telecom -
a) Verify if User can prevent deleting telecom row by clicking on 'No'.
b) Verify if User can delete telecom row by clicking on 'Yes' , then after saving it should be removed.
c) User verifies that UI and Zeus document is updated.

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
And the user selects office telecoms type office_telecoms_first_row_new_telecoms_type_dropdown value as <type>
And the user enters office telecoms rank office_telecoms_first_row_new_rank value as <rank>
And the user enters office telecoms text before office_telecoms_first_row_new_textBefore value as <textBefore>
And the user enters office telecoms value office_telecoms_first_row_new_value value as <value>
And the user enters office telecoms text after office_telecoms_first_row_new_textAfter value as <textAfter>
And the user enters office telecoms answer back office_telecoms_first_row_new_answerBack value as <answerBack>
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
|entity|searchBy|fid|officeFid|type|rank|textBefore|value|textAfter|answerBack|
|1038|FID|1038|1038-60|telex|1|5 pm|abc|9 am|1 hr|

