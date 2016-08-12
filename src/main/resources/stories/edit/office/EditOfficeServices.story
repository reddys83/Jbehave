Meta:@EditOfficeServices @Edit @Office @AllStories

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal
JIRA ID - ZEUS-1079 - User can edit Office's Services

Scenario: User verifies whether values entered in Service section are saved successfully
1- User verifies if new row with 'Service Category' & 'Service Override' values are saved successfully.
2- User verifies that 'Service Category' value (from 1st row) is not displayed in the 'Service Category' dropdown (in new row)
3- User verifies if another new row (2nd row) with 'Service Category' & 'Service Override' values are saved successfully.
4- User verifies 'Your Changes have been saved' message is displayed after save
5- Verify Zeus Office's Services page is updated with entered service values
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
And the user clicks on the add button for adding new services for office page
Then the user verifies that previously selected <serviceCategory> is not displayed in TYPE (DropDown) in second row
When the user selects <serviceCategory2> type in the services for office page
When the user enters <serviceOverride2> value  in the text box for office page
When the user clicks on the save button
When the user clicks on the confirm button
Then the user should see the successful update message at top of the office page

Examples:
|entity|searchBy|fid|officeFid|serviceCategory|serviceOverride|serviceCategory2|serviceOverride2|
|1038|FID|1038|1038-51|Accepting Credits|First Service Override Entered|Banking|Second Service Override Entered|