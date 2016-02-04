Meta:@SubAreaList @Area @View

Narrative:
In order to view the places of country
As a user
I want to cover the requirements mentioned in
JIRA ID - ZEUS-315 - User can search for subArea by full name
JIRA ID - ZEUS-321 - ignore special characters in currency, country, area/subarea and city drop-down

Scenario: Verify subArea list
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
When the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a sub-area option
Then the user should see the list of all existing subarea for the selected area by full name

Examples:
|country|area|
|USA|Illinois|

Scenario: Verify the subarea for selected country.
1. country and area with multiple subareas.
Meta:
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
Then the user should see the country type-ahead displayed
When the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
Then the user should see the below subareas for the selected country and area:
|SUBAREAS|
|Co. Antrim|
|Co. Armagh|
|Co. Down|
|Co. Fermanagh|
|Co. Londonderry|
|Co. Tyrone|
|Fermanagh|
|Londonderry|

Examples:
|country|area|
|UK|Northern Ireland|

Scenario: Verify the area for selected country.
Testcase: country and area with no subareas.
Meta:
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
Then the user should see the country type-ahead displayed
When the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
Then the user should see the subarea dropdown disabled

Examples:
|country|area|
|Angola|Cuando Cubango|

