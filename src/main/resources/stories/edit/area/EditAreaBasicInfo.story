Meta: @EditAreaBasicInfo @Edit @Area @AllStories

Narrative:
In order to view and edit the area page
As a user
I want to cover the requirements mentioned in

JIRA ID - ZEUS-1025 - User can edit Area's Status
JIRA ID - ZEUS-1027 - User can edit Area's End Date

JIRA ID - ZEUS-1026 - User can edit Area's Began Date
JIRA ID - ZEUS-1034 - User can edit Area's Add Info
JIRA ID - ZEUS-1040 - User can edit Area's Identifiers
JIRA ID - ZEUS-1039 - User can edit Area's Names
JIRA ID - ZEUS-1173 - Error handling when error is in section not currently displayed
JIRA ID - ZEUS-1033 - User can edit Area's Interest Rate Limit
JIRA ID - ZEUS-1041 - User can edit Area's Timezone
JIRA ID - ZEUS-1032 - User can edit Area's Use In Address Flag
JIRA ID - ZEUS-1031 - User can edit Area's Country & Area


Scenario: User can edit area Began Date -
a)Verify if user can see all the months in month dropdown (Began Date) are in MMM format
b)Verify if user can see that all the months are sorted as per chronological order
c)Verify if User can see Current value of the Month,Day & Year is retrieved from trusted document
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
When the user clicks on the area basic info link in the navigation bar
And the user clicks on the area update link
Then the user verifies whether all the months in the drop down option for area are in MMM format & are sorted in the chronological order
Then the user should see area began date value same as in trusted document

Examples:
|country|area|
|Angola|Cabinda|

Scenario: User can edit area Began Date - User has entered an 'Began Date' that is different from the current value, verify if
a)User can see Success message in Area Page
b)User can see entered values updated in Area Page
c)User can see entered values updated in Zeus document
d)User can see Basic info changes are updated in Confirmation Modal

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
When the user clicks on the area basic info link in the navigation bar
And the user clicks on the area update link
When the user gets the document with get document id for area with the <area> from the database
When the user enters <day2> <month2> <year2> Began Date in the edit basic info area page
When the user clicks on the save button
When the user clicks on the confirm button
When the user clicks on the area update link
When the user enters began date day <day> in the edit basic info area page
When the user enters began date month <month> in the edit basic info area page
When the user enters began date year <year> in the edit basic info area page
When the user clicks on the save button
Then the user should see the save confirmation modal
And the user should see the below summary changes in confirmation modal
|Summary|
|Basic Info|
When the user clicks on the confirm button
Then the user should see the entered <day> <month> <year> in area page
Then the user should see the area began date <day> <month> <year> value in zeus document
Then the user reverts the changes to the document


Examples:
|country|area|day|month|year|day2|month2|year2|
|Angola|Cabinda|05|Jun|2015|06|Jun|2015|

Scenario: User can edit area Began Date - Verify if
a)User can see Success message in Area Page
b)User can see entered values updated in Area Page
c)User can see entered values updated in Zeus document
d)User can see Basic info changes are updated in Confirmation Modal

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
When the user clicks on the area basic info link in the navigation bar
And the user clicks on the area update link
When the user gets the document with get document id for area with the <area> from the database
When the user enters began date day <day> in the edit basic info area page
When the user enters began date month <month> in the edit basic info area page
When the user enters began date year <year> in the edit basic info area page
When the user clicks on the save button
When the user clicks on the confirm button
Then the user should see the entered <day> <month> <year> in area page
Then the user should see the area began date <day> <month> <year> value in zeus document
Then the user reverts the changes to the document


Examples:
|country|area|day|month|year|
|Angola|Cabinda|||2016|
|Angola|Cabinda||Jun|2015|
|Angola|Cabinda|05|Jun|2015|

Scenario: User can edit area Began Date - Verify if User can see Began date getting saved in Area Page & Zeus document  when Day,Month & Year are entered as blank values

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
When the user clicks on the area basic info link in the navigation bar
And the user clicks on the area update link
When the user gets the document with get document id for area with the <area> from the database
When the user enters began date day <day> in the edit basic info area page
When the user enters began date month <month> in the edit basic info area page
When the user enters began date year <year> in the edit basic info area page
When the user clicks on the save button
When the user clicks on the confirm button
Then the user should see the entered <day> <month> <year> in area page
Then the user should see the area began date <day> <month> <year> value in zeus document
Then the user reverts the changes to the document

Examples:
|country|area|day|month|year|
|Angola|Cabinda||||


Scenario: User can edit area Began Date - Verify if User can see an error message in Area basic info edit page when began date is entered in an invalid format

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
When the user clicks on the area basic info link in the navigation bar
And the user clicks on the area update link
When the user enters began date day <day> in the edit basic info area page
When the user enters began date month <month> in the edit basic info area page
When the user enters began date year <year> in the edit basic info area page
When the user clicks on the save button
Then the user should see the error Enter a year, month/year or day/month/year. for area began date

Examples:
|country|area|day|month|year|
|Angola|Cabinda|06||2016|
|Angola|Cabinda|06|Jun||
|Angola|Cabinda||Jun||
|Angola|Cabinda|06|||

Scenario: User can edit area Began Date - Verify if User can see an error message in Area basic info edit page when future began date is entered

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
When the user clicks on the area basic info link in the navigation bar
And the user clicks on the area update link
When the user enters began date day <day> in the edit basic info area page
When the user enters began date month <month> in the edit basic info area page
When the user enters began date year <year> in the edit basic info area page
When the user clicks on the save button
Then the user should see the error Must be no later than today. for area began date

Examples:
|country|area|day|month|year|
|Angola|Cabinda|06|Jun|2020|

Scenario: User can edit area Began Date - Verify if User can see an error message in Area basic info edit page when invalid Year & inavlid Day is entered

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
When the user clicks on the area basic info link in the navigation bar
And the user clicks on the area update link
When the user enters began date day <day> in the edit basic info area page
When the user enters began date month <month> in the edit basic info area page
When the user enters began date year <year> in the edit basic info area page
When the user clicks on the save button
Then the user should see the error Invalid Date for area began date

Examples:
|country|area|day|month|year|
|Angola|Cabinda|45|Sep|4568|
|Angola|Cabinda|4R|Jun|2016|

Scenario: User can edit area Began Date - Verify if User can see a success message in Area basic info edit page when Day,Month & Year which is no different than current value entered

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
When the user clicks on the area basic info link in the navigation bar
And the user clicks on the area update link
When the user gets the document with get document id for area with the <area> from the database
When the user enters began date day <day> in the edit basic info area page
When the user enters began date month <month> in the edit basic info area page
When the user enters began date year <year> in the edit basic info area page
When the user clicks on the save button
When the user clicks on the confirm button
When the user clicks on the area update link
When the user enters began date day <day> in the edit basic info area page
When the user enters began date month <month> in the edit basic info area page
When the user enters began date year <year> in the edit basic info area page
When the user clicks on the save button
Then the user should not see the <ConfirmationSummary> changes in confirmation modal for area
When the user clicks on the confirm button
Then the user should see the entered <day> <month> <year> in area page
Then the user should see the area began date <day> <month> <year> value in zeus document
Then the user reverts the changes to the document

Examples:
|country|area|day|month|year|ConfirmationSummary|
|Angola|Cabinda|06|Jun|2016|Summary|

Scenario: Verify Area Status dropdown values from lookup Status
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the <area> in the type-ahead box
And the user clicks on the area basic info link in the navigation bar
And the user clicks on the area update link
When the user clicks on the Status drop-down in the basicinfo area page
Then the user should see the area status values from lookup AREA

Examples:
|country|area|
|USA|Alabama|

