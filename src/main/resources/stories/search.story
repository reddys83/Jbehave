Meta:

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario: search for an arbitrary entity and verify values
Given a user is on the search page
When the user searches for an arbitrary <entity>
Then the results should appear correctly

Examples:    
|entity|
|legalEntity|

Scenario: search by finid and verify values
Given a user is on the search page
When the user searches for <entity> with <field> equals <value>
Then the results should appear correctly

Examples:    
|entity|field|value|
|legalEntity|fid|1038|

Scenario: search by finid and verify no values
Given a user is on the search page
When the user searches for <entity> with <field> equals <value>
Then there should be no results

Examples:
|entity|field|value|
|legalEntity|fid|asdf|

Scenario: search by finid and verify tfpid does not exist
Given a user is on the search page
When the user searches for <entity> with <field> equals <value>
Then the results should appear correctly

Examples:
|entity|field|value|
|legalEntity|fid|149816|

Scenario: search by finid and verify the status is inactive
Given a user is on the search page
When the user searches for <entity> with <field> equals <value>
Then the results should appear correctly

Examples:
|entity|field|value|
|legalEntity|fid|15415|