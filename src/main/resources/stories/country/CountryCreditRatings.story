Meta:@CountryCreditRatings @Country

Narrative:
In order to view and edit the currencies
As a user
I want to cover the requirements mentioned in
JIRA ID - ZEUS-246 - User can search for country by full name
JIRA ID - ZEUS-251 - User can view a country's credit ratings

Scenario: Verify country's credit rating.
Meta:@verifyBuild
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user clicks on the choose a country option
Then the user should see the country type-ahead displayed
When the user enters the country <country> in the type-ahead box
Then the user should see the default country page and display all info
When the user clicks on the country credit rating link in the navigation bar
Then the user should see the country's credit ratings as:
|AGENCY|TYPE|VALUE|APPLIED DATE|CONFIRMED DATE|
|Fitch|Long Term Sovereign Debt Rating|B|01 Jan 1990|04 Jan 1991|
|Standard & Poors|Long Term Sovereign Debt Rating|A-|01 Jan 1990|04 Jan 1991|
||Chicagos Terrible Credit Rating|F+||

Examples:
|country|
|Afghanistan|

Scenario: Verify no country's credit rating.
Given a user is on the search page
When the user clicks on the data tab in the search page
When the user clicks on the choose a country option
Then the user should see the country type-ahead displayed
When the user enters the country <country> in the type-ahead box
And the user clicks on the country credit rating link in the navigation bar
Then the user should not see the country's credit ratings

Examples:
|country|
|Vanuatu|