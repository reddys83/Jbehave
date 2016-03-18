Meta:@EditCountryBasicInfo @Edit @Country

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal
JIRA ID - ZEUS-708 - User can edit country names
JIRA ID - ZEUS-712 - User can edit country timezones
JIRA ID - ZEUS-445 - Edit Language Summary for country
JIRA ID - ZEUS-191 - User can edit country basic info
JIRA ID - ZEUS-710 - User can edit country identifiers
JIRA ID - ZEUS-684 - User will get warning if click away from screen they are editing
JIRA ID - ZEUS-827 - User can only input number in date fields
JIRA ID - ZEUS-745 - User will see summary of changes made in confirmation modal
JIRA ID - ZEUS-441 - User can save edits to country

Scenario: Verify country names type from lookup COUNTRY_NAME_TYPE
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
And the user clicks on the update link
And the user clicks on the country name type drop-down
Then the user should see the country name types from lookup COUNTRY_NAME_TYPE

Examples:
|country|
|Afghanistan|

Scenario: Verify error message required
Bug ZEUS-898
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
When the user clicks on the delete time zone row button in the basic info country page
When the user clicks on the yes button in the delete row confirmation modal in the country page
Then the user should not see the newly added time zone row in the basic info country page

Examples:
|country|
|Albania|

Scenario:Error message displayed when tryiing to edit Language summary
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
And the user clicks on the update link
And the user clicks on language option
And the user enters country languages as <countryLanguages> in the country language country page
When the user clicks on the save button
Then the user should see the error message enter upto 100 valid characters for the country language in the country page
Then the user should see the error message at top of page the highlighted fields must be addressed before this update can be saved

Examples:
|country|countryLanguages|
|Albania|abcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcde1|

Scenario: The edit country basic info, country selection drop-down disabled ISO2 and ISO3 and status should not be editable.
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
And the user clicks on the update link
Then the user should see the country selection disabled in the country page
And the user should see the country ISO2 not editable
And the user should see the country ISO3 not editable
And the user should see the country status not editable
And the user should see the edits to country basic info from trusted dcoument

Examples:
|country|
|Åland Islands|

Scenario: The edit country basic info, The replaced by drop down lists all active countries, except the country the user is currently editing.
Meta:
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
And the user clicks on the update link
And the user clicks on replaced by drop down
Then the user should see the list of all active countries except the country the user is currently editing

Examples:
|country|
|Åland Islands|

Scenario: The edit country basic info, The user should see the error messagses for start and end date if the dates are later than today
Meta:
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
And the user clicks on the update link
And the user enters the begin date later than today
And the user enters the end date later than today
And the user clicks on the save button
Then the user should see the error 'Must be no later than today.' for start date
Then the user should see the error 'Must be no later than today.' for end date

Examples:
|country|
|Åland Islands|

Scenario: The edit country basic info, The user should see the error messagses for start and end date if the dates are later than today
Meta:
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
And the user clicks on the update link
And the user enters country end year as <countryEndYear>
And the user clicks on the save button
Then the user should see the error 'Must be after start date.' for end date

Examples:
|country|countryEndYear|
|Åland Islands|1814|

Scenario: The edit country basic info, The user should see the error messages for invalid inputs
TestCase: ZEUS-827
Meta:
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
And the user clicks on the update link
When the user enters country start year as <countryStartYear>
And the user enters country end year as <countryEndYear>
When the user enters more than 500 characters in the country add info
And the user enters more than 200 characters in the country imports
And the user enters more than 200 characters in the country exports
And the user enters more than 200 characters in the country political structure
And the user enters more than 5 characters inthe country intl dialing code
And the user clicks on the save button
Then the user should see the error message enter a day/month/year for startDate in country basic info page
And the user should see the error message enter a day/month/year for endDate in country basic info page
Then the user should see the error message enter uptp 500 valid charecters for addinfo
And the user should see the error message enter upto 200 valid charecters for imports
And the user should see the error message enter upto 200 valid charecters for exports
And the user should see the error message enter upto 200 valid charecters for political structure
And the user should see the error message enter upto 5 valid charectes for intl dialing code
Then the user should see the error message at top of page the highlighted fields must be addressed before this update can be saved

Examples:
|country|countryStartYear|countryEndYear|
|Åland Islands|abc|abc|

Scenario: The edit country basic info, The user enters valid data should see the confirm modal
BUG: ZEUS-900
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
And the user clicks on the update link
When the user enters country start year as <countryStartYear>
And the user enters country end year as <countryEndYear>
And the user selects replaced by country from the drop down as <countryReplacedBy>
When the user enters country add info as <countryAddInfo>
And the user enters country imports as <countryImports>
And the user enters country exports as <countryExports>
And the user enters country political structure as <countryPoliticalStructure>
And the user enters country intl dialing code as <countryIntlDialingCode>
And the user clicks on the save button
Then the user should see the save confirmation modal

Examples:
|country|countryStartYear|countryEndYear|countryReplacedBy|countryAddInfo|countryImports|countryExports|countryPoliticalStructure|countryIntlDialingCode|
|Åland Islands|1819|2011|Algeria|Machinery and equipment, foodstuffs, textiles, chemicals|Machinery and equipment, foodstuffs, textiles, chemicals|Textiles and footwear; asphalt, metals and metallic ores, crude oil; vegetables, fruits, tobacco|Parliamentary Republic|355|