Scenario: Edit and Save Area's Status value in the Area Basic Info page
a) Update the status with a new value and verify it is updated in Area Web page & zeus document
b) verify that the status can be changed to all 3 values active,inactive and pending

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the <area> in the type-ahead box
And the user clicks on the area basic info link in the navigation bar
And the user clicks on the area update link
When the user gets the document with get document id for area with the <area> from the database
When the user selects value as <status> from Status drop-down in the area basicinfo page
And the user clicks on the save button
Then the user should see the save confirmation modal
When the user clicks on the confirm button
Then the user should see the successful update message at top of the area page
Then the user should see the updated <status> in area web page
Then the user should see status value in area page as in zeus document
Then the user reverts the changes to the document

Examples:
|country|area|status|
|USA|Alabama|Active|
|USA|Alabama|Pending|
|USA|Alabama|Inactive|

Scenario:  Verify that the Area Status drop-down list should highlight the values that contain characters input by user

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the <area> in the type-ahead box
And the user clicks on the area basic info link in the navigation bar
And the user clicks on the area update link
And the user starts typing the name of a status as i in the Area Status drop-down
Then the user should see the selected status in the Area Status drop-down as Inactive
When the user starts typing the name of a status as a in the Area Status drop-down
Then the user should see the selected status in the Area Status drop-down as Active
When the user starts typing the name of a status as p in the Area Status drop-down
Then the user should see the selected status in the Area Status drop-down as Pending
When the user starts typing the name of a status as x in the Area Status drop-down
Then the user should see the selected status in the Area Status drop-down as Pending

Examples:
|country|area|
|USA|Alabama|

Scenario: Verify whether Area Status value in Area Web Page is retrieved from trusted document.
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the <area> in the type-ahead box
And the user clicks on the area basic info link in the navigation bar
And the user clicks on the area update link
Then the user should see the area status value in area page is same as in trusted document

Examples:
|country|area|
|USA|Alabama|

Scenario: User will see summary of changes made in confirmation modal when update the Area status

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the <area> in the type-ahead box
And the user clicks on the area basic info link in the navigation bar
And the user clicks on the area update link
When the user gets the document with get document id for area with the <area> from the database
When the user selects value as <status> from Status drop-down in the area basicinfo page
And the user clicks on the save button
Then the user should see the save confirmation modal
When the user clicks on the confirm button
Then the user should see the successful update message at top of the area page
Then the user should see the updated <status> in area web page
When the user clicks on the area update link
When the user selects value as <status2> from Status drop-down in the area basicinfo page
And the user clicks on the save button
Then the user should see the save confirmation modal
And the user should see the below summary changes in confirmation modal
|Summary|
|Basic Info|
When the user clicks on the return button
Then the user reverts the changes to the document

Examples:
|country|area|status|status2|
|USA|Alabama|Inactive|Pending|


Scenario: User can edit area End Date -
a)Verify if user can see all the months in month dropdown (End Date) are in MMM format
b)Verify if user can see that all the months are sorted as per chronological order
c)Verify if User can see Current value of the Month,Day & Year is retrieved from trusted document

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
When the user clicks on the area basic info link in the navigation bar
And the user clicks on the area update link
Then the user verifies whether all the months in the drop down option for End date are in MMM format & are sorted in the chronological order
Then the user should see area end date value same as in trusted document

Examples:
|country|area|
|Angola|Cabinda|


Scenario: User can edit area End Date - User has entered an 'End Date' that is different from the current value, verify if
a)User can see Success message in Area Page
b)User can see entered values updated in Area Page
c)User can see entered values updated in Zeus document
d)User can see Basic info changes are updated in Confirmation Modal

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
When the user clicks on the area basic info link in the navigation bar
And the user clicks on the area update link
When the user gets the document with get document id for area with the <area> from the database
When the user enters <beganDay1> <beganMonth1> <beganYear1> Began Date in the edit basic info area page
When the user enters <endDay1> <endMonth1> <endYear1> End Date in the edit basic info area page
When the user clicks on the save button
When the user clicks on the confirm button
When the user clicks on the area update link
When the user enters end date day <day> in the edit basic info area page
When the user enters end date month <month> in the edit basic info area page
When the user enters end date year <year> in the edit basic info area page
When the user clicks on the save button
Then the user should see the save confirmation modal
And the user should see the below summary changes in confirmation modal
|Summary|
|Basic Info|
When the user clicks on the confirm button
Then the user should see the entered end date <day> <month> <year> in area page
Then the user should see the area end date <day> <month> <year> value in zeus document
Then the user reverts the changes to the document


Examples:
|country|area|beganDay1|beganMonth1|beganYear1|endDay1|endMonth1|endYear1|day|month|year|
|Angola|Cabinda|05|Jun|2015|06|Jun|2015|07|Jun|2015|



Scenario: User can edit area End Date - Verify end date get saved even if all values are blank.

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
When the user clicks on the area basic info link in the navigation bar
And the user clicks on the area update link
When the user gets the document with get document id for area with the <area> from the database
When the user enters <beganDay1> <beganMonth1> <beganYear1> Began Date in the edit basic info area page
When the user enters end date day <day> in the edit basic info area page
When the user enters end date month <month> in the edit basic info area page
When the user enters end date year <year> in the edit basic info area page
When the user clicks on the save button
When the user clicks on the confirm button
Then the user should see the entered end date <day> <month> <year> in area page
Then the user should see the area end date <day> <month> <year> value in zeus document
Then the user reverts the changes to the document


Examples:
|country|area|beganDay1|beganMonth1|beganYear1|day|month|year|
|Angola|Cabinda|05|Jun|2015||||



Scenario: User is entering invalid inputs -  Verify if User can see an error message in Area basic info edit page
a)The user does not enter the month.
b)The user does not enter the year.
c)The user does not enter the day and year.
d)The user does not enter the month and year.

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
When the user clicks on the area basic info link in the navigation bar
And the user clicks on the area update link
When the user enters <beganDay1> <beganMonth1> <beganYear1> Began Date in the edit basic info area page
When the user enters end date day <day> in the edit basic info area page
When the user enters end date month <month> in the edit basic info area page
When the user enters end date year <year> in the edit basic info area page
When the user clicks on the save button
Then the user should see the error Enter a year, month/year or day/month/year. for area end date

Examples:
|country|area|beganDay1|beganMonth1|beganYear1|day|month|year|
|Angola|Cabinda|05|Jun|2015|06||2016|
|Angola|Cabinda|05|Jun|2015|06|Jun||
|Angola|Cabinda|05|Jun|2015||Jun||
|Angola|Cabinda|05|Jun|2015|06|||


Scenario: User can edit area End Date - Verify if User can see an error message in Area basic info edit page when future end date is entered

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
When the user clicks on the area basic info link in the navigation bar
And the user clicks on the area update link
When the user enters end date day <day> in the edit basic info area page
When the user enters end date month <month> in the edit basic info area page
When the user enters end date year <year> in the edit basic info area page
When the user clicks on the save button
Then the user should see the error Must be no later than today. for area end date

Examples:
|country|area|day|month|year|
|Angola|Cabinda|06|Jun|2020|

Scenario: Verify if User can see an error message in Area basic info edit page when user enters the day with alphabets (not in Gregorian calendar format)

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
When the user clicks on the area basic info link in the navigation bar
And the user clicks on the area update link
When the user enters end date day <day> in the edit basic info area page
When the user enters end date month <month> in the edit basic info area page
When the user enters end date year <year> in the edit basic info area page
When the user clicks on the save button
Then the user should see the error Invalid Date for area end date

Examples:
|country|area|day|month|year|
|Angola|Cabinda|6Rdseth765|Jun|2016|
|Angola|Cabinda|4R|Jun|4568|


