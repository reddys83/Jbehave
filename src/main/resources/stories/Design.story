Meta: @Design

Narrative:
In order to view stub entry details
As a user when I search by Name, FID, TFPID and click on the search results card I can view details
I want to cover the requirements mentioned in JIRA ID - Zeus54 - (User can view entity stub entry)

Scenario: Verify "All" selection should retrurn all the sections in the webapp
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
When the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
When the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
And the user clicks on the city all link in the navigation bar
Then the user should see the basic info for selected city
Then the user should see the credit rating for selected city
Then the user should see the regions for selected city
Then the user should see the places for selected city
Then the user should see the entities for selected city
Then the user should see the people for selected city

Examples:
|country|area|city|
|Angola|Cuanza Norte|Dondo|