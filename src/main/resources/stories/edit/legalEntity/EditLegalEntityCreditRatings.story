Meta:@EditLegalEntityCreditRatings @Edit @LegalEntity

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal
JIRA ID - ZEUS-911 - User can edit Legal Entity's Credit Ratings

Scenario: Verify Legal Entity's Credit Ratings Agency and Type dropdown values are
from lookup CREDIT_RATING_AGENCY and CREDIT_RATING_TYPE respectively in the same order as taxonomy
a) Verify for an existing CreditRating's row, the Credit Rating's Agency values are from CREDIT_RATING_AGENCY
b) Verify for an existing CreditRating's row, the Credit Rating's Type values are from CREDIT_RATING_TYPE
c) Verify for a new CreditRating's row, the Credit Rating's Agency values are from CREDIT_RATING_AGENCY
d) Verify for a new CreditRating's row, the Credit Rating's Type values are from CREDIT_RATING_TYPE
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the legal entity credit rating link in the navigation bar
And the user clicks on the legalEntity update link
Then the user should see the legalEntity_first_row_existing_creditrating_Agency_dropdown values in credit rating's section from lookup CREDIT_RATING_AGENCY
And the user should see the legalEntity_first_row_existing_creditrating_Agency_Type_dropdown values in credit rating's section from lookup CREDIT_RATING_TYPE
When the user clicks on add new credit rating button in the credit rating legal Entity page
Then the user should see the legalEntity_first_row_new_creditrating_Agency_dropdown values in credit rating's section from lookup CREDIT_RATING_AGENCY
And the user should see the legalEntity_first_row_new_creditrating_Type_dropdown values in credit rating's section from lookup CREDIT_RATING_TYPE
Examples:
|entity|searchBy|fid|
|1717|FID|1717|

Scenario: Update and Save existing credit ratings
a) User selects a new value for Agency, Type, Value, Applied Date and Confirmed Date and click Save. Updated Credit rating should be saved in Zeus document
b) User selects a new value for Agency, Type, Value and no values for Applied Date and Confirmed Date and click Save. Updated Credit rating should be saved in Zeus document
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the legal entity credit rating link in the navigation bar
And the user clicks on the legalEntity update link
Then the user should see the credit ratings values as in trusted document with fid <fid>
When the user gets the document with get Id for legalentity with the fid as <entity> from the database
And the user selects agency legalEntity_first_row_existing_creditrating_Agency_dropdown value as <agencyName>
And the user selects agency type legalEntity_first_row_existing_creditrating_Agency_Type_dropdown value as <type>
And the user enters agency value legalEntity_first_row_existing_creditrating_Agency_Value value as <value>
And the user enters agency AppliedDate day legalEntity_first_row_existing_creditrating_Agency_AppliedDateDay value as <AppliedDateDay>
And the user selects agency AppliedDate month legalEntity_first_row_existing_creditrating_Agency_AppliedDateMonth value as <AppliedDateMonth>
And the user enters agency AppliedDate year legalEntity_first_row_existing_creditrating_Agency_AppliedDateYear value as <AppliedDateYear>
And the user enters agency ConfirmedDate day legalEntity_first_row_existing_creditrating_Agency_ConfirmedDateDay value as <ConfirmedDateDay>
And the user selects agency ConfirmedDate month legalEntity_first_row_existing_creditrating_Agency_ConfirmedDateMonth value as <ConfirmedDateMonth>
And the user enters agency ConfirmedDate year legalEntity_first_row_existing_creditrating_Agency_ConfirmedDateYear value as <ConfirmedDateYear>
And the user clicks on the save button
Then the user should see the save confirmation modal
When the user clicks on the confirm button
Then the user should see creditratings values as <agencyName><type><value><AppliedDateDay><AppliedDateMonth><AppliedDateYear><ConfirmedDateDay><ConfirmedDateMonth><ConfirmedDateYear> for fid <fid> in zeus document
Then the user reverts the changes to the document
Examples:
|entity|searchBy|fid|agencyName|type|value|AppliedDateDay|AppliedDateMonth|AppliedDateYear|ConfirmedDateDay|ConfirmedDateMonth|ConfirmedDateYear|
|1165|FID|1165|Standard & Poors|Short Term Rating|B-|||||||
|1165|FID|1165|Standard & Poors|Short Term Rating|B-|7|Oct|2014|9|Mar|2016|


