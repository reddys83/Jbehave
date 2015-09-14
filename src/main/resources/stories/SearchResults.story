Meta:@SearchResults

Narrative:
As a user
I want to see the results for the searched entity
So that I can view the information I am looking for
JIRA ID - ZEUS-123

Scenario: search by name and verify search results
Given a user is on the search page
When the user searches for <entity> with <field> equals <value>
Then the user should see the search results for the searched entity
And the user should see the number of records displayed in the page w.r.t total search results

Examples:
|entity|field|value|
|legalEntity|name|Banco Continental|
|legalEntity|name|Bank of Montreal|
|legalEntity|name|First National Bank|

Scenario: search by name and navigate through different search results
Meta:@verifyBuild
Given a user is on the search page
When the user searches for <entity> with <field> equals <value>
Then the user should see the option to navigate to the desired page
When the user navigates to the 4th search results page
Then the user should see the search results for the searched entity
Then the user should see the option to navigate to the desired page
When the user navigates to the last search results page
Then the user should see the search results for the searched entity
Then the user should see the option to navigate to the desired page

Examples:
|entity|field|value|
|legalEntity|name|First National Bank|

Scenario: search by name and navigate through different search results
Given a user is on the search page
When the user searches for <entity> with <field> equals <value>
Then the user should see the option to navigate to the desired page
When the user navigates to the 5th search results page
Then the user should see the search results for the searched entity
Then the user should see the option to navigate to the desired page
When the user navigates to the last search results page
Then the user should see the search results for the searched entity
Then the user should see the option to navigate to the desired page

Examples:
|entity|field|value|
|legalEntity|name|First National Bank|

Scenario: search by name and verify no search results
Given a user is on the search page
When the user searches for <entity> with <field> equals <value>
Then the user should see the option to navigate to the desired page
When the user navigates to the 5th search results page
Then the user should see the search results for the searched entity
Then the user should see the option to navigate to the desired page
When the user navigates to the last search results page
Then the user should see the search results for the searched entity
Then the user should see the option to navigate to the desired page

Examples:
|entity|field|value|
|legalEntity|name|First National Bank|

Scenario: search by name and verify no search results
Given a user is on the search page
When the user searches for <entity> with <field> equals <value>
Then the user should see no results found message

Examples:
|entity|field|value|
|legalEntity|name|bank of greece|

Scenario: search by name and navigate to search results pages using Previous/Next link
Given a user is on the search page
When the user searches for <entity> with <field> equals <value>
And the user clicks on the next page link
Then the user should see the search results for the searched entity
When the user clicks on the previous page link
Then the user should see the search results for the searched entity

Examples:
|entity|field|value|
|legalEntity|name|First National Bank|
