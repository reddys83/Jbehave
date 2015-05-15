Meta:

Narrative:
In order to view stub entry details
As a user when I search by Name, FID, TFPID and click on the search results card I can view details
I want to cover the requirements mentioned in JIRA ID - Zeus54 - (User can view entity stub entry)

Scenario: search by name and verify search results
Given a user is on the search page
When the user searches for <entity> with <field> equals <value>
Then the user should see the search results for the searched entity
And the user should see the number of records displayed in the page w.r.t total search results

Examples:
|entity|field|value|
|legalEntity|name|Banco Continental|