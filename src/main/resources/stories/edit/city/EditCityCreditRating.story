Meta: @EditCityCreditRating @Edit @City @AllStories

Narrative:
In order to view and edit the city page
As a user
I want to cover the requirements mentioned in

JIRA ID - ZEUS-973 - User can view City Credit Ratings

Scenario: Verifying the credit rating agencies are from LookUp 'CREDIT_RATING_AGENCY'
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
When the user clicks on the city credit rating link in the navigation bar
And the user clicks on the update link
When the user clicks on add new credit rating button in the credit rating city page
And the user clicks on the Agency names drop-down in the basicinfo city page
Then the user should see the city Agency names from look up CREDIT_RATING_AGENCY
When the user clicks on the Agency types drop-down in the basicinfo city page
Then the user should see the city Agency types from look up CREDIT_RATING_TYPE

Examples:
|country|area|city|
|USA|Alabama|Alexander City|

Scenario: User has selected to add a credit rating and set values for all fields, verifies the Zeus app and DB.
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
When the user clicks on the city credit rating link in the navigation bar
And the user clicks on the update link
Then the user should see the city credit rating values same as in trusted document
When the user gets the document with get document id for city with the <city> from the database
When the user clicks on add new credit rating button in the credit rating city page
When the user enters credit rating agency as <agency> in the basic info city page
When the user enters credit rating type as <type> in the basic info city page
When the user enters credit rating <value> in the basic info city page
And the user enters applied date day 15 Jan 2016 in the credit rating city page
And the user enters confirmed date day 17 Jan 2016 in the credit rating city page
When the user clicks on the save button
And the user clicks on the confirm button
Then the user should see the successful update message at top of the page
Then the user should see the city credit rating values as in zeus document
Then the user reverts the changes to the document

Examples:
|country|area|city|agency|type|value|appliedDate|confirmedDate|row|
|USA|Alabama|Alexander City|Standard & Poors|Long Term Rating|1234|15 Jan 2016|17 Jan 2016|1|


Scenario: User has selected to update the existing credit rating row, verifies the Zeus app and DB.
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
When the user clicks on the city credit rating link in the navigation bar
And the user clicks on the update link
When the user gets the document with get document id for city with the <city> from the database
When the user deletes the existing credit rating rows
When the user clicks on add new credit rating button in the credit rating city page
When the user enters credit rating agency as <agency> in the basic info city page
When the user enters credit rating type as <type> in the basic info city page
When the user enters credit rating <value> in the basic info city page
When the user clicks on the save button
And the user clicks on the confirm button
Then the user should see the successful update message at top of the page
When the user clicks on the update link
When the user clicks on add new credit rating button in the credit rating city page
When the user enters credit rating agency as <agency2> in the basic info city page
When the user enters credit rating type as <type2> in the basic info city page
When the user enters credit rating <value2> in the basic info city page
And the user enters applied date day 14 Jan 2016 in the credit rating city page
And the user enters confirmed date day 17 Jan 2016 in the credit rating city page
When the user clicks on the save button
And the user clicks on the confirm button
Then the user should see the successful update message at top of the page
Then the user should see the updated city credit rating values as in zeus document
Then the user reverts the changes to the document

Examples:
|country|area|city|agency|type|value|agency2|type2|value2|appliedDate|confirmedDate|row|
|USA|Alabama|Alexander City|Standard & Poors|Long Term Rating|1234|Moody's|Long Term Sovereign Debt Rating|12457|14 Jan 2016|17 Jan 2016|0|

Scenario: User has selected to add credit rating row and saving without entering any values, it should be saved successfully.
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
When the user clicks on the city credit rating link in the navigation bar
And the user clicks on the update link
When the user gets the document with get document id for city with the <city> from the database
When the user deletes the existing credit rating rows
When the user clicks on add new credit rating button in the credit rating city page
When the user enters credit rating agency as <agency> in the basic info city page
When the user enters credit rating type as <type> in the basic info city page
When the user clicks on the save button
And the user clicks on the confirm button
Then the user should see the successful update message at top of the page
Then the user reverts the changes to the document

Examples:
|country|area|city|
|USA|Alabama|Alexander City|

Scenario: User has selected to add credit rating row and entering one of the agency dropdown value, error message should be thrown while saving
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
When the user clicks on the city credit rating link in the navigation bar
And the user clicks on the update link
When the user deletes the existing credit rating rows
When the user clicks on add new credit rating button in the credit rating city page
When the user enters credit rating agency as <agency> in the basic info city page
When the user enters credit rating type as <type> in the basic info city page
When the user clicks on the save button
Then user should see Required error message in credit rating type field
Then the user should be able to view the error message Enter up to 5 valid characters. in credit rating value

