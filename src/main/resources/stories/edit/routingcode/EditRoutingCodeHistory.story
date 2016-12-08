Meta:@EditRoutingCodeHistory @RoutingCode @View

Narrative:
In order to view and edit the office
As a user
I want to cover the requirements mentioned in

JIRA ID - ZEUS-1196 - User can edit Routing Code History


Scenario: User is on the Routing Code page -
a)Verify history events are deleted from zeus web page and marklogic when 'Yes' button is clicked
b)Verify history events are not deleted from zeus web page when no button is clicked
c)Verify delete button is enabled when eye icon is clicked
d)Verify delete confirmation message is available when eye icon is clicked

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
Then the user should see the history field values not deleted from the history web page
When the user clicks on the delete history row button in the routing code history page
Then the user should see the delete row confirmation modal in the routingCode page
When the user clicks on the yes button in the delete row confirmation modal in the routingCode page
When the user clicks on the save button
When the user clicks on the confirm button
Then the user should see the history field values deleted from the history web page
Then the use should see the history field values are deleted from trusted document
When the user clicks on the routing code update link
When the user clicks on the eye icon in first row to open the drawer
Then the user should verify that delete button is enabled
When the user clicks on the delete history row button in the routing code history page
Then the user should see the delete row confirmation modal in the routingCode page

Examples:
|entity|searchBy|routingCode|codeType|historyType|historyDate|
|083905216|Routing Code|083905216|ABA|Reinstatement|09 Aug 2013|