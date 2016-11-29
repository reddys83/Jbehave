Meta:@Smoke


Narrative: Ensuring current build has most of the features running perfectly.
This story covers following scenarios:
View Scenarios
	View Currency scenario verifies if searched currency is displayed and by clicking on Country name its navigating to country page.
	Verify Country holiday data.
	Verify Area basic info.
	Verify city multiple sections
	Verify city related places.
	Verify legal entity multiple sections
	Verify LegalEntity trust powers section will not appear for the entities which do not match below criteria:Legal entity type is one of the values Bank, Building Society, Credit Union, Government,
Savings & Loan Association, Savings Bank, Trust Company and Legal Entity country of operations is one of the values US, VI, MP, GU, PR, AS
	verify the routingCode search results with EXACT MATCH
	Verify the basic info for a routing code of type ABA
	Verify the payment systems view for different types of routing codes
	Verify when user is viewing a section other than Basic Info and Basic Info section has some errors, upon saving the Area,
the user should automatically navigate to All section


Edit Scenarios :
	User can edit legal Entity's corporate statement
	User can save edits to the currency uses and verify the data is save in the zeus document
	Verifying error message displayed for wrong format of claimes est date
	User can edit area identifiers- Verify if User can add New Area identifiers-Verify that all fields- "Type","Value" and "Status" are updated successfully
	Verify whether user is able to add a Area  entity successfully in Area Web page
	Update and Save existing credit ratings for a city
	User can edit city Began Date
	Save country holidays
	save country basic info
	Verify the user is able to save the country document with valid inputs for related places
	Verify successfull save with valid inputs for type and value in legalEntity personnel
	Delete legal entity type
	Update Office Services - User verifies SERVICE_CATEGORY ('Service Category' & 'Service Override') fields for Office
	Adding new location and location address for both depositing entity type ana non depositing entity type for Office.
	User is updating a Routing Code's Basic Info

Filtering :
    Filter offices by type - Domestic
    verify the routingCode search results with type filter
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
And the user should see the area's replace by as California, Kansas
And the user should see the Use in Address of an area as True
And the user should see the Interest Rate Limit of an area as 92%
And the user should see the Add Info of an area as ILLINOIS: Census area dissolved in 2100


Examples:
|country|area|
|USA|Illinois|

Scenario: Verifying error message displayed for wrong format of claimes est date

Given a user is on the search page
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
Meta:@test1600
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the currency tab in the data area
And the user clicks on the choose a currency option in the currency page
And the user enters the currency <currency> in the typeahead box in the currency page
And the user clicks on the update link
And the user get the document with get Id for currency with the name as Asian Currency Unit from the database

When the user enters the country <currencyCountry> in the currency usage
When the user enters the currency start day as <currencyStartDay> in the currency page
And the user enters the currency start month as <currencyStartMonth> in the currency page
And the user enters the currency start year as <currencyStartYear> in the currency page
And the user enters the first_existing_row_currency_primary_radio_button value as <primary> in the currency page
And the user clicks on the save button
When the user clicks on the confirm button
Then the user should see confirmation message
And the user should be redirected to view mode
Then the user should see the edits to currency uses in zeus document
And the user reverts the changes to the document

Examples:
|currency|currencyCountry|currencyStartDay|currencyStartMonth|currencyStartYear|primary|
|Asian Currency Unit|Angola|||1987|false|
|Asian Currency Unit|Angola||Jun|1987|false|
|Asian Currency Unit|Angola|21|Jun|1987|false|



Scenario: Filter offices by type - Domestic
Given a user is on the search page
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


Scenario: Verify city multiple sections
Meta:@verifyBuild
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
When the user clicks on the choose an area option
When the user enters the area <area> in the type-ahead box
When the user clicks on the choose a city option
When the user enters the city <city> in the type-ahead box
When the user clicks on the city regions link in the navigation bar

Then the user should see the city's alternative regions as:
|TYPE|VALUE|
|Metropolitan Statistical Area|16980|
|Federal Reserve District|7|
|Federal Home Loan Bank District|7|
|National Credit Union Administration Region|IV|

