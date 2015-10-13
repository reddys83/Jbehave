Meta:@cityMultipleSections

Narrative:
In order to view and edit the city
As a user
I want to cover the requirements mentioned in
JIRA ID - ZEUS - 337 - User can view all city info

Scenario: Verify city default section
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
When the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
When the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
Then the user should see the default city page and display basic info
Then the user should be able to see the Basic Info for selected city
Examples:
|country|area|city|
|Angola|Cuanza Norte|Dondo|

Scenario: Verify "All" selection should retrurn all the sections in the webapp
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
When the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
When the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
And the user clicks on the city all link in the navigation bar
Then the user should be able to see the Basic Info for selected city
Then the user should be able to see the Credit Rating for selected city
Then the user should be able to see the Regions for selected city
Then the user should be able to see the Places for selected city
Then the user should be able to see the Entities for selected city
Then the user should be able to see the People for selected city

Examples:
|country|area|city|
|Angola|Cuanza Norte|Dondo|

Scenario: Verify "All" should be selected automatically, if we select all the other options in the navigation bar.
Meta:
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
When the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
When the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
When the user clicks on the city basic info link in the navigation bar
And the user clicks on the city's credit rating link in the navigation bar
And the user clicks on the city regions link in the navigation bar
And the user clicks on the city's places link in the navigation bar
And the user clicks on the city's entity link in the navigation bar
And the user clicks on the city's people link in the navigation bar
Then the user should see all is selected by default in the navigation bar

Examples:
|country|area|city|
|Ecuador|Tungurahua|pelileo|
