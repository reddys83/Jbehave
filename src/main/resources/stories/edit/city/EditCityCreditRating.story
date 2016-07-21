Meta: @EditCityCreditRating @Edit @City @AllStories

Narrative:
In order to view and edit the city page
As a user
I want to cover the requirements mentioned in

JIRA ID - ZEUS-973 - User can view City Credit Ratings

Scenario: Verify City's Credit Ratings Agency and Type dropdown values are
from lookup CREDIT_RATING_AGENCY and CREDIT_RATING_TYPE respectively in the same order as taxonomy
a) Verify for an existing CreditRating's row, the Credit Rating's Agency values are from CREDIT_RATING_AGENCY
b) Verify for an existing CreditRating's row, the Credit Rating's Type values are from CREDIT_RATING_TYPE
c) Verify for a new CreditRating's row, the Credit Rating's Agency values are from CREDIT_RATING_AGENCY
d) Verify for a new CreditRating's row, the Credit Rating's Type values are from CREDIT_RATING_TYPE

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
And the user clicks on the city update link
Then the user should see the city Agency names from look up CREDIT_RATING_AGENCY in existing creditRating row $rowNumber
Then the user should see the city Agency types from look up CREDIT_RATING_TYPE in existing creditRating row $rowNumber
When the user deletes the existing credit rating rows
When the user clicks on add new credit rating button in the credit rating city page
Then the user should see the city Agency names from look up CREDIT_RATING_AGENCY in new creditRating row $rowNumber
Then the user should see the city Agency types from look up CREDIT_RATING_TYPE in new creditRating row $rowNumber

Examples:
|country|area|city|rowNumber|
|USA|Montana|Belt|1|

Scenario: Update and Save existing credit ratings
a) User selects a new value for Agency, Type, Value, Applied Date and Confirmed Date and click Save. Updated Credit rating should be saved in Zeus document
b) User selects a new value for Agency, Type, Value and no values for Applied Date and Confirmed Date and click Save. Updated Credit rating should be saved in Zeus document

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
When the user clicks on the city update link
Then the user should see the city credit rating values same as in trusted document
When the user gets the document with get document id for city with the <city> from the database
When the user enters credit rating agency as <agency> in credit rating row $rowNumber in the basic info city page
When the user enters credit rating type as <type> in credit rating row $rowNumber in the basic info city page
When the user enters credit rating <value> in credit rating row $rowNumber in the basic info city page
And the user enters applied date day <appliedDay> <appliedMonth> <appliedYear> in the credit rating city page
And the user enters confirmed date day <confirmedDay> <confirmedMonth> <confirmedYear> in the credit rating city page
When the user clicks on the save button
When the user clicks on the confirm button
Then the user should see the successful update message at top of the page
Then the user should see the city credit rating values as in zeus document
Then the user should see the entered city credit rating values are saved in UI in the row number <rowNumber>
Then the user reverts the changes to the document

Examples:
|country|area|city|agency|type|value|appliedDay|appliedMonth|appliedYear|confirmedDay|confirmedMonth|confirmedYear|rowNumber|
|USA|Montana|Belt|Standard & Poors|Long Term Rating|1234|||||||1|
|USA|Montana|Belt|Standard & Poors|Long Term Rating|1234|15|Jan|2016|17|Jan|2016|1|


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
And the user clicks on the city update link
When the user gets the document with get document id for city with the <city> from the database
When the user deletes the existing credit rating rows
When the user clicks on add new credit rating button in the credit rating city page
When the user enters credit rating agency as <agency> in credit rating row $rowNumber in the basic info city page
When the user enters credit rating type as <type> in credit rating row $rowNumber in the basic info city page
When the user enters credit rating <value> in credit rating row $rowNumber in the basic info city page
When the user clicks on the save button
And the user clicks on the confirm button
Then the user should see the successful update message at top of the page
When the user clicks on the update link
When the user enters credit rating agency as <agency2> in credit rating row $rowNumber in the basic info city page
When the user enters credit rating type as <type2> in credit rating row $rowNumber in the basic info city page
When the user enters credit rating <value2> in credit rating row $rowNumber in the basic info city page
And the user enters applied date day <appliedDay> <appliedMonth> <appliedYear> in the credit rating city page
And the user enters confirmed date day <confirmedDay> <confirmedMonth> <confirmedYear> in the credit rating city page
When the user clicks on the save button
Then the user should see the below summary changes in confirmation modal
|Summary|
|Credit Ratings|
When the user clicks on the confirm button
Then the user should see the successful update message at top of the page
Then the user should see the updated city credit rating values as in zeus document
Then the user should see the entered city credit rating values are updated in UI in the row number $rowNumber
Then the user reverts the changes to the document

