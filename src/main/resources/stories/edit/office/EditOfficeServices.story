Meta:@EditOfficeServices @Edit @Office @AllStories

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal
JIRA ID - ZEUS-1079 - User can edit Office's Services

Scenario: User verifies SERVICE_CATEGORY lookup
1- User verifies that service category dropdown values should be from the lookup and the values should be in the same order as the lookup.
2- User verifies whether existing values from 'Service Category' & 'Service Override' fields are retrieved from trusted doc.

Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
And the user clicks on the office services link in the navigation bar
And the user clicks on the office update link
Then the user should see the office's service's values are same as in trusted document
Then the user should see the office service category dropdown values from lookup SERVICE_CATEGORY

Examples:
|entity|searchBy|fid|officeFid|
|1038|FID|1038|1038-51|

Scenario: User verifies whether values entered in Service section are saved successfully
1- User verifies if new row with 'Service Category' & 'Service Override' values are saved successfully.
2- User verifies that 'Service Category' value (from 1st row) is not displayed in the 'Service Category' dropdown (in new row)
3- User verifies if another new row (2nd row) with 'Service Category' & 'Service Override' values are saved successfully.
4- User verifies 'Your Changes have been saved' message is displayed after save
5- Verify Zeus Office's Services page is updated with entered service values
6- Verify Zeus DB is updated with entered service values

Given a user is on the search page
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
And the user clicks on the add button for adding new services for office page
Then the user verifies that previously selected <serviceCategory> is not displayed in TYPE (DropDown) in second row
When the user selects <serviceCategory2> type in the services for office page
When the user enters <serviceOverride2> value  in the text box for office page
When the user clicks on the save button
When the user clicks on the confirm button
Then the user should see the successful update message at top of the office page
Then the user should see the Office Services values updated in office services page
Then the user should see the <serviceCategory> <serviceOverride> <serviceCategory2> <serviceOverride2> values updated in zeus document

Examples:
|entity|searchBy|fid|officeFid|serviceCategory|serviceOverride|serviceCategory2|serviceOverride2|
|1038|FID|1038|1038-51|Accepting Credits|First Service Override Entered|Banking|Second Service Override Entered|

Scenario: User verifies whether existing office services values can be updated
1- User verifies 'Your Changes have been saved' message is displayed after save
2- User verifies Office Services has been updated in confirmation modal
3- User verifies if existing 'Service Category' & 'Service Override' values are saved successfully.
4- Verify Zeus Office's Services page is updated with entered service values
6- Verify Zeus DB is updated with entered service values

Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
And the user clicks on the office services link in the navigation bar
And the user clicks on the office update link
When the user gets the document with get id for offices with the <officeFid> from the database
When the user updates <serviceCategory> type in the services for office page
When the user enters <serviceOverride> value  in the text box for office page
When the user clicks on the save button
Then the user should see the below summary changes in confirmation modal
|Summary|
|Services|
When the user clicks on the confirm button
Then the user should see the successful update message at top of the office page
Then the user should see Office Services values are updated in office services page
Then the user should see the <serviceCategory> <serviceOverride> values updated in zeus document
Then the user reverts the changes to the document

Examples:
|entity|searchBy|fid|officeFid|serviceCategory|serviceOverride|
|1038|FID|1038|1038-51|Accepting Credits|12346|

Scenario: User verifies whether existing office services values can be updated
1-User verifies whether blank value for Office Services are saved successfully in Office Services page
2-User verifies Blank Office Services values updated  in Zeus Document

Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
And the user clicks on the office services link in the navigation bar
And the user clicks on the office update link
When the user gets the document with get id for offices with the <officeFid> from the database
When the user updates <serviceCategory> type in the services for office page
When the user enters <serviceOverride> value  in the text box for office page
When the user clicks on the save button
Then the user should see the save confirmation modal
When the user clicks on the confirm button
Then the user should see the successful update message at top of the office page
Then the user should see Office Services values are updated as blank in office services page
Then the user should see the <serviceCategory> <serviceOverride> values updated in zeus document
Then the user reverts the changes to the document

Examples:
|entity|searchBy|fid|officeFid|serviceCategory|serviceOverride|
|1038|FID|1038|1038-51|||

