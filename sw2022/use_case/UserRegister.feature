Feature: Register user
Description:Only admin can register a user 

Background: The touristOffice has registered users
	Given that the admin is logged in 
	And these usere are registered in the touristOffice 
		| 1234567 | Rosol | rosol@gmail.com |Rr street|H3H2T5|Nablus|
		| 1478523 | Mohammd | mohammd@gmail.com |Mz|S3S1T5|Nablus|
		| 1236547 | Amer | amer@gmail.com |Az street|Y3Y1T5|Nablus|
		
	And the admin logs out 

Scenario: Admin is not logged in
Given that the admin is not logged in
And there is a user with ID "2984754" , name "Ahmad" , email "ahm@gmail.com" , address "Nablus street" ,postal code "H3H2T5" , and city "Nablus"
When admin tries to register a user
Then an error massage "Admin login is required" should display

Scenario: user is already registered
Given that the admin is logged in
And there is a user with ID "1234567" , name "Rosol" , email "rosol@gmail.com" , address "Rr street" ,postal code "H3H2T5" , and city "Nablus"
When admin tries to register a user 
Then an error massage "user is alreay registered" should display

Scenario: user not registered before
Given that the admin is logged in
And there is a user with ID "2984754" , name "Ahmad" , email "ahm@gmail.com" , address "Nablus street" ,postal code "H3H2T5" , and city "Nablus"
When admin tries to register a user
Then an information message "user registered succefully" should displayed

