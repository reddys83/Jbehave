Meta:@EditOfficePersonnel @Edit @Office @AllStories

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal
JIRA ID - ZEUS-1084 - User can edit Office's Personnel

Scenario: 1 User can edit Office's Personnel -
1 - Verify Office's Personnel types are from lookup PERSONNEL_SUMMARY_TEXT_TYPE
2 - Verify existing Personnel values are from trusted
3 - Verify two personnel rows can be added
4 - Verify previously selected personnel Type is not listed in personnel type dropdown of next row
5 - Verify Zeus Office's Personnel page is updated with entered personnel values
6 - Verify Zeus DB is updated with entered personnel values
7 - Verify confirmation model
8 - Verify existing personnal rows are updated
9 - Verify Blank value is accepted

Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
And the user clicks on the office personnel link in the navigation bar
And the user clicks on the office update link
When the user gets the document with get id for offices with the <officeFid> from the database
Then the user should see the office's personnel values same as in trusted document
Then the user should see the office personnel types from lookup PERSONNEL_SUMMARY_TEXT_TYPE
When the user deletes the existing office personnel rows
When the user clicks on the add new personnel button in the office personnel page
When the user enters personnel type as <personnelType> in the office personnel page
When the user enters personnel value as <personnelValue> in the office personnel page
When the user clicks on the add new personnel button in the office personnel page
Then the user verifies that previously selected <personnelType> is not present in the new office personnel row
When the user enters personnel type as <personnelType2> in the office personnel page
When the user enters personnel value as <personnelValue2> in the office personnel page
When the user clicks on the save button
Then the user should see the below summary changes in confirmation modal
|Summary|
|Personnel|
When the user clicks on the confirm button
Then the user should see the successful update message at top of the office page
Then the user verifies that the personnel parameters are present in the office identifiers page
And the user should see the office personnel values as in zeus document
Then the user reverts the changes to the document

Examples:
|entity|searchBy|fid|officeFid|personnelType|personnelValue|personnelType2|personnelValue2|
|1038|FID|1038|1038-60|InstitutionEmployees|QATest|locationEmployees|QATesting|
|1038|FID|1038|1038-60|locationEmployees|QATest|||

Scenario: 2 User can edit Office's existing Personnel 
1 - Verify Zeus Office's Personnel page is updated with entered personnel values
2 - Verify Zeus DB is updated with entered personnel values

Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
And the user clicks on the office personnel link in the navigation bar
And the user clicks on the office update link
When the user gets the document with get id for offices with the <officeFid> from the database
And the user enters personnel type as <personnelType> in the office personnel page
And the user enters personnel value as <personnelValue> in the office personnel page
When the user clicks on the save button
When the user clicks on the confirm button
Then the user should see the successful update message at top of the office page
Then the user verifies that the existing personnel parameters are updated in the office identifiers page
And the user should see the updated office personnel values as in zeus document
Then the user reverts the changes to the document

Examples:
|entity|searchBy|fid|officeFid|personnelType|personnelValue|
|1038|FID|1038|1038-60|locationEmployees|QATest|

Scenario: 3 User can edit office's Personnel
1 - Verify if error message 'Required' is displayed when blank value is entered  for 'Type'
2 - Verify if error message 'Enter up to 10000 valid characters' is displayed when blank value is entered  for 'Value'
3 - Verify whether the text entered in the Personnel 'Value' field is not beyond 10000 unicode characters.
4 - Verify whether the Personnel 'Value' field max length attribute

Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
And the user clicks on the office personnel link in the navigation bar
And the user clicks on the office update link
When the user gets the document with get id for offices with the <officeFid> from the database
When the user deletes the existing office personnel rows
When the user clicks on the add new personnel button in the office personnel page
When the user enters personnel type as <personnelType> in the office personnel page
When the user enters personnel value as <personnelValue> in the office personnel page
When the user clicks on the save button
Then the user should see the error message Required for personnel type field in the office personnel page
When the user enters personnel type as <personnelType2> in the office personnel page
When the user enters personnel value as <personnelValue2> in the office personnel page
When the user clicks on the save button
Then the user should see the error message Enter up to 10000 valid characters. for personnel value field in the office personnel page
When the user enters 10000 characters in the office personnel value text area
Then the user should see the office personnel value text area field length as 10000
When the user clicks on the save button
When the user clicks on the confirm button
Then the user should see the successful update message at top of the office page
Then the user verifies that the personnel parameters with 10000 characters are present in the office identifiers page
Then the user should see the office personnel value text with 10000 characters for fid <officeFid> in zeus document
Then the user reverts the changes to the document

Examples:
|entity|searchBy|fid|officeFid|personnelType|personnelType2|personnelValue|personnelValue2|
|1038|FID|1038|1038-60||InstitutionEmployees|Testing||

Scenario: 4 User can edit Office's Personnel - 
Verify if user is able to delete existing Office Personnel row by clicking yes on confirmation modal

Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
And the user clicks on the office personnel link in the navigation bar
And the user clicks on the office update link
When the user gets the document with get id for offices with the <officeFid> from the database
When the user clicks on the delete personnel row button in the office personnel page
Then the user should see the delete row confirmation modal in the office page
When the user clicks on the yes button in the delete row confirmation modal in the office page
When the user clicks on the save button
When the user clicks on the confirm button
Then the user should see the successful update message at top of the office page
Then the user should not see the newly added personnel row in the office personnel page
And the user verifies that no personnel values are updated in zeus document
Then the user reverts the changes to the document

Examples:
|entity|searchBy|fid|officeFid|personnelType|personnelValue| 
|1038|FID|1038|1038-60|InstitutionEmployees|QATest| 

Scenario: 5 User can edit Office's Personnel - 
1 - Verify if user is able view the personnel value in UI when user clicks delete on newly added Office Personnel row and clicks 'No' on confirmation modal 
2 - Verify if user is able to delete newly added Office Personnel row by clicking yes on confirmation modal

Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
And the user clicks on the office personnel link in the navigation bar
And the user clicks on the office update link
When the user gets the document with get id for offices with the <officeFid> from the database
When the user deletes the existing office personnel rows
When the user clicks on the add new personnel button in the office personnel page
And the user enters personnel type as <personnelType> in the office personnel page
And the user enters personnel value as <personnelValue> in the office personnel page
When the user clicks on the delete personnel row button in the office personnel page
Then the user should see the delete row confirmation modal in the office page
When the user clicks on the no button in the delete row confirmation modal in the office page
Then the user should see the newly added personnel row in the office personnel page
When the user clicks on the delete personnel row button in the office personnel page
Then the user should see the delete row confirmation modal in the office page
When the user clicks on the yes button in the delete row confirmation modal in the office page
When the user clicks on the save button
When the user clicks on the confirm button
Then the user should see the successful update message at top of the office page
Then the user should not see the newly added personnel row in the office personnel page
And the user verifies that no personnel values are updated in zeus document
Then the user reverts the changes to the document

Examples:
|entity|searchBy|fid|officeFid|personnelType|personnelValue|
|1038|FID|1038|1038-60|InstitutionEmployees|QATest|

