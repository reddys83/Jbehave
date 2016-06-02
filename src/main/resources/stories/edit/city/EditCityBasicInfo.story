Meta: @EditCityBasicInfo @Edit @City

Narrative:
In order to view and edit the city page
As a user
I want to cover the requirements mentioned in

JIRA ID - ZEUS-969 - User can edit City's Add Info

Scenario: The user can edit the value in the Add Info field and save it and see it on the front end
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
And the user gets the value already present in the text box
And the user enters the <addInfoText> in the add info text area
When the user clicks on the save button in city page
And the user clicks on the confirm button
Then the user should be able to verify the values are entered in the add info field
Then the user should see the successful update message at top of the page
Then the user verifies whether the new value <addInfoText> is different from previous value

Examples:
|country|area|city|addInfoText|
|Afghanistan|Badakshan|Panj Shair|Sample text|


Scenario: To update the City's 'Basic Info' by entering a value for 'Add Info' that is different from the current value(Back End validation)
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
When the user enters the <addInfoText> in the add info text area
When the user clicks on the save button in city page
And the user clicks on the confirm button
Then the user should see the <addInfoText> value as in zeus document

Examples:
|country|area|city|addInfoText|
|Afghanistan|Badakshan|Panj Shair|This is a different text|

Scenario: To view that there is no change in value when the user has entered a value for 'Add Info' that is no different to the current value(Front End Validation)
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
Then the user should see no summary changes in the save confirmation modal

Examples:
|country|area|city|addInfoText|value|
|Afghanistan|Badakshan|Panj Shair|This is a different text| |

Scenario: To view whether the text entered in the 'Add Info' field is not beyond 500 unicode characters after saving
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
And the user clicks on the confirm button
Then the user should be able to view that only 500 unicode characters are saved
When the user clicks on the city update link
Then the user reverts the changes to the add info text area
When the user clicks on the save button in city page
And the user clicks on the confirm button
Then the user should be able to verify the values are entered in the add info field
Then the user should see the successful update message at top of the page

Examples:
|country|area|city|
|Afghanistan|Badakshan|Panj Shair|