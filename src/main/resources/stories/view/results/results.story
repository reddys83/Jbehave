Meta:@results @View @AllStories

Narrative:
In order to view search results
As a user I want to cover the requirements mentioned in
JIRA ID - ZEUS-1391- Zeus Menus Re-work #1: 1st Menu Line
JIRA ID - ZEUS-1392- Zeus Menus Re-work #2: Move Legal Entity from DATA to RESULTS
JIRA ID - ZEUS-1393- Zeus Menus Re-work #3: Move OFFICES to 2nd line
JIRA ID - ZEUS-1132- User can search for a routingCode (Exact Match)

Scenario: Verify the results tab shows the legal entity results when search for a legal entity
Given a user is on the search page
When the user clicks on the results tab
Then the user should see results tab is selected
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
Then the user should see the search results for the institution
When the user clicks on the data tab in the search page
And the user clicks on the results tab
Then the user should see the same results of the previous search


Examples:
|entity|searchBy|
|National Bank|Name|


Scenario: Verify that user can navigate to results, Legal Entity, All Offices and Office pages.
Given a user is on the search page
When the user clicks on the results tab
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
Then the user should see the search results for the institution
When the user clicks on the search results card with fid <fid>
Then the user should see Legal Entity menu is selected in the 2nd line
When the user clicks on the offices link in the legal entity page
Then the user should see All Offices link is selected
And the user should see the label offices on the results list page
When the user clicks on the offices results card with fid <officeFid>
Then the user should see the offices tab in the office page
When the user clicks on the offices link in the legal entity page
Then the user should see All Offices link is selected
And the user should see the label offices on the results list page
And the user should not see the office tab in the office page
When the user clicks on the legal entity tab in the data area
Then the user should see Legal Entity menu is selected in the 2nd line
When the user clicks on the results tab
Then the user should see the same results of the previous search

Examples:
|entity|searchBy|fid|officeFid|
|1010|FID|1010|1010-44|


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







