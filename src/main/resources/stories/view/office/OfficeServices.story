Meta:@OfficeServices  @Office @View

Narrative:
In order to view and edit the office
As a user
I want to cover the requirements mentioned in
JIRA ID - ZEUS - 407 - User can view office services

Scenario: Verify office services (Office Id- c6458990-e7e7-4155-9024-7af61d55f9e9 )
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
When the user clicks on the office services link in the navigation bar

Then the user should see the office's services as:
|SERVICE CATEGORY|SERVICE OVERRIDE|
|Capital Markets||
|Documentary Collections|Quality Certifications|
|Equity Investments||
|Loans|Medium Terms Loans|
|Mergers and Acquisitions||
|Syndicated Loans||
|Underwriting||
|Advisory & Information Services|Advisory for Environment|


Examples:
|entity|searchBy|fid|officeFid|
|MPS Capital Services Banca per le Imprese SpA|Name|3314|3314-0|

Scenario: Verify no office services (Office Id - cac0b9d5-8043-40d2-80cd-aea4180c74cb)
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
When the user clicks on the office services link in the navigation bar

Then the user should not see the office's services

Examples:
|entity|searchBy|fid|officeFid|
|Anchor Savings Bank|Name|41031|41031-1|