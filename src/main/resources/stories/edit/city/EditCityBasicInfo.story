Meta: @EditCityBasicInfo @Edit @City @AllStories

Narrative:
In order to view and edit the city page
As a user
I want to cover the requirements mentioned in
JIRA ID - ZEUS-962 - User can view city status and can edit the city status
JIRA ID - ZEUS-969 -User can edit City's Add info
JIRA ID - ZEUS-972 -User can edit City's Identifiers

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
|USA|Georgia|Adel|

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
|USA|Georgia|Adel|

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
When the user gets the document with get document id for city with the <city> from the database
When the user starts typing the name of a status as p in the City Status drop-down
Then the user should see the selected status in the City Status drop-down as Pending
When the user clicks on the save button
Then the user should see the save confirmation modal
And the user should see the below summary changes in confirmation modal
|Summary|
|Basic Info|
When the user clicks on the return button
Then the user should return to edit city page mode
Then the user reverts the changes to the document

Examples:
|country|area|city|
|USA|Georgia|Adel|


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
|USA|Georgia|Adel|active|
|USA|Georgia|Adel|pending|
|USA|Georgia|Adel|inactive|


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
|USA|Georgia|Adel|active|Summary|


Scenario: The user can edit the value in the Add Info field and save it and see it on the front end(Front End Validation)
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
And the user gets the value already present in the text box
And the user enters the <addInfoText> in the add info text area
When the user clicks on the save button in city page
Then the user should see the below summary changes in confirmation modal
|Summary|
|Basic Info|
When the user clicks on the confirm button
Then the user should see the successful update message at top of the page
Then the user should be able to verify the values are entered in the add info field
Then the user verifies whether the new value <addInfoText> is different from previous value
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
|USA|Alabama|Alexander City|


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
|USA|New York|Brooklyn|Numeric ISO Code|H4Testing|active|FIPS Place Code|H4Testing|pending|
|USA|New York|Brooklyn|FIPS Place Code|H4Testing|pending|Numeric ISO Code|H4Testing|inactive|
|USA|New York|Brooklyn|FIPS Place Code|H4Testing|pending|Numeric ISO Code|H4Testing|active|


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



Scenario: User can edit city identifiers - Verify that an error message is displayed for required and invalid fields for newely added identifier - "Type","Value" and "Status", for new row on Saving.
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
Then the user should see the error message for the required identifier value field in the city basic info page
Then the user should see the error message for the required identifier type field in the city basic info page
Then the user should see the error message for the required identifier status field in the city basic info page
And the user should see the error message at top of page the highlighted fields must be addressed before this update can be saved
When the user enters an incorrect identifier value as <identifierValueIncorrect> in the basic info city page
When the user clicks on the save button
Then the user should see the Enter up to 50 valid characters error message for the identifier value field in the city basic info page


Examples:
|country|area|city|identifierValueIncorrect|
|Albania|Fier|Patos|aksjuilrw1aksjuilrw1aksjuilrw1aksjuilrw1aksju%)~12y1|


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
Then the user reverts the changes to the document

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
When the user clicks on the city update link
When the user gets the document with get document id for city with the <city> from the database
When the user enters the day <beganDay> in the text box for Began Date
When the user enters the month <beganMonth> in the drop down box for Began Date
When the user enters the year <beganYear> in the text box for Began Date
When the user enters the day <endDay> in the text box for End Date
When the user enters the month <endMonth> in the drop down box for End Date
When the user enters the year <endYear> in the text box for End Date
Then the user verifies whether all the months in the drop down option are present in chronological order
When the user clicks on the save button
Then the user should see the save confirmation modal
When the user clicks on the confirm button
Then the user should see the successful update message at top of the page
Then the user should see city end date value same as in trusted document
Then the user should see the <endDate> value as in zeus document
Then the user reverts the changes to the document

Examples:
|country|area|city|beganDay|beganMonth|beganYear|endDay|endMonth|endYear|endDate|
|Afghanistan|Badakshan|Panj Shair|1|June|2016|||||

