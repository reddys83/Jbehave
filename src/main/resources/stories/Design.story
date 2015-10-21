Meta: @Design

Narrative:
In order to view stub entry details
As a user when I search by Name, FID, TFPID and click on the search results card I can view details
I want to cover the requirements mentioned in JIRA ID - Zeus54 - (User can view entity stub entry)

Scenario: Verify related people information for city.
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
Then the user should see the country list box displayed
When the user clicks on the choose a country option
Then the user should see the list of all existing countries by full name
And the user should see the country list matching the expected country list and sorted alphabetically
When the user starts typing the name of a country as et in the country input box
Then the user should see the countries in the listbox as:
|COUNTRY|
|Ethiopia|
|St. Pierre et Miquelon|