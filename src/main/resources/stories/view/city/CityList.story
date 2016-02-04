Meta:@CityList @City @View

Narrative:
In order to view the places of country
As a user
I want to cover the requirements mentioned in
JIRA ID - ZEUS-325 - User can search for city by full name
JIRA ID - ZEUS-321 - ignore special characters in currency, country, area/subarea and city drop-down

Scenario: Verify city list
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
When the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
When the user clicks on the choose a city option
Then the user should see the list of all existing city for the selected area by full name

Examples:
|country|area|
|USA|Wyoming|

Scenario: Verify cities for selected area.
Meta:
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
When the user clicks on the choose an area option

Then the user should see the below states for the selected country:
|AREAS|
|Return All Cities|
|No Area|
|Christ Church|
|Saint James|
|Saint Peter|
|Saint Philip|
|Saint Thomas|
|St Joseph|
|St Michael|

When the user enters the area <area> in the type-ahead box
When the user clicks on the choose a city option
Then the user should see the below cities for the selected area:
|CITIES|
|Club Morgan Ridge|
|Hastings|
|Oistins|
|Rendezvous|
|Rockley|
|Sargeant Village|
|Seawell|
|Sheraton Park|
|Worthing|


Examples:
|country|area|
|Barbados|Christ Church|

Scenario: Verify return all cities.
Meta:
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
When the user clicks on the choose an area option

Then the user should see the below states for the selected country:
|AREAS|
|Return All Cities|
|No Area|

When the user enters the area <area> in the type-ahead box
When the user clicks on the choose a city option
Then the user should see the below cities for the selected area:
|CITIES|
|Brändö|
|Eckerö|
|Föglö|
|Geta|
|Godby|
|Hammarland|
|Jomala|
|Kökar|
|Kumlinge|
|Lappo|
|Lemland|
|Mariehamn|
|Saltvik|
|Sottunga|
|Vårdö|


Examples:
|country|area|
|Åland Islands|Return All Cities|

Scenario: Verify return cities wth no area.
Meta:
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
When the user clicks on the choose an area option

Then the user should see the below states for the selected country:
|AREAS|
|Return All Cities|
|No Area|

When the user enters the area <area> in the type-ahead box
When the user clicks on the choose a city option
Then the user should see the below cities for the selected area:
|CITIES|
|Brändö|
|Eckerö|
|Föglö|
|Geta|
|Godby|
|Hammarland|
|Jomala|
|Kökar|
|Kumlinge|
|Lappo|
|Lemland|
|Mariehamn|
|Saltvik|
|Sottunga|
|Vårdö|

Examples:
|country|area|
|Åland Islands|No Area|

Scenario: Verify no cities.
Meta:
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
When the user clicks on the choose an area option

Then the user should see the below states for the selected country:
|AREAS|
|Return All Cities|
|No Area|

When the user enters the area <area> in the type-ahead box
Then the user should not see any cities for the selected area

Examples:
|country|area|
|British Indian Ocean Territory|Return All Cities|
