Meta:@RoutingCodeFormerUsage @RoutingCode @View

Narrative:
In order to view and edit the office
As a user
I want to cover the requirements mentioned in
JIRA ID - ZEUS-1144 - User can view Routing Code Former Usages

Scenario: 
a)Verify that User can view Routing Code's former usages section has a table with below colums in view mode
    1 - NAME
    2 - CITY
   3 - AREA
    4 - DESCRIPTION
    5 - ADDITIONAL INFO
b)Verify user can view that there is a sort button for below columns
    1 - NAME
    2 - CITY
    3 - AREA
    
Given a user is on the search page
When the user selects the <searchBy> from the dropdown
When the user enters the <entity> in the typeahead
And the user clicks on the search button
When the user clicks on the search results card with routing code <routingCode> and code type <codeType>
Then the user should see the routing code basic info page
When the user clicks on the former usages link in the navigation bar
Then the user should verify the column names in former usage page


Examples:
|entity|searchBy|routingCode|codeType|
|DAAEDEDD435|Routing Code|DAAEDEDD435|SWIFT BIC|
