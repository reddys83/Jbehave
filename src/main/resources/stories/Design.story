Meta:@Design



Scenario: Verify the user is able to save the documetn with valid inputs
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
And the user clicks on area drop down in the places for country
When the user selects area <areaPlaces> dropdown in places for country
And the user clicks on city drop down in the places for country
And the user selects city <cityPlaces> dropdown in the places for country
And the user clicks on go button in places for country
And the user selects details value as <PlaceDetails> in the places for country
And the user clicks on the save button
Then the user should see the save confirmation modal

Examples:
|country|PlaceType|countryPlaces|areaPlaces|cityPlaces|PlaceDetails|
|Mayotte Island|Capital City|Algeria|Blida|Bouinan|Judicial Capital|

