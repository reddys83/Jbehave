Meta: @EditCityRelatedPlaces @Edit @City @AllStories

Narrative:
In order to view and edit the city page
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