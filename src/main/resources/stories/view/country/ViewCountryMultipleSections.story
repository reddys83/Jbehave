Meta:@ViewCountryMultipleSections @Country @View @AllStories

Narrative:
In order to view and edit the currencies
As a user
I want to cover the requirements mentioned in
JIRA ID - ZEUS-313 - User can select multiple sections of country to view
JIRA ID - ZEUS-312 - User can view all country info
JIRA ID - ZEUS-605 - make grey headers consistent on view screens
JIRA ID - ZEUS-420 - carry over selected sections of country when user selects new country to view

Scenario: Select and view multiple sections for country.
1. BUG_ID - ZEUS-792
Meta:@verifyBuild
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
Then the user should see the country basic info from trusted document
Then the user should see the default country page and display all info
When the user refreshes the page
Then the user should see the default country page and display all info
When the user clicks on the country basic info link in the navigation bar
Then the user should see the list of country's names type and value as:
|TYPE|VALUE|
|Country Name|Afghanistan|
|Former Name|Afghanistan|

And the user should see the country's demographics info as:
|TYPE|VALUE|UNIT|DATE|
|Area|253,861|mi²|02 Jan 2003|
|Area|647,497|km²|02 Jan 2003|
|Population|29,863,000||02 Jan 2003|

And the user should see the country's identifiers as:
|TYPE|VALUE|STATUS|
|ISO 3166-1 Numeric Identifier|24601|Active|
|ISO 3166-1 Identifier|ASDF|Inactive|
|FIPS Code|Test Identifier|Inactive|

And the user should see the country's banking hours summary as Saturday-Wednesday 08.00-16.00

Then the user should see country banking hrs from trusted document

And the user should see the country's time zones summary as +4½ hours

And the user should see the country's time zones as:
|ZONE|VALUE|
|UTC|+01:00|
|UTC|+01:30|

When the user clicks on the country holidays link in the navigation bar

Then the user should see the country's holidays list as:
|DATE|DESCRIPTION|NOTES|
|01 Jan 2015|New Year's Day||
|03 Jan 2015|Mohemmed's Birthday||
|15 Feb 2015|Liberation Day||
|21 Mar 2015|Noruz (New Year) 1||
|28 Apr 2015|Victory Day||
|18 Jun 2015|Ramadan||
|17 Jul 2015|Eid ul Fitr 1||
|18 Jul 2015|Eid ul Fitr 2||
|19 Jul 2015|Eid ul Fitr 3||
|19 Aug 2015|National Day||
|09 Sep 2015|Ahmed Shah Masoud Memorial Day||
|23 Sep 2015|Eid ul Adha Additional Holiday||
|24 Sep 2015|Eid ul Adha 1||
|26 Sep 2015|Eid ul Adha 3||
|24 Dec 2015|Prophet's Birthday||
|15 Feb 2016|Liberation Day||
|21 Mar 2016|Noruz (New Year) 1||
|28 Apr 2016|Victory Day||
|06 Jun 2016|Ramadan||
|06 Jul 2016|Eid ul Fitr 1||
|07 Jul 2016|Eid ul Fitr 2||
|12 Sep 2016|Eid ul Adha 1||
|13 Sep 2016|Eid ul Adha 2||
|14 Sep 2016|Eid ul Adha 3||
|11 Oct 2016|Ashoora||
|12 Dec 2016|Mohemmed's Birthday||

When the user clicks on the country regions link in the navigation bar
Then the user should see the country's alternative regions as:
|TYPE|VALUE|
|SEPA|False|
|Trading Region|South Asia|
|Continent|Europe|

When the user clicks on the country regions link in the navigation bar
Then the user should not see the country regions section
When the user clicks on the country holidays link in the navigation bar
Then the user should not see the country holidays section
When the user clicks on the country basic info link in the navigation bar
Then the user should see the basic info for the selected country

Examples:
|country|
|Afghanistan|

Scenario: Verify already selected options are preserved when the page is refreshed.
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
When the user clicks on the country basic info link in the navigation bar
Then the user should see the basic info for the selected country
When the user clicks on the country languages link in the navigation bar
Then the user should see the country's languages list as English, Samoan
When the user refreshes the page
Then the user should see the default country page and display all info
Then the user should see the country's languages list as English, Samoan

Examples:
|country|
|American Samoa|

Scenario: Carry over selected sections of country when user selects new country to view
Meta:@verifyBuild
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
When the user clicks on the country basic info link in the navigation bar
Then the user should see the list of country's names type and value as:
|TYPE|VALUE|
|Country Name|Afghanistan|
|Former Name|Afghanistan|
When the user clicks on the choose a country option
When the user enters an another country Åland Islands in the type-ahead box
Then the user should see the list of country's names type and value as:
|TYPE|VALUE|
|Country Name|Åland Islands|

Examples:
|country|
|Afghanistan|