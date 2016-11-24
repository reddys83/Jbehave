Meta:@loadTestDataRoutingCode @loadData
Narrative:
Reloading the data after data refresh

Scenario: Used for loading test data after data refresh for city
Creates test data for City-> Chicago

Given the user updates routingCode document with value <routingCode> and code type <routingCodeType>

Examples:
|routingCode|routingCodeType|
|083905216|ABA|
|01056|Swift BIC|
|DAAEDEDD435|SWIFT BIC|
|HLFXGB21K03|SWIFT BIC|
|77390628|BLZ (DE)|
|262176840|ABA|