Examples:
|country|area|city|agency|type|value|agency2|type2|value2|appliedDay|appliedMonth|appliedYear|confirmedDay|confirmedMonth|confirmedYear|rowNumber|
|USA|Montana|Belt|Standard & Poors|Long Term Rating|1234|Moody's|Long Term Sovereign Debt Rating|12457|15|Jan|2016|17|Jan|2016|1|

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
And the user clicks on the city update link
When the user gets the document with get document id for city with the <city> from the database
When the user deletes the existing credit rating rows
When the user clicks on add new credit rating button in the credit rating city page
When the user enters credit rating agency as <agency> in credit rating row $rowNumber in the basic info city page
When the user enters credit rating type as <type> in credit rating row $rowNumber in the basic info city page
When the user enters credit rating <value> in credit rating row $rowNumber in the basic info city page
When the user clicks on the save button
And the user clicks on the confirm button
Then the user should see the successful update message at top of the page
Then the user reverts the changes to the document

Examples:
|country|area|city|agency|type|value|rowNumber|
|USA|Montana|Belt||||1|

Scenario: User has selected to add credit rating row and entering one of the agency dropdown and also value, error message should be thrown while saving

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
And the user clicks on the city update link
When the user deletes the existing credit rating rows
When the user clicks on add new credit rating button in the credit rating city page
When the user enters credit rating agency as <agency> in credit rating row $rowNumber in the basic info city page
When the user enters credit rating type as <type> in credit rating row $rowNumber in the basic info city page
When the user enters credit rating <value> in credit rating row $rowNumber in the basic info city page
When the user clicks on the save button
Then user should see Required error message in credit rating type field

Examples:
|country|area|city|agency|type|value|rowNumber|
|USA|Montana|Belt|Standard & Poors||789|1|

Scenario: User has selected to add credit rating row and entering credit rating type dropdown and also value, error message should thrown while saving
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
And the user clicks on the city update link
When the user deletes the existing credit rating rows
When the user clicks on add new credit rating button in the credit rating city page
When the user enters credit rating agency as <agency> in credit rating row $rowNumber in the basic info city page
When the user enters credit rating type as <type> in credit rating row $rowNumber in the basic info city page
When the user enters credit rating <value> in credit rating row $rowNumber in the basic info city page
When the user clicks on the save button
Then user should see Required error message in credit rating agency field


Examples:
|country|area|city|agency|type|value|rowNumber|
|USA|Montana|Belt||Long Term Rating|789|1|

Scenario: User has selected to add credit rating row and entering one of the agency dropdown and also type dropdown, error message should be thrown while saving
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
And the user clicks on the city update link
When the user deletes the existing credit rating rows
When the user clicks on add new credit rating button in the credit rating city page
When the user enters credit rating agency as <agency> in credit rating row $rowNumber in the basic info city page
When the user enters credit rating type as <type> in credit rating row $rowNumber in the basic info city page
When the user enters credit rating <value> in credit rating row $rowNumber in the basic info city page
When the user clicks on the save button
Then the user should be able to view the error message Enter up to 5 valid characters. in credit rating value

Examples:
|country|area|city|agency|type|value|rowNumber|
|USA|Montana|Belt|Standard & Poors|Long Term Rating||1|

Scenario: Verifying error message enter a day/month/year for applied date
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
And the user clicks on the city update link
When the user clicks on add new credit rating button in the credit rating city page
And the user enters applied date day <appliedDay> in the credit rating city page
And the user selects applied date month <appliedMonth> in the credit rating city page
And the user enters applied date year <appliedYear> in the credit rating city page
When the user clicks on the save button
Then the user should see the error message at top of page the highlighted fields must be addressed before this update can be saved
And the user should see the error message enter a day/month/year for applied date in the credit rating city page

Examples:
|country|area|city|appliedDay|appliedMonth|appliedYear|rowNumber|
|USA|Montana|Belt|15|||1|
|USA|Montana|Belt|15|Jan||1|
|USA|Montana|Belt|15||2016|1|
|USA|Montana|Belt||Jan||1|


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
And the user clicks on the city update link
When the user deletes the existing credit rating rows
When the user clicks on add new credit rating button in the credit rating city page
And the user enters confirmed date day <confirmedDay> in the credit rating city page
And the user selects confirmed date month <confirmedMonth> in the credit rating city page
And the user enters confirmed date year <confirmedYear> in the credit rating city page
When the user clicks on the save button
Then the user should see the error message at top of page the highlighted fields must be addressed before this update can be saved
And the user should see the error message enter a day/month/year for confirmed date in the credit rating city page

