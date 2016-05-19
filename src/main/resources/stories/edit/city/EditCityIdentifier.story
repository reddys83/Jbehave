

Narrative:
As a user
I want to perform an action
So that I can achieve a business goa

JIRA ID - ZEUS-972 - User can edit City's Identifiers

Scenario : User can edit an existing City identifiers- Verify that an error message is displayed for required and invalid fields when existing identifier - "Type","Value" and "Status" on Saving.
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
And the user enters the country <country> in the type-ahead box
And the user enters the area <area> in the type-ahead box
And the user enters the city <city> in the type-ahead box
When the user enters identifier type as <identifierType> in the basic info city page
When the user enters an invalid identifier value as <identifierValueIncorrect> in the city page
When the user enters an  identifier status as <identifierValueIncorrect> in the city page
And the user clicks on the save button
Then the user should see the error message for the  identifier type field in the city page
Then the user should see the error message for the  identifier value field in the city page
Then the user should see the error message for the  identifier status field in the city page

Examples:
|country|city|identifierType|identifierValue|identifierStatus|
|USA|Alabama||