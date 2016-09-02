Meta:@Design


Scenario: User is updating a City's Basic Info and has set values for each of 'Country', 'Area' and 'Sub Area
1 - Verify city is mapped under newly added country2 and area2 (headers)
2 - Verify the Zeus DB whether the city is mapped under newly added country2 and area2

Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the city tab in the data area
And the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
And the user enters the city <city> in the type-ahead box
And the user clicks on the city basic info link in the navigation bar
When the user clicks on the city update link
When the user gets the document with get document id for city with the <city> from the database

When the user clicks on the country drop down in the city basic info
When user changes the <country2> in the country drop downfield of city basic page

When user clicks on the area drop down in the city basic info
Then user changes the area <area2> in the area dropdown field in city basic page
When user clicks on the subarea drop down in the city basic info
When the user clears subarea options in city basic page

Then user selects subarea <subarea1> in the subarea multiselect dropdown

When the user clicks on the save button in city page
When the user clicks on the confirm button in city page

Then the user should see the successful update message at top of the page

Then the user checks whether the header dropdown updates with <country2>, <area2>, <city>
Then the user checks whether the Address bar url is updated  with <country2>, <area2>

Then verify zeus document whether <city> is mapped to newly added <country2> and <area2>
When the user clicks on the choose a country option
And the user enters the country <country> in the type-ahead box
And the user clicks on the choose an area option
And the user enters the area <area> in the type-ahead box
And the user clicks on the choose a city option
Then user verify the city dropdown does not have city <city> value mapped to old country and area
Then the user reverts the changes to the document


Examples:
|country|area|city|country2|area2|subarea1|
|UK|Scotland|Aberfeldy|UK|Wales|Cardiff|


