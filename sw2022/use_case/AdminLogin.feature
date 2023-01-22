Feature: Admin login
	Description: The admin logs into the e-library 
	Actor: Admin
	
Scenario: Admin can login
	Given that the admin is not logged in
	And the password is "adminadmin"
	Then the admin login succeeds
	And the admin is logged in
	
Scenario: Admin has the wrong password
	Given that the admin is not logged in
	And the password is "adminxyz"
	Then the admin login fails
	And the admin is not logged in
	