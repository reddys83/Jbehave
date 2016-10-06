Meta:@EditRoutingCodeBasicInfo @Edit @RoutingCode @AllStories

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal
JIRA ID - ZEUS-1179 - User can select to edit Routing Code's Basic Info
JIRA ID - ZEUS-1476 - User can edit Routing Code Basic Info - Boolean Fields

Scenario: Verify the routing code basic info values in edit mode for ABA and non-ABA code types
Verify the headers and the legal entity link on the header
Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with routing code <routingCode> and code type <codeType>
Then the user should see the routing code basic info page
When the user clicks on the routing code update link
Then the user should see the edit routing code values from trusted document for routing code <routingCode> with code type <codeType>

Examples:
|entity|searchBy|routingCode|codeType|
|083905216|Routing Code|083905216|ABA|
|01056|Routing Code|01056|Swift BIC|
|262176840|Routing Code|262176840|ABA|

Scenario: User is updating Routing Code's Basic Info page - 
a) User verifies whether the current values for Boolean Fields(Account Eligibility, Internal Use Only, Use Head Office) is same as in trusted document.
b) User enters all Boolean Fields different from the current value to verify change in the confirmation modal.
c) User enters all Boolean Fields same as the current value to verify no change in the confirmation modal.
d) User verifies that the Basic Info page and Zeus document is updated correctly.
Meta: @qatest
Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the exact match link in the routing code results page
When the user clicks on the search results card with routing code <routingCode> and code type <codeType>
Then the user should see the routing code basic info page
When the user clicks on the routing code update link
When the user gets the document with get document id for routing code with the <routingCode> and <codeType> from the database
Then the user verifies the boolean field values same as in trusted document
When the user selects <booleanFieldValue> for routing code account eligibility field
When the user selects <booleanFieldValue> for routing code internal use only field
When the user selects <booleanFieldValue> for routing code use head office field
When the user clicks on the save button
Then the user should see the save confirmation modal
And the user should see the below summary changes in confirmation modal
|Summary|
|Basic Info|
When the user clicks on the confirm button
Then the user should be able to verify the boolean field values in routing code basic info page
Then the user should see the boolean field values same as in zeus document
When the user clicks on the routing code update link
When the user selects <booleanFieldValue> for routing code account eligibility field
When the user selects <booleanFieldValue> for routing code internal use only field
When the user selects <booleanFieldValue> for routing code use head office field
When the user clicks on the save button
Then the user should see the save confirmation modal
Then the user should not see the below summary changes in confirmation modal
|Summary|
|Basic Info|
When the user clicks on the confirm button
Then the user should be able to verify the boolean field values in routing code basic info page
Then the user should see the boolean field values same as in zeus document
Then the user reverts the changes to the document

Examples:
|entity|searchBy|routingCode|codeType|booleanFieldValue|
|01056|Routing Code|01056|Swift BIC|false|