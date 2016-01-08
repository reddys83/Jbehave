Meta:@CityBasicInfo @City

Narrative:
In order to view and edit the cities basic info
As a user
I want to cover the requirements mentioned in
JIRA ID - ZEUS - 92 - User can view city basic info
JIRA ID - ZEUS - 371 - User can follow link to area from city

Scenario: Verify the City basic info
Meta:@verifyBuild
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
And the user clicks on the city basic info link in the navigation bar
Then the user should see the basic info for selected city

And the user should see the city's names as:
|TYPE|VALUE|
|Full Name|Chicago|

And the user should see the city's identifiers as:
|TYPE|VALUE|STATUS|
|FIPS Place Code|14000|active|

And the user should see the Status of a city as Active
And the user should see the Began Date of a city as 03 Dec 1818
And the user should see the End Date of a city as 03 Jul 2776
And the user should see the Country of a city as USA
And the user should see the Area of a city as Illinois
And the user should see the Sub Area of a city as Cook
And the user should see the Replaced By of a city as Barajyolu, Chester
And the user should see the Population of a city as 149,998
And the user should see the Use In Address of a city as True
And the user should see the Add Info of a city as Land of Lincoln

Examples:
|country|area|city|
|USA|Illinois|Chicago|

Scenario: Verify city basic info with have no link to another area
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
And the user clicks on the city basic info link in the navigation bar
Then the user should not see the city's area link
And the user should not see the city's Subarea link

Examples:
|country|area|city|
|Turkmenistan|Return All Cities|Mary|

Scenario: User can follow link to area from city - click area
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
And the user clicks on the city basic info link in the navigation bar
And the user clicks on the city area link Illinois
Then the user should see the area page with USA, Illinois and Choose a Subarea selected
And the user should see the area's names as:
|TYPE|VALUE|
|Full Name|Illinois|
|Display Name|IL|

Examples:
|country|area|city|
|USA|Illinois|Chicago|

Scenario: User can follow link to area from city - click area
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
And the user clicks on the city basic info link in the navigation bar
And the user clicks on the city subarea link Cook
Then the user should see the area page with USA, Illinois and Cook selected
And the user should see the area's names as:
|TYPE|VALUE|
|Full Name|Cook|
|Display Name|Cook|

Examples:
|country|area|city|
|USA|Illinois|Chicago|