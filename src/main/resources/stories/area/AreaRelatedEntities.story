Meta:@AreaRelatedEntities @Area

Narrative:
In order to view and edit the currencies
As a user
I want to cover the requirements mentioned in
JIRA ID - ZEUS-306 - User can view an area's related entities

Scenario: Verify related entities for area.
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
When the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
When the user clicks on the area's entity link in the navigation bar
Then the user should see the area's entities as:
|TYPE|ENTITY|DETAILS|
|Government|Illinois Department of Employment Security|City Government|
|Government Type|Illinois Department of Employment Security|City Government, City Government|

Examples:
|country|area|
|USA|Illinois|

Scenario: Verify related entities for sub-area.
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
When the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
When the user clicks on the choose a sub-area option
And the user enters the sub-area <subArea> in the type-ahead box
When the user clicks on the sub-area's entity link in the navigation bar
Then the user should see the sub-area's entities as:
|TYPE|ENTITY|DETAILS|
|Government|Illinois Department of Employment Security|City Government|
|Government Type|Illinois Department of Employment Security|City Government, City Government|

Examples:
|country|area|subArea|
|USA|Illinois|Cook|

Scenario: Verify no related entities for area.
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
When the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
When the user clicks on the area's entity link in the navigation bar
Then the user should not see the area's entities

Examples:
|country|area|
|USA|Colorado|

Scenario: Verify no related entities for sub-area.
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
When the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
When the user clicks on the choose a sub-area option
And the user enters the sub-area <subArea> in the type-ahead box
When the user clicks on the area's entity link in the navigation bar
Then the user should not see the area's entities

Examples:
|country|area|subArea|
|USA|Colorado|Adams|