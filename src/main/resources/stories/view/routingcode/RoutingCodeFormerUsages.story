Meta:@RoutingCodeFormerUsage @RoutingCode @View

Narrative:
In order to view and edit the office
As a user
I want to cover the requirements mentioned in

JIRA ID - ZEUS-1144 - User can view Routing Code Former Usages
JIRA ID - ZEUS-1670 - Office Title for Office Name in View Routing Code (Former) Usages

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
When the user gets the document with get document id for routing code with the <routingCode> and <codeType> from the database
When the user clicks on the search results card with routing code <routingCode> and code type <codeType>
When the user deletes the existing former usages values
When the user inserts new former usages values
Then the user should see the routing code basic info page
When the user clicks on the former usages link in the navigation bar
Then the user should see the former usages field values same as in trusted document
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
When the user clicks on sort button for name column
When the user clicks on the office name link number <index>
Then the user should see the office basic info page
Then the user reverts the changes to the document

Examples:
|entity|searchBy|routingCode|codeType|index|
|DAAEDEDD435|Routing Code|DAAEDEDD435|SWIFT BIC|1|

Scenario: User is on the Routing Code page - 
a) Verify that Routing Code's former usages section has a table with values for below colums in view mode which is same as in trusted document.
   1 - NAME
   2 - CITY
   3 - AREA
   4 - ADDITIONAL INFO
b) Verify the Office Title for Office name in the Former Usages page for the following conditions:
   1. Office's override field is the Office title when override is not null.
   2. Prefix is prepended and suffix is appended with space with the Legal Title when override is null and either suffix or prefix is not null.
   3. Legal Title is the Office title when routing code institution and office institution link is not same, provided Office's override is null.
   4. Office Name is the Office title when routing code institution and office institution link is same, provided Office's override is null.

Given a user is on the search page
When the user selects the <searchBy> from the dropdown
When the user enters the <entity> in the typeahead
And the user clicks on the search button
When the user clicks on the search results card with routing code <routingCode> and code type <codeType>
Then the user should see the routing code basic info page
When the user clicks on the former usages link in the navigation bar
Then the user should see the former usages office name same as in trusted document

Examples:
|entity|searchBy|routingCode|codeType|
|77390628|Routing Code|77390628|BLZ (DE)|
|001|Routing Code|001|AF Cheque Clearing Sys|
|01056|Routing Code|01056|Swift BIC|
|HLFXGB21K03|Routing Code|HLFXGB21K03|SWIFT BIC|
|262176840|Routing Code|262176840|ABA|