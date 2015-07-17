Meta:@Currency

Narrative:
In order to view and edit the currencies
As a user
I want to cover the requirements mentioned in
JIRA ID - ZEUS-241 - (User can view entity stub entry)

Scenario: Verify currency list
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the currency tab in the data area
And the user clicks on the choose a currency option
Then the user should see the list of all existing currencies by full name

Scenario: Verify currency list matches the search string
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the currency tab in the data area
And the user clicks on the choose a currency option
And the user starts typing the name of a currency as Afg in the currency input box
Then the user should see the drop-down list of the currencies matching the input characters

Scenario: Verify no results match
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the currency tab in the data area
And the user clicks on the choose a currency option
And the user starts typing the name of a currency as dfbhjb in the currency input box
Then the user should see the option no results match for the searched string