Meta:@OfficeCreditRatings  @Office @View

Narrative:
In order to view and edit the office
As a user
I want to cover the requirements mentioned in
JIRA ID - ZEUS - 411 - User can view office credit ratings

Scenario: Verify office credit ratings  (Office ID - 99f53adf-5c75-400a-9f84-c8a098c3bcf0 )
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
And the user clicks on the office credit ratings link in the navigation bar

Then the user should see the office's credit ratings as:
|AGENCY|TYPE|VALUE|APPLIED DATE|CONFIRMED DATE|
|Standard & Poors|Long Term Rating|A|06 Jan 2015|06 Jan 2015|
|Standard & Poors|Short Term Rating|A-1|06 Jan 2015|06 Jan 2015|

Examples:
|entity|searchBy|fid|officeFid|
|BNP Paribas SA|Name|1568|1568-71|

Scenario: Verify no office credit ratings ( Office ID - cac0b9d5-8043-40d2-80cd-aea4180c74cb )
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
And the user clicks on the office credit ratings link in the navigation bar

Then the user should not see the office's credit ratings

Examples:
|entity|searchBy|fid|officeFid|
|Anchor Savings Bank|Name|41031|41031-1|
