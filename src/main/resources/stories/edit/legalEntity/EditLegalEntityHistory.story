Meta:@EditLegalEntityHistory @Edit @LegalEntity @AllStories

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal
JIRA ID - ZEUS-915 - User can edit Legal Entity's History

Scenario:
a) Verify legalEntity History value can be updated with a  new value and can be saved.
b) Verify legalEntity History can be updated with the same value and the confirmation summary is not displayed.

Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
When the user clicks on the legal entity history link in the navigation bar
When the user gets the document with get Id for legalentity with the fid as <entity> from the database
And the user clicks on the legalEntity update link
And the user enters value as <historyValue> in the legalentity history field
And the user clicks on the save button
Then the user should see the save confirmation modal
And the user should see the below summary changes in confirmation modal
|Summary|
|History|
When the user clicks on the confirm button
And the user clicks on the legalEntity update link
And the user enters value as <historyValue> in the legalentity history field
And the user clicks on the save button
Then the user should see the save confirmation modal
And the user should not see the below summary changes in confirmation modal
|Summary|
|History|
When the user clicks on the confirm button
Then the user should see the edits to legal entity history as <historyValue> for fid <fid> in zeus document
Then the user reverts the changes to the document

Examples:
|entity|searchBy|fid|historyValue|ConfirmationSummary|
|1717|FID|1717|legalentity history|Summary|

Scenario:
a) Verify that the Legal Entity's history field max length is 10000 characters only.
b) Verify that blank value can be entered and saved in History field.
Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the legal entity history link in the navigation bar
And the user clicks on the legalEntity update link
And the user gets the document with get Id for legalentity with the fid as <entity> from the database
Then the user should see the history text area field length as 10000
When the user enters value as <historyValue> in the legalentity history field
And the user clicks on the save button
Then the user should see the save confirmation modal
When the user clicks on the confirm button
Then the user should see the edits to legal entity history as <historyValue> for fid <fid> in zeus document
Then the user reverts the changes to the document

Examples:
|entity|searchBy|fid|historyValue|
|1165|FID|1165||