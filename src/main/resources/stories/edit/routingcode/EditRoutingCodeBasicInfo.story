Meta:@EditRoutingCodeBasicInfo @Edit @RoutingCode @AllStories

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal
JIRA ID - ZEUS-1179 - User can select to edit Routing Code's Basic Info

Scenario: Verify the routing code basic info values in edit mode.
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
