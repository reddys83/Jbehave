Meta: @EditCountryBasicInfo @Edit @Country

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal


Scenario: When the user edit the country banking hours and verify the day drop down and hours drop down
TestCase: Where the country which doesn't have any day info
Meta:
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
And the user clicks on the update link
And the user clicks on the add country banking hours option
Then the user should see a new row with day drop-down list with all days and hours with values in half hour increments

Examples:
|country|
|Algeria|

Scenario: When the user edit the country banking hours and verify the day drop down
TestCase: The country which have some day info, Then the drop down should exclude the day which is already present
Meta:
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
And the user clicks on the update link
And the user clicks on the add country banking hours option
Then the user should see a new row with day drop-down list with all days except the day which is already existing

Examples:
|country|
|Afghanistan|

Scenario: Please confirm - would you like to delete this row?
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
And the user clicks on the update link
And the user clicks on the add country banking hours option
And the user clicks on delete country banking hours option
Then the user should see the delete row confirmation modal in the country page

Examples:
|country|
|Afghanistan|





