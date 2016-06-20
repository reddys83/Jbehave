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

Examples:
|country|area|city|PlaceType|countryPlaces|areaPlaces|cityPlaces|PlaceDetails|
|Tajikistan|Leninabadskaya Oblast|Gafurov|Twin City|Afghanistan|Badakshan|Badakshan|Test2|