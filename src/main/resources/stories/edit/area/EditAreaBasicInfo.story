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
And the user enters the <area> in the type-ahead box
And the user clicks on the area basic info link in the navigation bar
And the user clicks on the area update link
When the user clicks on True option for Area Use in Address
When the user clicks on the save button
Then the user should see the save confirmation modal
When the user clicks on the confirm button
Then the user should see the successful update message at top of the area page
When the user clicks on the update link
When the user clicks on False option for Area Use in Address
When the user clicks on the save button
Then the user should see the save confirmation modal
Then the user should see the below summary changes in confirmation modal
|Summary|
|Basic Info|
When the user clicks on the confirm button
Then the user should see the successful update message at top of the area page
Then the user should see the updated <useInAddress> in area web page
Then the user should see updated Use in address value in zeus document

Examples:
|country|area|useInAddress|
|Angola|Bengo|False|

Scenario: User is updating  Area's Basic Info  page and  entered  value for 'Use in Address' that is no different from the current value
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the <area> in the type-ahead box
And the user clicks on the area basic info link in the navigation bar
And the user clicks on the area update link
When the user clicks on True option for Area Use in Address
When the user clicks on the save button
Then the user should see the save confirmation modal
When the user clicks on the confirm button
Then the user should see the successful update message at top of the page
When the user clicks on the city update link
When the user clicks on True option for Area Use in Address
When the user clicks on the save button
Then the user should see the save confirmation modal
Then the user should not see the <ConfirmationSummary> changes in confirmation modal for area
When the user clicks on the confirm button
Then the user should see the successful update message at top of the page
Then the user should see the updated <useInAddress> in area web page

Examples:
|country|area|useInAddress|
|Angola|Bengo|True|