Scenario: User can edit area End Date - Verify if User can see a success message in Area basic info edit page when Day,Month & Year which is no different than current value entered

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
When the user clicks on the area basic info link in the navigation bar
And the user clicks on the area update link
When the user gets the document with get document id for area with the <area> from the database
When the user enters <beganDay1> <beganMonth1> <beganYear1> Began Date in the edit basic info area page
When the user enters <endDay1> <endMonth1> <endYear1> End Date in the edit basic info area page
When the user clicks on the save button
When the user clicks on the confirm button
When the user clicks on the area update link
When the user enters end date day <day> in the edit basic info area page
When the user enters end date month <month> in the edit basic info area page
When the user enters end date year <year> in the edit basic info area page
When the user clicks on the save button
Then the user should not see the <ConfirmationSummary> changes in confirmation modal for area
When the user clicks on the confirm button
Then the user should see the entered end date <day> <month> <year> in area page
Then the user should see the area end date <day> <month> <year> value in zeus document
Then the user reverts the changes to the document

Examples:
|country|area|beganDay1|beganMonth1|beganYear1|endDay1|endMonth1|endYear1|day|month|year|ConfirmationSummary|
|Angola|Cabinda|05|Jun|2015|06|Jun|2015|06|Jun|2015|Summary|


Scenario: User can edit area End Date - Verify if User can see an error message in Area basic info edit page when end date is before began date

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
When the user clicks on the area basic info link in the navigation bar
And the user clicks on the area update link
When the user gets the document with get document id for area with the <area> from the database
When the user enters <beganDay1> <beganMonth1> <beganYear1> Began Date in the edit basic info area page
When the user enters end date day <day> in the edit basic info area page
When the user enters end date month <month> in the edit basic info area page
When the user enters end date year <year> in the edit basic info area page
When the user clicks on the save button
Then the user should see the error Must be after Began date. for area end date

Examples:
|country|area|beganDay1|beganMonth1|beganYear1|day|month|year|
|Angola|Cabinda|06|Jun|2015|05|Jun|2015|


Scenario: User can edit area End Date - Verify end date get saved even if began date is empty.

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
When the user clicks on the area basic info link in the navigation bar
And the user clicks on the area update link
When the user gets the document with get document id for area with the <area> from the database
When the user enters <beganDay1> <beganMonth1> <beganYear1> Began Date in the edit basic info area page
When the user enters end date day <day> in the edit basic info area page
When the user enters end date month <month> in the edit basic info area page
When the user enters end date year <year> in the edit basic info area page
When the user clicks on the save button
When the user clicks on the confirm button
Then the user should see the entered end date <day> <month> <year> in area page
Then the user should see the area end date <day> <month> <year> value in zeus document
Then the user reverts the changes to the document

Examples:
|country|area|beganDay1|beganMonth1|beganYear1|day|month|year|
|Angola|Cabinda||||06|Jun|2015|

Scenario:  To update the Area`s 'Basic Info' by entering a value for 'Add Info' that is different from the current value
a)User verifies whether current value of Add Info is same as in trusted document.
b)User verifies Area Basic Info has been updated in confirmation modal
c)User verifies 'Your Changes have been saved' message is displayed after save
d)User verified Add Info value is updated correctly in area basic info page
e)User verifies Add Info values in Zeus Document

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the <area> in the type-ahead box
And the user clicks on the area basic info link in the navigation bar
And the user clicks on the area update link
When the user gets the document with get document id for area with the <area> from the database
Then the user should see the area addInfoText value same as in trusted document
When the user enters the <addInfoDiffText> in the area add info text area
And the user clicks on the save button
When the user clicks on the confirm button
Then the user should see the successful update message at top of the area page
When the user clicks on the area update link
When the user enters the <addInfoText> in the area add info text area
And the user clicks on the save button
Then the user should see the below summary changes in confirmation modal
|Summary|
|Basic Info|
When the user clicks on the confirm button
Then the user should see the successful update message at top of the area page
Then the user should be able to verify the values are entered in the area add info field
Then the user should see the area addinfo value <addInfoText> as in zeus document
Then the user reverts the changes to the document
Examples:
|country|area|addInfoDiffText|addInfoText|
|USA|Georgia|This is a sample text|This is a different text|



Scenario: ZEUS-1173- Verify when user is viewing a section other than Basic Info and Basic Info section has some errors, upon saving the Area,
the user should automatically navigate to All section
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the area update link
When the user enters <beganDay1> <beganMonth1> <beganYear1> Began Date in the edit basic info area page
When the user clicks on the area's demographics link in the navigation bar
When the user clicks on the save button
Then the user should see the user is navigated to All section view
Then the user should see the error Enter a year, month/year or day/month/year. for area began date
And the user should see the error message at top of page the highlighted fields must be addressed before this update can be saved

Examples:
|country|area|beganDay1|beganMonth1|beganYear1|
|Angola|Cabinda|05||2015|


Scenario: To view that there is no change in value when the user has entered a value for 'Add Info' that is no different to the current value in Area page
a)User verifies Area Basic Info changes has not been updated in confirmation modal
b)User verifies 'Your Changes have been saved' message is displayed after save
c)User verified Add Info value is updated correctly in area basic info page

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the <area> in the type-ahead box
And the user clicks on the area basic info link in the navigation bar
And the user clicks on the area update link
When the user gets the document with get document id for area with the <area> from the database
When the user enters the <addInfoText> in the area add info text area
And the user clicks on the save button
When the user clicks on the confirm button
Then the user should see the successful update message at top of the area page
Then the user should be able to verify the values are entered in the area add info field
When the user clicks on the area update link
When the user enters the <addInfoText> in the area add info text area
And the user clicks on the save button
Then the user should not see the <ConfirmationSummary> changes in confirmation modal for area
When the user clicks on the confirm button
Then the user should see the successful update message at top of the area page
Then the user should be able to verify the values are entered in the area add info field
Then the user reverts the changes to the document

Examples:
|country|area|addInfoText|ConfirmationSummary|
|USA|Georgia|This is a same text|Basic Info|

Scenario: User verifies that add info field is limited to 500 unicode characters in Area basic info Page
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the <area> in the type-ahead box
And the user clicks on the area basic info link in the navigation bar
And the user clicks on the area update link
When the user gets the document with get document id for area with the <area> from the database
When the user enters values which is beyond 500 unicode characters in the area add info field
And the user clicks on the save button
And the user clicks on the confirm button
Then the user should see the successful update message at top of the area page
Then the user should be able to view that only 500 unicode characters are saved in area add info
Then the user should be able to verify the maximum values are entered in the area add info field
Then the user reverts the changes to the document

Examples:
|country|area|
|USA|Georgia|

Scenario:  To update the Area`s 'Basic Info' by entering a blnak value for 'Add Info'
a)User verifies whether blank value for Add Info is saved successfully in area basic info web page
b)User verifies 'Your Changes have been saved' message is displayed after save
d)User verifies Blank Add Info values updated  in Zeus Document

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the <area> in the type-ahead box
And the user clicks on the area basic info link in the navigation bar
And the user clicks on the area update link
When the user gets the document with get document id for area with the <area> from the database
When the user enters the <addInfoText> in the area add info text area
And the user clicks on the save button
When the user clicks on the confirm button
Then the user should see the successful update message at top of the area page
Then the user should be able to verify the values are entered in the area add info field
Then the user should see the area addinfo value <addInfoText> as in zeus document
Then the user reverts the changes to the document

Examples:
|country|area|addInfoText|
|USA|Georgia||

Scenario: User can edit area identifiers -
1- Verify area Identifier types are same as from lookup THIRD_PARTY_IDENTIFIER_GEO
2- Verify area Identifier status are from lookup STATUS
3- Verify existing identifier values are from trusted

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
When the user clicks on the area basic info link in the navigation bar
And the user clicks on the area update link
Then the user should see the identifier values same as in trusted document
When the user clicks on the add new identifier button in the basic info area page
Then the user should see the area identifier types from lookup THIRD_PARTY_IDENTIFIER_GEO
Then the user should see the area identifier status from lookup STATUS

Examples:
|country|area|
|Algeria|Constantine|

