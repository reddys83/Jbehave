Meta:@Design

Scenario: Verify Office Results Pagination and Counter
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
When the user clicks on address label for sorting offices
Then the user should see the office search results sorted ascending by addressLine1 from trusted document

Examples:
|entity|searchBy|fid|
|1038|FID|1038|