When the user clicks on the city's credit rating link in the navigation bar

Then the user should see the city's credit ratings as:
|NAME|TYPE|VALUE|Date APPLIED|DATE CONFIRMED|
|Fitch|Long Term Sovereign Debt Rating|B|01 Jan 1990|04 Jan 1991|
|Standard & Poors|Long Term Sovereign Debt Rating|A-|Jan 1990|04 Jan 1991|
||Chicagos Terrible Credit Rating|F+|||

When the user clicks on the city's entity link in the navigation bar

Then the user should see the city's entity as:
|TYPE|ENTITY|DETAILS|
|Government Type|Illinois Department of Employment Security||
|Government, city|Illinois Department of Employment Security|City Government, Also known as the IBA|

When the user clicks on the city regions link in the navigation bar
Then the user should not see the city's alternative regions section

Examples:
|country|area|city|
|USA|Illinois|Chicago|

Scenario: Verify city related places.
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
When the user clicks on the choose an area option
When the user enters the area <area> in the type-ahead box
When the user clicks on the choose a city option
When the user enters the city <city> in the type-ahead box
And the user clicks on the city's places link in the navigation bar

Then the user should see the city related places from trusted document

Examples:
|country|area|city|
|USA|Illinois|Chicago|

Scenario: Verify legal entity multiple sections
Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the legal entity credit rating link in the navigation bar

Then the user should see the legal entity's credit ratings as:
|NAME|TYPE|VALUE|Date APPLIED|DATE CONFIRMED|
|Capital Intelligence|Long Term Rating|A+|07 Oct 2015||
|Standard & Poors|Long Term Rating|A|02 Dec 2011||
|Standard & Poors|Short Term Rating|A-1|02 Dec 2011||
|Fitch|Long Term Rating|A+|07 Oct 2015||
|Fitch|Short Term Rating|F1|07 Oct 2015||
|Capital Intelligence|Short Term Rating|F1|07 Oct 2015||
|Japan Credit Rating Agency|Long Term Rating|A+|07 Oct 2015||
|Moody's|Long Term Rating|A1|02 Sep 2015||
|Moody's|Short Term Rating|P-1|02 Sep 2015||

When the user clicks on the legal entity identifier link in the navigation bar

Then the user should see the legal entity's identifiers as:
|TYPE|VALUE|STATUS|
|Bronnoysundregistrene (Norwegian LEIs) (EINO)|B4TYDEB6GKMZO031MB27|Active|
|S and P Identification Number (SPID)|105940|Active|
|FDIC|3510|Active|
|US Tax ID|94-1687665|Active|
|Fitch ID|80089060|Active|
|Chinese Bank Serial Number|Lan Testing|Inactive|
|National Settlement Depository (LEIRU)|123456789012345678901|Pending|
|OCC|13044|Active|
|Irish Stock Exchange (LEIIE)|Lan Iris Stock Exchange|Inactive|

When the user clicks on the legal entity credit rating link in the navigation bar
Then the user should not see the legal entity's credit ratings section

Examples:
|entity|searchBy|fid|
|1038|fid|1038|


Scenario: a) Verify LegalEntity trust powers section will not appear for the entities which do not match below criteria:
Legal entity type is one of the values Bank, Building Society, Credit Union, Government, Savings & Loan Association, Savings Bank, Trust Company
and Legal Entity country of operations is one of the values US, VI, MP, GU, PR, AS

Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
Then the user should see the trust power section not visible for fid <fid>
When the user clicks on the legal entity all link in the navigation bar
Then the user should not see the trust power section in the All page of the legal Entity page

Examples:
|entity|searchBy|fid|
|229070|FID|229070|
|3|FID|3|


Scenario: verify the routingCode search results with type filter
Given a user is on the search page
When the user clicks on the results tab
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
And the user applied the type filter as:
|Type|
|HNRN4|
|CLRN|

