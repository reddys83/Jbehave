Meta:@CountryAlternativeRegions

Narrative:
In order to view and edit the currencies
As a user
I want to cover the requirements mentioned in
JIRA ID - ZEUS-246 - User can search for country by full name
JIRA ID - ZEUS-252 - User can view country's alternative regions

Scenario: Verify Country holiday data. SEPA = True
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
Then the user should see the country list box displayed
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the country regions link in the navigation bar
Then the user should see the country alternatuive regions as:
|TYPE|VALUE|
|SEPA|True|
|Trading Region|Central & Eastern Europe|
|Continent|Europe|

Examples:
|country|
|Yugoslavia|

Scenario: Verify Country holiday data. SEPA = False
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
Then the user should see the country list box displayed
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the country regions link in the navigation bar
Then the user should see the country alternatuive regions as:
|TYPE|VALUE|
|SEPA|False|
|Trading Region|Africa|

Examples:
|country|
|Equatorial Guinea|
