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
And the user clicks on the area regions link in the navigation bar
And the user clicks on the area update link
And the user clicks on the add button for adding new places for area page
When the user clicks on new area places type drop-down for area
Then the user should see the values for type dropdown from lookup AREA_RELATED_PLACE_TYPE
When the user clicks on new area places details drop-down for area
Then the user should see the values for details dropdown from lookup AREA_RELATED_PLACE_SUBTYPE

Examples:
|country|area|
|Angola|Cabinda|

Scenario: Verify whether User is able to see error message "Required" when input values are blank for 'place' & 'type' field

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the area regions link in the navigation bar
And the user clicks on the area update link
And the user clicks on the add button for adding new places for area page
And the user clicks on the save button
Then the user should see the error message required for type in places for area
Then the user should see the error message required for place in places for area
Then the user should see the error message at top of page the highlighted fields must be addressed before this update can be saved

Examples:
|country|area|
|Angola|Cabinda|

Scenario: 
a)Verify whether user is able to add a Area Related place  successfully in Area Web page
b)Verify whether user is able to view the added related place in Zeus Document

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the area regions link in the navigation bar
And the user clicks on the area update link
When the user gets the document with get document id for area with the <area> from the database
When the user deletes the existing related places rows
And the user clicks on the add button for adding new places for area page
And the user selects type value as <PlaceType> in the places for area
When the user clicks on edit button in places for area
And the user clicks on the country option in the places for area
When the user enters the country <countryPlaces> in type-ahead box for area related places
And the user clicks on area option in the places for area
When the user enters area <areaPlaces> in the type-ahead box for area related places
And the user clicks on city options in the places for area
And the user enters city <cityPlaces> in the type-ahead box for area related places
And the user clicks on go button in places for area
And the user selects details value as <PlaceDetails> in the places for area
And the user clicks on the save button
Then the user should see the save confirmation modal
And the user should see the below summary changes in confirmation modal
|Summary|
|Related Places|
When the user clicks on the confirm button
Then the user should see the successful update message at top of the page
Then the user should see <PlaceType> <cityPlaces> <PlaceDetails> updated in area related place
Then the user reverts the changes to the document

Examples:
|country|area|PlaceType|countryPlaces|areaPlaces|cityPlaces|PlaceDetails|
|Angola|Cabinda|Twin City|Angola|Bengo|Caxito|Capital City|

Scenario: 
a)Verify whether user is able to update an existing  Area Related place (different to the current value) with same values successfully
b)Verify whether user should get  changes in confirmation modal

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the area regions link in the navigation bar
And the user clicks on the area update link
When the user gets the document with get document id for area with the <area> from the database
And the user selects type value as <PlaceType> in the places for area
When the user clicks on edit button in places for area
And the user clicks on the country option in the places for area
When the user enters the country <countryPlaces> in type-ahead box for area related places
And the user clicks on area option in the places for area
When the user enters area <areaPlaces> in the type-ahead box for area related places
And the user clicks on city options in the places for area
And the user enters city <cityPlaces> in the type-ahead box for area related places
And the user clicks on go button in places for area
And the user selects details value as <PlaceDetails> in the places for area
And the user clicks on the save button
Then the user should see the save confirmation modal
And the user should see the below summary changes in confirmation modal
|Summary|
|Related Places|
When the user clicks on the confirm button
Then the user should see the successful update message at top of the page
Then the user should see <PlaceType> <cityPlaces> <PlaceDetails> updated in area related place
Then the user reverts the changes to the document

Examples:
|country|area|PlaceType|countryPlaces|areaPlaces|cityPlaces|PlaceDetails|
|Angola|Cabinda|Twin City|Angola|Bengo|Caxito|Capital City|

Scenario: Verify whether the list in country, Area and city dropdown is displaying as expected

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the area regions link in the navigation bar
And the user clicks on the area update link
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
|country|area|city|countryPlaces|areaPlaces|
|Tajikistan|Leninabadskaya Oblast|Gafurov|Algeria|Blida|

Scenario: Verify whether User is able to see Go Button is disabled when
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
And the user clicks on the area regions link in the navigation bar
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
|Tajikistan|Leninabadskaya Oblast|Algeria|No Area|
|Tajikistan|Leninabadskaya Oblast|Algeria|Return All Cities|