Meta:@RoutingCodeBasicInfo @RoutingCode @View

Narrative:
In order to view and edit the office
As a user
I want to cover the requirements mentioned in
JIRA ID - ZEUS-1134 - User can view Routing Code Basic Info

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
