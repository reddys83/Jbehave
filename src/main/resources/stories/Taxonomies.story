Meta: @Taxonomies

Narrative:
As a user
I want to search for taxonomy by name
So that I can achieve a business goal mentioned in the story
JIRA ID - ZEUS-259-Admin can search for taxonomy by name

Scenario: View for taxonomy by name
Given a user is on the search page
When the user clicks on the admin tab in the search page
And the user clicks on the taxonomies tab in the data area
And the user clicks on the choose a taxonomy option
Then the user should see the list of all existing taxonomies by name

Scenario: Filter for taxonomy by name
Given a user is on the search page
When the user clicks on the admin tab in the search page
And the user clicks on the taxonomies tab in the data area
And the user clicks on the choose a taxonomy option
And the user starts typing the name of a taxonomy as Afg in the taxonomy input box
Then the user should see the drop-down list of the taxonomies matching the input characters

Scenario: No results match for taxonomy by name
Given a user is on the search page
When the user clicks on the admin tab in the search page
And the user clicks on the taxonomies tab in the data area
And the user clicks on the choose a taxonomy option
And the user starts typing the name of a taxonomy as Afg in the taxonomy input box
Then the user should see the option no results match for the searched taxonomy string
