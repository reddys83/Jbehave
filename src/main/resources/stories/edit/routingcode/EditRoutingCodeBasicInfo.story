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

Scenario: Verify alternate code forms can be added for a routing code
Verify the max length for the alternate code form value
Verify the alternate code form type values from lookup ROUTING_CODE_ALTERNATE_FORM_TYPE
Verify existing alternate code forms can not be edited

Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with routing code <routingCode> and code type <codeType>
Then the user should see the routing code basic info page
When the user clicks on the routing code update link
When the user gets the document with get document id for routing code with the <routingCode> and <codeType> from the database
Then the user verifies that the existing alternate code forms can not be edited
When the user click on add new alternate code form button
Then the user should see the alternate code type values from lookup ROUTING_CODE_ALTERNATE_FORM_TYPE except the values that were selected already
Then the user verifies the alternate code form value maxlength is 20 characters
When the user selects alternate code form type as <alternateCodeType>
And the user enters the alternate code form value as <alternateCodeValue>
When the user clicks on the save button
And the user clicks on the confirm button
Then the user should see the successful update message at top of the routing code page
Then the user should see the alternate code form values as <alternateCodeType> and <alternateCodeValue> in the routing code basic info page
Then the user should see the alternate code form values same as in zeus document for routing code <routingCode> with code type <codeType>
Then the user reverts the changes to the document


Examples:
|entity|searchBy|routingCode|codeType|alternateCodeType|alternateCodeValue|
|083905216|Routing Code|083905216|ABA|tfp_legacy|123456|

Scenario: Verify alternate code forms can be deleted for a routing code except the fractional value
Verify alternate code forms of type "fractional" can not be deleted

Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with routing code <routingCode> and code type <codeType>
Then the user should see the routing code basic info page
When the user clicks on the routing code update link
When the user gets the document with get document id for routing code with the <routingCode> and <codeType> from the database
Then the user verifies that the fractional value can not be deleted
When the user clicks on the delete alternate code form button
And the user clicks on the Yes button to delete a row
And the user clicks on the save button
And the user clicks on the confirm button
Then the user should see the successful update message at top of the routing code page
Then the user should not see the alternate code form values <alternateCodeType> and <alternateCodeValue> in the routing code basic info page
Then the user should see the alternate code form values same as in zeus document for routing code <routingCode> with code type <codeType>
Then the user reverts the changes to the document


Examples:
|entity|searchBy|routingCode|codeType|alternateCodeType|alternateCodeValue|
|083905216|Routing Code|083905216|ABA|fdb_legacy|2324|

Scenario: Verify that the user should get the Required field messages for alternate code type

Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with routing code <routingCode> and code type <codeType>
Then the user should see the routing code basic info page
When the user clicks on the routing code update link
When the user gets the document with get document id for routing code with the <routingCode> and <codeType> from the database
Then the user verifies that the existing alternate code forms can not be edited
When the user click on add new alternate code form button
When the user selects alternate code form type as <alternateCodeType>
And the user enters the alternate code form value as <alternateCodeValue>
When the user clicks on the save button
Then the user should see the error message for the required alternate code type field in the basic info routing code page
And the user should see the error message at top of page the highlighted fields must be addressed before this update can be saved

Examples:
|entity|searchBy|routingCode|codeType|alternateCodeType|alternateCodeValue|
|083905216|Routing Code|083905216|ABA||2324|

Scenario: Verify that the user should get the Required field messages for alternate code value
Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with routing code <routingCode> and code type <codeType>
Then the user should see the routing code basic info page
When the user clicks on the routing code update link
When the user gets the document with get document id for routing code with the <routingCode> and <codeType> from the database
Then the user verifies that the existing alternate code forms can not be edited
When the user click on add new alternate code form button
When the user selects alternate code form type as <alternateCodeType>
And the user enters the alternate code form value as <alternateCodeValue>
When the user clicks on the save button
Then the user should see the error message for the required alternate code value field in the basic info routing code page
And the user should see the error message at top of page the highlighted fields must be addressed before this update can be saved
Examples:
|entity|searchBy|routingCode|codeType|alternateCodeType|alternateCodeValue|
|083905216|Routing Code|083905216|ABA|tfp_legacy||