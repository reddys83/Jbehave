Meta:@Report

Narrative:
In order to view stub entry details
As a user when I search by Name, FID, TFPID and click on the search results card I can view details
I want to cover the requirements mentioned in
JIRA ID - ZEUS-155 - Code counts

Scenario: Verify Code Count
Meta:@verifyBuild
Given a user is on the search page
When the user clicks on the report tab
Then the user should see the report page
And the user should see the run button disabled in the report page
When the user selects the area as <area> in the report page
Then the user should see the run button disabled in the report page
When the user selects the required match as <requiredMatch> in the report page
And the user clicks on the run button in the report page
Then the user should see the count of the selected criteria as <count> in the report page

Examples:
|area|requiredMatch|count|
|Codes|ABI|814|
|Codes|CHIPS|8301|
