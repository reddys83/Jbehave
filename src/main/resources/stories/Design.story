Meta:@Design

Scenario: Verify Area related places.
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
When the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
When the user clicks on the area's places link in the navigation bar
Then the user should see the area's places as:
|TYPE|PLACE|DETAILS|
|Area, Test Data|Nassau||
|Federal Reserve Bank Region|South Valley Stream|Test Data, Test Data|
|Country|USA|Test Data, Test Data|

Examples:
|country|area|
|USA|Illinois|