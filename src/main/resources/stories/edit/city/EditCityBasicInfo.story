Meta: @EditCityBasicInfo @Edit @City

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

JIRA ID - ZEUS-972 -User can edit City's Identifiers

Scenario: User can edit city identifiers - Verify that an error message is displayed for required and invalid fields for newely added identifier - "Type","Value" and "Status", for new row on Saving.
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
When the user clicks on the city update link
When the user clicks on the add new identifier button in the basic info city page
When the user clicks on the save button
Then the user should see the error message for the required identifier value field in the basic info identifier page
Then the user should see the error message for the required identifier type field in the basic info identifier page
And the user should see the error message at top of page the highlighted fields must be addressed before this update can be saved
When the user enters identifier type as <identifierType> in the basic info city page
And the user enters identifier value as <identifierValueIncorrect> in the basic info city page
And the user clicks on the save button
Then the user should see the Enter up to 50 valid characters error message for the identifier value field in the basic info identifier page
Examples:
|country|city|area|identifierType|identifierValueIncorrect|
|USA|Alexander City|Alabama|Numeric ISO Code|aksjuilrw1aksjuilrw1aksjuilrw1aksjuilrw1aksju%)~12y1|


Scenario:User can edit city identifiers- Verify if User can add New City identifiers-Verify that all fields- "Type","Value" and "Status" are updated successfully
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
And the user clicks on the city basic info link in the navigation bar
And the user clicks on the city update link
When the user clicks on the add new identifier button in the basic info city page
When the user enters identifier type as <identifierType> in the basic info city page
When the user enters identifier value as <identifierValue> in the basic info city page
When the user enters identifier status as <identifierStatus> in the basic info city page
And the user clicks on the save button
Then the user should see the save confirmation modal
When the user clicks on the confirm button in city page
Then the user should see the updated identifiers in the City page as $identifierType $identifierValue $identifierStatus

Examples:
|country|city|area|identifierType|identifierValue|identifierStatus|
|USA|Alexander City|Alabama|Numeric ISO Code|H4Testing|active|


Scenario:User can edit city identifiers- Verify if User can edit existing identifiers( "Type","Value" and "Status") are updated successfully
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
And the user clicks on the city basic info link in the navigation bar
And the user clicks on the city update link
And the user clears identifier value in the basic info city page
When the user enters identifier type as <identifierType> in the basic info city page
When the user enters identifier value as <identifierValue> in the basic info city page
When the user enters identifier status as <identifierStatus> in the basic info city page
And the user clicks on the save button
Then the user should see the save confirmation modal
When the user clicks on the confirm button in city page
Then the user should see the updated identifiers in the City page as $identifierType $identifierValue $identifierStatus

Examples:
|country|city|area|identifierType|identifierValue|identifierStatus|
|Tajikistan|Gafurov|Leninabadskaya Oblast|Numeric ISO Code|H4Testing|active|


Scenario: Verifying row can be deleted by click on enter on the yes button in delete confirmation section.
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
And the user clicks on the city basic info link in the navigation bar
And the user clicks on the update link
When the user clicks on the add new identifier button in the basic info city page
When the user clicks on the delete identifier row button in the basic info city page
Then the user should see delete row confirmation modal in the city page
When the user presses enter button to delete row
Then the user should not see the newly added identifier row in the basic info city page

Examples:
|country|city|area|
|Tajikistan|Gafurov|Leninabadskaya Oblast|


Scenario:User can edit city identifiers- Verify if User can delete existing identifiers( "Type","Value" and "Status") and is updated successfully
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
And the user clicks on the city basic info link in the navigation bar
And the user clicks on the city update link
When the user clicks on the delete identifier row button in the basic info city page
Then the user should see delete row confirmation modal in the city page
When the user presses enter button to delete row
Then the user should not see the newly added identifier row in the basic info city page

Examples:
|country|city|area|
|Tajikistan|Gafurov|Leninabadskaya Oblast|