Scenario: User can edit area identifiers- Verify if User can add New Area identifiers-Verify that all fields- "Type","Value" and "Status" are updated successfully
1 - Verify two identifer rows are added
2 - Verify previously selected Identifer Type is not listed in identifer type dropdown of next row
3 - Verify Zeus Area page is updated with entered identifier values
4 - Verify Zeus DB is updated with entered identifier values

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
When the user clicks on the area basic info link in the navigation bar
And the user clicks on the area update link
When the user gets the document with get document id for area with the <area> from the database
When the user deletes the existing area identifier rows
When the user clicks on the add new identifier button in the basic info area page
When the user enters identifier type as <identifierType> in the basic info area page
When the user enters identifier value as <identifierValue> in the basic info area page
When the user enters identifier status as <identifierStatus> in the basic info area page
When the user clicks on the add new identifier button in the basic info area page
Then the user verifies that previously selected <identifierType> is not present in the new identifier row
When the user enters identifier type as <identifierType2> in the basic info area page
When the user enters identifier value as <identifierValue2> in the basic info area page
When the user enters identifier status as <identifierStatus2> in the basic info area page
And the user clicks on the save button
Then the user should see the save confirmation modal
And the user should see the below summary changes in confirmation modal
|Summary|
|Basic Info / Identifiers|
When the user clicks on the confirm button
Then the user should see the successful update message at top of the area page
Then the user verifies that the area identifiers parameters are entered in the basic info area page
Then the user should see the area identifier values as in zeus document
Then the user reverts the changes to the document

Examples:
|country|area|identifierType|identifierValue|identifierStatus|identifierType2|identifierValue2|identifierStatus2|
|Algeria|Constantine|Numeric ISO Code|QATesting|Active|FIPS Place Code|QATesting|Pending|
|Algeria|Constantine|FIPS Place Code|QATesting|Pending|Numeric ISO Code|QATesting|Inactive|
|Algeria|Constantine|FIPS Place Code|QATesting|Active|Numeric ISO Code|QATesting|Active|


Scenario: Verifying that area identifier row in not added when blank values are entered for 'Type', 'Value' and 'Status'

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
When the user clicks on the area basic info link in the navigation bar
And the user clicks on the area update link
When the user gets the document with get document id for area with the <area> from the database
When the user deletes the existing area identifier rows
When the user clicks on the add new identifier button in the basic info area page
When the user enters identifier type as <identifierType> in the basic info area page
When the user enters identifier value as <identifierValue> in the basic info area page
When the user enters identifier status as <identifierStatus> in the basic info area page
When the user clicks on the save button
Then the user should see the save confirmation modal
When the user clicks on the confirm button
Then the user should see the successful update message at top of the area page
Then the user should not see the newly added identifier row in the basic info area page
Then the user verifies that no values are entered in zeus document
Then the user reverts the changes to the document

Examples:
|country|area|identifierType|identifierValue|identifierStatus|
|Algeria|Constantine||||

Scenario: User can edit area identifiers - Verify whether the text entered in the Identifier 'Value' field is not beyond 50 unicode characters.

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
When the user clicks on the area basic info link in the navigation bar
And the user clicks on the area update link
When the user gets the document with get document id for area with the <area> from the database
When the user deletes the existing area identifier rows
When the user clicks on the add new identifier button in the basic info area page
When the user enters identifier type as <identifierType> in the basic info area page
When the user enters an incorrect identifier value as <identifierValueIncorrect> in the basic info area page
Then the user should see maximum length of area identifier value is limited to 50
When the user enters identifier status as <identifierStatus> in the basic info area page
When the user clicks on the save button
When the user clicks on the confirm button
Then the user should see the successful update message at top of the area page
Then the user reverts the changes to the document


Examples:
|country|area|identifierType|identifierValueIncorrect|identifierStatus|
|Algeria|Constantine|Numeric ISO Code|aksjuilrw1aksjuilrw1aksjuilrw1aksjuilrw1aksju%)~12y1|Active|

Scenario: User can edit area identifiers
1 - Verify that an error message 'Required' is displayed when user left identifier Type blank and enters value in identifier 'Value' and 'Status'

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
When the user clicks on the area basic info link in the navigation bar
And the user clicks on the area update link
When the user deletes the existing area identifier rows
When the user clicks on the add new identifier button in the basic info area page
When the user enters identifier type as <identifierType> in the basic info area page
When the user enters identifier value as <identifierValue> in the basic info area page
When the user enters identifier status as <identifierStatus> in the basic info area page
When the user clicks on the save button
Then the user should see the error message Required for identifier type field in the area basic info page

Examples:
|country|area|identifierType|identifierValue|identifierStatus|
|Algeria|Constantine||H4Testing|Inactive|

Scenario: User can edit area identifiers
1 - Verify that an error message 'Required' is displayed when user leaves identifier Value as blank and enters value in identifier 'Type' and 'Status'

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
When the user clicks on the area basic info link in the navigation bar
And the user clicks on the area update link
When the user deletes the existing area identifier rows
When the user clicks on the add new identifier button in the basic info area page
When the user enters identifier type as <identifierType> in the basic info area page
When the user enters identifier value as <identifierValue> in the basic info area page
When the user enters identifier status as <identifierStatus> in the basic info area page
When the user clicks on the save button
Then the user should see the error message Enter up to 50 valid characters. for identifier value field in the area basic info page

Examples:
|country|area|identifierType|identifierValue|identifierStatus|
|Algeria|Constantine|Numeric ISO Code||Active|

Scenario: User can edit area identifiers
1 - Verify that an error message 'Required' is displayed when user left identifier status blank and enters value in identifier 'Type' and 'Value'

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
When the user clicks on the area basic info link in the navigation bar
And the user clicks on the area update link
When the user deletes the existing area identifier rows
When the user clicks on the add new identifier button in the basic info area page
When the user enters identifier type as <identifierType> in the basic info area page
When the user enters identifier value as <identifierValue> in the basic info area page
When the user enters identifier status as <identifierStatus> in the basic info area page
When the user clicks on the save button
Then the user should see the error message Required for identifier status field in the area basic info page

Examples:
|country|area|identifierType|identifierValue|identifierStatus|
|Algeria|Constantine|Numeric ISO Code|H4Testing||

Scenario: User can edit area identifiers
1 - Verify if User can delete exisiting identifiers( "Type","Value" and "Status").

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
When the user clicks on the area basic info link in the navigation bar
And the user clicks on the area update link
When the user gets the document with get document id for area with the <area> from the database
When the user deletes the existing area identifier rows
When the user clicks on the save button
When the user clicks on the confirm button
Then the user should see the successful update message at top of the area page
Then the user should not see the identifier row in the basic info area page
Then the user verifies that the deleted row for area identifier does not exist in zeus document
Then the user reverts the changes to the document

Examples:
|country|area|
|Algeria|Constantine|

Scenario: User can edit area identifiers
1 - Verify if User can prevent deleting identifiers( "Type","Value" and "Status") by clicking on 'No'.
2 - Verify if User can delete identifiers( "Type","Value" and "Status") by clicking on 'Yes' , then after saving it should be removed.

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
When the user clicks on the area basic info link in the navigation bar
And the user clicks on the area update link
When the user gets the document with get document id for area with the <area> from the database
When the user deletes the existing area identifier rows
When the user clicks on the add new identifier button in the basic info area page
When the user enters identifier type as <identifierType> in the basic info area page
When the user enters identifier value as <identifierValue> in the basic info area page
When the user enters identifier status as <identifierStatus> in the basic info area page
When the user clicks on the save button
When the user clicks on the confirm button
When the user clicks on the area update link
When the user clicks on the delete identifier row button in the basic info area page
Then the user should see delete row confirmation modal in the area page
When the user clicks on the No button to cancel the deletion of row in basic info area page
Then the user should see the newly added identifier row in the basic info area page
When the user clicks on the save button
When the user clicks on the confirm button
Then the user verifies that the newly added identifier row values exists in the basic info area page
Then the user verifies that the row values for area identifier entered exists in zeus document
When the user clicks on the area update link
When the user clicks on the delete identifier row button in the basic info area page
Then the user should see delete row confirmation modal in the area page
When the user clicks on the Yes button to delete the row in basic info area page
When the user clicks on the save button
When the user clicks on the confirm button
Then the user should see the successful update message at top of the area page
Then the user should not see the newly added identifier row in the basic info area page
Then the user verifies that the deleted row for area identifier does not exist in zeus document
Then the user reverts the changes to the document

