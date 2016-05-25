Meta: @EditCityBasicInfo @Edit @City

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal
JIRA ID - ZEUS-969 - User can edit City's Add Info

Scenario: To view the City's 'Basic Info' under the City tab so that a value can be entered for 'Add Info' field
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
When the user clicks on the choose an area option
When the user enters the area <area> in the type-ahead box
When the user clicks on the choose a city option
When the user enters the city <city> in the type-ahead box
And the user clicks on the city basic info link in the navigation bar
And the user clicks on the update link
And the user enters the <addInfoText> in the add info text area
Then the user should be able to verify the values are entered in the add info field
And the user reverts the changes to the document

Examples:
|country|area|city|addInfoText|
|Afghanistan|Badakshan|Panj Shair|Sample text|

Scenario: To update the City's 'Basic Info' by entering a value for 'Add Info' that is different from the current value
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
When the user clicks on the choose an area option
When the user enters the area <area> in the type-ahead box
When the user clicks on the choose a city option
When the user enters the city <city> in the type-ahead box
And the user clicks on the city basic info link in the navigation bar
And the user clicks on the update link
And the user enters the <addInfoText> in the add info text area
When the user clicks on the save button
And the user clicks on the confirm button
When the user clicks on the update link
And the user enters the <addDifferentInfoText> in the add info text area
When the user clicks on the save button
And the user clicks on the confirm button
Then the user should see the successful update message at top of the page
And the user reverts the changes to the document

Examples:
|country|area|city|addInfoText|addDifferentInfoText|
|Afghanistan|Badakshan|Panj Shair|Sample text|This is a different text|

Scenario: To view an error message when the text entered in the 'Add Info' field is beyond 500 unicode characters
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
When the user clicks on the choose an area option
When the user enters the area <area> in the type-ahead box
When the user clicks on the choose a city option
When the user enters the city <city> in the type-ahead box
And the user clicks on the city basic info link in the navigation bar
And the user clicks on the update link
And the user enters values which is beyond 500 unicode characters in the add info field
When the user clicks on the save button
And the user clicks on the confirm button
Then the user should be able to view the error message 'Enter up to 500 valid characters'
And the user reverts the changes to the document

Examples:
|country|area|city|
|Afghanistan|Badakshan|Panj Shair|

Scenario: To view that there is no change in value when the user has entered a value for 'Add Info' that is no different to the current value
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
When the user clicks on the choose an area option
When the user enters the area <area> in the type-ahead box
When the user clicks on the choose a city option
When the user enters the city <city> in the type-ahead box
And the user clicks on the city basic info link in the navigation bar
And the user clicks on the update link
And the user enters the <addInfoText> in the add info text area
When the user clicks on the save button
And the user clicks on the confirm button
When the user clicks on the update link
And the user enters the <addInfoText> in the add info text area
And the user clicks on the save button
And the user clicks on the confirm button
Then the user should see the successful update message at top of the page
And the user reverts the changes to the document

Examples:
|country|area|city|addInfoText|addInfoText|
|Afghanistan|Badakshan|Panj Shair|Sample text|Sample text|