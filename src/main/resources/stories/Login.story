Meta:@Login

Narrative:
In order to view stub entry details
As a user when I search by Name, FID, TFPID and click on the search results card I can view details
I want to cover the requirements mentioned in
JIRA ID - ZEUS-68 - An authorized user can log in to Zeus

Scenario: Successful login
Given user is on the login page
When the user enters username as <username>
And the user enters password as <password>
And the user clicks on the login button
Then the user should see the search page

Examples:
|username|password|
|||

Scenario: Inavlid username/password combination
Given user is on the login page
When the user enters username as <username>
And the user enters password as <password>
And the user clicks on the login button
Then the user should see the error message please enter a valid username/password combination

Examples:
|username|password|
|||
|||

Scenario: All fields are required
Given user is on the login page
When the user enters username as <username>
And the user enters password as <password>
And the user clicks on the login button
Then the user should see the error message all fields are required

Examples:
|username|password|
|||
|||