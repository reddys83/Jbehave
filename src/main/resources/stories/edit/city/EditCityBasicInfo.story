Meta: @EditCityBasicInfo @Edit @City @AllStories

Narrative:
In order to view and edit the city page
As a user
I want to cover the requirements mentioned in

JIRA ID - ZEUS-968 - User can edit City's Population

Scenario: To view the City's 'Basic Info' under the City tab so that a value can be entered for 'Population' field
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
When the user gets the document with get document id for city with the <city> from the database
And the user enters the <value> in the population field
When the user clicks on the save button in city page
And the user clicks on the confirm button
Then the user should see the successful update message at top of the page
Then the user should see the population <value> as in zeus document

Examples:
|country|area|city|value|
|Afghanistan|Badakshan|Panj Shair|15|

Scenario: To update the City's 'Basic Info' by entering a value for 'Population' that is different from the current value
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
Then the user should see the population <previousValue> should be same in zeus document
When the user gets the document with get document id for city with the <city> from the database
And the user enters the <value> in the population field
When the user clicks on the save button in city page
And the user clicks on the confirm button
Then the user should see the successful update message at top of the page
Then the user should see the population <value> as in zeus document
Then the user reverts the changes to the document

Examples:
|country|area|city|previousValue|value|
|Afghanistan|Badakshan|Panj Shair|15|10|

Scenario: User is updating a City's Basic Info and has entered a value for 'Population' that is no different to the current value
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
Then the user should see the population <previousValue> should be same in zeus document
When the user gets the document with get document id for city with the <city> from the database
And the user enters the <value> in the population field
When the user clicks on the save button in city page
And the user clicks on the confirm button
Then the user should be able to verify the values are entered in the population field
Then the user should see the population <value> as in zeus document
Then the user reverts the changes to the document

Examples:
|country|area|city|previousValue|value|
|Afghanistan|Badakshan|Panj Shair|15|15|

Scenario: User is updating a City's Basic Info and has entered a value for 'Population' that is the maximum limit 50 characters from the current value
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
When the user gets the document with get document id for city with the <city> from the database
When the user enters values which is 50 unicode characters in the population field
When the user clicks on the save button in city page
And the user clicks on the confirm button
Then the user should see the successful update message at top of the page
Then the user should see the population <value> as in zeus document
Then the user reverts the changes to the document

Examples:
|country|area|city|
|Afghanistan|Badakshan|Panj Shair|

Scenario: User is updating a City's Basic Info and has entered a value for 'Population' that is exceeding the maximum limit 50 characters from the current value
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
When the user gets the document with get document id for city with the <city> from the database
When the user enters values which is beyond 50 unicode characters in the population field
When the user clicks on the save button in city page
Then the user should be able to view the error message 'Enter up to 50 valid characters'

Examples:
|country|area|city|error message|
|Afghanistan|Badakshan|Panj Shair|Enter up to 50 valid characters|

Scenario: 	User is updating a City's Basic Info and has entered a string value for 'Population', then error message shou be displayed.
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
And the user enters the <value> in the population field
When the user clicks on the save button in city page
Then the user should be able to view the error message 'Enter up to 50 valid characters'

Examples:
|country|area|city|value|
|Afghanistan|Badakshan|Panj Shair|stringvalue|
