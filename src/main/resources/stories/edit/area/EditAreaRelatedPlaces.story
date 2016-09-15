Meta: @EditAreaRelatedPlaces @Edit @Area @AllStories

Narrative:
In order to view and edit the area page
As a user
I want to cover the requirements mentioned in

JIRA ID - ZEUS-1048 - User can edit Area's Related Places

Scenario: Verify the list of type dropdown are from AREA_RELATED_PLACE_TYPE and details dropdown from AREA_RELATED_PLACE_SUBTYPE

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the area places link in the navigation bar
And the user clicks on the area update link
When the user deletes the existing related places rows
And the user clicks on the add button for adding new places for area page
When the user clicks on new area places type drop-down for area
Then the user should see the values for type dropdown from lookup AREA_RELATED_PLACE_TYPE
When the user clicks on new area places details drop-down for area
Then the user should see the values for details dropdown from lookup AREA_RELATED_PLACE_SUBTYPE
When the user clicks on edit button in places for area
And the user clicks on the country option in the places for area
Then the user should see the list of all existing countries by full name in places for area
When the user enters the country <countryPlaces> in type-ahead box for area related places
When the user clicks on area option in the places for area
Then the user should see the list of all existing area for the selected country by full name in places for area
When the user enters area <areaPlaces> in the type-ahead box for area related places
And the user clicks on city options in the places for area
Then the user should see the list of all existing city for the selected area by full name in places for area

Examples:
|country|area|countryPlaces|areaPlaces|
|Angola|Cabinda|Algeria|Blida|

Scenario: Verify whether User is able to see error message "Required" when input values are blank for 'place' & 'type' field

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the area places link in the navigation bar
And the user clicks on the area update link
When the user deletes the existing related places rows
And the user clicks on the add button for adding new places for area page
And the user selects details value as <placeDetails> in the places for area
And the user clicks on the save button
Then the user should see the error message required for type in places for area
Then the user should see the error message required for place in places for area
Then the user should see the error message at top of page the highlighted fields must be addressed before this update can be saved

Examples:
|country|area|placeDetails|
|Angola|Cabinda|State Capital|

Scenario: 
a)Verify whether user is able to add a Area Related place successfully in Area Web page
b)Verify whether user is able to view the added related place in Zeus Document

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the area places link in the navigation bar
And the user clicks on the area update link
When the user gets the document with get document id for area with the <area> from the database
When the user deletes the existing related places rows
And the user clicks on the add button for adding new places for area page
And the user selects type value as <placeType> in the places for area
When the user clicks on edit button in places for area
And the user clicks on the country option in the places for area
When the user enters the country <countryPlaces> in type-ahead box for area related places
And the user clicks on area option in the places for area
When the user enters area <areaPlaces> in the type-ahead box for area related places
And the user clicks on city options in the places for area
And the user enters city <cityPlaces> in the type-ahead box for area related places
And the user clicks on go button in places for area
And the user selects details value as <placeDetails> in the places for area
And the user clicks on the add button for adding new places for area page
And the user selects type value as <placeType2> in the places for area
When the user clicks on edit button for second row  in places for area
And the user clicks on the country option in the places for area
When the user enters the country <countryPlaces2> in type-ahead box for area related places
And the user clicks on area option in the places for area
When the user enters area <areaPlaces2> in the type-ahead box for area related places
And the user clicks on city options in the places for area
And the user enters city <cityPlaces2> in the type-ahead box for area related places
And the user clicks on go button in places for area
And the user selects details value as <placeDetails2> in the places for area
And the user clicks on the save button
Then the user should see the save confirmation modal
And the user should see the below summary changes in confirmation modal
|Summary|
|Related Places|
When the user clicks on the confirm button
Then the user should see the successful update message at top of the page
Then the user should see related place details saved in area web page
Then the user should see related place details saved in in zeus document
Then the user reverts the changes to the document

Examples:
|country|area|placeType|countryPlaces|areaPlaces|cityPlaces|placeDetails|placeType2|placeDetails2|countryPlaces2|areaPlaces2|cityPlaces2|
|Angola|Cabinda|Capital City|Angola|Zaire|Soyo|State Capital|Capital City|State Capital|Angola|Namibe|Camucuio|

