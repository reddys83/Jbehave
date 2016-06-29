Meta: @EditAreaBasicInfo @Edit @Area @AllStories

Narrative:
In order to view and edit the area page
As a user
I want to cover the requirements mentioned in

JIRA ID - ZEUS-1026 - User can edit Area's Began Date


Scenario: User can edit area Began Date - 
a)Verify if user can see all the months in month dropdown (Began Date) are in MMM format
b)Verify if user can see that all the months are sorted as per chronological order
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

Examples:
|country|area|
|Angola|Cabinda|

Scenario: User can edit Area Began Date - Verify if User can see Current value of the Month,Day & Year is retrieved from trusted document.

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
When the user clicks on the area basic info link in the navigation bar
And the user clicks on the area update link
Then the user should see area began date value same as in trusted document

Examples:
|country|area|
|Angola|Cabinda|


Scenario: User can edit area Began Date - User has entered an 'Began Date' that is different from the current value, verify if
a)User can see Success message in Area Page
b)User can see entered values updated in Area Page
c)User can see entered values updated in Zeus document
d)User can see Basic info changes are updated in Confirmation Modal

Meta: @EditAreaWithValidBeganDates

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
Then the user should see the successful update message at top of the area page
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
Then the user should see the successful update message at top of the area page
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

Meta: @EditAreaWithValidBeganDates

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
Then the user should see the successful update message at top of the area page
Then the user should see the entered <day> <month> <year> in area page
Then the user should see the area began date <day> <month> <year> value in zeus document
Then the user reverts the changes to the document


Examples:
|country|area|day|month|year|
|Angola|Cabinda|||2016|
|Angola|Cabinda||Jun|2015|
|Angola|Cabinda|05|Jun|2015|

Scenario: User can edit area Began Date - Verify if User can see Began date getting saved in Area Page & Zeus document  when Day,Month & Year are entered as blank values

Meta: @EditAreaWithBlankBeganDates

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
Then the user should see the successful update message at top of the area page
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

Meta: @EditAreaWithSameBeganDates

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
Then the user should see the successful update message at top of the area page
When the user clicks on the area update link
When the user enters began date day <day> in the edit basic info area page
When the user enters began date month <month> in the edit basic info area page
When the user enters began date year <year> in the edit basic info area page
When the user clicks on the save button
Then the user should not see the <ConfirmationSummary> changes in confirmation modal for area
When the user clicks on the confirm button
Then the user should see the successful update message at top of the area page
Then the user should see the entered <day> <month> <year> in area page
Then the user should see the area began date <day> <month> <year> value in zeus document
Then the user reverts the changes to the document

Examples:
|country|area|day|month|year|ConfirmationSummary|
|Angola|Cabinda|06|Jun|2016|Summary|

