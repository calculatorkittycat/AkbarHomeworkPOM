Feature: As a user I should not be able to log-in with
  invalid credentials

Scenario: Login with invalid credentials

Given User is at the login page
When User enters in-valid credentials
And User clicks the login button
Then Error message should be dispalyed
And User should still be at the login page