Meta:@Design

Scenario: Bug:ZEUS-930- LegalEntity search results are not showing up
Given a user is on the search page
When the user searches for <entity> with <field> equals <value>

Then the user should see the legal entity search results card matching the searched entity
|FID|TFPID|NAME|ADDRESS|STATUS|
|224355||American Life Hayat Sigorta AS||active|

Then the user should see the search results paginated for the searched entity
And the user should see the number of records displayed in the page w.r.t total search results

Examples:
|entity|field|value|
|fid|fid|224355|