Meta: @EditAreaBasicInfo @Edit @Area @AllStories

Narrative:
In order to view and edit the area page
As a user
I want to cover the requirements mentioned in

JIRA ID - ZEUS-1025 - User can edit Area's Status
JIRA ID - ZEUS-1027 - User can edit Area's End Date

JIRA ID - ZEUS-1026 - User can edit Area's Began Date
JIRA ID - ZEUS-1034 - User can edit Area's Add Info
JIRA ID - ZEUS-1031 - User can edit Area's Country & Area Parent


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
Then the user should see the status value in area page is same as in trusted document

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
Then user should see the list of area parent options in area page is Empty

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
Then user verify the list of area pareant options do not have No Area

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
Then user should see the list of area parent options in Area page is Empty

Examples:
|country|area|subArea|country2|
|USA|Alabama|Choose a Subarea|India|

Scenario: User views the area basic page,selects the update button with subarea,changes the country2 
1- User verifies whether Area parent showing default value as 'Choose an Area' 
2- User verifies the Area parent is in Alphabetical order and list shows all areas related to the country2

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
|USA|Alabama|Bibb|India|

Scenario: User is updating a Areas's Basic Info and has set values for 
each of 'Country' ,'Area Parent','Sub Area',change the country2,'Area Parent'
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
Then user should see the list of area parent options in Area page is Empty
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
each of 'Country' ,'Area Parent','Sub Area',change the 'country' with 'Area Parent' as 'Choose an Area'
1 - User verifies Area Parent dropdown is populated with Choose and area 
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
Then user verify the list of area pareant options do not have No Area
Then the user should verfiy that the 'Choose an Area' option is populated in the area parent dropdown
Then user changes the area <areaParent> in the area dropdown field in area basic page
When the user clicks on the save button
Then the user should see the Required error message for the required identifier type field in the area basic page

Examples:
|country|area|subArea|country2|areaParent|
|USA|Alabama|Bibb|India|Choose an Area|
