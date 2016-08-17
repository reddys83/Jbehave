Meta:@EditLegalEntityTrustPowers @Edit @LegalEntity @AllStories

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal
JIRA ID - ZEUS-913 - User can edit Legal Entity's Trust Powers

Scenario: Verify user can edit the Trust Powers and can save the values when Granted value is true.
a)Set all the trust power values
b)Leave Admin Employees value as blank
c)Leave min Account Size value as blank

Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the legalEntity update link
When the user clicks on the legal entity tust power link in the navigation bar
Then the user should see the trust power values as in trusted document with fid <fid> in edit mode
When the user gets the document with get Id for legalentity with the fid as <entity> from the database
And the user selects the trust powers granted value as <grantedValue>
And the user selects the trust powers full value as <fullValue>
And the user selects the trust powers used value as <usedValue>
And the user enters the trust powers professional employees value as <profEmployees>
And the user enters the trust powers admin employees value as <adminEmployees>
And the user enters the trust powers min account size value as <minacctSize>
And the user clicks on the save button
Then the user should see the save confirmation modal
When the user clicks on the confirm button
Then the user should see trust power values as <grantedValue><fullValue><usedValue><profEmployees><adminEmployees><minacctSize> for fid <fid> in zeus document
And the user reverts the changes to the document



Examples:
|entity|searchBy|fid|grantedValue|fullValue|usedValue|profEmployees|adminEmployees|minacctSize|
|1010|fid|1010|true|false|true||12345678|1234567890|
|1010|fid|1010|true|true|false|12345678||1234567890|
|1010|fid|1010|true|true|true|12345678|12345678||

Scenario: Verify user all other trust power fields will become disabled and the values retain when
a)Set the Granted value to false
b)Set the Granted value to null

Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the legalEntity update link
When the user clicks on the legal entity tust power link in the navigation bar
Then the user should see the trust power values as in trusted document with fid <fid> in edit mode
When the user gets the document with get Id for legalentity with the fid as <entity> from the database
And the user selects the trust powers granted value as <grantedValue>
Then the user should see the other trust power fields in disabled state
Then the user should see the disabled trust power values same as in trusted document with fid <fid> in edit mode
When the user clicks on the save button
Then the user should see the save confirmation modal
When the user clicks on the confirm button
Then the user should see trust power values as <grantedValue><fullValue><usedValue><profEmployees><adminEmployees><minacctSize> for fid <fid> in zeus document
And the user reverts the changes to the document

Examples:
|entity|searchBy|fid|grantedValue|fullValue|usedValue|profEmployees|adminEmployees|minacctSize|
|1010|fid|1010|false||||||
|1010|fid|1010|||||||


Scenario: Verify user all other trust power fields will become enabled and the values retain when
a)Set the Granted value from false to true
b)Set the Granted value from null to true

Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the legalEntity update link
When the user clicks on the legal entity tust power link in the navigation bar
Then the user should see the trust power values as in trusted document with fid <fid> in edit mode
When the user gets the document with get Id for legalentity with the fid as <entity> from the database
And the user selects the trust powers granted value as <grantedValue>
When the user clicks on the save button
Then the user should see the save confirmation modal
When the user clicks on the confirm button
When the user clicks on the legalEntity update link
Then the user should see the other trust power fields in disabled state
Then the user should see the disabled trust power values same as in trusted document with fid <fid> in edit mode
When the user selects the trust powers granted value as <grantedValue1>
Then the user should see the other trust power fields in enabled state
Then the user should see the enabled trust power values same as in trusted document with fid <fid> in edit mode
And the user reverts the changes to the document

Examples:
|entity|searchBy|fid|grantedValue|grantedValue1|
|1010|fid|1010|false|true|
|1010|fid|1010||true|


Scenario:
a) Verify Legal Entity's identifier value field max length is 50
b) Verify error messages for the fields when enter invalid values
Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the legalEntity update link
When the user clicks on the legal entity tust power link in the navigation bar
Then the user verifies the trust powers professional employees value maxlength is 8
Then the user verifies the trust powers admin employees value maxlength is 8
Then the user verifies the trust powers min account size value maxlength is 10
When the user selects the trust powers granted value as <grantedValue>
And the user enters the trust powers professional employees value as <profEmployees>
And the user enters the trust powers admin employees value as <adminEmployees>
And the user enters the trust powers min account size value as <minacctSize>
And the user clicks on the save button
Then the user should see the error message Enter up to 8 valid numbers. for prof Employees field
Then the user should see the error message Enter up to 8 valid numbers. for prof Admin field
Then the user should see the error message Enter up to 10 valid numbers. for min account size field

Examples:
|entity|searchBy|fid|grantedValue|profEmployees|adminEmployees|minacctSize|
|1010|fid|1010|true|test|test|test|
