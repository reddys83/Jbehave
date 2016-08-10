Meta:@EditOfficeStatistics @Edit @Office @AllStories

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal
JIRA ID - ZEUS-1081 - User can edit Office's statistics

Scenario: User is updating an office statistics page and enters value for 'total ATMs', 'total checking accounts', 'total saving account' fields and saves the office page
1- User verifies whether the current value in statistics page is defaulted from trusted
2- User verifies confirmation dialog modal has summary change text as 'Basic Info / Statistics'
3- User verifies that 'total ATMs', 'total checking accounts', 'total savings account' values are saved and reflects in UI
4- User verifies that 'total ATMs', 'total checking accounts', 'total savings account' value are saved and reflects in Zeus


Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
When the user clicks on the office all link in the navigation bar
And the user clicks on the office statistics link in the navigation bar
And the user clicks on the office update link
Then the user should see the statistics values same as in trusted document for fid <officeFid>
When the user gets the document with get id for offices with the <officeFid> from the database
And the user enters the office total atms value as <totalAtms>
And the user enters the office total checking accounts value as <totalCheckingAccounts>
And the user enters the office total savings accounts value as <totalSavingsAccounts>
And the user clicks on the save button
Then the user should see the below summary changes in confirmation modal
|Summary|
|Statistics|
Then the user should see the save confirmation modal
When the user clicks on the confirm button
Then the user should see the successful update message at top of the office page
Then the user verifies the office statistics field values in UI
Then the user verifies the office statistics values as in zeus document for fid <officeFid>
And the user reverts the changes to the document



Examples:
|entity|searchBy|fid|officeFid|totalAtms|totalCheckingAccounts|totalSavingsAccounts|
|1038|FID|1038|1038-52|12345|12345|12345|
|1038|FID|1038|1038-52||||

Scenario: User is updating an office statistics page and enters existing value for 'total ATMs', 'total checking accounts', 'total saving account' fields
and saves the office page
1- User verifies confirmation dialog modal do not have summary change text as 'Basic Info / Statistics'
2- User verifies that 'total ATMs', 'total checking accounts', 'total savings account' values are saved and retains the old values in UI
3- User verifies that 'total ATMs', 'total checking accounts', 'total savings account' value are saved and retains the old values in Zeus


Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
When the user clicks on the office all link in the navigation bar
And the user clicks on the office statistics link in the navigation bar
And the user clicks on the office update link
When the user gets the document with get id for offices with the <officeFid> from the database
And the user enters the office total atms value as <totalAtms>
And the user enters the office total checking accounts value as <totalCheckingAccounts>
And the user enters the office total savings accounts value as <totalSavingsAccounts>
And the user clicks on the save button
Then the user should see the save confirmation modal
When the user clicks on the confirm button
Then the user should see the successful update message at top of the office page
When the user clicks on the office update link
When the user enters the office total atms value as <totalAtms1>
When the user enters the office total checking accounts value as <totalCheckingAccounts1>
When the user enters the office total savings accounts value as <totalSavingsAccounts1>
When the user clicks on the save button
Then the user should not see the below summary changes in confirmation modal
|Summary|
|Statistics|
Then the user should see the save confirmation modal
When the user clicks on the confirm button
Then the user should see the successful update message at top of the office page
Then the user verifies the office statistics new field values in UI
Then the user verifies the office statistics new values as in zeus document for fid <officeFid>
And the user reverts the changes to the document

Examples:
|entity|searchBy|fid|officeFid|totalAtms|totalCheckingAccounts|totalSavingsAccounts|totalAtms1|totalCheckingAccounts1|totalSavingsAccounts1|
|1038|FID|1038|1038-52|12345|12345|12345|12345|12345|12345|


Scenario: User is updating an office statistics page and enters value exceeding 8 numbers for 'total ATMs', 'total checking accounts', 'total saving account' fields
and saves the office page
1- User verifies the timezone 'total atm', 'total checking accounts','total savings accounts' field are having max length attribute as '8'
2- User verifies that 'total ATMs', 'total checking accounts', 'total savings account' values are limited to 8 numbers in UI
3- User verifies that 'total ATMs', 'total checking accounts', 'total savings account' value are limited to 8 numbers in zeus

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
When the user clicks on the office all link in the navigation bar
And the user clicks on the office statistics link in the navigation bar
And the user clicks on the office update link
When the user gets the document with get id for offices with the <officeFid> from the database
And the user enters the office total atms value as <totalAtms>
And the user enters the office total checking accounts value as <totalCheckingAccounts>
And the user enters the office total savings accounts value as <totalSavingsAccounts>
Then the user verifies office statistics page fields max length attribute is 8
When the user clicks on the save button
Then the user should see the save confirmation modal
When the user clicks on the confirm button
Then the user should see the successful update message at top of the office page
Then the user verifies the office statistics field values are limited to 8 numbers in UI
Then the user verifies the office statistics values as in zeus document for fid <officeFid> are limited to 8 numbers
Then the user reverts the changes to the document

Examples:
|entity|searchBy|fid|officeFid|totalAtms|totalCheckingAccounts|totalSavingsAccounts|
|1038|FID|1038|1038-52|123456789|123456789|123456789|


Scenario: User is updating an office statistics page and enters value as alphanumerals and special characters for 'total ATMs', 'total checking accounts', 'total saving account' fields
and saves the office page
1- User verifies the 'total atm' field is showing 'Enter up to 8 valid numbers' validation message
2- User verifies the 'total checking accounts' field is showing 'Enter up to 8 valid numbers' validation message
3- User verifies the 'total savings accounts' field is showing 'Enter up to 8 valid numbers' validation message

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
When the user clicks on the office all link in the navigation bar
And the user clicks on the office statistics link in the navigation bar
And the user clicks on the office update link
When the user gets the document with get id for offices with the <officeFid> from the database
And the user enters the office total atms value as <totalAtms>
And the user enters the office total checking accounts value as <totalCheckingAccounts>
And the user enters the office total savings accounts value as <totalSavingsAccounts>
And the user clicks on the save button
Then the user should see the Enter up to 8 valid numbers. error message for the total atms field in the office statistics page
Then the user should see the Enter up to 8 valid numbers. error message for the total checking accounts field in the office statistics page
Then the user should see the Enter up to 8 valid numbers. error message for the total savings account field in the office statistics page
Then the user reverts the changes to the document

Examples:
|entity|searchBy|fid|officeFid|totalAtms|totalCheckingAccounts|totalSavingsAccounts|
|1038|FID|1038|1038-52|123,rw|123.ty|12345;3|

