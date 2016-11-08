Meta:@EditRoutingCodeRelatedCodes @Edit @RoutingCode @AllStories

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario: Verify that the user can add related codes for routing code
Check related code context values are from lookup RELATED_CODE_CONTEXT
Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with routing code <routingCode> and code type <codeType>
And the user clicks on the routing code related codes link in the navigation bar
When the user clicks on the routing code update link
When the user gets the document with get document id for routing code with the <routingCode> and <codeType> from the database
Then the user should see the routing code related code values from trusted document for routing code <routingCode> with code type <codeType>
When the user clicks on add new related codes button
Then the user should see the routing code related codes context values from lookup RELATED_CODE_CONTEXT except the values that were selected already
When the user selects routing code related code context type as <contextType>
And the user search for a routing code using the search code <searchCode> and selects routing code <relatedCode>
Then the user should see the related code's code type as <relatedCodeType>
When the user clicks on the save button
Then the user should see the save confirmation modal
And the user should see the below summary changes in confirmation modal
|Summary|
|Related Codes|
When the user clicks on the confirm button
Then the user should see the related codes for the routing code <routingCode> with code type <codeType> in zeus document
And the user should see the newly added related code <relatedCode> with contextType <contextType> in the zeus UI
Then the user reverts the changes to the document

Examples:
|entity|searchBy|routingCode|codeType|contextType|searchCode|relatedCode|relatedCodeType|
|77390628|Routing Code|77390628|BLZ (DE)|IBAN Override|001|001 - KRRN|KRRN|

Scenario: Verify that the user can delete related codes for routing code
Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with routing code <routingCode> and code type <codeType>
And the user clicks on the routing code related codes link in the navigation bar
When the user clicks on the routing code update link
And the user gets the document with get document id for routing code with the <routingCode> and <codeType> from the database
And the user clicks on the first_row_existing_related_codes_delete_button in the related codes section
And the user clicks on the yes button in the delete row confirmation modal in the routing code page
When the user clicks on the save button
Then the user should see the save confirmation modal
And the user should see the below summary changes in confirmation modal
|Summary|
|Related Codes|
When the user clicks on the confirm button
Then the user should see the related codes for the routing code <routingCode> with code type <codeType> in zeus document
And the user should not see the deleted related code <relatedCode> with contextType <contextType> in the zeus UI
Then the user reverts the changes to the document

Examples:
|entity|searchBy|routingCode|codeType|contextType|relatedCode|
|77390628|Routing Code|77390628|BLZ (DE)|ERP Override|30060601 - SWIFT BIC|

Scenario: Verify that the related search dropdown lists the values as per the search string.
Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with routing code <routingCode> and code type <codeType>
And the user clicks on the routing code related codes link in the navigation bar
When the user clicks on the routing code update link
When the user clicks on add new related codes button
And the user search for a routing code using the search code <searchCode>
Then the user should see the routing code search results in the related code dropdown for search code <searchCode>

Examples:
|entity|searchBy|routingCode|codeType|searchCode|
|77390628|Routing Code|77390628|BLZ (DE)|001|
|77390628|Routing Code|77390628|BLZ (DE)|0011|
|77390628|Routing Code|77390628|BLZ (DE)|00*1&1|
|77390628|Routing Code|77390628|BLZ (DE)|01056|

Scenario: Verify that the "No results..." message shows up when search for a routing code that has no results.
Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with routing code <routingCode> and code type <codeType>
And the user clicks on the routing code related codes link in the navigation bar
When the user clicks on the routing code update link
When the user clicks on add new related codes button
And the user search for a routing code using the search code <searchCode>
Then the user should see the message No results for <searchCode>

Examples:
|entity|searchBy|routingCode|codeType|searchCode|
|77390628|Routing Code|77390628|BLZ (DE)|qa|


Scenario: Verify that the user gets Required message when entered Context and leave related code value blank
Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with routing code <routingCode> and code type <codeType>
And the user clicks on the routing code related codes link in the navigation bar
When the user clicks on the routing code update link
When the user clicks on add new related codes button
When the user selects routing code related code context type as <contextType>
When the user clicks on the save button
Then the user should see the required error message for relatedcode
When the user search for a routing code using the search code <searchCode> and selects routing code <relatedCode>
And the user selects routing code related code context type as <blank>
And the user clicks on the save button
Then the user should see the required error message for context
Examples:
|entity|searchBy|routingCode|codeType|contextType|searchCode|relatedCode|blank|
|77390628|Routing Code|77390628|BLZ (DE)|IBAN Override|001|001 - KRRN||