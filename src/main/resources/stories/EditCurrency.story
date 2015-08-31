Meta:@EditCurrency

Narrative:
In order to view and edit the currencies
As a user
I want to cover the requirements mentioned in
JIRA ID - ZEUS-190 - User can edit currencies

Scenario: Verify that the user can edit the currency name, abbr, unit, quantity
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the currency tab in the data area
And the user clicks on the choose a currency option
And the user enters the currency <currency> in the typeahead box
And the user clicks on the update currency link
And the user enters the currency name value as <name>
And the user enters the currency abbr value as <abbr>
And the user enters the currency unit value as <unit>
And the user enters the currency quantity value as <quantity>
And the user clicks on the save button
Then the user should see the currency name value as <name>
And the user should see the currency abbr value as <abbr>
And the user should see the currency unit value as <unit>
And the user should see the currency quantity value as <quantity>

Examples:
|currency|name|abbr|unit|quantity|
|afghani|afghani|Af|Puls|100|

Scenario: Verify currency list matches the search string
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the currency tab in the data area
And the user clicks on the choose a currency option
And the user enters the currency <currency> in the typeahead box
And the user clicks on the update currency link
And the user enters the currency name value as <name>
And the user enters the currency abbr value as <abbr>
And the user enters the currency unit value as <unit>
And the user enters the currency quantity value as <quantity>
And the user clicks on the cancel button

Examples:
|currency|name|abbr|unit|quantity|
|afghani|afghani|Af|Puls|100|