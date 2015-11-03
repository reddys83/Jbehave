Meta:@OfficeBasicInfo  @Office

Narrative:
In order to view and edit the office
As a user
I want to cover the requirements mentioned in
JIRA ID - ZEUS-404 - User can view office basic info

Scenario: Verify the basic info for office
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
Then the user should see the message you can search for a legal entity at any time using the header search
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
Then the user should see the search results for the institution

And the user clicks on the offices tab in the legal entity

Then the user should see the offices for the legal entity

When the user clicks on the office with fid <fid>

Then the user should see the basic info for the selected office

And the user should see the office's names as:
|TYPE|VALUE|
|||
|||
|||

And the user should see the office types:
|TYPE|
||


And the user should see the Prefix of an office as
And the user should see the Suffix of an office as
And the user should see the Override of an office as
And the user should see the Status of an office as
And the user should see the Opened of an office as
And the user should see the Closed of an office as
And the user should see the Lead Location of an office as
And the user should see the Principal Office of an office as
And the user should see the Foreign Office of an office as
And the user should see the Business Hours of an office as
And the user should see the Add Info of an office as


Examples:
|entity|searchBy|fid|


