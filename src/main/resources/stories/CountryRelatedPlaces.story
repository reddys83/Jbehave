Meta:@CountryRelatedPlaces

Narrative:
In order to view the places of country
As a user
I want to cover the requirements mentioned in
JIRA ID - ZEUS-249 - User can view a country's related places

Scenario: Verify country places data.
Meta:@verifyBuild
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
Then the user should see the country list box displayed
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
When the user clicks on the country places link in the navigation bar
Then the user should see the country's places as:
|TYPE|PLACE|DETAILS|
|Capital City|Beijing|Capital City|
|Financial Centre|Beijing||

Examples:
|country|
|China|

Scenario: Verify country places data with multiple types and details.
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
Then the user should see the country list box displayed
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
When the user clicks on the country places link in the navigation bar
Then the user should see the country's places as:
|TYPE|PLACE|DETAILS|
|Capital City, Data updated manually|India|Capital City, Data updated manually|
|Financial Centre|Belgrade||

Examples:
|country|
|Yugoslavia|

Scenario: Verify the country which have no places
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
Then the user should see the country list box displayed
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
When the user clicks on the country places link in the navigation bar
Then the user should not see the country's places

Examples:
|country|
|Bonaire, Sint Eustatius and Saba|