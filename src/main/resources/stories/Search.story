Meta:@Search

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario: search by finid and verify values
Given a user is on the search page
When the user searches for <entity> with <field> equals <value>
Then the user should see the search results for the searched entity

Examples:    
|entity|field|value|
|legalEntity|fid|1038|

Scenario: search by finid and verify no values
Given a user is on the search page
When the user searches for <entity> with <field> equals <value>
Then the user should see no results found message

Examples:
|entity|field|value|
|legalEntity|fid|asdf|

Scenario: search by finid and verify tfpid does not exist
Given a user is on the search page
When the user searches for <entity> with <field> equals <value>
Then the user should see the search results for the searched entity

Examples:
|entity|field|value|
|legalEntity|fid|149816|

Scenario: search by finid and verify the status is inactive
Given a user is on the search page
When the user searches for <entity> with <field> equals <value>
Then the user should see the search results for the searched entity

Examples:
|entity|field|value|
|legalEntity|fid|15415|