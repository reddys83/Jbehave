Meta:@Design


Scenario: Verify the basic info for legalEntity (BUG : ZEUS-950)
Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
Then the user should see the search results for the institution
When the user clicks on the search results card with fid <fid>
Then the user should see the basic info label for selected legal entity
Then the user verifies basic info for legal entity left column <fid> from trusted document

And the user should see the legalEntity names for <fid> in the legalEntity basic info

And the user should see the legalEntity types for <fid> in the legalEntity basic info

And the user should see the legal entity's virtual presence as:
|TYPE|RANK|INFO|VALUE|
|Website||dnb.no|http://www.dnb.no|

And the user should see the legal entity corporate statement as Ultimate Parent Company: The Bank of Nova Scotia 1709 Hollis Street, Halifax, NS B3J 3B7, Canada

Examples:
|entity|searchBy|headOfficeAddress|fid|tfpid|
|DNB Bank ASA|Name|Dronning Eufemias gate 300191|4537|96664340|