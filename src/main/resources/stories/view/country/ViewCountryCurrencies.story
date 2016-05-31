Meta:@ViewCountryCurrencies @Country @View @AllStories

Narrative:
In order to view and edit the currencies
As a user
I want to cover the requirements mentioned in
JIRA ID - ZEUS-246 - User can view country's currencies
JIRA ID - ZEUS-314 - User can follow link to currency from county screen

Scenario: Verify country's currencies. Sorting order.
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
Then the user should see the default country page and display all info
When the user clicks on the currencies link in the navigation bar
Then the user should see the country's currencies as:
|ISO|NAME|START DATE|END DATE|PRIMARY|REPLACED BY|STATUS|
|ZWD|Zimbabwe Dollar|2007||true||active|
|ZWR|Zimbabwe Dollar|01 Aug 2008|31 Jan 2009|true|ZWL|inactive|
|ZWN|Zimbabwe Dollar|01 Aug 2006|31 Jul 2008|true|ZWR|inactive|
|ZWD|Zimbabwe Dollar|01 Jan 1980|31 Jul 2006|true|ZWN|inactive|
|ZWD|Zimbabwe Dollar|Jan 1970|Jan 1979|true|NAD|inactive|


Examples:
|country|
|Zimbabwe|


Scenario: Verify country's currencies. Sorting orderith same status.
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
Then the user should see the default country page and display all info
When the user clicks on the currencies link in the navigation bar
Then the user should see the country's currencies as:
|ISO|NAME|START DATE|END DATE|PRIMARY|REPLACED BY|STATUS|
|KPW|Korean People's Won|19 Sep 2001||true||active|
|KPW|Korean People's Won|01 Jan 1980||true||active|

Examples:
|country|
|Korea|

Scenario: Verify country's currencies. All columns.
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
Then the user should see the default country page and display all info
When the user clicks on the currencies link in the navigation bar
Then the user should see the country's currencies as:
|ISO|NAME|START DATE|END DATE|PRIMARY|REPLACED BY|STATUS|
|XPF|Franc CFP|02 Jan 2002||true||active|
|XPF|Franc CFP|01 Jan 1980|31 Dec 2001|true|EUR|inactive|

Examples:
|country|
|Wallis and Futuna|

Scenario: follow link to currency page from country screen.
Given a user is on the search page
When the user clicks on the data tab in the search page
And the user clicks on the country tab in the data area
When the user clicks on the choose a country option
When the user enters the country <country> in the type-ahead box
Then the user should see the default country page and display all info
When the user clicks on the currencies link in the navigation bar
When the user clicks on the currency iso link <isoCode>
Then the user should see the currency page for clicked iso name

Examples:
|country|isoCode|
|Haiti|HTG|