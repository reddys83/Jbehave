Meta: @EditCityBasicInfo @Edit @City @AllStories

Narrative:
In order to view and edit the city page
As a user
I want to cover the requirements mentioned in

JIRA ID - ZEUS-962 - User can view City status and can edit the city status
JIRA ID - ZEUS-969 -User can edit City's Add info
JIRA ID - ZEUS-972 -User can edit City's Identifiers
JIRA ID - ZEUS-968 - User can edit City's Population
JIRA ID - ZEUS-964 - User can edit City's END Date
JIRA ID - ZEUS-980 - User can edit City's Use In Address Flag
JIRA ID - ZEUS-963 - User can edit City's Began Date
JIRA ID - ZEUS-970 - User can edit City's Names

Scenario: Verify City Status dropdown values from lookup Status
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
And the user clicks on the city basic info link in the navigation bar
When the user clicks on the city update link
And the user clicks on the Status drop-down in the basicinfo city page
Then the user should see the status values from City Status dropdown

Examples:
|country|area|city|
|USA|Georgia|Adrian|

Scenario: Verify that the City Status drop-down list should highlight the values that contain characters input by user
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
And the user clicks on the city basic info link in the navigation bar
When the user clicks on the city update link
And the user starts typing the name of a status as i in the City Status drop-down
Then the user should see the selected status in the City Status drop-down as Inactive
When the user starts typing the name of a status as a in the City Status drop-down
Then the user should see the selected status in the City Status drop-down as Active
When the user starts typing the name of a status as p in the City Status drop-down
Then the user should see the selected status in the City Status drop-down as Pending
When the user starts typing the name of a status as x in the City Status drop-down
Then the user should see the selected status in the City Status drop-down as Pending

Examples:
|country|area|city|
|USA|Georgia|Adrian|

Scenario: User will see summary of changes made in confirmation modal when update the City status
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
And the user clicks on the city basic info link in the navigation bar
When the user clicks on the city update link
When the user selects value as <status> from Status drop-down in the city basicinfo page
And the user clicks on the save button in city page
When the user clicks on the confirm button
When the user clicks on the city update link
When the user starts typing the name of a status as i in the City Status drop-down
Then the user should see the selected status in the City Status drop-down as inactive
When the user clicks on the save button
Then the user should see the save confirmation modal
And the user should see the below summary changes in confirmation modal
|Summary|
|Basic Info|
When the user clicks on the return button
Then the user should return to edit city page mode

Examples:
|country|area|city|status|
|USA|Georgia|Adrian|active|


Scenario: Edit and Save City's Status value in the City Basic Info page
a) Veriy that the default value of status during edit matches with the status of the trusted document
b) Upate the status with a new value and verify it is updated in zeus document
c) Upate the status with the same existing value and verify the existing value in zeus document
d) verify that the status can be changed to all 3 values active,inactive and pending

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
And the user clicks on the city basic info link in the navigation bar
When the user clicks on the city update link
Then the user should see the city status value same as in trusted document
When the user gets the document with get document id for city with the <city> from the database
When the user selects value as <status> from Status drop-down in the city basicinfo page
And the user clicks on the save button in city page
Then the user should see the save confirmation modal
When the user clicks on the confirm button
Then the user should see the city <status> value as in zeus document
Then the user reverts the changes to the document

Examples:
|country|area|city|status|
|USA|Georgia|Adrian|active|
|USA|Georgia|Adrian|pending|
|USA|Georgia|Adrian|inactive|


Scenario: No changes should happen to City's Status value in the City Basic Info page when user selects save button with out doing any changes 

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
And the user clicks on the city basic info link in the navigation bar
When the user clicks on the city update link
Then the user should see the city status value same as in trusted document
When the user clicks on the save button in city page
Then the user should see the save confirmation modal
Then the user should not see the <ConfirmationSummary> changes in confirmation modal
When the user clicks on the confirm button
Then the user should see the city <status> value as in zeus document

Examples:
|country|area|city|status|ConfirmationSummary|
|USA|Georgia|Adrian|active|Summary|

Scenario: The user can edit the value in the Add Info field and save it and see it on the front end(Front End Validation)
Meta:ted10
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
When the user clicks on the choose an area option
When the user enters the area <area> in the type-ahead box
When the user clicks on the choose a city option
When the user enters the city <city> in the type-ahead box
And the user clicks on the city basic info link in the navigation bar
When the user clicks on the city update link
When the user gets the document with get document id for city with the <city> from the database
And the user enters the <addInfoText> in the add info text area
When the user clicks on the save button in city page
Then the user should see the below summary changes in confirmation modal
|Summary|
|Basic Info|
When the user clicks on the confirm button
Then the user should see the successful update message at top of the page
Then the user should be able to verify the values are entered in the add info field
Then the user reverts the changes to the document


Examples:
|country|area|city|addInfoText|
|Afghanistan|Badakshan|Panj Shair|Sample text|

Scenario: To update the City's 'Basic Info' by entering a value for 'Add Info' that is different from the current value(Back End validation)
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
When the user clicks on the choose an area option
When the user enters the area <area> in the type-ahead box
When the user clicks on the choose a city option
When the user enters the city <city> in the type-ahead box
And the user clicks on the city basic info link in the navigation bar
And the user clicks on the city update link
Then the user should see the addInfoText value same as in trusted document
When the user enters the <addInfoText> in the add info text area
When the user clicks on the save button in city page
And the user clicks on the confirm button
Then the user should see the city addinfo value <addInfoText> as in zeus document


Examples:
|country|area|city|addInfoText|
|Afghanistan|Badakshan|Panj Shair|This is a different text|

Scenario: To view that there is no change in value when the user has entered a value for 'Add Info' that is no different to the current value(Front End Validation)
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
When the user clicks on the choose an area option
When the user enters the area <area> in the type-ahead box
When the user clicks on the choose a city option
When the user enters the city <city> in the type-ahead box
And the user clicks on the city basic info link in the navigation bar
And the user clicks on the city update link
When the user enters the <addInfoText> in the add info text area
When the user clicks on the save button in city page
Then the user should see no summary changes in the city save confirmation modal

