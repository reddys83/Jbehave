Meta:@CityRelatedPeople @City @View @AllStories

Narrative:
In order to view and edit the people information
As a user
I want to cover the requirements mentioned in
JIRA ID - ZEUS-331 - User can view a city's related people

Scenario: Verify related people information for city.
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
When the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
When the user clicks on the city's people link in the navigation bar
Then the user should see the city's people as:
|TYPE|PERSON|
|President, Cheif executor|Yasuo Ueno|
|Financial Institution Board member|Steven Bangert|

Examples:
|country|area|city|
|USA|Illinois|Chicago|

Scenario: Verify the city which have no people.
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
When the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
When the user clicks on the city's people link in the navigation bar
Then the user should not see the city's people

Examples:
|country|area|city|
|USA|Illinois|Channahon|

