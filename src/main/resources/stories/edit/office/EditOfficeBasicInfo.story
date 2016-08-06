Meta:@EditOfficeBasicInfo @Edit @Office @AllStories

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal
JIRA ID - ZEUS-1066 - User can edit Office's Opened Date
and
JIRA ID - ZEUS-1068 - User can edit Office's Lead Location flag
and
JIRA ID - ZEUS-1070 - User can edit office's Foreign Office flag
and
JIRA ID - ZEUS-1072 - User can edit Office's Additional Info
and
JIRA ID - ZEUS-1074 - USer can edit Office's Types
and
JIRA ID - ZEUS-1073 - User can edit Office's Names
JIRA ID - ZEUS-1064 - User can edit Office's Prefix, Suffix and Override

Scenario: User can edit  'Office History' that is No different from the current value
a)User verifies 'Your Changes have been saved' message is displayed after save
b)User verifies Office History has been not been updated in confirmation modal
d)User verifies whether updated 'Office History' is reflecting in Office Web page
e)User verifies whether updated 'Office History' is reflecting in zeus document

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
And the user clicks on the office history link in the navigation bar
And the user clicks on the office update link
When the user gets the document with get id for offices with the <officeFid> from the database
When the user enters <officeHistoryOld> value in office page
When the user clicks on the save button
When the user clicks on the confirm button
Then the user should see the successful update message at top of the office page
Then the user should see the entered <officeHistoryOld> in Office page
When the user clicks on the office update link
When the user enters <officeHistory> value in Office page
When the user clicks on the save button
Then the user should not see the below summary changes in confirmation modal
|Summary|
|Basic Info|
When the user clicks on the confirm button
Then the user should see the successful update message at top of the office page
Then the user should see the entered <officeHistory> in Office page
Then the user reverts the changes to the document

Examples:
|entity|searchBy|fid|officeFid|officeHistoryOld|officeHistory|
|1038|FID|1038|1038-51|This is sample old text|This is sample old text|

Scenario: User can edit  'Office History' that is different from the current value
a)User verifies existing 'Office History' existing interest rate values are retrieved  from trusted doc 
b)User verifies 'Your Changes have been saved' message is displayed after save
c)User verifies Office History has been updated in confirmation modal
d)User verifies whether updated 'Office History' is reflecting in Office Web page
e)User verifies whether updated 'Office History' is reflecting in zeus document

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
And the user clicks on the office history link in the navigation bar
And the user clicks on the office update link
When the user gets the document with get id for offices with the <officeFid> from the database
When the user enters <officeHistoryOld> value in office page
When the user clicks on the save button
When the user clicks on the confirm button
Then the user should see the successful update message at top of the office page
Then the user should see the entered <officeHistoryOld> in Office page
When the user clicks on the office update link
When the user enters <officeHistory> value in Office page
When the user clicks on the save button
Then the user should see the below summary changes in confirmation modal
|Summary|
|Basic Info|
When the user clicks on the confirm button
Then the user should see the successful update message at top of the office page
Then the user should see the entered <officeHistory> in Office page
Then the user reverts the changes to the document

Examples:
|entity|searchBy|fid|officeFid|officeHistoryOld|officeHistory|
|1038|FID|1038|1038-51|This is sample old text|this is new text|

Scenario: User is updating an Office's  History  and verifies whether Blank value for 'History' is getting saved successfully
a)User verifies 'Your Changes have been saved' message is displayed after save
b)User verifies whether updated 'Office History' is reflecting in Office Web page
c)User verifies whether updated 'Office History' is reflecting in zeus document

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
And the user clicks on the office history link in the navigation bar
And the user clicks on the office update link
When the user gets the document with get id for offices with the <officeFid> from the database
When the user clicks on the office update link
When the user enters <officeHistory> value in Office page
When the user clicks on the save button
When the user clicks on the confirm button
Then the user should see the successful update message at top of the office page
Then the user should see the entered <officeHistory> in Office page
Then the user reverts the changes to the document

Examples:
|entity|searchBy|fid|officeFid|officeHistory|
|1038|FID|1038|1038-51||