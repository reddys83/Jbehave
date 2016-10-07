Meta: @EditAreaDemographics @Edit @Area @AllStories

Narrative:
In order to view and edit the area page
As a user
I want to cover the requirements mentioned in

JIRA ID - ZEUS-1042 - User can edit Area's Demographics

Scenario: user verifies area's demographics 
1- The demographic type drop-down lists values should be from DEMORGAPHIC_METRIC look up
2- The demographic unit drop-down lists values should be from UNIT_OF_MEASUREMENT for demographic type 'area'
3- Verify user can enter demogrpahic unit value and which is reflected in UI and Zeus

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
When the user clicks on the choose an area option in area Page
And the user enters the area <area> in the type-ahead box
And the user clicks on the area's demographics link in the navigation bar
And the user clicks on the area update link
When the user gets the document with get document id for area with the <area> from the database
When the user deletes the existing area demographics rows
When the user clicks on the add new demographics button in the area page
Then the user should see the area demographics types from lookup DEMOGRAPHIC_METRIC
When the user selects the demographic types <demographicType> in the area page
Then the user should see the demographics units in area page are from lookup UNIT_OF_MEASUREMENT
When the user enters the demographic value <demographicValue> in the area page
When the user enters the demographic unit <unitValue> in the area page
And the user enter demographics day <day> in the demographics area page
And the user enter demographics month <month> in the demographics area page
And the user enter demographics year <year> in the demographics area page
And the user clicks on the save button
When the user clicks on the confirm button
Then the user should see the successful update message at top of the area page
Then the user should see the area demographic values are saved in area page
Then the user should see the area demographic values as in zeus document
Then the user reverts the changes to the document

Examples:
|country|area|demographicType|demographicValue|unitValue|day|month|year|
|Angola|Bengo|Area|12345|km�|12|Jun|2011|

Scenario: The metric unit type is null, then unit drop-down for that row should get displayed
1- demographics type other than Area should not display the unit drop down

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
When the user clicks on the choose an area option in area Page
And the user enters the area <area> in the type-ahead box
And the user clicks on the area's demographics link in the navigation bar
And the user clicks on the area update link
When the user deletes the existing area demographics rows
When the user clicks on the add new demographics button in the area page
When the user selects the demographic types <demographicType> in the area page
Then the user should not see the unit drop down for selected demographic type in area page

Examples:
|country|area|demographicType|
|Angola|Bengo|Largest County Population|

Scenario: User adding new demographics values 
1 - Verify demographics type other than Area should not display the unit drop down 
2 - Verify entered demographic values in two rows and validating in Zeus and UI
3 - verify Blank value scenario

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
When the user clicks on the choose an area option in area Page
And the user enters the area <area> in the type-ahead box
And the user clicks on the area's demographics link in the navigation bar
And the user clicks on the area update link
When the user gets the document with get document id for area with the <area> from the database
When the user deletes the existing area demographics rows
When the user clicks on the add new demographics button in the country basic info page
When the user selects the demographic types <demographicType> in the area page
Then the user should not see the unit drop down for selected demographic type in area page
When the user enters the demographic value <demographicValue> in the area page
When the user enter demographics date <day> <month> <year> in the demographics row 1 in area page
When the user clicks on the add new demographics button in the country basic info page
When the user enter demographics date <day> <month> <year> in the demographics row 2 in area page
When the user selects the demographic types <demographicType2> <demographicValue2> in the area page
And the user clicks on the save button
When the user clicks on the confirm button
Then the user should see the successful update message at top of the area page
Then the user should see the area demographic row values are saved in area page
Then the user should see the area demographic values in two rows as in zeus document
Then the user reverts the changes to the document

Examples:
|country|area|demographicType|demographicValue|day|month|year|demographicType2|demographicValue2|
|Angola|Bengo|Largest County Population|34000000|||2014|Number of Counties|564|
|Angola|Bengo|Number of Houses|12345||||Largest County Population|345|

