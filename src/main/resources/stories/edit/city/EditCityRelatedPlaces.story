Meta: @EditCityRelatedPlaces @Edit @City @AllStories

Narrative:
In order to view and edit the city page
As a user
I want to cover the requirements mentioned in

JIRA ID - ZEUS-981 - User can edit City's Related Places

Scenario: Verify the list of type dropdown are from CITY_RELATED_PLACE_TYPE and details dropdown from CITY_RELATED_PLACE_SUBTYPE
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
When the user clicks on the city places link in the navigation bar
And the user clicks on the update link
And the user clicks on the add button for adding new places for city page
When the user clicks on new city places type drop-down for city
Then the user should see the values for type dropdown from lookup CITY_RELATED_PLACE_TYPE
When the user clicks on new city places details drop-down for city
Then the user should see the values for details dropdown from lookup CITY_RELATED_PLACE_SUBTYPE

Examples:
|country|area|city|
|Tajikistan|Leninabadskaya Oblast|Gafurov|

					 
Scenario: Verify whether User is able to see error message "Required" when input values are blank for 'type' field
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
When the user clicks on the city places link in the navigation bar
And the user clicks on the update link
And the user clicks on the add button for adding new places for city page
And the user clicks on the save button
Then the user should see the error message required for type in places for city
Then the user should see the error message at top of page the highlighted fields must be addressed before this update can be saved

Examples:
|country|area|city|
|Tajikistan|Leninabadskaya Oblast|Gafurov|

Scenario: 
a)Verify whether user is able to add a City Related place  successfully in City Web page
b)Verify whether user is able to view the added related place in Zeus Document
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
When the user clicks on the city places link in the navigation bar
And the user clicks on the update link
When the user gets the document with get document id for city with the <city> from the database
When the user deletes the existing related places rows
And the user clicks on the add button for adding new places for city page
And the user clicks on new city places type drop-down for city
And the user selects type value as <PlaceType> in the places for city
When the user clicks on edit button in places for city
And the user clicks on the country drop down in the places for city
When the user selects the country <countryPlaces> in the places for city
And the user clicks on area drop down in the places for city
When the user selects area <areaPlaces> dropdown in places for city
And the user clicks on city drop down in the places for city
And the user selects city <cityPlaces> dropdown in the places for city
And the user clicks on go button in places for city
And the user selects details value as <PlaceDetails> in the places for city
And the user clicks on the save button
Then the user should see the save confirmation modal
And the user should see the below summary changes in confirmation modal
|Summary|
|Related Places|
When the user clicks on the confirm button
Then the user should see the successful update message at top of the page
Then the user should see <PlaceType> <cityPlaces> <PlaceDetails> updated in city related place
Then the user should see the city related place date <PlaceType> <cityPlaces> <PlaceDetails> value in zeus document
Then the user reverts the changes to the document


Examples:
|country|area|city|PlaceType|countryPlaces|areaPlaces|cityPlaces|PlaceDetails|
|Tajikistan|Leninabadskaya Oblast|Gafurov|Twin City|Afghanistan|Badakshan|Badakshan|Capital City|

Scenario: 
a)Verify whether user is able to update an existing  City Related place  successfully in City Web page
b)Verify whether user is able to view the updated related place in Zeus Document
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
When the user clicks on the city places link in the navigation bar
And the user clicks on the update link
When the user gets the document with get document id for city with the <city> from the database
When the user deletes the existing related places rows
And the user clicks on the add button for adding new places for city page
And the user clicks on new city places type drop-down for city
And the user selects type value as <PlaceType> in the places for city
When the user clicks on edit button in places for city
And the user clicks on the country drop down in the places for city
When the user selects the country <countryPlaces> in the places for city
And the user clicks on area drop down in the places for city
When the user selects area <areaPlaces> dropdown in places for city
And the user clicks on city drop down in the places for city
And the user selects city <cityPlaces> dropdown in the places for city
And the user clicks on go button in places for city
And the user selects details value as <PlaceDetails> in the places for city
And the user clicks on the save button
Then the user should see the save confirmation modal
And the user should see the below summary changes in confirmation modal
|Summary|
|Related Places|
When the user clicks on the confirm button
Then the user should see the successful update message at top of the page
Then the user should see <PlaceType> <cityPlaces> <PlaceDetails> updated in city related place
Then the user should see the city related place date <PlaceType> <cityPlaces> <PlaceDetails> value in zeus document
Then the user reverts the changes to the document