Scenario: Update and Save all existing credit ratings values to null
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the legal entity credit rating link in the navigation bar
And the user clicks on the legalEntity update link
Then the user should see the credit ratings values as in trusted document with fid <fid>
When the user gets the document with get Id for legalentity with the fid as <entity> from the database
And the user selects agency legalEntity_first_row_existing_creditrating_Agency_dropdown value as <agencyName>
And the user selects agency type legalEntity_first_row_existing_creditrating_Agency_Type_dropdown value as <type>
And the user enters agency value legalEntity_first_row_existing_creditrating_Agency_Value value as <value>
And the user enters agency AppliedDate day legalEntity_first_row_existing_creditrating_Agency_AppliedDateDay value as <AppliedDateDay>
And the user selects agency AppliedDate month legalEntity_first_row_existing_creditrating_Agency_AppliedDateMonth value as <AppliedDateMonth>
And the user enters agency AppliedDate year legalEntity_first_row_existing_creditrating_Agency_AppliedDateYear value as <AppliedDateYear>
And the user enters agency ConfirmedDate day legalEntity_first_row_existing_creditrating_Agency_ConfirmedDateDay value as <ConfirmedDateDay>
And the user selects agency ConfirmedDate month legalEntity_first_row_existing_creditrating_Agency_ConfirmedDateMonth value as <ConfirmedDateMonth>
And the user enters agency ConfirmedDate year legalEntity_first_row_existing_creditrating_Agency_ConfirmedDateYear value as <ConfirmedDateYear>
And the user clicks on the save button
Then the user should see the save confirmation modal
When the user clicks on the confirm button
Then the user should not see creditratings values for fid <fid> in zeus document as:
|agencyName|type|value|AppliedDateDay|AppliedDateMonth|AppliedDateYear|ConfirmedDateDay|ConfirmedDateMonth|ConfirmedDateYear|
|Standard & Poors|Short Term Rating|B-|5|Jan|2013|10|Jan|2015|

Then the user reverts the changes to the document
Examples:
|entity|searchBy|fid|agencyName|type|value|AppliedDateDay|AppliedDateMonth|AppliedDateYear|ConfirmedDateDay|ConfirmedDateMonth|ConfirmedDateYear|
|1165|FID|1165||||||||||


Scenario: Add and Save new credit ratings
a) User selects a new value for Agency, Type, Value, Applied Date and Confirmed Date and click Save. New Credit rating should be saved in Zeus document
b) User selects a new value for Agency, Type, Value and no values for Applied Date and Confirmed Date and click Save. New Credit rating should be saved in Zeus document
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the legal entity credit rating link in the navigation bar
And the user clicks on the legalEntity update link
When the user gets the document with get Id for legalentity with the fid as <entity> from the database
And the user clicks on add new credit rating button in the credit rating legal Entity page
And the user selects agency legalEntity_first_row_new_creditrating_Agency_dropdown value as <agencyName>
And the user selects agency type legalEntity_first_row_new_creditrating_Type_dropdown value as <type>
And the user enters agency value legalEntity_first_row_new_creditrating_Agency_Value value as <value>
And the user enters agency AppliedDate day legalEntity_first_row_new_creditrating_Agency_AppliedDateDay value as <AppliedDateDay>
And the user selects agency AppliedDate month legalEntity_first_row_new_creditrating_Agency_AppliedDateMonth value as <AppliedDateMonth>
And the user enters agency AppliedDate year legalEntity_first_row_new_creditrating_Agency_AppliedDateYear value as <AppliedDateYear>
And the user enters agency ConfirmedDate day legalEntity_first_row_new_creditrating_Agency_ConfirmedDateDay value as <ConfirmedDateDay>
And the user selects agency ConfirmedDate month legalEntity_first_row_new_creditrating_Agency_ConfirmedDateMonth value as <ConfirmedDateMonth>
And the user enters agency ConfirmedDate year legalEntity_first_row_new_creditrating_Agency_ConfirmedDateYear value as <ConfirmedDateYear>
And the user clicks on the save button
Then the user should see the save confirmation modal
When the user clicks on the confirm button
Then the user should see creditratings values as <agencyName><type><value><AppliedDateDay><AppliedDateMonth><AppliedDateYear><ConfirmedDateDay><ConfirmedDateMonth><ConfirmedDateYear> for fid <fid> in zeus document
Then the user reverts the changes to the document
Examples:
|entity|searchBy|fid|agencyName|type|value|AppliedDateDay|AppliedDateMonth|AppliedDateYear|ConfirmedDateDay|ConfirmedDateMonth|ConfirmedDateYear|
|1165|FID|1165|Standard & Poors|Short Term Rating|B-|||||||
|1165|FID|1165|Standard & Poors|Short Term Rating|B-|7|Oct|2014|9|Mar|2016|


