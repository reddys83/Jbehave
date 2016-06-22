Meta: @EditCityBasicInfoNames

Narrative:
In order to view and edit the city page
As a user
I want to cover the requirements mentioned in

Scenario: 1 Edit and Save the full name in the City Basic Info page
Meta: @sureshtest12
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
And the user should see the full name is not editable
And the user enters the <nameValue> in the full name field
And the user clicks on the save button in city page
Then the user should see the below summary changes in confirmation modal
|Summary|
|Basic Info / Names|
When the user clicks on the confirm button
Then the user should see the successful update message at top of the page
Then the user should see the full name $nameValue as in zeus document
Then the user should be able to verify the <nameValue> is updated in name value field
Then the user reverts the changes to the document

Examples:
|country|area|city|source|nameValue|
|Belgium|Limburg|Bree|zeus|Panj Shair|


Scenario: 2 User adds new name type and saves the data
Meta: @sureshtest12
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
|country|area|city|source|newNameType|newNameValue|
|Belgium|Limburg|Bree|zeus|Display Name|Panj Shair|
|Belgium|Limburg|Bree|zeus|Alternative Name|Panj Shair|

Scenario: 3 User can edit city names - Verify city name types are same as from lookup PLACE_NAME_TYPE
Meta: @sureshtest12
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


Scenario: 3a User can edit city names - Verify city name types are mutually exclusive
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
When the user clicks on the city update link
When the user clicks on the add new name button in the basic info city page
And the user clicks on the city name type drop-down
And the user enters name type as <newNameType> in the basic info city page
And the user clicks on the add new name button in the basic info city page
Then the user checks whether the newly added row does not contain already selected name type

Examples:
|country|area|city|newNameType|
|Belgium|Limburg|Bree|Alternative Name|



Scenario: 4 Verify that newly added empty row is not getting added to the system
Meta: @sureshtest12
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
|country|area|city|source|
|Belgium|Limburg|Bree|zeus|

Scenario: 5 User can edit city names - Verify that an error message 'Required' is displayed when user left name type blank and enters value in name value
Meta: @sureshtest12
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
|country|area|city|source|newNameType|newNameValue|
|Belgium|Limburg|Bree|zeus|Display Name|Panj Shair|


Scenario: 6 User can edit city names - Verify that an error message 'Enter up to 75 valid characters.' is displayed when user left name value blank and enters value in name type
Meta: @sureshtest12
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
|country|area|city|source|newNameType|newNameValue|
|Belgium|Limburg|Bree|zeus|Display Name|Panj Shair|



Scenario: 7 User updates the existing name value and saves the data
Meta: @sureshtest12
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
|country|area|city|source|newNameType|newNameValue|newNameValue2|
|Belgium|Limburg|Bree|zeus|Display Name|Panj Shair|Badakhshan|



Scenario: 8 User can edit city name- Verify if User can delete city name ( "Type","Value") by clicking on 'no', then after saving the name should not get deleted.
Meta: @sureshtest12
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
|country|area|city|source|newNameType|newNameValue|
|Belgium|Limburg|Bree|zeus|Alternative Name|Panj Shair|



Scenario: 9 User can edit city name- Verify if User can delete city name ( "Type","Value") by clicking on 'yes', then after saving the name should be deleted.
Meta: @sureshtest12
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
|country|area|city|source|newNameType|newNameValue|
|Belgium|Limburg|Bree|zeus|Alternative Name|Panj Shair|
