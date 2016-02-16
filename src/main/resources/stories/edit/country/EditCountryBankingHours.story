Meta: @EditCountryBasicInfo @Edit @Country

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario:
a. Assuming no Banking Hours, when user clicks on update then the banking hours is editable
b. When the user adds summary and saves it, the summary is saved
c. When the user adds a row, then the user sees a new row with the day drop-down list with the value Monday through Sunday and hours display two list with values from 00:00 to 23:30
c. When the user selects day as Monday and hours as 00:00-23:30 and saves it, the information is saved successfully
d. When the user adds a second row, the user should see the day drop-down list with value Tuesday through Sunday and hours display two lists with value from 00:00 to 23:30
e. When the user selects day as Wednesday and hours as 00:00-00:00 and saves it, the information is saved successfully
f. When the user adds a third row, the user selects day as Tuesday and saves it, the information should be saved
g. When the user adds a fourth row, the user select hours as 23:30-00:00 and saves it the information is saved
h. When the user deletes the first row and clicks on the save button, the row is deleted
i. When the user add a new row, the new row should have Monday in the drop down
i. When the user deletes the summary and saves it, there should be no summary value

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
And the user clicks on the update country link
Then the user can edit banking hours summary and date
When the user clicks on the add country banking hours option
Then the user should see a new row with day drop-down list with all days and hours with values in half hour increments
When the user selects day as Monday and hours as 00:00-23:30 and saves it
Then the first row is saved successfully with day as Monday and hours as 00:00-23:30
When the user clicks on the update country link
And the user clicks on the add country banking hours option
Then the user should see a new row with day drop-down list with all days except monday and hours with values in half hour increments
When the user selects day as Wednesday and hours as 00:00-00:00
And the user clicks on the save button
Then the second row is saved successfully with day as Wednesday and hours as 00:00-00:00
When the user clicks on the update country link
And the user clicks on the add country banking hours option
When the user selects day as Tuesday and hours as no-value
And the user clicks on the save button
Then the third row is saved successfully with day as Tuesday and hours as no-value
When the user clicks on the update country link
And the user clicks on the add country banking hours option
When the user selects day as no-value and hours as 23:30-00:00
And the user clicks on the save button
Then the fourth row is saved successfully with day as no-value and hours as 23:30-00:00
When the user clicks on the update country link
And the user deletes the first row
Then the user should see the message Please confirm - would you like to delete this row?
When the user clicks the no button
Then the first row is saved successfully with day as Monday and hours as 00:00-23:30
When the user deletes the first row
And the user clicks the yes button
And the user clicks on the save button
Then the first row is deleted successfully
When the user clicks on the update country link
And the user deletes the banking hours summary
And the user clicks on the save button
Then the banking hours summary is deleted
When the user gets the trusted document for country <country>
Then the user should see the view banking hours from trusted document
And the user reverts the changes to the country <country>

Examples:
|country|
|Mali|




