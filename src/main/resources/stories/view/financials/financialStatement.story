Meta:@FinancialStatement @financials @View @AllStories

Narrative:
In order to view the legalEntity
As a user
I want to cover the requirements mentioned in
JIRA ID - ZEUS-1167 - User can view a Legal Entity's Financial Statement FINANCIALS (Left menu & header)



Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
Then the user should see the search results for the institution
When the user clicks on the search results card with fid <fid>
And the user clicks on the financials link in the legal entity page
Then the user should see the missing items retrieved from trusted document

Examples:
|entity|searchBy|fid|entityFid|
|237381|fid|237381|237381-20101231-1|
