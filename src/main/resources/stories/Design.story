Meta:@Design

Scenario: Save updates tp existing currency use
1. @accuracy = year
2. @accuracy = month
3. @accuracy = day
Meta:
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the currency tab in the data area
And the user clicks on the choose a currency option
And the user enters the currency <currency> in the typeahead box
And the user clicks on the update currency link
When the user enters the currency start day as <currencyStartDay>
And the user enters the currency start month as <currencyStartMonth>
And the user enters the currency start year as <currencyStartYear>
And the user clicks on the save button
And the user clicks on the confirm button
Then the user should see the view currency use from trusted document
And the user reverts the changes to the currency

Examples:
|currency|currencyStartDay|currencyStartMonth|currencyStartYear|
|Bahrain Dinar|||1990|
|Baht|||1990|
