Meta:@CityMultipleSections @City

Narrative:
In order to view and edit the city
As a user
I want to cover the requirements mentioned in
JIRA ID - ZEUS - 337 - User can view all city info
JIRA ID - ZEUS - 436 - User can select a new city when viewing a city
JIRA ID - ZEUS - 338 - User can select multiple sections of city to view

Scenario: Verify city default section
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
When the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
When the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
Then the user should see the default city page and display basic info
Then the user should see the basic info for selected area
Examples:
|country|area|city|
|Angola|Cuanza Norte|Dondo|

Scenario: Verify "All" selection should retrurn all the sections in the webapp
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
When the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
When the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
And the user clicks on the city all link in the navigation bar
Then the user should see the basic info for selected city
Then the user should see the credit rating for selected city
Then the user should see the regions for selected city
Then the user should see the places for selected city
Then the user should see the entities for selected city
Then the user should see the people for selected city

Examples:
|country|area|city|
|Angola|Cuanza Norte|Dondo|

Scenario: Verify "All" should be selected automatically, if we select all the other options in the navigation bar.
Meta:
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
When the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
When the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
When the user clicks on the city basic info link in the navigation bar
And the user clicks on the city's credit rating link in the navigation bar
And the user clicks on the city regions link in the navigation bar
And the user clicks on the city's places link in the navigation bar
And the user clicks on the city's entity link in the navigation bar
And the user clicks on the city's people link in the navigation bar
Then the user should see all is selected by default in the navigation bar

Examples:
|country|area|city|
|Ecuador|Tungurahua|pelileo|

Scenario: Verify the new selection of country should reset the area dropdown
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
When the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
When the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
Then the user should see the basic info for selected city
When the user clicks on the choose a country option
And the user enters an another country Cuba in the type-ahead box
And the user clicks on the choose an area option

Then the user should see the below states for the selected country:
|AREAS|
|Return All Cities|
|No Area|
|Camagüey|
|Ciego de Avila|
|Cienfuegos|
|Ciudad de La Habana|
|Granma|
|Guantánamo|
|Holguín|
|Las Tunas|
|Matanzas|
|Pinar del Río|
|Sancti-Spiritus|
|Villa Clara|

Examples:
|country|area|city|
|USA|Texas|Bee Cave|

Scenario: Verify the new selection of country and area should reset the city dropdown
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
When the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
When the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
Then the user should see the basic info for selected city
When the user clicks on the choose a country option
And the user enters an another country Egypt in the type-ahead box
And the user clicks on the choose an area option
And the user enters an another area Giza in the type-ahead box
And the user clicks on the choose a city option

Then the user should see the below cities for the selected area:
|CITIES|
|Dokki|
|Mohandessin|

Examples:
|country|area|city|
|Albania|Berat|Ura-Vajgurore|

Scenario: Verify the new selections of city should display same sections as previously selected while viewing previoush
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
When the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
When the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
And the user clicks on the city's people link in the navigation bar
And the user clicks on the city's entity link in the navigation bar
When the user clicks on the choose a country option
And the user enters an another country Egypt in the type-ahead box
And the user clicks on the choose an area option
And the user enters an another area Giza in the type-ahead box
And the user clicks on the choose a city option
And the user enters an another city Dokki in the type-ahead box
Then the user should see the people for selected city
And the user should see the entities for selected city

Examples:
|country|area|city|
|Albania|Berat|Ura-Vajgurore|

Scenario: Verify city multiple selection
Meta:@verifyBuild
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
When the user clicks on the choose an area option
When the user enters the area <area> in the type-ahead box
When the user clicks on the choose a city option
When the user enters the city <city> in the type-ahead box
When the user clicks on the city regions link in the navigation bar

Then the user should see the city's alternative regions as:
|TYPE|VALUE|
|Metropolitan Statistical Area|16980|
|Federal Reserve District|7|
|Federal Home Loan Bank District|7|
|National Credit Union Administration Region|IV|

When the user clicks on the city's credit rating link in the navigation bar

Then the user should see the city's credit ratings as:
|NAME|TYPE|VALUE|Date APPLIED|DATE CONFIRMED|
|Fitch|Long Term Sovereign Debt Rating|B|01 Jan 1990|04 Jan 1991|
|Standard & Poors|Long Term Sovereign Debt Rating|A-|Jan 1990|04 Jan 1991|
||Chicagos Terrible Credit Rating|F+|||

When the user clicks on the city's entity link in the navigation bar

Then the user should see the city's entity as:
|TYPE|ENTITY|DETAILS|
|Government Type|Illinois Department of Employment Security||
|Government, city|Illinois Department of Employment Security|City Government, Also known as the IBA|

When the user clicks on the city regions link in the navigation bar
Then the user should not see the city's alternative regions section

Examples:
|country|area|city|
|USA|Illinois|Chicago|