Meta:@Design



Scenario: verify the routingCode search results with EXACT MATCH
Given a user is on the search page
When the user clicks on the results tab
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
Then the user should see the search results for <entity> routingCode

Examples:
|entity|searchBy|
|001|Routing Code|
|00!@#$%^&*(6|Routing Code|
|qa|Routing Code|


Scenario: Verify error message for atlease two characters
Given a user is on the search page
When the user clicks on the results tab
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
Then the user should see the error message enter at least 2 valid characters in routing search results

Examples:
|entity|searchBy|
|!@#$%0|Routing Code|

Scenario: Verify message for 0 search results for routingCode
Given a user is on the search page
When the user clicks on the results tab
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
Then the user should see the message for 0 search results in routingCode search results

Examples:
|entity|searchBy|
|0023498|Routing Code|


Scenario: Verify the FID navigate to office in routing Code search results
Given a user is on the search page
When the user clicks on the results tab
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
Then the user should see the search results for <entity> routingCode
When the user clicks on <fid> in the routing search results

Then the user should see the basic info for selected office
Then the user should see the office names for <officeFid> in the office basic info

Examples:
|entity|searchBy|fid|
|01065|Routing Code|186-99|


Scenario: Verify the FID navigate to legalEntity in routing Code search results
Case 1: When routingCode does not have any usageLocations
Case 2: When routingCode had usageLocation @primaryAssignee= 'false'
Given a user is on the search page
When the user clicks on the results tab
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
Then the user should see the search results for <entity> routingCode
When the user clicks on <fid> in the routing search results

Then the user should see the basic info label for selected legal entity
And the user should see the legalEntity names for <fid> in the legalEntity basic info

Examples:
|entity|searchBy|fid|
|001|Routing Code|494|
|001|Routing Code|4275|

Scenario: verify the routingCode search results with country filter
Given a user is on the search page
When the user clicks on the results tab
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
And the user applied the country filter as:
|Country|
|Korea (Republic of)|
|Timor-Leste|

Then the user should see the routingCode search results for selected country as:
|Country|
|Korea (Republic of)|
|Timor-Leste|

Examples:
|entity|searchBy|
|001|Routing Code|

Scenario: verify the routingCode search results with type filter
Given a user is on the search page
When the user clicks on the results tab
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
And the user applied the type filter as:
|Type|
|HNRN4|
|CLRN|

Then the user should see the routingCode search results for selected type as:
|Type|
|HNRN4|
|CLRN|

Examples:
|entity|searchBy|
|001|Routing Code|


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

Scenario: Verify user can resort the results by 'CODE'
Given a user is on the search page
When the user clicks on the results tab
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
Then the user should see the search results for <entity> routingCode
When the user clicks on the column CODE in the routingCode search results
Then user should see the results in descending order for <entity> routingCode

Examples:
|entity|searchBy|
|qa|Routing Code|

