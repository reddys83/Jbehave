Meta:

Narrative:
JIRA ID - ZUES- 84 - User can update a legal entity's charter type

Scenario: User updates Charter type
Veriyfing if charter type values are updated in Zeus and Trusted documents.
Verifying the options displayed for charter type are same as those in lookup document.
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
Then the user should see the message you can search for a legal entity at any time using the header search
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
Then the user should see the search results for the institution
When the user clicks on the search results card with fid <fid>
And the user clicks on the update link
Then the user verifies options displayed for charter type from trusted document
And the user validates default value for charter type from trusted document <fid>
When the user updates charter type value <chartertype>
And the user clicks on the save button
Then the user should see the save confirmation modal
When the user clicks on the confirm button
Then the user verifies charter type from trusted and zeus document <fid>



Examples:
|entity|searchBy|fid|chartertype|
|1038|fid|1038|Private|