Meta:@EditCurrency @Currency @Edit @AllStories

Narrative:
In order to view and edit the currencies
As a user
I want to cover the requirements mentioned in
JIRA ID - ZEUS-190 - User can edit currencies
JIRA ID - ZEUS-243 - User edits for currency will be validated
JIRA ID - ZEUS-510 - User can edit a currency
JIRA ID - ZEUS-240 - User can save edits to existing currency
JIRA ID - ZEUS-285 - Users edits for currency use will be validated
JIRA ID - ZEUS-744 - User will confirm cancel for edit
JIRA ID - ZEUS-749 - Schematron validation for currency
JIRA ID - ZEUS-286 - User can save edits to currency uses
JIRA-ID - ZEUS-280 - User can add new use for currency
JIRA-ID - ZEUS-838 - User will see confirmation message after saving currency edits
JIRA ID - ZEUS-743 - User will get warning if click away from screen they are editing
JIRA ID - ZEUS-828 - User can only input numbers in date field
JIRA ID - ZEUS-802 Accented characters displaying correctly after saving
JIRA ID - ZEUS-869 - Remove currency use
JIRA ID - ZEUS-924 - User can't add duplicate primary currencies for a country


Scenario: a. Veify the currency selection drop-down is disabled in update mode
1. Verify the currency details are comming from trusted document
2. verify when user clicks "Cancel" changes are not saved and screen returns to view mode
Meta:
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the currency tab in the data area
And the user clicks on the choose a currency option in the currency page
And the user enters the currency <currency> in the typeahead box in the currency page
And the user clicks on the update link
Then the user should see the currency selection disabled in the currency page
Then the user should see the edit currency details from trusted document
When the user clicks on the cancel button
And the user clicks on the cancel yes button
Then the user should return to view currency page mode

Examples:
|currency|
|afghani|

Scenario: Verify error message for invalid entry
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the currency tab in the data area
And the user clicks on the choose a currency option in the currency page
And the user enters the currency <currency> in the typeahead box in the currency page
And the user clicks on the update link
And the user enters the currency name value as <name> in the currency page
And the user enters the currency abbr value as <abbr> in the currency page
And the user enters the currency unit value as <unit> in the currency page
And the user enters the currency quantity value as <quantity> in the currency page
And the user clicks on the save button
Then the user should see the error message enter up to 100 valid characters for name in the currency page
And the user should see the error message enter up to 30 valid characters for abbreviation in the currency page
And the user should see the error message enter up to 100 valid characters for unit in the currency page
And the user should see the error message enter a numeric value up to 10,000 for quantity in the currency page
And the user should see the error message at top of page the highlighted fields must be addressed before this update can be saved

Examples:
|currency|name|abbr|unit|quantity|
|afghani|afghaniafghaniafghaniafghaniafghaniafghaniafghaniafghaniafghaniafghaniafghaniafghaniafghaniafghaniafghaniafghaniafghani|afghaniTestafghaniTestafghaniTestafghaniTest|afghaniafghaniafghaniafghaniafghaniafghaniafghaniafghaniafghaniafghaniafghaniafghaniafghaniafghaniafghaniafghaniafghani|10001|

Scenario: Verify error message for required field
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the currency tab in the data area
And the user clicks on the choose a currency option in the currency page
And the user enters the currency <currency> in the typeahead box in the currency page
And the user clicks on the update link
And the user enters the currency name value as <name> in the currency page
And the user clicks on the save button
Then the user should see the error message for the required name field in the currency page
And the user should see the error message at top of page the highlighted fields must be addressed before this update can be saved

Examples:
|currency|name|
|afghani||

Scenario: Verify confirm changes STORY:920(failing because of invalid data in database)
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the currency tab in the data area
And the user clicks on the choose a currency option in the currency page
And the user enters the currency <currency> in the typeahead box in the currency page
And the user clicks on the update link
And the user get the document with get Id for currency with the name as Afghani-test from the database

