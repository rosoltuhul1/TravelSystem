package software;

import static org.junit.Assert.assertTrue;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class addAPI {
	String username = "admin";
	String password = "admin123";
	boolean isAdminLoggedIn = loginAsAdmin(username, password);
	boolean isTripAdded = addTrip();
	public addAPI() {
		// TODO Auto-generated constructor stub
	}
	
	
	@Given("the Admin is logged into the system")
	public void the_admin_is_logged_into_the_system() {
	    // Write code here that turns the phrase above into concrete actions
//		String username = "admin";
//		String password = "admin123";
//		boolean isAdminLoggedIn = loginAsAdmin(username, password);
		
	}
	@When("the Admin invokes the {string} function")
	public void the_admin_invokes_the_function(String string) {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
		
	}
	@Then("the Admin should be prompted to enter the trip details")
	public void the_admin_should_be_prompted_to_enter_the_trip_details() {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
	}
	@Then("the Admin should be able to enter the trip details")
	public void the_admin_should_be_able_to_enter_the_trip_details() {
	    // Write code here that turns the phrase above into concrete actions
	  //  throw new io.cucumber.java.PendingException();
	}
	@Then("the Admin should be able to submit the trip details")
	public void the_admin_should_be_able_to_submit_the_trip_details() {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
	}
	@Then("the new trip should be added to the system")
	public void the_new_trip_should_be_added_to_the_system() {
	    // Write code here that turns the phrase above into concrete actions
		assertTrue(isAdminLoggedIn && isTripAdded);	}


	private boolean loginAsAdmin(String username, String password) {
		//Login code
		return true;
	}

	private boolean addTrip() {
		//Add Trip code
		return true;}
	
	
	
	
}
	
	
	
	
	
	
	
	
	
	
	
	
/*
	@Test
	public void addTripTest() {
		//Step 1: Login as Admin
		String username = "admin";
		String password = "admin123";
		boolean isAdminLoggedIn = loginAsAdmin(username, password);
		
		//Step 2: Invoke "Add Trip" function
		boolean isTripAdded = addTrip();
		
		//Step 3: Verify new trip was added
		assertTrue(isAdminLoggedIn && isTripAdded);
	}

	private boolean loginAsAdmin(String username, String password) {
		//Login code
		return true;
	}

	private boolean addTrip() {
		//Add Trip code
		return true;}
	
	
	
	
}
*/
