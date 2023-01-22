package software;

import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class UnRegisteredUserSteps {

	
		User u;
		MyTrips Tt;
		Admin a;
	
	
	public UnRegisteredUserSteps(MyTrips Ttt,Admin aa) {
		Tt=Ttt;
		a=aa;
	}

	
	@Given("a user with ID {string} , name {string} , email {string} , address {string} ,postal code {string} , and city {string} id registered in the touristSystem")
	public void a_user_with_id_name_email_address_postal_code_and_city_id_registered_in_the_tourist_system(String id, String name, String email, String address, String code, String city) {
		u=new User(id,name,email,address,code,city);
		Tt.registeredUsers.add(u);
		
	}

	@Given("admin is logged in")
	public void admin_is_logged_in() {
		a.setLogState(true);
	}

	@When("try to unregister the user")
	public void try_to_unregister_the_user() {
		Tt.unregister(a,u);
	}

	@Then("the user is out of the touristSystem")
	public void the_user_is_out_of_the_tourist_system() {
	    // Write code here that turns the phrase above into concrete actions
		assertTrue(Tt.checkUser(u));
	}



	
	
	@Given("user has registered trip")
	public void user_has_registered_trip() {
		Trip b=new Trip();
		   ArrayList<Trip>trips=new ArrayList<Trip>();
		   Tt.registered.put(u.userId, trips);
		
	}

	@Then("the user sould still in the touristSystem")
	public void the_user_sould_still_in_the_tourist_system() {
		 assertTrue(Tt.checkUser(u));
		 }



	@Given("user has fine unpaid")
	public void user_has_fine_unpaid() {
		  u.lateTrips++;
		    u.countFine(30);
		    }
	
}
