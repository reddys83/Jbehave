Meta:@LegalEntityTrustPowers @LegalEntity

Narrative:
In order to view and edit the legalEntity
As a user
I want to cover the requirements mentioned in
JIRA ID - ZEUS-396 User can view legal entity trust powers

Scenario: Verify legalEntity trust powers
1. BUG-ID - ZEUS-627
Meta:
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
When the user clicks on the legal entity tust power link in the navigation bar
Then the user should see the legal entity's trust power as:
|GRANTED|FULL|USED|PROF.EMPLOYEES|ADMIN EMPLOYEES|MIN ACCOUNT SIZE($)|
|true|true|true|2|1|10000|

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
|Federation Nationale des Caisse d'Epargne|Name|153965|