Examples:
|country|area|city|addInfoText|Summary|
|Afghanistan|Badakshan|Panj Shair|This is a different text|Basic Info|

Scenario: To view whether the text entered in the 'Add Info' field is not beyond 500 unicode characters after saving the page
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
When the user clicks on the choose an area option
When the user enters the area <area> in the type-ahead box
When the user clicks on the choose a city option
When the user enters the city <city> in the type-ahead box
And the user clicks on the city basic info link in the navigation bar
And the user clicks on the city update link
When the user enters values which is beyond 500 unicode characters in the add info field
When the user clicks on the save button in city page
And the user clicks on the confirm button
Then the user should see the successful update message at top of the page
Then the user should be able to view that only 500 unicode characters are saved
Then the user should be able to verify the maximum values are entered in the add info field


Examples:
|country|area|city|
|Afghanistan|Badakshan|Panj Shair|


Scenario: User can edit country identifiers - Verify country Identifier types are same as from lookup THIRD_PARTY_IDENTIFIER_GEO
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
And the user clicks on the city basic info link in the navigation bar
And the user clicks on the city update link
When the user clicks on the add new identifier button in the basic info city page
And the user clicks on the city Identifier type drop-down
Then the user should see the city identifier types from lookup THIRD_PARTY_IDENTIFIER_GEO
When the user clicks on the city Identifier status drop-down
Then the user should see the city identifier status from lookup STATUS

Examples:
|country|area|city|
|Chad|No Area|Doba|


Scenario:User can edit city identifiers- Verify if User can add New City identifiers-Verify that all fields- "Type","Value" and "Status" are updated successfully
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
And the user clicks on the city basic info link in the navigation bar
And the user clicks on the city update link
When the user gets the document with get document id for city with the <city> from the database
When the user deletes the existing identifier rows
When the user clicks on the add new identifier button in the basic info city page
When the user enters identifier type as <identifierType> in the basic info city page
When the user enters identifier value as <identifierValue> in the basic info city page
When the user enters identifier status as <identifierStatus> in the basic info city page
When the user clicks on the add new identifier button in the basic info city page
When the user enters identifier type as <identifierType2> in the basic info city page
When the user enters identifier value as <identifierValue2> in the basic info city page
When the user enters identifier status as <identifierStatus2> in the basic info city page
And the user clicks on the save button
Then the user should see the save confirmation modal
When the user clicks on the confirm button
Then the user should see the successful update message at top of the page
Then the user should see the identifier <value> as in zeus document $identifierType $identifierValue $identifierStatus and $identifierType2 $identifierValue2 $identifierStatus2
Then the user reverts the changes to the document

Examples:
|country|area|city|identifierType|identifierValue|identifierStatus|identifierType2|identifierValue2|identifierStatus2|
|USA|New York|Brooklyn|Numeric ISO Code|H4Testing|Active|FIPS Place Code|H4Testing|Pending|
|USA|New York|Brooklyn|FIPS Place Code|H4Testing|Pending|Numeric ISO Code|H4Testing|Inactive|
|USA|New York|Brooklyn|FIPS Place Code|H4Testing|Pending|Numeric ISO Code|H4Testing|Active|


Scenario: Verifying row can be deleted by click on the yes button in delete confirmation section.
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
And the user clicks on the city basic info link in the navigation bar
And the user clicks on the city update link
When the user deletes the existing identifier rows
When the user clicks on the add new identifier button in the basic info city page
When the user clicks on the delete identifier row button in the basic info city page
Then the user should see delete row confirmation modal in the city page
When the user clicks on the Yes button to cancel the deletion of row
Then the user should not see the newly added identifier row in the basic info city page
When the user clicks on the save button
Then the user should see the save confirmation modal
When the user clicks on the confirm button in city page

Examples:
|country|area|city|
|Tajikistan|Leninabadskaya Oblast|Gafurov|

Scenario: User can edit city identifiers - Verify whether the text entered in the Identifier 'Value' field is not beyond 50 unicode characters.
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
When the user clicks on the city update link
When the user clicks on the add new identifier button in the basic info city page
When the user clicks on the save button
Then the user should see the save confirmation modal
When the user clicks on the confirm button in city page
Then the user should see the successful update message at top of the page
When the user clicks on the city update link
When the user clicks on the add new identifier button in the basic info city page
When the user enters identifier type as <identifierType> in the basic info city page
When the user enters an incorrect identifier value as <identifierValueIncorrect> in the basic info city page
Then the user should see maximum length of identifier value is limited to 50
When the user enters identifier status as <identifierStatus> in the basic info city page
When the user clicks on the save button
When the user clicks on the confirm button in city page
Then the user should see the successful update message at top of the page


Examples:
|country|area|city|identifierType|identifierValueIncorrect|identifierStatus|
|Albania|Fier|Patos|Numeric ISO Code|aksjuilrw1aksjuilrw1aksjuilrw1aksjuilrw1aksju%)~12y1|Active|

Scenario: User can edit city identifiers - Verify that an error message 'Required' is displayed when user left identifier Type blank and enters value in identifier 'Value' and 'Status'
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
And the user clicks on the city basic info link in the navigation bar
And the user clicks on the city update link
When the user gets the document with get document id for city with the <city> from the database
When the user deletes the existing identifier rows
When the user clicks on the add new identifier button in the basic info city page
When the user enters identifier type as <identifierType> in the basic info city page
When the user enters identifier value as <identifierValue> in the basic info city page
When the user enters identifier status as <identifierStatus> in the basic info city page
When the user clicks on the save button
Then the user should see the error message for the required identifier type field in the city basic info page

Examples:
|country|area|city|identifierType|identifierValue|identifierStatus|
|USA|New York|Brooklyn||H4Testing|Active|

