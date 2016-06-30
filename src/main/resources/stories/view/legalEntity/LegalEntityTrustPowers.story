Meta:@LegalEntityTrustPowers @LegalEntity @View @AllStories

Narrative:
In order to view and edit the legalEntity
As a user
I want to cover the requirements mentioned in
JIRA ID - ZEUS-396 User can view legal entity trust powers

Scenario: Verify legalEntity trust powers
BUG-ID - ZEUS-627 - Legal Entity Trust Powers - Case transformation should not happen when displaying the values.
Meta:
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
When the user clicks on the legal entity tust power link in the navigation bar
Then the user should see the legal entity's trust powers for fid <fid> from trusted document

Examples:
|entity|searchBy|fid|
|73788|FID|73788|

Scenario: Verify legalEntity has no trust powers
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
When the user clicks on the legal entity tust power link in the navigation bar
Then the user should not see the legal entity's trust powers

Examples:
|entity|searchBy|fid|
|Nodus International Bank Inc|Name|223191|

Scenario: Veirfy LegalEntity trust powers section will appear for the entities that will match below criteria:
Legal entity type is one of the values Bank, Building Society, Credit Union, Government, Savings & Loan Association, Savings Bank, Trust Company
and Legal Entity country of operations is one of the values US, VI, MP, GU, PR, AS
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
Then the user should see the trust power section visible for fid <fid>
When the user clicks on the legal entity all link in the navigation bar
Then the user should see the trust power section in the All page of the legal Entity page

Examples:
|entity|searchBy|fid|
|1038|FID|1038|
|80395|FID|80395|
|254972|FID|254972|
|254930|FID|254930|
|263791|FID|263791|
|80399|FID|80399|
|223191|FID|223191|



Scenario: a) Verify LegalEntity trust powers section will not appear for the entities which do not match below criteria:
Legal entity type is one of the values Bank, Building Society, Credit Union, Government, Savings & Loan Association, Savings Bank, Trust Company
and Legal Entity country of operations is one of the values US, VI, MP, GU, PR, AS

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
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
|259534|FID|259534|
