Feature: A feature to test login functionlity of an application

@Test
Scenario Outline: User Logs in to test application with Valid credentilas

Given User is on Login page
When User enters <Username> in txtUserName field
And User clicks on Continue button
Then User lands on password screen
When User enters <password> in txtPassword field
And User clicks on Login button
Then User lands on Home screen

Examples:
| Username | password |
| Test | changeme |


@Check2
Scenario: User Login to Application 

Given User is on Login page
When User enter loginCredential details
#|username	|Test		|
#|password	|Changeme	|
|username	|password	|
|Test		|Changeme	|
And User clicks on Login button
Then User lands on Home screen
