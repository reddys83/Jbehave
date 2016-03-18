Meta:@Design

Scenario: Verify delete confirmation for IBAN
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
And the user clicks on the update link
And the user clicks on the country payments link in the navigation bar
And the user clicks on the add new iban button in the payments country page
When the user clicks on the delete iban row button in the basic info country page
Then the user should see the delete row confirmation modal in the country page
When the user clicks on the no button in the delete row confirmation modal in the country page
Then the user should see the newly added iban row in the holiday country page
When the user clicks on the delete iban row button in the basic info country page
When the user clicks on the yes button in the delete row confirmation modal in the country page
Then the user should not see the newly added iban row in the holiday country page

Examples:
|country|
|Afghanistan|

Scenario: Verify delete confirmation for routing code
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
And the user clicks on the update link
And the user clicks on the country payments link in the navigation bar
And the user clicks on the add new routing code button in the payments country page
When the user clicks on the delete routing code row button in the basic info country page
Then the user should see the delete row confirmation modal in the country page
When the user clicks on the no button in the delete row confirmation modal in the country page
Then the user should see the newly added routing code row in the holiday country page
When the user clicks on the delete routing code row button in the basic info country page
When the user clicks on the yes button in the delete row confirmation modal in the country page
Then the user should not see the newly added routing code row in the holiday country page

Examples:
|country|
|Afghanistan|