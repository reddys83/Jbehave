Meta:@OfficeMultipleSections @Office @View

Narrative:
In order to view and edit the legalEntity
As a user
I want to cover the requirements mentioned in
JIRA ID - ZEUS-540 - User can select multiple office sections and view all
JIRA ID - ZEUS-605 - make grey headers consistent on view screens

Scenario: Verify All sections
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user navigates to the 4th page on the office search results
And the user clicks on the offices results card with fid <officeFid>
Then the user should see the default office page and display basic info
When the user clicks on the office all link in the navigation bar
Then the user should see the basic info for selected office
And the user should see the offered services for the office
And the user should see the history for the office
And the user should see the identifiers for the office
And the user should see the personnel for the office

Examples:
|entity|searchBy|fid|officeFid|
|Anchor Savings Bank|Name|41031|41031-75|

Scenario: Verify multiple sections
Meta:
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
And the user clicks on the office history link in the navigation bar

Then the user should see the office's history as:
|SUMMARY|
|Holds a free-text summarisation of the events that have affected this office. Bank was formed blah-di-blah|

When the user clicks on the office personnel link in the navigation bar

Then the user should see the office's personnel as:
|TYPE|VALUE|
|locationEmployees|0|
|Location Employees|100|

When the user clicks on the office personnel link in the navigation bar
Then the user should not see the personnel section for the office

Examples:
|entity|searchBy|fid|officeFid|
|299676|FID|299676|299676-0|

Scenario: Verify All sections
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user navigates to the 4th page on the office search results
And the user clicks on the offices results card with fid <officeFid>
Then the user should see the default office page and display basic info
When the user clicks on the office basic info link in the navigation bar
And the user clicks on the office locations link in the navigation bar
And the user clicks on the office services link in the navigation bar
And the user clicks on the office credit ratings link in the navigation bar
And the user clicks on the office statistics link in the navigation bar
And the user clicks on the office history link in the navigation bar
And the user clicks on the office identifier link in the navigation bar
And the user clicks on the office personnel link in the navigation bar
Then the user should see the basic info for selected office
And the user should see the offered services for the office
And the user should see the credit ratings for the office
And the user should see the statistics for the office
And the user should see the history for the office
And the user should see the identifiers for the office
And the user should see the personnel for the office
Then the user should see all is selected by default in the navigation bar

Examples:
|entity|searchBy|fid|officeFid|
|Anchor Savings Bank|Name|41031|41031-75|