Examples:
|country|area|city|agency|type|row|
|USA|Alabama|Alexander City|Standard & Poors||0|

Scenario: User has selected to add credit rating row and entering credit rating type dropdown value, error message should thrown while saving
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
When the user clicks on the city credit rating link in the navigation bar
And the user clicks on the update link
When the user deletes the existing credit rating rows
When the user clicks on add new credit rating button in the credit rating city page
When the user enters credit rating agency as <agency> in the basic info city page
When the user enters credit rating type as <type> in the basic info city page
When the user clicks on the save button
Then user should see Required error message in credit rating agency field
Then the user should be able to view the error message Enter up to 5 valid characters. in credit rating value


Examples:
|country|area|city|agency|type|row|
|USA|Alabama|Alexander City||Long Term Rating|0|

Scenario: Verifying Verify error message enter a year, month/year or day/month/year for applied date
1. only day
2. only day and month
3. only day and year
4. only month

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
When the user clicks on the city credit rating link in the navigation bar
And the user clicks on the update link
When the user clicks on add new credit rating button in the credit rating city page
And the user enters applied date day <appliedDay> in the credit rating city page
And the user selects applied date month <appliedMonth> in the credit rating city page
And the user enters applied date year <appliedYear> in the credit rating city page
When the user clicks on the save button
Then the user should see the error message at top of page the highlighted fields must be addressed before this update can be saved
And the user should see the error message enter a year, month/year or day/month/year for applied date in the credit rating city page

Examples:
|country|area|city|appliedDay|appliedMonth|appliedYear|row|
|USA|Alabama|Alexander City|15|||0|
|USA|Alabama|Alexander City|15|Jan||0|
|USA|Alabama|Alexander City|15||2016|0|
|USA|Alabama|Alexander City||Jan||0|
|USA|Alabama|Alexander City|abc||abc|0|


Scenario: Verifying Verify error message enter a year, month/year or day/month/year for confirmed date
1. only day
2. only day and month
3. only day and year
4. only month

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
When the user clicks on the city credit rating link in the navigation bar
And the user clicks on the update link
When the user deletes the existing credit rating rows
When the user clicks on add new credit rating button in the credit rating city page
And the user enters confirmed date day <confirmedDay> in the credit rating city page
And the user selects confirmed date month <confirmedMonth> in the credit rating city page
And the user enters confirmed date year <confirmedYear> in the credit rating city page
When the user clicks on the save button
Then the user should see the error message at top of page the highlighted fields must be addressed before this update can be saved
And the user should see the error message enter a year, month/year or day/month/year for confirmed date in the credit rating country page

Examples:
|country|area|city|confirmedDay|confirmedMonth|confirmedYear|row|
|USA|Alabama|Alexander City|15|||0|
|USA|Alabama|Alexander City|15|Jan||0|
|USA|Alabama|Alexander City|15||2016|0|
|USA|Alabama|Alexander City||Jan||0|


Scenario: User can edit city identifiers- Verify if User can delete credit rating by clicking on 'Yes' , then after saving it should be removed.

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
When the user clicks on the city credit rating link in the navigation bar
And the user clicks on the city update link
When the user clicks on add new credit rating button in the credit rating city page
When the user clicks on the delete credit rating row button in the basic info city page
Then the user should see delete row confirmation modal in credit rating
When the user clicks on the Yes button to cancel the deletion of row
Then the user should not see the newly added credit rating row in the basic info city page


Examples:
|country|area|city|row|
|Chad|No Area|Doba|0|

Scenario: User can edit city identifiers- Verify if User can delete credit rating by clicking on 'cancel', then after saving the identifier should not get deleted.
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
When the user clicks on the city credit rating link in the navigation bar
And the user clicks on the city update link
When the user clicks on add new credit rating button in the credit rating city page
When the user enters credit rating agency as <agency> in the basic info city page
When the user enters credit rating type as <type> in the basic info city page
When the user enters credit rating <value> in the basic info city page
And the user enters applied date day 15 Jan 2016 in the credit rating city page
And the user enters confirmed date day 17 Jan 2016 in the credit rating city page
When the user clicks on the save button
And the user clicks on the confirm button
Then the user should see the successful update message at top of the page
When the user clicks on the city update link
When the user clicks on the delete credit rating row button in the basic info city page
Then the user should see delete row confirmation modal in credit rating
When the user clicks on the No button to cancel the deletion of row
Then the user should see the newly added credit rating row in the basic info city page

Examples:
|country|area|city|agency|type|value|appliedDate|confirmedDate|row|
|USA|Alabama|Alexander City|Standard & Poors|Long Term Rating|1234|14 Jan 2016|17 Jan 2016|0|
