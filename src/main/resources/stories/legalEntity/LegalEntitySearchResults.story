Meta:@LegalEntitySearchResults @LegalEntity

Narrative:
As a user
I want to see the results for the searched entity
So that I can view the information I am looking for
JIRA ID - ZEUS-123 - User will see count of paginated results returned
JIRA ID - ZEUS-53 - User can search for legal entity by name
JIRA ID - ZEUS-71 - User can search for legal entity by FID or TFP ID

Scenario: search by name and verify search results
Given a user is on the search page
When the user searches for <entity> with <field> equals <value>
Then the user should see the search results paginated for the searched entity
And the user should see the number of records displayed in the page w.r.t total search results

Examples:
|entity|field|value|
|legalEntity|name|First National Bank|

Scenario: search by name and verify search results
Given a user is on the search page
When the user searches for <entity> with <field> equals <value>

Then the user should see the legal entity search results card matching the searched entity
|FID|TFPID|NAME|ADDRESS|STATUS|
|1124|10383720|Bank of Montreal|129 Rue St-Jacques|active|
|312461|10077880|Bank of Montreal|FOUR EMBARCADERO CENTER|inactive|

Then the user should see the search results paginated for the searched entity
And the user should see the number of records displayed in the page w.r.t total search results

Examples:
|entity|field|value|
|legalEntity|name|Bank of Montreal|

Scenario: search by name and verify search results
Given a user is on the search page
When the user searches for <entity> with <field> equals <value>

Then the user should see the legal entity search results card matching the searched entity
|FID|TFPID|NAME|ADDRESS|STATUS|
|4123|10055000|Société Générale|BP 208, 09|active|

Then the user should see the search results paginated for the searched entity
And the user should see the number of records displayed in the page w.r.t total search results

Examples:
|entity|field|value|
|legalEntity|name|Société Générale|

Scenario: search by fid and verify search results
Given a user is on the search page
When the user searches for <entity> with <field> equals <value>

Then the user should see the legal entity search results card matching the searched entity
|FID|TFPID|NAME|ADDRESS|STATUS|
|12253||Bank at Ormond by the Sea|1400 Ocean Shore Boulevard|inactive|

Then the user should see the search results paginated for the searched entity
And the user should see the number of records displayed in the page w.r.t total search results

Examples:
|entity|field|value|
|fid|fid|12253|

Scenario: search by tfpid and verify search results
Given a user is on the search page
When the user searches for <entity> with <field> equals <value>

Then the user should see the legal entity search results card matching the searched entity
|FID|TFPID|NAME|ADDRESS|STATUS|
|1038|10077420|Bank of America National Association|100 N Tryon St, Ste 170|active|

Then the user should see the search results paginated for the searched entity
And the user should see the number of records displayed in the page w.r.t total search results

Examples:
|entity|field|value|
|tfpid|tfpid|10077420|

Scenario: search by name and navigate through different search results
Meta:@verifyBuild
Given a user is on the search page
When the user searches for <entity> with <field> equals <value>
Then the user should see the option to navigate to the desired page
When the user navigates to the 4th page on the legal entity search results page
Then the user should see the search results paginated for the searched entity
Then the user should see the option to navigate to the desired page
When the user navigates to the 5th page on the legal entity search results page
Then the user should see the search results paginated for the searched entity
Then the user should see the option to navigate to the desired page

Examples:
|entity|field|value|
|legalEntity|name|First National Bank|

Scenario: search by name and navigate through different search results
Given a user is on the search page
When the user searches for <entity> with <field> equals <value>
Then the user should see the option to navigate to the desired page
When the user navigates to the 5th page on the legal entity search results page
Then the user should see the search results paginated for the searched entity
Then the user should see the option to navigate to the desired page
When the user navigates to the last page on the legal entity search results page
Then the user should see the search results paginated for the searched entity
Then the user should see the option to navigate to the desired page

Examples:
|entity|field|value|
|legalEntity|name|First National Bank|

Scenario: search by name and verify no search results
Given a user is on the search page
When the user searches for <entity> with <field> equals <value>
Then the user should see the option to navigate to the desired page
When the user navigates to the 5th page on the legal entity search results page
Then the user should see the search results paginated for the searched entity
Then the user should see the option to navigate to the desired page
When the user navigates to the last page on the legal entity search results page
Then the user should see the search results paginated for the searched entity
Then the user should see the option to navigate to the desired page

Examples:
|entity|field|value|
|legalEntity|name|First National Bank|

Scenario: search by name and verify no search results
Given a user is on the search page
When the user searches for <entity> with <field> equals <value>
Then the user should see no results found message

Examples:
|entity|field|value|
|legalEntity|name|bank of greece|

Scenario: search by name and navigate to search results pages using Previous/Next link
Given a user is on the search page
When the user searches for <entity> with <field> equals <value>
And the user clicks on the next page link
Then the user should see the search results paginated for the searched entity
When the user clicks on the previous page link
Then the user should see the search results paginated for the searched entity

Examples:
|entity|field|value|
|legalEntity|name|First National Bank|
