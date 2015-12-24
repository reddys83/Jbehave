Meta:@Taxonomies

Narrative:
As a user
I want to search for taxonomy by name
So that I can achieve a business goal mentioned in the story
JIRA ID - ZEUS-259 - Admin can search for taxonomy by name
JIRA ID - ZEUS-211 - Admin user can view a taxonomy
JIRA ID - ZEUS-506 - Taxonomies - The taxonomy list is not sorted.

Scenario: View for taxonomy by name
Given a user is on the search page
When the user clicks on the admin tab in the search page
And the user clicks on the taxonomies tab in the data area
And the user clicks on the choose a taxonomy option
Then the user should see the list of all existing taxonomies by name
And the list should not have any duplicates

Scenario: Filter for taxonomy by name
Given a user is on the search page
When the user clicks on the admin tab in the search page
And the user clicks on the taxonomies tab in the data area
And the user clicks on the choose a taxonomy option
And the user starts typing the name of a taxonomy as Rou in the taxonomy input box
Then the user should see the drop-down list of the taxonomies matching the input characters

Scenario: No results match for taxonomy by name
Given a user is on the search page
When the user clicks on the admin tab in the search page
And the user clicks on the taxonomies tab in the data area
And the user clicks on the choose a taxonomy option
And the user starts typing the name of a taxonomy as jadsfvbj in the taxonomy input box
Then the user should see the option no results match for the searched taxonomy string

Scenario: Filter for taxonomy by name
Meta:@verifyBuild
Given a user is on the search page
When the user clicks on the admin tab in the search page
And the user clicks on the taxonomies tab in the data area
And the user clicks on the choose a taxonomy option
And the user enters the taxonomy <taxonomy> in the type-ahead box
Then the user should see the taxonomy's entry as:
|CONTINENT|TFPSYS CONTINENT ID|TFPSYS CONTINENT DESCRIPTION|MODIFY|
|Africa|AFRI|Africa|
|Antactica|ANTA|Antactica|
|Asia|ASIA|Asia|
|Europe|EURO|Europe|
|North America|NAMR|North America|
|Oceania|OCEA|Oceania|
|South America|SAMR|South America|

Examples:
|taxonomy|
|Continent|

Scenario: Filter for taxonomy by name
Given a user is on the search page
When the user clicks on the admin tab in the search page
And the user clicks on the taxonomies tab in the data area
And the user clicks on the choose a taxonomy option
And the user enters the taxonomy <taxonomy> in the type-ahead box
Then the user should see the taxonomy's entry as:
|RELATIONSHIP TYPE|ENTITY TYPE|MODIFY|
|Government|LegalEntity|
|Banking Association|LegalEntity|

Examples:
|taxonomy|
|Area Related Entity Type|