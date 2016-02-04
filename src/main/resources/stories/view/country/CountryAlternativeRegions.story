Meta:@CountryAlternativeRegions @Country @View

Narrative:
In order to view and edit the currencies
As a user
I want to cover the requirements mentioned in
JIRA ID - ZEUS-246 - User can search for country by full name
JIRA ID - ZEUS-252 - User can view country's alternative regions

Scenario: Verify Country holiday data. SEPA = False
Meta:@verifyBuild
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user clicks on the choose a country option
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

Scenario: Verify Country holiday data. SEPA = False
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
And the user clicks on the country regions link in the navigation bar
Then the user should see the country's alternative regions as:
|TYPE|VALUE|
|SEPA|False|
|Trading Region|Africa|

Examples:
|country|
|Equatorial Guinea|
