Meta: @EditCityBasicInfo @Edit @City @AllStories

Narrative:
In order to view and edit the city page
As a user
I want to cover the requirements mentioned in

Scenario: Verify whether User is able to see error message "Required" when input values are blank for 'type' field
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
Then the user should see the error message required for type in places for city
Then the user should see the error message at top of page the highlighted fields must be addressed before this update can be saved

Examples:
|country|area|city|
|Tajikistan|Leninabadskaya Oblast|Gafurov|

Scenario: Verify whether User is able to see error message "Required" when input values are blank for 'place' field
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
Then the user should see the error message at top of page the highlighted fields must be addressed before this update can be saved

Examples:
|country|area|city|
|Tajikistan|Leninabadskaya Oblast|Gafurov|



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

Scenario: 
a)Verify whether user is able to add a City Related place  successfully in City Web page
b)Verify whether user is able to view the added related place in Zeus Document
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
When the user deletes the existing related places rows
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
Then the user reverts the changes to the document


Examples:
|country|area|city|PlaceType|countryPlaces|areaPlaces|cityPlaces|PlaceDetails|
|Tajikistan|Leninabadskaya Oblast|Gafurov|Twin City|Afghanistan|Badakshan|Badakshan|Capital City|