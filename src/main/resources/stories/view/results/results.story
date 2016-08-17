Meta:@results @View @AllStories

Narrative:
In order to view search results
As a user I want to cover the requirements mentioned in
JIRA ID - ZEUS-1391- Zeus Menus Re-work #1: 1st Menu Line
JIRA ID - ZEUS-1392- Zeus Menus Re-work #2: Move Legal Entity from DATA to RESULTS

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
|entity|searchBy|fid|
|National Bank|Name|1038|
