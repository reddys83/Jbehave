Meta:@FinancialStatement @financials @View @AllStories

Narrative:
In order to view the legalEntity
As a user
I want to cover the requirements mentioned in
JIRA ID - ZEUS-1533 - User can view a Legal Entity's Financial Statement MISSING ITEMS

Scenario:
User should verify
a)Missing Items are retrieved from trusted document
b)User is taken to the details screen for the linked Financial Statement when User selects the hyperlink 'Alternate of Statement' field value
c)User is taken to the Basic Info screen of the corresponding legal entity when User selects the hyperlink 'Alternate Entity' field value

Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
Then the user should see the search results for the institution
When the user clicks on the search results card with fid <fid>
And the user clicks on the financials link in the legal entity page
Then the user should see the <displayDate> should be the prefix to the Section Header 'MISSING'
When the user clicks on <periodEndDate> on the left navigation
Then the user should see the missing items retrieved from trusted document
When the user clicks on 'Alternate Entity' hyperlink
Then the user should see Legal Entity basic info page is dispayed
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
Then the user should see the search results for the institution
When the user clicks on the search results card with fid <fid>
And the user clicks on the financials link in the legal entity page
When the user clicks on <periodEndDate> on the left navigation
When the user clicks on 'Alternate of Statement' hyperlink
Then the user should see details screen for the linked Financial Statement is displayed

Examples:
|entity|searchBy|fid|entityFid|periodEndDate|
|237381|fid|237381|237381-20101231-1|2010-12-31|
