Meta:@EditLegalEntityBasicInfo @Edit @legalEntity

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal
JIRA ID - ZEUS-906 - User can edit Legal Entity's Lead Institution flag

Scenario: Select the value as True for Lead Institution flag and Save for a legalEntity with a default value as True or False
       a. Select the value as False for Lead Institution flag and Save for a legalEntity with a default value as True or False
       b. Select the value as True for Lead Institution flag and Save for a legalEntity with a default value as null
       c. Select the value as False for Lead Institution flag and Save for a legalEntity with a default value as null
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the update link
Then the user should see the legalentity's lead institution value as in trusted document with fid<fid>
When the user get the document with get Id for legalentity with the fid as selectedEntity from the database
And the user selects lead institution value <leadInstitutionflag> in the basicinfo legalentity page
And the user clicks on the save button
And the user clicks on the confirm button
Then the user should see the legalentity's lead institution value as <leadInstitutionflag>
And the user should see the legalentity's lead institution value as in zeus document with fid<fid>
And the user reverts the changes to the document


Examples:
|entity|searchBy|fid|leadInstitutionflag|
|1038|FID|1038|true|

