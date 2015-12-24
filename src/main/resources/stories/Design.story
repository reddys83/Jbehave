Meta:@Design

Narrative:
In order to view stub entry details
As a user when I search by Name, FID, TFPID and click on the search results card I can view details
I want to cover the requirements mentioned in JIRA ID - Zeus54 - (User can view entity stub entry)

Scenario: View for taxonomy by name
Given a user is on the search page
When the user clicks on the admin tab in the search page
And the user clicks on the taxonomies tab in the data area
And the user clicks on the choose a taxonomy option
Then the user should see the list of all existing taxonomies by name
And the list should not have any duplicates