Meta:@AreaRelatedPeople @Area @View @AllStories

Narrative:
In order to view and edit the people information
As a user
I want to cover the requirements mentioned in
JIRA ID - ZEUS-307 - User can view a area's related people

Scenario: Verify related people information for area.
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
When the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
When the user clicks on the area's people link in the navigation bar
Then the user should see the area's people as:
|TYPE|PERSON|
|Financial Institution Board member|Steven Bangert|
|President, Cheif executor|Yasuo Ueno|

Examples:
|country|area|
|USA|Illinois|

Scenario: Verify the area which have no people.
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
When the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
When the user clicks on the area's people link in the navigation bar
Then the user should not see the area's people

Examples:
|country|area|
|ukraine|dnipropetrovsk region|


Scenario: Verify related people information for sub-area.
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
When the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a sub-area option
And the user enters the sub-area <subArea> in the type-ahead box
When the user clicks on the sub-area's people link in the navigation bar

Then the user should see the sub-area's people as:
|TYPE|PERSON|
|Financial Institution Board member|Steven Bangert|
|President, Cheif executor|Yasuo Ueno|

Examples:
|country|area|subArea|
|USA|Illinois|Cook|

Scenario: Verify the sub area which have no people
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
When the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a sub-area option
And the user enters the sub-area <subArea> in the type-ahead box
When the user clicks on the sub-area's people link in the navigation bar
Then the user should not see the sub-area's people

Examples:
|country|area|subArea|
|Bangladesh|Chittagong|Chittagong|