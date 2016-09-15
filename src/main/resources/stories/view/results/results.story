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
Then the user should see the search results for routingCode

Examples:
|entity|searchBy|
|001|Routing Code|