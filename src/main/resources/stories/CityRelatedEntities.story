Meta:@CityRelatedEntities @City

Narrative:
In order to view and edit the city information
As a user
I want to cover the requirements mentioned in
JIRA ID - ZEUS - 330 - User can view a city's related entities

Scenario: Verify city entities data with legalEntity
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
Then the user should see the country list box displayed
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
When the user clicks on the choose an area option
When the user enters the area <area> in the type-ahead box
When the user clicks on the choose a city option
When the user enters the city <city> in the type-ahead box
And the user clicks on the city's entity link in the navigation bar

Then the user should see the city's entity as:
|TYPE|ENTITY|DETAILS|
|Government Type|Illinois Department of Employment Security||
|Government, city|Illinois Department of Employment Security|City Government, Also known as the IBA|

Examples:
|country|area|city|
|USA|Illinois|Chicago|

Scenario: Verify no city's entities
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
Then the user should see the country list box displayed
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
When the user clicks on the choose an area option
When the user enters the area <area> in the type-ahead box
When the user clicks on the choose a city option
When the user enters the city <city> in the type-ahead box
And the user clicks on the city's entity link in the navigation bar

Then the user should not see the city's entity

Examples:
|country|area|city|
|Belgium|Brabant Wallon|Sint-Stevens-Woluwe|
