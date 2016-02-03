Meta:@AreaList @Area

Narrative:
In order to view the places of country
As a user
I want to cover the requirements mentioned in
JIRA ID - ZEUS-315 - User can search for area by full name
JIRA ID - ZEUS-321 - ignore special characters in currency, country, area/subarea and city drop-down

Scenario: Verify Area list
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
When the user clicks on the choose an area option
Then the user should see the list of all existing area for the selected country by full name

Examples:
|country|
|USA|

Scenario: Verify the area for selected country.
Testcase: country with multiple areas.
Meta:
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
When the user clicks on the choose an area option
Then the user should see the below states for the selected country:
|AREAS|
|Barisal|
|Bogra|
|Chapai Nawabganj|
|Chittagong|
|Dacca|
|Dhaka|
|Khulna|
|Laxmipur|
|Manikganj|
|Munsigonj|
|Mymensingh|
|Rajshahi|
|Sonargaon|
|Sylhet|


Examples:
|country|
|Bangladesh|

Scenario: Verify the area for selected country.
Testcase: country with no areas.
Meta:
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
Then the user should see the area dropdown disabled

Examples:
|country|
|American Samoa|

Scenario: Verify the area for selected country
Testcase: country with one area.
Meta:
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the area tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
When the user clicks on the choose an area option
Then the user should see the below states for the selected country:
|AREAS|
|Nagorno-Karabakh|

Examples:
|country|
|Azerbaijan|
