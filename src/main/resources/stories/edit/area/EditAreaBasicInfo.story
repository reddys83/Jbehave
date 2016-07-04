Meta: @EditAreaBasicInfo @Edit @Area @AllStories


Narrative:
In order to view and edit the area page
As a user
I want to cover the requirements mentioned in

JIRA ID - ZEUS-1027 - User can edit Area's End Date


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


