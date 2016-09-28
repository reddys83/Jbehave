Meta:@Design


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
