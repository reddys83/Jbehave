Meta:@Design


Scenario: User is updating a City's Basic Info and has set values for each of 'Country', 'Area' and 'Sub Area
1 - User adds two sub areas and verify Zeus DB is updating with two sub area

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
Then user selects subarea <subarea2> in the subarea multiselect dropdown

When user clicks on the subarea drop down in the city basic info
Then the user checks whether this subarea <subarea1> are not reselectable
Then the user checks whether this subarea <subarea2> are not reselectable

When the user clicks on the save button in city page
When the user clicks on the confirm button in city page
Then the user should see the successful update message at top of the page

Then verify zeus document whether <city> is mapped to <subarea1> and <subarea2>
Then the user reverts the changes to the document


Examples:
|country|area|city|country2|area2|subarea1|subarea2|
|UK|England|Addlestone|USA|Arizona|Gila|Graham|