Meta:@EditRoutingCodeBasicInfo @Edit @RoutingCode @AllStories

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal
JIRA ID - ZEUS-1179 - User can select to edit Routing Code's Basic Info
JIRA ID - ZEUS-1474 - User can edit Routing Code Basic Info - Text Fields


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

Scenario: Verify whether User saves 'Registrar Fee SFDC Subscription Number' & 'Routing Code Comment' are saved successfully in routing code page

Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with routing code <routingCode> and code type <codeType>
Then the user should see the routing code basic info page
When the user clicks on the routing code update link
Then the user should see <registarFeeSFDCSubscription> and <routingCodeComment> field values same as in trusted document
When the user enters the <registarFeeSFDCSubscription> in the routing code basic info page
When the user enters the <routingCodeComment> in the routing code basic info page
And the user clicks on the save button
When the user clicks on the confirm button
Then the user should see the successful update message at top of the routing code page
Then the user should be able to verify the values are entered in the routing code basic info page
Then the user should see the <registarFeeSFDCSubscription> and <routingCodeComment> field values same as in zeus document

Examples:
|entity|searchBy|routingCode|codeType|registarFeeSFDCSubscription|routingCodeComment|
|083905216|Routing Code|083905216|ABA|408123|Sample Text|

Scenario: Verify whether User can update (no different to current value) 'Registrar Fee SFDC Subscription Number' & 'Routing Code Comment' successfully in routing code page

Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with routing code <routingCode> and code type <codeType>
Then the user should see the routing code basic info page
When the user clicks on the routing code update link
When the user gets the document with get document id for routing code with the <routingCode> and <codeType> from the database
When the user enters the <registarFeeSFDCSubscription> in the routing code basic info page
When the user enters the <routingCodeComment> in the routing code basic info page
And the user clicks on the save button
Then the user should not see the below summary changes in confirmation modal
|Summary|
|Basic Info|
When the user clicks on the confirm button
Then the user should see the successful update message at top of the routing code page
Then the user should be able to verify the values are entered in the routing code basic info page
Then the user should see the <registarFeeSFDCSubscription> and <routingCodeComment> field values same as in zeus document
Then the user reverts the changes to the document

Examples:
|entity|searchBy|routingCode|codeType|registarFeeSFDCSubscription|routingCodeComment|
|083905216|Routing Code|083905216|ABA|408123|Sample Text|

Scenario: Verify whether User can update blank values/special characters for 'Registrar Fee SFDC Subscription Number' & 'Routing Code Comment'

Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with routing code <routingCode> and code type <codeType>
Then the user should see the routing code basic info page
When the user clicks on the routing code update link
When the user gets the document with get document id for routing code with the <routingCode> and <codeType> from the database
When the user enters the <registarFeeSFDCSubscription> in the routing code basic info page
When the user enters the <routingCodeComment> in the routing code basic info page
And the user clicks on the save button
Then the user should see the below summary changes in confirmation modal
|Summary|
|Basic Info|
When the user clicks on the confirm button
Then the user should see the successful update message at top of the routing code page
Then the user should be able to verify the values are entered in the routing code basic info page
Then the user should see the <registarFeeSFDCSubscription> and <routingCodeComment> field values same as in zeus document
Then the user reverts the changes to the document

Examples:
|entity|searchBy|routingCode|codeType|registarFeeSFDCSubscription|routingCodeComment|
|083905216|Routing Code|083905216|ABA|||
|083905216|Routing Code|083905216|ABA|#%#$%^#$^#@$%^|$@#$@#%#$%^&&^*()_|

Scenario: User verifies that Registar Fee subscription field,Routing Code Comment fields are limited to 30 & 1000 unicode characters & verifies the max length attribute is restricted to 30 & 10000 in routing code Page

Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with routing code <routingCode> and code type <codeType>
Then the user should see the routing code basic info page
When the user clicks on the routing code update link
When the user gets the document with get document id for routing code with the <routingCode> and <codeType> from the database
When the user enters 30 unicode characters in Registar Fee subscription field
When the user enters 1000 unicode characters in Routing Code Comment field
Then the user should see maximum length of Registar Fee subscription field is limited to 30
Then the user should see maximum length of Routing Code Comment field is limited to 1000
When the user clicks on the save button
And the user clicks on the confirm button
Then the user should be able to verify the maximum values are entered in Registar Fee subscription field
Then the user should be able to verify the maximum values are entered in Routing Code Comment field
Then the user reverts the changes to the document

Examples:
|entity|searchBy|routingCode|codeType|
|083905216|Routing Code|083905216|ABA|