Then the user should see the routingCode search results for selected type as:
|Type|
|HNRN4|
|CLRN|

Examples:
|entity|searchBy|
|001|Routing Code|


Scenario: Verify the basic info for a routing code of type ABA
Verify the headers and the legal entity link on the header
Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with routing code <routingCode> and code type <codeType>
Then the user should see the routing code basic info page
And the user should see the routing code basic info values from trusted document for routing code <routingCode> with code type <codeType>
And the user should see the routing code page header with <legalentity>, <headOfficeAddress>, <routingCodeFid> and <routingCodeTfpid>
When the user clicks on the legal entity link in the routing code page header
Then the user should see the legalEntity names for <fid> in the legalEntity basic info

Examples:
|entity|searchBy|routingCode|codeType|legalentity|headOfficeAddress|routingCodeFid|routingCodeTfpid|fid|
|083905216|Routing Code|083905216|ABA|Berliner Volksbank eG|Berlin, Germany|C-1121793|ABA-083905216|1717|


Scenario: Verify the payment systems view for different types of routing codes
a) ABA
b) SWIFT BIC
C) SWIFT BIC (ZEUS-1610) - Unable to view one of the Routing code 01056)
Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with routing code <routingCode> and code type <codeType>
When the user clicks on payment systems section
Then the user should see the routing code payment system values from trusted document for routing code <routingCode> with code type <codeType>

Examples:
|entity|searchBy|routingCode|codeType|
|083905216|Routing Code|083905216|ABA|
|HLFXGB21K03|Routing Code|HLFXGB21K03|SWIFT BIC|
|01056|Routing Code|01056|Swift BIC|




Scenario: ZEUS-1173- Verify when user is viewing a section other than Basic Info and Basic Info section has some errors, upon saving the Area,
the user should automatically navigate to All section
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the area update link
When the user enters <beganDay1> <beganMonth1> <beganYear1> Began Date in the edit basic info area page
When the user clicks on the area's demographics link in the navigation bar
When the user clicks on the save button
Then the user should see the user is navigated to All section view
Then the user should see the error Enter a year, month/year or day/month/year. for area began date
And the user should see the error message at top of page the highlighted fields must be addressed before this update can be saved

Examples:
|country|area|beganDay1|beganMonth1|beganYear1|
|Angola|Cabinda|05||2015|


Scenario: User can edit area identifiers- Verify if User can add New Area identifiers-Verify that all fields- "Type","Value" and "Status" are updated successfully
1 - Verify two identifer rows are added
2 - Verify previously selected Identifer Type is not listed in identifer type dropdown of next row
3 - Verify Zeus Area page is updated with entered identifier values
4 - Verify Zeus DB is updated with entered identifier values

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
When the user clicks on the area basic info link in the navigation bar
And the user clicks on the area update link
When the user gets the document with get document id for area with the <area> from the database
When the user deletes the existing area identifier rows
When the user clicks on the add new identifier button in the basic info area page
When the user enters identifier type as <identifierType> in the basic info area page
When the user enters identifier value as <identifierValue> in the basic info area page
When the user enters identifier status as <identifierStatus> in the basic info area page
When the user clicks on the add new identifier button in the basic info area page
Then the user verifies that previously selected <identifierType> is not present in the new identifier row
When the user enters identifier type as <identifierType2> in the basic info area page
When the user enters identifier value as <identifierValue2> in the basic info area page
When the user enters identifier status as <identifierStatus2> in the basic info area page
And the user clicks on the save button
Then the user should see the save confirmation modal
And the user should see the below summary changes in confirmation modal
|Summary|
|Basic Info / Identifiers|
When the user clicks on the confirm button
Then the user should see the successful update message at top of the area page
Then the user verifies that the area identifiers parameters are entered in the basic info area page
Then the user should see the area identifier values as in zeus document
Then the user reverts the changes to the document

