Meta:@EditOfficeLocations @Edit @Office @AllStories

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

JIRA ID - ZEUS-1075 - User can select to edit Office's Locations
and
JIRA ID - ZEUS-1299 - User can edit Office's Locations(Addresses)

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
And the user clicks on the office locations link in the navigation bar
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
And the user clicks on the office locations link in the navigation bar
And the user clicks on the office update link
And the user gets the document with get id for offices with the <officeFid> from the database
And the user clicks on the add new office location button in the office page
Then the user should see the save confirmation modal
And the user should see the below summary changes in confirmation modal
|Summary|
|Basic Info|
When the user clicks on the confirm button

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
And the user clicks on the office locations link in the navigation bar
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
Then the user should not see the office address row in the locations office page
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
And the user clicks on the office locations link in the navigation bar
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
And the user clicks on the office locations link in the navigation bar
And the user clicks on the office update link
When the user gets the document with get id for offices with the <officeFid> from the database
And the user selects primary flag  value <primaryFlag> in the office locations
And the user clicks on the save button
Then the user should see the save confirmation modal
And the user should see the below summary changes in confirmation modal
|Summary|
|Office Locations|
When the user clicks on the confirm button
Then the user should see the successful update message at top of the office page
Then the user should see office location primary flag value as <primaryFlag> for fid <officeFid> in zeus document and in zeus UI

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
And the user clicks on the office locations link in the navigation bar
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
And the user enters office address info office_address_first_row_new_info value as <Info>
When the user clicks on the choose a country option in the office locations
When the user enters the office country <Country> in the type-ahead box
Then the user should see the list of all existing area for the selected country by full name in office address
When the user clicks on the choose an area option in the office locations
When the user enters the office area <Area> in the type-ahead box
Then the user should see the list of all existing subarea for the selected area by full name in office address
When the user clicks on the choose a subarea option in the office locations
When the user enters the office subarea <subArea> in the type-ahead box
When the user clicks on the choose a city option in the office locations
Then the user should see the below office cities for the selected subarea:
|CITIES|
|Alexis|
|Kirkwood|
|Little York|
|Monmouth|
|Roseville|
When the user clicks on add new office address button in the office locations
And the user enters office address postal code office_address_first_row_new_postalCode value as <PostalCode>
And the user enters office address postal code suffix office_address_first_row_new_postalCodeSuffix value as <PostalCodeSuffix>
And the user enters office address info office_address_first_row_new_info value as <Info>
And the user clicks on the save button
Then the user should see the save confirmation modal
And the user should see the below summary changes in confirmation modal
|Summary|
|Office Locations|
When the user clicks on the confirm button
Then the user should see the successful update message at top of the office page
And the user verifies that the office address lines addresses are entered in the office locations page
And the user should see the office address lines addresses as in zeus document
And the user reverts the changes to the document

Examples:
|entity|searchBy|fid|officeFid|Type|AddressLine1|AddressLine2|AddressLine3|AddressLine4|PostalCode|PostalCodeSuffix|Info|Country|Area|subArea|City|
|1010|FID|1010|1010-45|mailing|123 Marie Ln|345 Palmer Dr|456 Franklin Ln|789 Apple Valley|60126|123|adhsbd|USA|Illinois|Warren|Alexis|

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
And the user clicks on the office locations link in the navigation bar
And the user clicks on the office update link
When the user gets the document with get id for offices with the <officeFid> from the database
When the user clicks on the choose a country option in the office locations
When the user enters the office country <Country> in the type-ahead box
Then the user should see the list of all existing area for the selected country by full name in office address
When the user clicks on the choose an area option in the office locations
When the user enters the office area <Area> in the type-ahead box
Then the user should see the list of all existing subarea for the selected area by full name in office address
When the user clicks on the choose a subarea option in the office locations
When the user enters the office subarea <subArea> in the type-ahead box
When the user clicks on the choose a city option in the office locations
Then the user should see the below office cities for the selected subarea:
|CITIES|
|Alexis|
|Kirkwood|
|Little York|
|Monmouth|
|Roseville|

Examples:
|entity|searchBy|fid|officeFid|Country|Area|subArea|City|
|1010|FID|1010|1010-45|USA|Illinois|Warren|Alexis|

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
And the user clicks on the office locations link in the navigation bar
And the user clicks on the office update link
When the user gets the document with get id for offices with the <officeFid> from the database
When the user clicks on the choose a country option in the office locations
When the user enters the office country <Country> in the type-ahead box
When the user clicks on the choose an area option in the office locations
Then the user should see the below office states for the selected country:
|AREAS|
|No Area|
|Return All Cities|
When the user enters the office area <Area> in the type-ahead box
And the user clicks on the choose a city option in the office locations
Then the user should see the below office cities for the selected area:

|CITIES|
|Brändö|
|Eckerö|
|Föglö|
|Geta|
|Godby|
|Hammarland|
|Jomala|
|Kökar|
|Kumlinge|
|Lappo|
|Lemland|
|Mariehamn|
|Saltvik|
|Sottunga|
|Vårdö|

Examples:
|entity|searchBy|fid|officeFid|Country|Area|
|1010|FID|1010|1010-45|Åland Islands|Return All Cities|

Scenario: Verify return cities wth no area

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
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
When the user clicks on the choose an area option in the office locations
When the user enters the office area <Area> in the type-ahead box
And the user clicks on the choose a city option in the office locations
Then the user should see the below office cities for the selected area:

|CITIES|
|Brändö|
|Eckerö|
|Föglö|
|Geta|
|Godby|
|Hammarland|
|Jomala|
|Kökar|
|Kumlinge|
|Lappo|
|Lemland|
|Mariehamn|
|Saltvik|
|Sottunga|
|Vårdö|

Examples:
|entity|searchBy|fid|officeFid|Country|Area|
|1010|FID|1010|1010-45|Åland Islands|No Area|


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
And the user clicks on the office locations link in the navigation bar
And the user clicks on the office update link
When the user gets the document with get id for offices with the <officeFid> from the database
And the user clicks on add new office address button in the office locations
And the user enters office address postal code office_address_first_row_new_postalCode value as <PostalCode>
And the user enters office address postal code suffix office_address_first_row_new_postalCodeSuffix value as <PostalCodeSuffix>
And the user enters office address info office_address_first_row_new_info value as <Info>

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
And the user clicks on the office locations link in the navigation bar
And the user clicks on the office update link
And the user gets the document with get id for offices with the <officeFid> from the database
And the user clicks on the add new office location button in the office page
And the user clicks on add new office address button in the office locations
And the user clicks on delete office address row button for the row office_first_new_row_address_delete_button
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


Scenario: a)Verify that the delete button is disabled for the office address row where the address type is physical when the Legal Entity is associated with the office is a "deposit taking institution"
          b)Verify that the user should be able to add a new office address when the adddress type is mailing

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
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

Examples:
|entity|searchBy|fid|officeFid|Type|
|1010|FID|1010|1010-44|mailing|


Scenario:  Verify Office Locations Type dropdown values are from lookup  ADDRESS_TYPE

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
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
Then the user should see the office_addressType_first_row_new_address_type_dropdown values in office location's section from lookup ADDRESS_TYPE except the values that are selected already

Examples:
|entity|searchBy|fid|officeFid|
|1010|FID|1010|1010-44|


Scenario: a) Verify that the error message required is displayed when the the Address Type dropdown is left blank
          b) Verify that the error message required is not displayed when the Address Line1,Address Line2, Address Line3, Address Line 4, Postal Code, Postal Code Suffix, Info are left blank

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
Then the user should see office address line 1 text value as <AddressLine1> for fid <officeFid> in zeus document and in zeus UI
And the user should see office address line 2 text value as <AddressLine2> for fid <officeFid> in zeus document and in zeus UI
And the user should see office address line 3 text value as <AddressLine3> for fid <officeFid> in zeus document and in zeus UI
And the user should see office address line 4 text value as <AddressLine4> for fid <officeFid> in zeus document and in zeus UI
And the user should see office location primary flag value as <primaryFlag> for fid <officeFid> in zeus document and in zeus UI
And the user should see office country value as <Country> for fid <officeFid> in zeus document and in UI
And the user should see office area value as <Area> for fid <officeFid> in zeus document and in UI
And the user should see office area value as <SubArea> for fid <officeFid> in zeus document and in UI
And the user should see office city value as <City> for fid <officeFid> in zeus document and in UI
And the user should see office postal code value as <postalCode> for fid <officeFid> in zeus document and in zeus UI
And the user should see office postal code suffix  value as <postalCodeSuffix> for fid <officeFid> in zeus document and in zeus UI
And the user should see office locations info value as <Info> for fid <officeFid> in zeus document and in zeus UI

Examples:
|entity|searchBy|fid|officeFid|
|1010|FID|1010|1010-44|

Scenario: Verify that the error message "At least one physical address required" is displayed when none of the Address Type is physical


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
And the user clicks on the save button
Then the user should see the error message At least one physical address required for the office address type field
And the user should see the error message at top of page the highlighted fields must be addressed before this update can be saved

Examples:
|entity|searchBy|fid|officeFid|Type|
|1010|FID|1010|1010-44|Mailing|

Scenario: a)Verify that the error message "required" is displayed when Country is null(Choose a Country) and when the Address Type is not null
          b)Verify that the error message "required" is displayed when City is null(Choose a City) and when the Address Type is not null

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
And the user clicks on the office locations link in the navigation bar
And the user clicks on the office update link
When the user gets the document with get id for offices with the <officeFid> from the database
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
And the user enters office telecoms answer back office_telecoms_first_row_new_answerBack value as <AnswerBack>
And the user clicks on the save button
Then the user should see the save confirmation modal
And the user should see the below summary changes in confirmation modal
|Summary|
|Office Locations|
When the user clicks on the confirm button
Then the user should see the successful update message at top of the office page
And the user verifies that the office telecom fields are entered in the office locations page
And the user should see the office telecomm fields as in zeus document
And the user reverts the changes to the document

Examples:
|entity|searchBy|fid|officeFid|Type|Rank|TextBefore|CountryCode|AreaCode|Number|RangeLimit|Ext|TextAfter|AnswerBack|
|1010|FID|1010|1010-45|telephone|1|5 pm|708|298|3125|20|123|9 am|1 hr|

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
And the user clicks on the office locations link in the navigation bar
And the user clicks on the office update link
And the user gets the document with get id for offices with the <officeFid> from the database
And the user clicks on add new office telecoms button in the office locations
And the user clicks on delete office telecoms row button for the row office_first_row_telecoms_delete_button
And the user clicks on the yes button in the delete row confirmation modal in the office page
Then the user should not see the office telecoms row in the locations office page

Examples:
|entity|searchBy|fid|officeFid|
|1010|FID|1010|1010-45|















