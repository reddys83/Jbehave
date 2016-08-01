Meta:@EditLegalEntityBoardMeeting @Edit @LegalEntity

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal
JIRA ID - ZEUS-910 - User can edit Legal Entity's Board Meetings

Scenario: Verify legalEntity board meeting type values should list month and quater
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
When the user clicks on the legal entity board meetings link in the navigation bar
And the user clicks on the legalEntity update link
And the user clicks on the add new board meeting button in legalEntity
And the user clicks on the type dropdown in legalEntity board meeting for legalEntity_boardMeetings_first_new_type_dropdown
Then the user should see the below options for legalEntity board meeting type dropdown as:
|Type|
|Month|
|Quarter|

Examples:
|entity|searchBy|fid|
|1717|FID|1717|

Scenario: Verify legalEntity board meeting value dropdown for type MONTH
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
When the user clicks on the legal entity board meetings link in the navigation bar
And the user clicks on the legalEntity update link
And the user clicks on the add new board meeting button in legalEntity
And the user clicks on the type dropdown in legalEntity board meeting for legalEntity_boardMeetings_first_new_type_dropdown
And the user selects type <type> in the legalEntity board meeting for legalEntity_boardMeetings_first_new_type_dropdown
And the user clicks on the value dropdown in legalEntity board meeting for legalEntity_boardMeetings_first_new_type_dropdown
Then the user should see the below options for legalEntity board meeting value dropdown as:
|Value|
|Jan|
|Feb|
|Mar|
|Apr|
|May|
|Jun|
|Jul|
|Aug|
|Sep|
|Oct|
|Nov|
|Dec|

Examples:
|entity|searchBy|fid|type|
|1717|FID|1717|Month|

Scenario: Verify legalEntity board meeting value dropdown for type QUATER
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
When the user clicks on the legal entity board meetings link in the navigation bar
And the user clicks on the legalEntity update link
And the user clicks on the add new board meeting button in legalEntity
And the user clicks on the type dropdown in legalEntity board meeting for legalEntity_boardMeetings_first_new_type_dropdown
And the user selects type <type> in the legalEntity board meeting for legalEntity_boardMeetings_first_new_type_dropdown
And the user clicks on the value dropdown in legalEntity board meeting for legalEntity_boardMeetings_first_new_type_dropdown
Then the user should see the below options for legalEntity board meeting value dropdown as:
|Value|
|1|
|2|
|3|
|4|

Examples:
|entity|searchBy|fid|type|
|1717|FID|1717|Quarter|

Scenario: Veirfy the valid inputs for legalEntity Board meeting - Bug-ZEUS-1225
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
When the user clicks on the legal entity board meetings link in the navigation bar
And the user clicks on the legalEntity update link
When the user gets the document with get Id for legalentity with the fid as <entity> from the database
And the user clicks on the add new board meeting button in legalEntity
And the user enters summary <summary> in the legalEntity boardMeeting
And the user clicks on the type dropdown in legalEntity board meeting for legalEntity_boardMeetings_first_new_type_dropdown
And the user selects type <type> in the legalEntity board meeting for legalEntity_boardMeetings_first_new_type_dropdown
And the user clicks on the value dropdown in legalEntity board meeting for legalEntity_boardMeetings_first_new_type_dropdown
And the user selects value <value> in the legalEntity board meeting for legalEntity_boardMeetings_first_new_type_dropdown
And the user clicks on the save button
Then the user should see the save confirmation modal
When the user clicks on the confirm button
Then the user should see the edits to legal entity board meeting for fid <fid> in zeus document
Then the user reverts the changes to the document


Examples:
|entity|searchBy|fid|summary|type|value|monthNumber|
|1717|FID|1717|Stock Exchange Interim Entity Identifier|Month|Jan|1|


Scenario: Verify the error message for summary field.
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
When the user clicks on the legal entity board meetings link in the navigation bar
And the user clicks on the legalEntity update link
And the user enters more than 10000 character in summary for legalEntity boardMeetings
And the user clicks on the save button
Then the user should see the error message enter up to 10000 valid characters for summary in legalentity boardMeeting

Examples:
|entity|searchBy|fid|
|1717|FID|1717|

Scenario: Verify legalEntity board meeting value dropdown for type MONTH
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
When the user clicks on the legal entity board meetings link in the navigation bar
And the user clicks on the legalEntity update link
When the user gets the document with get Id for legalentity with the fid as <entity> from the database
And the user clicks on the add new board meeting button in legalEntity
And the user enters summary <summary> in the legalEntity boardMeeting
And the user clicks on the type dropdown in legalEntity board meeting for legalEntity_boardMeetings_first_new_type_dropdown
And the user selects type <type> in the legalEntity board meeting for legalEntity_boardMeetings_first_new_type_dropdown
And the user clicks on the value dropdown in legalEntity board meeting for legalEntity_boardMeetings_first_new_value_dropdown
And the user selects value <value> in the legalEntity board meeting for legalEntity_boardMeetings_first_new_value_dropdown
And the user clicks on the add new board meeting button in legalEntity
And the user clicks on the type dropdown in legalEntity board meeting for legalEntity_boardMeetings_second_new_type_dropdown
And the user selects type <type> in the legalEntity board meeting for legalEntity_boardMeetings_second_new_type_dropdown
And the user clicks on the value dropdown in legalEntity board meeting for legalEntity_boardMeetings_second_new_value_dropdown
And the user selects value <value> in the legalEntity board meeting for legalEntity_boardMeetings_second_new_value_dropdown
And the user clicks on the save button
Then user should see the duplicate error message for value dropdown in legalEntity board meeting


Examples:
|entity|searchBy|fid|summary|type|value|
|1717|FID|1717|Stock Exchange Interim Entity Identifier|Month|Jan|
