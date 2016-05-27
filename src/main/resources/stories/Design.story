Meta:@Design


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
And the user clicks on the value dropdown in legalEntity board meeting for legalEntity_boardMeetings_first_new_type_dropdown
And the user selects value <value> in the legalEntity board meeting for legalEntity_boardMeetings_first_new_type_dropdown
And the user clicks on the add new board meeting button in legalEntity
And the user clicks on the type dropdown in legalEntity board meeting for legalEntity_boardMeetings_second_new_type_dropdown
And the user selects type <type> in the legalEntity board meeting for legalEntity_boardMeetings_second_new_type_dropdown
And the user clicks on the value dropdown in legalEntity board meeting for legalEntity_boardMeetings_second_new_type_dropdown
And the user selects value <value> in the legalEntity board meeting for legalEntity_boardMeetings_second_new_type_dropdown
And the user clicks on the save button
Then user should see the duplicate error message for value dropdown in legalEntity board meeting


Examples:
|entity|searchBy|fid|summary|type|value|
|1717|FID|1717|Stock Exchange Interim Entity Identifier|Month|Jan|