Examples:
|country|area|city|confirmedDay|confirmedMonth|confirmedYear|rowNumber|
|USA|Montana|Belt|15|||1|
|USA|Montana|Belt|15|Jan||1|
|USA|Montana|Belt|15||2016|1|
|USA|Montana|Belt||Jan||1|

Scenario: Verify that Applied Date and Confirmed Date can not be later than today

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
And the user enters applied date that is later than today
And the user enters confirmed date that is later than today
When the user clicks on the save button
Then the user should see the error message at top of page the highlighted fields must be addressed before this update can be saved
Then the user should see the error text Must be no later than today. for applied date in the credit rating city page
Then the user should see the error text Must be no later than today. for confirmed date in the credit rating city page

Examples:
|country|area|city|row|
|USA|Montana|Belt|1|

Scenario: User updates invalid Applied date and Confirmed date
Verifying error message displaying Invalid Date when invalid date entered

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
And the user enters confirmed date day <confirmedDay> in the credit rating city page
And the user selects confirmed date month <confirmedMonth> in the credit rating city page
And the user enters confirmed date year <confirmedYear> in the credit rating city page
When the user clicks on the save button
Then the user should see the error message at top of page the highlighted fields must be addressed before this update can be saved
Then the user should see the error text Invalid Date for applied date in the credit rating city page
Then the user should see the error text Invalid Date for confirmed date in the credit rating city page

Examples:
|country|area|city|appliedDay|appliedMonth|appliedYear|confirmedDay|confirmedMonth|confirmedYear|rowNumber|
|USA|Montana|Belt|15|Dec|abcd|15|Dec|abcd|1|

Scenario: User can edit city identifiers- Verify if User can delete credit rating by clicking on 'Yes' , then after saving it should be removed.
Meta:@test88
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
When the user clicks on the city update link
When the user gets the document with get document id for city with the <city> from the database
When the user deletes the existing credit rating rows
When the user clicks on add new credit rating button in the credit rating city page
When the user enters credit rating agency as <agency> in credit rating row $rowNumber in the basic info city page
When the user enters credit rating type as <type> in credit rating row $rowNumber in the basic info city page
When the user enters credit rating <value> in credit rating row $rowNumber in the basic info city page
And the user enters applied date day <appliedDay> <appliedMonth> <appliedYear> in the credit rating city page
And the user enters confirmed date day <confirmedDay> <confirmedMonth> <confirmedYear> in the credit rating city page
When the user clicks on the save button
And the user clicks on the confirm button
Then the user should see the successful update message at top of the page
When the user clicks on the city update link
When the user clicks on the delete credit rating row button in the basic info city page
Then the user should see delete row confirmation modal in credit rating
When the user clicks on the Yes button to cancel the deletion of row
When the user clicks on the save button
And the user clicks on the confirm button
Then the user should see the successful update message at top of the page
Then the user should not see the newly added credit rating row in the basic info city page
Then the user should not see the city credit rating values in zeus document
Then the user reverts the changes to the document

Examples:
|country|area|city|agency|type|value|appliedDay|appliedMonth|appliedYear|confirmedDay|confirmedMonth|confirmedYear|rowNumber|
|USA|Montana|Belt|Standard & Poors|Long Term Rating|1234|15|Jan|2016|17|Jan|2016|1|

Scenario: User can edit city identifiers- Verify if User can delete credit rating by clicking on 'cancel', then after saving the credit rating row should not get deleted.

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
When the user gets the document with get document id for city with the <city> from the database
When the user deletes the existing credit rating rows
When the user clicks on add new credit rating button in the credit rating city page
When the user enters credit rating agency as <agency> in credit rating row $rowNumber in the basic info city page
When the user enters credit rating type as <type> in credit rating row $rowNumber in the basic info city page
When the user enters credit rating <value> in credit rating row $rowNumber in the basic info city page
And the user enters applied date day <appliedDay> <appliedMonth> <appliedYear> in the credit rating city page
And the user enters confirmed date day <confirmedDay> <confirmedMonth> <confirmedYear> in the credit rating city page
When the user clicks on the save button
And the user clicks on the confirm button
Then the user should see the successful update message at top of the page
When the user clicks on the city update link
When the user clicks on the delete credit rating row button in the basic info city page
Then the user should see delete row confirmation modal in credit rating
When the user clicks on the No button to cancel the deletion of row
Then the user should see the newly added credit rating row in the basic info city page
Then the user should see the city credit rating values as in zeus document
Then the user reverts the changes to the document

Examples:
|country|area|city|agency|type|value|appliedDay|appliedMonth|appliedYear|confirmedDay|confirmedMonth|confirmedYear|rowNumber|
|USA|Montana|Belt|Standard & Poors|Long Term Rating|1234|15|Jan|2016|17|Jan|2016|1|
