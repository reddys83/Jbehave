Meta: @EditCityBasicInfo @Edit @City @AllStories

Narrative:
In order to view and edit the city page
As a user
I want to cover the requirements mentioned in

Scenario: Verify the required messages for place
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
