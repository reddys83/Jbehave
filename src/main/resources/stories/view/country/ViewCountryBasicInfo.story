Meta:@ViewCountryBasicInfo @Country @View

Narrative:
In order to view and edit the currencies
As a user
I want to cover the requirements mentioned in
JIRA ID - ZEUS-246 - User can search for country by full name
JIRA ID - ZEUS-93 - User can view basic country info
JIRA ID - ZEUS-254 - User can view a country's holidays
JIRA ID - ZEUS-321 - ignore special characters in currency, country, area/subarea and city drop-down
JIRA ID - ZEUS-792 - Country Basic Info - Demographics - Dates are not displaying.

Scenario:
1. Verify that the country list is displayed and is not empty
2. Verify that the search box is availabe
3. Verify that the user can scroll
4. Verify that the list contains countries by their full name
5. Verify that the names are sorted Alphabetically
6. Verify that the user can type in the filter to display names matching the characters input by the user
Meta:
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user clicks on the choose a country option
Then the user should see the list of all existing countries by full name
When the user starts typing the name of a country as et in the country input box
Then the user should see the countries in the listbox as:
|COUNTRY|
|Ethiopia|
|Netherlands|
|St. Pierre et Miquelon|
|Vietnam|

Scenario: Verify Country basic info
1. BUG_D - ZEUS-792
Meta:@verifyBuild
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
When the user clicks on the country basic info link in the navigation bar
Then the user should see the basic info for the selected country
And the user should see the country basic info from trusted document

And the user should see the list of country's names type and value as:
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

Examples:
|country|
|Afghanistan|

Scenario: Click on replaced by country link
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
When the user clicks on the country basic info link in the navigation bar
And the user clicks on the replaced by country <replacedByCountry> in the country basic info
And the user clicks on the country basic info link in the navigation bar
Then the user should see the basic info for the selected country

Examples:
|country|replacedByCountry|
|Afghanistan|Albania|

Scenario: Verify country sections list
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
Then the user should see the below country sections
|SECTIONS|
|ALL|
|BASIC INFO|
|LANGUAGES|
|HOLIDAYS|
|CREDIT RATING|
|REGIONS|
|CURRENCIES|
|PAYMENTS|
|PLACES|
|ENTITIES|
|PEOPLE|

Examples:
|country|
|Afghanistan|

Scenario: Verify basic info left section
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
When the user clicks on the country basic info link in the navigation bar
Then the user should see the below fields in the country basic info left section
|FIELDS|
|Status|
|Start Date|
|End Date|
|Replaced By|
|Add Info|
|Domestic with|
|Imports|
|Exports|
|Political Structure|
|Intl Dialing Code|

Examples:
|country|replacedByCountry|
|Afghanistan|Albania|
