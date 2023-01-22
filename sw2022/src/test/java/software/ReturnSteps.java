package software;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import software.MyTrips;
import software.Trip;
import software.User;

public class ReturnSteps {
	
	public User u;
	public Trip b;
	public MyTrips l;
	String s;
	public ReturnSteps(MyTrips ll) {
		l=ll;
	}
	
	
	@Given("there is a user ID {string} ,name {string} ,email {string} ,address {string} ,postal code {string} ,and city {string}")
	public void there_is_a_user_id_name_email_address_postal_code_and_city(String string, String string2, String string3, String string4, String string5, String string6) {
	    // Write code here that turns the phrase above into concrete actions
		 u=new User(string,string2,string3,string4,string5,string6);
	}	
	
	
	
	

@Given("there is a trip with destination {string} ,airportNOW {string},and tripID {string}")
public void there_is_a_trip_with_destination_airport_now_and_trip_id(String destination, String airportNOW, String tripID) {
    // Write code here that turns the phrase above into concrete actions
	b=new Trip(destination,airportNOW,tripID);
	l.trips.add(b);
}


	
	
	
	
	
	
	
	
	
	
	
	
//	@Given("there is a user ID {string} ,name {string} ,email {string} ,address {string} ,postal code {string} ,and city {string}")
//	public void there_is_a_user_id_name_email_address_postal_code_and_city(String id, String name, String email, String address, String postal, String city) {
//	    u=new User(id,name,email,address,postal,city);
//	}
//
//	@Given("there is a trip with destination {string} ,airportNOW {string} ,and tripID {string}")
//	public void there_is_a_trip_with_destination_airport_now_and_trip_id(String destination, String airportNOW, String tripID) {
//	    b=new Trip(destination,airportNOW,tripID);
//	    l.trips.add(b);
//	}
	

	@Given("user is registered in touristSystem")
	public void user_is_registered_in_touristSystem() {
		l.registeredUsers.add(u);
	}
	
	@Given("the user has registered this trip")
	public void the_user_has_registered_this_trip() {
	    
	    l.register(b, u);
	}
	@When("action \\(return) happens")
	public void action_return_happens() {
	   s= u.returnTrip(b);
	   System.out.println(s);
	}

	@Then("the trip not be registered")
	public void the_trip_not_be_registered() {
	    assertFalse(b.registered);
	}

	@Then("error message should  display {string}")
	public void error_message_should_display(String string) {
		
//		s="this trip is not registered by you";
	//    assertEquals(s,string);
//	    s="this user is not registered";
//	    assertEquals(s,string);
	    
	}

}

