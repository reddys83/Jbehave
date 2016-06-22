Meta: @EditCityBasicInfo @Edit @City @AllStories

Narrative:
In order to view and edit the city page
As a user
I want to cover the requirements mentioned in



Scenario: Verify whether User is able to see error message "Required" when input values are blank for 'type' & 'value' field
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
When the user clicks on the city places link in the navigation bar
And the user clicks on the update link
And the user clicks on the add button for adding new places for city page
And the user clicks on the save button
Then the user should see the error message required for place in places for city
Then the user should see the error message required for type in places for city
Then the user should see the error message at top of page the highlighted fields must be addressed before this update can be saved

Examples:
|country|area|city|
|Tajikistan|Leninabadskaya Oblast|Gafurov|

Scenario: Verify the user is able to save the documetn with valid inputs
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
When the user clicks on the city places link in the navigation bar
And the user clicks on the update link
And the user clicks on the add button for adding new places for city page
And the user clicks on new country places type drop-down for city
And the user selects type value as <PlaceType> in the places for city
When the user clicks on edit button in places for city
And the user clicks on the country drop down in the places for city
When the user selects the country <countryPlaces> in the places for city
And the user clicks on area drop down in the places for city
When the user selects area <areaPlaces> dropdown in places for city
And the user clicks on city drop down in the places for city
And the user selects city <cityPlaces> dropdown in the places for city
And the user clicks on go button in places for city
And the user selects details value as <PlaceDetails> in the places for city
And the user clicks on the save button
Then the user should see the save confirmation modal
And the user should see the below summary changes in confirmation modal
|Summary|
|Related Places|

Examples:
|country|area|city|PlaceType|countryPlaces|areaPlaces|cityPlaces|PlaceDetails|
|Tajikistan|Leninabadskaya Oblast|Gafurov|Twin City|Afghanistan|Badakshan|Badakshan|Capital City|

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
When the user clicks on the city places link in the navigation bar
And the user clicks on the update link
And the user clicks on the add button for adding new places for city page
And the user clicks on new country places type drop-down for city
And the user selects type value as <PlaceType> in the places for city
When the user clicks on edit button in places for city
And the user clicks on the country drop down in the places for city
When the user selects the country <countryPlaces> in the places for city
And the user clicks on go button in places for city
Then the user should see place as Algeria in places for city
When the user clicks on edit button in places for city
And the user clicks on area drop down in the places for city
When the user selects area <areaPlaces> dropdown in places for city
And the user clicks on go button in places for city
Then the user should see place as Blida in places for city
When the user clicks on edit button in places for city
And the user clicks on city drop down in the places for city
And the user selects city <cityPlaces> dropdown in the places for city
And the user clicks on go button in places for city
Then the user should see place as Bouinan in places for city

Examples:
|country|area|city|PlaceType|countryPlaces|areaPlaces|cityPlaces|
|Tajikistan|Leninabadskaya Oblast|Gafurov|Capital City|Algeria|Blida|Bouinan|


Scenario: User is verifying Country,Area & City Dropdowns

Meta:
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
When the user clicks on the city places link in the navigation bar
And the user clicks on the update link
And the user clicks on the add button for adding new places for city page
And the user clicks on new country places type drop-down
And the user selects type value as <PlaceType> in the places for city
When the user clicks on edit button in places for city
And the user clicks on the country drop down in the places for city
When the user selects the country <countryPlaces> in the places for city
And the user clicks on area drop down in the places for city
When the user selects area <areaPlaces> dropdown in places for city
And the user clicks on city drop down in the places for city
And the user selects city <cityPlaces> dropdown in the places for city
And the user clicks on go button in places for city
And the user clicks on delete city places type
Then the user should see the delete row confirmation modal in the city page

Examples:
|country|area|city|PlaceType|countryPlaces|areaPlaces|cityPlaces|
|Tajikistan|Leninabadskaya Oblast|Gafurov|Capital City|Algeria|Blida|Bouinan|

Scenario: User is verifying whether 'Go' button is disabled if user is not selecting 'city' value & selects 'area' value.

