Meta: @Country

Narrative:
In order to view and edit the currencies
As a user
I want to cover the requirements mentioned in
JIRA ID - ZEUS-246 - User can search for country by full name

Scenario:
1. Verify that the country list is displayed and is not empty
2. Verify that the search box is availabe
3. Verify that the user can scroll
4. Verify that the list contains countries by their full name
5. Verify that the names are sorted Alphabetically
6. Verify that the user can type in the filter to display names matching the characters input by the user
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
Then the country list box is displayed
When the user clicks on the country list box
Then the countries type ahead and list is displayed
And the list matches the expected country list and is sorted
When the user starts typing the name of a country as et in the country input box
Then the user should see the countries in the listbox as:
|country|
|Ethiopia|
|St. Pierre et Miquelon|





