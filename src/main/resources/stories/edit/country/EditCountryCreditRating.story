Meta:@EditCountryRating

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal
JIRA ID - ZEUS-446 - User can edit country credit ratings

Scenario: Editting country credit ratings
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
And the user clicks on the update link
When the user clicks on the country credit rating link in the navigation bar
Then the user enters applied year <appliedyear>
And the user enters confirmed year <confirmedyear>
When the user clicks on the save button
Then the user should see the error message at top of page the highlighted fields must be addressed before this update can be saved
And the user should see error next to applied year
And the user should see error next to confirmed year
And the user should see required error when there is an empty row
When the user clicks on add row button verify need row added
Then the user clicks on remove button to delete row
Then the user should see the delete row confirmation modal in the country page
When the user clicks on the no button in the delete row confirmation modal in the country page
Then the user should see the newly added name row on the credit rating page
Then the user clicks on remove button to delete row
When the user clicks on the yes button in the delete row confirmation modal in the country page
Then the user should not see the newly added name row on credit rating page

Examples:
|country|appliedyear|confirmedyear|
|Afghanistan|2019|2019|


Scenario: Verifying Value field can only accept uptill 5 characters
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
And the user clicks on the update link
When the user clicks on the country credit rating link in the navigation bar
Then the user enters value <value>
When the user clicks on the save button
Then the user should see the error message enter upto 5 valid characters

Examples:
|country|value|
|Afghanistan|abcdef|

Scenario: Verifying Verify error message enter a year, month/year or day/month/year
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
Then the user enters data in applied year <day> <month> <year>
When the user clicks on the save button
Then the user should see the error message at top of page the highlighted fields must be addressed before this update can be saved
And the user verifies error message Enter a year, month/year or day/month/year

Examples:
|country|day|month|year|
|Afghanistan|15| | |
|Afghanistan|15|Jan| |
|Afghanistan|15| |2016|
|Afghanistan| |Jan| |