And the user enters the currency abbr value as <abbr> in the currency page
And the user enters the currency unit value as <unit> in the currency page
And the user enters the currency quantity value as <quantity> in the currency page
And the user clicks on the save button
When the user clicks on the confirm button
Then the user should see the edits to currency details in zeus document
Then the user should see the view currency details from trusted document
And the user reverts the changes to the document

Examples:
|currency|abbr|unit|quantity|
|Afghani-test|AFN|Puls-Test|100|

Scenario: verify save confirmation modal
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the currency tab in the data area
And the user clicks on the choose a currency option in the currency page
And the user enters the currency <currency> in the typeahead box in the currency page
And the user clicks on the update link
And the user clicks on the save button
Then the user should see the save confirmation modal
When the user clicks on the return button
Then the user should return to edit currency page mode

Examples:
|currency|
|Afghani-test|

Scenario: Verify user can edit the currency use for status active. (currency use should be editable)
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the currency tab in the data area
And the user clicks on the choose a currency option in the currency page
And the user enters the currency <currency> in the typeahead box in the currency page
And the user clicks on the update link
Then the user should see the currency usage is editable for status active

Examples:
|currency|
|Australian Dollar|

Scenario: Verify user can edit the currency use for status inactive. (currency use should be editable)
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the currency tab in the data area
And the user clicks on the choose a currency option in the currency page
And the user enters the currency <currency> in the typeahead box in the currency page
And the user clicks on the update link
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
And the user clicks on the choose a currency option in the currency page
And the user enters the currency <currency> in the typeahead box in the currency page
And the user clicks on the update link
Then the user should see the currency uses in edit mode are from trusted document
When the user clicks on the add country type-ahead option
Then user should see the list of countries in currency edit mode from trusted document

Examples:
|currency|
|Namibia Dollar|

Scenario: verify save confirmation modal
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the currency tab in the data area
And the user clicks on the choose a currency option in the currency page
And the user enters the currency <currency> in the typeahead box in the currency page
And the user clicks on the update link
And the user clicks on the save button
Then the user should see the save confirmation modal
When the user clicks on the return button
Then the user should return to edit currency page mode

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
And the user clicks on the choose a currency option in the currency page
And the user enters the currency <currency> in the typeahead box in the currency page
And the user clicks on the update link
Then the user should see the currency selection disabled in the currency page
When the user clicks on the cancel button
And the user clicks on the cancel yes button
Then the user should return to view currency page mode
When the user clicks on the update link
When the user clicks on the cancel button
And the user clicks on the cancel no button
Then the user should return to edit currency page mode
Then the user should see the currency selection disabled in the currency page

Examples:
|currency|
|afghani|

Scenario: BUG_ID - ZEUS-808
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the currency tab in the data area
And the user clicks on the choose a currency option in the currency page
And the user enters the currency <currency> in the typeahead box in the currency page
And the user clicks on the update link
And the user enters the currency quantity value as <quantity> in the currency page
And the user clicks on the save button
Then the user should see the error message enter a numeric value up to 10,000 for quantity in the currency page
And the user should see the error message at top of page the highlighted fields must be addressed before this update can be saved

Examples:
|currency|quantity|
|afghani|ab|

Scenario: Verify replaced by currency list
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the currency tab in the data area
And the user clicks on the choose a currency option in the currency page
And the user enters the currency <currency> in the typeahead box in the currency page
And the user clicks on the update link
Then the user should see the list of all other existing currencies (by name) excluding the currency they are currently viewing

Examples:
|currency|
|afghani|

Scenario: Verify error message for year for start and end date
1. only day
2. only month
3. only day and month
4. only day and year
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the currency tab in the data area
And the user clicks on the choose a currency option in the currency page
And the user enters the currency <currency> in the typeahead box in the currency page
And the user clicks on the update link
When the user enters the currency start day as <currencyStartDay> in the currency page
And the user enters the currency start month as <currencyStartMonth> in the currency page
And the user enters the currency start year as <currencyStartYear> in the currency page
And the user enters the currency end day as <currencyEndDay> in the currency page
And the user enters the currency end month as <currencyEndMonth> in the currency page
And the user enters the currency end year as <currencyEndYear> in the currency page
And the user clicks on the save button
Then the user should see the error 'Enter a year, month/year or day/month/year.' for start date
Then the user should see the error 'Enter a year, month/year or day/month/year.' for end date

