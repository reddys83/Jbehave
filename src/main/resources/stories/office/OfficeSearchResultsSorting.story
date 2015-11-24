Meta:@OfficeSearchResultsSorting @Office

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal
JIRA ID - ZEUS-617 - List offices types alphabetically when multiple for one office

Scenario: Verify the list of office multiple types should order alphabetically in office search results page
Meta:@RunTubati
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page

Then the user should see the multiple office types sorted alphabetically with comma separated for office 113461-1


Examples:
|entity|searchBy|fid|
|Joint Stock Company 'Petersburg Social Commercial Bank'|Name|113461|