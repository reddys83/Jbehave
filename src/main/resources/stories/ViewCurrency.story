Meta:@ViewCurrency

Narrative:
In order to view and edit the currencies
As a user
I want to cover the requirements mentioned in
JIRA ID - ZEUS-241 - User can search for an existing currency by full name
JIRA ID - ZEUS-189 - User can view a currency
JIRA ID - ZEUS-242 - User can view a currency's uses
JIRA ID - ZEUS-222 - User can follow link to another currency when viewing a currency

Scenario: Verify currency list
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the currency tab in the data area
And the user clicks on the choose a currency option
Then the user should see the list of all existing currencies by full name

Scenario: Verify currency list matches the search string
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the currency tab in the data area
And the user clicks on the choose a currency option
And the user starts typing the name of a currency as Afg in the currency input box
Then the user should see the drop-down list of the currencies matching the input characters
And the user should see the currencies in the listbox as:
|CURRENCY|
|afghani|
|Afghani|

Scenario: Verify no results match
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the currency tab in the data area
And the user clicks on the choose a currency option
And the user starts typing the name of a currency as dfbhjb in the currency input box
Then the user should see the option no results match for the searched currency string

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

Scenario: Verify currency's uses.
1. Verify sorting order.
2. Click on usage country link
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the currency tab in the data area
And the user clicks on the choose a currency option
And the user enters the currency <currency> in the typeahead box
Then the user should see the countries in the currency usage as:
|COUNTRIES|
|South Africa|
|Namibia|

And the user should see the currency's uses as:
|COUNTRY|START DATE|END DATE|PRIMARY|REPLACED BY|STATUS|
|ZAF|1980-01-01||True||Active|
|NAM|1980-01-01|1993-09-29|True|NAD|Inactive|

When the user clicks on the country <currencyUsageCountry> in the currency usage
And the user clicks on the country basic info link in the navigation bar
Then the user should see the basic info for the selected country

Examples:
|currency|currencyUsageCountry|
|Rand|South Affrica|

Scenario: Verify currency's uses.
1. Verify sorting order.
2. Click on usage country link
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the currency tab in the data area
And the user clicks on the choose a currency option
And the user enters the currency <currency> in the typeahead box
Then the user should see the countries in the currency usage as:
|COUNTRIES|
|Curaçao|
|Sint Maarten|
|Bonaire, Sint Eustatius and Saba|

And the user should see the currency's uses as:
|COUNTRY|START DATE|END DATE|PRIMARY|REPLACED BY|STATUS|
|CUW|1980-01-01||True||Active|
|SXM|1980-01-01||True||Active|
|BES|1980-01-01|2010-12-31|True|USD|Inactive|

When the user clicks on the country iso3 BES in the currency usage
Then the user should see the country iso3 as BES

Examples:
|currency|
|Netherlands Antilles Guilder|

Scenario: Verify currency's uses. No uses.
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the currency tab in the data area
And the user clicks on the choose a currency option
And the user enters the currency <currency> in the typeahead box
Then the user should not see the currency's uses

Examples:
|currency|
|Special Drawing Rights|

Scenario: Zeus-222
Verify clicking on the Replaced By link the user is taken to that currency (switch Rand to Rouble when the list value becomes more unique)
Meta:@verifyBuild
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the currency tab in the data area
And the user clicks on the choose a currency option
And the user enters the currency Rand in the typeahead box
Then the user should see the currency's uses as:
|COUNTRY|START DATE|END DATE|PRIMARY|REPLACED BY|STATUS|
|ZAF|1980-01-01||True||Active|
|NAM|1980-01-01|1993-09-29|True|NAD|Inactive|
When the user clicks on the replaced by currency NAD
Then the user should see the currency iso code value as <isoCode>
And the user should see the currency name value as <name>
And the user should see the currency abbr value as <abbr>
And the user should see the currency unit value as <unit>
And the user should see the currency quantity value as <quantity>

Examples:
|isoCode|name|abbr|unit|quantity|
|NAD|Namibia Dollar|N$|Cents|100|
