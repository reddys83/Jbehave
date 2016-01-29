Meta:@CountryPayments @Country

Narrative:
In order to view and edit the currencies
As a user
I want to cover the requirements mentioned in
JIRA ID - ZEUS-246 - User can search for country by full name
JIRA ID - ZEUS-255 - User can view country's payments info
JIRA ID - ZEUS-669 - Country Payments - Display all routing code types. Currently it is only displaying one.

Scenario: Verify country payments data.
1. BUG-ID - ZEUS-653
Meta:@verifyBuild
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user clicks on the choose a country option
Then the user should see the country type-ahead displayed
When the user enters the country <country> in the type-ahead box
When the user clicks on the country payments link in the navigation bar
Then the user should see the country's payments iban as:
|STATUS|ISO CODE|REGISTERED DATE|IBAN ROUTING CODE TYPE|
|True|QA|13 Jul 1922|SWIFT BIC|

And the user should see the country's payments routing code types as:
|TYPES|
|CSRN|
|ABA|

Examples:
|country|
|Qatar|

Scenario: Verify country no payments data.
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user clicks on the choose a country option
Then the user should see the country type-ahead displayed
When the user enters the country <country> in the type-ahead box
When the user clicks on the country payments link in the navigation bar
Then the user should not see the country's payments routing codes types

Examples:
|country|
|Vanuatu|
