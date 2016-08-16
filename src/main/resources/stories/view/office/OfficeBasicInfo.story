Meta:@OfficeBasicInfo  @Office @View

Narrative:
In order to view and edit the office
As a user
I want to cover the requirements mentioned in
JIRA ID - ZEUS-404 - User can view office basic info
JIRA ID - ZUES-542 - User will see head office address & legal entity in header of office screen

Scenario: Verify the basic info for office
Given a user is on the search page
Then the user should see the message you can search for a legal entity at any time using the header search
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user navigates to the 4th page on the office search results
And the user clicks on the offices results card with fid <officeFid>
When the user clicks on the office basic info link in the navigation bar

Then the user should see the office's names as:
|TYPE|VALUE|
|Legal Title|Anchor Savings Bank|
|Office Name|BUFFALO BRANCH|

And the user should see the office sort key as BUFFALO BRANCH
And the user should see the office types:
|TYPE|
|Branch|

And the user should see the Prefix of an office as Torrey Pines Bank, A Division of
And the user should see the Suffix of an office as Western NY Division
And the user should see the Override of an office as Mellon Bank, N.A.
And the user should see the Status of an office as inactive
And the user should see the Opened of an office as 1901
And the user should see the Closed of an office as 12 Apr 1993
And the user should see the Lead Location of an office as true
And the user should see the Principal Office of an office as false
And the user should see the Foreign Office of an office as true
And the user should see the Business Hours of an office as Hrs 10-5 Fri 10-6
And the user should see the Add Info of an office as Al Mankhool Branch - Dubai

Examples:
|entity|searchBy|fid|officeFid|headOfficeAddress|officeTfpid|
|Anchor Savings Bank|Name|41031|41031-75|Hewlett, New York, USA|30386260-30364570|


Scenario: Verify the header links in the offices page should navigate to legalEntity page(default view).
Given a user is on the search page
Then the user should see the message you can search for a legal entity at any time using the header search
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
When the user clicks on the legal title in the office headers

Then the user should see the legal entity's names as:
|TYPE|VALUE|
|Legal Title|Bank of Taiwan|
|Former Name|Collins|

Examples:
|entity|searchBy|fid|officeFid|
|Bank of Taiwan|Name|1165|1165-12|

Scenario: verify the legalTitle link in the office search resutls page should navigate to the default view of legalEntity page.
Given a user is on the search page
Then the user should see the message you can search for a legal entity at any time using the header search
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
When the user clicks on the legal title in the office headers

Then the user should see the legal entity's names as:
|TYPE|VALUE|
|Legal Title|Bank of Taiwan|
|Former Name|Collins|

Examples:
|entity|searchBy|fid|
|1165|FID|1165|

Scenario: The office and department tabs should be present in the offices default view page.
Meta:@test123
Given a user is on the search page
Then the user should see the message you can search for a legal entity at any time using the header search
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user navigates to the 4th page on the office search results
And the user clicks on the offices results card with fid <officeFid>
Then the user should see the offices tab in the office page

Examples:
|entity|searchBy|fid|officeFid|headOfficeAddress|officeTfpid|
|Anchor Savings Bank|Name|41031|41031-75|Hewlett, New York, USA|30386260-30364570|

Scenario: Verify legal entity sections list
Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
Then the user should see the below office sections
|SECTIONS|
|ALL|
|BASIC INFO|
|LOCATIONS|
|SERVICES|
|CREDIT RATINGS|
|STATISTICS|
|HISTORY|
|IDENTIFIERS|
|PERSONNEL|

Examples:
|entity|searchBy|fid|officeFid|headOfficeAddress|officeTfpid|
|Bank of America National Association|Name|1038|1038-55|Charlotte, North Carolina, USA||

Scenario: Verify office headers - Bug-ZEUS-1313
Given a user is on the search page
Then the user should see the message you can search for a legal entity at any time using the header search
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
Then the user should see the search results for the institution
When the user clicks on the search results card with fid <fid>
And the user clicks on the offices link in the legal entity page
And the user clicks on the offices results card with fid <officeFid>
Then the user should see the office header with <entity>, <headOfficeAddress>, <officeFid> and <officeTfpid>

Examples:
|entity|searchBy|headOfficeAddress|fid|officeTfpid|officeFid|
|Banque Tarneaud|Name|Limoges, Dept 87, France|1645|20172300-0|1645-0|
|City National Bank of Florida|Name|Miami, Florida, USA|2084|10117220-0|2084-0|
|Degussa Bank AG|Name|Frankfurt am Main, Germany|2312|20229800-0|2312-0|
