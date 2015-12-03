Meta:@Design

Narrative:
In order to view stub entry details
As a user when I search by Name, FID, TFPID and click on the search results card I can view details
I want to cover the requirements mentioned in JIRA ID - Zeus54 - (User can view entity stub entry)

Scenario: Verify Country holiday data. SEPA = False
Meta:@verifyBuild
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user clicks on the choose a country option
Then the user should see the country type-ahead displayed
When the user enters the country <country> in the type-ahead box
Then the user should see the default country page and display all info
When the user clicks on the country regions link in the navigation bar
Then the user should see the country's alternative regions as:
|TYPE|VALUE|
|SEPA|False|
|Trading Region|South Asia|
|Continent|Europe|

Examples:
|country|
|Afghanistan|