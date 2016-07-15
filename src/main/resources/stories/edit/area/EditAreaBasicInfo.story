Meta: @EditAreaBasicInfo @Edit @area @AllStories

Narrative:
In order to view and edit the area page
As a user
I want to cover the requirements mentioned in

JIRA ID - ZEUS-1025 - User can edit Area's Status
JIRA ID - ZEUS-1034 - User can edit Area's Add Info

Scenario:  To update the Area`s 'Basic Info' by entering a value for 'Add Info' that is different from the current value
a)User verifies whether current value of Add Info is same as in trusted document.
b)User verifies Area Basic Info has been updated in confirmation modal
c)User verifies 'Your Changes have been saved' message is displayed after save
d)User verified Add Info value is updated correctly in area basic info page
e)User verifies Add Info values in Zeus Document

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the <Area> in the type-ahead box
And the user clicks on the area basic info link in the navigation bar
And the user clicks on the area update link
When the user gets the document with get document id for area with the <Area> from the database
Then the user should see the area addInfoText value same as in trusted document
When the user enters the <addInfoText> in the area add info text area
And the user clicks on the save button
Then the user should see the below summary changes in confirmation modal
|Summary|
|Basic Info|
When the user clicks on the confirm button
Then the user should see the successful update message at top of the area page
Then the user should be able to verify the values are entered in the area add info field
Then the user should see the area addinfo value <addInfoText> as in zeus document
Then the user reverts the changes to the document

Examples:
|country|Area|addInfoText|
|USA|Georgia|This is a different text|

Scenario: To view that there is no change in value when the user has entered a value for 'Add Info' that is no different to the current value in Area page
a)User verifies Area Basic Info changes has not  been updated in confirmation modal
b)User verifies 'Your Changes have been saved' message is displayed after save
c)User verified Add Info value is updated correctly in area basic info page
d)User verifies Add Info values in Zeus Document

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the <Area> in the type-ahead box
And the user clicks on the area basic info link in the navigation bar
And the user clicks on the area update link
When the user gets the document with get document id for area with the <Area> from the database
When the user enters the <addInfoText> in the area add info text area
And the user clicks on the save button
When the user clicks on the confirm button
Then the user should see the successful update message at top of the area page
Then the user should be able to verify the values are entered in the area add info field
When the user clicks on the area update link
When the user enters the <addInfoText> in the area add info text area
And the user clicks on the save button
Then the user should not see the <ConfirmationSummary> changes in confirmation modal for area
When the user clicks on the confirm button
Then the user should see the successful update message at top of the area page
Then the user should be able to verify the values are entered in the area add info field
Then the user reverts the changes to the document

Examples:
|country|Area|city|addInfoText|ConfirmationSummary|
|USA|Georgia|Adrian|This is a same text|Basic Info|

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
When the user gets the document with get document id for area with the <Area> from the database
When the user enters values which is beyond 500 unicode characters in the area add info field
And the user clicks on the save button
And the user clicks on the confirm button
Then the user should see the successful update message at top of the area page
Then the user should be able to view that only 500 unicode characters are saved in area add info
Then the user should be able to verify the maximum values are entered in the area add info field
Then the user reverts the changes to the document

Examples:
|country|Area|
|USA|Georgia|