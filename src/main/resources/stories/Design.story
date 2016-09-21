Meta:@Design





Scenario: verify the routingCode search results with status filter
Given a user is on the search page
When the user clicks on the results tab
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
And the user applied the status filter active in the routingCode search results
Then the user should see the routing code search results for active status

Examples:
|entity|searchBy|
|001|Routing Code|