Examples:
|country|area|identifierType|identifierValue|identifierStatus|identifierType2|identifierValue2|identifierStatus2|
|Algeria|Constantine|Numeric ISO Code|QATesting|Active|FIPS Place Code|QATesting|Pending|
|Algeria|Constantine|FIPS Place Code|QATesting|Pending|Numeric ISO Code|QATesting|Inactive|
|Algeria|Constantine|FIPS Place Code|QATesting|Active|Numeric ISO Code|QATesting|Active|

Scenario: a)Verify whether user is able to add a Area  entity successfully in Area Web page
b)Verify whether user is able to view the added related entity in Zeus Document

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the area entity link in the navigation bar
And the user clicks on the area update link
When the user gets the document with get document id for area with the <area> from the database
When the user deletes all existing related entity rows
And the user clicks on the add button for adding new entity for area page
And the user selects type value as <entityType> in the entity for area
And the user clicks on edit button in entity for area
And the user selects fid value as <fid> in the entity for area
And the user clicks on go button in entity for area
And the user selects details value as <entityDetails> in the entity for area
And the user clicks on the add button for adding new entity for area page
And the user selects type value as <entityType2> in the entity for area
And the user clicks on edit button in second row for entity for area
And the user selects fid value as <fid2> in the entity for area
And the user clicks on go button in entity for area
And the user selects details value as <entityDetails2> in the entity for area
And the user clicks on the save button
When the user clicks on the confirm button
Then the user should see the successful update message at top of the area page
Then the user should see related entity values updated in area related entity
Then the user should see the area related entity values in zeus document
Then the user reverts the changes to the document

Examples:
|country|area|entityDetails|entityType|fid|entity|entityDetails2|entityType2|fid2|entity2|
|USA|Alabama|State Government|Banking Association|1038|Bank of America National Association|State Government|Government|1038|Bank of America National Association|


Scenario: Update and Save existing credit ratings for a city
a) User selects a new value for Agency, Type, Value, Applied Date and Confirmed Date and click Save. Updated Credit rating should be saved in Zeus document
b) User selects a new value for Agency, Type, Value and no values for Applied Date and Confirmed Date and click Save. Updated Credit rating should be saved in Zeus document

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
When the user clicks on the city credit rating link in the navigation bar
When the user clicks on the city update link
Then the user should see the city credit rating values same as in trusted document
When the user gets the document with get document id for city with the <city> from the database
When the user enters credit rating agency as <agency> in credit rating row $rowNumber in the basic info city page
When the user enters credit rating type as <type> in credit rating row $rowNumber in the basic info city page
When the user enters credit rating <value> in credit rating row $rowNumber in the basic info city page
And the user enters applied date day <appliedDay> <appliedMonth> <appliedYear> in the credit rating city page
And the user enters confirmed date day <confirmedDay> <confirmedMonth> <confirmedYear> in the credit rating city page
When the user clicks on the save button
When the user clicks on the confirm button
Then the user should see the successful update message at top of the page
Then the user should see the city credit rating values as in zeus document
Then the user should see the entered city credit rating values are saved in UI in the row number <rowNumber>
Then the user reverts the changes to the document

Examples:
|country|area|city|agency|type|value|appliedDay|appliedMonth|appliedYear|confirmedDay|confirmedMonth|confirmedYear|rowNumber|
|USA|Montana|Belt|Standard & Poors|Long Term Rating|1234|||||||1|
|USA|Montana|Belt|Standard & Poors|Long Term Rating|1234|15|Jan|2016|17|Jan|2016|1|


Scenario: User can edit city Began Date - Verify if
a)User can see Success message in City Page
b)User can see entered values updated in City Page
c)User can see entered values updated in Zeus document
d)User can see Basic info changes are updated in Confirmation Modal
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
And the user clicks on the city basic info link in the navigation bar
And the user clicks on the city update link
When the user gets the document with get document id for city with the <city> from the database
When the user enters began date day <day> in the edit basic info city page
When the user enters began date month <month> in the edit basic info city page
When the user enters began date year <year> in the edit basic info city page
When the user clicks on the save button
Then the user should see the save confirmation modal
And the user should see the below summary changes in confirmation modal
|Summary|
|Basic Info|
When the user clicks on the confirm button
Then the user should see the successful update message at top of the page
Then the user should see the entered <day> <month> <year> in city page
Then the user should see the city began date <day><month><year> value in zeus document
Then the user reverts the changes to the document


