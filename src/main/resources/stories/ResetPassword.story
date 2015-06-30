Meta:@ResetPassword

Narrative:
In order to view stub entry details
As a user when I search by Name, FID, TFPID and click on the search results card I can view details
I want to cover the requirements mentioned in
JIRA ID - ZEUS-99 - send password reset email

Scenario: Successful Reset
Given user is on the login page
When the user clicks on the forgot password link in the login page
Then the user should see the reset password page
And the user should see the instructions to provide username and email id in the reset password page
When the user enters username as <username> in the reset password page
And the user enters email id as <emailId> in the reset password page
And the user clicks on the submit button in the reset password page
Then the user should see the password reset request confirmation message in the reset password page

Examples:
|username|emailId|
|qatest|gajendra.sahu@accuity.com|

Scenario: Invalid Email
Given user is on the login page
When the user clicks on the forgot password link in the login page
Then the user should see the reset password page
And the user should see the instructions to provide username and email id in the reset password page
When the user enters username as <username> in the reset password page
And the user enters email id as <emailId> in the reset password page
And the user clicks on the submit button in the reset password page
Then the user should see the error message for email does not match in the reset password page

Examples:
|username|emailId|
|qatest|gajendra.sahu@accuit.com|

Scenario: Invalid Username
Given user is on the login page
When the user clicks on the forgot password link in the login page
Then the user should see the reset password page
And the user should see the instructions to provide username and email id in the reset password page
When the user enters username as <username> in the reset password page
And the user enters email id as <emailId> in the reset password page
And the user clicks on the submit button in the reset password page
Then the user should see the error message for invalid username in the reset password page

Examples:
|username|emailId|
|qates|gajendra.sahu@accuity.com|

Scenario: Invalid Username
Given user is on the login page
When the user clicks on the forgot password link in the login page
Then the user should see the reset password page
And the user should see the instructions to provide username and email id in the reset password page
When the user enters username as <username> in the reset password page
And the user enters email id as <emailId> in the reset password page
And the user clicks on the submit button in the reset password page
Then the user should see the error message for all fields are required in the reset password page

Examples:
|username|emailId|
|qatest||

Scenario: Return to login
Given user is on the login page
When the user clicks on the forgot password link in the login page
Then the user should see the reset password page
And the user should see the instructions to provide username and email id in the reset password page
When the user clicks on return to login link in the reset password page
Then the user should see the login page