Scenario: 
a)Verify whether user is able to update an existing  Area Related place (no different to the current value) with same values successfully
b)Verify whether user should get no changes in confirmation modal

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the area places link in the navigation bar
And the user clicks on the area update link
When the user gets the document with get document id for area with the <area> from the database
And the user updates type value as <placeType> in the places for area
When the user clicks on edit button in places for area
And the user clicks on the country option in the places for area
When the user enters the country <countryPlaces> in type-ahead box for area related places
And the user clicks on area option in the places for area
When the user enters area <areaPlaces> in the type-ahead box for area related places
And the user clicks on city options in the places for area
And the user enters city <cityPlaces> in the type-ahead box for area related places
And the user clicks on go button in places for area
And the user selects details value as <placeDetails> in the places for area
And the user clicks on the save button
Then the user should see the save confirmation modal
Then the user should not see the <ConfirmationSummary> changes in confirmation modal
When the user clicks on the confirm button
Then the user should see the successful update message at top of the page
Then the user should see <placeType> <cityPlaces> <placeDetails> updated in area related place
Then the user should see area related place date <placeType> <cityPlaces> <placeDetails> value in zeus document
Then the user reverts the changes to the document

Examples:
|country|area|placeType|countryPlaces|areaPlaces|cityPlaces|placeDetails|ConfirmationSummary|
|Angola|Cabinda|Capital City|Angola|Cunene|Cahama|State Capital|Summary|

Scenario: Verify whether Go Button is disabled when
User should see Go Button is disabled when
a)Country not selected ("Choose a Country")
b)Country selected. Area selected and = "Return All Cities" or "No area". City not selected ("Choose a City")

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the area places link in the navigation bar
And the user clicks on the area update link
When the user deletes the existing related places rows
And the user clicks on the add button for adding new places for area page
When the user clicks on edit button in places for area
Then the user should see 'Go' button disabled until value for City is selected
When the user clicks on the country option in the places for area
And the user enters the country <countryPlaces> in type-ahead box for area related places
And the user clicks on area option in the places for area
And the user enters area <areaPlaces> in the type-ahead box for area related places
Then the user should see 'Go' button disabled until value for City is selected

Examples:
|country|area|countryPlaces|areaPlaces|
|Angola|Cabinda|Algeria|No Area|
|Angola|Cabinda|Algeria|Return All Cities|

Scenario: Verify whether Go Button is disabled when (while adding a new related place)
User should see Go Button is Enabled when
a)Country selected. Area not selected ("Choose an Area") & Country should be updated in place
b)Country selected. Area selected and <> "Return All Areas" or "NO area". City not selected ("Choose a City") & Area should be updated in place

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the area places link in the navigation bar
And the user clicks on the area update link
When the user deletes the existing related places rows
And the user clicks on the add button for adding new places for area page
When the user clicks on edit button in places for area
When the user clicks on the country option in the places for area
And the user enters the country <countryPlaces> in type-ahead box for area related places
Then the user should see Go button enabled
When the user clicks on go button in places for area
Then the user should see place as Angola in places for area
When the user clicks on edit button in places for area
When the user clicks on the country option in the places for area
And the user enters the country <countryPlaces> in type-ahead box for area related places
When the user clicks on area option in the places for area
When the user enters area <areaPlaces> in the type-ahead box for area related places
Then the user should see Go button enabled
When the user clicks on go button in places for area
Then the user should see place as Moxico in places for area

Examples:
|country|area|countryPlaces|areaPlaces|
|Angola|Cabinda|Angola|Moxico|

Scenario: Verify whether Go Button is disabled when (while updating existing related place)
User should see Go Button is Enabled when
a)Country selected. Area not selected ("Choose an Area") & Country should be updated in place
b)Country selected. Area selected and <> "Return All Areas" or "NO area". City not selected ("Choose a City") & Area should be updated in place

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the area places link in the navigation bar
And the user clicks on the area update link
When the user gets the document with get document id for area with the <area> from the database
When the user deletes the existing related places rows
And the user clicks on the add button for adding new places for area page
And the user selects type value as <placeType> in the places for area
When the user clicks on edit button in places for area
And the user clicks on the country option in the places for area
When the user enters the country <countryPlaces> in type-ahead box for area related places
Then the user should see Go button enabled
When the user clicks on go button in places for area
Then the user should see place as Angola in places for area
When the user clicks on edit button in places for area
When the user clicks on the country option in the places for area
And the user enters the country <countryPlaces> in type-ahead box for area related places
When the user clicks on area option in the places for area
When the user enters area <areaPlaces> in the type-ahead box for area related places
Then the user should see Go button enabled
When the user clicks on go button in places for area
Then the user should see place as Namibe in places for area
When the user clicks on edit button in places for area
When the user clicks on the country option in the places for area
And the user enters the country <countryPlaces> in type-ahead box for area related places
When the user clicks on area option in the places for area
When the user enters area <areaPlaces> in the type-ahead box for area related places
And the user clicks on city options in the places for area
And the user enters city <cityPlaces> in the type-ahead box for area related places
And the user clicks on go button in places for area
And the user selects details value as <placeDetails> in the places for area
And the user clicks on the save button
Then the user should see the save confirmation modal
When the user clicks on the confirm button
Then the user should see the successful update message at top of the page
Then the user reverts the changes to the document