Examples:
|currency|currencyCountry|currencyStartDay|currencyStartMonth|currencyStartYear|currencyEndDay|currencyEndMonth|currencyEndYear|
|afghani|Albania|01|||01|||
|afghani|Albania||Jan|||Jan||
|afghani|Albania|01|Jan||01|Jan||
|afghani|Albania|01||1988|01||1988|

Scenario: Verify error message required for start and end date
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the currency tab in the data area
And the user clicks on the choose a currency option in the currency page
And the user enters the currency <currency> in the typeahead box in the currency page
And the user clicks on the update link
Then the user should see the list of all other existing currencies (by name) excluding the currency they are currently viewing
When the user enters the currency start day as <currencyStartDay> in the currency page
And the user enters the currency start month as <currencyStartMonth> in the currency page
And the user enters the currency start year as <currencyStartYear> in the currency page
And the user enters the currency end day as <currencyEndDay> in the currency page
And the user enters the currency end month as <currencyEndMonth> in the currency page
And the user enters the currency end year as <currencyEndYear> in the currency page
And the user clicks on the save button
Then the user should see the error 'Required' for start date


Examples:
|currency|currencyCountry|currencyStartDay|currencyStartMonth|currencyStartYear|currencyEndDay|currencyEndMonth|currencyEndYear|
|afghani|Albania||||||||

Scenario: Veifing schematron validation for currency
1. Verifying error message when currency start date is before 1500CE
2. Verifying error message when end date for currency is later than todays date
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the currency tab in the data area
And the user clicks on the choose a currency option in the currency page
And the user enters the currency <currency> in the typeahead box in the currency page
And the user clicks on the update link
When the user enters the currency start year as <currencyStartYear> in the currency page
When the user enters the currency end year as <currencyEndYear> in the currency page
When the user clicks on the save button
Then the user should see the error message at top of page the highlighted fields must be addressed before this update can be saved
And the user should see the error 'Must be after 1500CE.' for start date
And the user should see the error 'Must be no later than today.' for end date

Examples:
|currency|currencyStartYear|currencyEndYear|
|Deutsche Mark|1400|2018|

Scenario: Veifing schematron validation for currency
1. Verifying error message when start date for currency is later than todays date
2. Verifying error message when end date for currency is before than start date
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the currency tab in the data area
And the user clicks on the choose a currency option in the currency page
And the user enters the currency <currency> in the typeahead box in the currency page
And the user clicks on the update link
When the user enters the currency start year as <currencyStartYear> in the currency page
When the user clicks on the save button
Then the user should see the error 'Must be no later than today.' for start date
When the user clicks on the cancel button
And the user clicks on the cancel yes button
Then the user should return to view currency page mode
When the user clicks on the update link
When the user enters the currency end year as <currencyEndYear> in the currency page
When the user clicks on the save button
Then the user should see the error message at top of page the highlighted fields must be addressed before this update can be saved
And the user should see the error 'Must be after start date.' for end date

Examples:
|currency|currencyStartYear|currencyEndYear|
|Deutsche Mark|2018|1976|

Scenario: Verify newly added currency use
1. Verify by default primary = true
2. Verify by default status = active
3. Verify delete option
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the currency tab in the data area
And the user clicks on the choose a currency option in the currency page
And the user enters the currency <currency> in the typeahead box in the currency page
And the user clicks on the update link
And the user clicks on the add country type-ahead option
Then the user should see the list of all the existing country in add country list
When the user enters the country <addCurrencyCountry> in the add country type-ahead box
Then the user should see the primary equals to true by default
And the user should see the status equals to active by default
When the user clicks on the delete option for the additional currency use


Examples:
|currency|addCurrencyCountry|
|Deutsche Mark|Afghanistan|

