Meta:@CountryRelatedPeople @Country

Narrative:
In order to view and edit the people information
As a user
I want to cover the requirements mentioned in
JIRA ID - ZEUS-258 - User can view a country's related people.


Scenario: Verify related people information for country with single records
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user clicks on the choose a country option
Then the user should see the country type-ahead displayed
When the user enters the country <country> in the type-ahead box
When the user clicks on the country people link in the navigation bar
Then the user should see the country's people as:
|TYPE|PERSON|
|Financial Institution Board member|Steven Bangert|
|President, Cheif executor|Yasuo Ueno|

Examples:
|country|
|Qatar|

Scenario: Verify no country related people data.
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user clicks on the choose a country option
Then the user should see the country type-ahead displayed
When the user enters the country <country> in the type-ahead box
When the user clicks on the country people link in the navigation bar
Then the user should not see the country's people

Examples:
|country|
|Nauru|