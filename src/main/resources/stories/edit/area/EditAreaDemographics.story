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
And the user enters the area <area> in the type-ahead box
And the user clicks on the area's demographics link in the navigation bar
And the user clicks on the area update link
When the user clicks on the add new demographics button in the area page
Then the user should see the area demographics types from lookup DEMOGRAPHIC_METRIC
When the user selects the demographic types <demographicType> in the area page
Then the user should see the demographics units in area page are from lookup UNIT_OF_MEASUREMENT

!-- select unit value and verify UI and Zeus --

Examples:
|country|area|demographicType|
|Angola|Bengo|Area|

Scenario: User updates existing values to 
1 - Verify demographics type other than Area should not display the unit drop down 
2 - Verify entered demographic values are reflected in Zeus and UI

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the area's demographics link in the navigation bar
And the user clicks on the area update link
When the user clicks on the add new demographics button in the country basic info page
When the user selects the demographic types <demographicType> in the area page
Then the user should not see the unit drop down for selected demographic type in area page
When the user enters the demographic value <demographicValue> in the area page
And the user enter demographics day <day> in the demographics area page
And the user enter demographics month <month> in the demographics area page
And the user enter demographics year <year> in the demographics area page
And the user clicks on the save button
!-- verify zeus and UI

Examples:
|country|area|demographicType|demographicValue|day|month|year|
|Algeria|Constantine|Largest County Population|34000000|||2014|
|Algeria|Constantine|Population|34000000|||2014|

Scenario: The metric unit type is null, do not display a unit drop-down for that row
TestCase: demographics type other than Area should not display the unit drop down

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the area's demographics link in the navigation bar
And the user clicks on the area update link
When the user clicks on the add new demographics button in the area page
When the user selects the demographic types <demographicType> in the area page
Then the user should not see the unit drop down for selected demographic type in area page

Examples:
|country|area|demographicType|
|Andorra|Bengo|Largest County Population|

Scenario: User verifies appropriate error messages are displayed for invalid input 
1 - Verify error message enter a year, month/year or day/month/year for newly added holiday
2 - Verify error message "Must be no later than today" if the date is later than today
3 - Verify error message "Required" when type and value fields are null

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the area's demographics link in the navigation bar
And the user clicks on the area update link
When the user clicks on the add new demographics button in the area page
And the user enter demographics day <day> in the demographics area page
And the user enter demographics month <month> in the demographics area page
And the user enter demographics year <year> in the demographics area page
And the user clicks on the save button
Then the user should see the error message Enter a year, month/year or day/month/year. in the demographics area page
Then the user should see the error message at top of page the highlighted fields must be addressed before this update can be saved
When the user clicks on the area update link
When the user enters the demographic date later than today in area page
And the user clicks on the save button
Then the user should see the error message Must be no later than today. in the demographics area page
Then the user should see the error message Required for the type and value fields in area page

Examples:
|country|area|day|month|year|
|Algeria|Constantine|2||2011|
|Egypt|Constantine|abc||abc|

