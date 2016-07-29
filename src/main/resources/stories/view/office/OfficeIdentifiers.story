Meta:@OfficeIdentifiers @Office @View @AllStories

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

JIRA ID - ZEUS-406 - User can view office identifiers
JIRA ID - ZEUS-1083 - User can edit Office's Identifiers

Scenario: Verify office's identifier - Bug-ZEUS-1314
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
And the user clicks on the office identifier link in the navigation bar

Then the user should see the office's identifiers as:
|TYPE|VALUE|STATUS|
|FDIC Office Branch|5|Active|
|FDIC Office Branch ID|5|Inactive|

Examples:
|entity|searchBy|fid|officeFid|
|11621|FID|11621|11621-23|

Scenario: Verify no office's identifier
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
And the user clicks on the office identifier link in the navigation bar
Then the user should not see the office's identifiers

Examples:
|entity|searchBy|fid|officeFid|
|43823|FID|43823|43823-1|

Scenario: User can edit office's identifiers -
1- Verify Office's Identifier types are same as from lookup THIRD_PARTY_IDENTIFIER_OFFICE
2- Verify Office's Identifier status are from lookup STATUS
3- Verify existing identifier values are from trusted 

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
And the user clicks on the office identifier link in the navigation bar
And the user clicks on the office update link
Then the user should see the office's identifier values same as in trusted document
When the user clicks on the add new identifier button in the office identifier page
Then the user should see the office identifier types from lookup THIRD_PARTY_IDENTIFIER_OFFICE
Then the user should see the office identifier status from lookup STATUS

Examples:
|entity|searchBy|fid|officeFid|
|1038|FID|1038|1038-51|

Scenario: User can edit office's identifiers- Verify if User can add New Office identifiers-Verify that all fields- "Type","Value" and "Status" are updated successfully
1 - Verify two identifer rows are added
2 - Verify previously selected Identifer Type is not listed in identifer type dropdown of next row
3 - Verify Zeus Office's Identifiers page is updated with entered identifier values
4 - Verify Zeus DB is updated with entered identifier values

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
And the user clicks on the office identifier link in the navigation bar
And the user clicks on the office update link
When the user gets the document with get id for offices with the <officeFid> from the database
When the user deletes the existing office identifier rows
When the user clicks on the add new identifier button in the office identifier page
When the user enters identifier type as <identifierType> in the office identifier page
When the user enters identifier value as <identifierValue> in the office identifier page
When the user enters identifier status as <identifierStatus> in the office identifier page
When the user clicks on the add new identifier button in the office identifier page
Then the user verifies that previously selected <identifierType> is not present in the new office identifier row
When the user enters identifier type as <identifierType2> in the office identifier page
When the user enters identifier value as <identifierValue2> in the office identifier page
When the user enters identifier status as <identifierStatus2> in the office identifier page
And the user clicks on the save button
Then the user should see the save confirmation modal
And the user should see the below summary changes in confirmation modal
|Summary|
|Basic Info / Identifiers|
When the user clicks on the confirm button
Then the user should see the successful update message at top of the office page
Then the user verifies that the identifiers parameters are entered in the office identifiers page
Then the user should see the office identifier values as in zeus document
Then the user reverts the changes to the document

Examples:
|entity|searchBy|fid|officeFid|identifierType|identifierValue|identifierStatus|identifierType2|identifierValue2|identifierStatus2|
|1038|FID|1038|1038-51|Global Intermediary Identification Number|QATesting|Inactive|S and P Identification Number (SPID)|QATesting|Active|

Scenario: Verifying that office's identifier row in not added when blank values are entered for 'Type', 'Value' and 'Status'

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
And the user clicks on the office identifier link in the navigation bar
And the user clicks on the office update link
When the user gets the document with get id for offices with the <officeFid> from the database
When the user deletes the existing office identifier rows
When the user clicks on the add new identifier button in the office identifier page
When the user enters identifier type as <identifierType> in the office identifier page
When the user enters identifier value as <identifierValue> in the office identifier page
When the user enters identifier status as <identifierStatus> in the office identifier page
When the user clicks on the save button
Then the user should see the save confirmation modal
Then the user should not see the <ConfirmationSummary> changes in confirmation modal in the office identifiers page
When the user clicks on the confirm button
Then the user should see the successful update message at top of the office page
Then the user should not see the newly added identifier row in the office identifiers page
Then the user verifies that no values are entered in zeus document for office identifiers
Then the user reverts the changes to the document

Examples:
|entity|searchBy|fid|officeFid|identifierType|identifierValue|identifierStatus|
|1038|FID|1038|1038-51||||

Scenario: User can edit office's identifiers - Verify whether the text entered in the Identifier 'Value' field is not beyond 50 unicode characters.

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
And the user clicks on the office identifier link in the navigation bar
And the user clicks on the office update link
When the user gets the document with get id for offices with the <officeFid> from the database
When the user deletes the existing office identifier rows
When the user clicks on the add new identifier button in the office identifier page
When the user enters identifier type as <identifierType> in the office identifier page
When the user enters identifier value as <identifierValue> in the office identifier page
Then the user should see maximum length of office identifier value is limited to 50
When the user enters identifier status as <identifierStatus> in the office identifier page
When the user clicks on the save button
When the user clicks on the confirm button
Then the user should see the successful update message at top of the office page
Then the user reverts the changes to the document