Scenario: User can edit city identifiers - Verify that an error message 'Enter up to 50 valid characters.' is displayed when user left identifier value blank and enters value in identifier 'Type' and 'Status'
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
And the user clicks on the city basic info link in the navigation bar
And the user clicks on the city update link
When the user gets the document with get document id for city with the <city> from the database
When the user deletes the existing identifier rows
When the user clicks on the add new identifier button in the basic info city page
When the user enters identifier type as <identifierType> in the basic info city page
When the user enters identifier value as <identifierValue> in the basic info city page
When the user enters identifier status as <identifierStatus> in the basic info city page
When the user clicks on the save button
Then the user should see the error message for the required identifier value field in the city basic info page

Examples:
|country|area|city|identifierType|identifierValue|identifierStatus|
|USA|New York|Brooklyn|Numeric ISO Code||Active|

Scenario: User can edit city identifiers - Verify that an error message 'Required' is displayed when user left identifier status blank and enters value in identifier 'Type' and 'Value'
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
And the user clicks on the city basic info link in the navigation bar
And the user clicks on the city update link
When the user gets the document with get document id for city with the <city> from the database
When the user deletes the existing identifier rows
When the user clicks on the add new identifier button in the basic info city page
When the user enters identifier type as <identifierType> in the basic info city page
When the user enters identifier value as <identifierValue> in the basic info city page
When the user enters identifier status as <identifierStatus> in the basic info city page
When the user clicks on the save button
Then the user should see the error message for the required identifier status field in the city basic info page

Examples:
|country|area|city|identifierType|identifierValue|identifierStatus|
|USA|New York|Brooklyn|Numeric ISO Code|H4Testing||


Scenario: User can edit city identifiers- Verify if User can delete identifiers( "Type","Value" and "Status") by clicking on 'Yes' , then after saving it should be removed.

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
And the user clicks on the city basic info link in the navigation bar
And the user clicks on the city update link
When the user clicks on the add new identifier button in the basic info city page
When the user clicks on the delete identifier row button in the basic info city page
Then the user should see delete row confirmation modal in the city page
When the user clicks on the Yes button to cancel the deletion of row
Then the user should not see the newly added identifier row in the basic info city page

Examples:
|country|area|city|
|Chad|No Area|Doba|

Scenario: User can edit city identifiers- Verify if User can delete identifiers( "Type","Value" and "Status") by clicking on 'cancel', then after saving the identifier should not get deleted.
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
And the user clicks on the city basic info link in the navigation bar
And the user clicks on the city update link
When the user clicks on the add new identifier button in the basic info city page
When the user clicks on the delete identifier row button in the basic info city page
Then the user should see delete row confirmation modal in the city page
When the user clicks on the No button to cancel the deletion of row
Then the user should see the newly added identifier row in the basic info city page

Examples:
|country|area|city|
|Chad|No Area|Doba|



Scenario: User is updating City's 'Basic Info' by entering a value for 'Population' and verifies the confirmation dialog is having summary Basic Info
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
When the user clicks on the choose an area option
When the user enters the area <area> in the type-ahead box
When the user clicks on the choose a city option
When the user enters the city <city> in the type-ahead box
And the user clicks on the city basic info link in the navigation bar
And the user clicks on the city update link
When the user gets the document with get document id for city with the <city> from the database
When the user enters the <value> in the population field
When the user clicks on the save button in city page
Then the user should see the below summary changes in confirmation modal
|Summary|
|Basic Info|

When the user clicks on the confirm button
Then the user should see the successful update message at top of the page
Then the user should see the population <value> as in zeus document
Then the user reverts the changes to the document

Examples:
|country|area|city|value|
|USA|Georgia|Adrian|12345|
|USA|Georgia|Adrian|24513450000000000000000000000000000000000000000000|

Scenario: User is updating a City's Basic Info and has entered a same value for 'Population', verifies the confirmation dialog is not having summary info and Zeus Doc having same value
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
When the user clicks on the choose an area option
When the user enters the area <area> in the type-ahead box
When the user clicks on the choose a city option
When the user enters the city <city> in the type-ahead box
And the user clicks on the city basic info link in the navigation bar
And the user clicks on the city update link
When the user gets the document with get document id for city with the <city> from the database
When the user enters the <value> in the population field
When the user clicks on the save button in city page
And the user clicks on the confirm button
When the user clicks on the city update link
When the user enters the <value> in the population field
When the user clicks on the save button in city page
Then the user should not see the <ConfirmationSummary> changes in confirmation modal
When the user clicks on the confirm button
Then the user should see the population <value> as in zeus document
Then the user reverts the changes to the document

Examples:
|country|area|city|value|ConfirmationSummary|
|USA|Georgia|Adrian|123457|Summary|

Scenario: 	User is updating a City's Basic Info and has entered a string value value for 'Population', then error message should be displayed.(Negative Validation)
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
When the user clicks on the choose an area option
When the user enters the area <area> in the type-ahead box
When the user clicks on the choose a city option
When the user enters the city <city> in the type-ahead box
And the user clicks on the city basic info link in the navigation bar
And the user clicks on the city update link
And the user enters the <value> in the population field
When the user clicks on the save button in city page
Then the user should be able to view the error message 'Enter up to 50 valid numbers'
Then the user should see maximum length of population is limited to 50

Examples:
|country|area|city|value|
|USA|Georgia|Adrian|stringvalue|

Scenario: 
User is updating a City's Basic Info - 
User verifies the default value is from trusted and Then user has entered an 'End Date' that is different from the current value. 

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
And the user clicks on the city basic info link in the navigation bar
Then the user should see city end date value same as in trusted document
When the user clicks on the city update link
When the user gets the document with get document id for city with the <city> from the database
When the user enters the day <beganDay> in the text box for Began Date
When the user enters the month <beganMonth> in the drop down box for Began Date
When the user enters the year <beganYear> in the text box for Began Date
When the user enters the day <endDay> in the text box for End Date
When the user enters the month <endMonth> in the drop down box for End Date
When the user enters the year <endYear> in the text box for End Date
When the user clicks on the save button
When the user clicks on the confirm button
Then the user should see the successful update message at top of the page
When the user clicks on the city update link
When the user enters $endDay2 $endMonth2 $endYear2 for End Date values
When the user clicks on the save button
Then the user should see the save confirmation modal
Then the user should see the below summary changes in confirmation modal
|Summary|
|Basic Info|
When the user clicks on the confirm button
Then the user should see the successful update message at top of the page
Then the user should see the $endDay2 $endMonth2 $endYear2 value as in zeus document
Then the user reverts the changes to the document

