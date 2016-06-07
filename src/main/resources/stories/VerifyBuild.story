Meta:@Smoke


Narrative: Ensuring current build has most of the features running perfectly.
This story covers following scenarios:
View Scenarios :
    View Currency scenario verifies if searched currency is displayed and by clicking on Country name its navigating to country page.
    Verify Country holiday data.
    Verify Area basic info.
    Verifying error message displayed for wrong format of claimes est date
Edit Scenarios :
    User can edit legal Entity's corporate statement
    User can save edits to the currency uses and verify the data is save in the zeus document
Filtering :
    Filter offices by type - Domestic
Sorting :
    Verify the sorting office results by FID



Scenario: View Currency scenario verifies if searched currency is displayed and by clicking on Country name its navigating to country page.
Meta:@verifyBuild
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the currency tab in the data area
And the user clicks on the choose a currency option in the currency page
And the user enters the currency <currency> in the typeahead box in the currency page
Then the user should see the view currency use from trusted document
When the user clicks on the country <currencyUsageCountry> in the currency usage
Then the user should see the default country page and display all info

Examples:
|currency|currencyUsageCountry|
|Rand|South Africa|


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

Scenario: Verify Area basic info.
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
When the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
When the user clicks on the area basic info link in the navigation bar
Then the user should see the basic info for selected area

And the user should see the area's names as:
|TYPE|VALUE|
|Full Name|Illinois|
|Display Name|IL|

And the user should see the area's identifiers as:
|TYPE|VALUE|STATUS|
|typeA|coolIdentifier 24601|Active|
|typeB|ASDF|Inactive|
|FIPS Code|Test Identifier|Inactive|

And the user should see the area's time zones summary as +2 hour

And the user should see the area's time zones as:
|Summary||
|UTC|+02:00|
|UTC|+02:00|

And the user should see the Status of an area as Active
And the user should see the Began Date of an area as 21 May 2006
And the user should see the End Date of an area as 13 Jul 1922
And the user should see the Type of an area as Area
And the user should see the Country of an area as USA
And the user should see the Area Parent of an area as Atchison
And the user should see the area's replace by as California, Kansas
And the user should see the Use in Address of an area as True
And the user should see the Interest Rate Limit of an area as 92%
And the user should see the ISO2 of an area as IL
And the user should see the Add Info of an area as ILLINOIS: Census area dissolved in 2100


Examples:
|country|area|
|USA|Illinois|

Scenario: Verifying error message displayed for wrong format of claimes est date

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
Then the user should see the message you can search for a legal entity at any time using the header search
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
Then the user should see the search results for the institution
When the user clicks on the search results card with fid <fid>
And the user clicks on the legalEntity update link
When the user enters day for claimed est date <day>
And the user enters month for claimed est date <month>
And the user enters year for claimed est date <year>
And the user clicks on the save button
Then the user should see the error message enter a day/month/year on legal entity page
And the user should see the error message at top of page the highlighted fields must be addressed before this update can be saved


Examples:
|entity|searchBy|fid|day|month|year|
|1038|fid|1038|10| ||
|1038|fid|1038|10|2||
|1038|fid|1038||2||
|1038|fid|1038|10||1994|
|1038|fid|1038|10.5| |1994.6|


Scenario: User can edit legal Entity's corporate statement
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
Then the user should see the message you can search for a legal entity at any time using the header search
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
Then the user should see the search results for the institution
When the user clicks on the search results card with fid <fid>
And the user clicks on the legalEntity update link
When the user updates corporate statement <value>
And the user clicks on the save button
Then the user should see the save confirmation modal
When the user clicks on the confirm button
Then the user verifies corporate summary from zeus document <fid> <value>




Examples:
|entity|searchBy|fid|value|
|1038|fid|1038|CorporateValue|
|1038|fid|1038| |

Scenario: ZEUS-838 - User will see confirmation message after saving currency edits
ZEUS-286 - User can save edits to the currency uses and verify the data is save in the zeus document ( Active status ) STORY:920(failing because of invalid data in database)
1. @accuracy = year
2. @accuracy = month
3. @accuracy = day
Meta:
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the currency tab in the data area
And the user clicks on the choose a currency option in the currency page
And the user enters the currency <currency> in the typeahead box in the currency page
And the user clicks on the update link
And the user get the document with get Id for currency with the name as Afghani-test from the database

When the user enters the country <currencyCountry> in the currency usage
When the user enters the currency start day as <currencyStartDay> in the currency page
And the user enters the currency start month as <currencyStartMonth> in the currency page
And the user enters the currency start year as <currencyStartYear> in the currency page
And the user enters the first_new_row_currency_primary_radio_button value as <primary> in the currency page
And the user clicks on the save button
When the user clicks on the confirm button
Then the user should see confirmation message
And the user should be redirected to view mode
Then the user should see the edits to currency uses in zeus document
And the user reverts the changes to the document

Examples:
|currency|currencyCountry|currencyStartDay|currencyStartMonth|currencyStartYear|primary|
|Afghani-test|Angola|||1987|false|
|Afghani-test|Angola||Jun|1987|false|
|Afghani-test|Angola|21|Jun|1987|false|


Scenario: Filter offices by type - Domestic
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
Then the user should see the office type filter default to all
When the user selects the office type filter domestic
Then the user should see the list of domestic offices in the office search results

Examples:
|entity|searchBy|fid|
|1038|FID|1038|

Scenario: Verify the sorting office results by FID
Meta:
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
When the user clicks on the office search results fid column
Then the user should see the office search results cards sorted descending order by office fid with fid 91832 from the database
When the user clicks on the office search results fid column
Then the user should see the office search results cards sorted ascending order by office fid with fid 91832 from the database

Examples:
|entity|searchBy|fid|headOfficeAddress|tfpid|
|Associated Commercial Finance Inc|Name|91832|112 North Adams St|96691281|
