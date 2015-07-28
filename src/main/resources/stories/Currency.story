Meta:@Currency

Narrative:
In order to view and edit the currencies
As a user
I want to cover the requirements mentioned in
JIRA ID - ZEUS-241 - User can search for an existing currency by full name
JIRA ID - ZEUS-189 - User can view a currency

Scenario: Verify currency view only information
1. search for a currency that has all fields
2. search for a currency that has no subUnits
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the currency tab in the data area
And the user clicks on the choose a currency option
And the user enters the currency <currency> in the typeahead box
Then the user should see the currency iso code value as <isoCode>
And the user should see the currency name value as <name>
And the user should see the currency abbr value as <abbr>
And the user should see the currency unit value as <unit>
And the user should see the currency quantity value as <quantity>

Examples:
|currency|isoCode|name|abbr|unit|quantity|
|US Dollar|USD|US Dollar|US$|Cents|100|
|Icelandic Krona|ISK|Icelandic Krona|ISK|null|null|
|Sudanese Dinar|SDD|Sudanese Dinar|Dinar|Dirham|null|
