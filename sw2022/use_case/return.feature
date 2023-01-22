Feature: returning  trips for touristSystem after registering it based on destination,airportNOW or tripID
	
	Scenario:  for  successful return
	Given there is a user ID "1234567" ,name "Rosol" ,email "rosol@gmail.com" ,address "Rr street" ,postal code "H3H2T5" ,and city "Nablus"
	And there is a trip with destination " Palestine " ,airportNOW "Casablanka ",and tripID "T1"
	And user is registered in touristSystem
	And the user has registered this trip
	When action (return) happens  
	Then the trip not be registered
	
	
	Scenario: user return a trip that not registered by this user
	Given there is a user ID "1234567" ,name "Rosol" ,email "rosol@gmail.com" ,address "Rr street" ,postal code "H3H2T5" ,and city "Nablus"
	And there is a trip with destination " Palestine " ,airportNOW "Casablanka ",and tripID "T1"
	And user is registered in touristSystem
	When action (return) happens  
	Then error message should  display "this trip is not registered by you"
	
	
	
	Scenario: user not registered
	Given there is a user ID "2984754" ,name "Ahmad" ,email "ahm@gmail.com" ,address "Nablus street" ,postal code "H3H1T5" ,and city "Nablus" 
	When action (return) happens  
	Then error message should  display "this user is not registered"