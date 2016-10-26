Meta:@RoutingCodeHistory @RoutingCode @View

Narrative:
In order to view and edit the office
As a user
I want to cover the requirements mentioned in

JIRA ID - ZEUS-1159 - User can view Routing Code History


Scenario: User is on the Routing Code page -
a)Verify the values for below fields in table are from trusted doc in view mode

# Type
# Date
# Description
# Replaced By Code
# Details
b)User should verify whether default sort for the event is by 'Date' (newest first top to bottom)
c)User verifies 'N/A is displayed under Details Column, then there is no historic usages associated with this event.
d)User verifies 'Eye' icon is displayed under Details Column, then there are historic usages associated with this event.

Given a user is on the search page
When the user selects the <searchBy> from the dropdown
When the user enters the <entity> in the typeahead
And the user clicks on the search button
When the user clicks on the search results card with routing code <routingCode> and code type <codeType>
When the user deletes the existing history values
When the user inserts new history values
When the user clicks on the history link in the navigation bar
Then the user should see the history field values same as in trusted document

Examples:
|entity|searchBy|routingCode|codeType|
|083905216|Routing Code|083905216|ABA|