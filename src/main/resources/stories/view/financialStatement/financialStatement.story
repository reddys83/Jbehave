Meta:@FinancialStatementFinancials @FinancialStatement  @View

Narrative:
In order to view the financial statment
As a user
I want to cover the requirements mentioned in
JIRA ID - ZEUS-1636 - User can view a Legal Entity's Financial Statement FINANCIALS (Field values)

Scenario: User is on the Financial Statement page -
a) Verify that user can view Financials section with below fields in view mode
    1 - FINANCIAL STATEMENT TYPE
    2 - PERIOD START DATE
    3 - REPORTING PERIOD END DATE
    4 - REPORTING PERIOD FINANCIAL YEAR END
    5 - STATEMENT CURRENCY
    6 - ORDER OF MAGNITUDE
    7 - CONSOLIDATED
    8 - ACCOUNTING STANDARDS
    9 - AUDITED
    10 - AUDITED BY
    11 - DOCUMENT (PHYSICAL)
    12 - EXCHANGE RATE AT PERIOD END

Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the financials link in the legal entity page
Then the user should see the <latestPeriodEndDate> should be the prefix to the Section Header 'FINANCIALS'
Then the user should see the financials section field values same as in the trusted document of <fid> for <latestPeriodEndDate>
Then the user verifies Audited by field is displayed only when Audited field is true
!--When the user clicks on another <periodEndDate> on the left navigation
!--Then the user should see financials section field values for <periodEndDate>


Examples:
|entity|searchBy|fid|latestPeriodEndDate|periodEndDate|
|1234|FID|1234|2010 DEC 31|2009 DEC 31|


