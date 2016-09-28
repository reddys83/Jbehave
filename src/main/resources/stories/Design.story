Meta:@Design


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

