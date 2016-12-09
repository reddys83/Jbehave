Meta:@EditRoutingCodeHistory @RoutingCode @View

Narrative:
In order to view and edit the office
As a user
I want to cover the requirements mentioned in

JIRA ID - ZEUS-1196 - User can edit Routing Code History

Scenario: User is on the Routing Code page -
a)existing history event values should be present in the trusted document
b)verify whether default sort for the event is by 'Date' (newest first top to bottom)

Given a user is on the search page
When the user selects the <searchBy> from the dropdown
When the user enters the <entity> in the typeahead
And the user clicks on the search button
When the user clicks on the search results card with routing code <routingCode> and code type <codeType>
When the user clicks on the history link in the navigation bar
When the user clicks on the routing code update link
Then the user should see the history field values same as in trusted document
Then the user verifies that values in date column is in descending order

Examples:
|entity|searchBy|routingCode|codeType|
|083905216|Routing Code|083905216|ABA|

Scenario: User is on the Routing Code page -
a)Verify history events are deleted from zeus web page and marklogic when 'Yes' button is clicked
b)Verify history events are not deleted from zeus web page when no button is clicked

Given a user is on the search page
When the user selects the <searchBy> from the dropdown
When the user enters the <entity> in the typeahead
And the user clicks on the search button
When the user clicks on the search results card with routing code <routingCode> and code type <codeType>
When the user clicks on the history link in the navigation bar
When the user gets the document with get document id for routing code with the <routingCode> and <codeType> from the database
When the user clicks on the routing code update link
When the user clicks on the delete history row button in the routing code history page
When the user clicks on the no button in the delete row confirmation modal in the routingCode page
Then the user should see the history field values not deleted from the history web page
When the user clicks on the delete history row button in the routing code history page
Then the user should see the delete row confirmation modal in the routingCode page
When the user clicks on the yes button in the delete row confirmation modal in the routingCode page
When the user clicks on the save button
When the user clicks on the confirm button
Then the user should see the history field values deleted from the history web page
Then the use should see the history field values are deleted from zeus document
Then the user reverts the changes to the document

Examples:
|entity|searchBy|routingCode|codeType|historyType|historyDate|
|083905216|Routing Code|083905216|ABA|Reinstatement|09 Aug 2013|

Scenario: User is on the Routing Code page -
a)Verify delete button is enabled when eye icon is clicked
b)Verify delete confirmation message is available when eye icon is clicked

Given a user is on the search page
When the user selects the <searchBy> from the dropdown
When the user enters the <entity> in the typeahead
And the user clicks on the search button
When the user clicks on the search results card with routing code <routingCode> and code type <codeType>
When the user clicks on the history link in the navigation bar
When the user clicks on the routing code update link
When the user clicks on the delete history row button in the routing code history page
Then the user should see the eye icon enabled
Then the user should see the delete row confirmation modal in the routingCode page
When the user clicks on the no button in the delete row confirmation modal in the routingCode page
When the user clicks on the eye icon in first row to open the drawer
Then the user should verify that delete button is enabled
When the user clicks on the delete history row button in the routing code history page
Then the user should see the delete row confirmation modal in the routingCode page

Examples:
|entity|searchBy|routingCode|codeType|
|083905216|Routing Code|083905216|ABA|