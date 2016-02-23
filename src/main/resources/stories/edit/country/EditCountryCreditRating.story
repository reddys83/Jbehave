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
