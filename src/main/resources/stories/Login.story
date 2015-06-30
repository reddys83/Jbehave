Meta:@Login

Narrative:
In order to view stub entry details
As a user when I search by Name, FID, TFPID and click on the search results card I can view details
I want to cover the requirements mentioned in
JIRA ID - ZEUS-68 - An authorized user can log in to Zeus

Scenario: Inavlid username/password combination
Given user is on the login page
When the user enters username as <username> in the login page
And the user enters password as <password> in the login page
And the user clicks on the login button in the login page
Then the user should see the error message please enter a valid username/password combination in the login page

Examples:
|username|password|
|qatest|password2|
|qates|password1|

Scenario: All fields are required
Given user is on the login page
When the user enters username as <username> in the login page
And the user enters password as <password> in the login page
And the user clicks on the login button in the login page
Then the user should see the error message all fields are required in the login page

Examples:
|username|password|
|qatest||
||password1|

Scenario: Successful login
Given user is on the login page
When the user enters username as <username> in the login page
And the user enters password as <password> in the login page
And the user clicks on the login button in the login page
Then the user should see the search page

Examples:
|username|password|
|qatest|password1|

Scenario: BUG-ID - ZEUS-231
Given user is on the login page
When the user enters username as <username> in the login page
And the user enters password as <password> in the login page
And the user clicks on the login button in the login page
Then the user should see the error message please enter a valid username/password combination in the login page
When the user refreshes the login page
Then the user should see the login page without any errors

Examples:
|username|password|
|qatest|password2|

Scenario: BUG-ID - ZEUS-236
Given user is on the login page
When the user clicks on the login button in the login page
Then the user should see the error message all fields are required in the login page
When the user enters username as <username> in the login page
And the user enters password as <password> in the login page
Then the user should see the error message please enter a valid username/password combination in the login page

Examples:
|username|password|
|qatest|password2|