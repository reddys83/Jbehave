Meta:@Design


Scenario: User selects country , area or city  then only those should appear in place respectively
TestCase - user selects country and hit go button, then country should display
TestCase - user selects country and area and hit go button, then area should display
TestCase - user selects country and area and city and hit go button, then city should display

Meta:
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
When the user clicks on the country places link in the navigation bar
And the user clicks on the update link
And the user clicks on the add new places button in the places for country
And the user clicks on new country places type drop-down
And the user selects type value as <PlaceType> in the places for country
When the user clicks on edit button in places for country
And the user clicks on the country drop down in the places for country
When the user selects the country <countryPlaces> in the places for country
And the user clicks on go button in places for country
Then the user should see place as Algeria in places for country
When the user clicks on edit button in places for country
And the user clicks on area drop down in the places for country
When the user selects area <areaPlaces> dropdown in places for country
And the user clicks on go button in places for country
Then the user should see place as Blida in places for country
When the user clicks on edit button in places for country
And the user clicks on city drop down in the places for country
And the user selects city <cityPlaces> dropdown in the places for country
And the user clicks on go button in places for country
Then the user should see place as Bouinan in places for country



Examples:
|country|PlaceType|countryPlaces|areaPlaces|cityPlaces|
|Mayotte Island|Capital City|Algeria|Blida|Bouinan|