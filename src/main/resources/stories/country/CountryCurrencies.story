Meta:@CountryCurrencies @Country

Narrative:
In order to view and edit the currencies
As a user
I want to cover the requirements mentioned in
JIRA ID - ZEUS-246 - User can view country's currencies

Scenario: Verify country's currencies. Sorting order.
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user clicks on the choose a country option
Then the user should see the country type-ahead displayed
When the user enters the country <country> in the type-ahead box
Then the user should see the default country page and display all info
When the user clicks on the currencies link in the navigation bar
Then the user should see the country's currencies as:
|ISO|NAME|START DATE|END DATE|PRIMARY|REPLACED BY|STATUS|
|ZWL|Zimbabwe Dollar|2009-02-01||true||active|
|ZWR|Zimbabwe Dollar|2008-08-01|2009-01-31|true|ZWL|inactive|
|ZWN|Zimbabwe Dollar|2006-08-01|2008-07-31|true|ZWR|inactive|
|ZWD|Zimbabwe Dollar|1980-01-01|2006-07-31|true|ZWN|inactive|

Examples:
|country|
|Zimbabwe|


Scenario: Verify country's currencies. Sorting orderith same status.
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user clicks on the choose a country option
Then the user should see the country type-ahead displayed
When the user enters the country <country> in the type-ahead box
Then the user should see the default country page and display all info
When the user clicks on the currencies link in the navigation bar
Then the user should see the country's currencies as:
|ISO|NAME|START DATE|END DATE|PRIMARY|REPLACED BY|STATUS|
|KPW|Korean People's Won|2001-09-19||true||active|
|KPW|Korean People's Won|1980-01-01||true||active|

Examples:
|country|
|Korea|

Scenario: Verify country's currencies. All columns.
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user clicks on the choose a country option
Then the user should see the country type-ahead displayed
When the user enters the country <country> in the type-ahead box
Then the user should see the default country page and display all info
When the user clicks on the currencies link in the navigation bar
Then the user should see the country's currencies as:
|ISO|NAME|START DATE|END DATE|PRIMARY|REPLACED BY|STATUS|
|XPF|Franc CFP|2002-01-02||true||active|
|XPF|Franc CFP|1980-01-01|2001-12-31|true|EUR|inactive|

Examples:
|country|
|Wallis and Futuna|