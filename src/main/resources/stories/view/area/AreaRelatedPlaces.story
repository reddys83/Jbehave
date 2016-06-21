Meta:@AreaRelatedPlaces @Area @View @AllStories

Narrative:
In order to view the area basic info
As a user
I want to cover the requirements mentioned in
JIRA ID - ZEUS-305 - User can view an area's related places
and
JIRA ID - ZEUS-370 - User can follow link to city from area
and
JIRA ID - ZEUS-369 - User can follow link to another area from area

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


Scenario: Verify User can follow link to city from area when the area has only one row of related places with link to a city
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
When the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
When the user clicks on the area's city <areaCity> link in the area view
Then the user should see the basic info for selected city

And the user should see the city's names as:
|TYPE|VALUE|
|Full Name|Greenfield|

Examples:
|country|area|areaCity|
|USA|Missouri|Greenfield|


Scenario: Verify User can follow link to city from area when the area has multiple rows of places links.
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
When the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
When the user clicks on the area's city <areaCity> link in the area view
Then the user should see the basic info for selected city

And the user should see the city's names as:
|TYPE|VALUE|
|Full Name|South Valley Stream|

Examples:
|country|area|areaCity|
|USA|Illinois|South Valley Stream|

Scenario: Verify User can follow link to city from sub area when the sub area has only one row of related places with link to a city
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
When the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a sub-area option
And the user enters the sub-area <subArea> in the type-ahead box
When the user clicks on the sub-area's city <areaCity> link in the sub area view
Then the user should see the basic info for selected city

And the user should see the city's names as:
|TYPE|VALUE|
|Full Name|Greenfield|

Examples:
|country|area|subArea|areaCity|
|USA|Missouri|Dade|Greenfield|


Scenario: Verify User can follow link to city from sub area when the sub area has multiple rows of places links.
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
When the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a sub-area option
And the user enters the sub-area <subArea> in the type-ahead box
When the user clicks on the sub-area's city <areaCity> link in the sub area view
Then the user should see the basic info for selected city

And the user should see the city's names as:
|TYPE|VALUE|
|Full Name|South Valley Stream|

Examples:
|country|area|subArea|areaCity|
|USA|Illinois|Cook|South Valley Stream|

Scenario: Verify User can follow link to another area from area related place
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
When the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the area's places link in the navigation bar
And the user clicks on the area related places link Michigan
Then the user should see the area page with USA, Michigan and Choose a Subarea selected

Examples:
|country|area|
|USA|Illinois|

Scenario: Verify User can follow link to  another area from Sub-area related place
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
When the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
When the user clicks on the choose a sub-area option
And the user enters the sub-area <subArea> in the type-ahead box
And the user clicks on the area's places link in the navigation bar
And the user clicks on the area related places link Michigan
Then the user should see the area page with USA, Michigan and Choose a Subarea selected

Examples:
|country|area|subArea|
|USA|ILLINOIS|Cook|

