Feature: Add Trip

Scenario: Admin adds a new trip

Given the Admin is logged into the system
When the Admin invokes the "Add Trip" function
Then the Admin should be prompted to enter the trip details
And the Admin should be able to enter the trip details
And the Admin should be able to submit the trip details
Then the new trip should be added to the system