Examples:
|country|area|city|PlaceType|countryPlaces|areaPlaces|cityPlaces|PlaceDetails|
|Tajikistan|Leninabadskaya Oblast|Gafurov|Twin City|Afghanistan|Badakshan|Badakshan|Capital City|
|Tajikistan|Leninabadskaya Oblast|Gafurov|Capital City|Angola|Bengo|Caxito|Judicial Capital|

Scenario: 
a)Verify whether user is able to update an existing  City Related place (no different to the current value) with same values successfully
b)Verify whether user should get no changes in confirmation modal

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
When the user clicks on the city places link in the navigation bar
And the user clicks on the update link
When the user gets the document with get document id for city with the <city> from the database
When the user deletes the existing related places rows
And the user clicks on the add button for adding new places for city page
And the user clicks on new city places type drop-down for city
And the user selects type value as <PlaceType> in the places for city
When the user clicks on edit button in places for city
And the user clicks on the country drop down in the places for city
When the user selects the country <countryPlaces> in the places for city
And the user clicks on area drop down in the places for city
When the user selects area <areaPlaces> dropdown in places for city
And the user clicks on city drop down in the places for city
And the user selects city <cityPlaces> dropdown in the places for city
And the user clicks on go button in places for city
And the user selects details value as <PlaceDetails> in the places for city
And the user clicks on the save button
Then the user should see the save confirmation modal
When the user clicks on the confirm button
Then the user should see the successful update message at top of the page
Then the user should see <PlaceType> <cityPlaces> <PlaceDetails> updated in city related place
When the user clicks on the update link
And the user selects type value as <PlaceType> in the places for city
When the user clicks on edit button in places for city
And the user clicks on the country drop down in the places for city
When the user selects the country <countryPlaces> in the places for city
And the user clicks on area drop down in the places for city
When the user selects area <areaPlaces> dropdown in places for city
And the user clicks on city drop down in the places for city
And the user selects city <cityPlaces> dropdown in the places for city
And the user clicks on go button in places for city
And the user selects details value as <PlaceDetails> in the places for city
And the user clicks on the save button
Then the user should not see the <ConfirmationSummary> changes in confirmation modal
When the user clicks on the confirm button
Then the user should see the successful update message at top of the page
Then the user should see <PlaceType> <cityPlaces> <PlaceDetails> updated in city related place
Then the user reverts the changes to the document

Examples:
|country|area|city|PlaceType|countryPlaces|areaPlaces|cityPlaces|PlaceDetails|ConfirmationSummary|
|Tajikistan|Leninabadskaya Oblast|Gafurov|Capital City|Angola|Bengo|Caxito|Legislative Capital|Summary|

Scenario: User is verifying whether all expected Fields are disabled/Enabled at Related Place section

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
When the user clicks on the city places link in the navigation bar
And the user clicks on the update link
When the user deletes the existing related places rows
And the user clicks on the add button for adding new places for city page
When the user clicks on edit button in places for city
Then the user should see the default value for country is Choose a country
Then the user should see the area dropdown is disabled
Then the user should see the city dropdown is disabled
Then the user should see Edit button for place field is disabled
Then the user should see the delete option is  disabled until drawer closes
When the user clicks on the country drop down in the places for city
When the user selects the country <countryPlaces> in the places for city
And the user clicks on the country drop down in the places for city
Then the user should see Choose a country option is not selectable
Then the user should see the default value for area is Choose an area
When the user clicks on area drop down in the places for city
When the user selects area <areaPlaces> dropdown in places for city
When the user clicks on area drop down in the places for city
Then the user should see Choose an area option is not selectable
Then the user should see the default value for area is Choose a city
When the user clicks on city drop down in the places for city
And the user selects city <cityPlaces> dropdown in the places for city
When the user clicks on city drop down in the places for city
Then the user should see Choose a City option is not selectable
When the user clicks on go button in places for city
Then the user should see that drawer is closed
Then the user should see that Edit button for place field is enabled
Examples:
|country|area|city|PlaceType|countryPlaces|areaPlaces|cityPlaces|
|Tajikistan|Leninabadskaya Oblast|Gafurov|Capital City|Algeria|Blida|Bouinan|

Scenario: Verify whether the list in country, Area and city dropdown is displaying as expected

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
When the user clicks on the city places link in the navigation bar
And the user clicks on the update link
When the user clicks on edit button in places for city
And the user clicks on the country drop down in the places for city
When the user selects the country <countryPlaces> in the places for city
Then the user should see the list of all existing countries by full name in places for city
When the user clicks on area drop down in the places for city
Then the user should see the list of all existing area for the selected country by full name in places for city
When the user selects area <areaPlaces> dropdown in places for city
And the user clicks on city drop down in the places for city
Then the user should see the list of all existing city for the selected area by full name in places for city

