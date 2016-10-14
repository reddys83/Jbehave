Meta:@RoutingCodeFormerUsage @RoutingCode @View

Narrative:
In order to view and edit the office
As a user
I want to cover the requirements mentioned in

JIRA ID - ZEUS-1144 - User can view Routing Code Former Usages

Scenario: User is on the Routing Code page - 
a) Verify that user can view Routing Code's former usages section has a table with below columns in view mode
    1 - NAME
    2 - CITY
    3 - AREA
    4 - ADDITIONAL INFO
b) Verify that values in the Name, City and Area column are in ascending and descending order after clicking on sort button.
c) Verify that after clicking on Office Name link, the app is navigated to the corresponding office basic info page.
   
Given a user is on the search page
When the user selects the <searchBy> from the dropdown
When the user enters the <entity> in the typeahead
And the user clicks on the search button
When the user clicks on the search results card with routing code <routingCode> and code type <codeType>
Then the user should see the routing code basic info page
When the user clicks on the former usages link in the navigation bar
Then the user should verify the column names in former usage page
Then the user verifies that values in name column is in ascending order
When the user clicks on sort button for name column
Then the user verifies that values in name column is in descending order
When the user clicks on sort button for city column
Then the user verifies that values in city column is in ascending order
When the user clicks on sort button for city column
Then the user verifies that values in city column is in descending order
When the user clicks on sort button for area column
Then the user verifies that values in area column is in ascending order
When the user clicks on sort button for area column
Then the user verifies that values in area column is in descending order
When the user clicks on the first office name link
Then the user should see the office name basic info page

Examples:
|entity|searchBy|routingCode|codeType|
|DAAEDEDD435|Routing Code|DAAEDEDD435|SWIFT BIC|