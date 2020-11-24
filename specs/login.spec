# Login Specification

Created by user on 11/12/20

This is an executable specification file which follows markdown syntax.
Every heading in this file denotes a scenario. Every bulleted point denotes a step.

Tags: login

    |Email                  |Password|
    |-----------------------|--------|
    |randima@mailinator.com |abc1234 |
    |randima@mailinator.com |abc123  |

## Existing user login into the application
Tags: positive
* Login with email as <Email> and password as <Password>

## Invalid user login into the application
Tags: negative
* Input email "test.email.com"
* Input password "123123"
* Click login button
* Page title is "Login - My Store"