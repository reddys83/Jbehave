Meta:@EditCurrency @Currency

Narrative:
In order to view and edit the currencies
As a user
I want to cover the requirements mentioned in
JIRA ID - ZEUS-190 - User can edit currencies
JIRA ID - ZEUS-243 - User edits for currency will be validated
JIRA ID - ZEUS-510 - User can edit a currency
JIRA ID - ZEUS-240 - User can save edits to existing currency
JIRA ID - ZEUS-744 - User will confirm cancel for edit

Scenario: a. Veify the currency selection drop-down is disabled in update mode
b. Verify the currency details are comming from trusted document
c. verify when user clicks "Cancel" changes are not saved and screen returns to view mode
Meta:
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the currency tab in the data area
And the user clicks on the choose a currency option
And the user enters the currency <currency> in the typeahead box
And the user clicks on the update currency link
Then the user should see the currency selection disabled
Then the user should see the edit currency details from trusted document
When the user clicks on the cancel button
And the user clicks on the cancel yes button
Then the user should return to view mode of the currency page

Examples:
|currency|
|afghani|

Scenario: Verify error message for invalid entry
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
Then the user should see the error message please enter up to 100 valid characters for name
And the user should see the error message please enter up to 30 valid characters for abbreviation
And the user should see the error message please enter up to 100 valid characters for unit
And the user should see the error message please enter a numeric value up to 10,000 for quantity
And the user should see the error message at top of page the highlighted fields must be addressed before this update can be saved

Examples:
|currency|name|abbr|unit|quantity|
|afghani|afghaniafghaniafghaniafghaniafghaniafghaniafghaniafghaniafghaniafghaniafghaniafghaniafghaniafghaniafghaniafghaniafghani|afghaniTestafghaniTestafghaniTestafghaniTest|afghaniafghaniafghaniafghaniafghaniafghaniafghaniafghaniafghaniafghaniafghaniafghaniafghaniafghaniafghaniafghaniafghani|10001|

Scenario: Verify error message for required field
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the currency tab in the data area
And the user clicks on the choose a currency option
And the user enters the currency <currency> in the typeahead box
And the user clicks on the update currency link
And the user enters the currency name value as <name>
And the user clicks on the save button
Then the user should see the error message for the required name field
And the user should see the error message at top of page the highlighted fields must be addressed before this update can be saved

Examples:
|currency|name|
|afghani||

Scenario: Verify confirm changes
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the currency tab in the data area
And the user clicks on the choose a currency option
And the user enters the currency <currency> in the typeahead box
And the user clicks on the update currency link
And the user enters the currency abbr value as <abbr>
And the user enters the currency unit value as <unit>
And the user enters the currency quantity value as <quantity>
And the user clicks on the save button
When the user clicks on the confirm button
Then the user should see the edits to currency in zeus document
Then the user should see the view currency details from trusted document
And the user reverts the changes to the currency

Examples:
|currency|abbr|unit|quantity|
|Afghani-test|AFN-test|Puls-Test|100|

Scenario: verify save confirmation modal
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the currency tab in the data area
And the user clicks on the choose a currency option
And the user enters the currency <currency> in the typeahead box
And the user clicks on the update currency link
And the user clicks on the save button
Then the user should see the save confirmation modal
When the user clicks on the return button
Then the user should return to edit mode of the currency page

Examples:
|currency|
|Afghani-test|

Scenario: Verify user can edit the currency use for status active. (currency use should be editable)
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

Scenario: Veirfy user can edit the currency
1. Veirfy user can edit the currency use and the values comes from trusted document
2. Veify the country drop-down when the user is editing an existing currency
Meta:
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the currency tab in the data area
And the user clicks on the choose a currency option
And the user enters the currency <currency> in the typeahead box
And the user clicks on the update currency link
Then the user should see the currency uses in edit mode are from trusted document
Then user should see the list of countries in currency edit mode from trusted document

Examples:
|currency|
|Namibia Dollar|

Scenario: verify save confirmation modal
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the currency tab in the data area
And the user clicks on the choose a currency option
And the user enters the currency <currency> in the typeahead box
And the user clicks on the update currency link
And the user clicks on the save button
Then the user should see the save confirmation modal
When the user clicks on the return button
Then the user should return to edit mode of the currency page

Examples:
|currency|
|Afghani-test|

Scenario:
1. Veify whether confirmation modal appears when editing currency
2. After clicking on Yes from confirmation modal view mode of currency is displayed
3. After clicking on No from confirmation modal edit mode of currency is displayed
Meta:
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the currency tab in the data area
And the user clicks on the choose a currency option
And the user enters the currency <currency> in the typeahead box
And the user clicks on the update currency link
Then the user should see the currency selection disabled
When the user clicks on the cancel button
And the user clicks on the cancel yes button
Then the user should return to view mode of the currency page
When the user clicks on the update currency link
When the user clicks on the cancel button
And the user clicks on the cancel no button
Then the user should return to edit mode of the currency page
Then the user should see the currency selection disabled

Examples:
|currency|
|afghani|