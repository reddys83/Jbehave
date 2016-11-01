Meta:@FinancialStatement @financials @View @AllStories

Narrative:
In order to view the legalEntity
As a user
I want to cover the requirements mentioned in
JIRA ID - ZEUS-1167 - User can view a Legal Entity's Financial Statement FINANCIALS (Left menu & header)

Scenario: Verify legalEntity financialStatement periodEnd date(Left menu)
testdata:
 1.legalEntity which has more than one financialStatement
 2.legalEntity which has only one financialStatement
 3.legalEntity which one of the financialStatement has only year
 4.legalEntity which one of the financialStatement has only month
 5.legalEntity with no financialStatements
Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
Then the user should see the search results for the institution
When the user clicks on the search results card with fid <fid>
And the user clicks on the financials link in the legal entity page
Then the user should see legalEntity financialStatements for legalEntity <fid> in the left side menu bar

Examples:
|entity|searchBy|fid|
|1234|fid|1234|
|60115|fid|60115|
|1247|fid|1247|
|13927|fid|13927|
|286840|fid|286840|
