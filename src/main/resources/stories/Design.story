Meta:@Design

Narrative:
In order to view stub entry details
As a user when I search by Name, FID, TFPID and click on the search results card I can view details
I want to cover the requirements mentioned in JIRA ID - Zeus54 - (User can view entity stub entry)

Scenario: Verify error message for year for start and end date
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the currency tab in the data area
And the user clicks on the choose a currency option
And the user enters the currency <currency> in the typeahead box
And the user clicks on the update currency link
When the user enters the currency start day as <currencyStartDay>
And the user enters the currency start month as <currencyStartMonth>
And the user enters the currency start year as <currencyStartYear>
And the user enters the currency end day as <currencyEndDay>
And the user enters the currency end month as <currencyEndMonth>
And the user enters the currency end year as <currencyEndYear>
Then the user should see the error 'Please enter a year for currency use start date.' for start date
Then the user should see the error 'Please enter a year for currency use end date.' for end date

Examples:
|currency|currencyCountry|currencyStartDay|currencyStartMonth|currencyStartYear|currencyEndDay|currencyEndMonth|currencyEndYear|
|afghani|Albania|01||||01|||
