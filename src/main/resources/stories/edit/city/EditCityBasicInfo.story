Meta: @EditCityBasicInfo @Edit @City @AllStories

Narrative:
In order to view and edit the city page
As a user
I want to cover the requirements mentioned in
JIRA ID - ZEUS-962 - User can view city status and can edit the city status
JIRA ID - ZEUS-969 -User can edit City's Add info
JIRA ID - ZEUS-972 -User can edit City's Identifiers
JIRA ID - ZEUS-968 - User can edit City's Population
JIRA ID - ZEUS-963 - User can edit City's Began Date


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
|USA|Georgia|Adel|12345|
|USA|Georgia|Adel|24513450000000000000000000000000000000000000000000|

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
|USA|Georgia|Adel|123457|Summary|

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
|USA|Georgia|Adel|stringvalue|

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


Scenario: User can edit city Began Date - Verify if User can see an error message in City basic info edit page when Year & Day is entered in an invalid length

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
|Tajikistan|Leninabadskaya Oblast|Gafurov|454845|Sep|4568821|

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
