Meta:@AreaDemographics @Area

Narrative:
In order to view the area basic info
As a user
I want to cover the requirements mentioned in
JIRA ID - ZEUS-308 - User can view an area's demographics

Scenario: Verify area demographics.
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
When the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
When the user clicks on the area's demographics link in the navigation bar
Then the user should see the area's demographics as:
|TYPE|VALUE|UNIT|DATE|
|Number of Counties|1|mi²|01 Aug 2015|
|Persons per Household|2.65||01 Aug 2015|
|Largest MSA Population|9,729,825||01 Aug 2015|

Examples:
|country|area|
|USA|Illinois|

Scenario:Verify sub area demographics
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
When the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
When the user clicks on the choose a sub-area option
And the user enters the sub-area <subArea> in the type-ahead box
And the user clicks on the sub-area's demographics link in the navigation bar
Then the user should see the sub-area's demographics as:
|TYPE|VALUE|UNIT|DATE|
|Number of Counties|1|mi²|01 Aug 2015|
|Persons per Household|2.65||01 Aug 2015|
|Largest MSA Population|9,729,825||01 Aug 2015|

Examples:
|country|area|subArea|
|USA|Illinois|Cook|

Scenario: Verify the area which have no demographics
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
When the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
When the user clicks on the area's demographics link in the navigation bar
Then the user should not see the area's demographics

Examples:
|country|area|
|ukraine|dnipropetrovsk region|

Scenario:
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
When the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
When the user clicks on the choose a sub-area option
And the user enters the sub-area <subArea> in the type-ahead box
And the user clicks on the sub-area's demographics link in the navigation bar
Then the user should not see the sub-area's demographics

Examples:
|country|area|subArea|
|USA|Connecticut|Fairfield|