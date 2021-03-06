Meta:@EditRoutingCodeBasicInfo @Edit @RoutingCode @AllStories

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal
JIRA ID - ZEUS-1179 - User can select to edit Routing Code's Basic Info
JIRA ID - ZEUS-1474 - User can edit Routing Code Basic Info - Text Fields
JIRA ID - ZEUS-1475 - User can edit Routing Code Basic Info - Date Fields
JIRA ID - ZEUS-1476 - User can edit Routing Code Basic Info - Boolean Fields
JIRA ID - ZEUS-1477 - User can edit Routing Code Basic Info - Drop-down Fields


Scenario: Verify the routing code basic info values in edit mode for ABA and non-ABA code types
Verify the headers and the legal entity link on the header
Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with routing code <routingCode> and code type <codeType>
Then the user should see the routing code basic info page
When the user clicks on the routing code update link
Then the user should see the edit routing code values from trusted document for routing code <routingCode> with code type <codeType>

Examples:
|entity|searchBy|routingCode|codeType|
|083905216|Routing Code|083905216|ABA|
|01056|Routing Code|01056|Swift BIC|
|262176840|Routing Code|262176840|ABA|

Scenario: Verify whether User saves 'Registrar Fee SFDC Subscription Number' & 'Routing Code Comment' are saved successfully in routing code page

Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with routing code <routingCode> and code type <codeType>
Then the user should see the routing code basic info page
When the user clicks on the routing code update link
When the user gets the document with get document id for routing code with the <routingCode> and <codeType> from the database
Then the user should see <registarFeeSFDCSubscription> and <routingCodeComment> field values same as in trusted document
When the user enters the <registarFeeSFDCSubscription> in the routing code basic info page
When the user enters the <routingCodeComment> in the routing code basic info page
And the user clicks on the save button
When the user clicks on the confirm button
Then the user should see the successful update message at top of the routing code page
Then the user should be able to verify the values are entered in the routing code basic info page
Then the user should see the <registarFeeSFDCSubscription> and <routingCodeComment> field values same as in zeus document
Then the user reverts the changes to the document

Examples:
|entity|searchBy|routingCode|codeType|registarFeeSFDCSubscription|routingCodeComment|
|083905216|Routing Code|083905216|ABA|408123|Sample Text|

Scenario: Verify whether User can update (no different to current value) 'Registrar Fee SFDC Subscription Number' & 'Routing Code Comment' successfully in routing code page

Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with routing code <routingCode> and code type <codeType>
Then the user should see the routing code basic info page
When the user clicks on the routing code update link
When the user gets the document with get document id for routing code with the <routingCode> and <codeType> from the database
When the user enters the <registarFeeSFDCSubscription> in the routing code basic info page
When the user enters the <routingCodeComment> in the routing code basic info page
And the user clicks on the save button
Then the user should not see the below summary changes in confirmation modal
|Summary|
|Basic Info|
When the user clicks on the confirm button
Then the user should see the successful update message at top of the routing code page
Then the user should be able to verify the values are entered in the routing code basic info page
Then the user should see the <registarFeeSFDCSubscription> and <routingCodeComment> field values same as in zeus document
Then the user reverts the changes to the document

Examples:
|entity|searchBy|routingCode|codeType|registarFeeSFDCSubscription|routingCodeComment|
|083905216|Routing Code|083905216|ABA|408123|Sample Text|

Scenario: Verify whether User can update blank values/special characters for 'Registrar Fee SFDC Subscription Number' & 'Routing Code Comment'

Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with routing code <routingCode> and code type <codeType>
Then the user should see the routing code basic info page
When the user clicks on the routing code update link
When the user gets the document with get document id for routing code with the <routingCode> and <codeType> from the database
When the user enters the <registarFeeSFDCSubscription> in the routing code basic info page
When the user enters the <routingCodeComment> in the routing code basic info page
And the user clicks on the save button
Then the user should see the below summary changes in confirmation modal
|Summary|
|Basic Info|
When the user clicks on the confirm button
Then the user should see the successful update message at top of the routing code page
Then the user should be able to verify the values are entered in the routing code basic info page
Then the user should see the <registarFeeSFDCSubscription> and <routingCodeComment> field values same as in zeus document
Then the user reverts the changes to the document