Scenario:
a. Add and Save all new credit ratings values to null. Should not get any erros
b. Verify the maxlength value is 5 for Value field.
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the legal entity credit rating link in the navigation bar
And the user clicks on the legalEntity update link
Then the user should see the credit ratings values as in trusted document with fid <fid>
When the user clicks on add new credit rating button in the credit rating legal Entity page
Then the user verifies the credit ratings value maxlength is 5 for the row legalEntity_first_row_new_creditrating_Agency_Value
When the user selects agency legalEntity_first_row_new_creditrating_Agency_dropdown value as <agencyName>
And the user selects agency type legalEntity_first_row_new_creditrating_Type_dropdown value as <type>
And the user enters agency value legalEntity_first_row_new_creditrating_Agency_Value value as <value>
And the user enters agency AppliedDate day legalEntity_first_row_new_creditrating_Agency_AppliedDateDay value as <AppliedDateDay>
And the user selects agency AppliedDate month legalEntity_first_row_new_creditrating_Agency_AppliedDateMonth value as <AppliedDateMonth>
And the user enters agency AppliedDate year legalEntity_first_row_new_creditrating_Agency_AppliedDateYear value as <AppliedDateYear>
And the user enters agency ConfirmedDate day legalEntity_first_row_new_creditrating_Agency_ConfirmedDateDay value as <ConfirmedDateDay>
And the user selects agency ConfirmedDate month legalEntity_first_row_new_creditrating_Agency_ConfirmedDateMonth value as <ConfirmedDateMonth>
And the user enters agency ConfirmedDate year legalEntity_first_row_new_creditrating_Agency_ConfirmedDateYear value as <ConfirmedDateYear>
And the user clicks on the save button
Then the user should see the save confirmation modal
When the user clicks on the confirm button
Examples:
|entity|searchBy|fid|agencyName|type|value|AppliedDateDay|AppliedDateMonth|AppliedDateYear|ConfirmedDateDay|ConfirmedDateMonth|ConfirmedDateYear|
|1165|FID|1165||||||||||

Scenario: Delete and Save existing credit ratings
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the legal entity credit rating link in the navigation bar
And the user clicks on the legalEntity update link
When the user gets the document with get Id for legalentity with the fid as <entity> from the database
And the user clicks on add new credit rating button in the credit rating legal Entity page
And the user clicks on delete legal entity credit rating row button for the row legalEntity_first_existing_row_creditrating_delete_button
Then the user should see the delete row confirmation modal in the legal entity page
When the user clicks on the yes button in the delete row confirmation modal in the legal entity basic info page
And the user clicks on the save button
Then the user should see the save confirmation modal
When the user clicks on the confirm button
Then the user should not see creditratings values for fid <fid> in zeus document as:
|agencyName|type|value|AppliedDateDay|AppliedDateMonth|AppliedDateYear|ConfirmedDateDay|ConfirmedDateMonth|ConfirmedDateYear|
|Standard & Poors|Short Term Rating|B-|5|Jan|2013|10|Jan|2015|
Then the user reverts the changes to the document
Examples:
|entity|searchBy|fid|
|1165|FID|1165|