Examples:
|country|area|identifierType|identifierValue|identifierStatus|
|Algeria|Constantine|FIPS Place Code|H4Testing|Pending|


Scenario: User has selected to update Full Name in Area's Basic Info

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
When the user clicks on the area basic info link in the navigation bar
And the user clicks on the area update link
When the user gets the document with get document id for area with the <area> from the database
Then the user should see the Full Name type is from PLACE_NAME_TYPE lookup
Then the user should see the Full Name value in area page is same as in trusted document
And the user should see the Full Name is not editable
Then the user enters the name <value> in the Full Name field
When the user clicks on the save button
Then the user should see the save confirmation modal
And the user should see the below summary changes in confirmation modal
|Summary|
|Basic Info / Names|
When the user clicks on the confirm button
Then the user should see the Full Name <value> in zeus document
Then the user should be able see the <value> is updated in Full Name value field
Then the user reverts the changes to the document

Examples:
|country|area|value|
|Angola|Namibe|Namibe1|

Scenario: User has selected to update Display Name in Area's Basic Info

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
When the user clicks on the area basic info link in the navigation bar
And the user clicks on the area update link
When the user gets the document with get document id for area with the <area> from the database
Then the user should see the Display Name type is from PLACE_NAME_TYPE lookup
Then the user should see the Display Name value in area page is same as in trusted document
And the user should see the Display Name is not editable
Then the user enters the name <value> in the Display Name field
When the user clicks on the save button
Then the user should see the save confirmation modal
And the user should see the below summary changes in confirmation modal
|Summary|
|Basic Info / Names|
When the user clicks on the confirm button
Then the user should see the Display Name <value> in zeus document
Then the user should be able see the <value> is updated in Display Name value field
Then the user reverts the changes to the document

Examples:
|country|area|value|
|Angola|Namibe|Namibe1|

Scenario: User has selected to add Alternative Name in Area's Basic Info
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
When the user clicks on the area basic info link in the navigation bar
And the user clicks on the area update link
When the user gets the document with get document id for area with the <area> from the database
When the user deletes the existing area names rows
When the user clicks on the add names button in the area basic info page
Then the user should see the area name types from lookup PLACE_NAME_TYPE
When the user enters name type as <type> in the area basic info page
And the user enters name value as <value> in the area basic info page
When the user clicks on the save button
Then the user should see the save confirmation modal
And the user should see the below summary changes in confirmation modal
|Summary|
|Basic Info / Names|
When the user clicks on the confirm button
Then the user should see the Alternative Name <value> in zeus document
Then the user should see the area name type and value updated in the area basic info page
Then the user reverts the changes to the document

Examples:
|country|area|type|value|
|Angola|Namibe|Alternative Name|testing|

Scenario: User has selected to add New Name Row in Area's Basic Info - check save is successful when all blank values are selected and document is not updated

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
When the user clicks on the area basic info link in the navigation bar
And the user clicks on the area update link
When the user gets the document with get document id for area with the <area> from the database
When the user deletes the existing area names rows
When the user clicks on the add names button in the area basic info page
When the user enters name type as <type> in the area basic info page
And the user enters name value as <value> in the area basic info page
When the user clicks on the save button
When the user clicks on the confirm button
And the user clicks on the area update link
When the user clicks on the add names button in the area basic info page
When the user enters name type as <type> in the area basic info page
And the user enters name value as <value> in the area basic info page
When the user clicks on the save button
Then the user should see the save confirmation modal
Then the user should not see the <ConfirmationSummary> changes in confirmation modal for area
When the user clicks on the confirm button
Then the user should not see the <type> <value> in zeus document
Then the user reverts the changes to the document

Examples:
|country|area|type|value|ConfirmationSummary|
|Angola|Namibe|||Summary|

Scenario: User has selected to add New Name Row in Area's Basic Info - error message "Required" is displayed when type is not entered but value is entered

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
When the user clicks on the area basic info link in the navigation bar
And the user clicks on the area update link
When the user deletes the existing area names rows
When the user clicks on the add names button in the area basic info page
When the user enters name value as <value> in the area basic info page
When the user clicks on the save button
Then the user should see the error message Required for the required name type field in the area basic info page

Examples:
|country|area|value|
|Angola|Namibe|testing|

Scenario: User has selected to add New Name Row in Area's Basic Info - error message is displayed when type is entered but value is not entered

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
When the user clicks on the area basic info link in the navigation bar
And the user clicks on the area update link
When the user deletes the existing area names rows
When the user clicks on the add names button in the area basic info page
When the user enters name type as <type> in the area basic info page
When the user clicks on the save button
Then the user should see the error message Enter up to 75 valid characters. for the required name value field in the area basic info page

Examples:
|country|area|type|
|Angola|Namibe|Alternative Name|

Scenario: User has selected to delete an existing area name -
a) verify if User can delete area name row and clicks no on confirmation modal, the existing name is available in UI
b) verify if User can delete area name row and clicks yes on confirmation modal, on save the existing name is removed

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
When the user clicks on the area basic info link in the navigation bar
And the user clicks on the area update link
When the user gets the document with get document id for area with the <area> from the database
When the user deletes the existing area names rows
When the user clicks on the add names button in the area basic info page
When the user enters name type as <type> in the area basic info page
And the user enters name value as <value> in the area basic info page
When the user clicks on the save button
When the user clicks on the confirm button
And the user clicks on the area update link
When the user clicks on the delete name row button in the area basic info page
Then the user should see the delete row confirmation modal in the area page
When the user clicks on the no button in the delete row confirmation modal in the area page
Then the user should see the area name type and value in the edit area basic info page
When the user clicks on the delete name row button in the area basic info page
Then the user should see the delete row confirmation modal in the area page
When the user clicks on the yes button in the delete row confirmation modal in the area page
When the user clicks on the save button
Then the user should see the below summary changes in confirmation modal
|Summary|
|Basic Info / Names|
When the user clicks on the confirm button
Then the user should not see the <type> <value> in zeus document
Then the user should not see the area name type and value updated in the area basic info page
Then the user reverts the changes to the document

Examples:
|country|area|type|value|ConfirmationSummary|
|Angola|Namibe|Alternative Name|test|Summary|

Scenario: User has selected to add an area name -
a) verify if User can delete area name row and clicks no on confirmation modal, the newly added name is available in UI
b) verify if User can delete area name row and clicks yes on confirmation modal, on save the newly added name is removed

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
When the user clicks on the area basic info link in the navigation bar
And the user clicks on the area update link
When the user gets the document with get document id for area with the <area> from the database
When the user deletes the existing area names rows
When the user clicks on the add names button in the area basic info page
When the user enters name type as <type> in the area basic info page
And the user enters name value as <value> in the area basic info page
When the user clicks on the delete name row button in the area basic info page
Then the user should see the delete row confirmation modal in the area page
When the user clicks on the no button in the delete row confirmation modal in the area page
Then the user should see the area name type and value in the edit area basic info page
When the user clicks on the delete name row button in the area basic info page
Then the user should see the delete row confirmation modal in the area page
When the user clicks on the yes button in the delete row confirmation modal in the area page
When the user clicks on the save button
When the user clicks on the confirm button
Then the user should not see the <type> <value> in zeus document
Then the user should not see the area name type and value updated in the area basic info page
Then the user reverts the changes to the document

