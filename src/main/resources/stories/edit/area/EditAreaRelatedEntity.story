Meta: @EditAreaRelatedEntity @Edit @Area @AllStories

Narrative:
In order to view and edit the city page
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
When the user gets the document with get document id for area with the <area> from the database
When the user deletes all existing related entity rows
And the user clicks on the add button for adding new places for area page
When the user clicks on new area entity type drop-down for area
Then the user should see the values for type dropdown from lookup AREA_RELATED_PRESENCE_TYPE
When the user clicks on new area entity details drop-down for area
Then the user should see the values for details dropdown from lookup AREA_RELATED_PRESENCE_SUBTYPE
Then the user reverts the changes to the document

Examples:
|country|area|
|USA|Alabama|

					 
Scenario: Verify whether User is able to see error message "Required" when input values are blank for 'type' field

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the area entity link in the navigation bar
And the user clicks on the area update link

And the user selects type value as <PlaceType> in the places for city
And the user selects details value as <PlaceDetails> in the places for city


And the user clicks on the save button
Then the user should see the error message required for type in places for city
Then the user should see the error message at top of page the highlighted fields must be addressed before this update can be saved

Examples:
|country|area|city|
|Tajikistan|Leninabadskaya Oblast|Gafurov|
