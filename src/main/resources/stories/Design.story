Meta:@Design


Scenario: ZEUS-286 - User can save edits to the currency uses and verify the data is save in the zeus document ( Inactive status ) (AFT implementation issue)
1. @accuracy = year
2. @accuracy = month
3. @accuracy = day
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
And the user enters the currency usage primary value as <primary> in the currency page
And the user enters the currency usage replaced by as <replacedBy> in the currency page
And the user clicks on the save button
When the user clicks on the confirm button
Then the user should see the edits to currency uses in zeus document
And the user reverts the changes to the document

Examples:
|currency|currencyCountry|currencyStartDay|currencyStartMonth|currencyStartYear|currencyEndDay|currencyEndMonth|currencyEndYear|primary|replacedBy|
|Gold Francs|Venezuela|||1987|||1999|false|Dram|
|Gold Francs|Venezuela||Jun|1987||Jun|1999|false|Guyana Dollar|
|Gold Francs|Venezuela|21|Jun|1987|23|Jun|1999|false|Kwanza|