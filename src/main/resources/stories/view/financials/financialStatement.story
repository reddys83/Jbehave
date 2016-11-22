Meta:@FinancialStatement @financials @View @AllStories

Narrative:
In order to view the legalEntity
As a user
I want to cover the requirements mentioned in
JIRA ID - ZEUS-1167 - User can view a Legal Entity's Financial Statement FINANCIALS (Left menu & header)
JIRA ID - ZEUS-1532 - User can view a Legal Entity's Financial Statement LINE ITEMS

Scenario: Verify legalEntity financialStatement periodEnd date(Left menu)
testdata:
 1.legalEntity which has more than one financialStatement
 2.legalEntity which has only one financialStatement
 3.legalEntity with no financialStatements
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
|286840|fid|286840|

Scenario: User should verify the following
a)Line Item values (Type, Calculated, Value, NormalizedValue & Notes) should be displayed in UI from Trusted document
b)Type Name Fid values should be displayed from look up FINANCIAL_LINE_ITEM_TYPE
c)Line Items should be sorted as per look up

Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
Then the user should see the search results for the institution
When the user clicks on the search results card with fid <fid>
And the user clicks on the financials link in the legal entity page
When the user clicks on <displayDate> on the left navigation
Then the user should see the line items are sorted as per lookup
Then the user should see the line items retrieved from trusted document

Examples:
|entity|searchBy|fid|displayDate|
|237381|fid|237381|2010 DEC 31|