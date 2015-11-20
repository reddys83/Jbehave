Meta:@LegalEntityServices @LegalEntity

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal
JIRA ID - ZEUS-393 - User can view legal entity services

Scenario: Verify legalEntity services
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
When the user clicks on the legal entity services link in the navigation bar
Then the user should see the legal entity's offered services as:
|CATEGORY|OVERRIDE|
|Asset Management|Wealth Management|
|Asset Management|Retirement Planning|
|Cash Services|Checking|
|Cash Services|Cash Management|
|Commercial Banking||
|Loans||
|Trust Administration|Estate Management|
|Trusteeship Services|Trust Services|
|Payment Services|Wire Transfers|
|Internet Banking||
|Savings Accounts - Personal||
|Savings Accounts - Personal|Savings Accounts - Business|

Then the user should see the legal entity's financial services as:
|FINANCIAL CATEGORY|FINANCIAL DETAILS|
|Equities|Mutual Funds|
|Equities|Mutual Funds|

Examples:
|entity|searchBy|fid|
|73788|FID|73788|

Scenario: Verify no services for legal entity
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
When the user clicks on the legal entity services link in the navigation bar
Then the user should not see the legal entity's offered services
And the user should not see the legal entity's financial services

Examples:
|entity|searchBy|fid|
|Bank of Montreal|Name|312461|