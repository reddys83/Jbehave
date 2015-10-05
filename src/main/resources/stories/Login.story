Meta:@Login

Narrative:
In order to view stub entry details
As a user when I search by Name, FID, TFPID and click on the search results card I can view details
I want to cover the requirements mentioned in
JIRA ID - ZEUS-68 - An authorized user can log in to Zeus

Scenario: valid username and invalid password
Given user is on the login page
When the user enters a valid username on the login page
And the user enters an invalid password on the login page
And the user clicks on the login button in the login page
Then the user should see the error message please enter a valid username/password combination in the login page

Scenario: invalid username and valid password
Given user is on the login page
When the user enters an invalid username on the login page
And the user enters an invalid password on the login page
And the user clicks on the login button in the login page
Then the user should see the error message please enter a valid username/password combination in the login page

Scenario: All fields are required
Given user is on the login page
When the user enters a valid username on the login page
And the user clicks on the login button in the login page
Then the user should see the error message all fields are required in the login page


Scenario: All fields are required
Given user is on the login page
When the user enters a valid password on the login page
And the user clicks on the login button in the login page
Then the user should see the error message all fields are required in the login page


Scenario: BUG-ID - ZEUS-231
Given user is on the login page
When the user enters a valid username on the login page
And the user enters an invalid password on the login page
And the user clicks on the login button in the login page
Then the user should see the error message please enter a valid username/password combination in the login page
When the user refreshes the login page
Then the user should see the login page without any errors


Scenario: BUG-ID - ZEUS-236
Given user is on the login page
When the user clicks on the login button in the login page
Then the user should see the error message all fields are required in the login page
When the user enters a valid username on the login page
And the user enters an invalid password on the login page
When the user clicks on the login button in the login page
Then the user should see the error message please enter a valid username/password combination in the login page
