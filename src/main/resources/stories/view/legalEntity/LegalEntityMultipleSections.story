Meta:@LegalEntityMultipleSections @LegalEntity

Narrative:
In order to view and edit the city
As a user
I want to cover the requirements mentioned in
JIRA ID - ZEUS - 402 - User can view all legal entity info
JIRA ID - ZEUS - 403 - User can select multiple sections of legal entity to view
JIRA ID - ZEUS-605 - make grey headers consistent on view screens

Scenario: Verify All sections
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
Then the user should see the default legal entity page and display basic info
When the user clicks on the legal entity all link in the navigation bar
Then the user should see the basic info for selected legal entity
And the user should see the board meetings for the legal entity
And the user should see the credit rating for the legal entity
And the user should see the history for the legal entity
And the user should see the identifiers for the legal entity
And the user should see the location summaries for the legal entity
And the user should see the ownership summaries for the legal entity
And the user should see the personnel for the legal entity
And the user should see the offered services for the legal entity
And the user should see the financial services for the legal entity
And the user should see the statistics for the legal entity
And the user should see the trust powers for the legal entity

Examples:
|entity|searchBy|fid|
|Bank of America National Association|Name|1038|

Scenario: Verify multiple sections
Meta:
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the legal entity credit rating link in the navigation bar

Then the user should see the legal entity's credit ratings as:
|NAME|TYPE|VALUE|Date APPLIED|DATE CONFIRMED|
|Fitch |Long Term Rating|A+|07 Oct 2015||
|Fitch |Short Term Rating|F1|07 Oct 2015||
|Moody's|Long Term Rating|A1|02 Sep 2015||
|Moody's|Short Term Rating|P-1|02 Sep 2015||
|Standard & Poors|Long Term Rating|A|02 Dec 2011||
|Standard & Poors|Short Term Rating|A-1|02 Dec 2011||

When the user clicks on the legal entity identifier link in the navigation bar

Then the user should see the legal entity's identifiers as:
|TYPE|VALUE|STATUS|
|The Global Markets Entity Identifier (GMEI)|B4TYDEB6GKMZO031MB27|active|
|S and P Identification Number (SPID)|105940|active|
|RSSD|480228|active|
|FDIC|3510|active|
|OCC|13044|active|
|Global Intermediary Identification Number|K613SZ.99999.SL.840|active|
|Moodys Organisation ID|600011442|active|
|US Tax ID|94-1687665|active|
|Fitch ID|80089060|active|

When the user clicks on the legal entity credit rating link in the navigation bar
Then the user should not see the legal entity's credit ratings section

Examples:
|entity|searchBy|fid|
|Bank of America National Association|Name|1038|

Scenario: Verify All sections
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the legal entity board meetings link in the navigation bar
And the user clicks on the legal entity credit rating link in the navigation bar
And the user clicks on the legal entity history link in the navigation bar
And the user clicks on the legal entity identifier link in the navigation bar
And the user clicks on the legal entity locations link in the navigation bar
And the user clicks on the legal entity ownership link in the navigation bar
When the user clicks on the legal entity personnel link in the navigation bar
When the user clicks on the legal entity services link in the navigation bar
When the user clicks on the legal entity statistics link in the navigation bar
When the user clicks on the legal entity tust power link in the navigation bar
Then the user should see the basic info for selected legal entity
And the user should see the board meetings for the legal entity
And the user should see the credit rating for the legal entity
And the user should see the history for the legal entity
And the user should see the identifiers for the legal entity
And the user should see the location summaries for the legal entity
And the user should see the ownership summaries for the legal entity
And the user should see the personnel for the legal entity
And the user should see the offered services for the legal entity
And the user should see the financial services for the legal entity
And the user should see the statistics for the legal entity
And the user should see the trust powers for the legal entity
Then the user should see all is selected by default in the navigation bar

Examples:
|entity|searchBy|fid|
|Bank of America National Association|Name|1038|
