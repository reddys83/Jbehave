Meta:@RoutingCodeBasicInfo @RoutingCode @View

Narrative:
In order to view and edit the office
As a user
I want to cover the requirements mentioned in
JIRA ID - ZEUS-1134 - User can view Routing Code Basic Info
JIRA ID - ZEUS-1479 - User can hyperlink from Routing Code Search Results to Routing Code Basic Info screen
JIRA ID - ZEUs-1540 - Routing Code Search: Search Value of 1 digit

Scenario: Verify the basic info for a routing code of type ABA
Verify the headers and the legal entity link on the header
Meta:@test321
Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with routing code <routingCode> and code type <codeType>
Then the user should see the routing code basic info page
And the user should see the routing code basic info values from trusted document for routing code <routingCode> with code type <codeType>
And the user should see the routing code page header with <legalentity>, <headOfficeAddress>, <routingCodeFid> and <routingCodeTfpid>
When the user clicks on the legal entity link in the routing code page header
Then the user should see the legalEntity names for <fid> in the legalEntity basic info

Examples:
|entity|searchBy|routingCode|codeType|legalentity|headOfficeAddress|routingCodeFid|routingCodeTfpid|fid|
|083905216|Routing Code|083905216|ABA|Berliner Volksbank eG|Berlin, Germany|C-1121793|ABA-083905216|1717|


Scenario: Verify the basic info for a routing code of type non-ABA (Swift BIC)
Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with routing code <routingCode> and code type <codeType>
Then the user should see the routing code basic info page
Then the user should not see ABA code type specific fields in the basic info page
And the user should see the routing code basic info values from trusted document for routing code <routingCode> with code type <codeType>
Examples:
|entity|searchBy|routingCode|codeType|
|01056|Routing Code|01056|Swift BIC|

Scenario: User is viewing the results of a routing code search - 
1 - User selects the 'code' value which is a hyperlink in the routing code search results row.
2 - Verify that the page is redirected to Routing Code's basic info page.
3 - Verify that the following menus are available in the sidebar.
    (ALL, BASIC INFO, PAYMENT SYSTEMS, RELATED CODES, USAGES, FORMER USAGES, HISTORY) 
    
Given a user is on the search page
When the user selects the <searchBy> from the dropdown
When the user enters the <entity> in the typeahead
And the user clicks on the search button
Then the user should see the View Routing Code tooltip on routing code results page
Then the user should see the View Office tooltip on routing code search results page
When the user clicks on the code value hyperlink on the search results card with routing code <routingCode> and code type <codeType>
Then the user should see the routing code basic info page
Then the user should see all the routing code menus in the sidebar

Examples:
|entity|searchBy|routingCode|codeType|
|DAAEDEDD435|Routing Code|DAAEDEDD435|SWIFT BIC|

Scenario: User verifies the message "Enter at least 2 valid characters" when only one alpha numeric character is entered

Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
Then the user should see the message Enter at least 2 valid characters in search box

Examples:
|entity|searchBy|
|1#$@|Routing Code|
|a#$@|Routing Code|
||Routing Code|
|2|Routing Code|
|B|Routing Code|
|.-|Routing Code|

Scenario: User should not see message "Enter at least 2 valid characters" when more than 2 alpha numeric characters are entered

Given a user is on the search page
When the user selects the <searchBy> from the dropdown
And the user enters the <entity> in the typeahead
Then the user should not see the message Enter at least 2 valid characters in search box
Then the user should see Results page displayed
When the user enters the <entity> in the typeahead
When the user clears the entity value in type ahead box
Then the user should see the message Enter at least 2 valid characters in search box

Examples: 
|entity|searchBy|
|1#$@2|Routing Code|
|1a@#%@%#$%|Routing Code|
|22$@#$@#$@$|Routing Code|
|107001119|Routing Code|    