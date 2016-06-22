Meta: @EditCityBasicInfoNames

Narrative:
In order to view and edit the city page
As a user
I want to cover the requirements mentioned in

Scenario: User edit and save the full name in the City Basic Info page
Meta: @sureshtest1
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
And the user clicks on the city basic info link in the navigation bar
Then the user should see city name value same as in trusted document
When the user clicks on the city update link
And the user gets the document with get document id for city with the <city> from the database
And the user should see the full name is not editable
And the user enters the <newNameValue> in the full name field
And the user clicks on the save button in city page
Then the user should see the below summary changes in confirmation modal
|Summary|
|Basic Info / Names|
When the user clicks on the confirm button
Then the user should see the successful update message at top of the page
Then the user should see the full name <newNameValue> as in zeus document
Then the user should be able to verify the <newNameValue> is updated in full name value field
Then the user reverts the changes to the document

Examples:
|country|area|city|newNameValue|
|Belgium|Limburg|Bree|Panj Shair|

Scenario: User adds new name type and value, checks the confirmation summary modal and saves the data to DB
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
And the user clicks on the city basic info link in the navigation bar
When the user clicks on the city update link
And the user gets the document with get document id for city with the <city> from the database
When the user clicks on the add new name button in the basic info city page
And the user clicks on the city name type drop-down
And the user enters name type as <newNameType> in the basic info city page
And the user enters name value as <newNameValue> in the basic info city page
And the user clicks on the save button in city page
Then the user should see the below summary changes in confirmation modal
|Summary|
|Basic Info / Names|
When the user clicks on the confirm button
Then the user should see the successful update message at top of the page
Then the user should see the value updated in zeus document
Then the user should see the city name type and value updated in UI
Then the user reverts the changes to the document

Examples:
|country|area|city|newNameType|newNameValue|
|Belgium|Limburg|Bree|Display Name|Panj Shair|
|Belgium|Limburg|Bree|Alternative Name|Panj Shair|

Scenario: User can edit city names - Verify city name types are same as from lookup PLACE_NAME_TYPE
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
And the user clicks on the city basic info link in the navigation bar
When the user clicks on the city update link
When the user clicks on the add new name button in the basic info city page
And the user clicks on the city name type drop-down
Then the user should see the city name types from lookup PLACE_NAME_TYPE

Examples:
|country|area|city|
|Belgium|Limburg|Bree|

Scenario: User can edit city names - Verify city name types in the dropdown are not getting repeated in the consecutive rows
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
And the user clicks on the city basic info link in the navigation bar
When the user clicks on the city update link
When the user clicks on the add new name button in the basic info city page
And the user clicks on the city name type drop-down
And the user enters name type as <newNameType> in the basic info city page
And the user clicks on the add new name button in the basic info city page
Then the user checks whether the newly added row does not contain already selected name type

Examples:
|country|area|city|newNameType|
|Belgium|Limburg|Bree|Alternative Name|


Scenario: User can edit city names - Verify that newly added empty row is not getting saved to the system
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
And the user clicks on the city basic info link in the navigation bar
When the user clicks on the city update link
When the user clicks on the add new name button in the basic info city page
And the user clicks on the save button in city page
When the user clicks on the confirm button
Then the user should see the successful update message at top of the page
Then the user should be able to verify empty rows not added in zeus document

Examples:
|country|area|city|
|Belgium|Limburg|Bree|

Scenario: User can edit city names - Verify that an error message 'Required' is displayed when user left name type blank and enters value in name value
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
And the user clicks on the city basic info link in the navigation bar
When the user clicks on the city update link
When the user clicks on the add new name button in the basic info city page
And the user enters name value as <newNameValue> in the basic info city page
And the user clicks on the save button in city page
Then the user should see the error message for the required name type field in the city basic info page

Examples:
|country|area|city|newNameType|newNameValue|
|Belgium|Limburg|Bree|Display Name|Panj Shair|