Scenario: Save newly added currency use
1. @accuracy = year
2. @accuracy = month
3. @accuracy = day
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the currency tab in the data area
And the user clicks on the choose a currency option in the currency page
And the user enters the currency <currency> in the typeahead box in the currency page
And the user clicks on the update link
And the user get the document with get Id for currency with the name as Afghani-test from the database

And the user clicks on the add country type-ahead option
When the user enters the country <addCurrencyCountry> in the add country type-ahead box
When the user enters the currency new start day as <currencyStartDay> in the currency page
And the user enters the currency new start month as <currencyStartMonth> in the currency page
And the user enters the currency new start year as <currencyStartYear> in the currency page
And the user clicks on the save button
And the user clicks on the confirm button
Then the user should see the view currency use from trusted document
And the user reverts the changes to the document

Examples:
|currency|addCurrencyCountry|currencyStartDay|currencyStartMonth|currencyStartYear|currencyEndDay|currencyEndMonth|currencyEndYear|
|Afghani-test|Algeria|||1988|||1988|
|Afghani-test|Algeria||Jan|1988||Jan|1988|
|Afghani-test|Algeria|01|Jan|1988|01|Jan|1988|

Scenario: ZEUS-838 - User will see confirmation message after saving currency edits
Save updates tp existing currency use STORY:920(failing because of invalid data in database)
1. @accuracy = year
2. @accuracy = month
3. @accuracy = day
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the currency tab in the data area
And the user clicks on the choose a currency option in the currency page
And the user enters the currency <currency> in the typeahead box in the currency page
And the user clicks on the update link
And the user get the document with get Id for currency with the name as Afghani-test from the database

When the user enters the currency start day as <currencyStartDay> in the currency page
And the user enters the currency start month as <currencyStartMonth> in the currency page
And the user enters the currency start year as <currencyStartYear> in the currency page
And the user clicks on the save button
And the user clicks on the confirm button
Then the user should see confirmation message
And the user should be redirected to view mode
Then the user should see the view currency use from trusted document
And the user reverts the changes to the document

Examples:
|currency|addCurrencyountry|currencyStartDay|currencyStartMonth|currencyStartYear|currencyEndDay|currencyEndMonth|currencyEndYear|
|Afghani-test|Albania|||1988|||1988|
|Afghani-test|Albania||Jan|1988||Jan|1988|
|Afghani-test|Albania|01|Jan|1988|01|Jan|1988|

Scenario: ZEUS-838 - User will see confirmation message after saving currency edits
 ZEUS-286 - User can save edits to the currency uses and verify the data is save in the zeus document ( Active status ) STORY:920(failing because of invalid data in database)
1. @accuracy = year
2. @accuracy = month
3. @accuracy = day
Meta:
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the currency tab in the data area
And the user clicks on the choose a currency option in the currency page
And the user enters the currency <currency> in the typeahead box in the currency page
And the user clicks on the update link
And the user get the document with get Id for currency with the name as Afghani-test from the database

When the user enters the country <currencyCountry> in the currency usage
When the user enters the currency start day as <currencyStartDay> in the currency page
And the user enters the currency start month as <currencyStartMonth> in the currency page
And the user enters the currency start year as <currencyStartYear> in the currency page
And the user enters the first_new_row_currency_primary_radio_button value as <primary> in the currency page
And the user clicks on the save button
When the user clicks on the confirm button
Then the user should see confirmation message
And the user should be redirected to view mode
Then the user should see the edits to currency uses in zeus document
And the user reverts the changes to the document

Examples:
|currency|currencyCountry|currencyStartDay|currencyStartMonth|currencyStartYear|primary|
|Afghani-test|Angola|||1987|false|
|Afghani-test|Angola||Jun|1987|false|
|Afghani-test|Angola|21|Jun|1987|false|

