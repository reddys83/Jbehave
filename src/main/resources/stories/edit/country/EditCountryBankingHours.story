Meta:@EditCountryBankingHours @Edit @Country @AllStories

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal
JIRA ID - ZEUS-711 - User can edit country banking hours
JIRA ID - ZEUS-441 - User can save edits to country

Scenario: When the user edit the country banking hours and verify the day drop down and hours drop down
TestCase: Where the country which doesn't have any day info
Meta:
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
And the user clicks on the update link
And the user clicks on the add country banking hours option
Then the user should see a new row with day drop-down list with all days and hours with values in half hour increments

Examples:
|country|
|Algeria|

Scenario: When the user edit the country banking hours and verify the day drop down
TestCase: The country which have some day info, Then the drop down should exclude the day which is already present
Meta:
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
And the user clicks on the update link
And the user clicks on the add country banking hours option
Then the user should see a new row with day drop-down list with all days except the day which is already existing and hours with values in half hour increments

Examples:
|country|
|Afghanistan|

Scenario: Please confirm - would you like to delete this row?
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
And the user clicks on the update link
And the user clicks on the add country banking hours option
And the user clicks on delete country banking hours option
Then the user should see the delete row confirmation modal in the country page

Examples:
|country|
|Afghanistan|

Scenario: Save country banking hours
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
And the user clicks on the update link
And the user get the document with get Id for country with the name as Bosnia-Herzegovina from the database
Then the user reverts the changes to the document
When the user clicks on the add country banking hours option
And the user selects country banking hours day as <bankingHrsDay> in the country page
And the user selects country banking hours start time as <bankingHrsStartTime> in the country page
And the user selects country banking hours end time as <bankingHrsEndTime> in the country page
And the user clicks on the save button
And the user clicks on the confirm button
Then the user should see the edits to country banking hrs in zeus document
And the user reverts the changes to the document

Examples:
|country|bankingHrsDay|bankingHrsStartTime|bankingHrsEndTime|
|Bosnia-Herzegovina|Wednesday|00:00|23:30|


Scenario: User deletes all rows of banking hours and verify if the rows are deleted from Zeus document
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
And the user clicks on the update link
And the user get the document with get Id for country with the name as Bosnia-Herzegovina from the database
And the user deletes the existing banking hours rows
And the user clicks on the save button
Then the user should see the save confirmation modal
When the user clicks on the confirm button
Then the user should not see the banking hours rows
Then the user should see the edits to country banking hrs in zeus document
And the user reverts the changes to the document

Examples:
|country|
|Bosnia-Herzegovina|








