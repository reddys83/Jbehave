Meta:@CountryCurrencies

Narrative:
In order to view and edit the currencies
As a user
I want to cover the requirements mentioned in
JIRA ID - ZEUS-246 - User can view country's currencies

Scenario: Verify country's currencies.
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
Then the user should see the country list box displayed
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
Then the user should see the default country page and display all info
When the user clicks on the currencies link in the navigation bar
Then the user should see the country's currencies as:
|ISO|NAME|START DATE|END DATE|PRIMARY|REPLACED BY|STATUS|
|TJS|Somoni|2001-05-01||true||active|
|TJR|Rouble|1980-01-01|2001-04-30|true||inactive|

Examples:
|country|
|Wallis and Futuna|
