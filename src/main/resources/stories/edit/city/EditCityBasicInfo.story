Meta: @EditCityBasicInfo @Edit @City @AllStories

Narrative:
In order to view and edit the city page
As a user
I want to cover the requirements mentioned in
JIRA ID - ZEUS-964 -User can edit City's End Date

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
|Afghanistan|Badakshan|Badakhshan|1|June|2016|1|June|2015|Basic Info|Must be after Began date.| 

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