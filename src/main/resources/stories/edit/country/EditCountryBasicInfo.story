Meta:@EditCountryBasicInfo @Edit @Country

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal
JIRA ID - ZEUS-708 - User can edit country names

Scenario: scenario description
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
And the user clicks on the update link
And the user clicks on the country name type drop-down
Then the user should see the country name types from lookup COUNTRY_NAME_TYPE

When the user clicks on the confirm button
And the user clicks on the save button
And the user clicks on the cancel button
And the user clicks on the cancel no button
And the user clicks on the cancel yes button
And the user clicks on the return button
And the user clicks on the confirm button

Examples:
|country|
|Albania|