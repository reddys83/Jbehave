Meta:@ResetPassword

Narrative:
In order to view stub entry details
As a user when I search by Name, FID, TFPID and click on the search results card I can view details
I want to cover the requirements mentioned in
JIRA ID - ZEUS-99 - send password reset email


Scenario:
Bug ID - ZEUS-282: IE 11 does not show any messages on clicking submit
a. Valid username, Invalid Email - error message should be displayed for email
b. Invalid username, valid Email - error message should be displayed for username
c. Valid Username and no email address - error message should be displayed to enter valid email address
d. Valid email address and no Username - error message should be displayed to enter valid username
e. no username and no email address - error message all fields are required
e. Valid Username and valid Email - password reset confirmation message is displayed
f. Return to login page
Meta:
Given user is on the login page
When the user clicks on the forgot password link in the login page
Then the user should see the reset password page
And the user should see the instructions to provide username and email id in the reset password page
When the user enters a valid username in the reset password page
And the user enters an invalid email address a@a.com in the reset password page
And the user clicks on the submit button in the reset password page
Then the user should see the error message that says email does not match with the ID
When the user refreshes the reset password page

And the user enters an invalid username ab in the reset password page
And the user enters a valid email address in the reset password page
And the user clicks on the submit button in the reset password page
Then the user should see the error message for invalid username in the reset password page
When the user refreshes the reset password page

And the user enters a valid username in the reset password page
And the user clicks on the submit button in the reset password page
Then the user should see the error message to enter a valid email address
When the user refreshes the reset password page

And the user enters a valid email address in the reset password page
And the user clicks on the submit button in the reset password page
Then the user should see the error message for invalid username in the reset password page
When the user refreshes the reset password page

And the user clicks on the submit button in the reset password page
Then the user should see the error message that all fields are required
When the user refreshes the reset password page

And the user enters a valid username in the reset password page
And the user enters a valid email address in the reset password page
And the user clicks on the submit button in the reset password page
Then the user should see the password reset request confirmation message in the reset password page

When the user clicks on return to login link in the reset password page
Then the user should see the login page


