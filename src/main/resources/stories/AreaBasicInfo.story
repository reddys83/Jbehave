Meta:@AreaBasicInfo @Area

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
And the user enters the area <area> in the type-ahead box
When the user clicks on the area basic info link in the navigation bar
Then the user should see the basic info for selected area

And the user should see the area's names as:
|TYPE|VALUE|
|Full Name|Illinois|
|Display Name|IL|

And the user should see the area's identifiers as:
|TYPE|VALUE|STATUS|
|typeA|coolIdentifier 24601|Active|
|typeB|ASDF|Inactive|

And the user should see the area's time zones summary as +2 hour

And the user should see the area's time zones as:
|Summary||
|UTC|+02:00|
|UTC|+02:30|

And the user should see the Status of an area as Active
And the user should see the Began Date of an area as 13 Jul 1922
And the user should see the End Date of an area as 21 May 2006
And the user should see the Type of an area as Area
And the user should see the Country of an area as USA
And the user should see the Area Parent of an area as Atchison
And the user should see the area's replace by as California, Kansas
And the user should see the Use in Address of an area as True
And the user should see the Interest Rate Limit of an area as 92%
And the user should see the ISO2 of an area as IL
And the user should see the Add Info of an area as ILLINOIS: Census area dissolved in 2100


Examples:
|country|area|
|USA|Illinois|

Scenario: Verify Area basic info with have no link to another area
Meta:@runThis
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
When the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the area basic info link in the navigation bar
Then the user should not see the area's area link

Examples:
|country|area|
|Albania|Fier|