Examples:
|entity|searchBy|routingCode|codeType|registarFeeSFDCSubscription|routingCodeComment|
|083905216|Routing Code|083905216|ABA|||
|083905216|Routing Code|083905216|ABA|#%#$%^#$^#@$%^|$@#$@#%#$%^&&^*()_|

Scenario: User verifies that Registar Fee subscription field,Routing Code Comment fields are limited to 30 & 1000 unicode characters & verifies the max length attribute is restricted to 30 & 10000 in routing code Page

Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with routing code <routingCode> and code type <codeType>
Then the user should see the routing code basic info page
When the user clicks on the routing code update link
When the user gets the document with get document id for routing code with the <routingCode> and <codeType> from the database
When the user enters 30 unicode characters in Registar Fee subscription field
When the user enters 1000 unicode characters in Routing Code Comment field
Then the user should see maximum length of Registar Fee subscription field is limited to 30
Then the user should see maximum length of Routing Code Comment field is limited to 1000
When the user clicks on the save button
And the user clicks on the confirm button
Then the user should be able to verify the maximum values are entered in Registar Fee subscription field
Then the user should be able to verify the maximum values are entered in Routing Code Comment field
Then the user reverts the changes to the document

Examples:
|entity|searchBy|routingCode|codeType|
|083905216|Routing Code|083905216|ABA|

Scenario: User is updating a Routing Code's Basic Info - 
a) User verifies that the current Date Field values is same as in trusted document.
b) User verifies the change in confirmation modal by entering Date fields(Start Date, End Date, Forthcoming Retirement Date, Confirmed with Fed)
   that is different from the current Date values.
c) User verifies that blank values is saving successfully in the Routing Code Basic Info page.
d) User verifies that Routing Code Basic Info page and Zeus document is updated.

Given a user is on the search page
When the user selects the <searchBy> from the dropdown
When the user enters the <entity> in the typeahead
And the user clicks on the search button
When the user clicks on the search results card with routing code <routingCode> and code type <codeType>
Then the user should see the routing code basic info page
When the user changes the status for routing code <routingCode> and code type <codeType> to <status>
When the user clicks on the routing code update link
When the user gets the document with get document id for routing code with the <routingCode> and <codeType> from the database
Then the user should see the edit routing code date field values from trusted document for routing code <routingCode> with code type <codeType>
When the user enters <startDateDay> <startDateMonth> <startDateYear> for routing code start date field
When the user enters <endDateDay> <endDateMonth> <endDateYear> for routing code end date field
When the user enters <retirementDay> <retirementMonth> <retirementYear> for routing code forthcoming retirement date field
When the user enters <fedDay> <fedMonth> <fedYear> for routing code confirmed with fed field
When the user clicks on the save button
Then the user should see the save confirmation modal
And the user should see the below summary changes in confirmation modal
|Summary|
|Basic Info|
When the user clicks on the confirm button
Then the user should see the updated date field values in routing code basic info page
Then the user should see the date field values same as in zeus document
Then the user reverts the changes to the document

Examples:
|entity|searchBy|routingCode|codeType|startDateDay|startDateMonth|startDateYear|endDateDay|endDateMonth|endDateYear|retirementDay|retirementMonth|retirementYear|fedDay|fedMonth|fedYear|status|
|083905216|Routing Code|083905216|ABA|||||||||||||active|
|083905216|Routing Code|083905216|ABA|1|Jan|2016|12|Dec|2016|12|Dec|2050|26|Jan|2016|active|
|083905216|Routing Code|083905216|ABA|1|Jan|2017|12|Dec|2017|12|Dec|2050|26|Jan|2016|pending|

