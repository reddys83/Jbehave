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
Verify the currency details are comming from trusted document
verify when user clicks "Cancel" changes are not saved and screen returns to view mode
Meta:
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the currency tab in the data area
And the user clicks on the choose a currency option
And the user enters the currency <currency> in the typeahead box
And the user clicks on the update currency link
Then the user should see the currency selection is disabled
Then the user should see the currency <currency> details are from trusted document
When the user clicks on the cancel button
Then the user should return to view mode of the currency page

Examples:
|currency|
|afghani|

Scenario: Verify user can edit the currency use for status active. (currency use should be editable)
Meta:
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the currency tab in the data area
And the user clicks on the choose a currency option
And the user enters the currency <currency> in the typeahead box
And the user clicks on the update currency link
Then the user should see the currency usage is editable for status active

Examples:
|currency|
|Australian Dollar|

Scenario: Verify user can edit the currency use for status inactive. (currency use should be editable)
Meta:
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the currency tab in the data area
And the user clicks on the choose a currency option
And the user enters the currency <currency> in the typeahead box
And the user clicks on the update currency link
Then the user should see the currency usage is editable for status inactive

Examples:
|currency|
|Deutsche Mark|

Scenario: Veirfy user can edit the currency use and the values comes from trusted document
Meta:
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the currency tab in the data area
And the user clicks on the choose a currency option
And the user enters the currency <currency> in the typeahead box
And the user clicks on the update currency link
Then the user should see the currency uses in edit mode are from trusted document

Examples:
|currency|
|Namibia Dollar|

Scenario: Veify the country drop-down when the user is editing an existing currency
Meta:
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the currency tab in the data area
And the user clicks on the choose a currency option
And the user enters the currency <currency> in the typeahead box
And the user clicks on the update currency link
Then user should see the list of countries in currency edit mode from trusted document

Examples:
|currency|
|Namibia Dollar|

