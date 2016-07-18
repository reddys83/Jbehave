Meta: @EditAreaBasicInfo @Edit @Area @AllStories


Narrative:
In order to view and edit the area page
As a user
I want to cover the requirements mentioned in

JIRA ID - ZEUS-1025 - User can edit Area's Status
JIRA ID - ZEUS-1027 - User can edit Area's End Date

JIRA ID - ZEUS-1026 - User can edit Area's Began Date
JIRA ID - ZEUS-1173 - Error handling when error is in section not currently displayed


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