Scenario: User verifies that Service Override Field is limited to 100 unicode characters in Office service Page

Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
And the user clicks on the office services link in the navigation bar
And the user clicks on the office update link
When the user gets the document with get id for offices with the <officeFid> from the database
When the user deletes the existing service rows
And the user clicks on the add button for adding new services for office page
When the user selects <serviceCategory> type in the services for office page
When the user enters values which is beyond 100 unicode characters in the office service field
Then the user should see maximum length of office service value is limited to 100
When the user clicks on the save button
When the user clicks on the confirm button
Then the user should see the successful update message at top of the office page
Then the user should be able to view that only 100 unicode characters are saved in office service field
Then the user reverts the changes to the document

Examples:
|entity|searchBy|fid|officeFid|serviceCategory|
|1038|FID|1038|1038-51|Accepting Credits|

Scenario: User verifies whether existing office services values can be updated
1-Verify that an error message 'Required' is displayed when user leaves ServiceCategory status as blank and enters value in Service Category text field

Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
And the user clicks on the office services link in the navigation bar
And the user clicks on the office update link
When the user gets the document with get id for offices with the <officeFid> from the database
When the user updates <serviceCategory> type in the services for office page
When the user enters <serviceOverride> value  in the text box for office page
When the user clicks on the save button
Then the user should see error message for the required office Service Category field in office page
When the user selects <serviceCategory2> type in the services office page
When the user enters <serviceOverride2> value  in the text box for service office page
When the user clicks on the save button
When the user clicks on the confirm button
Then the user should see the successful update message at top of the office page
Then the user should see the Office Services values are updated in office services page
Then the user should see the <serviceCategory2> <serviceOverride2> values updated in zeus document
Then the user reverts the changes to the document

Examples:
|entity|searchBy|fid|officeFid|serviceCategory|serviceOverride|serviceCategory2|serviceOverride2|
|1038|FID|1038|1038-51||Testservice|Banking||

Scenario: User verifies whether existing office services values can be updated
1 - Verify if User can delete exisiting services("Service Category" and "Service Override").

Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
And the user clicks on the office services link in the navigation bar
And the user clicks on the office update link
When the user gets the document with get id for offices with the <officeFid> from the database
When the user clicks on the delete services row button in the office services page
Then the user should see the delete row confirmation modal in the office page
When the user clicks on the yes button in the delete row confirmation modal in the office page
When the user clicks on the save button
When the user clicks on the confirm button
Then the user should see the successful update message at top of the office page
Then the user should not see the deleted Office Services values in office services page
Then the user should see the <serviceCategory> <serviceOverride> values not updated in zeus document
Then the user reverts the changes to the document

Examples:
|entity|searchBy|fid|officeFid|serviceCategory|serviceOverride|
|1038|FID|1038|1038-51|Accepting Credits|same text|

Scenario: User verifies whether existing office services values can be updated
1 - Verify if User can prevent deleting services ("Service Category" and "Service Override") by clicking on 'No'.
2 - Verify if User can delete identifiers("Service Category" and "Service Override") by clicking on 'Yes' , then after saving it should be removed.

Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
And the user clicks on the office services link in the navigation bar
And the user clicks on the office update link
When the user gets the document with get id for offices with the <officeFid> from the database
When the user deletes the existing service rows
And the user clicks on the add button for adding new services for office page
When the user updates <serviceCategory> type in the services for office page
When the user enters <serviceOverride> value  in the text box for office page
When the user clicks on the delete services row button in the office services page
Then the user should see the delete row confirmation modal in the office page
When the user clicks on the no button in the delete row confirmation modal in the office page
Then the user should see Office Services values are updated in Edit office services page
When the user clicks on the delete services row button in the office services page
When the user clicks on the yes button in the delete row confirmation modal in the office page
When the user clicks on the save button
When the user clicks on the confirm button
Then the user should see the successful update message at top of the office page
Then the user should not see the deleted Office Services values in office services page
Then the user should see the <serviceCategory> <serviceOverride> values not updated in zeus document
Then the user reverts the changes to the document

Examples:
|entity|searchBy|fid|officeFid|serviceCategory|serviceOverride|
|1038|FID|1038|1038-51|Banking|1234|

