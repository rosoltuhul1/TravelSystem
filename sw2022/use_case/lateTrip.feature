Feature: Late Trip
Scenario: Late Trip after 21 days
Given the user has registered a Trip
And 21 days have passed
And the fine for one late Trip is 30 NIS
Then the user has Late Trips
And the user has to pay a fine of 30 NIS