Meta:@loadTestDataFinancialStatement @loadData
Narrative:
Reloading the data after data refresh

Scenario: Data upload for financialStatements

Given the user updates financialStatement with fid <entityFid>

Examples:
|entityFid|
|1234-20071231-1|
|1234-20081231-1|
|1234-20091231-1|
|1234-20101231-1|
|60115-20131231-1|