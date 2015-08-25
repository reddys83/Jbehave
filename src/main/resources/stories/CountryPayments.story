Meta:@CountryPayments

Narrative:
In order to view and edit the currencies
As a user
I want to cover the requirements mentioned in
JIRA ID - ZEUS-246 - User can search for country by full name
JIRA ID - ZEUS-255 - User can view country's payments info

Scenario: Verify country payments data.
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
Then the user should see the country list box displayed
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
When the user clicks on the country payments link in the navigation bar
Then the user should see the country's payments iban as:
|STATUS|ISO CODE|REGISTERED DATE|IBAN ROUTING CODE TYPE|
|True|YU|13 Jul 1922|CSRN|

And the user should see the country's payments routing code types as:
|TYPES|
|CSRN|

Examples:
|country|
|Yugoslavia|

Scenario: Verify country no payments data.
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
Then the user should see the country list box displayed
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
When the user clicks on the country payments link in the navigation bar
Then the user should not see the country's payments iban
And the user should not see the country's payments routing codes types


Examples:
|country|
|Vanuatu|
