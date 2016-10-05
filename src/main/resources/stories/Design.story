Meta:@Desig


Scenario: verify the routingCode search results with EXACT MATCH
Given a user is on the search page
When the user clicks on the results tab
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
Then the user should see the search results for <entity> routingCode

Examples:
|entity|searchBy|
|001|Routing Code|
|00!@#$%^&*(6|Routing Code|

Scenario: Verify error message for atlease two characters
Given a user is on the search page
When the user clicks on the results tab
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
Then the user should see the error message enter at least 2 valid characters in routing search results

Examples:
|entity|searchBy|
|!@#$%0|Routing Code|

Scenario: Verify message for 0 search results for routingCode
Given a user is on the search page
When the user clicks on the results tab
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
Then the user should see the message for 0 search results in routingCode search results

Examples:
|entity|searchBy|
|0023498|Routing Code|


Scenario: Verify the FID navigate to office in routing Code search results
Given a user is on the search page
When the user clicks on the results tab
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
Then the user should see the search results for <entity> routingCode
When the user clicks on 186-99 in the routing search results

Then the user should see the basic info for selected office
Then the user should see the office names for <officeFid> in the office basic info

Examples:
|entity|searchBy|officeFid|
|01065|Routing Code|186-99|


Scenario: Verify the FID navigate to legalEntity in routing Code search results
Case 1: When routingCode does not have any usageLocations
Given a user is on the search page
When the user clicks on the results tab
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
Then the user should see the search results for <entity> routingCode
When the user clicks on 494 in the routing search results

Then the user should see the basic info label for selected legal entity

And the user should see the legal entity's names as:
|TYPE|VALUE|
|Legal Title|Banco Central de Venezuela|
|Marketing Name|BCV|

Examples:
|entity|searchBy|
|001|Routing Code|


Scenario: Verify the FID navigate to legalEntity in routing Code search results
Case 2: When routingCode had usageLocation @primaryAssignee= 'false'
Given a user is on the search page
When the user clicks on the results tab
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
Then the user should see the search results for <entity> routingCode
When the user clicks on 4275 in the routing search results

Then the user should see the basic info label for selected legal entity

And the user should see the legal entity's names as:
|TYPE|VALUE|
|Legal Title|Standard Chartered Bank|
|Former Name|First Interstate International of California - Miami|

Examples:
|entity|searchBy|
|001|Routing Code|


Scenario: verify the routingCode search results with country filter
Given a user is on the search page
When the user clicks on the results tab
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
And the user applied the country filter as:
|Country|
|Korea (Republic of)|
|Timor-Leste|

Then the user should see the routingCode search results for selected country as:
|Country|
|Korea (Republic of)|
|Timor-Leste|

Examples:
|entity|searchBy|
|001|Routing Code|

Scenario: verify the routingCode search results with type filter
Given a user is on the search page
When the user clicks on the results tab
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
And the user applied the type filter as:
|Type|
|HNRN4|
|CLRN|
=======
Scenario: User is updating a City's Basic Info and has set values for each of 'Country', 'Area' and 'Sub Area
1 - User adds two sub areas and verify Zeus DB is updating with two sub area

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

When the user clicks on the country drop down in the city basic info
When user changes the <country2> in the country drop downfield of city basic page

When user clicks on the area drop down in the city basic info
Then user changes the area <area2> in the area dropdown field in city basic page

When user clicks on the subarea drop down in the city basic info
When the user clears subarea options in city basic page

Then user selects subarea <subarea1> in the subarea multiselect dropdown
Then user selects subarea <subarea2> in the subarea multiselect dropdown

When user clicks on the subarea drop down in the city basic info
Then the user checks whether this subarea <subarea1> are not reselectable
Then the user checks whether this subarea <subarea2> are not reselectable

When the user clicks on the save button in city page
When the user clicks on the confirm button in city page
Then the user should see the successful update message at top of the page

Then verify zeus document whether <city> is mapped to <subarea1> and <subarea2>
Then the user reverts the changes to the document


Then the user should see the routingCode search results for selected type as:
|Type|
|HNRN4|
|CLRN|

Examples:
<<<<<<< HEAD
|entity|searchBy|
|001|Routing Code|


Scenario: verify the routingCode search results with status filter
Given a user is on the search page
When the user clicks on the results tab
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
And the user applied the status filter active in the routingCode search results
Then the user should see the routing code search results for active status

Examples:
|entity|searchBy|
|001|Routing Code|