Examples:
|country|area|countryPlaces|areaPlaces|cityPlaces|placeType|placeDetails|
|Angola|Cabinda|Angola|Namibe|Bibala|Capital City|State Capital|

Scenario: Verify whether Go Button is disabled when
User should see Go Button is disabled when
a)Country not selected ("Choose a Country")
b)Country selected. Area selected and = "Return All Cities" or "No area". City not selected ("Choose a City")

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the area places link in the navigation bar
And the user clicks on the area update link
When the user deletes the existing related places rows
And the user clicks on the add button for adding new places for area page
When the user clicks on edit button in places for area
Then the user should see 'Go' button disabled until value for City is selected
When the user clicks on the country option in the places for area
And the user enters the country <countryPlaces> in type-ahead box for area related places
And the user clicks on area option in the places for area
And the user enters area <areaPlaces> in the type-ahead box for area related places
Then the user should see 'Go' button disabled until value for City is selected

Examples:
|country|area|countryPlaces|areaPlaces|
|Angola|Cabinda|Algeria|No Area|
|Angola|Cabinda|Algeria|Return All Cities|

Scenario: Verify whether Go Button is disabled when (while adding a new related place)
User should see Go Button is Enabled when
a)Country selected. Area not selected ("Choose an Area") & Country should be updated in place
b)Country selected. Area selected and <> "Return All Areas" or "NO area". City not selected ("Choose a City") & Area should be updated in place

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the area places link in the navigation bar
And the user clicks on the area update link
When the user deletes the existing related places rows
And the user clicks on the add button for adding new places for area page
When the user clicks on edit button in places for area
When the user clicks on the country option in the places for area
And the user enters the country <countryPlaces> in type-ahead box for area related places
Then the user should see Go button enabled
When the user clicks on go button in places for area
Then the user should see place as Angola in places for area
When the user clicks on edit button in places for area
When the user clicks on the country option in the places for area
And the user enters the country <countryPlaces> in type-ahead box for area related places
When the user clicks on area option in the places for area
When the user enters area <areaPlaces> in the type-ahead box for area related places
Then the user should see Go button enabled
When the user clicks on go button in places for area
Then the user should see place as Moxico in places for area

Examples:
|country|area|countryPlaces|areaPlaces|
|Angola|Cabinda|Angola|Moxico|

Scenario: Verify whether Go Button is disabled when (while updating existing related place)
User should see Go Button is Enabled when
a)Country selected. Area not selected ("Choose an Area") & Country should be updated in place
b)Country selected. Area selected and <> "Return All Areas" or "NO area". City not selected ("Choose a City") & Area should be updated in place

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the area places link in the navigation bar
And the user clicks on the area update link
When the user gets the document with get document id for area with the <area> from the database
When the user deletes the existing related places rows
And the user clicks on the add button for adding new places for area page
And the user selects type value as <placeType> in the places for area
When the user clicks on edit button in places for area
And the user clicks on the country option in the places for area
When the user enters the country <countryPlaces> in type-ahead box for area related places
Then the user should see Go button enabled
When the user clicks on go button in places for area
Then the user should see place as Angola in places for area
When the user clicks on edit button in places for area
When the user clicks on the country option in the places for area
And the user enters the country <countryPlaces> in type-ahead box for area related places
When the user clicks on area option in the places for area
When the user enters area <areaPlaces> in the type-ahead box for area related places
Then the user should see Go button enabled
When the user clicks on go button in places for area
Then the user should see place as Namibe in places for area
When the user clicks on edit button in places for area
When the user clicks on the country option in the places for area
And the user enters the country <countryPlaces> in type-ahead box for area related places
When the user clicks on area option in the places for area
When the user enters area <areaPlaces> in the type-ahead box for area related places
And the user clicks on city options in the places for area
And the user enters city <cityPlaces> in the type-ahead box for area related places
And the user clicks on go button in places for area
And the user selects details value as <placeDetails> in the places for area
And the user clicks on the save button
Then the user should see the save confirmation modal
When the user clicks on the confirm button
Then the user should see the successful update message at top of the page
Then the user reverts the changes to the document

