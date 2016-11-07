Meta:@Design




Scenario: Verify Area list
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
When the user clicks on the choose an area option
Then the user should see the list of all existing area for the selected country by full name

Examples:
|country|
|USA|
