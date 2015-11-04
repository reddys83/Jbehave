Meta:@OfficePersonnel @Office

Narrative:
In order to view and edit the city
As a user
I want to cover the requirements mentioned in
JIRA ID - ZEUS - 410 - User can view office personnel

Scenario: Verify Office Personnel
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the lagal entity page
And the user clicks on the offices results card with fid <officeFid>
When the user clicks on the office personnel link in the navigation bar

Then the user should see the office's personnel as:
|TYPE|VALUE|
|locationEmployees|0|
|Location Employees|100|

Examples:
|entity|searchBy|fid|officeFid|
|299676|FID|299676|299676-0|

Scenario: Verify no legal entity's personnel
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the lagal entity page
And the user clicks on the offices results card with fid <officeFid>
When the user clicks on the office personnel link in the navigation bar

Then the user should not see the office's personnel

Examples:
|entity|searchBy|fid|officeFid|
|43823|FID|43823|43823-210|