Meta:@Logout

Narrative:
In order to view stub entry details
As a user when I search by Name, FID, TFPID and click on the search results card I can view details
I want to cover the requirements mentioned in
JIRA ID - ZEUS-194 - user can log out of zeus

Scenario: Successful logout
Given user is on the login page
When the user enters username as <username>
And the user enters password as <password>
And the user clicks on the login button
Then the user should see the search page
When the user moves the cursor to the settings in the search page
When the user clicks on the logout link
Then the user is successfully logged out
When I click the back button on the browser
Then the user is still logged out

Examples:
|username|password|
|qatest|password1|

