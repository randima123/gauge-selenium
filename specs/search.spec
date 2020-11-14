# Search Specification
Created by user on 11/13/20

This is an executable specification file which follows markdown syntax.
Every heading in this file denotes a scenario. Every bulleted point denotes a step.

table: ./src/test/resources/invalid_search_results.csv

## User search for an invalid item
* Login with email as "randima@mailinator.com" and password as "abc123"
* Search item <Item Name>
* No result found message is present

## User search for a valid item
* Login with email as "randima@mailinator.com" and password as "abc123"
* Search item "T-shirt"
* User sees search results
* First search result name is "Faded Short Sleeve T-shirts" and price is "$16.513"