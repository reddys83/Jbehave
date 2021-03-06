Meta:@RoutingCodeHistory @RoutingCode @View

Narrative:
In order to view and edit the office
As a user
I want to cover the requirements mentioned in

JIRA ID - ZEUS-1159 - User can view Routing Code History


Scenario: User is on the Routing Code page -
a)Verify the values for below fields in table are from trusted doc in view mode
	Type, Date, Description, Replaced By Code, Details, Name, Address, City, Area, Sub Area, Country, Postal Code, Additional Info
b)User should verify whether default sort for the event is by 'Date' (newest first top to bottom)
c)User verifies 'N/A is displayed under Details Column, then there is no historic usages associated with this event.
d)User verifies 'Eye' icon is displayed under Details Column, then there are historic usages associated with this event.

Given a user is on the search page
When the user selects the <searchBy> from the dropdown
When the user enters the <entity> in the typeahead
And the user clicks on the search button
When the user clicks on the search results card with routing code <routingCode> and code type <codeType>
When the user clicks on the history link in the navigation bar
Then the user should see the history field values same as in trusted document
Then the user should verify the column names in history page
When the user clicks on the eye icon in first row to open the drawer
Then the user should verify the column names in history usage
Then the user verifies that values in date column is in descending order
When the user clicks on the eye icon in first row to close the drawer
Then the user should see N/A value under details column

Examples:
|entity|searchBy|routingCode|codeType|
|083905216|Routing Code|083905216|ABA|