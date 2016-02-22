Meta:@Design

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
