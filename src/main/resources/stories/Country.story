Meta: @Country

Narrative:
In order to view and edit the currencies
As a user
I want to cover the requirements mentioned in
JIRA ID - ZEUS-246 - User can search for country by full name
JIRA ID - ZEUS-93 - User can view basic country info

Scenario:
1. Verify that the country list is displayed and is not empty
2. Verify that the search box is availabe
3. Verify that the user can scroll
4. Verify that the list contains countries by their full name
5. Verify that the names are sorted Alphabetically
6. Verify that the user can type in the filter to display names matching the characters input by the user
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
Then the user should see the country list box displayed
When the user clicks on the choose a country option
Then the user should see the list of all existing countries by full name
And the user should see the country list matching the expected country list and sorted alphabetically
When the user starts typing the name of a country as et in the country input box
Then the user should see the countries in the listbox as:
|COUNTRY|
|Ethiopia|
|St. Pierre et Miquelon|

Scenario: Verify Country basic info
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
Then the user should see the country list box displayed
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
Then the user should see the country iso2 as YU
And the user should see the country iso3 as YUG
When the user clicks on the basic info link in the navigation bar
Then the user should see the country basic info

And the user should see the list of country names type and value as:
|TYPE|VALUE|
|Country Name|Yugoslavia|
|Former Name|Kingdom of Serbs, Croats and Slovenes|

And the user should see the country demographics info as:
|TYPE|VALUE|UNIT|DATE|
|Area|39,518|m²|01 Jan 2012|
|Area|102,350|km²|01 Jan 2012|
|Population|20,000,000|||

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
And the user should see the country status as Inactive
And the user should see the country start date as 13 Jul 1922
And the user should see the country end date as 21 May 2006
And the user should see the country replaced by as  Montenegro Serbia Bosnia-Herzegovina Slovenia Croatia
And the user should see the country imports as Machinery and transport equipment, fuels and lubricants, manufactured goods, chemicals, food and live animals, and raw materials.
And the user should see the country exports as Manufactured goods, food (grain) and live animals, raw materials, and metals.
And the user should see the country intl dialing code as 38
And the user should see the country population as 20,000,000

Examples:
|country|
|Yugoslavia|