Scenario: Delete newly added credit ratings row
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the legal entity credit rating link in the navigation bar
And the user clicks on the legalEntity update link
When the user gets the document with get Id for legalentity with the fid as <entity> from the database
And the user clicks on add new credit rating button in the credit rating legal Entity page
And the user clicks on delete legal entity credit rating row button for the row legalEntity_first_new_row_creditrating_delete_button
Then the user should see the delete row confirmation modal in the legal entity page
When the user clicks on the no button in the delete row confirmation modal in the legal entity page
Then the user should still see the new credit ratings row with legalEntity_first_row_new_creditrating_Agency_dropdown
When the user clicks on delete legal entity credit rating row button for the row legalEntity_first_new_row_creditrating_delete_button
Then the user should see the delete row confirmation modal in the legal entity page
When the user clicks on the yes button in the delete row confirmation modal in the legal entity basic info page
Then the user should not see the new credit ratings row with legalEntity_first_row_new_creditrating_Agency_dropdown
Examples:
|entity|searchBy|fid|
|1165|FID|1165|


Scenario:
a. Verify that the user User should see Required error message for both Type and value when select a value for Agency but keeps the Type and Value as blank
b. User should see Required error message for both Agency and value when  selects Type but keeps the Agency and Value as blank
c. User should see Required error message for both Agency and Type when enters a valid value for Value but keeps the Agency and Type as blank
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the legal entity credit rating link in the navigation bar
And the user clicks on the legalEntity update link
When the user gets the document with get Id for legalentity with the fid as <entity> from the database
And the user clicks on add new credit rating button in the credit rating legal Entity page
And the user selects agency legalEntity_first_row_new_creditrating_Agency_dropdown value as <agencyName>
And the user selects agency type legalEntity_first_row_new_creditrating_Type_dropdown value as <type>
And the user clicks on the save button
Then the user should see the error message Enter up to 5 valid characters. for the credit ratings agency value field
And the user should see the error message at top of page the highlighted fields must be addressed before this update can be saved
When the user clicks on delete legal entity credit rating row button for the row legalEntity_first_new_row_creditrating_delete_button
And the user clicks on the yes button in the delete row confirmation modal in the legal entity basic info page
And the user clicks on add new credit rating button in the credit rating legal Entity page
When the user selects agency legalEntity_first_row_new_creditrating_Agency_dropdown value as <agencyName>
And the user enters agency value legalEntity_first_row_new_creditrating_Agency_Value value as <value>
And the user clicks on the save button
Then the user should see the error message Required for the credit ratings agency type field
And the user should see the error message at top of page the highlighted fields must be addressed before this update can be saved
When the user clicks on delete legal entity credit rating row button for the row legalEntity_first_new_row_creditrating_delete_button
And the user clicks on the yes button in the delete row confirmation modal in the legal entity basic info page
And the user clicks on add new credit rating button in the credit rating legal Entity page
When the user selects agency type legalEntity_first_row_new_creditrating_Type_dropdown value as <type>
And the user enters agency value legalEntity_first_row_new_creditrating_Agency_Value value as <value>
And the user clicks on the save button
Then the user should see the error message Required for the credit ratings agency name field
And the user should see the error message at top of page the highlighted fields must be addressed before this update can be saved
Examples:
|entity|searchBy|fid|agencyName|type|value|
|1165|FID|1165|Standard & Poors|Short Term Rating|B-|

Scenario: User updates invalid Applied date and Confirmed date
Verifying error message displaying Invalid Date when invalid date entered.
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the legal entity credit rating link in the navigation bar
And the user clicks on the legalEntity update link
And the user clicks on add new credit rating button in the credit rating legal Entity page
And the user enters agency AppliedDate day legalEntity_first_row_new_creditrating_Agency_AppliedDateDay value as <AppliedDateDay>
And the user selects agency AppliedDate month legalEntity_first_row_new_creditrating_Agency_AppliedDateMonth value as <AppliedDateMonth>
And the user enters agency AppliedDate year legalEntity_first_row_new_creditrating_Agency_AppliedDateYear value as <AppliedDateYear>
And the user enters agency ConfirmedDate day legalEntity_first_row_new_creditrating_Agency_ConfirmedDateDay value as <ConfirmedDateDay>
And the user selects agency ConfirmedDate month legalEntity_first_row_new_creditrating_Agency_ConfirmedDateMonth value as <ConfirmedDateMonth>
And the user enters agency ConfirmedDate year legalEntity_first_row_new_creditrating_Agency_ConfirmedDateYear value as <ConfirmedDateYear>
When the user clicks on the save button
Then the user should see the error 'Invalid Date' for Applied date
Then the user should see the error 'Invalid Date' for Confirmed date
And the user should see the error message at top of page the highlighted fields must be addressed before this update can be saved
Examples:
|entity|searchBy|fid|agencyName|type|value|AppliedDateDay|AppliedDateMonth|AppliedDateYear|ConfirmedDateDay|ConfirmedDateMonth|ConfirmedDateYear|
|1165|FID|1165|Standard & Poors|Short Term Rating|B-|invalid|Jan|2013|invalid|Jan|2015|
|1165|FID|1165|Standard & Poors|Short Term Rating|B-|9|Jan|invalid|9|Aug|invalid|