Examples:
|country|area|city|countryPlaces|areaPlaces|
|Tajikistan|Leninabadskaya Oblast|Gafurov|Algeria|Blida|

Scenario: Verify whether User is able to see Go Button is disabled when
User should see Go Button is disabled when
a)Country not selected ("Choose a Country")
b)Country selected. Area selected and = "Return All Cities" or "No area". City not selected ("Choose a City")

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
When the user clicks on the city places link in the navigation bar
And the user clicks on the update link
When the user deletes the existing related places rows
And the user clicks on the add button for adding new places for city page
When the user clicks on edit button in places for city
Then the user should see 'Go' button disabled until value for City is selected
When the user clicks on the country drop down in the places for city
And the user selects the country <countryPlaces> in the places for city
And the user clicks on area drop down in the places for city
And the user selects area <areaPlaces> dropdown in places for city
Then the user should see 'Go' button disabled until value for City is selected

Examples:
|country|area|city|countryPlaces|areaPlaces|
|Tajikistan|Leninabadskaya Oblast|Gafurov|Algeria|No Area|
|Tajikistan|Leninabadskaya Oblast|Gafurov|Algeria|Return All Cities|

Scenario: Verify whether User is able to see Go Button is disabled when (while adding a new related place)
User should see Go Button is Enabled when
a)Country selected. Area not selected ("Choose an Area") & Country should be updated in place
b)Country selected. Area selected and <> "Return All Areas" or "NO area". City not selected ("Choose a City") & Area should be updated in place

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
When the user clicks on the city places link in the navigation bar
And the user clicks on the update link
When the user deletes the existing related places rows
And the user clicks on the add button for adding new places for city page
When the user clicks on edit button in places for city
When the user clicks on the country drop down in the places for city
And the user selects the country <countryPlaces> in the places for city
Then the user should see Go button enabled
When the user clicks on go button in places for city
Then the user should see place as Tajikistan in places for city
When the user clicks on edit button in places for city
When the user clicks on the country drop down in the places for city
And the user selects the country <countryPlaces> in the places for city
When the user clicks on area drop down in the places for city
When the user selects area <areaPlaces> dropdown in places for city
Then the user should see Go button enabled
When the user clicks on go button in places for city
Then the user should see place as Leninabadskaya Oblast in places for city

Examples:
|country|area|city|countryPlaces|areaPlaces|
|Tajikistan|Leninabadskaya Oblast|Gafurov|Tajikistan|Leninabadskaya Oblast|

Scenario: Verify whether User is able to see Go Button is disabled when (while updating existing related place)
User should see Go Button is Enabled when
a)Country selected. Area not selected ("Choose an Area") & Country should be updated in place
b)Country selected. Area selected and <> "Return All Areas" or "NO area". City not selected ("Choose a City") & Area should be updated in place

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
When the user clicks on the city places link in the navigation bar
And the user clicks on the update link
When the user gets the document with get document id for city with the <city> from the database
When the user deletes the existing related places rows
And the user clicks on the add button for adding new places for city page
And the user clicks on new city places type drop-down for city
And the user selects type value as <PlaceType> in the places for city
When the user clicks on edit button in places for city
And the user clicks on the country drop down in the places for city
When the user selects the country <countryPlaces> in the places for city
And the user clicks on area drop down in the places for city
When the user selects area <areaPlaces> dropdown in places for city
And the user clicks on city drop down in the places for city
And the user selects city <cityPlaces> dropdown in the places for city
And the user clicks on go button in places for city
And the user selects details value as <PlaceDetails> in the places for city
And the user clicks on the save button
Then the user should see the save confirmation modal
When the user clicks on the confirm button
Then the user should see the successful update message at top of the page
When the user clicks on the update link
When the user clicks on edit button in places for city
When the user clicks on the country drop down in the places for city
And the user selects the country <countryPlaces> in the places for city
Then the user should see Go button enabled
When the user clicks on go button in places for city
Then the user should see place as Tajikistan in places for city
When the user clicks on edit button in places for city
When the user clicks on the country drop down in the places for city
And the user selects the country <countryPlaces> in the places for city
When the user clicks on area drop down in the places for city
When the user selects area <areaPlaces> dropdown in places for city
Then the user should see Go button enabled
When the user clicks on go button in places for city
Then the user should see place as Leninabadskaya Oblast in places for city
Then the user reverts the changes to the document

