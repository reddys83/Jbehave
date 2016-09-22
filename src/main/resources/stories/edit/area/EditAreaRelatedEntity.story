Meta: @EditAreaRelatedEntity @Edit @Area @AllStories

Narrative:
In order to view and edit the area page
As a user
I want to cover the requirements mentioned in

JIRA ID - ZEUS-1049 - User can edit Area's Related Entities
		
Scenario: Verify the list of type dropdown are from AREA_RELATED_PRESENCE_TYPE and details dropdown from AREA_RELATED_PRESENCE_SUBTYPE

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the area entity link in the navigation bar
And the user clicks on the area update link
When the user deletes all existing related entity rows
And the user clicks on the add button for adding new entity for area page
When the user clicks on new area entity type drop-down for area
Then the user should see the values for type dropdown from lookup AREA_RELATED_PRESENCE_TYPE
When the user clicks on new area entity details drop-down for area
Then the user should see the values for details dropdown from lookup AREA_RELATED_PRESENCE_SUBTYPE

Examples:
|country|area|
|USA|Alabama|
				 
Scenario: a)Verify whether user is able to add a Area  entity successfully in Area Web page
b)Verify whether user is able to view the added related entity in Zeus Document

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
And the user clicks on the add button for adding new entity for area page
And the user selects type value as <entityType2> in the entity for area
And the user clicks on edit button in second row for entity for area
And the user selects fid value as <fid2> in the entity for area
And the user clicks on go button in entity for area
And the user selects details value as <entityDetails2> in the entity for area
And the user clicks on the save button
When the user clicks on the confirm button
Then the user should see the successful update message at top of the area page
Then the user should see related entity values updated in area related entity
Then the user should see the area related entity values in zeus document
Then the user reverts the changes to the document

Examples:
|country|area|entityDetails|entityType|fid|entity|entityDetails2|entityType2|fid2|entity2|
|USA|Alabama|State Government|Banking Association|1038|Bank of America National Association|State Government|Government|1038|Bank of America National Association|

Scenario: a)Verify whether user is able to update an existing Area Related entity (different to the current value) with same values successfully

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
And the user selects type value as <entityType> in the entity for area
And the user clicks on edit button in entity for area
And the user selects fid value as <fid> in the entity for area
And the user clicks on go button in entity for area
And the user selects details value as <entityDetails> in the entity for area
And the user clicks on the save button
Then the user should see the below summary changes in confirmation modal
|Summary|
|Presences|
When the user clicks on the confirm button
Then the user should see the successful update message at top of the area page
Then the user should see <entityType> <entity> <entityDetails> updated in area related entity
Then the user reverts the changes to the document

Examples:
|country|area|entityDetails|entityType|fid|entity|
|USA|Alabama|State Government|Banking Association|1038|Bank of America National Association|

Scenario: Verify whether No new row is added in Area web page when all the entity fields are having blank values

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
And the user clicks on the save button
When the user clicks on the confirm button
Then the user should see the successful update message at top of the area page
Then the user verifies that no new row is added in area web page
Then the user reverts the changes to the document

Examples:
|country|area|entityDetails|entityType|fid|entity|
|USA|Alabama|State Government|Government|1038|Bank of America National Association|

Scenario: Verify whether User is able to see error message "Required" when input values are blank for 'type','entity','enter a valid fid' fields

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the area entity link in the navigation bar
And the user clicks on the area update link
When the user deletes all existing related entity rows
And the user clicks on the add button for adding new entity for area page
And the user selects details value as <entityDetails> in the entity for area
And the user clicks on the save button
Then the user should see the error message required for type in entity for area
Then the user should see the error message required for entity for area
When the user selects type value as <entityType> in the entity for area
And the user clicks on edit button in entity for area
And the user selects fid value as <fid> in the entity for area
And the user clicks on go button in entity for area
Then the user should see the error message enter a valid fid  for entity for area
Then the user should see the error message at top of page the highlighted fields must be addressed before this update can be saved

Examples:
|country|area|entityDetails|fid|entityType|
|USA|Alabama|State Government|pppp|Government|
|USA|Alabama|State Government|999999|Government|

Scenario: 
a)Verify whether user is able to delete an existing  area Related entity successfully in area Web page
b)Verify whether user is able to view the related entity in area page when 'no' button is clicked in delete confirmation dialog

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
Then the user should see the area related entity values are from trusted document
When the user deletes all existing related entity rows
And the user clicks on the add button for adding new entity for area page
And the user selects type value as <entityType> in the entity for area
And the user clicks on edit button in entity for area
And the user selects fid value as <fid> in the entity for area
And the user clicks on go button in entity for area
And the user selects details value as <entityDetails> in the entity for area
When the user clicks on the delete entity row button in the area entity page
Then the user should see the delete row confirmation modal in the area page
When the user clicks on the no button in the delete row confirmation modal in the area page
Then the user should see the Area entity values in area related entity web page
When the user clicks on the delete entity row button in the area entity page
Then the user should see the delete row confirmation modal in the area page
When the user clicks on the yes button in the delete row confirmation modal in the area page
And the user clicks on the save button
When the user clicks on the confirm button
Then the user should not see the deleted Area Entity values in area entity page
Then the user should see the area related entity values deleted in zeus document
Then the user reverts the changes to the document

Examples:
|country|area|entityDetails|entityType|fid|entity|ConfirmationSummary|
|USA|Alabama|State Government|Government|1038|Bank of America National Association|Summary|

