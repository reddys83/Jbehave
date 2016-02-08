Meta:@EditCountryBasicInfo @Edit @Country

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal
JIRA ID - ZEUS-708 - User can edit country names
JIRA ID - ZEUS-712 - User can edit country timezones

Scenario: Verify country names type from lookup COUNTRY_NAME_TYPE
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
And the user clicks on the update link
And the user clicks on the add new name button in the basic info country page
And the user clicks on the country name type drop-down
Then the user should see the country name types from lookup COUNTRY_NAME_TYPE

Examples:
|country|
|Afghanistan|

Scenario: Verify error message required
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
And the user clicks on the update link
And the user clicks on the add new name button in the basic info country page
And the user enters country name as <countryName> in the basic info country page
And the user clicks on the save button
Then the user should see the error message for the required country name field in the basic info country page
Then the user should see the error message for the required name type field in the basic info country page
Then the user should see the error message for the required name value field in the basic info country page
And the user should see the error message at top of page the highlighted fields must be addressed before this update can be saved

Examples:
|country|countryName|
|Albania||

Scenario: Verify message please confirm - would you like to delete this row?
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
And the user clicks on the update link
And the user clicks on the add new name button in the basic info country page
And the user clicks on the delete name row button in the basic info country page
Then the user should see the delete row confirmation modal in the country page
When the user clicks on the no button in the delete row confirmation modal in the country page
Then the user should see the newly added name row in the basic info country page
When the user clicks on the delete name row button in the basic info country page
When the user clicks on the yes button in the delete row confirmation modal in the country page
Then the user should not see the newly added name row in the basic info country page

Examples:
|country|
|Albania|

Scenario: Verify message enter up to 50 valid characters
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
And the user clicks on the update link
And the user enters country name as <countryName> in the basic info country page
And the user clicks on the save button
Then the user should see the error message enter up to 50 valid characters for country name value in the basic info country page

Examples:
|country|countryName|
|Afghanistan|AfghanistanAfghanistanAfghanistanAfghanistanAfghanistanAfghanistan|

Scenario: Verify message enter up to 100 valid characters"
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
And the user clicks on the update link
And the user enters time zones summary <timeZoneSummary> in the basic info country page
And the user clicks on the save button
Then the user should see the error message enter up to 100 valid characters for time zone summary in the basic info country page

Examples:
|country|timeZoneSummary|
|Albania|1 hour+1 hour+1 hour+1 hour+1 hour+1 hour+1 hour+1 hour+1 hour+1 hour+1 hour+1 hour+1 hour+1 hour+1hrs|

Scenario: Verify time zone is from look up TIME_ZONE
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
And the user clicks on the update link
And the user clicks on the add new time zone button in the basic info country page
And the user clicks on the select time zone list in the basic info country page
Then the user should see the country time zones from lookup TIME_ZONE

Examples:
|country|
|Albania|

Scenario: Verify delete confirmation modal
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
And the user clicks on the update link
And the user clicks on the add new time zone button in the basic info country page
And the user clicks on the select time zone list in the basic info country page
When the user clicks on the delete time zone row button in the basic info country page
Then the user should see the delete row confirmation modal in the country page
When the user clicks on the no button in the delete row confirmation modal in the country page
Then the user should see the newly added time zone row in the basic info country page
When the user clicks on the delete name row button in the basic info country page
When the user clicks on the yes button in the delete row confirmation modal in the country page
Then the user should not see the newly added time zone row in the basic info country page

Examples:
|country|
|Albania|