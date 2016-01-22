Meta:@Design

Narrative:
In order to view stub entry details
As a user when I search by Name, FID, TFPID and click on the search results card I can view details
I want to cover the requirements mentioned in JIRA ID - Zeus54 - (User can view entity stub entry)

Scenario: Edits for currency use will be validated
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the currency tab in the data area
And the user clicks on the choose a currency option
And the user enters the currency <currency> in the typeahead box
And the user clicks on the update currency link
Then the user should see the list of all other existing currencies (by name) excluding the currency they are currently viewing
Then the user should see the error 'Please enter a year for currency use start date.' for start date
Then the user should see the error 'Please enter a month for currency use start date.' for start date
Then the user should see the error 'Please enter a year for currency use start date.' for end date
Then the user should see the error 'Please enter a month for currency use start date.' for end date
Then the user should see the error 'Required' for end date
Then the user should see the error 'Required' for start date
Examples:
|currency|
|afghani|