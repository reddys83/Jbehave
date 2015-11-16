Meta:@CityCreditRatings @City

Narrative:
In order to view and edit the cities
As a user
I want to cover the requirements mentioned in
JIRA ID - ZEUS-326 - User can view an city's credit rating

Scenario: Verify city's credit rating.
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
When the user clicks on the city's credit rating link in the navigation bar

Then the user should see the city's credit ratings as:
|NAME|TYPE|VALUE|Date APPLIED|DATE CONFIRMED|
|Fitch|Long Term Sovereign Debt Rating|B|01 Jan 1990|04 Jan 1991|
|Standard & Poors|Long Term Sovereign Debt Rating|A-|01 Jan 1990|04 Jan 1991|
||Chicagos Terrible Credit Rating|F+|||


Examples:
|country|area|city|
|USA|Illinois|Chicago|

Scenario: Verify no city's credit rating.
Meta:
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
When the user clicks on the choose an area option
When the user enters the area <area> in the type-ahead box
When the user clicks on the choose a city option
When the user enters the city <city> in the type-ahead box
When the user clicks on the city's credit rating link in the navigation bar

Then the user should not see the city's credit ratings

Examples:
|country|area|city|
|Turkey|Adana|Barajyolu|
