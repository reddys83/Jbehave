Meta: @EditCityRegions
Narrative:
In order to view and edit the city page
As a user
I want to cover the requirements mentioned in

JIRA ID - ZEUS-975 - User can edit City's Regions

Scenario: Verify City Region type dropdown values from lookup Status
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
And the user clicks on the city regions link in the navigation bar
When the user clicks on the city update link
And the user clicks on the add new region button in the city region page
Then the user should see the region type from region type dropdown

Examples:
|country|area|city|
|Angola|Bengo|Caxito|


Scenario: User adds new region type and value, checks the confirmation summary modal and saves the data to DB
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
And the user clicks on the city regions link in the navigation bar
When the user clicks on the city update link
And the user gets the document with get document id for city with the <city> from the database
And the user clicks on the add new region button in the city region page
And the user enters region type as <newRegionType> in the region city page
And the user enters region value as <newRegionValue> in the region city page
And the user clicks on the save button in city page
Then the user should see the below summary changes in confirmation modal
|Summary|
|Regions|
When the user clicks on the confirm button
Then the user should see the successful update message at top of the page
Then the user should see the region type and value updated in zeus document
Then the user should see the city region type and value updated in UI
When the user clicks on the city update link
Then the user should see city region value same as in trusted document
Then the user reverts the changes to the document

Examples:
|country|area|city|newRegionType|newRegionValue|
|Angola|Bengo|Caxito|Federal Reserve District|10|
|Angola|Bengo|Caxito|National Credit Union Administration Region|IV|
|Angola|Bengo|Caxito|Metropolitan Statistical Area|11020|

Scenario: User adds new blank region type and blank value, checks the new blank region is not getting added to DB
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
And the user clicks on the city regions link in the navigation bar
When the user clicks on the city update link
And the user clicks on the add new region button in the city region page
And the user clicks on the save button in city page
When the user clicks on the confirm button
Then the user should see the successful update message at top of the page
Then the user should see the blank region type and blank value is not updated in zeus document

Examples:
|country|area|city|
|Angola|Bengo|Caxito|


Scenario: User adds new region type but not selected region value, checks whether the required message is displayed
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
And the user clicks on the city regions link in the navigation bar
When the user clicks on the city update link
And the user clicks on the add new region button in the city region page
And the user enters region type as <newRegionType> in the region city page
And the user clicks on the save button in city page
Then the user should see the error message for the required region value field in the city region page

Examples:
|country|area|city|newRegionType|
|Angola|Bengo|Caxito|Federal Reserve District|


Scenario: User updates existing region type and value, checks the confirmation summary modal and saves the data to DB
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
And the user clicks on the city regions link in the navigation bar
When the user clicks on the city update link
And the user gets the document with get document id for city with the <city> from the database
And the user clicks on the add new region button in the city region page
And the user enters region type as <newRegionType> in the region city page
And the user enters region value as <newRegionValue> in the region city page
And the user clicks on the save button in city page
When the user clicks on the confirm button
Then the user should see the successful update message at top of the page
When the user clicks on the city update link
And the user enters region type as <newRegionType2> in the region city page
And the user enters region value as <newRegionValue2> in the region city page
And the user clicks on the save button in city page
Then the user should see the below summary changes in confirmation modal
|Summary|
|Regions|
When the user clicks on the confirm button
Then the user should see the successful update message at top of the page
Then the user should see the city region type 2 and value 2 updated in UI
Then the user should see the region type 2 and value 2 updated in zeus document
Then the user reverts the changes to the document

Examples:
|country|area|city|newRegionType|newRegionValue|newRegionType2|newRegionValue2|
|Angola|Bengo|Caxito|Federal Reserve District|10|Metropolitan Statistical Area|10260|


Scenario: User can edit city region - Verify if User can delete city region row and clicks no on confirmation modal, on save the region should not get deleted.
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
And the user clicks on the city regions link in the navigation bar
When the user clicks on the city update link
And the user gets the document with get document id for city with the <city> from the database
And the user clicks on the add new region button in the city region page
And the user enters region type as <newRegionType> in the region city page
And the user enters region value as <newRegionValue> in the region city page
And the user clicks on the save button in city page
Then the user should see the below summary changes in confirmation modal
|Summary|
|Regions|
When the user clicks on the confirm button
Then the user should see the successful update message at top of the page
When the user clicks on the city update link
When the user clicks on the delete region row button in the region city page
Then the user should see the delete row confirmation modal in the city page
When the user clicks on the No button to cancel the deletion of row
And the user clicks on the save button in city page
When the user clicks on the confirm button
Then the user should see the successful update message at top of the page
Then the user should see the city region type and value updated in UI
Then the user should see the region type and value updated in zeus document
Then the user reverts the changes to the document

Examples:
|country|area|city|newRegionType|newRegionValue|
|Angola|Bengo|Caxito|Federal Reserve District|10|

Scenario: User can edit city region - Verify if User can delete city region row and clicks yes on confirmation modal, on save the region should get deleted.
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
And the user clicks on the city regions link in the navigation bar
When the user clicks on the city update link
And the user gets the document with get document id for city with the <city> from the database
And the user clicks on the add new region button in the city region page
And the user enters region type as <newRegionType> in the region city page
And the user enters region value as <newRegionValue> in the region city page
And the user clicks on the save button in city page
Then the user should see the below summary changes in confirmation modal
|Summary|
|Regions|
When the user clicks on the confirm button
Then the user should see the successful update message at top of the page
When the user clicks on the city update link
When the user clicks on the delete region row button in the region city page
Then the user should see the delete row confirmation modal in the city page
When the user clicks on the Yes button to cancel the deletion of row
And the user clicks on the save button in city page
When the user clicks on the confirm button
Then the user should see the successful update message at top of the page
Then the user should see the city region type and value deleted in UI
Then the user should see the region not present in zeus document
Then the user reverts the changes to the document

Examples:
|country|area|city|newRegionType|newRegionValue|
|Angola|Bengo|Caxito|Federal Reserve District|10|