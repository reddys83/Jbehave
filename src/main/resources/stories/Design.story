Meta:@Design


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

