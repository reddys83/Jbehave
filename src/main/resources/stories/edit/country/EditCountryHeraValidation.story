Meta:@EditCountryHeraValidation @Edit @Country

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal
JIRA ID - ZEUS-920 - Properly handle Hera validation errors

Scenario: User will see the message "Technical error. Update not successful. Please contact Accuity Helpdesk"
when tries to update the Country and experiences an error resulting in Hera failure to update the document(s)

Meta:
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
And the user clicks on the update link
And the user enters time zones summary <timeZoneSummary> in the basic info country page
And the user clicks on the save button
And the user clicks on the confirm button
Then the user should see the hera validation error in the country page

Examples:
|country|timeZoneSummary|
|Northern Mariana Islands|+1 hour
