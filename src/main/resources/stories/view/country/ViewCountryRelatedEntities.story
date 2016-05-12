Meta:@ViewCountryRelatedEntities @Country @View

Narrative:
In order to view and edit the currencies
As a user
I want to cover the requirements mentioned in
JIRA ID - ZEUS-246 - User can search for country by full name
JIRA ID - ZEUS-256 - User can view a country's related entities
JIRA ID - ZEUS-876 - Country Related Entity - Presence expansion

Scenario: Verify country entities data with legalEntity and office
Meta:@verifyBuild
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
When the user clicks on the country entity link in the navigation bar
Then the user should see the country's entities as:
|TYPE|ENTITY|DETAILS|
|Regulator1|Qatar Central Bank|Central, Bank|
|Regulator|Qatar Financial Centre Regulatory Authority|Central, Bank|
|Central Bank|Qatar Central Bank|Central, Bank|

Examples:
|country|
|Qatar|

Scenario: Verify country entities data.
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
When the user clicks on the country entity link in the navigation bar
Then the user should see the country's entities as:
|TYPE|ENTITY|DETAILS|
|Central Bank|State Bank of Vietnam||
|Regulator|State Bank of Vietnam||
|National Association|Vietnam Bankers Association||

Examples:
|country|
|Vietnam|

Scenario: Verify no country entities data.
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
When the user clicks on the country entity link in the navigation bar
Then the user should not see the country's entities

Examples:
|country|
|Nauru|

Scenario: Verify country office entities entity value is displayed in the format "Legal Title [Office]", "Full Name [City]", "Full name [Area]"
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
When the user clicks on the country entity link in the navigation bar
Then the user should see the related entities for the country <country> from trusted document

Examples:
|country|
|Bermuda|
