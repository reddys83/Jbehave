Meta:@OfficeMultipleSections @Office

Narrative:
In order to view and edit the legalEntity
As a user
I want to cover the requirements mentioned in
JIRA ID - ZEUS-540 - User can select multiple office sections and view all

Scenario: Verify All sections
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the lagal entity page
And the user clicks on the offices results card with fid <officeFid>
Then the user should see the default office page and display basic info
When the user clicks on the office all link in the navigation bar
Then the user should see the basic info for selected office
And the user should see the offered services for the office
And the user should see the history for the office

Examples:
|entity|searchBy|fid|officeFid|
|Anchor Savings Bank|Name|41031|41031-75|