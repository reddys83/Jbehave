Meta:@RoutingCodeRelatedCodes @RoutingCode @View

Narrative:
In order to view and edit the office
As a user
I want to cover the requirements mentioned in
JIRA ID - ZEUS-1142 - User can view Routing Code Related Codes

Scenario: Verify RoutingCode related codes
Meta:@test6767
Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with routing code <routingCode> and code type <codeType>
And the user clicks on the routing code related codes link in the navigation bar
Then the user should see the related codes for routingCode <routingCode> and code type <codeType>

Examples:
|entity|searchBy|routingCode|codeType|
|77390628|Routing Code|77390628|BLZ (DE)|

Scenario: Verify there are no related codes for routingCodes
Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with routing code <routingCode> and code type <codeType>
And the user clicks on the routing code related codes link in the navigation bar
Then the user should not see related codes for routingCode <routingCode> and code type <codeType>

Examples:
|entity|searchBy|routingCode|codeType|
|006|Routing Code|006|GNRN|
