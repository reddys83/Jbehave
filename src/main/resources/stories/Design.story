Meta:@Design

Scenario: User can use a combination of filters for office list
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
When the user selects the office status filter active
And the user selects the office type filter domestic
And the user selects the institution type filter Head Office
Then the user should see the office results for the applied filters

Examples:
|entity|searchBy|fid|
|1038|FID|1038|