Examples:
|entity|searchBy|fid|officeFid|identifierType|identifierValue|identifierStatus|
|1038|FID|1038|1038-51|RSSD|aksjuilrw1aksjuilrw1aksjuilrw1aksjuilrw1aksju%)~12y1|Active|

Scenario: User can edit office's identifiers 
1 - Verify that an error message 'Required' is displayed when user left identifier Type blank and enters value in identifier 'Value' and 'Status'

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
And the user clicks on the office identifier link in the navigation bar
And the user clicks on the office update link
When the user deletes the existing office identifier rows
When the user clicks on the add new identifier button in the office identifier page
When the user enters identifier type as <identifierType> in the office identifier page
When the user enters identifier value as <identifierValue> in the office identifier page
When the user enters identifier status as <identifierStatus> in the office identifier page
When the user clicks on the save button
Then the user should see the error message Required for identifier type field in the office identifiers page

Examples:
|entity|searchBy|fid|officeFid|identifierType|identifierValue|identifierStatus|
|1038|FID|1038|1038-51||XYZ|Active|

Scenario: User can edit office's identifiers 
1 - Verify that an error message 'Required' is displayed when user leaves identifier Value as blank and enters value in identifier 'Type' and 'Status'

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
And the user clicks on the office identifier link in the navigation bar
And the user clicks on the office update link
When the user deletes the existing office identifier rows
When the user clicks on the add new identifier button in the office identifier page
When the user enters identifier type as <identifierType> in the office identifier page
When the user enters identifier value as <identifierValue> in the office identifier page
When the user enters identifier status as <identifierStatus> in the office identifier page
When the user clicks on the save button
Then the user should see the error message Enter up to 50 valid characters. for identifier value field in the office identifiers page

Examples:
|entity|searchBy|fid|officeFid|identifierType|identifierValue|identifierStatus|
|1038|FID|1038|1038-51|RSSD||Active|

Scenario: User can edit office's identifiers
1 - Verify that an error message 'Required' is displayed when user left identifier status blank and enters value in identifier 'Type' and 'Value'

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
And the user clicks on the office identifier link in the navigation bar
And the user clicks on the office update link
When the user deletes the existing office identifier rows
When the user clicks on the add new identifier button in the office identifier page
When the user enters identifier type as <identifierType> in the office identifier page
When the user enters identifier value as <identifierValue> in the office identifier page
When the user enters identifier status as <identifierStatus> in the office identifier page
When the user clicks on the save button
Then the user should see the error message Required for identifier status field in the office identifiers page

Examples:
|entity|searchBy|fid|officeFid|identifierType|identifierValue|identifierStatus|
|1038|FID|1038|1038-51|FDIC Office Branch ID|XYZ||

Scenario: User can edit office's identifiers
1 - Verify if User can delete exisiting identifiers( "Type","Value" and "Status").

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
And the user clicks on the office identifier link in the navigation bar
And the user clicks on the office update link
When the user gets the document with get id for offices with the <officeFid> from the database
When the user deletes the existing office identifier rows
When the user clicks on the save button
When the user clicks on the confirm button
Then the user should see the successful update message at top of the office page
Then the user should not see the identifier row in the office identifiers page
Then the user verifies that the deleted row for office identifier does not exist in zeus document
Then the user reverts the changes to the document

Examples:
|entity|searchBy|fid|officeFid|
|1038|FID|1038|1038-51|

Scenario: User can edit office's identifiers
1 - Verify if User can prevent deleting identifiers( "Type","Value" and "Status") by clicking on 'No' after saving.
2 - Verify if User can delete identifiers( "Type","Value" and "Status") by clicking on 'Yes' , then after saving it should be removed.

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
And the user clicks on the office identifier link in the navigation bar
And the user clicks on the office update link
When the user gets the document with get id for offices with the <officeFid> from the database
When the user deletes the existing office identifier rows
When the user clicks on the add new identifier button in the office identifier page
When the user enters identifier type as <identifierType> in the office identifier page
When the user enters identifier value as <identifierValue> in the office identifier page
When the user enters identifier status as <identifierStatus> in the office identifier page
When the user clicks on the save button
When the user clicks on the confirm button
And the user clicks on the office update link
When the user clicks on the delete identifier row button in the office identifiers page
Then the user should see delete row confirmation modal in the office identifiers page
When the user clicks on the No button to cancel the deletion of row in the office identifiers page
When the user clicks on the save button
When the user clicks on the confirm button
Then the user verifies that the newly added identifier row values exists in the office identifiers page
Then the user verifies that the row values for office identifier entered exists in zeus document
When the user clicks on the office update link
When the user clicks on the delete identifier row button in the office identifiers page
Then the user should see delete row confirmation modal in the office identifiers page
When the user clicks on the Yes button to delete the row in the office identifiers page
When the user clicks on the save button
When the user clicks on the confirm button
Then the user should see the successful update message at top of the office page
Then the user should not see the identifier row in the office identifiers page
Then the user verifies that the deleted row for office identifier does not exist in zeus document
Then the user reverts the changes to the document

Examples:
|entity|searchBy|fid|officeFid|identifierType|identifierValue|identifierStatus|
|1038|FID|1038|1038-51|FDIC Office Branch ID|QATest|Inactive|