Examples:
|country|area|city|beganDay|beganMonth|beganYear|endDay|endMonth|endYear|endDay2|endMonth2|endYear2|
|Afghanistan|Badakshan|Panj Shair|1|Jun|2016|5|Jun|2016|10|Jun|2016|

Scenario: User is updating a City's Basic Info - The user has entered all blank values for 'End Date'
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
And the user clicks on the city basic info link in the navigation bar
Then the user should see city end date value same as in trusted document
When the user clicks on the city update link
When the user gets the document with get document id for city with the <city> from the database
Then the user verifies whether all the months in the drop down option are present in chronological order
When the user enters the day <beganDay> in the text box for Began Date
When the user enters the month <beganMonth> in the drop down box for Began Date
When the user enters the year <beganYear> in the text box for Began Date
When the user enters the day <endDay> in the text box for End Date
When the user enters the month <endMonth> in the drop down box for End Date
When the user enters the year <endYear> in the text box for End Date
When the user clicks on the save button
Then the user should see the save confirmation modal
When the user clicks on the confirm button
Then the user should see the successful update message at top of the page
Then the user should see the <endDate> value as in zeus document
Then the user reverts the changes to the document

Examples:
|country|area|city|beganDay|beganMonth|beganYear|endDay|endMonth|endYear|endDate|
|Afghanistan|Badakshan|Panj Shair|1|Jun|2016|||||


Scenario: User is entering invalid inputs - 
a)The user does not enter the month.
b)The user does not enter the year.
c)The user does not enter the day and year.
d)The user does not enter the month and year.
e)The user enters the day with alphabets (not in Gregorian calendar format)
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
And the user clicks on the city basic info link in the navigation bar
When the user clicks on the city update link
When the user enters the day <beganDay> in the text box for Began Date
When the user enters the month <beganMonth> in the drop down box for Began Date
When the user enters the year <beganYear> in the text box for Began Date
When the user enters the day <endDay> in the text box for End Date
When the user enters the month <endMonth> in the drop down box for End Date
When the user enters the year <endYear> in the text box for End Date
When the user clicks on the save button
Then the user verifies whether error message Enter a year, month/year or day/month/year. is displayed for End Date

Examples:
|country|area|city|beganDay|beganMonth|beganYear|endDay|endMonth|endYear|
|Afghanistan|Badakshan|Panj Shair|1|Jun|2016|6||2016|
|Afghanistan|Badakshan|Panj Shair|1|Jun|2016|6|Jun||
|Afghanistan|Badakshan|Panj Shair|1|Jun|2016||Jun||
|Afghanistan|Badakshan|Panj Shair|1|Jun|2016|6|||

Scenario: User is entering invalid inputs - The user enters the day with alphabets (not in Gregorian calendar format)
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
And the user clicks on the city basic info link in the navigation bar
When the user clicks on the city update link
When the user enters the day <beganDay> in the text box for Began Date
When the user enters the month <beganMonth> in the drop down box for Began Date
When the user enters the year <beganYear> in the text box for Began Date
When the user enters the day <endDay> in the text box for End Date
When the user enters the month <endMonth> in the drop down box for End Date
When the user enters the year <endYear> in the text box for End Date
When the user clicks on the save button
Then the user verifies whether error message Invalid Date is displayed for End Date

Examples:
|country|area|city|beganDay|beganMonth|beganYear|endDay|endMonth|endYear|
|Afghanistan|Badakshan|Panj Shair|1|Jun|2016|6Rdseth765|Jun|2016|

Scenario: User gets an error message when entering a date that is later than today 
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
And the user clicks on the city basic info link in the navigation bar
When the user clicks on the city update link
When the user enters the day <beganDay> in the text box for Began Date
When the user enters the month <beganMonth> in the drop down box for Began Date
When the user enters the year <beganYear> in the text box for Began Date
When the user enters the future date in the text box for End Date
When the user clicks on the save button
Then the user verifies whether error message Must be no later than today. is displayed for End Date

Examples:
|country|area|city|beganDay|beganMonth|beganYear|
|Afghanistan|Badakshan|Panj Shair|1|Jun|2016|

Scenario: User is updating a City's Basic Info and has entered an 'End Date' that is no different to the current value
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
And the user clicks on the city basic info link in the navigation bar
When the user clicks on the city update link
When the user gets the document with get document id for city with the <city> from the database
When the user enters the day <beganDay> in the text box for Began Date
When the user enters the month <beganMonth> in the drop down box for Began Date
When the user enters the year <beganYear> in the text box for Began Date
When the user enters the day <endDay> in the text box for End Date
When the user enters the month <endMonth> in the drop down box for End Date
When the user enters the year <endYear> in the text box for End Date
When the user clicks on the save button
When the user clicks on the confirm button
Then the user should see the successful update message at top of the page
When the user clicks on the city update link
When the user enters the day <endDay> in the text box for End Date
When the user enters the month <endMonth> in the drop down box for End Date
When the user enters the year <endYear> in the text box for End Date
When the user clicks on the save button
Then the user should see the save confirmation modal
Then the user should see no summary changes in the city save confirmation modal
When the user clicks on the confirm button
Then the user should see the successful update message at top of the page
Then the user reverts the changes to the document

Examples:
|country|area|city|beganDay|beganMonth|beganYear|endDay|endMonth|endYear|Summary|
|Afghanistan|Badakshan|Panj Shair|1|Jun|2016|5|Jun|2016|Basic Info| 

