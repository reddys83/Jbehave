Meta: @EditAreaCreditRating @Edit @Area @AllStories

Narrative:
In order to view and edit the area page
As a user
I want to cover the requirements mentioned in

JIRA ID - ZEUS-1046 - User can edit Area Credit Ratings

Scenario: User is viewing and updating a Area's Credit Ratings
a) User verifies Agency and Type values are same as in trusted document.
b) User verifies Agency and Type values are from CREDIT_RATING_AGENCY and CREDIT_RATING_TYPE look up respectively.
c) User verifies the existing values are updating correctly in UI and Zeus.

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
When the user clicks on the area credit rating link in the navigation bar
And the user clicks on the area update link
When the user gets the document with get document id for area with the <area> from the database
Then the user should see the area credit rating values same as in trusted document
Then the user should see the area credit rating agency names from look up CREDIT_RATING_AGENCY
Then the user should see the area credit rating types from look up CREDIT_RATING_TYPE
When the user enters credit rating agency as <agency> in credit rating row <rowNumber> in the area page
When the user enters credit rating type as <type> in credit rating row <rowNumber> in the area page
When the user enters credit rating <value> in credit rating row <rowNumber> in the area page
And the user enters applied date day <appliedDay> <appliedMonth> <appliedYear> in the area page
And the user enters confirmed date day <confirmedDay> <confirmedMonth> <confirmedYear> in the area page
When the user clicks on the save button
Then the user should see the below summary changes in confirmation modal
|Summary|
|Credit Ratings|
When the user clicks on the confirm button
Then the user should see the successful update message at top of the area page
Then the user should see the entered area credit rating values are saved in UI in the row <rowNumber>
Then the user should see the area credit rating values as in zeus document
Then the user reverts the changes to the document

Examples:
|country|area|agency|type|value|appliedDay|appliedMonth|appliedYear|confirmedDay|confirmedMonth|confirmedYear|rowNumber|
|USA|Alabama|Fitch|Long Term Rating|abcd|30|Jan|2015|30|Jan|2016|2|
|USA|Alabama|Fitch|Long Term Rating|abcd|30|Jan|2015|30|Jan|2016|3|

Scenario: User is updating a Area's Credit Ratings - 
a) User adds a new row and enters blank values for all fields for Credit Ratings and verifies that the new row is not added after saving.
b) User verifies that UI and Zeus are updated correctly.

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
When the user clicks on the area credit rating link in the navigation bar
And the user clicks on the area update link
When the user gets the document with get document id for area with the <area> from the database
When the user deletes the existing area credit rating rows
When the user clicks on add new credit rating button in the credit rating area page
When the user enters credit rating agency as <agency> in credit rating row <rowNumber> in the area page
When the user enters credit rating type as <type> in credit rating row <rowNumber> in the area page
When the user enters credit rating <value> in credit rating row <rowNumber> in the area page
And the user enters applied date day <appliedDay> <appliedMonth> <appliedYear> in the area page
And the user enters confirmed date day <confirmedDay> <confirmedMonth> <confirmedYear> in the area page
When the user clicks on the save button
When the user clicks on the confirm button
Then the user should see the successful update message at top of the area page
Then the user should not see the newly added credit rating row in the area page
Then the user should not see the area credit rating row in zeus document
Then the user reverts the changes to the document

Examples:
|country|area|agency|type|value|appliedDay|appliedMonth|appliedYear|confirmedDay|confirmedMonth|confirmedYear|rowNumber|
|USA|Alabama||||||||||1|

Scenario: User is updating a Area's Credit Ratings - User adds a new row 
a) User verifies the error message 'Required' for 'Agency' field when no value is entered.
b) User verifies the error message 'Required' for 'Type' field when no value is entered.
c) User verifies the error message 'Enter up to 5 valid characters.' for 'Value' field when when no value is entered.
d) Verifying error message 'Enter a day/month/year.' for 'Applied Date' and 'Confirmed Date' field by entering
   1. only day
   2. only day and month
   3. only day and year
   4. only month

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
When the user clicks on the area credit rating link in the navigation bar
And the user clicks on the area update link
When the user deletes the existing area credit rating rows
When the user clicks on add new credit rating button in the credit rating area page
And the user enters applied date day <appliedDay> <appliedMonth> <appliedYear> in the area page
And the user enters confirmed date day <confirmedDay> <confirmedMonth> <confirmedYear> in the area page
When the user clicks on the save button
Then the user should see Required error message in area credit rating agency field
Then the user should see Required error message in area credit rating type field
Then the user should be able to view the error message Enter up to 5 valid characters. in area credit rating value
Then the user should see the error message Enter a day/month/year. for applied date in the area page
Then the user should see the error message Enter a day/month/year. for confirmed date in the area page

