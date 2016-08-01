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
JIRA ID - ZEUS-1041 - User can edit Area's Timezone

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

Scenario: User views the Area basic page,selects the update button and clicks on add new timezone button
1- User verifies the timezone dropdown shows all Hera IDs in the lookup matches with the timezone lookup
2- User verifies whether default value for timezone is blank
3- User verifies whether the current value in timezone is defaulted from trusted

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
Then the user clicks on add new timezone button
Then user verifies whether default value for timezone is blank
Then the user verifies whether timezone dropdown list shows all Hera IDs matches with the timezone lookup
Then user selects the timezone<timeZone> in the timezone dropdown of area basic page
When the user clicks on the save button
Then the user should see the save confirmation modal
When the user clicks on the confirm button
Then the user should see the successful update message at top of the area page
When the user clicks on the area update link
Then the user verifies the current value in timezone is defaulted from trusted
Then the user reverts the changes to the document

Examples:
|country|area|timeZone|
|USA|Alabama|+10:00|


Scenario: User is updating a Areas's Basic Info and has set values for 
each of 'Country','Area',clicks the add new timezone button and saves with empty timezone
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
Then the user clicks on add new timezone button
When the user clicks on the save button
Then the user should see the save confirmation modal
When the user clicks on the confirm button
Then the user should see the successful update message at top of the area page
Then the user verifies  whether the Area is not updated with the newly added timezone
Then the user verifies the zeus document whether the Area is not updated with the newly added timezone
Then the user reverts the changes to the document

Examples:
|country|area|
|USA|Alabama|


Scenario: User is updating a Areas's Basic Info and has set values for 
each of 'Country','Area',clicks the add new timezone button,selects 'timezone' value
1-User verifies whether the time zone list displays all time zone's except those that have been already selected for this area
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
Then the user clicks on add new timezone button
Then user selects the timezone<timeZone> in the timezone dropdown of area basic page
Then the user clicks on add new timezone button
Then user verifies whether timezone dropdown displays time zone's except selected timezone<timeZone>
Then user selects the timezone<timeZone1> in the timezone dropdown of area basic page
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


Scenario: User is updating a Areas's Basic Info and has set values for 
each of 'Country','Area',clicks the add new timezone button,updates the existing 'timezone' value
1- User verifies area is updated with newly updated timezone 'timezone'
2- User verifies Zeus DB whether the area is updated with newly updated timezone 'timezone'

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
Then user changes the <timeZone1> in the timezone dropdown of area basic page
When the user clicks on the save button
Then the user should see the save confirmation modal
When the user clicks on the confirm button
Then the user should see the successful update message at top of the area page
Then the user verifies  whether the Area is updated with the newly updated timezone
Then the user verifies the zeus document whether the Area is updated with the newly updated timezone
Then the user reverts the changes to the document

Examples:
|country|area|timeZone|timeZone1|
|USA|Alaska|+10:00|+11:00|

Scenario: User is updating a Areas's Basic Info and has set values for 
each of 'Country','Area',enters timezone summary as 'Null'
1- User verifies area is updated with newly added timezone summary
2- User verifies Zeus DB whether the area is updated with newly added timezone summary

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
Then the user verifies  whether the Area is updated with the newly added summary
Then the user verifies the zeus document whether the Area is updated with the newly added summary
Then the user reverts the changes to the document

Examples:
|country|area|summary|
|USA|Alabama||

Scenario: User is updating a Areas's Basic Info and has set values for 
each of 'Country','Area',user updates the existing timezone summary with new summary value
1- User verifies area is updated with newly updated timezone 'summary1' value
2- User verifies Zeus DB whether the area is updated with newly updated timezone 'summary1' value

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
Then the user enters the summary as <summary1>
When the user clicks on the save button
Then the user should see the save confirmation modal
When the user clicks on the confirm button
Then the user should see the successful update message at top of the area page
Then the user verifies  whether the Area is updated with the newly updated summary
Then the user verifies the zeus document whether the Area is updated with the newly updated summary
Then the user reverts the changes to the document