Scenario: User is updating a City's Basic Info and has entered an 'End Date' that is before the 'Began Date'
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
And the user clicks on the city basic info link in the navigation bar
When the user clicks on the city update link
When the user enters the day <beganDay> in the text box for Began Date
When the user enters the month <beganMonth> in the drop down box for Began Date
When the user enters the year <beganYear> in the text box for Began Date
When the user enters the day <endDay> in the text box for End Date
When the user enters the month <endMonth> in the drop down box for End Date
When the user enters the year <endYear> in the text box for End Date
When the user clicks on the save button
Then the user verifies whether error message Must be after Began date. is displayed for End Date

Examples:
|country|area|city|beganDay|beganMonth|beganYear|endDay|endMonth|endYear|Summary|
|Afghanistan|Badakshan|Badakhshan|1|Jun|2016|1|Jun|2015|Basic Info|

Scenario: User enters End Date values when the Began Date values are empty
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
And the user clicks on the city basic info link in the navigation bar
When the user clicks on the city update link
When the user gets the document with get document id for city with the <city> from the database
And the user clears the day, month and year values for Began Date
When the user enters the day <endDay> in the text box for End Date
When the user enters the month <endMonth> in the drop down box for End Date
When the user enters the year <endYear> in the text box for End Date
When the user clicks on the save button
When the user clicks on the confirm button
Then the user should see the successful update message at top of the page
Then the user reverts the changes to the document

Examples:
|country|area|city|endDay|endMonth|endYear|
|USA|Alabama|Alexander City|6|Jun|2010|

Scenario: User is updating  City's Basic Info  page and  entered  value for 'Use in Address' that is different from the current value
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
And the user clicks on the city basic info link in the navigation bar
When the user clicks on the city update link
When the user gets the document with get document id for city with the <city> from the database
When the user clicks on True option for Use in Address
When the user clicks on the save button
Then the user should see the save confirmation modal
When the user clicks on the confirm button
Then the user should see the successful update message at top of the page
When the user clicks on the city update link
When the user clicks on False option for Use in Address
When the user clicks on the save button
Then the user should see the save confirmation modal
Then the user should see the below summary changes in confirmation modal
|Summary|
|Basic Info|
When the user clicks on the confirm button
Then the user should see the successful update message at top of the page
Then the user should see the address flag value same as in zeus document
Then the user reverts the changes to the document

Examples:
|country|area|city|
|Tajikistan|Leninabadskaya Oblast|Gafurov|

Scenario: User is updating  City's Basic Info  page and  entered  value for 'Use in Address' that is no different from the current value
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
And the user clicks on the city basic info link in the navigation bar
When the user clicks on the city update link
When the user gets the document with get document id for city with the <city> from the database
When the user clicks on False option for Use in Address
When the user clicks on the save button
Then the user should see the save confirmation modal
When the user clicks on the confirm button
Then the user should see the successful update message at top of the page
When the user clicks on the city update link
When the user clicks on False option for Use in Address
When the user clicks on the save button
Then the user should see the save confirmation modal
Then the user should see no summary changes in the city save confirmation modal
When the user clicks on the confirm button
Then the user should see the successful update message at top of the page
Then the user reverts the changes to the document

Examples:
|country|area|city|Summary|
|Tajikistan|Leninabadskaya Oblast|Gafurov|Basic Info|

Scenario: User can edit city Began Date - Verify if User can see Current value of the Month,Day & Year is retrieved from trusted document.

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
And the user clicks on the city basic info link in the navigation bar
And the user clicks on the city update link
Then the user should see the began date value in city page is same as in trusted document

Examples:
|country|area|city|
|Tajikistan|Leninabadskaya Oblast|Gafurov|

Scenario: User can edit city Began Date - 
a)Verify if user can see all the months in month dropdown (Began Date) are in MMM format
b)Verify if user can see that all the months are sorted as per chronological order
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
And the user clicks on the city basic info link in the navigation bar
And the user clicks on the city update link
Then the user verifies whether all the months in the drop down option are in MMM format & are sorted in the chronological order

Examples:
|country|area|city|
|Tajikistan|Leninabadskaya Oblast|Gafurov|

Scenario: User can edit city Began Date - Verify if User can see an error message in City basic info edit page when began date is entered in an invalid format

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
And the user clicks on the city basic info link in the navigation bar
And the user clicks on the city update link
When the user enters began date day <day> in the edit basic info city page
When the user enters began date month <month> in the edit basic info city page
When the user enters began date year <year> in the edit basic info city page
When the user clicks on the save button
Then the user should see the error Enter a year, month/year or day/month/year. for began date

Examples:
|country|area|city|day|month|year|
|Tajikistan|Leninabadskaya Oblast|Gafurov|28||2016|
|Tajikistan|Leninabadskaya Oblast|Gafurov|28|||
|Tajikistan|Leninabadskaya Oblast|Gafurov|28|Mar||

Scenario: User can edit city Began Date - Verify if User can see an error message in City basic info edit page when future began date is entered

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
And the user clicks on the city basic info link in the navigation bar
And the user clicks on the city update link
When the user enters began date day <day> in the edit basic info city page
When the user enters began date month <month> in the edit basic info city page
When the user enters began date year <year> in the edit basic info city page
When the user clicks on the save button
Then the user should see the error Must be no later than today. for began date

Examples:
|country|area|city|day|month|year|
|Tajikistan|Leninabadskaya Oblast|Gafurov|28|Sep|2019|

Scenario: User can edit city Began Date - Verify if User can see an error message in City basic info edit page when invalid Year & inavlid Day is entered

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
And the user clicks on the city basic info link in the navigation bar
And the user clicks on the city update link
When the user enters began date day <day> in the edit basic info city page
When the user enters began date month <month> in the edit basic info city page
When the user enters began date year <year> in the edit basic info city page
When the user clicks on the save button
Then the user should see the error Invalid Date for began date

Examples:
|country|area|city|day|month|year|
|Tajikistan|Leninabadskaya Oblast|Gafurov|45|Sep|4568|


