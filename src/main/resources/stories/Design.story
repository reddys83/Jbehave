Meta:@Design

Scenario: Verify delete confirmation modal
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
And the user clicks on the update link
And the user clicks on the add new time zone button in the basic info country page
And the user clicks on the select time zone list in the basic info country page
When the user clicks on the delete time zone row button in the basic info country page
Then the user should see the delete row confirmation modal in the country page
When the user clicks on the no button in the delete row confirmation modal in the country page
Then the user should see the newly added time zone row in the basic info country page
When the user clicks on the delete name row button in the basic info country page
When the user clicks on the yes button in the delete row confirmation modal in the country page
Then the user should not see the newly added time zone row in the basic info country page

Examples:
|country|
|Albania|