Scenario: ZEUS-838 - User will see confirmation message after saving currency edits
ZEUS-286 - User can save edits to the currency uses and verify the data is save in the zeus document ( Inactive status ) (AFT implementation issue)
1. @accuracy = year
2. @accuracy = month
3. @accuracy = day (BUG : 1028 & 1029)
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the currency tab in the data area
And the user clicks on the choose a currency option in the currency page
And the user enters the currency <currency> in the typeahead box in the currency page
And the user clicks on the update link
And the user get the document with get Id for currency with the name as Deutsche Mark from the database

When the user enters the country <currencyCountry> in the currency usage
When the user enters the currency start day as <currencyStartDay> in the currency page
And the user enters the currency start month as <currencyStartMonth> in the currency page
And the user enters the currency start year as <currencyStartYear> in the currency page
And the user enters the currency end day as <currencyEndDay> in the currency page
And the user enters the currency end month as <currencyEndMonth> in the currency page
And the user enters the currency end year as <currencyEndYear> in the currency page
And the user enters the first_new_row_currency_primary_radio_button value as <primary> in the currency page
And the user enters the currency usage replaced by as <replacedBy> in the currency page
And the user clicks on the save button
When the user clicks on the confirm button
Then the user should see confirmation message
And the user should be redirected to view mode
Then the user should see the edits to currency uses in zeus document
And the user reverts the changes to the document

Examples:
|currency|currencyCountry|currencyStartDay|currencyStartMonth|currencyStartYear|currencyEndDay|currencyEndMonth|currencyEndYear|primary|replacedBy|
|Gold Francs|Venezuela|||1987|||1999|false|Dram|
|Gold Francs|Venezuela||Jun|1987||Jun|1999|false|Guyana Dollar|
|Gold Francs|Venezuela|21|Jun|1987|23|Jun|1999|false|Kwanza|

Scenario: ZEUS-743 - User will get warning if click away from screen they are editing
Meta:
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the currency tab in the data area
And the user clicks on the choose a currency option in the currency page
And the user enters the currency <currency> in the typeahead box in the currency page
And the user clicks on the update link
When the user clicks on the country tab in the data area
Then the user should see the cancel update confirmation modal
When the user clicks on the cancel no button
Then the user should return to edit currency page mode
When the user clicks on the country tab in the data area
Then the user should see the cancel update confirmation modal
When the user clicks on the cancel yes button
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
Then the user should see the basic info for the selected country

Examples:
|currency|country|
|Rand|Afghanistan|

Scenario: ZEUS-802 Accented characters displaying correctly after saving
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the currency tab in the data area
When the user clicks on the choose a currency option in the currency page
When the user enters the currency <currency> in the typeahead box in the currency page
And the user clicks on the update link
And the user get the document with get Id for currency with the name as Australian Dollar from the database
When the user enters the currency name value as <name> in the currency page
And the user clicks on the save button
When the user clicks on the confirm button
Then the user should see the currency name value as <name> in the currency page
And the user reverts the changes to the document

Examples:
|currency|name|
|Australian Dollar|Australian Dóllar|

Scenario: ZEUS-828 - User can only input numbers in date field for start date and end date
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the currency tab in the data area
And the user clicks on the choose a currency option in the currency page
And the user enters the currency <currency> in the typeahead box in the currency page
And the user clicks on the update link
When the user enters the currency start day as <currencyStartDay> in the currency page
And the user enters the currency start year as <currencyStartYear> in the currency page
When the user enters the currency end day as <currencyEndDay> in the currency page
And the user enters the currency end year as <currencyEndYear> in the currency page
And the user clicks on the save button
Then the user should see the error Invalid Date for start date
Then the user should see the error Invalid Date for end date
Then the user should see the error message at top of page the highlighted fields must be addressed before this update can be saved

Examples:
|currency|currencyStartDay|currencyStartYear|currencyEndDay|currencyEndYear|
|afghani|test|test|test|test|

