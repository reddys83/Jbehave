Meta:@EditOfficeLocations @Edit @Office @AllStories

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal


Scenario: Verify if the user can edit postal code position

Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
And the user clicks on the office locations link in the navigation bar
And the user clicks on the office update link
And the user gets the document with get id for offices with the <officeFid> from the database
When the user clicks on the choose a country option in the office locations
When the user enters the office country <Country> in the type-ahead box
Then the user should verify the postal code position is updated in Office web page
Then the user should verify postal code position is zeus document

Examples:
|entity|searchBy|fid|officeFid|Country|postalCodePosition|
|1045|FID|1045|1045-26|USA|US|









