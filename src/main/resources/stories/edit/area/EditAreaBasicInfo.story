Meta: @EditAreaBasicInfo @Edit @Area @AllStories


Narrative:
In order to view and edit the area page
As a user
I want to cover the requirements mentioned in

JIRA ID - ZEUS-1025 - User can edit Area's Status
JIRA ID - ZEUS-1027 - User can edit Area's End Date

JIRA ID - ZEUS-1026 - User can edit Area's Began Date


Scenario: User can edit  'Interest Rate Limit' that is different from the current value
a)User verifies 'Your Changes have been saved' message is displayed after save
b) User verifies whether updated 'Interest Rate Limit; is reflecting in Area Web page
c)User verifies whether updated 'Interest rate limit' is reflecting in zeus document


Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
When the user clicks on the area basic info link in the navigation bar
And the user clicks on the area update link
When the user gets the document with get document id for area with the <area> from the database
When the user enters <interestRate> value in area page
When the user clicks on the save button
When the user clicks on the confirm button
Then the user should see the successful update message at top of the area page
Then the user should see the entered <interestRate> in area page
When the user clicks on the area update link
When the user enters <interestRateNew> value in area page
When the user clicks on the save button
When the user clicks on the confirm button
Then the user should see the entered <interestRate> in area page
Then the user should see the entered <interestRate> in zeus document
Then the user reverts the changes to the document

Examples:
|country|area|interestRate|interestRateNew|
|Angola|Cabinda|10|15|