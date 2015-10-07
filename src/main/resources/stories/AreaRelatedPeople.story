Meta:@AreaRelatedPeople @Area

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

