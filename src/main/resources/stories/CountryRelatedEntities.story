Meta:@CountryRelatedEntities

Narrative:
In order to view and edit the currencies
As a user
I want to cover the requirements mentioned in
JIRA ID - ZEUS-246 - User can search for country by full name
JIRA ID - ZEUS-256 - User can view a country's related entities

Scenario: Verify country entities data with legalEntity and office
Meta:@verifyBuild
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
Then the user should see the country list box displayed
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
When the user clicks on the country entity link in the navigation bar
Then the user should see the country's entities as:
|TYPE|ENTITY|DETAILS|
|Central Office, Central Office2|Bank of the Ryukyus, Ltd|Central Office, details 2|
|Central Bank, Central Office2|Central Bank of Somalia|Central Bank, details 2|

Examples:
|country|
|Yugoslavia|

Scenario: Verify country entities data.
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
Then the user should see the country list box displayed
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
When the user clicks on the country entity link in the navigation bar
Then the user should see the country's entities as:
|TYPE|ENTITY|DETAILS|
|National Association|Vietnam Bankers Association||
|Central Bank|State Bank of Vietnam||
|Regulator|State Bank of Vietnam||

Examples:
|country|
|Vietnam|

Scenario: Verify no country entities data.
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
Then the user should see the country list box displayed
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
When the user clicks on the country entity link in the navigation bar
Then the user should not see the country's entities

Examples:
|country|
|Nauru|