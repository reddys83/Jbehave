Meta:@OfficeStatistics  @Office @View @AllStories

Narrative:
In order to view and edit the offices
As a user
I want to cover the requirements mentioned in
JIRA ID - ZEUS - 405 User can view office statistics

Scenario: Verify office statistics  ( Office Id - cac0b9d5-8043-40d2-80cd-aea4180c74cb )
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
When the user clicks on the office statistics link in the navigation bar

Then the user should see the office's statistics as:
|TYPE|VALUE|
|Total ATMs|265|
|Total Checking Accounts|43|
|Total Savings Accounts|1345|

Examples:
|entity|searchBy|fid|officeFid|
|Anchor Savings Bank|Name|41031|41031-75|

Scenario: Verify no statistics  (Office Id - c6458990-e7e7-4155-9024-7af61d55f9e9 )
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
When the user clicks on the office statistics link in the navigation bar

Then the user should see the office's statistics as:
|TYPE|VALUE|
|Total ATMs||
|Total Checking Accounts||
|Total Savings Accounts||

Examples:
|entity|searchBy|fid|officeFid|
|Anchor Savings Bank|Name|41031|41031-5|


Scenario: Verify statistics subsection will be supressed in the Office view if the office is linked to a non-US Entity legal entity.
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
Then the user should see the statistics section not visible for office fid <fid>
When the user clicks on the office all link in the navigation bar
Then the user should not see the statistics section in the All page of the office page

Examples:
|entity|searchBy|fid|officeFid|
|1165|FID|1165|1165-15|

Scenario: Veirfy statistics section will appear in the office view for the entities that will match below criteria:
Legal Entity country of operations is one of the values US, VI, MP, GU, PR, AS
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
Then the user should see the statistics section visible for fid <fid>
When the user clicks on the office all link in the navigation bar
Then the user should see the statistics section in the All page of the office page

Examples:
|entity|searchBy|fid|officeFid|
|1038|FID|1038|1038-0|
|80395|FID|80395|80395-1|
|254972|FID|254972|254972-0|
|254930|FID|254930|254930-0|
|263791|FID|263791|263791-0|
|80399|FID|80399|80399-0|
|223191|FID|223191|223191-0|
