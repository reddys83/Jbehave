Meta:@LegalEntityBoardMeetings @LegalEntity

Narrative:
In order to view and edit the legalEntity
As a user
I want to cover the requirements mentioned in
JIRA ID - ZEUS-392 User can view legalEntity board meetings

Scenario: Verify legal entity's board meetings
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the legal entity board meetings link in the navigation bar
Then the user should see the legal entity's summary as Yearly
Then the user should see the legal entity's board meetings as:
|TYPE|VALUE|
|month|3|

Examples:
|entity|searchBy|fid|
|Belvnesheconombank Open Joint Stock Company|Name|1706|

Scenario: Verify the legalEntity has no board meetings
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the legal entity board meetings link in the navigation bar
Then the user should not see the legal entity's summary
And the user should not see the legal entity's board meetings

Examples:
|entity|searchBy|fid|
|Associated Commercial Finance Inc|Name|91832|