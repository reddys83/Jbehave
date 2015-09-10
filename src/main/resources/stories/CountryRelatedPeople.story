Meta:@CountryRelatedPeople

Narrative:
In order to view and edit the people information
As a user
I want to cover the requirements mentioned in
JIRA ID - ZEUS-258 - User can view a country's related people.


Scenario: Verify related people information for country with single records
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
Then the user should see the country list box displayed
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
When the user clicks on the country people link in the navigation bar
Then the user should see the country's people as:
|TYPE|PERSON|
|President|Yasuo Ueno|

Examples:
|country|
|Algeria|


Scenario: Verify related people information for country with multiple records
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
Then the user should see the country list box displayed
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
When the user clicks on the country people link in the navigation bar
Then the user should see the country's people as:
|TYPE|PERSON|
|Business representative|Ms Rossana Salaris|
|Mayor, Financial Commissioner|Thomas Pichler|

Examples:
|country|
|Yugoslavia|


Scenario: Verify no country related people data.
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
Then the user should see the country list box displayed
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
When the user clicks on the country people link in the navigation bar
Then the user should not see the country's people

Examples:
|country|
|Nauru|