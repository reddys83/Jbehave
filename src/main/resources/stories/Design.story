Meta:@Design

Scenario: Verify whether User is able to see Go Button is disabled when (while updating existing related place)
User should see Go Button is Enabled when
a)Country selected. Area not selected ("Choose an Area") & Country should be updated in place
b)Country selected. Area selected and <> "Return All Areas" or "NO area". City not selected ("Choose a City") & Area should be updated in place

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
And the user selects type value as <PlaceType> in the places for city
When the user clicks on edit button in places for city
And the user clicks on the country option in the places for city
When the user enters the country <countryPlaces> in type-ahead box for city related places
Then the user should see Go button enabled
When the user clicks on go button in places for city
Then the user should see place as Angola in places for city
When the user clicks on edit button in places for city
When the user clicks on the country option in the places for city
And the user enters the country <countryPlaces> in type-ahead box for city related places
When the user clicks on area option in the places for city
When the user enters area <areaPlaces> in the type-ahead box for city related places
Then the user should see Go button enabled
When the user clicks on go button in places for city
Then the user should see place as Namibe in places for city
When the user clicks on edit button in places for city
When the user clicks on the country option in the places for city
And the user enters the country <countryPlaces> in type-ahead box for city related places
When the user clicks on area option in the places for city
When the user enters area <areaPlaces> in the type-ahead box for city related places
And the user clicks on city options in the places for city
And the user enters city <cityPlaces> in the type-ahead box for city related places
And the user clicks on go button in places for city
And the user selects details value as <PlaceDetails> in the places for city
And the user clicks on the save button
Then the user should see the save confirmation modal
When the user clicks on the confirm button
Then the user should see the successful update message at top of the page
Then the user reverts the changes to the document

Examples:
|country|area|city|countryPlaces|areaPlaces|cityPlaces|PlaceType|PlaceDetails|
|Tajikistan|Leninabadskaya Oblast|Gafurov|Angola|Namibe|Bibala|Twin City|Capital City|