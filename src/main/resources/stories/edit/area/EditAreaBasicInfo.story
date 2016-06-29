Meta: @EditCityBasicInfo @Edit @area @AllStories

Narrative:
In order to view and edit the area page
As a user
I want to cover the requirements mentioned in

JIRA ID - ZEUS-1025 - User can edit Area's Status

Scenario: Verify Area Status dropdown values from lookup Status

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a area option
And the user enters the area <subarea> in the type-ahead box
And the user clicks on the area basic info link in the navigation bar
When the user clicks on the area update link
And the user clicks on the Status drop-down in the basicinfo area page
Then the user should see the status values from area Status dropdown

Examples:
|country|area|area|
|USA|Georgia|Adel|

Scenario: Verify that the area Status drop-down list should highlight the values that contain characters input by user
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the area basic info link in the navigation bar
When the user clicks on the area update link
And the user starts typing the name of a status as i in the area Status drop-down
Then the user should see the selected status in the area Status drop-down as Inactive
When the user starts typing the name of a status as a in the area Status drop-down
Then the user should see the selected status in the area Status drop-down as Active
When the user starts typing the name of a status as p in the area Status drop-down
Then the user should see the selected status in the area Status drop-down as Pending
When the user starts typing the name of a status as x in the area Status drop-down
Then the user should see the selected status in the area Status drop-down as Pending

Examples:
|country|area|area|
|USA|Georgia|Adel|

Scenario: User will see summary of changes made in confirmation modal when update the area status

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the area basic info link in the navigation bar
When the user clicks on the area update link
When the user selects value as <status> from Status drop-down in the area basicinfo page
And the user clicks on the save button in area page
When the user clicks on the confirm button
When the user clicks on the area update link
When the user starts typing the name of a status as i in the area Status drop-down
Then the user should see the selected status in the area Status drop-down as inactive
When the user clicks on the save button
Then the user should see the save confirmation modal
And the user should see the below summary changes in confirmation modal
|Summary|
|Basic Info|
When the user clicks on the return button
Then the user should return to edit area page mode

Examples:
|country|area|area|status|
|USA|Georgia|Adel|active|


Scenario: Edit and Save area's Status value in the area Basic Info page
a) Veriy that the default value of status during edit matches with the status of the trusted document
b) Upate the status with a new value and verify it is updated in zeus document
c) Upate the status with the same existing value and verify the existing value in zeus document
d) verify that the status can be changed to all 3 values active,inactive and pending

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the area basic info link in the navigation bar
When the user clicks on the area update link
Then the user should see the area status value same as in trusted document
When the user gets the document with get document id for area with the <area> from the database
When the user selects value as <status> from Status drop-down in the area basicinfo page
And the user clicks on the save button in area page
Then the user should see the save confirmation modal
When the user clicks on the confirm button
Then the user should see the area <status> value as in zeus document
Then the user reverts the changes to the document

Examples:
|country|area|area|status|
|USA|Georgia|Adel|active|
|USA|Georgia|Adel|pending|
|USA|Georgia|Adel|inactive|


Scenario: No changes should happen to area's Status value in the area Basic Info page when user selects save button with out doing any changes 

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the area basic info link in the navigation bar
When the user clicks on the area update link
Then the user should see the area status value same as in trusted document
When the user clicks on the save button in area page
Then the user should see the save confirmation modal
Then the user should not see the <ConfirmationSummary> changes in confirmation modal
When the user clicks on the confirm button
Then the user should see the area <status> value as in zeus document

Examples:
|country|area|area|status|ConfirmationSummary|
|USA|Georgia|Adel|active|Summary|