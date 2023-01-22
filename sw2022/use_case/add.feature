Feature: Add trip to the touristSystem
	Description:add trip to the touristSystem
	Actors: Admin
                                          
Scenario: Add a trip tothe touristSystem
 	Given that the administrator is logged in
 	And there is a trip with destination "Maldive", airportNOW "Cairo", and tripID "T4"
 	When the trip is added to the touristSystem
 	Then the trip with destination "Maldive", airportNOW "Cairo", and tripID "T4" is contained in the touristSystem
 	
Scenario: Add a trip when the adminstrator is not logged in
	Given that the administrator is not logged in
 	And there is a trip with destination "Italy", airportNOW "Casablanca", and tripID "T7"
	When the trip is added to the touristSystem
	Then the error message "Administrator login required" is given
	
