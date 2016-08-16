Meta:@EditOfficeServices @Edit @Office @AllStories

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal
JIRA ID - ZEUS-1079 - User can edit Office's Services

Scenario: User verifies whether existing office services values can be updated
1- User verifies 'Your Changes have been saved' message is displayed after save
2- User verifies Office Services has been updated in confirmation modal
3- User verifies if existing 'Service Category' & 'Service Override' values are saved successfully.
4- Verify Zeus Office's Services page is updated with entered service values
6- Verify Zeus DB is updated with entered service values

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
And the user clicks on the office services link in the navigation bar
And the user clicks on the office update link
When the user deletes the existing service rows
And the user clicks on the add button for adding new services for office page
When the user selects <serviceCategory> type in the services for office page
When the user enters <serviceOverride> value  in the text box for office page
When the user clicks on the save button
When the user clicks on the confirm button
And the user clicks on the office update link
When the user selects <newServiceCategory> type in the services for office page
When the user enters <newServiceOverride> value  in the text box for office page
When the user clicks on the save button
Then the user should see the below summary changes in confirmation modal
|Summary|
|Services|
When the user clicks on the confirm button
Then the user should see the successful update message at top of the office page
Then the user should see the existing Office Services values updated in office services page

Examples:
|entity|searchBy|fid|officeFid|serviceCategory|serviceOverride|newServiceCategory|newServiceOverride|
|1038|FID|1038|1038-51|Accepting Credits|1234|Bonds|12345|


Scenario: User verifies whether existing office services values can be updated
MAx Lenght

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
And the user clicks on the office services link in the navigation bar
And the user clicks on the office update link
When the user deletes the existing service rows
And the user clicks on the add button for adding new services for office page
When the user selects <serviceCategory> type in the services for office page
When the user enters values which is beyond 100 unicode characters in the office service field
Then the user should see maximum length of office service value is limited to 100
When the user clicks on the save button
When the user clicks on the confirm button
Then the user should see the successful update message at top of the office page
Then the user should be able to view that only 100 unicode characters are saved in office service field

Examples:
|entity|searchBy|fid|officeFid|serviceCategory|
|1038|FID|1038|1038-51|Accepting Credits|

Scenario: User verifies whether existing office services values can be updated
Negative Validation

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
And the user clicks on the office services link in the navigation bar
And the user clicks on the office update link
When the user deletes the existing service rows
And the user clicks on the add button for adding new services for office page
When the user selects <serviceCategory> type in the services for office page
When the user enters <serviceOverride> value  in the text box for office page
When the user clicks on the save button
Then the user should see error message for the required office Service Category field in office page
When the user selects <serviceCategory2> type in the services office page
When the user enters <serviceOverride2> value  in the text box for service office page
When the user clicks on the save button
When the user clicks on the confirm button
Then the user should see the successful update message at top of the office page
Then the user should see the Office Services values are updated in office services page

Examples:
|entity|searchBy|fid|officeFid|serviceCategory|serviceOverride|serviceCategory2|serviceOverride2|
|1038|FID|1038|1038-51||Testservice|Banking||

Scenario: User verifies whether existing office services values can be updated
Delete Existing services

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
And the user clicks on the office services link in the navigation bar
And the user clicks on the office update link
When the user deletes the existing service rows
And the user clicks on the add button for adding new services for office page
When the user selects <serviceCategory> type in the services for office page
When the user enters <serviceOverride> value  in the text box for office page
When the user clicks on the save button
When the user clicks on the confirm button
Then the user should see the successful update message at top of the office page
When the user clicks on the office update link
When the user clicks on the delete services row button in the office services page
Then the user should see the delete row confirmation modal in the office page
When the user clicks on the yes button in the delete row confirmation modal in the office page
When the user clicks on the save button
When the user clicks on the confirm button
Then the user should see the successful update message at top of the office page
Then the user should not see the deleted Office Services values in office services page

Examples:
|entity|searchBy|fid|officeFid|serviceCategory|serviceOverride|
|1038|FID|1038|1038-51|Banking|1234|

Scenario: User verifies whether existing office services values can be updated
Blank Scenario

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
And the user clicks on the office services link in the navigation bar
And the user clicks on the office update link
When the user deletes the existing service rows
When the user clicks on the save button
When the user clicks on the confirm button
And the user clicks on the office update link
And the user clicks on the add button for adding new services for office page
When the user selects <serviceCategory> type in the services for office page
When the user enters <serviceOverride> value  in the text box for office page
When the user clicks on the save button
Then the user should see the save confirmation modal
Then the user should not see the below summary changes in confirmation modal
|Summary|
|Services|
When the user clicks on the confirm button
Then the user should see the successful update message at top of the office page
Then the user should see Office Services values are updated in office services page

Examples:
|entity|searchBy|fid|officeFid|serviceCategory|serviceOverride|
|1038|FID|1038|1038-51|||


Scenario: User verifies whether existing office services values can be updated
Delete New Scenario

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
And the user clicks on the office services link in the navigation bar
And the user clicks on the office update link
When the user deletes the existing service rows
When the user clicks on the save button
When the user clicks on the confirm button
And the user clicks on the office update link
When the user deletes the existing service rows
And the user clicks on the add button for adding new services for office page
When the user selects <serviceCategory> type in the services for office page
When the user enters <serviceOverride> value  in the text box for office page
When the user clicks on the delete services row button in the office services page
Then the user should see the delete row confirmation modal in the office page
When the user clicks on the no button in the delete row confirmation modal in the office page
When the user clicks on the save button
When the user clicks on the confirm button
Then the user should see the successful update message at top of the office page
Then the user should see Office Services values are updated in office services page
When the user clicks on the office update link
When the user clicks on the delete services row button in the office services page
Then the user should see the delete row confirmation modal in the office page
When the user clicks on the yes button in the delete row confirmation modal in the office page
When the user clicks on the save button
When the user clicks on the confirm button
Then the user should see the successful update message at top of the office page
Then the user should not see the deleted Office Services values in office services page

Examples:
|entity|searchBy|fid|officeFid|serviceCategory|serviceOverride|
|1038|FID|1038|1038-51|Banking|1234|