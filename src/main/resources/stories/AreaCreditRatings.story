Meta:@AreaCreditRatings @Area

Narrative:
In order to view and edit the currencies
As a user
I want to cover the requirements mentioned in
JIRA ID - ZEUS-303 - User can view an area's credit rating

Scenario: Verify area's credit rating.
Meta:@verifyBuild
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
When the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
When the user clicks on the area's credit rating link in the navigation bar
Then the user should see the area's credit ratings as:
|NAME|TYPE|VALUE|Date APPLIED|DATE CONFIRMED|
|Fitch|Long Term Sovereign Debt Rating|B|01 Jan 1990|04 Jan 1991|
|Standard & Poors|Long Term Sovereign Debt Rating|A-|01 Jan 1990|04 Jan 1991|
||Chicagos Terrible Credit Rating|F+|||


Examples:
|country|area|
|USA|Illinois|

Scenario: Verify sub-area's credit rating.
Meta:
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
When the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
When the user clicks on the choose a sub-area option
And the user enters the sub-area <subArea> in the type-ahead box
When the user clicks on the sub-area's credit rating link in the navigation bar
Then the user should see the sub-area's credit ratings as:
|NAME|TYPE|VALUE|Date APPLIED|DATE CONFIRMED|
|Moodys|Long Term TEST Rating|ZZZ|01 Jan 1990|04 Jan 1991|

Examples:
|country|area|subArea|
|USA|Illinois|Cook|

Scenario: Verify no area's credit rating.
Meta:
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
When the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
When the user clicks on the area's credit rating link in the navigation bar
Then the user should not see the area's credit ratings

Examples:
|country|area|
|USA|Colorado|

Scenario: Verify no sub-area's credit rating.
Meta:@verifyBuild
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
When the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
When the user clicks on the choose a sub-area option
And the user enters the sub-area <subArea> in the type-ahead box
When the user clicks on the sub-area's credit rating link in the navigation bar
Then the user should not see the sub-area's credit ratings

Examples:
|country|area|subArea|
|USA|Colorado|Adams|