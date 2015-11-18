Meta: @CountryLanguages @Country

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario: Verify Country Language data.
Meta:@verifyBuild
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
Then the user should see the country list box displayed
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
When the user clicks on the country languages link in the navigation bar
Then the user should see the country's languages list as Greek

Examples:
|country|
|Greece|

Scenario: Verify Country Language data.
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
Then the user should see the country list box displayed
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
When the user clicks on the country languages link in the navigation bar
Then the user should see the country's languages list as English, Samoan

Examples:
|country|
|American Samoa|English, Samoan|

Scenario: Verify Country Language data.
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
Then the user should see the country list box displayed
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
When the user clicks on the country languages link in the navigation bar
Then the user should see the country's languages list as English; Bemba; Kaonde; Lozi; Lunda; Luvale; Nyanja; Tongan

Examples:
|country|
|Zambia|
