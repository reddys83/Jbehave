Meta:@Design


Scenario: ZEUS-826 User can't add duplicate uses for a currency in the same country
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

Scenario: The user should see the confirmation modal to delete places row message Please confirm - would you like to delete this row?
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
When the user clicks on the legal entity locations link in the navigation bar
And the user clicks on the update link
When the user gets the document with get Id for legalentity with the fid as <entity> from the database
When the user clicks on the add new location summary button in legalentity location
And the user select type as <type> in the legalentity location summary
And the user enters value as <value> in the legalentity location summary
And the user clicks on delete button for legal entity location summary
Then the user should see the delete row confirmation modal in the legalEntity page
When the user clicks on the no button in the delete row confirmation modal in the legalEntity page
Then the user should see the newly added legalentity location summary
When the user clicks on delete button for legal entity location summary
When the user clicks on the yes button in the delete row confirmation modal in the legalEntity page
Then the user should not see the newly added legalentity location summary


Examples:
|entity|searchBy|fid|type|value|
|1717|FID|1717|NumberOfBranches|100|

