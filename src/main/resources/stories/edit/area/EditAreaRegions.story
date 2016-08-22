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
|Angola|Bengo|Federal Reserve Sub District|FEDERAL_RESERVE_BRANCH_DISTRICT|
|Angola|Bengo|Federal Home Loan Bank District|FEDERAL_HOME_LOAN_BANK_DISTRICT|
|Angola|Bengo|National Credit Union Administration Region|NCUA_REGION|
|Angola|Bengo|Metropolitan Statistical Area|MSA|