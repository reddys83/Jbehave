Meta:@RoutingCodeBasicInfo @RoutingCode @View

Narrative:
In order to view and edit the office
As a user
I want to cover the requirements mentioned in
JIRA ID - ZEUS-1134 - User can view Routing Code Basic Info
JIRA ID - ZEUS-1479 - User can hyperlink from Routing Code Search Results to Routing Code Basic Info screen

Scenario: Verify the basic info for a routing code of type ABA
Verify the headers and the legal entity link on the header

Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with routing code <routingCode> and code type <codeType>
Then the user should see the routing code basic info page
And the user should see the routing code basic info values from Trusted document for routing code <routingCode> with code type <codeType>
And the user should see the routing code page header with <legalentity>, <headOfficeAddress>, <routingCodeFid> and <routingCodeTfpid>
When the user clicks on the legal entity link in the routing code page header
Then the user should see the legal entity's names as:
|TYPE|VALUE|
|Legal Title|Berliner Volksbank eG|
|Former Name|Berliner Volksbank (West) eG|

Examples:
|entity|searchBy|routingCode|codeType|legalentity|headOfficeAddress|routingCodeFid|routingCodeTfpid|
|083905216|Routing Code|083905216|ABA|Berliner Volksbank eG|Berlin, Bezirk Freiburg, Sachsen-Anhalt, Germany|C-1121793|ABA-083905216|


Scenario: Verify the basic info for a routing code of type non-ABA (Swift BIC)
Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with routing code <routingCode> and code type <codeType>
Then the user should see the routing code basic info page
Then the user should not see ABA code type specific fields in the basic info page
And the user should see the routing code basic info values from Trusted document for routing code <routingCode> with code type <codeType>
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
Then the user should see the view routing code tooltip on routing code search results page
Then the user should see the view office tooltip on routing code search results page
When the user clicks on the code value hyperlink on the search results card with routing code <routingCode> and code type <codeType>
Then the user should see the routing code basic info page
Then the user should see all the routing code menus in the sidebar

Examples:
|entity|searchBy|routingCode|codeType|
|DAAEDEDD435|Routing Code|DAAEDEDD435|SWIFT BIC|    