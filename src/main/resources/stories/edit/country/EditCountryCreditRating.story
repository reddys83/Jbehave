Meta:@EditCountryRating @Edit @Country

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal
JIRA ID - ZEUS-446 - User can edit country credit ratings

Scenario: Verify must not be later than today error message
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
And the user clicks on the update link
When the user clicks on the country credit rating link in the navigation bar
And the user enters applied date year <appliedYear> in the credit rating country page
And the user enters confirmed date year <confirmedYear> in the credit rating country page
When the user clicks on the save button
Then the user should see the error message at top of page the highlighted fields must be addressed before this update can be saved
And the user should see the error message must be no later than today for applied date in the credit rating country page
And the user should see the error message must be no later than today for confirmed date in the credit rating country page

Examples:
|country|appliedYear|confirmedYear|
|Afghanistan|2019|2019|

Scenario: Verify required error message and delete confirmation
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
And the user clicks on the update link
When the user clicks on the country credit rating link in the navigation bar
When the user clicks on add new credit rating button in the credit rating country page
And the user clicks on the save button
Then the user should see required error message for the credit rating confirmed date in the credit rating country page
Then the user clicks on the delete credit rating row button in the basic info country page
Then the user should see the delete row confirmation modal in the country page
When the user clicks on the no button in the delete row confirmation modal in the country page
Then the user should see the newly added credit rating row in the credit rating country page
Then the user clicks on the delete credit rating row button in the basic info country page
When the user clicks on the yes button in the delete row confirmation modal in the country page
Then the user should not see the newly added credit rating row in the credit rating country page

Examples:
|country|appliedYear|confirmedYear|
|Afghanistan|2019|2019|

Scenario: Verifying Value field can only accept uptill 5 characters
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
And the user clicks on the update link
When the user clicks on the country credit rating link in the navigation bar
Then the user enters credit rating value <value> in the credit rating country page
When the user clicks on the save button
Then the user should see the error message enter upto 5 valid characters in the credit rating country page

Examples:
|country|value|
|Afghanistan|abcdef|

Scenario: Verifying Verify error message enter a year, month/year or day/month/year for applied date
1. only day
2. only day and month
3. only day and year
4. only month
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
And the user clicks on the update link
When the user clicks on the country credit rating link in the navigation bar
And the user enters applied date day <appliedDay> in the credit rating country page
And the user selects applied date month <appliedMonth> in the credit rating country page
And the user enters applied date year <appliedYear> in the credit rating country page
When the user clicks on the save button
Then the user should see the error message at top of page the highlighted fields must be addressed before this update can be saved
And the user should see the error message enter a year, month/year or day/month/year for applied date in the credit rating country page

Examples:
|country|appliedDay|appliedMonth|appliedYear|
|Afghanistan|15|||
|Afghanistan|15|Jan||
|Afghanistan|15||2016|
|Afghanistan||Jan||

Scenario: Verifying Verify error message enter a year, month/year or day/month/year for confirmed date
1. only day
2. only day and month
3. only day and year
4. only month
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
And the user clicks on the update link
When the user clicks on the country credit rating link in the navigation bar
And the user enters confirmed date day <confirmedDay> in the credit rating country page
And the user selects confirmed date month <confirmedMonth> in the credit rating country page
And the user enters confirmed date year <confirmedYear> in the credit rating country page
When the user clicks on the save button
Then the user should see the error message at top of page the highlighted fields must be addressed before this update can be saved
And the user should see the error message enter a year, month/year or day/month/year for confirmed date in the credit rating country page

Examples:
|country|confirmedDay|confirmedMonth|confirmedYear|
|Afghanistan|15|||
|Afghanistan|15|Jan||
|Afghanistan|15||2016|
|Afghanistan||Jan||