Scenario: User is updating a Routing Code's Date fields(Start Date, End Date, Forthcoming Retirement Date, Confirmed with Fed) 
a) User verifies that the error message 'Invalid Date' is displayed when invalid date is entered with code type = 'ABA'    
b) User verifies that the error message 'Enter a year, month/year or day/month/year.' is displayed when invalid date format is entered with code type = 'ABA' 
c) User verifies that the error message 'Must be after 1500CE.' is displayed when year is less than 1500 with code type = 'ABA'  
  
Given a user is on the search page
When the user selects the <searchBy> from the dropdown
When the user enters the <entity> in the typeahead
And the user clicks on the search button
When the user clicks on the search results card with routing code <routingCode> and code type <codeType>
Then the user should see the routing code basic info page
When the user clicks on the routing code update link
When the user enters <startDateDay> <startDateMonth> <startDateYear> for routing code start date field
When the user enters <endDateDay> <endDateMonth> <endDateYear> for routing code end date field
When the user enters <retirementDay> <retirementMonth> <retirementYear> for routing code forthcoming retirement date field
When the user enters <fedDay> <fedMonth> <fedYear> for routing code confirmed with fed field
When the user clicks on the save button
Then the user should see the error message <errorMessage> for routing code start date field
Then the user should see the error message <errorMessage> for routing code end date field
Then the user should see the error message <errorMessage> for routing code forthcoming retirement date field
Then the user should see the error message <errorMessage> for routing code confirmed with fed field

Examples:
|entity|searchBy|routingCode|codeType|startDateDay|startDateMonth|startDateYear|endDateDay|endDateMonth|endDateYear|retirementDay|retirementMonth|retirementYear|fedDay|fedMonth|fedYear|errorMessage|
|083905216|Routing Code|083905216|ABA|ab|Jan|20s4|0.|Jun|wxyz|df|Dec|asd|4?|Aug|qw45|Invalid Date|
|083905216|Routing Code|083905216|ABA|6||2016|6|Jun|||Jun||6|||Enter a year, month/year or day/month/year.|
|083905216|Routing Code|083905216|ABA|1|Jan|24|2|Jun|25|1|Dec|24|4|Aug|20|Must be after 1500CE.|

Scenario: User is updating a Routing Code's Date fields(Start Date, End Date) 
a) User verifies that the error message 'Invalid Date' is displayed when invalid date is entered with code type is not 'ABA'    
b) User verifies that the error message 'Enter a year, month/year or day/month/year.' is displayed when invalid date format is entered with code type is not 'ABA' 

Given a user is on the search page
When the user selects the <searchBy> from the dropdown
When the user enters the <entity> in the typeahead
And the user clicks on the search button
When the user clicks on the search results card with routing code <routingCode> and code type <codeType>
Then the user should see the routing code basic info page
When the user clicks on the routing code update link
When the user enters <startDateDay> <startDateMonth> <startDateYear> for routing code start date field
When the user enters <endDateDay> <endDateMonth> <endDateYear> for routing code end date field
When the user clicks on the save button
Then the user should see the error message <errorMessage> for routing code start date field
Then the user should see the error message <errorMessage> for routing code end date field

Examples:
|entity|searchBy|routingCode|codeType|startDateDay|startDateMonth|startDateYear|endDateDay|endDateMonth|endDateYear|errorMessage|
|DAAEDEDD435|Routing Code|DAAEDEDD435|SWIFT BIC|32|Jun|2015|29|Feb|2015|Invalid Date|  
|DAAEDEDD435|Routing Code|DAAEDEDD435|SWIFT BIC|6||2016|6|Jun||Enter a year, month/year or day/month/year.|

Scenario: User is updating a Routing Code's Basic Info - 
a) User verifies that the error message 'Must be no later than today.' is displayed for the Date fields(Start Date, Confirmed With Fed) when date later than today is entered and 
   when code status not = 'pending'
  
