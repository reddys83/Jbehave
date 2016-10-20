Meta:@RoutingCodeBasicInfo @RoutingCode @View

Narrative:
In order to view and edit the office
As a user
I want to cover the requirements mentioned in
JIRA ID - ZEUS-1134 - User can view Routing Code Basic Info
JIRA ID - ZEUs-1540 - Routing Code Search: Search Value of 1 digit

Scenario: User verifies the message "Enter at least 2 valid characters" when only one alpha numeric character is entered

Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
Then the user should verify the message

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
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
Then the user should not see the message
When the user enters the <entity> in the typeahead
When the user clears the entity value in type ahead box
Then the user should verify the message

Examples: 
|entity|searchBy|
|1#$@2|Routing Code|
|1a@#%@%#$%|Routing Code|
|22$@#$@#$@$|Routing Code|
|107001119|Routing Code|