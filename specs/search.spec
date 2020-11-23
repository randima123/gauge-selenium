# Search Specification
Created by user on 11/13/20

This is an executable specification file which follows markdown syntax.
Every heading in this file denotes a scenario. Every bulleted point denotes a step.

Tags: search

table: ./src/test/resources/invalid_search_results.csv

* Login with email as "randima@mailinator.com" and password as "abc123"

## User search for an invalid item
Tags: positive
* Search item <Item Name>
* No result found message is present

## User search for a valid item
Tags: negative
* Search item "T-shirt"
* User sees search results
* Search result <table: ./src/test/resources/search_data.csv>