Given a user is on the search page
When the user selects the <searchBy> from the dropdown
When the user enters the <entity> in the typeahead
And the user clicks on the search button
When the user clicks on the search results card with routing code <routingCode> and code type <codeType>
Then the user should see the routing code basic info page
When the user changes the status for routing code <routingCode> and code type <codeType> to <status>
When the user clicks on the routing code update link
When the user enters start date and confirmed with fed later than today
When the user clicks on the save button
Then the user should see the error message <errorMessage> for routing code start date field
Then the user should see the error message <errorMessage> for routing code confirmed with fed field

Examples:
|entity|searchBy|routingCode|codeType|startDateDay|startDateMonth|startDateYear|fedDay|fedMonth|fedYear|errorMessage|status|
|083905216|Routing Code|083905216|ABA|1|Jan|2017|31|Dec|2017|Must be no later than today.|active|

Scenario: User is updating a Routing Code's Date fields(Start Date, End Date, Forthcoming Retirement Date, Confirmed with Fed)
a) User verifies no change in confirmation modal.   
b) User verifies that Routing Code Basic Info page and Zeus document is updated.

Given a user is on the search page
When the user selects the <searchBy> from the dropdown
When the user enters the <entity> in the typeahead
And the user clicks on the search button
When the user clicks on the search results card with routing code <routingCode> and code type <codeType>
Then the user should see the routing code basic info page
When the user changes the status for routing code <routingCode> and code type <codeType> to <status>
When the user clicks on the routing code update link
When the user gets the document with get document id for routing code with the <routingCode> and <codeType> from the database
When the user enters <startDateDay> <startDateMonth> <startDateYear> for routing code start date field
When the user enters <endDateDay> <endDateMonth> <endDateYear> for routing code end date field
When the user enters <retirementDay> <retirementMonth> <retirementYear> for routing code forthcoming retirement date field
When the user enters <fedDay> <fedMonth> <fedYear> for routing code confirmed with fed field
When the user clicks on the save button
Then the user should see the save confirmation modal
And the user should not see the below summary changes in confirmation modal
|Summary|
|Basic Info|
When the user clicks on the confirm button
Then the user should see the updated date field values in routing code basic info page
Then the user should see the date field values same as in zeus document
Then the user reverts the changes to the document

Examples:
|entity|searchBy|routingCode|codeType|startDateDay|startDateMonth|startDateYear|endDateDay|endDateMonth|endDateYear|retirementDay|retirementMonth|retirementYear|fedDay|fedMonth|fedYear|status|
|083905216|Routing Code|083905216|ABA|1|Jan|2017|12|Dec|2017|12|Dec|2050|26|Jan|2016|pending|

Scenario: User is updating a Routing Code's Basic Info - 
a) User verifies that Forthcoming Retirement Date and Confirmed with Fed fields do not exist when codetype is not 'ABA'.
b) User enters values for Start Date and End Date fields and verifies UI and Zeus document after saving.

Given a user is on the search page
When the user selects the <searchBy> from the dropdown
When the user enters the <entity> in the typeahead
And the user clicks on the search button
When the user clicks on the search results card with routing code <routingCode> and code type <codeType>
Then the user should see the routing code basic info page
Then the user should see that forthcoming retirement date and confirmed with fed fields does not exist
When the user changes the status for routing code <routingCode> and code type <codeType> to <status>
When the user clicks on the routing code update link
When the user gets the document with get document id for routing code with the <routingCode> and <codeType> from the database
When the user enters <startDateDay> <startDateMonth> <startDateYear> for routing code start date field
When the user enters <endDateDay> <endDateMonth> <endDateYear> for routing code end date field
When the user clicks on the save button
Then the user should see the save confirmation modal
When the user clicks on the confirm button
Then the user should see the updated date field values in routing code basic info page for non ABA code type
Then the user should see the date field values same as in zeus document for non ABA code type
Then the user reverts the changes to the document

