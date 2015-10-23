Meta:@LegalEntityTrustPowers  @LegalEntity

Narrative:
In order to view and edit the legalEntity
As a user
I want to cover the requirements mentioned in
JIRA ID - ZEUS-396 User can view legal entity trust powers

Scenario: Verify legalEntity trust powers
Meta:
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
Then the user should see the message you can search for a legal entity at any time using the header search
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
Then the user should see the search results for the institution
When the user clicks on the search results card with fid <fid>
When the user clicks on the legal entity tust power link in the navigation bar
Then the user should see the legal entity's trust power as:
|GRANTED|FULL|USED|PROF.EMPLOYEES|ADMIN EMPLOYEES|MIN ACCOUNT SIZE($)|
|True|True|True|1|1|100|


Examples:
|entity|searchBy|fid|
|Val-Gaz Limited Liability Company|Name|180613|

Scenario: Verify legalEntity has no trust powers
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
Then the user should see the message you can search for a legal entity at any time using the header search
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
Then the user should see the search results for the institution
When the user clicks on the search results card with fid <fid>
When the user clicks on the legal entity tust power link in the navigation bar
Then the user should not see the legal entity's trust powers

Examples:
|entity|searchBy|fid|
|Federation Nationale des Caisse d'Epargne|Name|153965|