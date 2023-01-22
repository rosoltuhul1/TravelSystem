package software;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import software.Admin;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class AdminLoginSteps {
	
	public Admin a;
	public String pass;
	
	public AdminLoginSteps(Admin ad) {
		a=ad;
	}
@Given("that the admin is not logged in")
public void that_the_admin_is_not_logged_in() {
    // Write tripID here that turns the phrase above into concrete actions
	a.setLogState(false);
   
}

@Given("the password is {string}")
public void the_password_is(String string) {
    // Write tripID here that turns the phrase above into concrete actions
    
    pass=string;
}

@Then("the admin login succeeds")
public void the_admin_login_succeeds() {
    // Write tripID here that turns the phrase above into concrete actions
    assertTrue(a.login(pass));
}

@Then("the admin is logged in")
public void the_admin_is_logged_in() {
    // Write tripID here that turns the phrase above into concrete actions
	assertTrue(a.getLogState());

}

@Then("the admin login fails")
public void the_admin_login_fails() {
    // Write tripID here that turns the phrase above into concrete actions
   assertFalse(a.login(pass));
}

@Then("the admin is not logged in")
public void the_admin_is_not_logged_in() {
    // Write tripID here that turns the phrase above into concrete actions
	assertFalse(a.getLogState());
  
}



}
