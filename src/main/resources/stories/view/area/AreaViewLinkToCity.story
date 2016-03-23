Meta:@AreaViewLinkToCity @Area @View

Narrative:
In order to view the area basic info
As a user
I want to cover the requirements mentioned in
JIRA ID - ZEUS-370 - User can follow link to city from area

Scenario: Verify User can follow link to city from area when the area has only one row of related places with link to a city
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
When the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
When the user clicks on the Area's city <areaCity> link in the Area view
Then the user should see the basic info for selected city

And the user should see the city's names as:
|TYPE|VALUE|
|Full Name|Eolia|

Examples:
|country|area|areaCity|
|USA|Missouri|Eolia|


Scenario: Verify User can follow link to city from area the area has multiple rows of related places with links to multiple cities
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
When the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
When the user clicks on the Area's city <areaCity> link in the Area view
Then the user should see the basic info for selected city

And the user should see the city's names as:
|TYPE|VALUE|
|Full Name|Greenfields|

Examples:
|country|area|areaCity|
|USA|Missouri|Greenfields|