Meta:@CountryRelatedEntities

Narrative:
In order to view and edit the currencies
As a user
I want to cover the requirements mentioned in
JIRA ID - ZEUS-246 - User can search for country by full name
JIRA ID - ZEUS-256 - User can view a country's related entities

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
|Central Office|Bank of the Ryukyus, Ltd|Central Office|
|Central Bank|Central Bank of Somalia|Central Bank|

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
|National Association|Vanuatu Bankers Association||
|National Association|Vanuatu Financial Centre Association||
|Regulator|National Bank of Vanuatu Ltd||
|Central Bank|Reserve Bank of Vanuatu||
|Regulator|Reserve Bank of Vanuatu||

Examples:
|country|
|Vanuatu|

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