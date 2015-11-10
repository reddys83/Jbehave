Meta:@OfficeSearchResults @Office

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal
JIRA ID - ZEUS-430 - User view list of offices in legal entity

Scenario: Verify Office Results
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
Then the user should see the office search results card for the search legal entity
|ID|NAME|ADDRESS|CITY|AREA|COUNTRY|TYPE|STATUS|
|951-0|Flughofstrasse|Flughofstrasse 35|Glattbrugg|Zürich|Switzerland|Head Office|active|
|951-4|Flughofstrasse|Flughofstrasse 35|Glattbrugg|Zürich|Switzerland|Head Office Branch|active|

Then the user should see the office search results paginated

Examples:
|entity|searchBy|fid|officeFid|
|951|FID|951|41031-75|