Examples:
|country|area|appliedDay|appliedMonth|appliedYear|confirmedDay|confirmedMonth|confirmedYear|rowNumber|
|USA|Alabama|15|||15|||1|
|USA|Alabama|15|Jan||15|Jan||1|
|USA|Alabama|15||2016|15||2016|1|
|USA|Alabama||Jan|||Jan||1|

Scenario: User is updating a Area's Credit Ratings - 
a) User verifies error message 'Invalid Date' for a date which is not in Gregorian Calendar format.
b) User verifies error message 'Must be no later than today.' for a date which is later than today.

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
When the user clicks on the area credit rating link in the navigation bar
And the user clicks on the area update link
When the user deletes the existing area credit rating rows
When the user clicks on add new credit rating button in the credit rating area page
And the user enters applied date day <appliedDay> <appliedMonth> <appliedYear> in the area page
And the user enters confirmed date day <confirmedDay> <confirmedMonth> <confirmedYear> in the area page
When the user clicks on the save button
Then the user should see the error message Invalid Date for applied date in the area page
Then the user should see the error message Invalid Date for confirmed date in the area page
When the user enters applied date and confirmed date that is later than today
When the user clicks on the save button
Then the user should see the error message Must be no later than today. for applied date in the area page
Then the user should see the error message Must be no later than today. for confirmed date in the area page

Examples:
|country|area|appliedDay|appliedMonth|appliedYear|confirmedDay|confirmedMonth|confirmedYear|rowNumber|
|USA|Alabama|15|Dec|abcd|15|Dec|abcd|1|

Scenario: User is adding/deleting new Area's Credit Ratings -
1 - Verify if User can prevent deleting credit rating row by clicking on 'No'.
2 - Verify if User can delete credit rating row by clicking on 'Yes' , then after saving it should be removed.
3 - User verifies that UI and Zeus document is updated.

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
When the user clicks on the area credit rating link in the navigation bar
And the user clicks on the area update link
When the user gets the document with get document id for area with the <area> from the database
When the user deletes the existing area credit rating rows
When the user clicks on add new credit rating button in the credit rating area page
When the user enters credit rating agency as <agency> in credit rating row <rowNumber> in the area page
When the user enters credit rating type as <type> in credit rating row <rowNumber> in the area page
When the user enters credit rating <value> in credit rating row <rowNumber> in the area page
And the user enters applied date day <appliedDay> <appliedMonth> <appliedYear> in the area page
And the user enters confirmed date day <confirmedDay> <confirmedMonth> <confirmedYear> in the area page
When the user clicks on the save button
When the user clicks on the confirm button
And the user clicks on the area update link
When the user clicks on the delete credit rating row button in the area credit rating page
Then the user should see delete row confirmation modal in the area credit rating
When the user clicks on the No button to cancel the deletion of credit rating row
Then the user should see the newly added credit rating row in the area credit rating page
When the user clicks on the delete credit rating row button in the area credit rating page
When the user clicks on the Yes button to delete credit rating row
When the user clicks on the save button
When the user clicks on the confirm button
Then the user should see the successful update message at top of the area page
Then the user should not see the newly added credit rating row in the area page
Then the user should not see the area credit rating row in zeus document
Then the user reverts the changes to the document

Examples:
|country|area|agency|type|value|appliedDay|appliedMonth|appliedYear|confirmedDay|confirmedMonth|confirmedYear|rowNumber|
|USA|Alabama|Fitch|Long Term Rating|abc|30|Jan|2015|30|Jan|2016|1|