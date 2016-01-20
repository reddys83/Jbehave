Meta:@EditCurrency @Currency

Narrative:
In order to view and edit the currencies
As a user
I want to cover the requirements mentioned in
JIRA ID - ZEUS-190 - User can edit currencies

Scenario: Verify that the user can edit the currency name, abbr, unit, quantity
Meta:@verifyBuild
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

Examples:
|currency|name|abbr|unit|quantity|
|afghani|afghaniTest|AfT|Puls-Test|101|

Scenario: Veify the currency selection drop-down is disabled in update mode
Meta:
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the currency tab in the data area
And the user clicks on the choose a currency option
And the user enters the currency <currency> in the typeahead box
And the user clicks on the update currency link
Then the user should see the currency selection is disabled

Examples:
|currency|
|afghani|

Scenario: Verify the currency details are comming from trusted document
Meta:
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the currency tab in the data area
And the user clicks on the choose a currency option
And the user enters the currency <currency> in the typeahead box
And the user clicks on the update currency link
Then the user should see the currency <currency> details are from trusted document

Examples:
|currency|
|afghani|

Scenario: verify when user clicks "Cancel" changes are not saved and screen returns to view mode
Meta:@cancelButton
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the currency tab in the data area
And the user clicks on the choose a currency option
And the user enters the currency <currency> in the typeahead box
And the user clicks on the update currency link
Then the user should return to view mode of the currency page

Examples:
|currency|
|afghani|