Scenario: User can edit city Began Date - Verify if
a)User can see Success message in City Page
b)User can see entered values updated in City Page
c)User can see entered values updated in Zeus document
d)User can see Basic info changes are updated in Confirmation Modal

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
And the user clicks on the city basic info link in the navigation bar
And the user clicks on the city update link
When the user gets the document with get document id for city with the <city> from the database
When the user enters began date day <day> in the edit basic info city page
When the user enters began date month <month> in the edit basic info city page
When the user enters began date year <year> in the edit basic info city page
When the user clicks on the save button
Then the user should see the save confirmation modal
And the user should see the below summary changes in confirmation modal
|Summary|
|Basic Info|
When the user clicks on the confirm button
Then the user should see the successful update message at top of the page
Then the user should see the entered <day> <month> <year> in city page
Then the user should see the city began date <day><month><year> value in zeus document
Then the user reverts the changes to the document


Examples:
|country|area|city|day|month|year|
|Tajikistan|Leninabadskaya Oblast|Gafurov|||2016|
|Tajikistan|Leninabadskaya Oblast|Gafurov||Oct|2015|
|Tajikistan|Leninabadskaya Oblast|Gafurov|01|Sep|2015|

Scenario: User can edit city Began Date - Verify if User can see a message in City basic info edit page when Day,Month & Year which is no different than current value entered

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
And the user clicks on the city basic info link in the navigation bar
And the user clicks on the city update link
When the user enters began date day <day> in the edit basic info city page
When the user enters began date month <month> in the edit basic info city page
When the user enters began date year <year> in the edit basic info city page
When the user clicks on the save button
When the user clicks on the confirm button
Then the user should see the successful update message at top of the page
When the user clicks on the city update link
When the user gets the document with get document id for city with the <city> from the database
When the user enters began date day <day> in the edit basic info city page
When the user enters began date month <month> in the edit basic info city page
When the user enters began date year <year> in the edit basic info city page
When the user clicks on the save button
Then the user should not see the <ConfirmationSummary> changes in confirmation modal
When the user clicks on the confirm button
Then the user should see the successful update message at top of the page
Then the user should see the entered <day> <month> <year> in city page
Then the user reverts the changes to the document

Examples:
|country|area|city|day|month|year|ConfirmationSummary|
|Tajikistan|Leninabadskaya Oblast|Gafurov|25|Sep|1902|Summary|

Scenario: User can edit city Began Date - Verify if User can see Began date getting saved in City Page & Zeus document  when Day,Month & Year are entered as blank values

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
And the user clicks on the city basic info link in the navigation bar
And the user clicks on the city update link
When the user gets the document with get document id for city with the <city> from the database
When the user enters began date day <day> in the edit basic info city page
When the user enters began date month <month> in the edit basic info city page
When the user enters began date year <year> in the edit basic info city page
When the user clicks on the save button
When the user clicks on the confirm button
Then the user should see the successful update message at top of the page
Then the user should see the entered <day> <month> <year> in city page
Then the user should see the city began date <day><month><year> value in zeus document
Then the user reverts the changes to the document

Examples:
|country|area|city|day|month|year|
|Tajikistan|Leninabadskaya Oblast|Gafurov||||

Scenario: User can edit city names - Verify city name types are same as from lookup PLACE_NAME_TYPE
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
And the user clicks on the city basic info link in the navigation bar
When the user clicks on the city update link
When the user clicks on the add new name button in the basic info city page
Then the user should see the city name types from lookup PLACE_NAME_TYPE

Examples:
|country|area|city|
|Belgium|Limburg|Bree|

Scenario: User edit and save the full name in the City Basic Info page
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
And the user clicks on the city basic info link in the navigation bar
When the user clicks on the city update link
Then the user should see city name value same as in trusted document
When the user gets the document with get document id for city with the <city> from the database
And the user should see the full name is not editable
And the user enters the <newNameValue> in the full name field
And the user clicks on the save button in city page
Then the user should see the below summary changes in confirmation modal
|Summary|
|Basic Info / Names|
When the user clicks on the confirm button
Then the user should see the successful update message at top of the page
Then the user should see the full name <newNameValue> as in zeus document
Then the user should be able to verify the <newNameValue> is updated in full name value field
Then the user reverts the changes to the document

Examples:
|country|area|city|newNameValue|
|Belgium|Limburg|Bree|Panj Shair|

Scenario: User adds new name type and value, checks the confirmation summary modal and saves the data to DB
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
And the user clicks on the city basic info link in the navigation bar
When the user clicks on the city update link
Then the user should see city name value same as in trusted document
When the user gets the document with get document id for city with the <city> from the database
And the user clicks on the add new name button in the basic info city page
And the user enters name type as <newNameType> in the basic info city page
And the user enters name value as <newNameValue> in the basic info city page
And the user clicks on the save button in city page
Then the user should see the below summary changes in confirmation modal
|Summary|
|Basic Info / Names|
When the user clicks on the confirm button
Then the user should see the successful update message at top of the page
Then the user should see the value updated in zeus document
Then the user should see the city name type and value updated in UI
Then the user reverts the changes to the document

Examples:
|country|area|city|newNameType|newNameValue|
|Belgium|Limburg|Bree|Display Name|Panj Shair|
|Belgium|Limburg|Bree|Alternative Name|Panj Shair|


Scenario: User can edit city names - Verify city name types in the dropdown are not getting repeated in the consecutive rows
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
And the user clicks on the city basic info link in the navigation bar
When the user clicks on the city update link
When the user clicks on the add new name button in the basic info city page
And the user enters name type as <newNameType> in the basic info city page
And the user clicks on the add new name button in the basic info city page
Then the user checks whether the newly added row does not contain <newNameType> name type

Examples:
|country|area|city|newNameType|
|Belgium|Limburg|Bree|Alternative Name|


Scenario: User can edit city names - Verify that newly added empty row is not getting saved to the system
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
And the user clicks on the city basic info link in the navigation bar
When the user clicks on the city update link
When the user clicks on the add new name button in the basic info city page
And the user clicks on the save button in city page
When the user clicks on the confirm button
Then the user should see the successful update message at top of the page
Then the user should be able to verify empty rows not added in zeus document

