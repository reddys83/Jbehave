Meta:@EditOfficeIdentifiers @Edit @Office @AllStories

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal
JIRA ID - ZEUS-1083 - User can edit Office's Identifiers

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
When the user clicks on the confirm button
Then the user should see the successful update message at top of the office page
Then the user verifies that the identifiers parameters are entered in the office identifiers page
Then the user should see the office identifier values as in zeus document
Then the user reverts the changes to the document

Examples:
|entity|searchBy|fid|officeFid|identifierType|identifierValue|identifierStatus|identifierType2|identifierValue2|identifierStatus2|
|1038|FID|1038|1038-51|Global Intermediary Identification Number|QATesting|Inactive|S and P Identification Number (SPID)|QATesting|Active|

Scenario: User can edit existin office's identifiers- Verify if User can add New Office identifiers-Verify that all fields- "Type","Value" and "Status" are updated successfully
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
And the user clicks on the save button
When the user clicks on the confirm button
And the user clicks on the office update link
When the user enters identifier type as <newIdentifierType> in the office identifier page
When the user enters identifier value as <newIdentifierValue> in the office identifier page
When the user enters identifier status as <newIdentifierStatus> in the office identifier page
When the user clicks on the save button
Then the user should see the below summary changes in confirmation modal
|Summary|
|Identifiers|
When the user clicks on the confirm button
Then the user should see the successful update message at top of the office page
Then the user verifies existing offices identifiers parameters are updated with new office identifiers
Then the user verifies that office identifier values are updated in zeus document
Then the user reverts the changes to the document

Examples:
|entity|searchBy|fid|officeFid|identifierType|identifierValue|identifierStatus|newIdentifierType|newIdentifierValue|newIdentifierStatus|
|1038|FID|1038|1038-51|Global Intermediary Identification Number|QATesting|Inactive|S and P Identification Number (SPID)|QATesting|Active|

Scenario: Verifying that office's identifier row in not added after saving when blank values are entered for 'Type', 'Value' and 'Status'

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
And the user clicks on the office update link
When the user clicks on the add new identifier button in the office identifier page
When the user enters identifier type as <identifierType> in the office identifier page
When the user enters identifier value as <identifierValue> in the office identifier page
When the user enters identifier status as <identifierStatus> in the office identifier page
When the user clicks on the save button
Then the user should see the save confirmation modal
Then the user should not see the below summary changes in confirmation modal <ConfirmationSummary>
When the user clicks on the confirm button
Then the user should see the successful update message at top of the office page
Then the user should not see the newly added identifier row in the office identifiers page
Then the user verifies that no values are entered in zeus document for office identifiers
Then the user reverts the changes to the document

Examples:
|entity|searchBy|fid|officeFid|identifierType|identifierValue|identifierStatus|ConfirmationSummary|
|1038|FID|1038|1038-51||||Summary|

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
1 - Verify that an error message 'Required' is displayed when the user leaves the identifier Type as blank and enters value in identifier 'Value' and 'Status'

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
1 - Verify that an error message 'Required' is displayed when user leaves identifier status as blank and enters value in identifier 'Type' and 'Value'

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
1 - Verify if User can prevent deleting identifiers( "Type","Value" and "Status") by clicking on 'No'.
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
Then the user should see the delete row confirmation modal in the office page
When the user clicks on the no button in the delete row confirmation modal in the office page
Then the user should see the newly added identifier row in the office identifiers page
When the user clicks on the delete identifier row button in the office identifiers page
Then the user should see the delete row confirmation modal in the office page
When the user clicks on the yes button in the delete row confirmation modal in the office page
Then the user should not see the newly added identifier row in the office identifiers page
When the user clicks on the save button
When the user clicks on the confirm button
Then the user should see the successful update message at top of the office page
Then the user should not see the identifier row in the office identifiers page
Then the user verifies that the deleted row for office identifier does not exist in zeus document
Then the user reverts the changes to the document

Examples:
|entity|searchBy|fid|officeFid|identifierType|identifierValue|identifierStatus|
|1038|FID|1038|1038-51|FDIC Office Branch ID|QATest|Inactive|