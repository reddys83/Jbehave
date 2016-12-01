Meta:@EditRoutingCodeHistory @RoutingCode @View

Narrative:
In order to view and edit the office
As a user
I want to cover the requirements mentioned in

JIRA ID - ZEUS-1196 - User can edit Routing Code History


Scenario: User is on the Routing Code page -
a)Verify the values for below fields in table are from trusted doc in view mode
	Type, Date, Description, Replaced By Code, Details, Name, Address, City, Area, Sub Area, Country, Postal Code, Additional Info
b)User should verify whether default sort for the event is by 'Date' (newest first top to bottom)
c)User verifies 'N/A is displayed under Details Column, then there is no historic usages associated with this event.
d)User verifies 'Eye' icon is displayed under Details Column, then there are historic usages associated with this event.

Given a user is on the search page
When the user selects the <searchBy> from the dropdown
When the user enters the <entity> in the typeahead
And the user clicks on the search button
When the user clicks on the search results card with routing code <routingCode> and code type <codeType>
When the user clicks on the history link in the navigation bar
When the user clicks on the routing code update link
When the user gets the document with get document id for routing code with the <routingCode> and <codeType> from the database
Then the user should see the history field values same as in trusted document
When the user clicks on the delete services row button in the routing code history page
Then the user should see the delete row confirmation modal in the routingCode page
When the user clicks on the yes button in the delete row confirmation modal in the routingCode page
When the user clicks on the save button
When the user clicks on the confirm button
Then the user should see the history field values same as in trusted document
Then the user reverts the changes to the document

Examples:
|entity|searchBy|routingCode|codeType|
|083905216|Routing Code|083905216|ABA|