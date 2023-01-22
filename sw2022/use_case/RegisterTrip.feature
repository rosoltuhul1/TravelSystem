Feature: register trip
Description:Only register user can register trip, and each trip has 5 seats 

Background: register

Given these usere registered in the touristSystem 
		| 1234567 | Rosol | rosol@gmail.com |Rr street|M5M2T5|Nablus|
		| 1478523 | Mohammd | mohammd@gmail.com |Mz|S3S1T5|Nablus|
		| 1236547 | Amer | amer@gmail.com |Az street|Y3Y1T5|Nablus|
And  these trips contained in the touristSystem  
		| Palestine | Casablanka |T1 |
		| Chicago | Heathrow |T2 |
		| Istanbul | Jordan | T3 |
		| Maldive | Cairo | T4 |	
    | Milan | Lebanon | C22 |
And these trips fullregistered 
		| 1234567| Palestine | Casablanka |T1 |

Scenario: unregistered user
Given there is a user has ID "2984754" , name "Ahmad" , email "ahm@gmail.com" , address "Nablus street" ,postal code "H3H2T5" , and city "Nablus"
And there is a trip with destination " Palestine " , airportNOW "Casablanka " and tripID "T1"
When the user tries to register this trip
Then error massage "This user is not registered" should display 

Scenario: unavailable trip
Given there is a user has ID "1234567" , name "Rosol" , email "rosol@gmail.com" , address "Rr street" ,postal code "H3H2T5" , and city "Nablus"
And there is a trip with destination " Pakistan " , airportNOW "Casablanka " and tripID "T55"
When the user tries to register this trip
Then error massage "This trip is not available in the touristSystem" should display 

Scenario: available trips but fullRegistered
Given there is a user has ID "1234567" , name "Rosol" , email "rosol@gmail.com" , address "Rr street" ,postal code "H3H2T5" , and city "Nablus"
And there is a trip with destination " Palestine " , airportNOW "Casablanka " and tripID "T1"
And the trip is fullRegistered 
When the user tries to register this trip
Then error massage "you cant register this trip because it is fullRegistered" should display


Scenario: successful register
Given there is a user has ID "1234567" , name "Rosol" , email "rosol@gmail.com" , address "Rr street" ,postal code "H3H2T5" , and city "Nablus"
And there is a trip with destination " Chicago " , airportNOW "Heathrow " and tripID "T2"
And the trip is not fullRegistered 
When the user tries to register this trip
Then the regestering should success

Scenario: user tries to register more than maximum trips
Given there is a user has ID "1234567" , name "Rosol" , email "rosol@gmail.com" , address "Rr street" ,postal code "H3H2T5" , and city "Nablus"
And this user has registered maximum trips
And there is a trip with destination " Mildive " , airportNOW " Cairo" and tripID "T4"
When the user tries to register this trip
Then error massage "you cant register this trip you have registered maximum trips" should display 



Scenario: User cannot register trips if he has late trips
Given a trip with tripID "xyz" is in the touristSystem
And  trip with tripID "T99" is in the touristSystem
And there is a user has ID "1234567" , name "Rosol" , email "rosol@gmail.com" , address "Rr street" ,postal code "H3H2T5" , and city "Nablus"
When the user registers the trip with tripID "T99"
And 21 day have passed
And the user register the trip with tripID "xyz"
Then the trip with tripID "xyz" is not register by the user
And  error massage "you can't register any new trip because you have an overdue trips" is given


#Scenario:  User cannot register trips if he has fines
#Given a trip with tripID "xyz" is in the touristSystem
#And  trip with tripID "T99" is in the touristSystem
#And there is a user has ID "1234567" , name "Rosol" , email "rosol@gmail.com" , address "Rr street" ,postal code "H3H2T5" , and city "Nablus"
#When the user registers the trip with tripID "T99"
#And 21 day have passed
#Then the user has to pay fine of 30 NIS
#When the user returns the trip with tripID "T99"
#Then the user has to pay fine of 30 NIS
#When the user register the trip with tripID "xyz"
#Then the trip with tripID "xyz" is not registered by the user
#And  error massage "you can't register trips,you have fine to pay" is given



