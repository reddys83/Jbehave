Meta:@EditOfficeBasicInfo @Edit @Office @AllStories

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal
JIRA ID - ZEUS-1066 - User can edit Office's Opened Date

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


Scenario: User updates the Prefix, Suffix and Override fields. Verifies that Override value is saved and Prefix and Suffix values are null in Zeus document.
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
And the user enters the office prefix value as <prefix>
And the user enters the office suffix value as <suffix>
And the user enters the office override value as <override>
And the user clicks on the save button
Then the user should see the save confirmation modal
When the user clicks on the confirm button
Then the user should verify the prefix,suffix and override values for fid <officeFid> as:
|prefix|suffix|override|
|||testoverride|

Examples:
|entity|searchBy|fid|officeFid|prefix|suffix|override|
|1010|FID|1010|1010-44|testprefix|testsuffix|testoverride|

Scenario: User updates the Prefix, Suffix fields and keeps override as blank. Verifies that Override value is null and Prefix and Suffix values are saved in Zeus document.
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
And the user enters the office prefix value as <prefix>
And the user enters the office suffix value as <suffix>
And the user enters the office override value as <override>
And the user clicks on the save button
Then the user should see the save confirmation modal
When the user clicks on the confirm button
Then the user should verify the prefix,suffix and override values as:
|prefix|suffix|override|
|testprefix|testsuffix||

Examples:
|entity|searchBy|fid|officeFid|prefix|suffix|override|
|1010|FID|1010|1010-44|testprefix|testsuffix||

Scenario: User updates the suffix value and keeps prefix and Override value as blank. Verifies that suffix value is saved and prefix and Override values are null in Zeus document.
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
And the user enters the office prefix value as <prefix>
And the user enters the office suffix value as <suffix>
And the user enters the office override value as <override>
And the user clicks on the save button
Then the user should see the save confirmation modal
When the user clicks on the confirm button
Then the user should verify the prefix,suffix and override values as:
|prefix|suffix|override|
||testsuffix||

Examples:
|entity|searchBy|fid|officeFid|prefix|suffix|override|
|1010|FID|1010|1010-44||testsuffix||

Scenario: User updates the prefix value and keeps suffix and Override value as blank. Verifies that prefix value is saved and suffix and Override values are null in Zeus document.
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
And the user enters the office prefix value as <prefix>
And the user enters the office suffix value as <suffix>
And the user enters the office override value as <override>
And the user clicks on the save button
Then the user should see the save confirmation modal
When the user clicks on the confirm button
Then the user should verify the prefix,suffix and override values as:
|prefix|suffix|override|
|testprefix|||

Examples:
|entity|searchBy|fid|officeFid|prefix|suffix|override|
|1010|FID|1010|1010-44|testprefix|||

Scenario: User updates the prefix and suffix values and enters blank spaces in the Override field. Verifies that prefix and suffix values are saved and Override value is null in Zeus document.
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
And the user enters the office prefix value as <prefix>
And the user enters the office suffix value as <suffix>
And the user enters the office override value as <override>
And the user clicks on the save button
Then the user should see the save confirmation modal
When the user clicks on the confirm button
Then the user should verify the prefix,suffix and override values for fid <>as:
|prefix|suffix|override|
|testprefix|testsuffix||

Examples:
|entity|searchBy|fid|officeFid|prefix|suffix|override|
|1010|FID|1010|1010-44|testprefix|testsuffix|     |