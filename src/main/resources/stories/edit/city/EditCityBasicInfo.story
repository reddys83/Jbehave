Meta: @EditCityBasicInfo @Edit @City @AllStories

Narrative:
In order to view and edit the city page
As a user
I want to cover the requirements mentioned in

Scenario: The user can edit the value in the Add Info field and save it and see it on the front end(Front End Validation)
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
When the user clicks on the choose an area option
When the user enters the area <area> in the type-ahead box
When the user clicks on the choose a city option
When the user enters the city <city> in the type-ahead box
And the user clicks on the city basic info link in the navigation bar
When the user clicks on the city update link
When the user gets the document with get document id for city with the <city> from the database
And the user gets the value already present in the text box
And the user enters the <addInfoText> in the add info text area
When the user clicks on the save button in city page
Then the user should see the below summary changes in confirmation modal
|Summary|
|Basic Info|
When the user clicks on the confirm button
Then the user should see the successful update message at top of the page
Then the user should be able to verify the values are entered in the add info field
Then the user verifies whether the new value <addInfoText> is different from previous value


Examples:
|country|area|city|addInfoText|
|Afghanistan|Badakshan|Panj Shair|Sample text|

Scenario: To update the City's 'Basic Info' by entering a value for 'Add Info' that is different from the current value(Back End validation)
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
When the user clicks on the choose an area option
When the user enters the area <area> in the type-ahead box
When the user clicks on the choose a city option
When the user enters the city <city> in the type-ahead box
And the user clicks on the city basic info link in the navigation bar
And the user clicks on the city update link
Then the user should see the addInfoText value same as in trusted document
When the user enters the <addInfoText> in the add info text area
When the user clicks on the save button in city page
And the user clicks on the confirm button
Then the user should see the <addInfoText> value as in zeus document

Examples:
|country|area|city|addInfoText|
|Afghanistan|Badakshan|Panj Shair|This is a different text|

Scenario: To view that there is no change in value when the user has entered a value for 'Add Info' that is no different to the current value(Front End Validation)
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
When the user clicks on the choose an area option
When the user enters the area <area> in the type-ahead box
When the user clicks on the choose a city option
When the user enters the city <city> in the type-ahead box
And the user clicks on the city basic info link in the navigation bar
And the user clicks on the city update link
When the user enters the <addInfoText> in the add info text area
When the user clicks on the save button in city page
Then the user should see no summary changes in the city save confirmation modal

Examples:
|country|area|city|addInfoText|Summary|
|Afghanistan|Badakshan|Panj Shair|This is a different text|Basic Info|

Scenario: To view whether the text entered in the 'Add Info' field is not beyond 500 unicode characters after saving the page
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
When the user clicks on the choose an area option
When the user enters the area <area> in the type-ahead box
When the user clicks on the choose a city option
When the user enters the city <city> in the type-ahead box
And the user clicks on the city basic info link in the navigation bar
And the user clicks on the city update link
When the user enters values which is beyond 500 unicode characters in the add info field
When the user clicks on the save button in city page
And the user clicks on the confirm button
Then the user should see the successful update message at top of the page
Then the user should be able to view that only 500 unicode characters are saved
Then the user should be able to verify the maximum values are entered in the add info field
Then the user reverts the changes to the document


Examples:
|country|area|city|
|Afghanistan|Badakshan|Panj Shair|

Scenario: User can edit country identifiers - Verify country Identifier types are same as from lookup THIRD_PARTY_IDENTIFIER_GEO
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
And the user clicks on the city basic info link in the navigation bar
And the user clicks on the city update link
When the user clicks on the add new identifier button in the basic info city page
And the user clicks on the city Identifier type drop-down
Then the user should see the city identifier types from lookup THIRD_PARTY_IDENTIFIER_GEO
When the user clicks on the city Identifier status drop-down
Then the user should see the city identifier status from lookup STATUS