Examples:
|country|area|type|value|ConfirmationSummary|
|Angola|Namibe|Alternative Name|test|Summary|

Scenario: User has selected to update area name - verify that Full Name and Display Name cannot be deleted

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
When the user clicks on the area basic info link in the navigation bar
And the user clicks on the area update link
Then the user should not see delete row button against <type>

Examples:
|country|area|type|
|Angola|Namibe|Full Name|
|Angola|Namibe|Display Name|

Scenario: User has selected to add multiple Alternative Name in Area's Basic Info with different values

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
When the user clicks on the area basic info link in the navigation bar
And the user clicks on the area update link
When the user gets the document with get document id for area with the <area> from the database
When the user deletes the existing area names rows
When the user clicks on the add names button in the area basic info page
When the user enters name type as <type> in the area basic info page
And the user enters name value as <value> in the area basic info page
When the user clicks on the add names button in the area basic info page
When the user enters second name type as <type> in the area basic info page
And the user enters second name value as <value2> in the area basic info page
When the user clicks on the save button
Then the user should see the save confirmation modal
And the user should see the below summary changes in confirmation modal
|Summary|
|Basic Info / Names|
When the user clicks on the confirm button
Then the user should see the Alternative Name <value> and <value2> in zeus document
Then the user should see the area name type and value updated in the area basic info page
Then the user should see the second area name type and value updated in the area basic info page
Then the user reverts the changes to the document

Examples:
|country|area|type|value|value2|
|Angola|Namibe|Alternative Name|test|test2|

Scenario: User has selected to add multiple Alternative Name in Area's Basic Info with same values

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
When the user clicks on the area basic info link in the navigation bar
And the user clicks on the area update link
When the user gets the document with get document id for area with the <area> from the database
When the user deletes the existing area names rows
When the user clicks on the add names button in the area basic info page
When the user enters name type as <type> in the area basic info page
And the user enters name value as <value> in the area basic info page
When the user clicks on the add names button in the area basic info page
When the user enters second name type as <type> in the area basic info page
And the user enters second name value as <value2> in the area basic info page
When the user clicks on the save button
Then the user should see the save confirmation modal
And the user should see the below summary changes in confirmation modal
|Summary|
|Basic Info / Names|
When the user clicks on the confirm button
Then the user should see the Alternative Name <value> and <value2> in zeus document
Then the user should see the area name type and value updated in the area basic info page
Then the user should not see the second area name type and value updated in the area basic info page
Then the user reverts the changes to the document

Examples:
|country|area|type|value|value2|
|Angola|Namibe|Alternative Name|testing|testing|


Scenario: User can edit  'Interest Rate Limit' that is different from the current value
a)User verifies existing 'Interest Rate Limit' existing interest rate values are retrieved  from trusted doc
b)User verifies 'Your Changes have been saved' message is displayed after save
c)User verifies Area Basic Info has been updated in confirmation modal
d)User verifies whether updated 'Interest Rate Limit is reflecting in Area Web page
e)User verifies whether updated 'Interest rate limit' is reflecting in zeus document
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
When the user clicks on the area basic info link in the navigation bar
And the user clicks on the area update link
Then the user should see the Interest Rate value in area page is same as per trusted document
When the user gets the document with get document id for area with the <area> from the database
When the user enters <interestRateOld> value in area page
When the user clicks on the save button
When the user clicks on the confirm button
Then the user should see the successful update message at top of the area page
Then the user should see the entered <interestRateOld> in area page
When the user clicks on the area update link
When the user enters <interestRate> value in area page
When the user clicks on the save button
Then the user should see the below summary changes in confirmation modal
|Summary|
|Basic Info|
When the user clicks on the confirm button
Then the user should see the entered <interestRate> in area page
Then the user should see the entered <interestRate> in zeus document
Then the user reverts the changes to the document

Examples:
|country|area|interestRateOld|interestRate|
|Angola|Cabinda|10%|15%|

Scenario: User can edit  'Interest Rate Limit' that is no different from the current value
a)User verifies 'Your Changes have been saved' message is displayed after save
b)User verifies Area Interest Rate changes has not been updated in confirmation modal
c)User verifies whether updated 'Interest Rate Limit' is reflecting in Area Web page
d)User verifies whether updated 'Interest rate limit' is reflecting in zeus document

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
When the user clicks on the area basic info link in the navigation bar
And the user clicks on the area update link
When the user gets the document with get document id for area with the <area> from the database
When the user enters <interestRateOld> value in area page
When the user clicks on the save button
When the user clicks on the confirm button
Then the user should see the successful update message at top of the area page
Then the user should see the entered <interestRateOld> in area page
When the user clicks on the area update link
When the user enters <interestRate> value in area page
When the user clicks on the save button
Then the user should not see the <ConfirmationSummary> changes in confirmation modal for area
When the user clicks on the confirm button
Then the user should see the entered <interestRate> in area page
Then the user should see the entered <interestRate> in zeus document
Then the user reverts the changes to the document

Examples:
|country|area|interestRateOld|interestRate|ConfirmationSummary|
|Angola|Cabinda|10%|10%|Basic Info|

Scenario: User can save  'Interest Rate Limit' successfully when blank value is entered (Blank/Null)
a)User verifies 'Your Changes have been saved' message is displayed after save
b)User verifies whether blank 'Interest Rate Limit value is reflecting in Area Web page
c)User verifies whether blank 'Interest rate limit' is reflecting in zeus document

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
When the user clicks on the area basic info link in the navigation bar
And the user clicks on the area update link
When the user gets the document with get document id for area with the <area> from the database
When the user enters <interestRate> value in area page
When the user clicks on the save button
When the user clicks on the confirm button
Then the user should see the successful update message at top of the area page
Then the user should see the entered <interestRate> in area page
Then the user should see the entered <interestRate> in zeus document
Then the user reverts the changes to the document

Examples:
|country|area|interestRate|
|Angola|Cabinda||

Scenario: User verifies that Interest Rate  field is limited to 256 unicode characters in Area basic info Page

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the <area> in the type-ahead box
And the user clicks on the area basic info link in the navigation bar
And the user clicks on the area update link
When the user gets the document with get document id for area with the <area> from the database
When the user enters values which is beyond 256 unicode characters in the area Interest Rate field
Then the user should see maximum length of interest rate value is limited to 256
When the user clicks on the save button
And the user clicks on the confirm button
Then the user should see the successful update message at top of the area page
Then the user should be able to view that only 256 unicode characters are saved in area Interest Rate field
Then the user should be able to verify the maximum values are entered in the area Interest Rate field
Then the user reverts the changes to the document

Examples:
|country|area|
|Angola|Cabinda|

Scenario: User is updating an Area's Basic Info and has entered characters & Symbols as a  value for 'Interest Rate Limit'
a)User verifies 'Your Changes have been saved' message is displayed after save
b)User verifies whether characters & symbols are saved as 'Interest Rate Limit value & is reflecting in Area Web page
c)User verifies whether updated 'Interest rate limit' is reflecting in zeus document

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
When the user clicks on the area basic info link in the navigation bar
And the user clicks on the area update link
When the user gets the document with get document id for area with the <area> from the database
When the user enters <interestRate> value in area page
When the user clicks on the save button
When the user clicks on the confirm button
Then the user should see the successful update message at top of the area page
Then the user should see the entered <interestRate> in area page
Then the user should see the entered <interestRate> in zeus document
Then the user reverts the changes to the document

Examples:
|country|area|interestRate|
|Angola|Cabinda|qwertyfhfyndsak|
|Angola|Cabinda|!@#$%^&*()_+}{|":>?<?.,|


