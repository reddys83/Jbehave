Meta: @Design

Narrative:
In order to view stub entry details
As a user when I search by Name, FID, TFPID and click on the search results card I can view details
I want to cover the requirements mentioned in JIRA ID - Zeus54 - (User can view entity stub entry)

Scenario:
1. Verify currency's uses. Sorting order.
2. Verify clicking on the Replaced By link the user is taken to that currency
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the currency tab in the data area
And the user clicks on the choose a currency option
And the user enters the currency Rand in the typeahead box
Then the user should see the currency's uses
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
