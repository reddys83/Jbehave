Meta:@CityAlternativeRegions @City @View @AllStories

Narrative:
In order to view and edit the cities
As a user
I want to cover the requirements mentioned in
JIRA ID - ZEUS-328 - User can view city's alternative regions

Scenario: Verify City alternative region data.
Meta:@verifyBuild
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
When the user clicks on the choose an area option
When the user enters the area <area> in the type-ahead box
When the user clicks on the choose a city option
When the user enters the city <city> in the type-ahead box
When the user clicks on the city regions link in the navigation bar

Then the user should see the city's alternative regions as:
|TYPE|VALUE|
|Metropolitan Statistical Area|16980|
|Federal Reserve District|7|
|Federal Home Loan Bank District|7|
|National Credit Union Administration Region|IV|

Examples:
|country|area|city|
|USA|Illinois|Chicago|

Scenario: Verify no city's alternative region data.
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
When the user clicks on the choose an area option
When the user enters the area <area> in the type-ahead box
When the user clicks on the choose a city option
When the user enters the city <city> in the type-ahead box
When the user clicks on the city regions link in the navigation bar

Then the user should not see the city's alternative regions

Examples:
|country|area|city|
|Turkey|Adana|Barajyolu|
