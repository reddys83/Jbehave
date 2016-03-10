Meta:@Design

Scenario: save country basic info
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
And the user clicks on the update link
When the user enters country start year as <countryStartYear>
And the user enters country end year as <countryEndYear>
And the user clicks on the save button
And the user clicks on the confirm button
Then the user should see the edits to country basic info in zeus document
And the user reverts the changes to the country Bosnia-Herzegovina

Examples:
|country|countryStartYear|countryEndYear|
|Bosnia-Herzegovina|2014|2015|