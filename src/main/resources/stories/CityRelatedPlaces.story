Meta:@CityRelatedPlaces

Narrative:
In order to view the city related places
As a user
I want to cover the requirements mentioned in
JIRA ID - ZEUS-329 - User can view a city's related places

Scenario: Verify city related places.
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
When the user clicks on the choose an area option
When the user enters the area <area> in the type-ahead box
When the user clicks on the choose a city option
When the user enters the city <city> in the type-ahead box
And the user clicks on the city's places link in the navigation bar

Then the user should see the city's places as:
|TYPE|PLACE|DETAILS|
|Capital|South Valley Stream|Including its lake area, The country has a total area of 1,635 square miles|
|country|USA||
|State, Largest sub area|Nassau||

Examples:
|country|area|city|
|USA|Illinois|Chicago|

Scenario: Verify city has no related places.
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
When the user clicks on the choose an area option
When the user enters the area <area> in the type-ahead box
When the user clicks on the choose a city option
When the user enters the city <city> in the type-ahead box
And the user clicks on the city's places link in the navigation bar

Then the user should not see the city's related places

Examples:
|country|area|city|
|Panama|Herrera|Ocu|