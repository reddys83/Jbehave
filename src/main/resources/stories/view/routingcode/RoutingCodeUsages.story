Meta:@RoutingCodeUsages @RoutingCode @View

Narrative:
In order to view and edit the office
As a user
I want to cover the requirements mentioned in
JIRA ID - ZEUS-1143 - User can view Routing Code current usages

Scenario: Verify the usages for a routing code
Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with routing code <routingCode> and code type <codeType>
And the user clicks on the routingCode usages link in the navigation bar
Then the user should see the usages for routingCode <routingCode> and code type <codeType>

Examples:
|entity|searchBy|routingCode|codeType|
|DAAEDEDD435|Routing Code|DAAEDEDD435|SWIFT BIC|
|001|Routing Code|001|AF Cheque Clearing Sys|


Scenario: Verify the user can resort the usages by 'Name'
Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with routing code <routingCode> and code type <codeType>
And the user clicks on the routingCode usages link in the navigation bar
And the user clicks on name column in the routingCode usages
Then the user should see the usages sort descending order by name for routingCode <routingCode> and code type <codeType>

Examples:
|entity|searchBy|routingCode|codeType|
|DAAEDEDD435|Routing Code|DAAEDEDD435|SWIFT BIC|

Scenario: Verify the user can resort the usagse by 'city'
Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with routing code <routingCode> and code type <codeType>
And the user clicks on the routingCode usages link in the navigation bar
And the user clicks on city column in the routingCode usages
Then the user should see the usages sort ascending order by city for routingCode <routingCode> and code type <codeType>

Examples:
|entity|searchBy|routingCode|codeType|
|DAAEDEDD435|Routing Code|DAAEDEDD435|SWIFT BIC|



Scenario: Verify the user can resort the usagse by 'city'
Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with routing code <routingCode> and code type <codeType>
And the user clicks on the routingCode usages link in the navigation bar
And the user clicks on area column in the routingCode usages
Then the user should see the usages sort ascending order by area for routingCode <routingCode> and code type <codeType>

Examples:
|entity|searchBy|routingCode|codeType|
|DAAEDEDD435|Routing Code|DAAEDEDD435|SWIFT BIC|

Scenario: Verify the user redirected to office page with the click on office link
Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with routing code <routingCode> and code type <codeType>
And the user clicks on the routingCode usages link in the navigation bar
And the user click on office Brandenburger Str in the routingCode usages
Then the user should see the office names for <officeFid> in the office basic info

Examples:
|entity|searchBy|routingCode|codeType|officeFid|
|DAAEDEDD435|Routing Code|DAAEDEDD435|SWIFT BIC|2336-4|
