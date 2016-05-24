Meta:@EditCountryAlternativeRegion @Edit @Country @AllStories

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal
JIRA ID - ZEUS-444 - User can edit country alternative regions

Scenario: The alternative region type dropdown should show values from COUNTRY_ALTERNATIVE_REGION lookup and previously selected types should not show up
Meta:
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
And the user clicks on the update link
When the user clicks on the add new regions button in the country basic info page
Then the user should see the country regions types from lookup COUNTRY_ALTERNATIVE_REGION excluding which are already existing

Examples:
|country|
|Angola|

Scenario: The values for trading region should display from TRADING_REGION look up table
Meta:
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
And the user clicks on the update link
When the user clicks the value drop down for region type trading region
Then the user should see the drop down items from TRADING_REGION look up table

Examples:
|country|
|Angola|

Scenario: The values for continent should display from CONTINENT look up table
Meta:
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
And the user clicks on the update link
When the user clicks on the add new regions button in the country basic info page
And the user selects region type as <regionType> in the drop down
When the user clicks the value drop down for region type continent
Then the user should see the drop down items from CONTINENT look up table

Examples:
|country|regionType|
|Angola|Continent|

Scenario: The values for sepa should display from SEPA_STATUS
Meta:
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
And the user clicks on the update link
When the user clicks on the add new regions button in the country basic info page
And the user selects region type as <regionType> in the drop down
Then the user should see the values from SEPA_STATUS look up table

Examples:
|country|regionType|
|Angola|SEPA|

Scenario: The user should see the save confirmation upon valid inputs
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
And the user clicks on the update link
When the user clicks on the add new regions button in the country basic info page
And the user selects region type as <regionType> in the drop down
And the user selects region value as <regionValue> in the drop down
And the user clicks on the save button
Then the user should see the save confirmation modal


Examples:
|country|regionType|regionValue|
|Netherlands|Continent|Asia|

Scenario:The user should see reguired message when user save with empty region values
Meta:
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
And the user clicks on the update link
When the user clicks on the add new regions button in the country basic info page
And the user clicks on the save button
Then the user should see the error message required for the region type field
And the user should see the error message at top of page the highlighted fields must be addressed before this update can be saved

Examples:
|country|
|Mayotte Island|

Scenario:The user should see reguired message when user save with empty region values
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
And the user clicks on the update link
When the user clicks on the add new regions button in the country basic info page
And the user selects region type as <regionType> in the drop down
And the user clicks on the save button
Then the user should see the error message required for the region value field
And the user should see the error message at top of page the highlighted fields must be addressed before this update can be saved

Examples:
|country|regionType|
|Netherlands|Continent|

Scenario: The user should see the confirmation modal to delete region row message Please confirm - would you like to delete this row?
Meta:
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
And the user clicks on the update link
When the user clicks on the add new regions button in the country basic info page
And the user clicks on delete country region type
Then the user should see the delete row confirmation modal in the country page

Examples:
|country|
|Mayotte Island|

