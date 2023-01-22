Feature: Searching for trips based on destination,airportNOW or tripID
	Description: A user or admin search for trips by the destination,airportNOW or tripID
	Actors: user

Background: The touristOffice has a set of trips 
	Given that the admin is logged in 
	And these trips are contained in the touristOffice 
		| Palestine | Casablanka |T1 |
		| Chicago | Heathrow |T2 |
		| Istanbul | Jordan | T3 |
		| Maldive | Cairo | T4 |
	And the admin logs out 
	
Scenario: Searching for a trip by the tripID 
	Given that the admin is not logged in 
	When the user searches for the text "1" 
	Then the trip with tripID "T1" is found 
	
Scenario: Searching for a trip by the destination 
	Given that the admin is not logged in 
	When the user searches for the text "P" 
	Then the trip with tripID "T1" is found
	
Scenario: Searching for a trip by the airportNOW 
	Given that the admin is not logged in 
	When the user searches for the text "Jo" 
	Then the trip with tripID "T3" is found
	
Scenario: Searching  when the admin is logged in 
	Given that the admin is logged in 
	When the user searches for the text "2" 
	Then the trip with tripID "T2" is found
	
Scenario: No trips found
	When the user searches for the text "India" 
	Then no trips are found 
	
Scenario: Find more than one trip 
	When the user searches for the text "Ca" 
	Then the trips with tripID "T1" and "T4" are found
	
	