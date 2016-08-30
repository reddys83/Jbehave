Meta:@EditOfficeHistory @Edit @Office @AllStories

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal
JIRA ID - ZEUS-1082 - User can edit Office's History

Scenario: User can edit  'Office History' that is different from the current value & verifies whether Blank,spl character,numbers & character values for 'History' is getting saved successfully
a)User verifies existing 'Office History' values are retrieved  from trusted doc 
b)User verifies 'Your Changes have been saved' message is displayed after save
c)User verifies Office History has been updated in confirmation modal
d)User verifies 'Office History' is reflecting in Office Web page
e)User verifies 'Office History' is reflecting in zeus document

Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
And the user clicks on the office history link in the navigation bar
And the user clicks on the office update link
When the user gets the document with get id for offices with the <officeFid> from the database
Then the user should see the Office History value in office page is same as per trusted document
When the user enters <officeHistory> value in Office page
When the user clicks on the save button
Then the user should see the below summary changes in confirmation modal
|Summary|
|History|
When the user clicks on the confirm button
Then the user should see the successful update message at top of the office page
Then the user should see the entered <officeHistory> in Office page
Then the user should see the entered Office History in zeus document
Then the user reverts the changes to the document

Examples:
|entity|searchBy|fid|officeFid|officeHistory|
|1038|FID|1038|1038-51||
|1038|FID|1038|1038-51|!@#$%^&*()_+}{|":>?<?.,|
|1038|FID|1038|1038-51|24154545444545455|

Scenario: User can edit  'Office History' that is No different from the current value
a)User verifies 'Your Changes have been saved' message is displayed after save
b)User verifies Office History has been not been updated in confirmation modal
d)User verifies 'Office History' is reflecting in Office Web page
e)User verifies 'Office History' is reflecting in zeus document

Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
And the user clicks on the office history link in the navigation bar
And the user clicks on the office update link
When the user gets the document with get id for offices with the <officeFid> from the database
When the user enters <officeHistory> value in Office page
When the user clicks on the save button
Then the user should not see the below summary changes in confirmation modal
|Summary|
|Basic Info|
When the user clicks on the confirm button
Then the user should see the successful update message at top of the office page
Then the user should see the entered <officeHistory> in Office page
Then the user should see the entered Office History in zeus document
Then the user reverts the changes to the document

Examples:
|entity|searchBy|fid|officeFid|officeHistory|
|1038|FID|1038|1038-51|This is sample old text|

Scenario: User verifies that Office History  field is limited to 10000 unicode characters & verifies the max length attribute is restricted to 10000 in Office Page

Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
And the user clicks on the office history link in the navigation bar
And the user clicks on the office update link
When the user gets the document with get id for offices with the <officeFid> from the database
When the user enters values which is beyond 10000 unicode characters in the Office History field
Then the user should see maximum length of office history is limited to 10000
When the user clicks on the save button
And the user clicks on the confirm button
Then the user should see the successful update message at top of the office page
Then the user should be able to view that only 10000 unicode characters are saved in Office History field
Then the user should be able to verify the maximum values are entered in the Office History field
Then the user reverts the changes to the document

Examples:
|entity|searchBy|fid|officeFid|
|1038|FID|1038|1038-51|