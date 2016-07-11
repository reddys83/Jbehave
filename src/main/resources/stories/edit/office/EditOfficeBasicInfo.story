Meta:@EditOfficeBasicInfo @Edit @Office @AllStories

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal
JIRA ID - ZEUS-1066 - User can edit Office's Opened Date
and
JIRA ID - ZEUS-1068 - User can edit Office's Lead Location flag

Scenario: Update and Save office Opened date
Verify User updates a value for Opened Date and click Save. Updated Office opened date should be saved in Zeus document

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
And the user clicks on the office update link
And the user updates office Opened <day> <month> <year>
And the user clicks on the save button
Then the user should see the save confirmation modal
When the user clicks on the confirm button
Then the user verifies office opened date from zeus document <fid> <day> <month> <year>


Examples:
|entity|searchBy|fid|officeFid|day|month|year|
|1010|FID|1010|1010-44|07|Oct|2014|

Scenario: User updates Office Opened date
Verifying error message Enter a year, month/year or day/month/year. is displaying for invalid date entered.

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
And the user clicks on the office update link
And the user updates office Opened <day> <month> <year>
And the user clicks on the save button
Then the user should see the error 'Enter a year, month/year or day/month/year.' for opened date
And the user should see the error message at top of page the highlighted fields must be addressed before this update can be saved

Examples:
|entity|searchBy|fid|officeFid|day|month|year|
|1010|FID|1010|1010-44|14|Jan||

Scenario: User updates Office Opened date
Verifying error message Invalid Date is displaying for invalid date entered.

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
And the user clicks on the office update link
And the user updates office Opened <day> <month> <year>
And the user clicks on the save button
Then the user should see the error 'Invalid Date' for opened date
And the user should see the error message at top of page the highlighted fields must be addressed before this update can be saved

Examples:
|entity|searchBy|fid|officeFid|day|month|year|
|1010|FID|1010|1010-44|32|Oct|1909|

Scenario: Verify that Opened Date can not be later than today
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
And the user clicks on the office update link
And the user updates office Opened <day> <month> <year>
And the user clicks on the save button
Then the user should see the error 'Must be no later than today.' for opened date
And the user should see the error message at top of page the highlighted fields must be addressed before this update can be saved

Examples:
|entity|searchBy|fid|officeFid|day|month|year|
|1010|FID|1010|1010-44|15|Jan|2020|

Scenario: User updates Office Opened date- Verify null values are allowed for day, month and year

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
And the user clicks on the office update link
And the user updates office Opened <day> <month> <year>
And the user clicks on the save button
Then the user should see the save confirmation modal
When the user clicks on the confirm button
Then the user verifies office opened date from zeus document <fid> <day> <month> <year>


Examples:
|entity|searchBy|fid|officeFid|day|month|year|
|1010|FID|1010|1010-44||||


Scenario: Verify the default Edit value and Save Lead Location value for an office
       a. Select the value as True for Lead Location flag and Save for an office with a default value as True or False
       b. Select the value as False for Lead Location flag and Save for an office with a default value as True or False

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
And the user clicks on the office update link
When the user gets the document with get id for offices with the <officeFid> from the database
And the user selects lead location value <leadLocationflag> in the basicinfo office page
And the user clicks on the save button
Then the user should see the save confirmation modal
And the user should see the below summary changes in confirmation modal
|Summary|
|Basic Info|
When the user clicks on the confirm button
Then the user should see leadLocation value as <leadLocationflag> for fid <fid> in zeus document
And the user reverts the changes to the document

Examples:
|entity|searchBy|fid|officeFid|leadLocationflag|
|1010|FID|1010|1010-44|true|
|1010|FID|1010|1010-51|false|