Examples:
|country|area|city|day|month|year|
|Tajikistan|Leninabadskaya Oblast|Gafurov|||2016|
|Tajikistan|Leninabadskaya Oblast|Gafurov||Oct|2015|
|Tajikistan|Leninabadskaya Oblast|Gafurov|01|Sep|2015|



Scenario: Save country holidays
Bug : ZEUS-900
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
And the user clicks on the update link
And the user get the document with get Id for country with the name as Bosnia-Herzegovina from the database

When the user clicks on the add new holiday button in the holidays country page
And the user enters holiday day <day> in the holidays country page
And the user enters holiday month <month> in the holidays country page
And the user enters holiday year <year> in the holidays country page
And the user enters holiday description <description> in the holidays country page
And the user enters holiday notes <notes> in the holidays country page
And the user clicks on the save button
And the user clicks on the confirm button
Then the user should see the edits to country banking hrs in zeus document
And the user reverts the changes to the document

Examples:
|country|day|month|year|description|notes|
|Bosnia-Herzegovina|1|Jan|2016|New Year|New Year 2016|

Scenario: save country basic info
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
And the user clicks on the update link
And the user get the document with get Id for country with the name as Bosnia-Herzegovina from the database

When the user enters country start year as <countryStartYear>
And the user enters country end year as <countryEndYear>
And the user clicks on the save button
And the user clicks on the confirm button
Then the user should see the edits to country basic info in zeus document
And the user reverts the changes to the document

Examples:
|country|countryStartYear|countryEndYear|
|Bosnia-Herzegovina|2014|2015|


Scenario: Verify the user is able to save the country document with valid inputs for related places
Meta:
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
When the user clicks on the country places link in the navigation bar
And the user clicks on the update link
And the user clicks on the add new places button in the places for country
And the user clicks on new country places type drop-down
And the user selects type value as <PlaceType> in the places for country
When the user clicks on edit button in places for country
And the user clicks on the country drop down in the places for country
When the user selects the country <countryPlaces> in the places for country
And the user clicks on area drop down in the places for country
When the user selects area <areaPlaces> dropdown in places for country
And the user clicks on city drop down in the places for country
And the user selects city <cityPlaces> dropdown in the places for country
And the user clicks on go button in places for country
And the user selects details value as <PlaceDetails> in the places for country
And the user clicks on the save button
Then the user should see the save confirmation modal

Examples:
|country|PlaceType|countryPlaces|areaPlaces|cityPlaces|PlaceDetails|
|Mayotte Island|Capital City|Algeria|Blida|Bouinan|Judicial Capital|

Scenario: Verify successfull save with valid inputs for type and value in legalEntity personnel
Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
When the user clicks on the legal entity personnel link in the navigation bar
And the user clicks on the legalEntity update link
When the user gets the document with get Id for legalentity with the fid as <entity> from the database
And the user clicks on the add new personnel button in legalEntity
And the user selects type <type> in the legalEntity personnel for legalEntity_personnel_first_new_type_dropdown_edit_xpath
And the user enters value as <value> in the legalEntity personnel
And the user clicks on the save button
Then the user should see the save confirmation modal
When the user clicks on the confirm button
Then the user should see the edits to legal entity personnel for fid <fid> in zeus document
Then the user reverts the changes to the document


Examples:
|entity|searchBy|fid|type|value|
|1038|FID|1038|InstitutionEmployees|8094|