Scenario: User views the Area basic page, selects the update button and clicks on add new timezone button
1- User verifies whether the current value in timezone is defaulted from trusted
2- User verifies whether default value for timezone is blank
3- User verifies the timezone values from timezone lookup

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the <area> in the type-ahead box
And the user clicks on the area basic info link in the navigation bar
And the user clicks on the area update link
When the user deletes the existing area timezone rows
Then the user clicks on add new timezone button
Then the user should see the timezone values same as in trusted document
Then the user should see the timezone values from TIME_ZONE lookup

Examples:
|country|area|
|USA|Alabama|

Scenario: User is updating a Areas's Basic Info and has set values for
each of 'Country', 'Area', clicks the add new timezone button and saves with empty timezone
1- User verifies area is not updated with newly added timezone 'timezone' as empty
2- User verifies Zeus DB whether the area is not updated with newly added timezone 'timezone' as empty

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the <area> in the type-ahead box
And the user clicks on the area basic info link in the navigation bar
And the user clicks on the area update link
When the user gets the document with get document id for area with the <area> from the database
When the user deletes the existing area timezone rows
Then the user clicks on add new timezone button
When the user clicks on the save button
Then the user should see the save confirmation modal
When the user clicks on the confirm button
Then the user should see the successful update message at top of the area page
Then the user verifies area page is not updated with Null time zone
Then the user verifies timezone is not updated in zeus document
Then the user reverts the changes to the document

Examples:
|country|area|
|USA|Alabama|

Scenario: User is updating a Areas's Basic Info and has set values for
each of 'Country', 'Area', clicks the add new timezone button, selects 'timezone' value
1- User verifies whether the time zone list displays all time zone's except those that have been already selected for this area
2- User verifies area is updated with newly added timezone
3- User verifies Zeus DB whether the area is updated with newly added timezone

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the <area> in the type-ahead box
And the user clicks on the area basic info link in the navigation bar
And the user clicks on the area update link
When the user gets the document with get document id for area with the <area> from the database
When the user deletes the existing area timezone rows
Then the user clicks on add new timezone button
Then user selects the timezone <timeZone> in the timezone dropdown of area basic page
Then the user clicks on add new timezone button
Then user verifies whether default value for timezone is blank
Then user verifies whether timezone dropdown displays time zone's except selected timezone <timeZone>
Then user selects the timezone <timeZone1> in the timezone dropdown of area basic page
When the user clicks on the save button
Then the user should see the save confirmation modal
When the user clicks on the confirm button
Then the user should see the successful update message at top of the area page
Then the user verifies that the area timezone values are updated in the basic info area page
And the user should see the area timezone values as in zeus document
Then the user reverts the changes to the document

Examples:
|country|area|timeZone|timeZone1|
|USA|Alabama|+10:00|+12:00|

Scenario: User is updating a Areas's Basic Info and has set values for each of 'Country', 'Area', clicks the add new timezone button, updates the existing 'timezone' value
1- User verifies existing timezone can be updated with new 'timezone'
2- User verifies Zeus DB whether the area is updated with newly updated timezone.
3- User verifies confirmation dialog modal has summary change text as 'Basic Info / Time Zones'
4- Verify if User can prevent deleting timezone by clicking on 'No'.
5- Verify if User can delete timezone by clicking on 'Yes', then after saving it should be removed.

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the <area> in the type-ahead box
And the user clicks on the area basic info link in the navigation bar
And the user clicks on the area update link
When the user gets the document with get document id for area with the <area> from the database
When the user deletes the existing area timezone rows
Then the user clicks on add new timezone button
Then user selects the timezone <timeZone> in the timezone dropdown of area basic page
When the user clicks on the save button
Then the user should see the save confirmation modal
When the user clicks on the confirm button
Then the user should see the successful update message at top of the area page
When the user clicks on the area update link
Then user changes the <timeZone1> in the timezone dropdown of area basic page
When the user clicks on the save button
Then the user should see the save confirmation modal
And the user should see the below summary changes in confirmation modal
|Summary|
|Basic Info / Time Zones|
When the user clicks on the confirm button
Then the user should see the successful update message at top of the area page
Then the user verifies whether the Area is updated with the newly updated timezone
And the user should see the area timezone value as in zeus document
When the user clicks on the area update link
When the user clicks on the delete timezone row button in the basic info area page
Then the user should see the delete row confirmation modal in the area page
When the user clicks on the no button in the delete row confirmation modal in the area page
Then the user should see the newly added timezone row in the basic info area page
When the user clicks on the delete timezone row button in the basic info area page
Then the user should see the delete row confirmation modal in the area page
When the user clicks on the yes button in the delete row confirmation modal in the area page
Then the user should not see the newly added timezone row in the basic info area page
When the user clicks on the save button
Then the user should see the save confirmation modal
When the user clicks on the confirm button
Then the user should see the successful update message at top of the area page
Then the user should not see the newly added timezone row in the basic info area page
Then the user verifies the deleted timezone does not exist in zeus document
Then the user reverts the changes to the document

Examples:
|country|area|timeZone|timeZone1|
|USA|Alabama|+10:00|+11:00|

Scenario: User is updating a Areas's Basic Info and has set values for each of 'Country', 'Area', user updates the existing timezone summary with new summary value
1- User verifies existing timezone 'summary' value is updated with 'summary1'
2- User verifies Zeus DB whether the area is updated with newly updated timezone 'summary1' value
3- User verifies area is updated with newly added timezone summary
4- User verifies Zeus DB whether the area is updated with timezone summary as 'NULL'
5- User verifies summary max length attribute is 100

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the <area> in the type-ahead box
And the user clicks on the area basic info link in the navigation bar
And the user clicks on the area update link
When the user gets the document with get document id for area with the <area> from the database
Then the user enters the summary as <summary>
When the user clicks on the save button
Then the user should see the save confirmation modal
When the user clicks on the confirm button
Then the user should see the successful update message at top of the area page
When the user clicks on the area update link
Then the user enters the summary as <summary1>
Then the user verifies summary max length attribute is 100
When the user clicks on the save button
Then the user should see the below summary changes in confirmation modal
|Summary|
|Basic Info / Time Zones|
When the user clicks on the confirm button
Then the user should see the successful update message at top of the area page
Then the user verifies the area page is updated with the new timezone summary
Then the user verifies the zeus document whether the area is updated with the newly updated summary
Then the user reverts the changes to the document

Examples:
|country|area|summary|summary1|
|USA|Alabama||Coordinated Universal Time|
|USA|Alabama|Coordinated Universal Time is the primary time standard by which the world regulates clocks and tim|1234|
|USA|Alabama|test|834567834652684561534168423156484231654568345678346526845615341684231564842316545634834567834654545|
|USA|Alabama|,.;:|@#$%$%^%^&&^&*%@#$%$%^%^&&^&*%@#$%$%^%^&&^&*%@#$%$%^%^&&^&*%@#$%$%^%^&&^&*%@#$%$%^%^&&^&*%@#$%$%^%^|
|USA|Alabama|test||

Scenario: User is updating  Area's Basic Info  page and  entered  value for 'Use in Address' that is different from the current value
a)User verifies existing 'Use in Address' values are retrieved  from trusted doc
b)User verifies 'Your Changes have been saved' message is displayed after save
c)User verifies Area Basic Info has been updated in confirmation modal
d)User verifies whether updated 'Use in Address' is reflecting in Area Web page
e)User verifies whether updated 'Use in Address' is reflecting in zeus document
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the <area> in the type-ahead box
And the user clicks on the area basic info link in the navigation bar
And the user clicks on the area update link
Then the user should see Use in address value is retrieved from trusted document
When the user gets the document with get document id for area with the <area> from the database
When the user clicks on <useInAddress> option for Area Use in Address
When the user clicks on the save button
Then the user should see the save confirmation modal
Then the user should see the below summary changes in confirmation modal
|Summary|
|Basic Info|
When the user clicks on the confirm button
Then the user should see the successful update message at top of the area page
Then the user should see the updated <useInAddress> in area web page
Then the user should see updated Use in address value in zeus document
Then the user reverts the changes to the document

