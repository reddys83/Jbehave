Meta:@EditCountryHolidays @Edit @Country

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal
JIRA ID - ZEUS-247 - User can edit country holidays
JIRA ID - ZEUS-441 - User can save edits to country

Scenario: Verify error message enter a year, month/year or day/month/year for existing holiday
1. only day
2. only day and month
3. only day and year
4. only month
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
And the user clicks on the update link
And the user clicks on the country holidays link in the navigation bar
And the user enters holiday day <day> in the holidays country page
And the user enters holiday month <month> in the holidays country page
And the user enters holiday year <year> in the holidays country page
And the user clicks on the save button
Then the user should see the error message enter a day/month/year in the holidays country page
And the user should see the error message at top of page the highlighted fields must be addressed before this update can be saved

Examples:
|country|day|month|year|
|Afghanistan|1|||
|Afghanistan|1|Jan||
|Afghanistan|1||1988|
|Afghanistan||Jan||
|Afghanistan|abc||abc|

Scenario: Verify error message enter a year, month/year or day/month/year for newly added holiday
1. only day
2. only day and month
3. only day and year
4. only month
Meta:
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
And the user clicks on the update link
And the user clicks on the country holidays link in the navigation bar
And the user clicks on the add new holiday button in the holidays country page
And the user enters holiday day <day> in the holidays country page
And the user enters holiday month <month> in the holidays country page
And the user enters holiday year <year> in the holidays country page
And the user clicks on the save button
Then the user should see the error message enter a day/month/year in the holidays country page
And the user should see the error message at top of page the highlighted fields must be addressed before this update can be saved

Examples:
|country|day|month|year|
|American Samoa|1|||
|American Samoa|1|Jan||
|American Samoa|1||1988|
|American Samoa||Jan||

Scenario: Verify error message required for holidays date existing holiday
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
And the user clicks on the update link
And the user clicks on the country holidays link in the navigation bar
And the user enters holiday day <day> in the holidays country page
And the user enters holiday month <month> in the holidays country page
And the user enters holiday year <year> in the holidays country page
And the user clicks on the save button
Then the user should see the error message required for holiday date in the holidays country page
And the user should see the error message at top of page the highlighted fields must be addressed before this update can be saved

Examples:
|country|day|month|year|
|Afghanistan||||

Scenario: Verify error message required for holidays date for newly added holiday
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
And the user clicks on the update link
And the user clicks on the country holidays link in the navigation bar
And the user clicks on the add new holiday button in the holidays country page
And the user enters holiday day <day> in the holidays country page
And the user enters holiday month <month> in the holidays country page
And the user enters holiday year <year> in the holidays country page
And the user clicks on the add new holiday button in the holidays country page
And the user clicks on the save button
Then the user should see the error message required for holiday date in the holidays country page
And the user should see the error message at top of page the highlighted fields must be addressed before this update can be saved

Examples:
|country|day|month|year|
|American Samoa||||

Scenario: Verify error message required for holidays date for existing holiday
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
And the user clicks on the update link
And the user clicks on the country holidays link in the navigation bar
And the user enters holiday day <day> in the holidays country page
And the user enters holiday month <month> in the holidays country page
And the user enters holiday year <year> in the holidays country page
And the user enters holiday description <description> in the holidays country page
And the user enters holiday notes <notes> in the holidays country page
And the user clicks on the save button
Then the user should see the error message enter up to 100 valid characters for holiday description in the holidays country page
Then the user should see the error message enter up to 100 valid characters for holiday notes in the holidays country page
And the user should see the error message at top of page the highlighted fields must be addressed before this update can be saved

Examples:
|country|day|month|year|description|notes|
|Afghanistan|1|Jan|1988|Test DescriptionTest DescriptionTest DescriptionTest DescriptionTest DescriptionTest DescriptionTest Description|Test NoteTest NoteTest NoteTest NoteTest NoteTest NoteTest NoteTest NoteTest NoteTest NoteTest NoteTest Note|

Scenario: Verify error message required for holidays date for newly added holiday
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
And the user clicks on the update link
And the user clicks on the country holidays link in the navigation bar
And the user clicks on the add new holiday button in the holidays country page
And the user enters holiday day <day> in the holidays country page
And the user enters holiday month <month> in the holidays country page
And the user enters holiday year <year> in the holidays country page
And the user enters holiday description <description> in the holidays country page
And the user enters holiday notes <notes> in the holidays country page
And the user clicks on the save button
Then the user should see the error message enter up to 100 valid characters for holiday description in the holidays country page
Then the user should see the error message enter up to 100 valid characters for holiday notes in the holidays country page
And the user should see the error message at top of page the highlighted fields must be addressed before this update can be saved

Examples:
|country|day|month|year|description|notes|
|American Samoa|1|Jan|1988|Test DescriptionTest DescriptionTest DescriptionTest DescriptionTest DescriptionTest DescriptionTest Description|Test NoteTest NoteTest NoteTest NoteTest NoteTest NoteTest NoteTest NoteTest NoteTest NoteTest NoteTest Note|

Scenario: Verify delete confirmation
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
And the user clicks on the update link
And the user clicks on the country holidays link in the navigation bar
And the user clicks on the add new holiday button in the holidays country page
When the user clicks on the delete holiday row button in the basic info country page
Then the user should see the delete row confirmation modal in the country page
When the user clicks on the no button in the delete row confirmation modal in the country page
Then the user should see the newly added holiday row in the holiday country page
When the user clicks on the delete holiday row button in the basic info country page
When the user clicks on the yes button in the delete row confirmation modal in the country page
Then the user should not see the newly added holiday row in the holiday country page

Examples:
|country|
|American Samoa|

Scenario: Save country holidays
Bug : ZEUS-900
Meta:
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
And the user clicks on the update link
And the user get the document with get Id for country with the name as Bosnia-Herzegovina from the database

When the user clicks on the add new holiday button in the holidays country page
And the user enters holiday day <day> in the holidays country page
And the user enters holiday month <month> in the holidays country page
And the user enters holiday year <year> in the holidays country page
And the user enters holiday description <description> in the holidays country page
And the user enters holiday notes <notes> in the holidays country page
And the user clicks on the save button
And the user clicks on the confirm button
Then the user should see the edits to country banking hrs in zeus document
And the user reverts the changes to the document

Examples:
|country|day|month|year|description|notes|
|Bosnia-Herzegovina|1|Jan|2016|New Year|New Year 2016|