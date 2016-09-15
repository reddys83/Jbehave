Meta: @EditAreaRelatedEntity @Edit @Area @AllStories

Narrative:
In order to view and edit the area page
As a user
I want to cover the requirements mentioned in

JIRA ID - ZEUS-1049 - User can edit Area's Related Entities
				 


Scenario: add related entity

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the area entity link in the navigation bar
And the user clicks on the area update link
When the user gets the document with get document id for area with the <area> from the database
When the user deletes all existing related entity rows
And the user clicks on the add button for adding new entity for area page
And the user selects type value as <entityType> in the entity for area
And the user clicks on edit button in entity for area
And the user selects fid value as <fid> in the entity for area
And the user clicks on go button in entity for area
And the user selects details value as <entityDetails> in the entity for area
And the user clicks on the save button
When the user clicks on the confirm button
Then the user should see the successful update message at top of the area page
Then the user should see <entityType> <entity> <entityDetails> updated in area related entity
Then the user reverts the changes to the document

Examples:
|country|area|entityDetails|entityType|fid|entity|
|USA|Alabama|State Government|Banking Association|1038|Bank of America National Association|