Examples:
|country|area|city|countryPlaces|areaPlaces|cityPlaces|PlaceType|PlaceDetails|
|Tajikistan|Leninabadskaya Oblast|Gafurov|Tajikistan|Leninabadskaya Oblast|Gafurov|Twin City|Capital City|

Scenario: 
a)Verify whether user is able to delete an existing  City Related place successfully in City Web page
b)Verify whether user is not able to view the deleted related place in Zeus Document
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
When the user clicks on the city places link in the navigation bar
And the user clicks on the update link
When the user gets the document with get document id for city with the <city> from the database
When the user deletes the existing related places rows
And the user clicks on the add button for adding new places for city page
And the user clicks on new city places type drop-down for city
And the user selects type value as <PlaceType> in the places for city
When the user clicks on edit button in places for city
And the user clicks on the country drop down in the places for city
When the user selects the country <countryPlaces> in the places for city
And the user clicks on area drop down in the places for city
When the user selects area <areaPlaces> dropdown in places for city
And the user clicks on city drop down in the places for city
And the user selects city <cityPlaces> dropdown in the places for city
And the user clicks on go button in places for city
And the user selects details value as <PlaceDetails> in the places for city
And the user clicks on the save button
Then the user should see the save confirmation modal
When the user clicks on the confirm button
Then the user should see the successful update message at top of the page
Then the user should see <PlaceType> <cityPlaces> <PlaceDetails> updated in city related place
When the user clicks on the update link
When the user clicks on delete city places type
Then the user should see the delete row confirmation modal in the city page
When the user clicks on the Yes button to cancel the deletion of row
When the user clicks on the save button
Then the user should see the save confirmation modal
And the user should see the below summary changes in confirmation modal
|Summary|
|Related Places|
When the user clicks on the confirm button in city page
Then the user should see the successful update message at top of the page
Then the user should not see <PlaceType> <cityPlaces> <PlaceDetails> updated in city related place
Then the user should not see the city related place value in zeus document
Then the user reverts the changes to the document

Examples:
|country|area|city|PlaceType|countryPlaces|areaPlaces|cityPlaces|PlaceDetails|
|Tajikistan|Leninabadskaya Oblast|Gafurov|Twin City|Angola|Bengo|Caxito|Judicial Capital|

Scenario: 
Verify whether user is able to view the related place in city page when 'no' button is clicked in delete confirmation dialog

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
When the user clicks on the city places link in the navigation bar
And the user clicks on the update link
When the user gets the document with get document id for city with the <city> from the database
When the user deletes the existing related places rows
And the user clicks on the add button for adding new places for city page
And the user clicks on new city places type drop-down for city
And the user selects type value as <PlaceType> in the places for city
When the user clicks on edit button in places for city
And the user clicks on the country drop down in the places for city
When the user selects the country <countryPlaces> in the places for city
And the user clicks on area drop down in the places for city
When the user selects area <areaPlaces> dropdown in places for city
And the user clicks on city drop down in the places for city
And the user selects city <cityPlaces> dropdown in the places for city
And the user clicks on go button in places for city
And the user selects details value as <PlaceDetails> in the places for city
And the user clicks on the save button
When the user clicks on the confirm button
Then the user should see the successful update message at top of the page
Then the user should see <PlaceType> <cityPlaces> <PlaceDetails> updated in city related place
When the user clicks on the update link
When the user clicks on delete city places type
Then the user should see the delete row confirmation modal in the city page
When the user clicks on the No button to cancel the deletion of row
When the user clicks on the save button
Then the user should see the save confirmation modal
Then the user should not see the <ConfirmationSummary> changes in confirmation modal
When the user clicks on the confirm button
Then the user should see the successful update message at top of the page
Then the user should see <PlaceType> <cityPlaces> <PlaceDetails> updated in city related place
Then the user reverts the changes to the document

Examples:
|country|area|city|PlaceType|countryPlaces|areaPlaces|cityPlaces|PlaceDetails|ConfirmationSummary|
|Tajikistan|Leninabadskaya Oblast|Gafurov|Twin City|Angola|Bengo|Caxito|Judicial Capital|Summary|

Scenario: Verify whether User is able to see error message "Required" when input values are blank for 'place' field
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
When the user clicks on the city places link in the navigation bar
And the user clicks on the update link
And the user clicks on the add button for adding new places for city page
And the user clicks on the save button
Then the user should see the error message required for place in places for city
Then the user should see the error message at top of page the highlighted fields must be addressed before this update can be saved

Examples:
|country|area|city|
|Tajikistan|Leninabadskaya Oblast|Gafurov|