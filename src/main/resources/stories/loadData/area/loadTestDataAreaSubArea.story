Meta:@loadData
Narrative:
Reloading the data after data refresh

Scenario: Used for loading test data after data refresh for Area and Sub Area.
Create test data for Area-> Illinois and SubArea-> Cook

Given the user loads area test data for nightly runs in database <xqueryName>
And the user updates office with fid <entityFid>

Examples:
|xqueryName|
|load test data for Area illinois|
|load test data for sub area Cook|