Scenario: ZEUS-869 remove currency use
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the currency tab in the data area
And the user clicks on the choose a currency option in the currency page
And the user enters the currency <currency> in the typeahead box in the currency page
And the user clicks on the update link
And the user clicks on the add country type-ahead option
When the user enters the country <addCurrencyCountry> in the add country type-ahead box
When the user clicks on delete currency usage
Then the user should see the delete row confirmation modal in the currency page
When the user clicks on the no button in the delete row confirmation modal in the currency page
Then the user should see the newly added usage in the currency page
When the user clicks on delete currency usage
When the user clicks on the yes button in the delete row confirmation modal in the currency page
Then the user should not see the newly added usage in the currency page

Examples:
|currency|addCurrencyCountry|
|Ariary|Algeria|

Scenario: ZEUS-826 User can't add duplicate uses for a currency in the same country for new row
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the currency tab in the data area
And the user clicks on the choose a currency option in the currency page
And the user enters the currency <currency> in the typeahead box in the currency page
And the user clicks on the update link
And the user clicks on the add country type-ahead option
When the user enters the country <addCurrencyCountry> in the add country type-ahead box

When the user enters the currency new start day as <currencyStartDay> in the currency page
And the user enters the currency new start month as <currencyStartMonth> in the currency page
And the user enters the currency new start year as <currencyStartYear> in the currency page

And the user clicks on the add country type-ahead option
When the user enters the country <addCurrencyCountry> in the add country type-ahead box

When the user enters the currency new start day as <currencyStartDay> in the currency page
And the user enters the currency new start month as <currencyStartMonth> in the currency page
And the user enters the currency new start year as <currencyStartYear> in the currency page

And the user clicks on the save button
Then the user should see the error Currency may not be used in a country more than once in the same date range for start date
Then the user should see the error Currency may not be used in a country more than once in the same date range for end date
Then the user should see the error message at top of page the highlighted fields must be addressed before this update can be saved

Examples:
|currency|addCurrencyCountry|currencyStartDay|currencyStartMonth|currencyStartYear|
|Bahrain Dinar|Algeria|21|Jun|1987|


Scenario: ZEUS-826 User can't add duplicate uses for a currency in the same country for existing row
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the currency tab in the data area
And the user clicks on the choose a currency option in the currency page
And the user enters the currency <currency> in the typeahead box in the currency page
And the user clicks on the update link
And the user clicks on the save button
Then the user should see the error Currency may not be used in a country more than once in the same date range for start date
Then the user should see the error Currency may not be used in a country more than once in the same date range for end date
Then the user should see the error message at top of page the highlighted fields must be addressed before this update can be saved

Examples:
|currency|
|Ariary|

Scenario: Verify user should get the error "Duplicate primary currency exists" when updating a currency use for a country which is having a primary currency already.

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the currency tab in the data area
And the user clicks on the choose a currency option in the currency page
And the user enters the currency <currency> in the typeahead box in the currency page
And the user clicks on the update link
And the user clicks on the add country type-ahead option
When the user enters the country <addCurrencyCountry> in the add country type-ahead box

When the user enters the currency new start day as <currencyStartDay> in the currency page
And the user enters the currency new start month as <currencyStartMonth> in the currency page
And the user enters the currency new start year as <currencyStartYear> in the currency page
And the user enters the first_new_row_currency_primary_radio_button value as <primary> in the currency page
And the user clicks on the save button
Then the user should see the duplicate_primary_currency_error_message as Duplicate primary currency exists for 1 rows
Then the user should see the error message at top of page the highlighted fields must be addressed before this update can be saved

Examples:
|currency|addCurrencyCountry|currencyStartDay|currencyStartMonth|currencyStartYear|primary|
|Indian Rupee|USA|01|Jan|1980|true|



Scenario: Verify user can add a new non-primary currency for a country which is having a primary currency already.

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the currency tab in the data area
And the user clicks on the choose a currency option in the currency page
And the user enters the currency <currency> in the typeahead box in the currency page
And the user clicks on the update link
And the user get the document with get Id for currency with the name as Australian Dollar from the database
And the user clicks on the add country type-ahead option
When the user enters the country <addCurrencyCountry> in the add country type-ahead box
When the user enters the currency new start day as <currencyStartDay> in the currency page
And the user enters the currency new start month as <currencyStartMonth> in the currency page
And the user enters the currency new start year as <currencyStartYear> in the currency page
And the user enters the first_new_row_currency_primary_radio_button value as <primary> in the currency page
And the user clicks on the save button
When the user clicks on the confirm button
Then the user should see confirmation message
And the user should be redirected to view mode
And the user reverts the changes to the document