Examples:
|entity|searchBy|routingCode|codeType|startDateDay|startDateMonth|startDateYear|endDateDay|endDateMonth|endDateYear|status|
|DAAEDEDD435|Routing Code|DAAEDEDD435|SWIFT BIC|||||||active|
|DAAEDEDD435|Routing Code|DAAEDEDD435|SWIFT BIC|1|Jan|2017|12|Dec|2017|pending|

Scenario: User is updating Routing Code's Basic Info page - 
a) User verifies whether the current values for Boolean Fields(Account Eligibility, Internal Use Only, Use Head Office) is same as in trusted document.
c) User enters all Boolean Fields same as the current value to verify no change in the confirmation modal.
d) User verifies that the Basic Info page and Zeus document is updated correctly.

Given a user is on the search page
When the user selects the <searchBy> from the dropdown
When the user enters the <entity> in the typeahead
And the user clicks on the search button
When the user clicks on the search results card with routing code <routingCode> and code type <codeType>
Then the user should see the routing code basic info page
When the user clicks on the routing code update link
When the user gets the document with get document id for routing code with the <routingCode> and <codeType> from the database
Then the user verifies the boolean field values same as in trusted document
When the user selects <accountEligibilityValue> for routing code account eligibility field
When the user selects <internalUseOnlyValue> for routing code internal use only field
When the user selects <useHeadOfficeValue> for routing code use head office field
When the user clicks on the save button
Then the user should see the save confirmation modal
Then the user should not see the below summary changes in confirmation modal
|Summary|
|Basic Info|
When the user clicks on the confirm button
Then the user should be able to verify the boolean field values in routing code basic info page
Then the user should see the boolean field values same as in zeus document
Then the user reverts the changes to the document

Examples:
|entity|searchBy|routingCode|codeType|accountEligibilityValue|internalUseOnlyValue|useHeadOfficeValue|
|01056|Routing Code|01056|Swift BIC|true|true|true|

Scenario: User is updating Routing Code's Basic Info page - 
a) User enters all Boolean Fields different from the current value to verify change in the confirmation modal.
b) User verifies that the Basic Info page and Zeus document is updated correctly.

Given a user is on the search page
When the user selects the <searchBy> from the dropdown
When the user enters the <entity> in the typeahead
And the user clicks on the search button
When the user clicks on the search results card with routing code <routingCode> and code type <codeType>
Then the user should see the routing code basic info page
When the user clicks on the routing code update link
When the user gets the document with get document id for routing code with the <routingCode> and <codeType> from the database
When the user selects <accountEligibilityValue> for routing code account eligibility field
When the user selects <internalUseOnlyValue> for routing code internal use only field
When the user selects <useHeadOfficeValue> for routing code use head office field
When the user clicks on the save button
Then the user should see the save confirmation modal
And the user should see the below summary changes in confirmation modal
|Summary|
|Basic Info|
When the user clicks on the confirm button
Then the user should be able to verify the boolean field values in routing code basic info page
Then the user should see the boolean field values same as in zeus document
Then the user reverts the changes to the document

Examples:
|entity|searchBy|routingCode|codeType|accountEligibilityValue|internalUseOnlyValue|useHeadOfficeValue|
|01056|Routing Code|01056|Swift BIC|false|false|false|

Scenario: User is updating Routing Code's Basic Info page -
a) User verifies that the current Routing Code Subtype and ABA Code Source drop-down values is same as in trusted document.
b) User verifies that Routing Code Subtype drop-down values are from ROUTING_CODE_SUBTYPE lookup.
c) User verifies that ABA Code Source drop-down values are from ROUTING_CODE_SOURCE lookup.
d) User verifies the change in confirmation modal by entering Routing Code Subtype and ABA Code Source drop-down values that is different from the current values.
e) User verifies UI and Zeus document is updated.