Scenario: The user has entered a value for 'Demographics' that is no different to the current value in the Area Demographics page
1 - User verifies Area Demographics changes has not been updated in confirmation modal
2 - User verifies Demographics values in Area Demographics page and Zeus Document

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
When the user clicks on the choose an area option in area Page
And the user enters the area <area> in the type-ahead box
And the user clicks on the area's demographics link in the navigation bar
And the user clicks on the area update link
When the user gets the document with get document id for area with the <area> from the database
When the user deletes the existing area demographics rows
When the user clicks on the add new demographics button in the country basic info page
When the user selects the demographic types <demographicType> in the area page
When the user enters the demographic value <demographicValue> in the area page
When the user enter demographics date <day> <month> <year> in the demographics row 1 in area page
And the user clicks on the save button
When the user clicks on the confirm button
And the user clicks on the area update link
When the user selects the demographic types <demographicType> in the area page
When the user enters the demographic value <demographicValue> in the area page
And the user enter demographics day <day> in the demographics area page
And the user enter demographics month <month> in the demographics area page
And the user enter demographics year <year> in the demographics area page
And the user clicks on the save button
Then the user should not see the below summary changes in confirmation modal
|Summary|
|Demographics|
When the user clicks on the confirm button
Then the user should see the area demographic row is saved in area page
Then the user should see the area demographic values as in zeus document
Then the user reverts the changes to the document

Examples:
|country|area|demographicType|demographicValue|unitValue|day|month|year|
|Angola|Cabinda|Population|124||12|Jun|2011|


Scenario: User verifies appropriate error messages are displayed for invalid input 
1 - Verify error message enter a year, month/year or day/month/year for newly added holiday
2 - Verify error message "Must be no later than today" if the date is later than today
3 - Verify error message "Required" when type and value fields are null

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
When the user clicks on the choose an area option in area Page
And the user enters the area <area> in the type-ahead box
And the user clicks on the area's demographics link in the navigation bar
And the user clicks on the area update link
When the user deletes the existing area demographics rows
When the user clicks on the add new demographics button in the area page
And the user enter demographics day <day> in the demographics area page
And the user enter demographics month <month> in the demographics area page
And the user clicks on the save button
Then the user should see the error message Enter a year, month/year or day/month/year. in the demographics area page
Then the user should see the error message at top of page the highlighted fields must be addressed before this update can be saved
When the user enters the demographic date later than today in area page
And the user clicks on the save button
Then the user should see the error message Must be no later than today. in the demographics area page
Then the user should see the error message Required for the type and value fields in area page

Examples:
|country|area|day|month|
|Angola|Bengo||Jun|
|Angola|Bengo|21|Aug|


Scenario: User is adding/deleting new Area's Demographics -
1 - Verify if User can prevent deleting demographics row by clicking on 'No'.
2 - Verify if User can delete demographics row by clicking on 'Yes' , then after saving it should be removed.
3 - User verifies that UI and Zeus document is updated.

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
When the user clicks on the choose an area option in area Page
And the user enters the area <area> in the type-ahead box
And the user clicks on the area's demographics link in the navigation bar
And the user clicks on the area update link
When the user gets the document with get document id for area with the <area> from the database
When the user deletes the existing area demographics rows
When the user clicks on the add new demographics button in the area page
When the user selects the demographic types <demographicType> in the area page
When the user enters the demographic value <demographicValue> in the area page
And the user clicks on the save button
When the user clicks on the confirm button
And the user clicks on the area update link
When the user clicks on delete area demographics option
Then the user should see delete row confirmation modal in the area demographics page
When the user clicks on the No button to cancel the deletion of area demographics row
Then the user should see the newly added demographics row in the area demographics page
When the user clicks on delete area demographics option
Then the user should see delete row confirmation modal in the area demographics page
When the user clicks on the Yes button to delete area demographics row
And the user clicks on the save button
Then the user should see the below summary changes in confirmation modal
|Summary|
|Demographics|
When the user clicks on the confirm button
Then the user should see the successful update message at top of the area page
Then the user should not see the newly added demographics row in the area page
Then the user should see the area demographic values are null in zeus document
Then the user reverts the changes to the document

Examples:
|country|area|demographicType|demographicValue|
|Angola|Bengo|Population|123|