Scenario:Delete legal entity type
a) Verify that the delete button is disabled for the first row of legal entity type
b) Verify that the user should get the confirmation window for deleting existing entity type rows and user clicks No button
c) Verify that the user should get the confirmation window for deleting existing entity type rows and user clicks Yes button and row should be deleted
Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the legalEntity update link
When the user gets the document with get Id for legalentity with the fid as <entity> from the database
Then the user should see the first_row_existing_entitytype_delete_button in disabled state in entity types section
When the user clicks on the second_row_existing_entitytype_delete_button in entity types section
Then the user should see the delete row confirmation modal in the legal entity page
When the user clicks on the no button in the delete row confirmation modal in the legal entity page
Then the user should still see the second_existing_entitytype_dropdown with value Commercial Bank
When the user clicks on the second_row_existing_entitytype_delete_button in entity types section
When the user clicks on the yes button in the delete row confirmation modal in the legal entity page
Then the user should not see the second_existing_entitytype_dropdown with value Commercial Bank
When the user clicks on the save button
Then the user should see the save confirmation modal
When the user clicks on the confirm button
Then the user should not see the deleted entity type value Commercial Bank in the zeus document for fid <fid>
Then the user reverts the changes to the document

Examples:
|entity|searchBy|fid|
|1165|FID|1165|

Scenario: Update Office services - User verifies SERVICE_CATEGORY ('Service Category' & 'Service Override') fields for Office
1- User verifies that service category dropdown values are same as lookup values
2- User verifies whether existing office's service values are from trusted document.
3- User verifies whether existing office's service values updated with different data both in UI and Zeus document.
4- User verifies that Service Override Field is limited to 100 unicode characters in Office service Page
Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
And the user clicks on the office services link in the navigation bar
And the user clicks on the office update link
Then the user should see the office's service's values are same as in trusted document
Then the user should see the office service category dropdown values from lookup SERVICE_CATEGORY
When the user gets the document with get id for offices with the <officeFid> from the database
When the user deletes all service rows in office page
And the user clicks on the add button for adding new services for office page
When the user selects <serviceCategory> type in the services for office page
When the user enters <serviceOverride> value  in the text box for office page
And the user clicks on the add button for adding new services for office page
Then the user verifies that previously selected <serviceCategory> is not displayed in second row
When the user selects <serviceCategory2> type in the services for office page
When the user enters <serviceOverride2> value  in the text box for office page
Then the user should see maximum length of office service value is limited to 100
When the user clicks on the save button
When the user clicks on the confirm button
Then the user should see the successful update message at top of the office page
Then the user should see the Office Services values updated in office services page
Then the user should see the user should see the  Office Services values updated in zeus document
Then the user reverts the changes to the document

Examples:
|entity|searchBy|fid|officeFid|serviceCategory|serviceOverride|serviceCategory2|serviceOverride2|
|1038|FID|1038|1038-51|Accepting Credits|First Service Override Entered|Banking|gheshrgjk;aerhg;uaehr;gjkhaejrgjkaerhgaejrhgjaehgjaerghrwrwradasdadasdasdasdasdasdasdadadadasdasdasd|


Scenario: Adding new location and location address for both depositing entity type ana non depositing entity type for Office.
1- Verify Office Address Type dropdown values are from lookup ADDRESS_TYPE
2- Verify that the user should be able to Add new address row for an office location
3- Verify User can select and save values for Type, Address Line 1, Address Line 2, Address Line 3, Address Line 4, Country,Area, Subarea, City, PostalCode, PostalCodeSuffix and Info

Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
And the user clicks on the office locations link in the navigation bar
And the user clicks on the office update link
Then the user should see the office locations address same as in trusted document
When the user gets the document with get id for offices with the <officeFid> from the database
When the user deletes the existing office locations rows
When the user clicks on the add new office location button in the office page
When the user clicks on add new office address button in the office locations
Then the user should see the address type values in office location's section from lookup ADDRESS_TYPE
When the user selects office address type value as <Type> in row 1
And the user enters office address <AddressLine1> in row 1
And the user enters office address <AddressLine2> in row 1
And the user enters office address <AddressLine3> in row 1
And the user enters office address <AddressLine4> in row 1
When the user clicks on the choose a country option in the office locations
When the user enters the office country <Country> in the type-ahead box
When the user clicks on the choose an area option in the office locations
When the user enters the office area <Area> in the type-ahead box
When the user clicks on the choose a subarea option in the office locations
When the user enters the office subarea <subArea> in the type-ahead box
When the user clicks on the choose a city option in the office locations
When the user enters the office city <City> in the type-ahead box
When the user enters office address postal code value as <PostalCode> in location 1
And the user enters office address postal code suffix value as <PostalCodeSuffix> in location 1
And the user enters office address info value as <Info> in location 1
When the user clicks on the save button
Then the user should see the save confirmation modal
And the user should see the below summary changes in confirmation modal
|Summary|
|Locations|
When the user clicks on the confirm button
Then the user verifies that the office address lines addresses are entered in the office locations page
And the user should see the office address lines addresses as in zeus document
And the user reverts the changes to the document


