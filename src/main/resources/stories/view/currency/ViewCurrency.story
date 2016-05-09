Meta:@ViewCurrency @Currency @View

Narrative:
In order to view and edit the currencies
As a user
I want to cover the requirements mentioned in
JIRA ID - ZEUS-241 - User can search for an existing currency by full name
JIRA ID - ZEUS-189 - User can view a currency
JIRA ID - ZEUS-242 - User can view a currency's uses
JIRA ID - ZEUS-222 - User can follow link to another currency when viewing a currency
JIRA ID - ZEUS-703 - Only display currency use start and end dates to the indicated accuracy
JIRA ID - ZEUS-429 - All info should display (by default) when you link to country from currency
JIRA ID - ZEUS-238 - display full country name in currency use
JIRA ID - ZEUS-321 - ignore special characters in currency, country, area/subarea and city drop-down

Scenario: Verify currency list
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the currency tab in the data area
And the user clicks on the choose a currency option in the currency page
Then the user should see the list of all existing currencies by full name

Scenario: Verify currency list matches the search string
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the currency tab in the data area
And the user clicks on the choose a currency option in the currency page
And the user starts typing the name of a currency as Pa' in the currency input box
Then the user should see the drop-down list of the currencies matching the input characters

And the user should see the currencies in the listbox as:
|CURRENCY|
|Pa'anga|

Scenario: Verify no results match
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the currency tab in the data area
And the user clicks on the choose a currency option in the currency page
And the user starts typing the name of a currency as dfbhjb in the currency input box
Then the user should see the option no results match for the searched currency string

Scenario: Verify currency view only information
1. search for a currency that has all fields
2. search for a currency that has no subUnits
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the currency tab in the data area
And the user clicks on the choose a currency option in the currency page
And the user enters the currency <currency> in the typeahead box in the currency page
Then the user should see the currency iso code value as <isoCode> in the currency page
And the user should see the currency name value as <name> in the currency page
And the user should see the currency abbr value as <abbr> in the currency page
And the user should see the currency unit value as <unit> in the currency page
And the user should see the currency quantity value as <quantity> in the currency page

Examples:
|currency|isoCode|name|abbr|unit|quantity|
|US Dollar asdt|USD|US Dollar asdf|US$ - new|Cents|100|
|Icelandic Krona|ISK|Icelandic Krona|ISK|null|null|
|Sudanese Dinar|SDD|Sudanese Dinar|Dinar|Dirham|null|

Scenario: Verify currency's uses.
1. Verify sorting order.
2. Click on usage country link
3. BUG-ID - ZEUS-753
Meta:
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the currency tab in the data area
And the user clicks on the choose a currency option in the currency page
And the user enters the currency <currency> in the typeahead box in the currency page
Then the user should see the view currency use from trusted document
When the user clicks on the country <currencyUsageCountry> in the currency usage
Then the user should see the default country page and display all info

Examples:
|currency|currencyUsageCountry|
|Rand|South Africa|

Scenario: Verify currency's uses. No uses.
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the currency tab in the data area
And the user clicks on the choose a currency option in the currency page
And the user enters the currency <currency> in the typeahead box in the currency page
Then the user should not see the currency's uses in the currency page

Examples:
|currency|
|Special Drawing Rights|

Scenario: Follow link to another currency when viewing a currency
1. BUG-ID - ZEUS-753
Meta:@verifyBuild
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the currency tab in the data area
And the user clicks on the choose a currency option in the currency page
And the user enters the currency <currency> in the typeahead box in the currency page
Then the user should see the view currency use from trusted document
When the user clicks on the replaced by currency NAD in the currency page
Then the user should see the currency iso code value as <isoCode> in the currency page
And the user should see the currency name value as <name> in the currency page
And the user should see the currency abbr value as <abbr> in the currency page
And the user should see the currency unit value as <unit> in the currency page
And the user should see the currency quantity value as <quantity> in the currency page

Examples:
|isoCode|name|abbr|unit|quantity|currency|
|NAD|Namibia Dollar|N$|Cents|100|Rand|
