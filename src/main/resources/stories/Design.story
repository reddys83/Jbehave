Meta:@Design


Given a user is on the search page
And the user updates office with fid <entityFid>
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <entityFid>
And the user clicks on the office update link
And the user updates principal office flag to <principalFlag>
And the user clicks on the save button
Then the user should not see the below summary changes in confirmation modal
|Summary|
|Basic Info|
When the user clicks on the confirm button
Then the user verifies office principal office is <principalFlag>
And the user verifies office <principalFlag> from zeus document <entityFid>


Examples:
|entity|searchBy|fid|entityFid|principalFlag|
|1010|FID|1010|1010-45|false|