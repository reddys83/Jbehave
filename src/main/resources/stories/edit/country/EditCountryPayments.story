Meta:@EditCountryPayments @Edit @Country @AllStories

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal
JIRA ID - ZEUS-447 - User can edit country payments info

Scenario: Verify error message for IBAN registered date
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
When the user clicks on the country payments link in the navigation bar
And the user clicks on the update link
And the user enters iban registered day <day> in the payments country page
And the user selects iban registered month <month> in the payments country page
And the user enters iban registered year <year> in the payments country page
And the user clicks on the save button
Then the user should see the error message enter a year, month/year or day/month/year for country payments in the country page
And the user should see the error message at top of page the highlighted fields must be addressed before this update can be saved

Examples:
|country|day|month|year|
|Qatar|1|||
|Qatar|1|Jan||
|Qatar|1||1988|
|Qatar||Jan||

Scenario: Verify IBAN routing code type list from lookup ROUTING_CODE_TYPE
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
When the user clicks on the country payments link in the navigation bar
And the user clicks on the update link
And the user clicks on the country payments iban routing code types in the country page
Then the user should see the iban routing code type drop-down lists values alphabetically from lookup ROUTING_CODE_TYPE

Examples:
|country|
|Qatar|

Scenario: Verify country iso2 list
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
When the user clicks on the country payments link in the navigation bar
And the user clicks on the update link
And the user clicks on the country payments iso code in the country page
Then the user should see the iban country iso2 code drop-down list sorted alphabetically in the country page

Examples:
|country|
|Qatar|

Scenario: Verify routing code types list from lookup ROUTING_CODE_TYPE
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
When the user clicks on the country payments link in the navigation bar
And the user clicks on the update link
And the user clicks on the country payments routing code types in the country page
Then the user should see the routing code type drop-down lists values alphabetically from lookup ROUTING_CODE_TYPE

Examples:
|country|
|Qatar|

Scenario: Verify country payments info from trusted document
Meta:@test6
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
When the user clicks on the country payments link in the navigation bar
And the user clicks on the update link
Then the user should see the country payments iban info from trusted document

Examples:
|country|
|Qatar|

Scenario: Verify country payments routing codes from trusted document
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
When the user clicks on the country payments link in the navigation bar
And the user clicks on the update link
Then the user should see the country payments routing code types from trusted document

Examples:
|country|
|Qatar|

Scenario: Verify delete confirmation for IBAN
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
And the user clicks on the update link
And the user clicks on the country payments link in the navigation bar
And the user clicks on the add new iban button in the payments country page
When the user clicks on the delete iban row button in the basic info country page
Then the user should see the delete row confirmation modal in the country page
When the user clicks on the no button in the delete row confirmation modal in the country page
Then the user should see the newly added iban row in the holiday country page
When the user clicks on the delete iban row button in the basic info country page
When the user clicks on the yes button in the delete row confirmation modal in the country page
Then the user should not see the newly added iban row in the holiday country page

Examples:
|country|
|Afghanistan|

Scenario: Verify delete confirmation for routing code
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
And the user clicks on the update link
And the user clicks on the country payments link in the navigation bar
And the user clicks on the add new routing code button in the payments country page
When the user clicks on the delete routing code row button in the basic info country page
Then the user should see the delete row confirmation modal in the country page
When the user clicks on the no button in the delete row confirmation modal in the country page
Then the user should see the newly added routing code row in the holiday country page
When the user clicks on the delete routing code row button in the basic info country page
When the user clicks on the yes button in the delete row confirmation modal in the country page
Then the user should not see the newly added routing code row in the holiday country page

Examples:
|country|
|Afghanistan|