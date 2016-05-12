Meta:@Design

Scenario: Verify country entities data.
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
When the user clicks on the country entity link in the navigation bar
Then the user should see the country's entities from trusted document

Examples:
|country|
|Bermuda|
