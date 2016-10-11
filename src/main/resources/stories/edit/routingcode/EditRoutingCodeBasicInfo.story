Meta:@EditRoutingCodeBasicInfo @Edit @RoutingCode @AllStories

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal
JIRA ID - ZEUS-1179 - User can select to edit Routing Code's Basic Info

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
When the user clicks on the routing code update link
When the user gets the document with get document id for routing code with the <routingCode> and <codeType> from the database
!-- Then the user should see the edit routing code values from trusted document for routing code <routingCode> with code type <codeType>
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
|entity|searchBy|routingCode|codeType|startDateDay|startDateMonth|startDateYear|endDateDay|endDateMonth|endDateYear|retirementDay|retirementMonth|retirementYear|fedDay|fedMonth|fedYear|
|083905216|Routing Code|083905216|ABA|||||||||||||
|083905216|Routing Code|083905216|ABA|1|Jan|2016|12|Dec|2016|12|Dec|2050|26|Jan|2016|

Scenario: User is updating a Routing Code's Date fields(Start Date, End Date, Forthcoming Retirement Date, Confirmed with Fed) 
a) User verifies that the error message 'Invalid Date' is displayed when invalid date is entered with code type = 'ABA'    
b) User verifies that the error message 'Enter a year, month/year or day/month/year.' is displayed when invalid date format is entered with code type = 'ABA' 
   
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
When the user clicks on the routing code update link
When the user enters start date and confirmed with fed later than today
When the user clicks on the save button
Then the user should see the error message <errorMessage> for routing code start date field
Then the user should see the error message <errorMessage> for routing code confirmed with fed field

Examples:
|entity|searchBy|routingCode|codeType|startDateDay|startDateMonth|startDateYear|fedDay|fedMonth|fedYear|errorMessage|
|083905216|Routing Code|083905216|ABA|1|Jan|2017|31|Dec|2017|Must be no later than today.|

Scenario: User is updating a Routing Code's Date fields(Start Date, End Date, Forthcoming Retirement Date, Confirmed with Fed)
a) User verifies no change in confirmation modal.   
b) User verifies that Routing Code Basic Info page and Zeus document is updated.

Given a user is on the search page
When the user selects the <searchBy> from the dropdown
When the user enters the <entity> in the typeahead
And the user clicks on the search button
When the user clicks on the search results card with routing code <routingCode> and code type <codeType>
Then the user should see the routing code basic info page
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
|entity|searchBy|routingCode|codeType|startDateDay|startDateMonth|startDateYear|endDateDay|endDateMonth|endDateYear|retirementDay|retirementMonth|retirementYear|fedDay|fedMonth|fedYear|
|083905216|Routing Code|083905216|ABA|1|Jan|2016|12|Dec|2016|12|Dec|2050|26|Jan|2016|

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
When the user clicks on the routing code update link
When the user gets the document with get document id for routing code with the <routingCode> and <codeType> from the database
When the user enters <startDateDay> <startDateMonth> <startDateYear> for routing code start date field
When the user enters <endDateDay> <endDateMonth> <endDateYear> for routing code end date field
When the user clicks on the save button
Then the user should see the save confirmation modal
When the user clicks on the confirm button
Then the user should see the updated date field values in routing code basic info page for non ABA code type
Then the user should see the date field values same as in zeus document
Then the user reverts the changes to the document

Examples:
|entity|searchBy|routingCode|codeType|startDateDay|startDateMonth|startDateYear|endDateDay|endDateMonth|endDateYear|
|DAAEDEDD435|Routing Code|DAAEDEDD435|SWIFT BIC|1|Jan|2017|12|Dec|2017|