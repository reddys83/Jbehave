Meta: @EditAreaBasicInfo @Edit @Area @AllStories

Narrative:
In order to view and edit the area page
As a user
I want to cover the requirements mentioned in

JIRA ID - ZEUS-1042 - User can edit Area's Demographics

Scenario: user verifies area's demographics 
1- The demographic type drop-down lists values should be from DEMORGAPHIC_METRIC look up
2- The demographic unit drop-down lists values should be from UNIT_OF_MEASUREMENT for demographic type 'area'

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user clicks on the area's demographics link in the navigation bar
When the user clicks on the area basic info link in the navigation bar
And the user clicks on the area update link
When the user clicks on the add new demographics button in the area page
Then the user should see the area demographics types from lookup DEMOGRAPHIC_METRIC
When the user selects the demographic types <demographicType> in the area page
Then the user should see the demographics units in area page are from lookup UNIT_OF_MEASUREMENT

Examples:
|country|area|demographicType|
|Angola|Constantine|Area|

Scenario: The metric unit type is null, do not display a unit drop-down for that row
TestCase: demographics type other than Area should not display the unit drop down

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user clicks on the area's demographics link in the navigation bar
When the user clicks on the area basic info link in the navigation bar
And the user clicks on the area update link
When the user clicks on the add new demographics button in the area page
When the user selects the demographic types <demographicType> in the area page
Then the user should not see the unit drop down for selected demographic type in area page

Examples:
|country|area|demographicType|
|Andorra|Constantine|Largest County Population|

Scenario: User should see the error message "Must be no later than today" if the date is later than today
User should see the required error message if the type and value fields are null.
Testcase: Error message  - Must be no later than today
TestCase: Error message - Required

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user clicks on the area's demographics link in the navigation bar
When the user clicks on the area basic info link in the navigation bar
And the user clicks on the area update link
When the user clicks on the add new demographics button in the area page
And the user enters the demographic date later than today
And the user clicks on the save button
Then the user should see the error 'Must be no later than today.' for demographics date
Then the user should see the error message required for the type and value fields

Examples:
|country|area|
|Algeria|Constantine|

Scenario: User should see the required error message if the type and value fields are null.
Testcase: Confirmation modal to delete the row in demographich country basic info.

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user clicks on the area's demographics link in the navigation bar
When the user clicks on the area basic info link in the navigation bar
And the user clicks on the area update link
When the user clicks on the add new demographics button in the area page
And the user clicks on delete country demographics option
Then the user should see the delete row confirmation modal in the area page

Examples:
|country|area|
|Algeria|Constantine|

Scenario: Verify error message enter a year, month/year or day/month/year for newly added holiday

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user clicks on the area's demographics link in the navigation bar
When the user clicks on the area basic info link in the navigation bar
And the user clicks on the area update link
When the user clicks on the add new demographics button in the area page
And the user enter demographics day <day> in the demographics area page
And the user enter demographics month <month> in the demographics area page
And the user enter demographics year <year> in the demographics area page
And the user clicks on the save button
Then the user should see the error message Enter a year, month/year or day/month/year. in the demographics area page
Then the user should see the error message at top of page the highlighted fields must be addressed before this update can be saved

Examples:
|country|area|day|month|year|
|Algeria|Constantine|2||2011|
|Egypt|Constantine|abc||abc|

Scenario: User shoud see the confirmation modal for valid input and save

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user clicks on the area's demographics link in the navigation bar
When the user clicks on the area basic info link in the navigation bar
And the user clicks on the area update link
When the user clicks on the add new demographics button in the country basic info page
When the user selects the demographic types <demographicType> in the area page
And the user enter the demographic value <demographicValue> in the country basic info page 
And the user enter demographics day <day> in the demographics area page
And the user enter demographics month <month> in the demographics area page
And the user enter demographics year <year> in the demographics area page
And the user clicks on the save button
Then the user should see the save confirmation modal

Examples:
|country|area|demographicType|demographicValue|day|month|year|
|Algeria|Constantine|Largest County Population|34000000|||2014|