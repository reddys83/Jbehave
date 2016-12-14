Meta:@EditOfficeServices @Edit @Office @AllStories

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal
JIRA ID - ZEUS-1079 - User can edit Office's Services


Scenario: User verifies SERVICE_CATEGORY ('Service Category' & 'Service Override') fields
1- User verifies that service category dropdown values are same as lookup values
2- User verifies whether existing office's service values are from trusted document.
3- User verifies whether existing office's service values updated with different data both in UI and Zeus document.
4- User verifies that Service Override Field is limited to 100 unicode characters in Office service Page

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
When the user gets the document with get id for offices with the <officeFid> from the database
When the user deletes all service rows in office page
And the user clicks on the add button for adding new services for office page
Then the user should see the office service category dropdown values from lookup SERVICE_CATEGORY
When the user selects <serviceCategory> type in the services for office page
When the user enters <serviceOverride> value  in the text box for office page
And the user clicks on the add button for adding new services for office page
Then the user verifies that previously selected <serviceCategory> is not displayed in second row
When the user selects <serviceCategory2> type in the services for office page
When the user enters <serviceOverride2> value  in the text box for office page
Then the user should see maximum length of office service value is limited to 100
When the user clicks on the save button
When the user clicks on the confirm button
Then the user should see the successful update message at top of the office page
Then the user should see the Office Services values updated in office services page
Then the user should see the user should see the  Office Services values updated in zeus document
Then the user reverts the changes to the document

Examples:
|entity|searchBy|fid|officeFid|serviceCategory|serviceOverride|serviceCategory2|serviceOverride2|
|1038|FID|1038|1038-51|Accepting Credits|First Service Override Entered|Banking|gheshrgjk;aerhg;uaehr;gjkhaejrgjkaerhgaejrhgjaehgjaerghrwrwradasdadasdasdasdasdasdasdadadadasdasdasd|

Scenario: User verifies whether values entered in SERVICE_CATEGORY ('Service Category' & 'Service Override') fields
1- User verifies two new rows can be saved successfully.
2- User verifies 'Service Category' dropdown is mutually exclusive
3- User verifies office service values are updated in UI and zeus document.

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
1 - Verify if User can delete existing services("Service Category" and "Service Override").

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
When the user deletes all service rows in office page
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