Given a user is on the search page
When the user selects the <searchBy> from the dropdown
When the user enters the <entity> in the typeahead
And the user clicks on the search button
When the user clicks on the search results card with routing code <routingCode> and code type <codeType>
Then the user should see the routing code basic info page
When the user clicks on the routing code update link
When the user gets the document with get document id for routing code with the <routingCode> and <codeType> from the database
Then the user verifies that the drop-down field values are same as in trusted document
Then the user should see the routing code subtype values from lookup ROUTING_CODE_SUBTYPE
Then the user should see the ABA code source values from lookup ROUTING_CODE_SOURCE
When the user selects the routing code subtype as <routingCodeSubtype> in the routing code basic info page
When the user selects the ABA code source as <ABACodeSource> in the routing code basic info page
When the user clicks on the save button
Then the user should see the save confirmation modal
And the user should see the below summary changes in confirmation modal
|Summary|
|Basic Info|
When the user clicks on the confirm button
Then the user should be able to verify the drop-down field values in routing code basic info page
Then the user should see the drop-down field values same as in zeus document
Then the user reverts the changes to the document

Examples:
|entity|searchBy|routingCode|codeType|routingCodeSubtype|ABACodeSource|
|083905216|Routing Code|083905216|ABA|Unknown|Other (Unknown)|
|083905216|Routing Code|083905216|ABA|Special Series|Other (Unknown)|
|083905216|Routing Code|083905216|ABA|Unknown|ABA|
|083905216|Routing Code|083905216|ABA|Electronic Transaction Identifier|EFT Data Collection|

Scenario: User is updating Routing Code's Basic Info page -
a) User verifies no change in confirmation modal by entering Routing Code Subtype and ABA Code Source drop-down values that is same as the current values.
b) User verifies UI and Zeus document has no change.

Given a user is on the search page
When the user selects the <searchBy> from the dropdown
When the user enters the <entity> in the typeahead
And the user clicks on the search button
When the user clicks on the search results card with routing code <routingCode> and code type <codeType>
Then the user should see the routing code basic info page
When the user clicks on the routing code update link
When the user gets the document with get document id for routing code with the <routingCode> and <codeType> from the database
When the user selects the routing code subtype as <routingCodeSubtype> in the routing code basic info page
When the user selects the ABA code source as <ABACodeSource> in the routing code basic info page
When the user clicks on the save button
Then the user should see the save confirmation modal
Then the user should not see the below summary changes in confirmation modal
|Summary|
|Basic Info|
When the user clicks on the confirm button
Then the user should be able to verify the drop-down field values in routing code basic info page
Then the user should see the drop-down field values same as in zeus document
Then the user reverts the changes to the document

Examples:
|entity|searchBy|routingCode|codeType|routingCodeSubtype|ABACodeSource|
|083905216|Routing Code|083905216|ABA|Electronic Transaction Identifier|EFT Data Collection|

Scenario: User is on the Routing Code's Basic Info page -
a) User selects a Routing Code where the Routing Code Type is not 'ABA'.
b) User verifies that the Routing Code Subtype and ABA Source Code fields does not exist in the basic info page.

Given a user is on the search page
When the user selects the <searchBy> from the dropdown
When the user enters the <entity> in the typeahead
And the user clicks on the search button
When the user clicks on the search results card with routing code <routingCode> and code type <codeType>
Then the user should see the routing code basic info page
Then the user should see that the routing code subtype and ABA code source fields does not exist

Examples:
|entity|searchBy|routingCode|codeType|
|DAAEDEDD435|Routing Code|DAAEDEDD435|SWIFT BIC|

