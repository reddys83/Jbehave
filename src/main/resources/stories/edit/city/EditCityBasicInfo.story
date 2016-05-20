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
And the user clicks on the city basic info link in the navigation bar
And the user clicks on the city update link
When the user clicks on the add new identifier button in the basic info city page
Then the user should see the default identifier status as active
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


Scenario: User can edit City identifiers-Verify that an error message is displayed for required and invalid fields- "Type","Value" and "Status", for old row on Saving.
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
When the user enters identifier type as <identifierType> in the basic info city page
And the user clears identifier value in the basic info city page
And the user clicks on the save button
Then the user should see the error message for the required identifier value field in the basic info identifier page
Then the user should see the error message for the required identifier type field in the basic info identifier page
Then the user should see the error message at top of page the highlighted fields must be addressed before this update can be saved

Examples:
|country|city|area|identifierType|
|USA|Alexander City|Alabama||

Scenario:User can edit existing City identifiers-Verify that all fields- "Type","Value" and "Status" are updated successfully
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
When the user selects identifier type as <identifierType> in the basic info city page
Then the user should see the identifier type values  from lookup THIRD_PARTY_IDENTIFIER_GEO
Then the user should see that values in <identifierType> are sorted in same order from <typelookup> THIRD_PARTY_IDENTIFIER_GEO
When the user selects identifier status as <identifierStatus> in the basic info city page
Then the user should see the identifier status values from lookup STATUS
Then the user should see that values in <identifierStatus> are sorted in same order from <statuslookup> STATUS
When the user enters identifier type as <identifierType> in the basic info city page
When the user enters identifier value as <identifierValue> in the basic info city page
When the user enters identifier status as <identifierStatus> in the basic info city page
And the user clicks on the save button
Then user should see success message Your changes have been saved.

Examples:
|country|city|area|identifierType|identifierValue|identifierStatus|typelookup|statuslookup|
|USA|Alexander City|Alabama|Numeric ISO Code|H4|ACtive|Type|Status|

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
Then the user should see the default identifier status as active
Then the user should see the default identifier Type as blank
Then the user should see the default identifier value as blank
When the user selects identifier type as <identifierType> in the basic info city page
Then the user should see the identifier type values  from lookup THIRD_PARTY_IDENTIFIER_GEO
Then the user should see that values in <identifierType> are sorted in same order from <typelookup> THIRD_PARTY_IDENTIFIER_GEO
When the user selects identifier status as <identifierStatus> in the basic info city page
Then the user should see the identifier status values from lookup STATUS
Then the user should see that values in <identifierStatus> are sorted in same order from <statuslookup> STATUS
When the user enters identifier type as <identifierType> in the basic info city page
When the user enters identifier value as <identifierValue> in the basic info city page
When the user enters identifier status as <identifierStatus> in the basic info city page
And the user clicks on the save button
Then user should see success message Your changes have been saved.

Examples:
|country|city|area|identifierType|identifierValue|identifierStatus|typelookup|statuslookup|
|USA|Alexander City|Alabama|Numeric ISO Code|H4|ACtive|Type|Status|


Scenario:User can edit city identifiers - Verify Delete confirmation messages & veirfy if User can delete  identifier successfully (adding new identifier)
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
And the user clicks on the add new identifier button in the city page
When the user clicks on the delete identifier row button in the city page
Then the user should see the delete row confirmation message in the city page
When the user presses enter button to delete row
Then the user should not see the newly added identifier row in the city page

Examples:
|country|city|area|
|USA|Alexander City|Alabama|

Scenario:User can edit city identifiers - Verify Delete confirmation messages & veirfy if User can delete  identifier successfully (existing identifier)
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
When the user clicks on the delete identifier row button in the city page
Then the user should see the delete row confirmation message in the city page
When the user presses enter button to delete row
Then the user should not see the newly added identifier row in the city page
Examples:
|country|city|area|
|USA|Alexander City|Alabama|


Scenario:User can edit city identifiers - Verify Delete confirmation messages & veirfy if User retain the  identifier  values successfully if User selects "No" to confirm to not proceed with the deletion
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
When the user clicks on the delete identifier row button in the city page
Then the user should see the delete row confirmation message in the city page
When the user presses enter button to delete row
Then the user should not see the newly added identifier row in the city page
Then the user should see the delete row confirmation modal in the city page
When the user clicks on the no button in the delete row confirmation modal in the city page
Then the user should see the newly added identifier row in the  city page
Examples:
|country|city|area|
|USA|Alexander City|Alabama|