Scenario: User is updating a City's Basic Info - The user has entered an 'End Date' that is different from the current value
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
And the user verifies that the <endDay>, <endMonth> and <endYear> is in Gregorian Calendar format
And the user verifies that the <endDay>, <endMonth> and <endYear> is not later than today
When the user clicks on the save button
When the user clicks on the confirm button
Then the user should see the successful update message at top of the page
When the user clicks on the city update link
When the user enters the day <endDay2> in the text box for End Date
When the user enters the month <endMonth2> in the drop down box for End Date
When the user enters the year <endYear2> in the text box for End Date
When the user clicks on the save button
Then the user should see the save confirmation modal
Then the user should see the below summary changes in confirmation modal
|Summary|
|Basic Info|
When the user clicks on the confirm button
Then the user should see the successful update message at top of the page
Then the user should see city end date value same as in trusted document
Then the user should see the <endDate> value as in zeus document
Then the user reverts the changes to the document

Examples:
|country|area|city|beganDay|beganMonth|beganYear|endDay|endMonth|endYear|endDay2|endMonth2|endYear2|endDate|
|Afghanistan|Badakshan|Panj Shair|1|June|2016|5|June|2016|10|June|2016|10 Jun 2016|

Scenario: User is entering invalid inputs - 
a)The user does not enter the month.
b)The user does not enter the year.
c)The user does not enter the day and year.
d)The user does not enter the month and year.
e)The user enters the day with alphabets 
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
Then the user verifies whether error message <errMsg> is displayed

Examples:
|country|area|city|beganDay|beganMonth|beganYear|endDay|endMonth|endYear|errMsg|
|Afghanistan|Badakshan|Panj Shair|1|June|2016|6||2016|Enter a year, month/year or day/month/year.|
|Afghanistan|Badakshan|Panj Shair|1|June|2016|6|June||Enter a year, month/year or day/month/year.|
|Afghanistan|Badakshan|Panj Shair|1|June|2016||June||Enter a year, month/year or day/month/year.| 
|Afghanistan|Badakshan|Panj Shair|1|June|2016|6|||Enter a year, month/year or day/month/year.|
|Afghanistan|Badakshan|Panj Shair|1|June|2016|6Rdseth765|June|2016|Invalid Date|

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
When the user enters the day <endDay> in the text box for End Date
When the user enters the month <endMonth> in the drop down box for End Date
When the user enters the future year in the text box for End Date
When the user clicks on the save button
Then the user verifies whether error message <errMsg> is displayed

Examples:
|country|area|city|beganDay|beganMonth|beganYear|endDay|endMonth|errMsg|
|Afghanistan|Badakshan|Panj Shair|1|June|2016|6|June|Must be no later than today.|

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
When the user enters the day <beganDay> in the text box for Began Date
When the user enters the month <beganMonth> in the drop down box for Began Date
When the user enters the year <beganYear> in the text box for Began Date
When the user enters the day <endDay> in the text box for End Date
When the user enters the month <endMonth> in the drop down box for End Date
When the user enters the year <endYear> in the text box for End Date
And the user verifies that the <endDay>, <endMonth> and <endYear> is in Gregorian Calendar format
And the user verifies that the <endDay>, <endMonth> and <endYear> is not later than today
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
|Afghanistan|Badakshan|Panj Shair|1|June|2016|5|June|2016|Basic Info| 

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
And the user verifies that the <endDay>, <endMonth> and <endYear> is in Gregorian Calendar format
And the user verifies that the <endDay>, <endMonth> and <endYear> is not later than today
When the user clicks on the save button
Then the user verifies whether error message <errMsg> is displayed

Examples:
|country|area|city|beganDay|beganMonth|beganYear|endDay|endMonth|endYear|Summary|errMsg|
|Afghanistan|Badakshan|Badakhshan|1|June|2016|1|June|1015|Basic Info|Must be after Began date.| 

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
And the user clears the day, month and year values for Began Date
When the user enters the day <endDay> in the text box for End Date
When the user enters the month <endMonth> in the drop down box for End Date
When the user enters the year <endYear> in the text box for End Date
And the user verifies that the <endDay>, <endMonth> and <endYear> is in Gregorian Calendar format
And the user verifies that the <endDay>, <endMonth> and <endYear> is not later than today
When the user clicks on the save button
When the user clicks on the confirm button
Then the user checks the error message <errMsg> is displayed at the top of the page

Examples:
|country|area|city|endDay|endMonth|endYear|errMsg|
|USA|Alabama|Alexander City|6|June|2016|Technical error. Update not successful. Please contact Accuity Helpdesk|