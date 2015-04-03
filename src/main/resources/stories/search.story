Meta:

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario: search by finid and verify values
Given a user is on the search page
When the user searches for <entity> with <field> equals <value>
Then the results should appear correctly
|name|address|fid|tfpid|status|
|Bank of America NA|100 N Tryon St, Ste 170|1038|10077420|Active|

Examples:    
|entity|field|value|
|legalEntity|FID|1038|

Scenario: search by finid and verify no values
Given a user is on the search page
When the user searches for <entity> with <field> equals <value>
Then there should be no results
|result|
|No results found|

Examples:
|entity|field|value|
|legalEntity|FID|asdf|

Scenario: search by finid and verify tfpid does not exist
Given a user is on the search page
When the user searches for <entity> with <field> equals <value>
Then the results should appear correctly
|name|address|fid|tfpid|status|
|Embecca Properties (PVT) Ltd||149816||Active

Examples:
|entity|field|value|
|legalEntity|FID|149816|

Scenario: search by finid and verify the status is inactive
Given a user is on the search page
When the user searches for <entity> with <field> equals <value>
Then the results should appear correctly
|name|address|fid|tfpid|status|
|Crystal River Bank|PO Box 607, 865 North East Highway 19|15415||Inactive

Examples:
|entity|field|value|
|legalEntity|FID|15415|