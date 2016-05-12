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