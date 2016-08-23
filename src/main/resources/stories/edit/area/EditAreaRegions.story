Meta: @EditAreaRegions @Edit @Area @AllStories

Narrative:
In order to view and edit the Area  page
As a user
I want to cover the requirements mentioned in

JIRA ID - ZEUS-1047 - User can edit Area's Regions



Scenario: Verify Area Region type dropdown values from lookup AREA_ALTERNATIVE_REGION
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the area regions link in the navigation bar
And the user clicks on the area update link
When the user clicks on the add new region button in the area region page
And the user enters region type as <newRegionType> in the region area page
Then the user should see the region type from 'AREA_ALTERNATIVE_REGION' look up
Then the user should see the area region value from <regionValueLookUp>

Examples:
|country|area|newRegionType|regionValueLookUp|
|Angola|Cabinda|Federal Reserve District|FEDERAL_RESERVE_DISTRICT|

Scenario: User adds new region type and value, checks the confirmation summary modal and saves the data to DB

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the area regions link in the navigation bar
And the user clicks on the area update link
When the user gets the document with get document id for area with the <area> from the database
When the user deletes all existing area regions in area page in area page
When the user clicks on the add new region button in the area region page
And the user enters region type as <newRegionType> in the region area page
And the user enters region value as <newRegionValue> in the region area page
When the user clicks on the save button
When the user clicks on the confirm button
Then the user should see the successful update message at top of the area page
Then the user should see the area region type and value updated in UI
Then the user reverts the changes to the document

Examples:
|country|area|newRegionType|newRegionValue|
|Angola|Cabinda|Federal Reserve District|FEDERAL_RESERVE_DISTRICT|

Scenario: User adds new region type but not selected region value, checks whether the required message is displayed
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the area regions link in the navigation bar
And the user clicks on the area update link
When the user deletes all existing area regions in area page in area page
When the user clicks on the add new region button in the area region page
And the user enters region type as <newRegionType> in the region area page
When the user clicks on the save button
Then the user should see the error message for the required region value field in the area region page

Examples:
|country|area|newRegionType|newRegionValue|
|Angola|Cabinda|Federal Reserve District|FEDERAL_RESERVE_DISTRICT|

Scenario: User adds new blank region type and blank value, checks the new blank region is not getting added to DB
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the area regions link in the navigation bar
And the user clicks on the area update link
When the user deletes all existing area regions in area page in area page
When the user clicks on the add new region button in the area region page
When the user clicks on the save button
When the user clicks on the confirm button
Then the user should see the successful update message at top of the area page
Then the user should see the blank area region type and blank value is not updated in zeus document

Examples:
|country|area|newRegionType|newRegionValue|
|Angola|Cabinda|Federal Reserve District|FEDERAL_RESERVE_DISTRICT|

Scenario: User updates existing region type and value, checks the confirmation summary modal and saves the data to DB
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the area regions link in the navigation bar
And the user clicks on the area update link
And the user gets the document with get document id for area with the <city> from the database
And the user enters region type as <newRegionType> in the region city page
And the user enters region value as <newRegionValue> in the region city page
And the user clicks on the save button in city page
Then the user should see the below summary changes in confirmation modal
|Summary|
|Regions|
When the user clicks on the confirm button
Then the user should see the successful update message at top of the area page
Then the user should see the city region type 2 and value 2 updated in UI
Then the user should see the region type 2 and value 2 updated in zeus document
Then the user reverts the changes to the document

Examples:
|country|area|city|newRegionType|newRegionValue|newRegionType2|newRegionValue2|
|Angola|Bengo|Caxito|Federal Reserve District|10|Metropolitan Statistical Area|10260|