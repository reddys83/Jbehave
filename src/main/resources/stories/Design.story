Meta:@Design

Narrative:
In order to view stub entry details
As a user when I search by Name, FID, TFPID and click on the search results card I can view details
I want to cover the requirements mentioned in JIRA ID - Zeus54 - (User can view entity stub entry)

Scenario: a. Veify the currency selection drop-down is disabled in update mode
b. Verify the currency details are comming from trusted document
c. verify when user clicks "Cancel" changes are not saved and screen returns to view mode
Meta:
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the currency tab in the data area
And the user clicks on the choose a currency option
And the user enters the currency <currency> in the typeahead box
And the user clicks on the update currency link
Then the user should see the currency selection disabled
Then the user should see the edit currency details from trusted document
When the user clicks on the cancel button
And the user clicks on the cancel yes button
Then the user should return to view mode of the currency page

Examples:
|currency|
|Afghani-test|