Scenario: Verify that Month,Day and Year are required for Applied Date and Confirmed Date
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the legal entity credit rating link in the navigation bar
And the user clicks on the legalEntity update link
And the user clicks on add new credit rating button in the credit rating legal Entity page
And the user enters agency AppliedDate day legalEntity_first_row_new_creditrating_Agency_AppliedDateDay value as <AppliedDateDay>
And the user selects agency AppliedDate month legalEntity_first_row_new_creditrating_Agency_AppliedDateMonth value as <AppliedDateMonth>
And the user enters agency AppliedDate year legalEntity_first_row_new_creditrating_Agency_AppliedDateYear value as <AppliedDateYear>
And the user enters agency ConfirmedDate day legalEntity_first_row_new_creditrating_Agency_ConfirmedDateDay value as <ConfirmedDateDay>
And the user selects agency ConfirmedDate month legalEntity_first_row_new_creditrating_Agency_ConfirmedDateMonth value as <ConfirmedDateMonth>
And the user enters agency ConfirmedDate year legalEntity_first_row_new_creditrating_Agency_ConfirmedDateYear value as <ConfirmedDateYear>
When the user clicks on the save button
Then the user should see the error 'Enter a day/month/year.' for Applied date
Then the user should see the error 'Enter a day/month/year.' for Confirmed date
And the user should see the error message at top of page the highlighted fields must be addressed before this update can be saved
Examples:
|entity|searchBy|fid|agencyName|type|value|AppliedDateDay|AppliedDateMonth|AppliedDateYear|ConfirmedDateDay|ConfirmedDateMonth|ConfirmedDateYear|
|1165|FID|1165|Standard & Poors|Short Term Rating|B-||Jan|2013||Jan|2015|
|1165|FID|1165|Standard & Poors|Short Term Rating|B-|9|Jan||9|Aug||
|1165|FID|1165|Standard & Poors|Short Term Rating|B-|9||2013|9||2015|

Scenario: Verify that Applied Date and Confirmed Date can not be later than today
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the legal entity tab in the data area
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with fid <fid>
And the user clicks on the legal entity credit rating link in the navigation bar
And the user clicks on the legalEntity update link
And the user clicks on add new credit rating button in the credit rating legal Entity page
And the user enters agency AppliedDate day legalEntity_first_row_new_creditrating_Agency_AppliedDateDay value as <AppliedDateDay>
And the user selects agency AppliedDate month legalEntity_first_row_new_creditrating_Agency_AppliedDateMonth value as <AppliedDateMonth>
And the user enters agency AppliedDate year legalEntity_first_row_new_creditrating_Agency_AppliedDateYear value as <AppliedDateYear>
And the user enters agency ConfirmedDate day legalEntity_first_row_new_creditrating_Agency_ConfirmedDateDay value as <ConfirmedDateDay>
And the user selects agency ConfirmedDate month legalEntity_first_row_new_creditrating_Agency_ConfirmedDateMonth value as <ConfirmedDateMonth>
And the user enters agency ConfirmedDate year legalEntity_first_row_new_creditrating_Agency_ConfirmedDateYear value as <ConfirmedDateYear>
When the user clicks on the save button
Then the user should see the error 'Must be no later than today.' for Applied date
Then the user should see the error 'Must be no later than today.' for Confirmed date
And the user should see the error message at top of page the highlighted fields must be addressed before this update can be saved
Examples:
|entity|searchBy|fid|agencyName|type|value|AppliedDateDay|AppliedDateMonth|AppliedDateYear|ConfirmedDateDay|ConfirmedDateMonth|ConfirmedDateYear|
|1165|FID|1165|Standard & Poors|Short Term Rating|B-|9|Jan|2025|19|Jan|2025|
