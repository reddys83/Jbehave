Meta:@Design

Narrative:
In order to view stub entry details
As a user when I search by Name, FID, TFPID and click on the search results card I can view details
I want to cover the requirements mentioned in JIRA ID - Zeus54 - (User can view entity stub entry)

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