Scenario: User can edit city names - Verify that an error message 'Enter up to 75 valid characters.' is displayed when user left name value blank and enters value in name type
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
And the user clicks on the city basic info link in the navigation bar
When the user clicks on the city update link
When the user clicks on the add new name button in the basic info city page
And the user enters name type as <newNameType> in the basic info city page
And the user clicks on the save button in city page
Then the user should see the error message for the required name value field in the city basic info page

Examples:
|country|area|city|newNameType|newNameValue|
|Belgium|Limburg|Bree|Display Name|Panj Shair|

Scenario: User can edit city names - Verify that the new value updated on existing name is saved to DB
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
And the user clicks on the city basic info link in the navigation bar
When the user clicks on the city update link
And the user gets the document with get document id for city with the <city> from the database
When the user clicks on the add new name button in the basic info city page
And the user clicks on the city name type drop-down
And the user enters name type as <newNameType> in the basic info city page
And the user enters name value as <newNameValue> in the basic info city page
And the user clicks on the save button in city page
Then the user should see the below summary changes in confirmation modal
|Summary|
|Basic Info / Names|
When the user clicks on the confirm button
Then the user should see the successful update message at top of the page
When the user clicks on the city update link
And the user enters name value as <newNameValue2> in the basic info city page
And the user clicks on the save button in city page
Then the user should see the below summary changes in confirmation modal
|Summary|
|Basic Info / Names|
When the user clicks on the confirm button
Then the user should see the successful update message at top of the page
Then the user should see the value newly updated in zeus document
Then the user reverts the changes to the document

Examples:
|country|area|city|newNameType|newNameValue|newNameValue2|
|Belgium|Limburg|Bree|Display Name|Panj Shair|Badakhshan|

Scenario: User can edit city name- Verify if User can delete city name row and clicks no on confirmation modal, on save the name should not get deleted.
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
And the user clicks on the city basic info link in the navigation bar
When the user clicks on the city update link
And the user gets the document with get document id for city with the <city> from the database
When the user clicks on the add new name button in the basic info city page
And the user clicks on the city name type drop-down
And the user enters name type as <newNameType> in the basic info city page
And the user enters name value as <newNameValue> in the basic info city page
And the user clicks on the save button in city page
Then the user should see the below summary changes in confirmation modal
|Summary|
|Basic Info / Names|
When the user clicks on the confirm button
Then the user should see the successful update message at top of the page
When the user clicks on the city update link
When the user clicks on the delete name row button in the basic info city page
Then the user should see delete names row confirmation modal in the city page
When the user clicks on the No button to cancel the deletion of row
And the user clicks on the save button in city page
When the user clicks on the confirm button
Then the user should see the successful update message at top of the page
Then the user should see the value updated in zeus document
Then the user reverts the changes to the document

Examples:
|country|area|city|newNameType|newNameValue|
|Belgium|Limburg|Bree|Alternative Name|Panj Shair|

Scenario: User can edit city name- Verify if User can delete city name row and clicks yes on confirmation modal, on save the name should get deleted
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
And the user clicks on the city basic info link in the navigation bar
When the user clicks on the city update link
And the user gets the document with get document id for city with the <city> from the database
When the user clicks on the add new name button in the basic info city page
And the user clicks on the city name type drop-down
And the user enters name type as <newNameType> in the basic info city page
And the user enters name value as <newNameValue> in the basic info city page
And the user clicks on the save button in city page
Then the user should see the below summary changes in confirmation modal
|Summary|
|Basic Info / Names|
When the user clicks on the confirm button
Then the user should see the successful update message at top of the page
When the user clicks on the city update link
When the user clicks on the delete name row button in the basic info city page
Then the user should see delete names row confirmation modal in the city page
When the user clicks on the Yes button to cancel the deletion of row
And the user clicks on the save button in city page
When the user clicks on the confirm button
Then the user should see the successful update message at top of the page
Then the user should see the value not present in zeus document
Then the user reverts the changes to the document

Examples:
|country|area|city|newNameType|newNameValue|
|Belgium|Limburg|Bree|Alternative Name|Panj Shair|