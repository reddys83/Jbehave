Meta:@Design
Scenario: User deletes all rows of banking hours and verify if the rows are deleted from Zeus document
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
And the user clicks on the update link
And the user get the document with get Id for country with the name as South Africa from the database
And the user deletes the existing banking hours rows
And the user clicks on the save button
Then the user should see the save confirmation modal
And the user should see the below summary changes in confirmation modal
|Summary|
|Basic Info / Banking Hours|
When the user clicks on the confirm button
Then the user should not see the banking hours rows
Then the user should see the edits to country banking hrs in zeus document
And the user reverts the changes to the document

Examples:
|country|
|South Africa|
