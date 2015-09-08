Meta:@Details

Narrative:
In order to view stub entry details
As a user when I search by Name, FID, TFPID and click on the search results card I can view details
I want to cover the requirements mentioned in
JIRA ID - ZEUS-54 - (User can view entity stub entry)
JIRA ID - ZEUS-74 - (User can view entity stub entry - head office information and address)

Scenario: search by fid, click on result card and verify values for stub entry
Meta:@verifyBuild
Given a user is on the search page
When the user searches for <entity> with <field> equals <value>
And the user clicks on the search results card with fid <value>
Then the user should see the details page for the selected institution
Then the user should see the legal name as <legalName> in the details page
And the user should see the former names as <formerNames> in the details page
And the user should see the country of operations as <country> in the details page
And the user should see the status as <status> in the details page

Examples:
|entity|field|value|legalName|formerNames|country|status|
|legalEntity|fid|1038|Bank of America National Association|Bank of America National Trust & Savings Association|USA|Active|

Scenario: search by fid, click on result card and verify values for stub entry
Given a user is on the search page
When the user searches for <entity> with <field> equals <value>
And the user clicks on the search results card with fid <value>
Then the user should see the details page for the selected institution
Then the user should see the office type as head office in the details page
And the user should see the office name as <officeName> in the details page
And the user should see the <addressType> and <addressInfo> in the details page
And the user should see the fax information <fax> in the details page
And the user should see the email information <email> in the details page
And the user should see the telex information <telex> in the details page
And the user should see the telephone information <telephone> in the details page

Examples:
|entity|field|value|legalName|officeName|addressType|addressInfo|fax|email|telex|telephone|
|legalEntity|fid|68707|UBS AG|Bahnhofstrasse|Physical Address|Bahnhofstrasse 45|+41-44-2399111|info@ubs.com|813811|+41-44-2341111|