Examples:
|country|area|countryPlaces|areaPlaces|cityPlaces|placeType|placeDetails|
|Angola|Cabinda|Angola|Namibe|Bibala|Capital City|State Capital|

Scenario: 
a)Verify whether user is able to delete an existing  Area Related place successfully in Area Web page
b)Verify whether user is not able to view the deleted related place in Zeus Document

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the area places link in the navigation bar
And the user clicks on the area update link
When the user gets the document with get document id for area with the <area> from the database
When the user deletes the existing related places rows
And the user clicks on the add button for adding new places for area page
And the user selects type value as <placeType> in the places for area
When the user clicks on edit button in places for area
And the user clicks on the country option in the places for area
When the user enters the country <countryPlaces> in type-ahead box for area related places
And the user clicks on area option in the places for area
When the user enters area <areaPlaces> in the type-ahead box for area related places
And the user clicks on city options in the places for area
And the user enters city <cityPlaces> in the type-ahead box for area related places
And the user clicks on go button in places for area
And the user selects details value as <placeDetails> in the places for area
And the user clicks on the save button
Then the user should see the save confirmation modal
When the user clicks on the confirm button
Then the user should see the successful update message at top of the page
Then the user should see <placeType> <cityPlaces> <placeDetails> updated in area related place
When the user clicks on the update link
When the user clicks on delete area places type
Then the user should see the delete row confirmation modal in the area page
When the user clicks on the Yes button to cancel the deletion of row
When the user clicks on the save button
Then the user should see the save confirmation modal
And the user should see the below summary changes in confirmation modal
|Summary|
|Related Places|
When the user clicks on the confirm button
Then the user should see the successful update message at top of the page
Then the user should not see <placeType> <cityPlaces> <placeDetails> updated in area related place
Then the user should not see the area related place value in zeus document
Then the user reverts the changes to the document

Examples:
|country|area|placeType|countryPlaces|areaPlaces|cityPlaces|placeDetails|
|Angola|Cabinda|Capital City|Angola|Luanda|Palanca|State Capital|

Scenario: 
Verify whether user is able to view the related place in Area page when 'no' button is clicked in delete confirmation dialog

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the area places link in the navigation bar
And the user clicks on the area update link
When the user gets the document with get document id for area with the <area> from the database
When the user clicks on delete area places type
Then the user should see the delete row confirmation modal in the area page
When the user clicks on the No button to cancel the deletion of row
When the user clicks on the save button
Then the user should see the save confirmation modal
Then the user should not see the <ConfirmationSummary> changes in confirmation modal
When the user clicks on the confirm button
Then the user should see the successful update message at top of the page
Then the user should see <placeType> <cityPlaces> <placeDetails> updated in area related place
Then the user should see area related place date <placeType> <cityPlaces> <placeDetails> value in zeus document
Then the user reverts the changes to the document

Examples:
|country|area|placeType|countryPlaces|areaPlaces|cityPlaces|placeDetails|ConfirmationSummary|
|Angola|Cabinda|Capital City|Angola|Cunene|Cahama|State Capital|Summary|

Scenario: User is verifying whether all expected Fields are disabled/Enabled at Related Place section

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the area places link in the navigation bar
And the user clicks on the area update link
When the user deletes the existing related places rows
And the user clicks on the add button for adding new places for area page
When the user clicks on edit button in places for area
Then the user should see the default value for country is Choose a country
Then the user should see the area dropdown is disabled
Then the user should see the city dropdown is disabled
Then the user should see Edit button for place field is disabled
Then the user should see the delete option is  disabled until drawer closes
When the user clicks on the country option in the places for area
When the user enters the country <countryPlaces> in type-ahead box for area related places
And the user clicks on the country option in the places for area
Then the user should see Choose a country option is not selectable
Then the user should see the default value for area is Choose an area
When the user clicks on area option in the places for area
When the user enters area <areaPlaces> in the type-ahead box for area related places
When the user clicks on area option in the places for area
Then the user should see Choose an area option is not selectable
Then the user should see the default value for area is Choose a city
When the user clicks on city options in the places for area
And the user enters city <cityPlaces> in the type-ahead box for area related places
When the user clicks on city options in the places for area
Then the user should see Choose a City option is not selectable
When the user clicks on go button in places for area
Then the user should see that drawer is closed
Then the user should see that Edit button for place field is enabled

Examples:
|country|area|placeType|countryPlaces|areaPlaces|cityPlaces|
|Angola|Cabinda|Capital City|Algeria|Blida|Bouinan|