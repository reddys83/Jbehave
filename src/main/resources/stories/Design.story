Meta:

Narrative:
In order to view stub entry details
As a user when I search by Name, FID, TFPID and click on the search results card I can view details
I want to cover the requirements mentioned in JIRA ID - Zeus54 - (User can view entity stub entry)

Scenario: search by fid, click on result card and verify values for stub entry
Given a user is on the search page
When the user searches for <entity> with <field> equals <value>
And the user clicks on the card with fid <value>
Then the user is on details page
Then the user can verify that the legal name is <legalName>

Examples:
|entity|field|value|legalName|
|legalEntity|fid|1038|Bank of America National Association|