Examples:
|country|area|summary|summary1|
|USA|Alabama||Coordinated Universal Time|

Scenario: User is updating a Areas's Basic Info and has set values for 
each of 'Country','Area',enters the 'summary' value exceeding 100 unicode characters
1- User verifies the timezone 'summary' field is having max lenght attribute as '100'
2- User verifies the timezone 'summary' field is limited to '100' unicode characters

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
Then the user verifies summary max length attribute is 100
When the user clicks on the save button
Then the user should see the save confirmation modal
When the user clicks on the confirm button
Then the user should see the successful update message at top of the area page
Then the user verifies the summary field is limited to 100 unicode characters
Then the user reverts the changes to the document

Examples:
|country|area|summary|
|USA|Alabama|Coordinated Universal Time is the primary time standard by which the world regulates clocks and time1|

Scenario: User can edit area timezone and tries to delete the timezone before saving the area basic page 
1 - Verify if User can prevent deleting timezone by clicking on 'No'.
2 - Verify if User can delete timezone by clicking on 'Yes' , then after saving it should be removed.

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
When the user clicks on the choose a sub-area option
When the user clicks on the area basic info link in the navigation bar
And the user clicks on the area update link
When the user gets the document with get document id for area with the <area> from the database
Then the user clicks on add new timezone button
Then user selects the timezone<timeZone> in the timezone dropdown of area basic page
When the user clicks on the delete timezone row button in the basic info area page
Then the user should see delete row confirmation modal in the area basic page
When the user clicks on the No button to cancel the deletion of row in basic info area page
Then the user should see the newly added timezone row in the basic info area page
When the user clicks on the delete timezone row button in the basic info area page
Then the user should see delete row confirmation modal in the area basic page
When the user clicks on the Yes button to delete the row in basic info area page
When the user clicks on the save button
Then the user should see the save confirmation modal
When the user clicks on the confirm button
Then the user should see the successful update message at top of the area page
Then the user should not see the newly added timezone row in the basic info area page
Then the user verifies that the deleted row for area timezone does not exist in zeus document
Then the user reverts the changes to the document

Examples:
|country|area|timeZone|
|USA|Alabama|+10:00|

Scenario: User can edit area timezone and tries to delete the timezone after saving the area basic page
1 - Verify if User can prevent deleting timezone by clicking on 'No'.
2 - Verify if User can delete timezone by clicking on 'Yes' , then after saving it should be removed.

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
When the user clicks on the choose a sub-area option
When the user clicks on the area basic info link in the navigation bar
And the user clicks on the area update link
When the user gets the document with get document id for area with the <area> from the database
Then the user clicks on add new timezone button
Then user selects the timezone<timeZone> in the timezone dropdown of area basic page
When the user clicks on the save button
Then the user should see the save confirmation modal
When the user clicks on the confirm button
Then the user should see the successful update message at top of the area page
When the user clicks on the area update link
When the user clicks on the delete timezone row button in the basic info area page
Then the user should see delete row confirmation modal in the area basic page
When the user clicks on the No button to cancel the deletion of row in basic info area page
Then the user should see the newly added timezone row in the basic info area page
When the user clicks on the save button
When the user clicks on the confirm button
Then the user verifies that the newly added timezone row values exists in the basic info area page
Then the user verifies that the row values for area timezone entered exists in zeus document
When the user clicks on the area update link
When the user clicks on the delete timezone row button in the basic info area page
Then the user should see delete row confirmation modal in the area basic page
When the user clicks on the Yes button to delete the row in basic info area page
When the user clicks on the save button
Then the user should see the save confirmation modal
When the user clicks on the confirm button
Then the user should see the successful update message at top of the area page
Then the user should not see the newly added timezone row in the basic info area page
Then the user verifies that the deleted row for area timezone does not exist in zeus document
Then the user reverts the changes to the document

Examples:
|country|area|timeZone|
|USA|Alabama|+10:00|