Examples:
|country|area|city|
|USA|Alabama|Alexander City|


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
When the user gets the document with get document id for city with the <city> from the database
When the user deletes the existing identifier rows
When the user clicks on the add new identifier button in the basic info city page
When the user enters identifier type as <identifierType> in the basic info city page
When the user enters identifier value as <identifierValue> in the basic info city page
When the user enters identifier status as <identifierStatus> in the basic info city page
When the user clicks on the add new identifier button in the basic info city page
When the user enters identifier type as <identifierType2> in the basic info city page
When the user enters identifier value as <identifierValue2> in the basic info city page
When the user enters identifier status as <identifierStatus2> in the basic info city page
And the user clicks on the save button
Then the user should see the save confirmation modal
When the user clicks on the confirm button
Then the user should see the successful update message at top of the page
Then the user should see the identifier <value> as in zeus document $identifierType $identifierValue $identifierStatus and $identifierType2 $identifierValue2 $identifierStatus2
Then the user reverts the changes to the document

Examples:
|country|area|city|identifierType|identifierValue|identifierStatus|identifierType2|identifierValue2|identifierStatus2|
|USA|New York|Brooklyn|Numeric ISO Code|H4Testing|active|FIPS Place Code|H4Testing|pending|
|USA|New York|Brooklyn|FIPS Place Code|H4Testing|pending|Numeric ISO Code|H4Testing|inactive|
|USA|New York|Brooklyn|FIPS Place Code|H4Testing|pending|Numeric ISO Code|H4Testing|active|


Scenario: Verifying row can be deleted by click on the yes button in delete confirmation section.
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
When the user clicks on the city update link
When the user deletes the existing identifier rows
When the user clicks on the add new identifier button in the basic info city page
When the user clicks on the delete identifier row button in the basic info city page
Then the user should see delete row confirmation modal in the city page
When the user clicks on the Yes button to cancel the deletion of row
Then the user should not see the newly added identifier row in the basic info city page
When the user clicks on the save button
Then the user should see the save confirmation modal
When the user clicks on the confirm button in city page

Examples:
|country|area|city|
|Tajikistan|Leninabadskaya Oblast|Gafurov|



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
When the user gets the document with get document id for city with the <city> from the database
When the user clicks on the add new identifier button in the basic info city page
When the user clicks on the save button
Then the user should see the error message for the required identifier value field in the city basic info page
Then the user should see the error message for the required identifier type field in the city basic info page
Then the user should see the error message for the required identifier status field in the city basic info page
And the user should see the error message at top of page the highlighted fields must be addressed before this update can be saved
When the user enters an incorrect identifier value as <identifierValueIncorrect> in the basic info city page
When the user clicks on the save button
Then the user should see the Enter up to 50 valid characters error message for the identifier value field in the city basic info page
Then the user reverts the changes to the document

Examples:
|country|area|city|identifierValueIncorrect|
|Albania|Fier|Patos|aksjuilrw1aksjuilrw1aksjuilrw1aksjuilrw1aksju%)~12y1|


Scenario: User can edit city identifiers- Verify if User can delete identifiers( "Type","Value" and "Status") by clicking on 'Yes' , then after saving it should be removed.
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
When the user clicks on the delete identifier row button in the basic info city page
Then the user should see delete row confirmation modal in the city page
When the user clicks on the Yes button to cancel the deletion of row
Then the user should not see the newly added identifier row in the basic info city page
Then the user reverts the changes to the document

Examples:
|country|area|city|
|Chad|No Area|Doba|

Scenario: User can edit city identifiers- Verify if User can delete identifiers( "Type","Value" and "Status") by clicking on 'cancel', then after saving the identifier should not get deleted.
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
When the user clicks on the delete identifier row button in the basic info city page
Then the user should see delete row confirmation modal in the city page
When the user clicks on the No button to cancel the deletion of row
Then the user should see the newly added identifier row in the basic info city page
Then the user reverts the changes to the document

Examples:
|country|area|city|
|Chad|No Area|Doba|
