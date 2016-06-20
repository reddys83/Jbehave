Meta: @EditCityCreditRating @Edit @City @AllStories

Narrative:
In order to view and edit the city page
As a user
I want to cover the requirements mentioned in

JIRA ID - ZEUS-973 - User can view City Credit Rating


Scenario: Verifying the credit rating agencies are from LookUp 'CREDIT_RATING_AGENCY'
Meta: @singleScenario
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
When the user clicks on the city credit rating link in the navigation bar
And the user clicks on the update link
When the user clicks on add new credit rating button in the credit rating city page
And the user clicks on the Agency names drop-down in the basicinfo city page
Then the user should see the city Agency names from look up CREDIT_RATING_AGENCY
When the user clicks on the Agency types drop-down in the basicinfo city page
Then the user should see the city Agency types from look up CREDIT_RATING_TYPE

Examples:
|country|area|city|
|USA|Alabama|Alexander City|

Scenario: User has selected to add a credit rating and set values for all fields in the row except either the 'Agency' field or the 'Type' field 
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
When the user clicks on the city credit rating link in the navigation bar
And the user clicks on the update link
When the user clicks on add new credit rating button in the credit rating city page

Examples:
|country|area|city|
|USA|Alabama|Alexander City|

Scenario: Verifying Verify error message enter a year, month/year or day/month/year for applied date
1. only day
2. only day and month
3. only day and year
4. only month

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
When the user clicks on the city credit rating link in the navigation bar
And the user clicks on the update link
When the user clicks on add new credit rating button in the credit rating city page
And the user enters applied date day <appliedDay> in the credit rating city page
And the user selects applied date month <appliedMonth> in the credit rating city page
And the user enters applied date year <appliedYear> in the credit rating city page
When the user clicks on the save button
Then the user should see the error message at top of page the highlighted fields must be addressed before this update can be saved
And the user should see the error message enter a year, month/year or day/month/year for applied date in the credit rating city page

Examples:
|country|area|city|appliedDay|appliedMonth|appliedYear|
|USA|Alabama|Alexander City|15|||
|USA|Alabama|Alexander City|15|Jan||
|USA|Alabama|Alexander City|15||2016|
|USA|Alabama|Alexander City||Jan||
|USA|Alabama|Alexander City|abc||abc|

Scenario: Verifying Verify error message enter a year, month/year or day/month/year for confirmed date
1. only day
2. only day and month
3. only day and year
4. only month
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
When the user clicks on the city credit rating link in the navigation bar
And the user clicks on the update link
When the user clicks on add new credit rating button in the credit rating city page
And the user enters confirmed date day <confirmedDay> in the credit rating city page
And the user selects confirmed date month <confirmedMonth> in the credit rating city page
And the user enters confirmed date year <confirmedYear> in the credit rating city page
When the user clicks on the save button
Then the user should see the error message at top of page the highlighted fields must be addressed before this update can be saved
And the user should see the error message enter a year, month/year or day/month/year for confirmed date in the credit rating country page

Examples:
|country|area|city|confirmedDay|confirmedMonth|confirmedYear|
|USA|Alabama|Alexander City|15|||
|USA|Alabama|Alexander City|15|Jan||
|USA|Alabama|Alexander City|15||2016|
|USA|Alabama|Alexander City||Jan||