Examples:
|country|area|city|
|Belgium|Limburg|Bree|

Scenario: User can edit city names - Verify that an error message 'Required' is displayed when user left name type blank and enters value in name value
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
And the user clicks on the city basic info link in the navigation bar
When the user clicks on the city update link
When the user clicks on the add new name button in the basic info city page
And the user enters name value as <newNameValue> in the basic info city page
And the user clicks on the save button in city page
Then the user should see the error message for the required name type field in the city basic info page

Examples:
|country|area|city|newNameValue|
|Belgium|Limburg|Bree|Panj Shair|

Scenario: User can edit city names - Verify that an error message 'Enter up to 75 valid characters.' is displayed when user left name value blank and enters value in name type
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
And the user clicks on the city basic info link in the navigation bar
When the user clicks on the city update link
When the user clicks on the add new name button in the basic info city page
And the user enters name type as <newNameType> in the basic info city page
And the user clicks on the save button in city page
Then the user should see the error message for the required name value field in the city basic info page

Examples:
|country|area|city|newNameType|
|Belgium|Limburg|Bree|Display Name|

Scenario: User can edit city names - Verify that the new value updated on existing name is saved to DB
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
And the user clicks on the city basic info link in the navigation bar
When the user clicks on the city update link
And the user gets the document with get document id for city with the <city> from the database
When the user clicks on the add new name button in the basic info city page
And the user enters name type as <newNameType> in the basic info city page
And the user enters name value as <newNameValue> in the basic info city page
And the user clicks on the save button in city page
When the user clicks on the confirm button
Then the user should see the successful update message at top of the page
When the user clicks on the city update link
And the user enters name value as <newNameValue2> in the basic info city page
And the user clicks on the save button in city page
Then the user should see the below summary changes in confirmation modal
|Summary|
|Basic Info / Names|
When the user clicks on the confirm button
Then the user should see the successful update message at top of the page
Then the user should see the value newly updated in zeus document
Then the user reverts the changes to the document

Examples:
|country|area|city|newNameType|newNameValue|newNameValue2|
|Belgium|Limburg|Bree|Display Name|Panj Shair|Badakhshan|

Scenario: User can edit city name- Verify if User can delete city name row and clicks no on confirmation modal, on save the name should not get deleted.
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
And the user clicks on the city basic info link in the navigation bar
When the user clicks on the city update link
And the user gets the document with get document id for city with the <city> from the database
When the user clicks on the add new name button in the basic info city page
And the user enters name type as <newNameType> in the basic info city page
And the user enters name value as <newNameValue> in the basic info city page
And the user clicks on the save button in city page
Then the user should see the below summary changes in confirmation modal
|Summary|
|Basic Info / Names|
When the user clicks on the confirm button
Then the user should see the successful update message at top of the page
When the user clicks on the city update link
When the user clicks on the delete name row button in the basic info city page
Then the user should see the delete row confirmation modal in the city page
When the user clicks on the No button to cancel the deletion of row
And the user clicks on the save button in city page
When the user clicks on the confirm button
Then the user should see the successful update message at top of the page
Then the user should see the value updated in zeus document
Then the user reverts the changes to the document

Examples:
|country|area|city|newNameType|newNameValue|
|Belgium|Limburg|Bree|Alternative Name|Panj Shair|

Scenario: User can edit city name- Verify if User can delete city name row and clicks yes on confirmation modal, on save the name should get deleted
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
And the user clicks on the city basic info link in the navigation bar
When the user clicks on the city update link
And the user gets the document with get document id for city with the <city> from the database
When the user clicks on the add new name button in the basic info city page
And the user enters name type as <newNameType> in the basic info city page
And the user enters name value as <newNameValue> in the basic info city page
And the user clicks on the save button in city page
Then the user should see the below summary changes in confirmation modal
|Summary|
|Basic Info / Names|
When the user clicks on the confirm button
Then the user should see the successful update message at top of the page
When the user clicks on the city update link
When the user clicks on the delete name row button in the basic info city page
Then the user should see the delete row confirmation modal in the city page
When the user clicks on the Yes button to cancel the deletion of row
And the user clicks on the save button in city page
When the user clicks on the confirm button
Then the user should see the successful update message at top of the page
Then the user should see the value not present in zeus document
Then the user reverts the changes to the document

Examples:
|country|area|city|newNameType|newNameValue|
|Belgium|Limburg|Bree|Alternative Name|Panj Shair|

Scenario: 	User is updating a City's Basic Info and checked whether name value has maxlength attribute set to 75
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
And the user clicks on the city basic info link in the navigation bar
When the user clicks on the city update link
And the user clicks on the add new name button in the basic info city page
Then the user should see the maxlength of name value field set to 75

Examples:
|country|area|city|
|Belgium|Limburg|Bree|

Scenario: User views the city basic page,selects the update button and verify the country, area, subarea list are in Alphabetical order
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
And the user clicks on the city basic info link in the navigation bar
When the user clicks on the city update link
When user changes the <country2> in the country drop downfield of city basic page
Then the user should see all the list of countries in city page are in Alphabetical order
Then user should see the list of Area options in city page are in Alphabetical order
Then user changes the area <area2> in the area dropdown field in city basic page
Then user should see the list of Sub area options in city page are in Alphabetical order

Examples:
|country|area|city|country2|area2|
|USA|California|Alamo|India|Tamil Nadu|


Scenario: User views the city basic page,changes the country and area 
1- verify the area showing default value as 'Choose an Area' 
2- verify the sub area showing default value as 'Choose a SubArea'
3- verfiy that the 'No Area' option is available at the top of the area and subarea dropdown
4- verify when user selects 'No Area' in area dropdown, then sub area should have only 'No Area' as an option

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
And the user clicks on the city update link
When user changes the <country2> in the country drop downfield of city basic page
Then the user verify the Area dropdown is populating with 'Choose an Area'as a option
Then user should see the list of Area options are refreshed pointing to selected <country2>
Then the user verify the SubArea dropdown is populating with 'Choose a SubArea' as a option
Then user changes the area <area2> in the area dropdown field in city basic page
Then user should see the list of Sub area options are refreshed pointing to selected <area2>
And the user should verfiy that the 'No Area' option is available at the top of the area dropdown option
Then the user should verfiy that the 'No Area' option is available at the top of the Subarea dropdown option
Then user selects No Area in area dropdown field in city basic page
When the user clicks on the choose a subarea option of city basic page
Then the user should verfiy that the 'No Area' option is only option exist in Subarea dropdown option