Examples:
|country|area|useInAddress|
|Angola|Cabinda|False|

Scenario: User is updating  Area's Basic Info  page and  entered  value for 'Use in Address' that is no different from the current value
a)User verifies 'Your Changes have been saved' message is displayed after save
b)User verifies Area Basic Info has not been updated in confirmation modal
c)User verifies whether updated 'Use in Address' is reflecting in Area Web page
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the <area> in the type-ahead box
And the user clicks on the area basic info link in the navigation bar
And the user clicks on the area update link
When the user gets the document with get document id for area with the <area> from the database
When the user clicks on <useInAddress> option for Area Use in Address
When the user clicks on the save button
Then the user should not see the below summary changes in confirmation modal
|Summary|
|Basic Info|
When the user clicks on the confirm button
Then the user should see the successful update message at top of the area page
Then the user should see the updated <useInAddress> in area web page
Then the user should see updated Use in address value in zeus document
Then the user reverts the changes to the document

Examples:
|country|area|useInAddress|
|Angola|Cabinda|True|

Scenario: User views the Area basic page,selects the update button with subarea='Choose a Subarea'
1- User verifies whether the header dropdowns are disabled
2- User verifies the country dropdown is populating with header country value
3- User verifies the country list are in Alphabetical order
4- User verifies the Area parent list is empty
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the <area> in the type-ahead box
When the user clicks on the choose a sub-area option
When the user enters the sub-area <subArea> in the type-ahead box
And the user clicks on the area basic info link in the navigation bar
And the user clicks on the area update link
Then the user should verify the header dropdowns are disabled
Then the user should verify the country dropdown is populating with default country <country> as a option
Then the user should see all the list of existing countries by full name in Alphabetical order in area basic info page
Then user should not see the area parent dropdown

Examples:
|country|area|subArea|
|USA|Alabama|Choose a Subarea|

Scenario: User views the Area basic page,selects the update button with subarea
1- User verifies whether the header dropdowns are disabled
2- User verifies country dropdown is populating with header country value
3- User verifies the country list are in Alphabetical order
4- User verifies area parent dropdown is populating with header area value
5- User verifies the Area parent list are in Alphabetical order and list shows all areas related to the Country
6- User verifies Area parent option do not have 'No Area'
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the <area> in the type-ahead box
When the user clicks on the choose a sub-area option
When the user enters the sub-area <subArea> in the type-ahead box
And the user clicks on the area basic info link in the navigation bar
And the user clicks on the area update link
Then the user should verify the header dropdowns are disabled
Then the user should verify the country dropdown is populating with default country <country> as a option
Then the user should see all the list of existing countries by full name in Alphabetical order in area basic info page
Then the user should verify the parent area dropdown is populating with default area <area> as a option
When the user click on the choose an area parent option of area basic page
Then user should see the list of area parent options are pointing to selected <country> in area basic page
Then user verify the list of area parent options do not have No Area

Examples:
|country|area|subArea|
|USA|Alabama|Bibb|

Scenario: User views the area basic page,selects the update button with subarea = 'Choose a Subarea',changes the country2
User verifies whether the Area Parent value is defaulted with null
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the <area> in the type-ahead box
When the user clicks on the choose a sub-area option
When the user enters the sub-area <subArea> in the type-ahead box
And the user clicks on the area basic info link in the navigation bar
And the user clicks on the area update link
When user changes the <country2> in the country dropdownfield of area basic page
Then user should not see the area parent dropdown

Examples:
|country|area|subArea|country2|
|USA|Alabama|Choose a Subarea|India|

Scenario: User views the area basic page,selects the update button with subarea,changes the country2
1- User verifies whether Area parent showing default value as 'Choose an Area'
2- User verifies the Area parent is in Alphabetical order and list shows all areas related to country2
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the <area> in the type-ahead box
When the user clicks on the choose a sub-area option
When the user enters the sub-area <subArea> in the type-ahead box
And the user clicks on the area basic info link in the navigation bar
And the user clicks on the area update link
When user changes the <country2> in the country dropdownfield of area basic page
Then the user should verfiy that the 'Choose an Area' option is populated in the area parent dropdown
Then user should see the list of area parent options are refreshed pointing to selected <country2> in area basic info page

Examples:
|country|area|subArea|country2|
|USA|Alabama|Bibb|UK|

Scenario: User is updating a Areas's Basic Info and has set values for
each of 'Country','Area Parent','Sub Area',change the country2,'Area Parent'
1- User verifies the header dropdowns are updated with country2 and areaparent
2- User verifies Address bar url is updated with country2 and areaparent
3- User verifies Zeus DB whether the subarea is mapped under newly added country2 and areaparent
4- User verifies subarea is not mapped to country and area
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the <area> in the type-ahead box
When the user clicks on the choose a sub-area option
When the user enters the sub-area <subArea> in the type-ahead box
And the user clicks on the area basic info link in the navigation bar
And the user clicks on the area update link
When the user gets the document with get document id for subarea with the <subArea> from the database
When user changes the <country2> in the country dropdownfield of area basic page
Then user changes the area <areaParent> in the area dropdown field in area basic page
When the user clicks on the save button
Then the user should see the save confirmation modal
When the user clicks on the confirm button
Then the user should see the successful update message at top of the area page
Then the user checks whether the header dropdown updates with <country2>, <areaParent>, <subArea>
Then the user checks whether the Address bar url is updated  with <country2>, <areaParent>
Then the user verifies <subArea> is mapped to newly added <country2> and <areaParent> in zeus document
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a sub-area option
Then user should verify the subArea dropdown does not have subArea <subArea> value mapped to old country and area
Then the user reverts the changes to the document

Examples:
|country|area|subArea|country2|areaParent|
|USA|Alabama|Bibb|India|Tamil Nadu|


Scenario: User is updating a Areas's Basic Info and has set values for
each of 'Country' ,'Area','Sub Area' as 'Choose a Subarea',change the country
1-  User verifies the header dropdowns are updated with country2 and area
2 - User verifies the Zeus DB whether the area is mapped under newly added country2
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the <area> in the type-ahead box
When the user clicks on the choose a sub-area option
When the user enters the sub-area <subArea> in the type-ahead box
And the user clicks on the area basic info link in the navigation bar
And the user clicks on the area update link
When the user gets the document with get document id for area with the <area> from the database
When user changes the <country2> in the country dropdownfield of area basic page
When the user clicks on the save button
Then the user should see the save confirmation modal
When the user clicks on the confirm button
Then the user should see the successful update message at top of the area page
Then the user checks whether the header dropdown updates with <country2>, <area>
Then the user verifies <area> is mapped to newly added <country2> in zeus document
Then the user reverts the changes to the document

Examples:
|country|area|subArea|country2|
|USA|Alabama|Choose a Subarea|India|

Scenario: User is updating a Areas's Basic Info and has set values for
each of 'Country','Area Parent','Sub Area',change the 'country' with 'Area Parent' as 'Choose an Area'
1 - User verifies Area Parent dropdown is populated with 'Choose an area'
2 - User verifies the 'Area Parent' field is showing 'Required' validation message
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the <area> in the type-ahead box
When the user clicks on the choose a sub-area option
When the user enters the sub-area <subArea> in the type-ahead box
And the user clicks on the area basic info link in the navigation bar
And the user clicks on the area update link
When user changes the <country2> in the country dropdownfield of area basic page
Then user verify the list of area parent options do not have No Area
Then the user should verfiy that the 'Choose an Area' option is populated in the area parent dropdown
Then user changes the area <areaParent> in the area dropdown field in area basic page
When the user clicks on the save button
Then the user should see the Required error message for the required area parent field in the area basic page

Examples:
|country|area|subArea|country2|areaParent|
|USA|Alabama|Bibb|India|Choose an Area|
