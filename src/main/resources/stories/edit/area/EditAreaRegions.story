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
|Angola|Cabinda|Federal Home Loan Bank District|FEDERAL_HOME_LOAN_BANK_DISTRICT|

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
And the user gets the document with get document id for area with the <area> from the database
And the user enters region type as <newRegionType> in the region area page
And the user enters region value as <newRegionValue> in the region area page
When the user clicks on the save button
Then the user should see the below summary changes in confirmation modal
|Summary|
|Regions|
When the user clicks on the confirm button
Then the user should see the successful update message at top of the area page
Then the user should see the area region type and value updated in UI
Then the user should see the area region type and value updated in zeus document
Then the user reverts the changes to the document

Examples:
|country|area|newRegionType|newRegionValue|
|Angola|Cabinda|Federal Reserve District|1|
|Angola|Cabinda|Federal Home Loan Bank District|6|

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
Then the user should see the area region type and value updated in zeus document
Then the user reverts the changes to the document

Examples:
|country|area|newRegionType|newRegionValue|
|Angola|Cabinda|Federal Reserve District|3|
|Angola|Cabinda|Federal Home Loan Bank District|9|

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
|Angola|Cabinda|Federal Reserve District|4|

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
When the user gets the document with get document id for area with the <area> from the database
When the user deletes all existing area regions in area page in area page
When the user clicks on the add new region button in the area region page
When the user clicks on the save button
When the user clicks on the confirm button
Then the user should see the successful update message at top of the area page
Then the user should see the blank area region type and blank value is not updated in zeus document
Then the user reverts the changes to the document

Examples:
|country|area|
|Angola|Cabinda|


Scenario: User can edit area region - 
1 - Verify if User can delete area region row and clicks no on confirmation modal, on save the region should not get deleted.
2 - Verify if User can delete area region row and clicks yes on confirmation modal, on save the region should get deleted.

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
When the user clicks on the delete region row button in the region area page
When the user clicks on the no button in the delete row confirmation modal in the office page
Then the user should see the area region type and value updated in edit area page
When the user clicks on the delete region row button in the region area page
When the user clicks on the yes button in the delete row confirmation modal in the office page
When the user clicks on the save button
When the user clicks on the confirm button
Then the user should see the successful update message at top of the area page
Then the user should see the area region type and value deleted in UI
Then the user should see the area region not present in zeus document
Then the user reverts the changes to the document

Examples:
|country|area|newRegionType|newRegionValue|
|Angola|Cabinda|Federal Home Loan Bank District|9|