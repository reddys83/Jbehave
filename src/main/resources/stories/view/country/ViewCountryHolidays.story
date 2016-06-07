Meta:@ViewCountryHolidays @Country @View @AllStories

Narrative:
In order to view and edit the currencies
As a user
I want to cover the requirements mentioned in
JIRA ID - ZEUS-246 - User can search for country by full name
JIRA ID - ZEUS-254 - User can view a country's holidays

Scenario: Verify Country holiday data.
Meta:@verifyBuild
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
Then the user should see the default country page and display all info
When the user clicks on the country holidays link in the navigation bar
Then the user should see the country's holidays list as:
|DATE|DESCRIPTION|NOTE|
|01 Jan 2015|New Year's Day|National Day Off|
|01 Jan 2015|Public Holiday|National Day Off|
|06 Apr 2015|Easter Monday|National Day Off|
|01 May 2015|Labour Day|National Day Off|
|14 May 2015|Ascension Day|National Day Off|
|25 May 2015|Whitmonday|National Day Off|
|26 Jun 2015|Independence Day|National Day Off|
|25 Dec 2015|Christmas Day|National Day Off|
|01 Jan 2016|New Year's Day|National Day Off|
|28 Mar 2016|Easter Monday|National Day Off|
|29 Mar 2016|Veterans Day|National Day Off|
|05 May 2016|Ascension Day|National Day Off|
|16 May 2016|Whitmonday|National Day Off|
|15 Aug 2016|Assumption Day|National Day Off|
|14 Oct 2016|Proclamation of the First Republic|National Day Off|
|01 Nov 2016|All Saints Day|National Day Off|

Examples:
|country|
|Madagascar|

Scenario: Verify no country holiday data.
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
When the user clicks on the country holidays link in the navigation bar
Then the user should not see the country's holidays list

Examples:
|country|
|British Indian Ocean Territory|