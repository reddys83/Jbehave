Meta: @EditAreaBasicInfo @Edit @area @AllStories

Narrative:
In order to view and edit the area page
As a user
I want to cover the requirements mentioned in

JIRA ID - ZEUS-1025 - User can edit Area's Status

Scenario:  Verify that the Area Status drop-down list should highlight the values that contain characters input by user

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
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
|country|area|
|USA|Georgia|