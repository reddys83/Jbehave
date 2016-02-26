Meta:@EditCountryDemographics @Edit @Country

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal
JIRA ID - ZEUS-248 - User can edit country demographics

Scenario: The demographic type drop-down lists values should be from DEMORGAPHIC_METRIC
Meta:
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
And the user clicks on the update link
When the user clicks on the add new demographics button in the country basic info page
Then the user should see the country demographics types from lookup DEMOGRAPHIC_METRIC

Examples:
|country|
|Algeria|

Scenario: The metric unit type is null, Do not display a unit drop-down for that row
TestCase: demographics type other than Area should not display the unit drop down
Meta:
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
And the user clicks on the update link
When the user clicks on the add new demographics button in the country basic info page
And the user selects the demographic types <demographicType> in the country basic info page
Then the user should not see the unit drop down for selected demographic type

Examples:
|country|demographicType|
|Andorra|Largest County Population|

Scenario: The metric's unit type is not null then display the values from UNIT_OF_MEASUREMENT
TestCase: Demographic type as Area should have unit drop down
Meta:
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
And the user clicks on the update link
When the user clicks on the add new demographics button in the country basic info page
And the user selects the demographic types <demographicType> in the country basic info page
Then the user should see the unit drop down for selected demographic type
And the user should see the demographics units are from lookup UNIT_OF_MEASUREMENT

Examples:
|country|demographicType|
|Algeria|Area|

Scenario: User should see the error message "Must be no later than today" if the date is later than today
User should see the required error message if the type and value fields are null.
Testcase: Error message  - Must be no later than today
TestCase: Error message - Required
Meta:
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
And the user clicks on the update link
When the user clicks on the add new demographics button in the country basic info page
And the user enters the demographic date later than today
And the user clicks on the save button
Then the user should see the error 'Must be no later than today.' for demographics date
Then the user should see the error message required for the type and value fields

Examples:
|country|
|Algeria|

Scenario: User should see the required error message if the type and value fields are null.
Testcase: Confirmation modal to delete the row in demographich country basic info.
Meta:
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
And the user clicks on the update link
When the user clicks on the add new demographics button in the country basic info page
And the user clicks on delete country demographics option
Then the user should see the delete row confirmation modal in the country page

Examples:
|country|
|Algeria|

Scenario: Verify error message enter a year, month/year or day/month/year for newly added holiday
Meta:
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
And the user clicks on the update link
When the user clicks on the add new demographics button in the country basic info page
And the user enter demographics day <day> in the demographics country page
And the user enter demographics month <month> in the demographics country page
And the user enter demographics year <year> in the demographics country page
And the user clicks on the save button
Then the user should see the error message enter a day/month/year in the holidays country page
And the user should see the error message at top of page the highlighted fields must be addressed before this update can be saved

Examples:
|country|day|month|year|
|Algeria|2||2011|

Scenario: User shoud see the confirmation modal for valid input and save
Meta:
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
And the user clicks on the update link
When the user clicks on the add new demographics button in the country basic info page
And the user selects the demographic types <demographicType> in the country basic info page
And the user enter the demographic value <demographicValue> in the country basic info page
And the user enter demographics day <day> in the demographics country page
And the user enter demographics month <month> in the demographics country page
And the user enter demographics year <year> in the demographics country page
And the user clicks on the save button
Then the user should see the save confirmation modal

Examples:
|country|demographicType|demographicValue|day|month|year|
|Algeria|Largest County Population|34000000|||2014|