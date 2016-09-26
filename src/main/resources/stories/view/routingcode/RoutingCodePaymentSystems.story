Meta:@RoutingCodePaymentSystems @RoutingCode @View

Narrative:
In order to view and edit the office
As a user
I want to cover the requirements mentioned in
JIRA ID - ZEUS-1134 - User can view Routing Code Basic Info

Scenario: Verify the basic info for a routing code of type ABA
Verify the headers and the legal entity link on the header

Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with routing code <routingCode> and code type <codeType>
When the user clicks on payment systems section
Then the user should see the routing code payment system values from Trusted document for routing code <routingCode> with code type <codeType>

Examples:
|entity|searchBy|routingCode|codeType|
|HLFXGB21K03|Routing Code|HLFXGB21K03|SWIFT BIC|