package software;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import software.Admin;
import software.MyTrips;
import software.Trip;

public class AddSteps {
	
	public Admin admistrator;
	public MyTrips l;
	public Trip b;
	
	public AddSteps(MyTrips ll,Admin aa) {
		l=ll;
		admistrator=aa;
		
	}
	

	@Given("that the administrator is logged in")
	public void that_the_administrator_is_logged_in() {
		admistrator.setLogState(true);
	}

	@Given("there is a trip with destination {string}, airportNOW {string}, and tripID {string}")
	public void there_is_a_trip_with_destination_airportNOW_and_tripID(String string, String string2, String string3) {
	    b=new Trip(string,string2,string3);
	    
	}

	@When("the trip is added to the touristSystem")
	public void the_trip_is_added_to_the_touristSystem() {
	    l.add(b, admistrator);
	}

	@Then("the trip with destination {string}, airportNOW {string}, and tripID {string} is contained in the touristSystem")
	public void the_trip_with_destination_airportNOW_and_tripID_is_contained_in_the_library(String string, String string2, String string3) {
		assertEquals(1, l.trips.size());
	    assertTrue( l.isContained(string,string2,string3));
	}

	@Given("that the administrator is not logged in")
	public void that_the_administrator_is_not_logged_in() {
		admistrator.setLogState(false);
	}

	@Then("the error message {string} is given")
	public void the_error_message_is_given(String string) {
		assertEquals(0, l.trips.size());
	    assertEquals( "Administrator login required",string);
	}


}

