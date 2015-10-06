Meta:@AreaMultipleSections @Area

Narrative:
In order to view and edit the currencies
As a user
I want to cover the requirements mentioned in
JIRA ID - ZEUS-335 - User can view all area info

Scenario: Verify area and sub-area's default section.
Meta:
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
When the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
Then the user should see the default area page and display all info
And the user should see the basic info for selected area
And the user should see the demographics for selected area
And the user should see the credit ratings for selected area
And the user should see the places for selected area
And the user should see the people for selected area
When the user clicks on the choose a sub-area option
And the user enters the sub-area <subArea> in the type-ahead box
Then the user should see the default sub-area page and display all info
And the user should see the basic info for selected sub-area
And the user should see the credit ratings for selected sub-area
And the user should see the demographics for selected sub-area
And the user should see the places for selected sub-area
And the user should see the people for selected sub-area

Examples:
|country|area|subArea|
|USA|Illinois|Cook|

Scenario: Verify "All" is highlighted in sidebar, other previously selected sections are no longer highlighted.
Meta:
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
When the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
When the user clicks on the area basic info link in the navigation bar
When the user clicks on the area's credit rating link in the navigation bar
When the user clicks on the area's demographics link in the navigation bar
When the user clicks on the area's people link in the navigation bar
When the user clicks on the area's places link in the navigation bar
When the user clicks on the area's alternative regions link in the navigation bar
Then the user should see the default area page and display all info

Examples:
|country|area|
|USA|Illinois|