Scenario: User can edit country identifiers - Verify that an error message is displayed for required and invalid fields for newely added identifier - "Type","Value" and "Status", for new row on Saving.
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
And the user clicks on the update link
And the user clicks on the add new identifier button in the basic info country page
And the user should see the default identifier status as active
And the user clicks on the save button
Then the user should see the error message for the required identifier value field in the basic info identifier page
Then the user should see the error message for the required identifier type field in the basic info identifier page
And the user should see the error message at top of page the highlighted fields must be addressed before this update can be saved
When the user enters identifier type as <identifierType> in the basic info country page
And the user enters identifier value as <identifierValueIncorrect> in the basic info country page
And the user clicks on the save button
Then the user should see the Enter up to 50 valid characters error message for the identifier value field in the basic info identifier page

Examples:
|country|identifierType|identifierValueIncorrect|
|Albania|Numeric ISO Code|aksjuilrw1aksjuilrw1aksjuilrw1aksjuilrw1aksju%)~12y1|

Scenario: User can edit country identifiers - Verify country Identifier types from lookup THIRD_PARTY_IDENTIFIER_GEO
Meta:
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
And the user clicks on the update link
And the user clicks on the add new identifier button in the basic info country page
And the user clicks on the country Identifier type drop-down
Then the user should see the country identifier types from lookup THIRD_PARTY_IDENTIFIER_GEO

Examples:
|country|
|Albania|

Scenario: User can edit country identifiers - Verify deletion message on new row - please confirm - would you like to delete this row?
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
And the user clicks on the update link
And the user clicks on the add new identifier button in the basic info country page
When the user clicks on the delete identifier row button in the basic info country page
Then the user should see the delete row confirmation modal in the country page
When the user clicks on the no button in the delete row confirmation modal in the country page
Then the user should see the newly added identifier row in the basic info country page
When the user clicks on the delete identifier row button in the basic info country page
When the user clicks on the yes button in the delete row confirmation modal in the country page
Then the user should not see the newly added identifier row in the basic info country page

Examples:
|country|
|Albania|

Scenario:User can edit country identifiers-Verify that an error message is displayed for required and invalid fields- "Type","Value" and "Status", for old row on Saving.
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
And the user clicks on the update link
When the user enters identifier type as <identifierType> in the basic info country page
And the user clears identifier value in the basic info country page
And the user clicks on the save button
Then the user should see the error message for the required identifier value field in the basic info identifier page
Then the user should see the error message for the required identifier type field in the basic info identifier page
And the user should see the error message at top of page the highlighted fields must be addressed before this update can be saved

Examples:
|country|identifierType|
|Afghanistan||

Scenario:User will get warning if click away from screen they are editing
Meta:
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
And the user clicks on the update link
And the user clicks on the country basic info link in the navigation bar
Then the user should not see the cancel update confirmation modal
When the user clicks on the currency tab in the data area
Then the user should see the cancel update confirmation modal
When the user clicks on the cancel no button
Then the user should return to edit country page mode
When the user clicks on the currency tab in the data area
Then the user should see the cancel update confirmation modal
When the user clicks on the cancel yes button
And the user clicks on the choose a currency option in the currency page
And the user enters the currency <currency> in the typeahead box in the currency page
Then the user should see the currency page

Examples:
|country|currency|
|Afghanistan|Rand|

Scenario: User will see summary of changes made in confirmation modal
Meta:
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
And the user clicks on the update link
When the user clicks on the add new demographics button in the country basic info page
And the user selects the demographic types <demographicType> in the country basic info page
And the user enter the demographic value <demographicValue> in the country basic info page
When the user enters country start year as <countryStartYear>
And the user enters country end year as <countryEndYear>
And the user clicks on the add new holiday button in the holidays country page
And the user enters holiday day <day> in the holidays country page
And the user enters holiday month <month> in the holidays country page
And the user enters holiday year <year> in the holidays country page
When the user clicks on the country credit rating link in the navigation bar
And the user clicks on add new credit rating button in the credit rating country page
And the user enters applied date year <appliedYear> in the credit rating country page
And the user enters confirmed date year <confirmedYear> in the credit rating country page
And the user clicks on the save button
Then the user should see the save confirmation modal
And the user should see the below summary changes in confirmation modal
|Summary|
|Basic Info / Demographics|
|Basic Info|
|Holidays|
|Credit Ratings|


Examples:
|country|demographicType|demographicValue|appliedYear|confirmedYear|countryStartYear|countryEndYear|day|month|year|
|Guam|Largest County Population|34000000|2011|2013|2011|2013|1|Jan|2015|

Scenario: save country basic info
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
And the user clicks on the update link
And the user get the document with get Id for country with the name as Bosnia-Herzegovina from the database

When the user enters country start year as <countryStartYear>
And the user enters country end year as <countryEndYear>
And the user clicks on the save button
And the user clicks on the confirm button
Then the user should see the edits to country basic info in zeus document
And the user reverts the changes to the document

Examples:
|country|countryStartYear|countryEndYear|
|Bosnia-Herzegovina|2014|2015|
