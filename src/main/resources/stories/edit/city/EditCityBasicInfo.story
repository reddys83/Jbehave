Meta: @EditCityBasicInfo @Edit @City @AllStories

Narrative:
In order to view and edit the city page
As a user
I want to cover the requirements mentioned in

JIRA ID - ZEUS-968 - User can edit City's Population

Scenario: User is updating City's 'Basic Info' by entering a value for 'Population' and verifies the confirmation dialog is having summary Basic Info
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
When the user enters the <value> in the population field
When the user clicks on the save button in city page
Then the user should see the below summary changes in confirmation modal
|Summary|
|Basic Info|

When the user clicks on the confirm button
Then the user should see the successful update message at top of the page
Then the user should see the population <value> as in zeus document
Then the user reverts the changes to the document

Examples:
|country|area|city|value|
|USA|Georgia|Adel|12345|

Scenario: User is updating a City's Basic Info and has entered a same value for 'Population', verifies the confirmation dialog is not having summary info and Zeus Doc having same value
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
When the user enters the <value> in the population field
When the user clicks on the save button in city page
And the user clicks on the confirm button
When the user clicks on the city update link
When the user enters the <value> in the population field
When the user clicks on the save button in city page
Then the user should not see the <ConfirmationSummary> changes in confirmation modal
When the user clicks on the confirm button
Then the user should see the population <value> as in zeus document
Then the user reverts the changes to the document

Examples:
|country|area|city|value|ConfirmationSummary|
|USA|Georgia|Adel|123457|Summary|


Scenario: User is updating a City's Basic Info and has entered a value for 'Population' that is not exceeding the maximum limit 50 characters and verify the value is updated in Zeus DB
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
Then the user reverts the changes to the document

Examples:
|country|area|city|value|
|USA|Georgia|Adel|24513450000000000000000000000000000000000000000000|


Scenario: 	User is updating a City's Basic Info and has entered a string value value for 'Population', then error message should be displayed.(Negative Validation)
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
Then the user should be able to view the error message 'Enter up to 50 valid numbers'
Then the user should see maximum length of population is limited to 50

Examples:
|country|area|city|value|
|USA|Georgia|Adel|stringvalue|
