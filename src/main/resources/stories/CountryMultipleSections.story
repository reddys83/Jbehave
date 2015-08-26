Meta:@CountryMultipleSections

Narrative:
In order to view and edit the currencies
As a user
I want to cover the requirements mentioned in
JIRA ID - ZEUS-313 - User can select multiple sections of country to view

Scenario: Select and view multiple sections for country.
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
Then the user should see the country list box displayed
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
Then the user should see the country iso2 as YU
And the user should see the country iso3 as YUG
When the user clicks on the country basic info link in the navigation bar
Then the user should see the basic info for the selected country

And the user should see the list of country names type and value as:
|TYPE|VALUE|
|Country Name|Yugoslavia|
|Former Name|Kingdom of Serbs, Croats and Slovenes|

And the user should see the country demographics info as:
|TYPE|VALUE|UNIT|DATE|
|Area|39,518|mi²|01 Jan 2012|
|Area|102,350|km²|01 Jan 2012|
|Population|20,000,000||01 Jan 2012|

And the user should see the country identifiers as:
|TYPE|VALUE|STATUS|
|ISO 3166-1 Numeric Identifier|891|Inactive|

And the user should see the country banking hours summary as Workin' 9-5

And the user should see the country banking hours as:
|DAY|HOURS|
|Monday|9-5|
|Tuesday|9-5|
|Wednesday|9-5|
|Thursday|9-5|
|Friday|9-5|

And the user should see the country time zones summary as +1 hour

And the user should see the country time zones as:
|ZONE|VALUE|
|UTC|+01:00|
|UTC|+01:30|

And the user should see the country status as Inactive
And the user should see the country start date as 13 Jul 1922
And the user should see the country end date as 21 May 2006
And the user should see the country replaced by as  Montenegro, Serbia, Bosnia-Herzegovina, Slovenia Croatia
And the user should see the country additional info as No longer exists.
And the user should see the country imports as Machinery and transport equipment, fuels and lubricants, manufactured goods, chemicals, food and live animals, and raw materials.
And the user should see the country exports as Manufactured goods, food (grain) and live animals, raw materials, and metals.
And the user should see the country intl dialing code as +38
And the user should see the country political structure as Republic?
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

When the user clicks on the country regions link in the navigation bar
Then the user should see the country alternatuive regions as:
|TYPE|VALUE|
|SEPA|True|
|Trading Region|Central & Eastern Europe|
|Continent|Europe|

When the user clicks on the country regions link in the navigation bar
Then the user should not see the country regions section
When the user clicks on the country holidays link in the navigation bar
Then the user should not see the country holidays section
When the user clicks on the country basic info link in the navigation bar
Then the user should see the basic info for the selected country

Examples:
|country|
|Yugoslavia|


