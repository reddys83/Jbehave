Meta:@AreaAlternativeRegions @Area

Narrative:
In order to view and edit the currencies
As a user
I want to cover the requirements mentioned in
JIRA ID - ZEUS-304 - User can view an area's alternative regions

Scenario: Verify area's alternative regions.
Meta:@verifyBuild
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
When the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
When the user clicks on the area's alternative regions link in the navigation bar
Then the user should see the area's alternative regions as:
|TYPE|VALUE|
|Federal Reserve Bank Region|San Francisco 12|
|Federal Home Loan Bank Region|Seattle 12|
|My random sweet region|Sugar 1234|


Examples:
|country|area|
|USA|Illinois|

Scenario: Verify sub-area's alternative regions.
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
When the user clicks on the sub-area's alternative regions link in the navigation bar
Then the user should see the sub-area's alternative regions as:
|TYPE|VALUE|
|Federal Reserve Bank Region|San Francisco 12|
|Federal Home Loan Bank Region|Seattle 12|
|My random sweet region|Sugar 1234|

Examples:
|country|area|subArea|
|USA|Illinois|Cook|

Scenario: Verify no area's alternative regions.
Meta:
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
When the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
When the user clicks on the area's alternative regions link in the navigation bar
Then the user should not see the area's alternative regions

Examples:
|country|area|
|USA|Colorado|

Scenario: Verify no sub-area's alternative regions.
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
When the user clicks on the sub-area's alternative regions link in the navigation bar
Then the user should not see the sub-area's alternative regions

Examples:
|country|area|subArea|
|USA|Colorado|Adams|