Meta: @EditCityBasicInfo @Edit @City

Narrative:
In order to view and edit the city page
As a user
I want to cover the requirements mentioned in

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
And the user clicks on the city update link
Then the user should see the <addInfoText> value same as in trusted document
When the user gets the document with get document id for city with the <city> from the database
And the user enters the <addInfoText> in the add info text area
When the user clicks on the save button in city page
And the user clicks on the confirm button
Then the user should be able to verify the values are entered in the add info field
Then the user should see the <addInfoText> value as in zeus document
Then the user reverts the changes to the document

Examples:
|country|area|city|addInfoText|
|Afghanistan|Badakshan|Panj Shair|Sample text|

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
And the user clicks on the city update link
Then the user should see the addInfoText value same as in trusted document
When the user gets the document with get document id for city with the <city> from the database
And the user enters the <addInfoText> in the add info text area
When the user clicks on the save button in city page
And the user clicks on the confirm button
Then the user should be able to verify the values are entered in the add info field
Then the user should see the <addInfoText> value as in zeus document
Then the user reverts the changes to the document

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
And the user clicks on the city update link
When the user enters the <addInfoText> in the add info text area
When the user clicks on the save button in city page
And the user clicks on the confirm button
Then the user should be able to verify the values are entered in the add info field
Then the user should see the successful update message at top of the page
Then the user should see the <addInfoText> value as in zeus document

Examples:
|country|area|city|addInfoText|
|Afghanistan|Badakshan|Panj Shair|This is a different text|

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
And the user clicks on the city update link
When the user enters the <addInfoText> in the add info text area
When the user clicks on the save button in city page
And the user clicks on the confirm button
Then the user should be able to verify the values are entered in the add info field
Then the user should see the successful update message at top of the page
Then the user should see the <addInfoText> value as in zeus document


Examples:
|country|area|city|addInfoText|
|Afghanistan|Badakshan|Panj Shair|This is a different text|

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
And the user clicks on the city update link
When the user enters values which is beyond 500 unicode characters in the add info field
When the user clicks on the save button in city page
Then the user should be able to view the error message 'Enter up to 500 valid characters'

Examples:
|country|area|city|
|Afghanistan|Badakshan|Panj Shair|
