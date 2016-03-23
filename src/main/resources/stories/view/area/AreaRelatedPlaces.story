Meta:@AreaRelatedPlaces @Area @View

Narrative:
In order to view the area basic info
As a user
I want to cover the requirements mentioned in
JIRA ID - ZEUS-305 - User can view an area's related places

Scenario: Verify Area related places.
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
When the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
When the user clicks on the area's places link in the navigation bar
Then the user should see the area related places from trusted document

Examples:
|country|area|
|USA|Illinois|


Scenario: Verify the Area which have no places
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
When the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the area's places link in the navigation bar
Then the user should not see the area's places

Examples:
|country|area|
|UAE|Ajman|


Scenario: Verify related places information for sub-area.
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
When the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a sub-area option
And the user enters the sub-area <subArea> in the type-ahead box
When the user clicks on the sub-area's places link in the navigation bar

Then the user should see the sub-area's related places from trusted document

Examples:
|country|area|subArea|
|USA|Illinois|Cook|

Scenario: Verify the sub area which have no places
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
When the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a sub-area option
And the user enters the sub-area <subArea> in the type-ahead box
When the user clicks on the sub-area's places link in the navigation bar
Then the user should not see the sub-area's places

Examples:
|country|area|subArea|
|USA|New Jersey|Camden|