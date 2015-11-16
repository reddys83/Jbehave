Meta:@CountryMultipleSections @Country

Narrative:
In order to view and edit the currencies
As a user
I want to cover the requirements mentioned in
JIRA ID - ZEUS-313 - User can select multiple sections of country to view
JIRA ID - ZEUS-312 - User can view all country info

Scenario: Select and view multiple sections for country.
Meta:@verifyBuild
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
Then the user should see the country list box displayed
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
Then the user should see the country iso2 as AF
And the user should see the country iso3 as AFG
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

And the user should see the country's banking hours as:
|DAY|HOURS|
|Monday|9-5|
|Tuesday|9-5|
|Wednesday|9-5|
|Thursday|9-5|
|Friday|9-5|

And the user should see the country's time zones summary as +4½ hours

And the user should see the country's time zones as:
|ZONE|VALUE|
|UTC|+01:00|
|UTC|+01:30|

And the user should see the Status of a country as Active
And the user should see the Start Date of a country as 03 Dec 1818
And the user should see the End Date of a country as 03 Jul 2776
And the user should see the countries's replace by as Albania, Algeria
And the user should see the Add Info of a country as Country
And the user should see the Imports of a country as Capital goods, food, textiles, petroleum products
And the user should see the Exports of a country as Natural gas, fruits & nuts, carpets, karakul, wool, cotton, hides and pelts, precious and semiprecious gems
And the user should see the Intl Dialing Code of a country as +93
And the user should see the Political Structure of a country as Republic
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
Then the user should see the country list box displayed
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
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

