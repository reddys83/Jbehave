Meta: @EditAreaBasicInfo @Edit @area @AllStories

Narrative:
In order to view and edit the area page
As a user
I want to cover the requirements mentioned in

JIRA ID - ZEUS-1025 - User can edit Area's Status
JIRA ID - ZEUS-1034 - User can edit Area's Add Info

Scenario: Verify Area Status dropdown values from lookup Status
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the <Area> in the type-ahead box
And the user clicks on the area basic info link in the navigation bar
And the user clicks on the area update link
When the user clicks on the Status drop-down in the basicinfo area page
Then the user should see the area status values from lookup AREA

Examples:
|country|Area|
|USA|Alabama|

Scenario: Edit and Save Area's Status value in the Area Basic Info page
a) Update the status with a new value and verify it is updated in Area Web page & zeus document
b) verify that the status can be changed to all 3 values active,inactive and pending

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the <Area> in the type-ahead box
And the user clicks on the area basic info link in the navigation bar
And the user clicks on the area update link
When the user gets the document with get document id for area with the <area> from the database
When the user selects value as <status> from Status drop-down in the area basicinfo page
And the user clicks on the save button
Then the user should see the save confirmation modal
When the user clicks on the confirm button
Then the user should see the successful update message at top of the area page
Then the user should see the updated <status> in area web page
Then the user should see status value in area page as in zeus document
Then the user reverts the changes to the document

Examples:
|country|Area|status|
|USA|Alabama|Active|
|USA|Alabama|Pending|
|USA|Alabama|Inactive|

Scenario:  Verify that the Area Status drop-down list should highlight the values that contain characters input by user

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the <Area> in the type-ahead box
And the user clicks on the area basic info link in the navigation bar
And the user clicks on the area update link
And the user starts typing the name of a status as i in the Area Status drop-down
Then the user should see the selected status in the Area Status drop-down as Inactive
When the user starts typing the name of a status as a in the Area Status drop-down
Then the user should see the selected status in the Area Status drop-down as Active
When the user starts typing the name of a status as p in the Area Status drop-down
Then the user should see the selected status in the Area Status drop-down as Pending
When the user starts typing the name of a status as x in the Area Status drop-down
Then the user should see the selected status in the Area Status drop-down as Pending

Examples:
|country|Area|
|USA|Alabama|

Scenario: Verify whether Area Status value in Area Web Page is retrieved from trusted document.

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the <Area> in the type-ahead box
And the user clicks on the area basic info link in the navigation bar
And the user clicks on the area update link
Then the user should see the status value in area page is same as in trusted document

Examples:
|country|Area|
|USA|Alabama|

Scenario: User will see summary of changes made in confirmation modal when update the Area status

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the <Area> in the type-ahead box
And the user clicks on the area basic info link in the navigation bar
And the user clicks on the area update link
When the user gets the document with get document id for area with the <area> from the database
When the user selects value as <status> from Status drop-down in the area basicinfo page
And the user clicks on the save button
Then the user should see the save confirmation modal
When the user clicks on the confirm button
Then the user should see the successful update message at top of the area page
Then the user should see the updated <status> in area web page
When the user clicks on the area update link
When the user selects value as <status2> from Status drop-down in the area basicinfo page
And the user clicks on the save button
Then the user should see the save confirmation modal
And the user should see the below summary changes in confirmation modal
|Summary|
|Basic Info|
When the user clicks on the return button
Then the user reverts the changes to the document

Examples:
|country|Area|status|status2|
|USA|Alabama|Inactive|Pending|

Scenario: The user can edit the value in the Add Info field and save it and see it in Area web page(Front End Validation) 

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the <Area> in the type-ahead box
And the user clicks on the area basic info link in the navigation bar
And the user clicks on the area update link
When the user gets the document with get document id for area with the <area> from the database
When the user enters the <addInfoText> in the area add info text area
And the user clicks on the save button
Then the user should see the below summary changes in confirmation modal
|Summary|
|Basic Info|
When the user clicks on the confirm button
Then the user should see the successful update message at top of the page
Then the user should be able to verify the values are entered in the area add info field
Then the user reverts the changes to the document

Examples:
|country|area|city|addInfoText|
|USA|Georgia|Adrian|Sample text|

Scenario: To update the Area`s 'Basic Info' by entering a value for 'Add Info' that is different from the current value(Back End validation)
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the <Area> in the type-ahead box
And the user clicks on the area basic info link in the navigation bar
And the user clicks on the area update link
Then the user should see the addInfoText value same as in trusted document
When the user enters the <addInfoText> in the add info text area
When the user clicks on the save button in city page
And the user clicks on the confirm button
Then the user should see the city addinfo value <addInfoText> as in zeus document


Examples:
|country|area|city|addInfoText|
|USA|Georgia|Adrian|This is a different text|

Scenario: To view that there is no change in value when the user has entered a value for 'Add Info' that is no different to the current value in Area page(Front End Validation)

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the <Area> in the type-ahead box
And the user clicks on the area basic info link in the navigation bar
And the user clicks on the area update link
When the user gets the document with get document id for area with the <area> from the database
When the user enters the <addInfoText> in the area add info text area
And the user clicks on the save button
When the user clicks on the confirm button
Then the user should see the successful update message at top of the page
Then the user should be able to verify the values are entered in the area add info field
When the user clicks on the area update link
When the user enters the <addInfoText> in the area add info text area
And the user clicks on the save button
Then the user should not see the <ConfirmationSummary> changes in area confirmation modal
When the user clicks on the confirm button
Then the user should see the successful update message at top of the page
Then the user should be able to verify the values are entered in the area add info field
Then the user reverts the changes to the document

Examples:
|country|area|city|addInfoText|ConfirmationSummary|
|USA|Georgia|Adrian|This is a different text|Basic Info|

Scenario: To view whether the text entered in the 'Add Info' field is not beyond 500 unicode characters after saving the Area page
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the <Area> in the type-ahead box
And the user clicks on the area basic info link in the navigation bar
And the user clicks on the area update link
When the user enters values which is beyond 500 unicode characters in the area add info field
And the user clicks on the save button
And the user clicks on the confirm button
Then the user should see the successful update message at top of the page
Then the user should be able to view that only 500 unicode characters are saved in area add info
Then the user should be able to verify the maximum values are entered in the area add info field


Examples:
|country|area|city|
|USA|Georgia|Adrian|