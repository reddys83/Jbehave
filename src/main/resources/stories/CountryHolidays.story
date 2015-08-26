Meta:@CountryHolidays

Narrative:
In order to view and edit the currencies
As a user
I want to cover the requirements mentioned in
JIRA ID - ZEUS-246 - User can search for country by full name
JIRA ID - ZEUS-254 - User can view a country's holidays

Scenario: Verify Country holiday data.
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
Then the user should see the country list box displayed
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
When the user clicks on the country holidays link in the navigation bar
Then the user should see the country's holidays list as:
|DATE|DESCRIPTION|NOTES|
|01 Jan 2015|New Years Day|The day of the new year|
|03 Jan 2015|New Year's Third Day|For the determinedly hung over|
|16 May 2015||The holiday with no name|
|01 Jul 2015|The Holiday With No Note||
|18 Jul 2015|||
|24 Sep 2015|||
|13 Oct 2015|Early Christmas||

Examples:
|country|
|Yugoslavia|

Scenario: Verify no country holiday data.
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
Then the user should see the country list box displayed
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
When the user clicks on the country holidays link in the navigation bar
Then the user should not see the country's holidays list

Examples:
|country|
|British Indian Ocean Territory|