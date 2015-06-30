Meta:@Logout

Narrative:
In order to view stub entry details
As a user when I search by Name, FID, TFPID and click on the search results card I can view details
I want to cover the requirements mentioned in
JIRA ID - ZEUS-194 - user can log out of zeus

Scenario: Successful logout
Given user is on the login page
When the user enters username as <username> in the login page
And the user enters password as <password> in the login page
And the user clicks on the login button in the login page
Then the user should see the search page
When the user moves the cursor to the settings in the search page
When the user clicks on the logout link in the search page
Then the user is successfully logged out
When the user clicks on the browser navigate back button
Then the user is still logged out

Examples:
|username|password|
|qatest|password1|

