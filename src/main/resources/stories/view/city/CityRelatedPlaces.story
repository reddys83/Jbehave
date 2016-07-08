Meta:@CityRelatedPlaces @City @View @AllStories

Narrative:
In order to view the city related places
As a user
I want to cover the requirements mentioned in
JIRA ID - ZEUS-329 - User can view a city's related places
JIRA ID - ZEUS - 371 - User can follow link to area from city
JIRA ID - ZEUS - 372 - User can follow link to country from city
JIRS ID - ZEUS - 379 - User can follow link to city from another city

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

Then the user should see the city related places from trusted document

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

Scenario: User can follow link to area from city related place - click subarea in other country
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
And the user clicks on the city's places link in the navigation bar
And the user clicks on the city related place link Bilaspur
Then the user should see the area page with India, Chhattisgarh and Bilaspur selected
And the user should see the area's names as:
|TYPE|VALUE|
|Full Name|Bilaspur|
|Display Name|Bilaspur|

Examples:
|country|area|city|
|USA|Illinois|Chicago|

Scenario: User can follow link to area from city related place - click subarea in same country
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
And the user clicks on the city's places link in the navigation bar
And the user clicks on the city related place link Cook
Then the user should see the area page with USA, Illinois and Cook selected
And the user should see the area's names as:
|TYPE|VALUE|
|Full Name|Cook|
|Display Name|Cook|

Examples:
|country|area|city|
|USA|Illinois|Chicago|

Scenario: User can follow link to area from city related place - click area in other country
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
And the user clicks on the city's places link in the navigation bar
And the user clicks on the city related place link Berat
Then the user should see the area page with Albania, Berat and Choose a Subarea selected
And the user should see the area's names as:
|TYPE|VALUE|
|Full Name|Berat|
|Display Name|Berat|

Examples:
|country|area|city|
|USA|Illinois|Chicago|

Scenario: User can follow link to area from city related place - click area in same country
1. BUG-ID - ZEUS-795
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
And the user clicks on the city's places link in the navigation bar
And the user clicks on the city related place link Illinois
Then the user should see the area page with USA, Illinois and Choose a Subarea selected
And the user should see the area's names as:
|TYPE|VALUE|
|Full Name|Atchison|
|Display Name|Atchison|

Examples:
|country|area|city|
|USA|Illinois|Chicago|

Scenario: User can follow link to country from city related place - click same country
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
And the user clicks on the city's places link in the navigation bar
And the user clicks on the city related place link USA
Then the user should see the country page with USA selected
And the user should see the area's names as:
|TYPE|VALUE|
|Country Name|USA|

Examples:
|country|area|city|
|USA|Illinois|Chicago|

Scenario: User can follow link to country from city related place - click different country
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
And the user clicks on the city's places link in the navigation bar
And the user clicks on the city related place link UK
Then the user should see the country page with UK selected
And the user should see the area's names as:
|TYPE|VALUE|
|Country Name|UK|

Examples:
|country|area|city|
|USA|Illinois|Chicago|


Scenario: Verify User can follow link to city from another city in related places
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
When the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
And the user clicks on the city's places link in the navigation bar
And the user clicks on the city related place link South Valley Stream
Then the user should see the city's names as:

|TYPE|VALUE|
|Full Name|South Valley Stream|

Examples:
|country|area|city|
|USA|Illinois|Chicago|