Meta:
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
When the user clicks on the city places link in the navigation bar
And the user clicks on the update link
And the user clicks on the add button for adding new places for city page
When the user clicks on edit button in places for city
And the user clicks on the country drop down in the places for city
When the user selects the country <countryPlaces> in the places for city
And the user clicks on area drop down in the places for city
When the user selects area <areaPlaces> dropdown in places for city
And the user clicks on city drop down in the places for city
And the user selects city <cityPlaces> dropdown in the places for city
Then the user should see Edit button for place field is disabled until drawer closes
Then the user should see the delte option is  disabled until drawer closes
When the user clicks on go button in places for city
Then the user should see that drawer is closed
When the user clicks on edit button in places for city
And the user clicks on the country drop down in the places for city
When the user selects the country <countryPlaces> in the places for city
Then the user should see 'Go' button disabled until value for Area is selected
When the user clicks on edit button in places for city
And the user clicks on the country drop down in the places for city
When the user selects the country <countryPlaces> in the places for city
And the user clicks on area drop down in the places for city
When the user selects area <areaPlaces> dropdown in places for city
Then the user should see 'Go' button disabled until value for City is selected

Examples:
|country|area|city|PlaceType|countryPlaces|areaPlaces|cityPlaces|
|Tajikistan|Leninabadskaya Oblast|Gafurov|Capital City|Algeria|Blida|Bouinan|

Scenario: Verify the list of type dropdown are from CITY_RELATED_PLACE_TYPE and details dropdown from CITY_RELATED_PLACE_SUBTYPE

Meta:
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
When the user clicks on the city places link in the navigation bar
And the user clicks on the update link
And the user clicks on the add button for adding new places for city page
When the user clicks on new city places type drop-down for city
Then the user should see the values for type dropdown from lookup CITY_RELATED_PLACE_TYPE
When the user clicks on new city places details drop-down for city
Then the user should see the values for details dropdown from lookup CITY_RELATED_PLACE_SUBTYPE

Examples:
|country|area|city|
|Tajikistan|Leninabadskaya Oblast|Gafurov|

Scenario: Verify the list in country, Area and city dropdown
Meta:
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
When the user clicks on the city places link in the navigation bar
And the user clicks on the update link
And the user clicks on the add button for adding new places for city page
When the user clicks on edit button in places for city
And the user clicks on the country drop down in the places for city
Then the user should see the list of all existing countries by full name in places for city
When the user selects the country <countryPlaces> in the places for city
And the user clicks on area drop down in the places for city
Then the user should see the list of all existing area for the selected country by full name in places for city
When the user selects area <areaPlaces> dropdown in places for city
And the user clicks on city drop down in the places for city
Then the user should see the list of all existing city for the selected area by full name in places for country
Then the user should see the list of all existing city for the selected area by full name in places for city

Examples:
|country|area|city|countryPlaces|areaPlaces|
|Tajikistan|Leninabadskaya Oblast|Gafurov|Algeria|Blida|

Scenario: Verify the user is able to save City Related places successfully in City Web page & Zeus Document
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
When the user clicks on the city places link in the navigation bar
And the user clicks on the update link
When the user gets the document with get document id for city with the <city> from the database
And the user clicks on the add button for adding new places for city page
And the user clicks on new city places type drop-down for city
And the user selects type value as <PlaceType> in the places for city
When the user clicks on edit button in places for city
And the user clicks on the country drop down in the places for city
When the user selects the country <countryPlaces> in the places for city
And the user clicks on area drop down in the places for city
When the user selects area <areaPlaces> dropdown in places for city
And the user clicks on city drop down in the places for city
And the user selects city <cityPlaces> dropdown in the places for city
And the user clicks on go button in places for city
And the user selects details value as <PlaceDetails> in the places for city
And the user clicks on the save button
Then the user should see the save confirmation modal
And the user should see the below summary changes in confirmation modal
|Summary|
|Related Places|
When the user clicks on the confirm button
Then the user should see the successful update message at top of the page
Then the user should see <PlaceType> <cityPlaces> <PlaceDetails> updated in city related place
Then the user should see the city related place date <PlaceType> <cityPlaces> <PlaceDetails> value in zeus document


Examples:
|country|area|city|PlaceType|countryPlaces|areaPlaces|cityPlaces|PlaceDetails|
|Tajikistan|Leninabadskaya Oblast|Gafurov|Twin City|Afghanistan|Badakshan|Badakshan|Capital City|

Scenario: User is checking if related place is deleted successfully

Meta:
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
When the user clicks on the city places link in the navigation bar
And the user clicks on the update link
And the user clicks on delete city places type
Then the user should see the delete row confirmation modal in the city page
When the user clicks on the Yes button to cancel the deletion of row
When the user clicks on the save button
Then the user should see the save confirmation modal
And the user should see the below summary changes in confirmation modal
|Summary|
|Related Places|
When the user clicks on the confirm button in city page
Then the user should see the successful update message at top of the page

Examples:
|country|area|city|PlaceType|countryPlaces|areaPlaces|cityPlaces|
|Tajikistan|Leninabadskaya Oblast|Gafurov|Capital City|Algeria|Blida|Bouinan|

