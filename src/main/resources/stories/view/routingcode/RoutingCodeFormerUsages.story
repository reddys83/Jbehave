Meta:@RoutingCodeFormerUsage @RoutingCode @View

Narrative:
In order to view and edit the office
As a user
I want to cover the requirements mentioned in

JIRA ID - ZEUS-1144 - User can view Routing Code Former Usages

Scenario: User is on the Routing Code Doc screen for a routing code - 
Verify that user can view Routing Code's former usages section has a table with below columns in view mode
    1 - NAME
    2 - CITY
    3 - AREA
    4 - ADDITIONAL INFO
    
Given a user is on the search page
When the user selects the <searchBy> from the dropdown
When the user enters the <entity> in the typeahead
And the user clicks on the search button
When the user clicks on the exact match link in the routing code results page
When the user clicks on the search results card with routing code <routingCode> and code type <codeType>
Then the user should see the routing code basic info page
When the user clicks on the former usages link in the navigation bar
Then the user should verify the column names in former usage page

Examples:
|entity|searchBy|routingCode|codeType|
|DAAEDEDD435|Routing Code|DAAEDEDD435|SWIFT BIC|

Scenario: User is on the Routing Code Doc screen for a routing code - 
a) Verify that values in the Name column is in alphabetical order by default.
b) Verify that values in the City and Area column is in alphabetical order after clicking on sort button.

Given a user is on the search page
When the user selects the <searchBy> from the dropdown
When the user enters the <entity> in the typeahead
And the user clicks on the search button
When the user clicks on the exact match link in the routing code results page
When the user clicks on the search results card with routing code <routingCode> and code type <codeType>
Then the user should see the routing code basic info page
When the user clicks on the former usages link in the navigation bar
Then the user verifies that values in name column is in alphabetical order
When the user clicks on sort button for city column
Then the user verifies that values in city column is in alphabetical order
When the user clicks on sort button for area column
Then the user verifies that values in area column is in alphabetical order

Examples:
|entity|searchBy|routingCode|codeType|
|107001119|Routing Code|107001119|ABA|

Scenario: User is on the Routing Code Doc screen for a routing code - 
a) Verify that after clicking on Office Name link, the app is navigated to the corresponding basic info page.

Given a user is on the search page
When the user selects the <searchBy> from the dropdown
When the user enters the <entity> in the typeahead
And the user clicks on the search button
When the user clicks on the exact match link in the routing code results page
When the user clicks on the search results card with routing code <routingCode> and code type <codeType>
Then the user should see the routing code basic info page
When the user clicks on the former usages link in the navigation bar
When the user clicks on the first office name link
Then the user should see the office name basic info page

Examples:
|entity|searchBy|routingCode|codeType|
|DAAEDEDD435|Routing Code|DAAEDEDD435|SWIFT BIC|