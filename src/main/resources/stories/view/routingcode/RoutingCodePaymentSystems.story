Meta:@RoutingCodePaymentSystems @RoutingCode @View

Narrative:
In order to view and edit the office
As a user
I want to cover the requirements mentioned in
JIRA ID - ZEUS-1136 - User can view Routing Code Payment Systems

Scenario: Verify the payment systems view for different types of routing codes
a) ABA
b) SWIFT BIC
C) SWIFT BIC (ZEUS-1610) - Unable to view one of the Routing code 01056)
Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with routing code <routingCode> and code type <codeType>
When the user clicks on payment systems section
Then the user should see the routing code payment system values from trusted document for routing code <routingCode> with code type <codeType>

Examples:
|entity|searchBy|routingCode|codeType|
|083905216|Routing Code|083905216|ABA|
|HLFXGB21K03|Routing Code|HLFXGB21K03|SWIFT BIC|
|01056|Routing Code|01056|Swift BIC|