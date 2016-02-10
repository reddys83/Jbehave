Meta:@EditCountryBasicInfo @Edit @Country

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal
JIRA ID - ZEUS-708 - User can edit country names
JIRA ID - ZEUS-191 -

Scenario: scenario description
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
And the user clicks on the update link
And the user clicks on the confirm button
And the user clicks on the save button
And the user clicks on the cancel button
And the user clicks on the cancel no button
And the user clicks on the cancel yes button
And the user clicks on the return button
And the user clicks on the confirm button

Examples:
|country|
|Albania|

Scenario: The edit country basic info, country selection drop-down disabled
ISO2 and ISO3 and status should not be editable.
Meta:
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
And the user clicks on the update link
Then the user should see the country selection disabled
And the country ISO2 should not be editable
And the country ISO3 should not be editable
And the country status should not be editable
And the user should see the edits to country basic info from trusted dcoument

Examples:
|country|
|Åland Islands|

Scenario: The edit country basic info, The replaced by drop down lists all active countries, except the country the user is currently editing.
Meta:
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
And the user clicks on the update link
And the user clicks on replaced by drop down
Then the user should see the list of all active countries except the country the user is currently editing

Examples:
|country|
|Åland Islands|

Scenario: The edit country basic info, The user should see the error messagses for start and end date if the dates are later than today
Meta:
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
And the user clicks on the update link
And the user enters start date later than today
And the user enters end date later than today
And the user clicks on the save button
Then the user should see the error 'Must be no later than today.' for start date
Then the user should see the error 'Must be no later than today.' for end date

Examples:
|country|
|Åland Islands|

Scenario: The edit country basic info, The user should see the error messages for invalid inputs
Meta:
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
And the user clicks on the update link
When the user enters more than 500 characters in the country add info
And the user enters more than 200 characters in the country imports
And the user enters more than 200 characters in the country exports
And the user enters more than 200 characters in the country political structure
And the user enters more than 5 characters inthe country intl dialing code
And the user clicks on the save button
Then the user should see the error message enter uptp 500 valid charecters for addinfo
And the user should see the error message enter upto 200 valid charecters for imports
And the user should see the error message enter upto 200 valid charecters for exports
And the user should see the error message enter upto 200 valid charecters for political structure
And the user should see the error message enter upto 5 valid charectes for intl dialing code

Examples:
|country|
|Åland Islands|

Scenario: The edit country basic info, The user enters valid data should see the confirm modal
Meta:@RunCount
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
And the user clicks on the update link
When the user enters country start year as <countryStartYear>
And the user enters country end year as <countryEndYear>
And the user selects replaced by country from the drop down as <countryReplacedBy>
When the user enters country add info as <countryAddInfo>
And the user enters country imports as <countryImports>
And the user enters country exports as <countryExports>
And the user enters country political structure as <countryPoliticalStructure>
And the user enters country intl dialing code as <countryIntlDialingCode>
And the user clicks on the save button
Then the user should see the save confirmation modal

Examples:
|country|countryStartYear|countryEndYear|countryReplacedBy|countryAddInfo|countryImports|countryExports|countryPoliticalStructure|countryIntlDialingCode|
|Åland Islands|1819|2011|Algeria|Machinery and equipment, foodstuffs, textiles, chemicals|Machinery and equipment, foodstuffs, textiles, chemicals|Textiles and footwear; asphalt, metals and metallic ores, crude oil; vegetables, fruits, tobacco|Parliamentary Republic|355|