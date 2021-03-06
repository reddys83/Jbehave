Meta:@LegalEntitySearchResults @LegalEntity @View @AllStories

Narrative:
As a user
I want to see the results for the searched entity
So that I can view the information I am looking for
JIRA ID - ZEUS-123 - User will see count of paginated results returned
JIRA ID - ZEUS-53 - User can search for legal entity by name
JIRA ID - ZEUS-71 - User can search for legal entity by FID or TFP ID
JIRA ID - ZEUS-622 - Search Results is not showing office address.
JIRA ID - ZEUS-490 - Change legal entity search to use ADDN rather than Denorm
JIRA ID - ZEUS-475 - User can search for legal entity under "Data"

Scenario: search by name and verify search results
Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
Then the user should see the search results paginated for the searched entity
And the user should see the number of records displayed in the page w.r.t total search results

Examples:
|entity|searchBy|
|First National Bank|name|

Scenario: search by name and verify search results
Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown

Then the user should see the legal entity search results card matching the searched entity
|FID|TFPID|NAME|ADDRESS|STATUS|
|1124|10383720|Bank of Montreal||active|
|312461|10077880|Bank of Montreal||inactive|

Then the user should see the search results paginated for the searched entity
And the user should see the number of records displayed in the page w.r.t total search results

Examples:
|entity|searchBy|
|Bank of Montreal|name|

Scenario: search by name and verify search results
Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown

Then the user should see the legal entity search results card matching the searched entity
|FID|TFPID|NAME|ADDRESS|STATUS|
|4123|10055000|Société Générale||active|

Then the user should see the search results paginated for the searched entity
And the user should see the number of records displayed in the page w.r.t total search results

Examples:
|entity|searchBy|
|Société Générale|name|

Scenario: search by fid and verify search results
Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown

Then the user should see the legal entity search results card matching the searched entity
|FID|TFPID|NAME|ADDRESS|STATUS|
|12253||Bank at Ormond by the Sea|1400 Ocean Shore Boulevard|inactive|

Then the user should see the search results paginated for the searched entity
And the user should see the number of records displayed in the page w.r.t total search results

Examples:
|entity|searchBy|
|12253|fid|

Scenario: search by tfpid and verify search results
Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown

Then the user should see the legal entity search results card matching the searched entity
|FID|TFPID|NAME|ADDRESS|STATUS|
|1038|10077420|Bank of America National Association|100 N Tryon St, Ste 170|active|

Then the user should see the search results paginated for the searched entity
And the user should see the number of records displayed in the page w.r.t total search results

Examples:
|entity|searchBy|
|10077420|tfpid|

Scenario: search by name and navigate through different search results
Meta:@verifyBuild
Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
Then the user should see the option to navigate to the desired page
When the user navigates to the 4th page on the legal entity search results page
Then the user should see the search results paginated for the searched entity
Then the user should see the option to navigate to the desired page
When the user navigates to the 5th page on the legal entity search results page
Then the user should see the search results paginated for the searched entity
Then the user should see the option to navigate to the desired page

Examples:
|entity|searchBy|
|First National Bank|name|

Scenario: search by name and navigate through different search results
Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
Then the user should see the option to navigate to the desired page
When the user navigates to the 5th page on the legal entity search results page
Then the user should see the search results paginated for the searched entity
Then the user should see the option to navigate to the desired page
When the user navigates to the last page on the legal entity search results page
Then the user should see the search results paginated for the searched entity
Then the user should see the option to navigate to the desired page

Examples:
|entity|searchBy|
|First National Bank|name|

Scenario: search by name and verify no search results
Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
Then the user should see the option to navigate to the desired page
When the user navigates to the 5th page on the legal entity search results page
Then the user should see the search results paginated for the searched entity
Then the user should see the option to navigate to the desired page
When the user navigates to the last page on the legal entity search results page
Then the user should see the search results paginated for the searched entity
Then the user should see the option to navigate to the desired page

Examples:
|entity|searchBy|
|First National Bank|name|

Scenario: search by name and verify no search results
Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
Then the user should see no results found message

Examples:
|entity|searchBy|
|bank of greece|name|

Scenario: search by name and navigate to search results pages using Previous/Next link BUG:927
Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the next page link
Then the user should see the search results paginated for the searched entity
When the user clicks on the previous page link
Then the user should see the search results paginated for the searched entity

Examples:
|entity|searchBy|
|First National Bank|name|

Scenario: search by fid and verify legal entity head office (not with fid -0)
Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown

Then the user should see the legal entity search results card matching the searched entity
|FID|TFPID|NAME|ADDRESS|STATUS|
|1||AB Banka as|Gp Building, No.30, Kamala Iind Street, Chinna Chokkikulam|inactive|

Then the user should see the search results paginated for the searched entity
And the user should see the number of records displayed in the page w.r.t total search results

Examples:
|entity|searchBy|
|1|fid|

Scenario: Bug:ZEUS-930- LegalEntity search results are not showing up
Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown

Then the user should see the legal entity search results card matching the searched entity
|FID|TFPID|NAME|ADDRESS|STATUS|
|224355||American Life Hayat Sigorta AS||active|

Then the user should see the search results paginated for the searched entity
And the user should see the number of records displayed in the page w.r.t total search results

Examples:
|entity|searchBy|
|224355|fid|