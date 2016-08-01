Meta:@EditCountryRelatedPlaces @Edit @Country @AllStories

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal
JIRA ID - ZEUS-448 - User can edit country related places
JIRA ID - ZEUS-943 - Go button disabled - Country Related Places

Scenario: Verify the list of type dropdown are from COUNTRY_RELATED_PLACE_TYPE and details dropdown from COUNTRY_RELATED_PLACE_SUBTYPE
Meta:
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
When the user clicks on the country places link in the navigation bar
And the user clicks on the update link
And the user clicks on the add new places button in the places for country
And the user clicks on new country places type drop-down
Then the user should see the values for type dropdown from COUNTRY_RELATED_PLACE_TYPE
When the user clicks on new country places details drop-down
Then the user should see the values for details dropdown from COUNTRY_RELATED_PLACE_SUBTYPE

Examples:
|country|
|Anguilla|

Scenario: Verify the list in country, Area and city dropdown
Meta:
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
When the user clicks on the country places link in the navigation bar
And the user clicks on the update link
And the user clicks on the add new places button in the places for country
And the user clicks on new country places type drop-down
And the user selects type value as <PlaceType> in the places for country
When the user clicks on edit button in places for country
And the user clicks on the country drop down in the places for country
Then the user should see the list of all existing countries by full name in places for country
When the user selects the country <countryPlaces> in the places for country
And the user clicks on area drop down in the places for country
Then the user should see the list of all existing area for the selected country by full name in places for country
When the user selects area <areaPlaces> dropdown in places for country
And the user clicks on city drop down in the places for country
Then the user should see the list of all existing city for the selected area by full name in places for country

Examples:
|country|PlaceType|countryPlaces|areaPlaces|
|Anguilla|Capital City|Algeria|Blida|

Scenario: Verify the user is able to save the documetn with valid inputs
Meta:
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
When the user clicks on the country places link in the navigation bar
And the user clicks on the update link
And the user clicks on the add new places button in the places for country
And the user clicks on new country places type drop-down
And the user selects type value as <PlaceType> in the places for country
When the user clicks on edit button in places for country
And the user clicks on the country drop down in the places for country
When the user selects the country <countryPlaces> in the places for country
And the user clicks on area drop down in the places for country
When the user selects area <areaPlaces> dropdown in places for country
And the user clicks on city drop down in the places for country
And the user selects city <cityPlaces> dropdown in the places for country
And the user clicks on go button in places for country
And the user selects details value as <PlaceDetails> in the places for country
And the user clicks on the save button
Then the user should see the save confirmation modal

Examples:
|country|PlaceType|countryPlaces|areaPlaces|cityPlaces|PlaceDetails|
|Mayotte Island|Capital City|Algeria|Blida|Bouinan|Judicial Capital|

Scenario: Verify the required messages for type
Meta:
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
When the user clicks on the country places link in the navigation bar
And the user clicks on the update link
And the user clicks on the add new places button in the places for country
And the user clicks on the save button
Then the user should see the error message required for type in places for country
Then the user should see the error message at top of page the highlighted fields must be addressed before this update can be saved

Examples:
|country|
|Anguilla|

Scenario: Verify the required messages for place
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
When the user clicks on the country places link in the navigation bar
And the user clicks on the update link
And the user clicks on the add new places button in the places for country
And the user clicks on new country places type drop-down
And the user selects type value as <PlaceType> in the places for country
And the user clicks on the save button
Then the user should see the error message required for place in places for country
Then the user should see the error message at top of page the highlighted fields must be addressed before this update can be saved

Examples:
|country|PlaceType|
|Mayotte Island|Capital City|

Scenario: The user should see the confirmation modal to delete places row message Please confirm - would you like to delete this row?
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
When the user clicks on the country places link in the navigation bar
And the user clicks on the update link
And the user clicks on the add new places button in the places for country
And the user clicks on new country places type drop-down
And the user selects type value as <PlaceType> in the places for country
When the user clicks on edit button in places for country
And the user clicks on the country drop down in the places for country
When the user selects the country <countryPlaces> in the places for country
And the user clicks on area drop down in the places for country
When the user selects area <areaPlaces> dropdown in places for country
And the user clicks on city drop down in the places for country
And the user selects city <cityPlaces> dropdown in the places for country
And the user clicks on go button in places for country
And the user clicks on delete country places type
Then the user should see the delete row confirmation modal in the country page

Examples:
|country|PlaceType|countryPlaces|areaPlaces|cityPlaces|
|Mayotte Island|Capital City|Algeria|Blida|Bouinan|

Scenario: User selects country , area or city  then only those should appear in place respectively
TestCase - user selects country and hit go button, then country should display
TestCase - user selects country and area and hit go button, then area should display
TestCase - user selects country and area and city and hit go button, then city should display
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
When the user clicks on the country places link in the navigation bar
And the user clicks on the update link
And the user clicks on the add new places button in the places for country
And the user clicks on new country places type drop-down
And the user selects type value as <PlaceType> in the places for country
When the user clicks on edit button in places for country
And the user clicks on the country drop down in the places for country
When the user selects the country <countryPlaces> in the places for country
And the user clicks on go button in places for country
Then the user should see place as Algeria in places for country
When the user clicks on edit button in places for country
And the user clicks on area drop down in the places for country
When the user selects area <areaPlaces> dropdown in places for country
And the user clicks on go button in places for country
Then the user should see place as Blida in places for country
When the user clicks on edit button in places for country
And the user clicks on city drop down in the places for country
And the user selects city <cityPlaces> dropdown in the places for country
And the user clicks on go button in places for country
Then the user should see place as Bouinan in places for country



Examples:
|country|PlaceType|countryPlaces|areaPlaces|cityPlaces|
|Mayotte Island|Capital City|Algeria|Blida|Bouinan|


Scenario: Go button should be disabled when user selects "No Area" or "Return All Cities" as the value for 'area' while adding a new related place
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
When the user clicks on the country places link in the navigation bar
And the user clicks on the update link
And the user clicks on the add new places button in the places for country
And the user clicks on new country places type drop-down
And the user selects type value as <PlaceType> in the places for country
When the user clicks on edit button in places for country
And the user clicks on the country drop down in the places for country
When the user selects the country <countryPlaces> in the places for country
And the user clicks on area drop down in the places for country
When the user selects area <areaPlaces> dropdown in places for country
And the user should see go button in disabled state in the related places section

Examples:
|country|PlaceType|countryPlaces|areaPlaces|
|USA|Capital City|USA|No Area|
|USA|Financial Centre|USA|Return All Cities|


Scenario: Go button should be disabled when user selects "No Area" or "Return All Cities" as the value for 'area' while editing an existing related place
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
When the user clicks on the country places link in the navigation bar
And the user clicks on the update link
And the user clicks on edit button in existing places for country
And the user clicks on the country drop down in the places for country
When the user selects the country <countryPlaces> in the places for country
And the user clicks on area drop down in the places for country
When the user selects area <areaPlaces> dropdown in places for country
And the user should see go button in disabled state in the related places section

Examples:
|country|countryPlaces|areaPlaces|
|USA|USA|No Area|
|USA|USA|Return All Cities|