package software;

import static org.junit.Assert.assertFalse;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import software.Admin;

public class AdminLogOutSteps {
	
	public Admin a;
	public AdminLogOutSteps(Admin ad) {
		//System.out.println("logout feature");
		a=ad;
	}
	

	@Given("that the admin is logged in")
	public void that_the_admin_is_logged_in() {
	    // Write tripID here that turns the phrase above into concrete actions
	    a.setLogState(true);
	}

	@When("the admin logs out")
	public void the_admin_logs_out() {
	    // Write tripID here that turns the phrase above into concrete actions
	   a.logout();
	}
	
	

}

