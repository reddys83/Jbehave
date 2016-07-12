Meta: @EditAreaBasicInfo @Edit @area @AllStories

Narrative:
In order to view and edit the area page
As a user
I want to cover the requirements mentioned in

JIRA ID - User can edit Area's Use In Address Flag

Scenario: User is updating  Area's Basic Info  page and  entered  value for 'Use in Address' that is different from the current value
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the area basic info link in the navigation bar
When the user clicks on the area update link
When the user gets the document with get document id for area with the <area> from the database
When the user clicks on True option for Area Use in Address
When the user clicks on the save button
Then the user should see the save confirmation modal
When the user clicks on the confirm button
Then the user should see the successful update message at top of the area page
When the user clicks on the area update link
When the user clicks on False option for Area Use in Address
When the user clicks on the save button
Then the user should see the save confirmation modal
Then the user should see the below summary changes in confirmation modal
|Summary|
|Basic Info|
When the user clicks on the confirm button
Then the user should see the successful update message at top of the page
Then the user should see the address flag value same as in zeus document
Then the user reverts the changes to the document

Examples:
|country|area|city|
|Tajikistan|Leninabadskaya Oblast|Gafurov|

Scenario: User is updating  Area's Basic Info  page and  entered  value for 'Use in Address' that is no different from the current value
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the area basic info link in the navigation bar
When the user clicks on the area update link
When the user gets the document with get document id for area with the <area> from the database
When the user clicks on False option for Use in Address
When the user clicks on the save button
Then the user should see the save confirmation modal
When the user clicks on the confirm button
Then the user should see the successful update message at top of the page
When the user clicks on the city update link
When the user clicks on False option for Use in Address
When the user clicks on the save button
Then the user should see the save confirmation modal
Then the user should see no <summary> changes in area save confirmation modal
When the user clicks on the confirm button
Then the user should see the successful update message at top of the page
Then the user reverts the changes to the document

Examples:
|country|area|city|summary|
|Tajikistan|Leninabadskaya Oblast|Gafurov|Basic Info|