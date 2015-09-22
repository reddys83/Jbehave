Meta:@AreaBasicInfo

Narrative:
In order to view the area basic info
As a user
I want to cover the requirements mentioned in
JIRA ID - ZEUS-187 - User can view basic area info


Scenario: Verify Area basic info.
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
When the user clicks on the choose an area option
And the user enters the area<area> in the type-ahead box
When the user clicks on the area basic info link in the navigation bar
Then the user should see the basic info for selected area

And the user should see the area's names as:
|TYPE|VALUE|
|Display Name||
|Full Name||

And the user should see the area's identifiers as:
|TYPE|VALUE|STATUS|
||||
||||

And the user should see the area's time zones as:
|Summary||
|UTC|+02|
|UTC|+03|

And the user should see the area's status as
And the user should see the area's began date as
And the user should see the area's end date as
And the user should see the area's type as
And the user should see the area's country as
And the user should see the area's area as
And the user should see the area's  repalced by as
And the user should see the area's use in address as
And the user should see the area's interest rate limit as


Examples:
|country|area|
|USA|Illinois|

Scenario: Verify Area basic info with have no link to another area
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
When the user clicks on the choose an area option
And the user enters the area<area> in the type-ahead box
And the user clicks on the area basic info link in the navigation bar
Then the user should not see the area's area link

Examples:
|country|area|
|||