Examples:
|country|area|city|country2|area2|
|USA|California|Alamo|India|Tamil Nadu|


Scenario: User updates the city basic page info by changing the country,area,subarea options
1- Verify whether the selected sub area is not reselectable for another sub area.


Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
And the user clicks on the city basic info link in the navigation bar
When the user clicks on the city update link
When the user gets the document with get document id for city with the <city> from the database
When user changes the <country2> in the country drop downfield of city basic page
Then user changes the area <area2> in the area dropdown field in city basic page
When the user clicks on the choose a subarea option of city basic page
When the user clears subarea options in city basic page
Then user selects Subarea <Subarea1> in the subarea multiselect dropdown
Then the user checks whether this subarea1 <Subarea> are not reselectable
When the user clicks on the save button in city page
When the user clicks on the confirm button in city page
Then the user should see the successful update message at top of the page
Then verify zeus document whether the city is updated with newly added SubArea <Subarea1>
When the user clicks on the city update link
Then verify UI whether city is updated with newly added SubArea <Subarea1>
Then the user reverts the changes to the document


Examples:
|country|area|city|country2|area2|Subarea1|
|USA|California|Alamo|USA|Arizona|Gila|


Scenario: User is updating a City's Basic Info and has set values for each of 'Country', 'Area' and 'Sub Area
1 - Verify city is mapped under newly added country2 and area2
2 - Verify the Zesu DB whether the city is mapped under newly added country2 and area2

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
And the user clicks on the city basic info link in the navigation bar
When the user clicks on the city update link
When the user gets the document with get document id for city with the <city> from the database
When user changes the <country2> in the country drop downfield of city basic page
Then user changes the area <area2> in the area dropdown field in city basic page
When the user clicks on the choose a subarea option of city basic page
Then user selects Subarea <Subarea1> in the subarea multiselect dropdown
When the user clicks on the save button in city page
When the user clicks on the confirm button in city page
Then the user should see the successful update message at top of the page
Then the user checks whether the header dropdown updates with <country2>, <area2>, <city>
Then the user checks whether the Address bar url is updated  with <country2>, <area2>
Then verify zeus document whether <city> is mapped to newly added <country2> and <area2>
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
Then user verify the city dropdown does not have city <city> value mapped to old country and area
Then the user reverts the changes to the document


Examples:
|country|area|city|country2|area2|Subarea1|
|USA|California|Alamo|USA|Arizona|Gila|

Scenario: User is updating a City's Basic Info and has set values for each of 'Country', 'Area' and 'Sub Area as 'No Area'
1 - Verify whether the city is not updated to newly added sub area(null)
2 - Verify whether the zeus DB is having Sub area value as null
        
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
And the user clicks on the city basic info link in the navigation bar
When the user clicks on the city update link
When the user gets the document with get document id for city with the <city> from the database
When user changes the <country2> in the country drop downfield of city basic page
Then user changes the area <area2> in the area dropdown field in city basic page
When the user clicks on the choose a subarea option of city basic page
Then user selects Subarea <Subarea1> in the subarea multiselect dropdown
When the user clicks on the save button in city page
When the user clicks on the confirm button in city page
Then the user should see the successful update message at top of the page
Then user verify the city is not updated with newly added subarea(null)
Then verify zeus document whether the city is not updated with newly SubArea
Then the user reverts the changes to the document

Examples:
|country|area|city|country2|area2|Subarea1|
|USA|California|Alamo|USA|Arizona|No Area|

Scenario: User is updating a City's Basic Info and has set values for each of 'Country', 'Area' and 'Sub Area as 'No Area'
1 - Verify whether the city is not updated to newly added sub area(null)
2 - Verify whether the zeus DB is having Sub area value as null
  
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
And the user clicks on the city basic info link in the navigation bar
When the user clicks on the city update link
When the user gets the document with get document id for city with the <city> from the database
When user changes the <country2> in the country drop downfield of city basic page
Then user changes the area <area2> in the area dropdown field in city basic page
When the user clicks on the choose a subarea option of city basic page
Then user selects Subarea <Subarea1> in the subarea multiselect dropdown
When the user clicks on the save button in city page
When the user clicks on the confirm button in city page
Then the user should see the successful update message at top of the page
Then user verify the city is not updated with newly added subarea(null)
Then user verify the city is not updated with newly added area(null)
Then verify zeus document whether the city is not updated with newly added area and subArea
Then the user reverts the changes to the document

Examples:
|country|area|city|country2|area2|Subarea1|
|USA|California|Alamo|USA|No Area|No Area|


Scenario: User is updating a City's Basic Info and has set values for each of 'Country', 'Area' and 'Sub Area
1 - User adds two sub areas and verify Zeus DB is updating with two sub area 

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
And the user clicks on the city basic info link in the navigation bar
When the user clicks on the city update link
When the user gets the document with get document id for city with the <city> from the database
When user changes the <country2> in the country drop downfield of city basic page
Then user changes the area <area2> in the area dropdown field in city basic page
When the user clicks on the choose a subarea option of city basic page
Then user selects Subarea <Subarea1> in the subarea multiselect dropdown
Then user selects Subarea <Subarea2> in the subarea multiselect dropdown
When the user clicks on the save button in city page
When the user clicks on the confirm button in city page
Then the user should see the successful update message at top of the page
Then verify zeus document whether <city> is mapped to <Subarea1> and <Subarea2>
Then the user reverts the changes to the document


Examples:
|country|area|city|country2|area2|Subarea1|Subarea2|
|USA|California|Alamo|USA|Arizona|Gila|Graham|