Scenario: Verify alternate code forms can be added for a routing code
Verify the max length for the alternate code form value
Verify the alternate code form type values from lookup ROUTING_CODE_ALTERNATE_FORM_TYPE
Verify existing alternate code forms can not be edited

Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with routing code <routingCode> and code type <codeType>
Then the user should see the routing code basic info page
When the user clicks on the routing code update link
When the user gets the document with get document id for routing code with the <routingCode> and <codeType> from the database
Then the user verifies that the existing alternate code forms can not be edited
When the user click on add new alternate code form button
Then the user should see the alternate code type values from lookup ROUTING_CODE_ALTERNATE_FORM_TYPE except the values that were selected already
Then the user verifies the alternate code form value maxlength is 20 characters
When the user selects alternate code form type as <alternateCodeType>
And the user enters the alternate code form value as <alternateCodeValue>
When the user clicks on the save button
And the user clicks on the confirm button
Then the user should see the successful update message at top of the routing code page
Then the user should see the alternate code form values as <alternateCodeType> and <alternateCodeValue> in the routing code basic info page
Then the user should see the alternate code form values same as in zeus document for routing code <routingCode> with code type <codeType>
Then the user reverts the changes to the document


Examples:
|entity|searchBy|routingCode|codeType|alternateCodeType|alternateCodeValue|
|083905216|Routing Code|083905216|ABA|tfp_legacy|123456|

Scenario: Verify alternate code forms can be deleted for a routing code except the fractional value
Verify alternate code forms of type "fractional" can not be deleted

Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with routing code <routingCode> and code type <codeType>
Then the user should see the routing code basic info page
When the user clicks on the routing code update link
When the user gets the document with get document id for routing code with the <routingCode> and <codeType> from the database
Then the user verifies that the fractional value can not be deleted
When the user clicks on the delete alternate code form button
And the user clicks on the Yes button to delete a row
And the user clicks on the save button
And the user clicks on the confirm button
Then the user should see the successful update message at top of the routing code page
Then the user should not see the alternate code form values <alternateCodeType> and <alternateCodeValue> in the routing code basic info page
Then the user should see the alternate code form values same as in zeus document for routing code <routingCode> with code type <codeType>
Then the user reverts the changes to the document


Examples:
|entity|searchBy|routingCode|codeType|alternateCodeType|alternateCodeValue|
|083905216|Routing Code|083905216|ABA|fdb_legacy|2324|

Scenario: Verify that the user should get the Required field messages for alternate code type

Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with routing code <routingCode> and code type <codeType>
Then the user should see the routing code basic info page
When the user clicks on the routing code update link
When the user gets the document with get document id for routing code with the <routingCode> and <codeType> from the database
Then the user verifies that the existing alternate code forms can not be edited
When the user click on add new alternate code form button
When the user selects alternate code form type as <alternateCodeType>
And the user enters the alternate code form value as <alternateCodeValue>
When the user clicks on the save button
Then the user should see the error message for the required alternate code type field in the basic info routing code page
And the user should see the error message at top of page the highlighted fields must be addressed before this update can be saved

Examples:
|entity|searchBy|routingCode|codeType|alternateCodeType|alternateCodeValue|
|083905216|Routing Code|083905216|ABA||2324|

Scenario: Verify that the user should get the Required field messages for alternate code value
Given a user is on the search page
When the user enters the <entity> in the typeahead
And the user selects the <searchBy> from the dropdown
And the user clicks on the search button
When the user clicks on the search results card with routing code <routingCode> and code type <codeType>
Then the user should see the routing code basic info page
When the user clicks on the routing code update link
When the user gets the document with get document id for routing code with the <routingCode> and <codeType> from the database
Then the user verifies that the existing alternate code forms can not be edited
When the user click on add new alternate code form button
When the user selects alternate code form type as <alternateCodeType>
And the user enters the alternate code form value as <alternateCodeValue>
When the user clicks on the save button
Then the user should see the error message for the required alternate code value field in the basic info routing code page
And the user should see the error message at top of page the highlighted fields must be addressed before this update can be saved
Examples:
|entity|searchBy|routingCode|codeType|alternateCodeType|alternateCodeValue|
|083905216|Routing Code|083905216|ABA|tfp_legacy||