Examples:
|entity|searchBy|fid|officeFid|Type|AddressLine1|AddressLine2|AddressLine3|AddressLine4|Country|Area|subArea|City|PostalCode|PostalCodeSuffix|Info|
|951|FID|951|951-4|mailing|123 Marie Ln|345 Palmer Dr|456 Franklin Ln|789 Apple Valley|USA|Illinois|Warren|Alexis|60126|123|adhsbd|
|444|FID|444|444-499|physical|123 Marie Ln|345 Palmer Dr|456 Franklin Ln|789 Apple Valley|USA|Illinois|Warren|Alexis|60126|123|adhsbd|


Scenario: User is updating a Routing Code's Basic Info -
a) User verifies that the current Date Field values is same as in trusted document.
b) User verifies the change in confirmation modal by entering Date fields(Start Date, End Date, Forthcoming Retirement Date, Confirmed with Fed)
   that is different from the current Date values.
c) User verifies that blank values is saving successfully in the Routing Code Basic Info page.
d) User verifies that Routing Code Basic Info page and Zeus document is updated.
Given a user is on the search page
When the user selects the <searchBy> from the dropdown
When the user enters the <entity> in the typeahead
And the user clicks on the search button
When the user clicks on the search results card with routing code <routingCode> and code type <codeType>
Then the user should see the routing code basic info page
When the user changes the status for routing code <routingCode> and code type <codeType> to <status>
When the user clicks on the routing code update link
Then the user should see the edit routing code date field values from trusted document for routing code <routingCode> with code type <codeType>
When the user enters <startDateDay> <startDateMonth> <startDateYear> for routing code start date field
When the user enters <endDateDay> <endDateMonth> <endDateYear> for routing code end date field
When the user enters <retirementDay> <retirementMonth> <retirementYear> for routing code forthcoming retirement date field
When the user enters <fedDay> <fedMonth> <fedYear> for routing code confirmed with fed field
When the user clicks on the save button
Then the user should see the save confirmation modal
And the user should see the below summary changes in confirmation modal
|Summary|
|Basic Info|
When the user clicks on the confirm button
Then the user should see the updated date field values in routing code basic info page
Then the user should see the date field values same as in zeus document

Examples:
|entity|searchBy|routingCode|codeType|startDateDay|startDateMonth|startDateYear|endDateDay|endDateMonth|endDateYear|retirementDay|retirementMonth|retirementYear|fedDay|fedMonth|fedYear|status|
|083905216|Routing Code|083905216|ABA|||||||||||||active|
|083905216|Routing Code|083905216|ABA|1|Jan|2016|12|Dec|2016|12|Dec|2050|26|Jan|2016|active|
|083905216|Routing Code|083905216|ABA|1|Jan|2017|12|Dec|2017|12|Dec|2050|26|Jan|2016|pending|


Scenario: verify the routingCode search results with EXACT MATCH
Given a user is on the search page
When the user clicks on the results tab
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
Then the user should see the search results for <entity> routingCode

Examples:
|entity|searchBy|
|001|Routing Code|
|00!@#$%^&*(6|Routing Code|
|qa|Routing Code|