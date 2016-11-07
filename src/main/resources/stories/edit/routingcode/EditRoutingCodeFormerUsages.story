Meta:@EditRoutingCodeFormerUsages @Edit @RoutingCode @AllStories

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal
JIRA ID - ZEUS-1195 - User can edit Routing Code's Former Usages

Scenario: User is viewing the Routing Code's Former Usages page in edit mode - 
a) Verify that the Name, City, Area and Additional Info column values are from trusted document.
b) Verify that the add row button is not present in any Former Usages row.
c) Verify that the 'Office Name' field is not a hyperlink.
d) Verify that values in the Name, City and Area column can be in ascending and descending order after clicking on sort button.
e) Verify that there is no change in the confirmation modal after clicking on Save button.
f) Verify that Name column list values is in default order after clicking on confirm button.
Meta: @qatest
Given a user is on the search page
When the user selects the <searchBy> from the dropdown
When the user enters the <entity> in the typeahead
And the user clicks on the search button
When the user clicks on the search results card with routing code <routingCode> and code type <codeType>
When the user deletes the existing former usages values
When the user inserts new former usages values
Then the user should see the routing code basic info page
When the user clicks on the former usages link in the navigation bar
When the user clicks on the routing code update link
Then the user verifies the former usages field values same as in trusted document
Then the user verifies the column names in former usages edit page
Then the user verifies no add row button in former usages edit page
Then the user verifies that the office name is not a hyperlink in former usages edit page
Then the user verifies that values in name column is in ascending order in former usages edit page
When the user clicks on sort button for name column in former usages edit page
Then the user verifies that values in name column is in descending order in former usages edit page
When the user clicks on sort button for city column in former usages edit page
Then the user verifies that values in city column is in ascending order in former usages edit page
When the user clicks on sort button for city column in former usages edit page
Then the user verifies that values in city column is in descending order in former usages edit page
When the user clicks on sort button for area column in former usages edit page
Then the user verifies that values in area column is in ascending order in former usages edit page
When the user clicks on sort button for area column in former usages edit page
Then the user verifies that values in area column is in descending order in former usages edit page
When the user clicks on the save button
Then the user should not see the below summary changes in confirmation modal
|Summary|
|Former Usages|
When the user clicks on the confirm button
Then the user verifies that values in name column is in ascending order

Examples:
|entity|searchBy|routingCode|codeType|
|083905216|Routing Code|083905216|ABA|

Scenario: User is deleting a row in Routing Code's Former Usages page in edit mode -
a) Verify if user can prevent deleting a former usage row("Name", "City", "Area" and "Additional Info") by clicking on 'No' button.
b) Verify if user can delete a former usage row("Name", "City", "Area" and "Additional Info") by clicking on 'Yes' button, then after saving it should be removed.

Given a user is on the search page
When the user selects the <searchBy> from the dropdown
When the user enters the <entity> in the typeahead
And the user clicks on the search button
When the user gets the document with get document id for routing code with the <routingCode> and <codeType> from the database
When the user clicks on the search results card with routing code <routingCode> and code type <codeType>
When the user deletes the existing former usages values
When the user inserts a former usages value for one row
Then the user should see the routing code basic info page
When the user clicks on the former usages link in the navigation bar
When the user clicks on the routing code update link
When the user clicks on the delete former usages row button in the former usages edit page
Then the user should see the delete row confirmation modal in the former usages page
When the user clicks on the no button in the delete row confirmation modal in the routing code former usages page
Then the user should see the newly added former usages row in the former usages edit page
When the user clicks on the delete former usages row button in the former usages edit page
Then the user should see the delete row confirmation modal in the former usages page
When the user clicks on the yes button in the delete row confirmation modal in the routing code former usages page
When the user clicks on the save button
Then the user should see the below summary changes in confirmation modal
|Summary|
|Former Usages|
When the user clicks on the confirm button
Then the user should not see the newly added former usages row in the former usages view page
Then the user verifies that the former usages field values does not exist in zeus document
Then the user reverts the changes to the document

Examples:
|entity|searchBy|routingCode|codeType|
|083905216|Routing Code|083905216|ABA|