Meta:@Design


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
