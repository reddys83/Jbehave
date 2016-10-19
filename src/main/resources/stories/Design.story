Meta:@Desig


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
When the user clicks on 186-99 in the routing search results

Then the user should see the basic info for selected office
Then the user should see the office names for <officeFid> in the office basic info

Examples:
|entity|searchBy|officeFid|
|01065|Routing Code|186-99|


Scenario: Verify the FID navigate to legalEntity in routing Code search results
Case 1: When routingCode does not have any usageLocations
Given a user is on the search page
When the user clicks on the results tab
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
Then the user should see the search results for <entity> routingCode
When the user clicks on 494 in the routing search results

Then the user should see the basic info label for selected legal entity

And the user should see the legal entity's names as:
|TYPE|VALUE|
|Legal Title|Banco Central de Venezuela|
|Marketing Name|BCV|

Examples:
|entity|searchBy|
|001|Routing Code|


Scenario: Verify the FID navigate to legalEntity in routing Code search results
Case 2: When routingCode had usageLocation @primaryAssignee= 'false'
Given a user is on the search page
When the user clicks on the results tab
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
Then the user should see the search results for <entity> routingCode
When the user clicks on 4275 in the routing search results

Then the user should see the basic info label for selected legal entity

And the user should see the legal entity's names as:
|TYPE|VALUE|
|Legal Title|Standard Chartered Bank|
|Former Name|First Interstate International of California - Miami|

Examples:
|entity|searchBy|
|001|Routing Code|


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

Scenario: User is updating a City's Basic Info and has set values for each of 'Country', 'Area' and 'Sub Area
1 - User adds two sub areas and verify Zeus DB is updating with two sub area

Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with routing code <routingCode> and code type <codeType>
And the user clicks on the routingCode usages link in the navigation bar
Then the user should see the usages for routingCode <routingCode> and code type <codeType>

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