Examples:
|currency|addCurrencyCountry|currencyStartDay|currencyStartMonth|currencyStartYear|primary|
|Australian Dollar|USA|01|Jan|1980|false|

Scenario: Verify user should get the error "Duplicate primary currency exists" for multiple rows when updating a currency use for multiple countries which are having a primary currency already.

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the currency tab in the data area
And the user clicks on the choose a currency option in the currency page
And the user enters the currency <currency> in the typeahead box in the currency page
And the user clicks on the update link
And the user get the document with get Id for currency with the name as Australian Dollar from the database
And the user clicks on the add country type-ahead option
When the user enters the country <addCurrencyCountry> in the add country type-ahead box
When the user enters the currency new start day as <currencyStartDay> in the currency page
And the user enters the currency new start month as <currencyStartMonth> in the currency page
And the user enters the currency new start year as <currencyStartYear> in the currency page
And the user enters the first_new_row_currency_primary_radio_button value as <primary> in the currency page
And the user clicks on the add country type-ahead option
When the user enters the country <addSecondCurrencyCountry> in the add country type-ahead box
When the user enters the currency new start day as <currencyStartDay> in the currency page
And the user enters the currency new start month as <currencyStartMonth> in the currency page
And the user enters the currency new start year as <currencyStartYear> in the currency page
And the user enters the first_new_row_currency_primary_radio_button value as <primary> in the currency page
And the user clicks on the save button
Then the user should see the duplicate_primary_currency_error_message as Duplicate primary currency exists for 2 rows
Then the user should see the error message at top of page the highlighted fields must be addressed before this update can be saved

Examples:
|currency|addCurrencyCountry|currencyStartDay|currencyStartMonth|currencyStartYear|primary|addSecondCurrencyCountry|
|Australian Dollar|USA|01|Jan|1980|true|UK|

Scenario: Verify user should get the multiple errors "Duplicate primary currency exists",
"Currency may not be used in a country more than once in the same date range for start date" and
"Currency may not be used in a country more than once in the same date range for end date"
when updating a currency use for a country which is having a primary currency already and the date ranges are overlapping with previous one.

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the currency tab in the data area
And the user clicks on the choose a currency option in the currency page
And the user enters the currency <currency> in the typeahead box in the currency page
And the user clicks on the update link
And the user clicks on the add country type-ahead option
When the user enters the country <addCurrencyCountry> in the add country type-ahead box
When the user enters the currency new start day as <currencyStartDay> in the currency page
And the user enters the currency new start month as <currencyStartMonth> in the currency page
And the user enters the currency new start year as <currencyStartYear> in the currency page
And the user enters the first_new_row_currency_primary_radio_button value as <primary> in the currency page
And the user clicks on the add country type-ahead option
When the user enters the country <addCurrencyCountry> in the add country type-ahead box
When the user enters the currency new start day as <currencyStartDay> in the currency page
And the user enters the currency new start month as <currencyStartMonth> in the currency page
And the user enters the currency new start year as <currencyStartYear> in the currency page
And the user enters the first_new_row_currency_primary_radio_button value as <primary> in the currency page
And the user clicks on the save button
Then the user should see the error Currency may not be used in a country more than once in the same date range for start date
Then the user should see the error Currency may not be used in a country more than once in the same date range for end date
Then the user should see the duplicate_primary_currency_error_message as Duplicate primary currency exists for 2 rows
Then the user should see the error message at top of page the highlighted fields must be addressed before this update can be saved

Examples:
|currency|addCurrencyCountry|currencyStartDay|currencyStartMonth|currencyStartYear|primary|
|Afghani-test|Angola|01|Jan|1980|true|