Meta:@EditLegalEntityBasicInfo @Edit @legalEntity

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal
JIRA ID - ZEUS-906 - User can edit Legal Entity's Lead Institution flag

Scenario: Verify the default Edit value and Save Lead Institution value for a legal entity on legalEntity page
       a. Select the value as True for Lead Institution flag and Save for a legalEntity with a default value as True or False
       b. Select the value as False for Lead Institution flag and Save for a legalEntity with a default value as True or False
       c. Select the value as True for Lead Institution flag and Save for a legalEntity with a default value as null
       d. Select the value as False for Lead Institution flag and Save for a legalEntity with a default value as null
       e. Do not select any value and Save for a legalEntity with a default value as null
       f. Verify the save confirmation modal

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the update link
Then the user should see the legalentity's lead institution value as in trusted document with fid <fid>
When the user gets the document with get Id for legalentity with the fid as <entity> from the database
And the user selects lead institution value <leadInstitutionflag> in the basicinfo legalentity page
And the user clicks on the save button
Then the user should see the save confirmation modal
When the user clicks on the confirm button
Then the user should see leadInstitution value as <leadInstitutionflag> for fid <fid> in zeus document
And the user reverts the changes to the document

Examples:
|entity|searchBy|fid|leadInstitutionflag|
|1038|FID|1038|true|
|1038|FID|1038|false|
|1165|FID|1165|true|
|1165|FID|1165|false|
|1165|FID|1165||

Scenario: Verify that the Lead Institution label is not shown during edit mode for a legal entity which do not have a legal entity
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the update link
Then the user should not see lead institution label and value

Examples:
|entity|searchBy|fid|
|128|FID|128|

Scenario:User will get warning if click away from screen they are editing
Meta:
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the update link
When the user clicks on the currency tab in the data area
Then the user should see the cancel update confirmation modal
When the user clicks on the cancel no button
Then the user should return to edit legalentity page mode
When the user clicks on the currency tab in the data area
Then the user should see the cancel update confirmation modal
When the user clicks on the cancel yes button
And the user clicks on the choose a currency option in the currency page
And the user enters the currency <currency> in the typeahead box in the currency page
Then the user should see the currency page

Examples:
|entity|searchBy|fid|leadInstitutionflag|currency|
|1038|FID|1038|true|Rand|


Scenario: User will see summary of changes made in confirmation modal
Meta:
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the update link
And the user selects lead institution value other than default value in the basicinfo legalentity page
And the user clicks on the save button
Then the user should see the save confirmation modal
And the user should see the below summary changes in confirmation modal
|Summary|
|Basic Info|

When the user clicks on the return button
Then the user should return to edit legalentity page mode

Examples:
|entity|searchBy|fid|
|1038|FID|1038|

