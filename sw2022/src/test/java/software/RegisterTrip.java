package software;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import software.Admin;
import software.MyTrips;
import software.Trip;
import software.User;

public class RegisterTrip {
	public User u;
	public Trip t;
	public MyTrips Tt;
	boolean flag;
	Trip t1,t2;
	public RegisterTrip(MyTrips TT) {
		Tt=TT;
	}
	
	
	
	@Given("these usere registered in the touristSystem")
	public void these_usere_registered_in_the_tourist_system(io.cucumber.datatable.DataTable dataTable) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
	    //throw new io.cucumber.java.PendingException();
        String id,name,email,add,postal,city;
		for(int i=0; i<3;i++) 
		{
			   id=dataTable.cell(i,0);
			   name=dataTable.cell(i,1);
			   email=dataTable.cell(i,2);
			   add=dataTable.cell(i,3);
			   postal=dataTable.cell(i,4);
			   city=dataTable.cell(i,5);
			   
			   u=new User(id,name,email,add,postal,city);
			   Tt.registeredUsers.add(u);
	}
	}

	@Given("these trips contained in the touristSystem")
	public void these_trips_contained_in_the_tourist_system(io.cucumber.datatable.DataTable dataTable) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
		//System.out.println("adding trip from registeered");
		String destination,airportNOW,tripID;
		Admin ad=new Admin();
	    ad.logState=true;
		for(int i=0; i<5;i++) {
			   destination=dataTable.cell(i,0);
			   airportNOW=dataTable.cell(i,1);
			   tripID=dataTable.cell(i,2);
			   
			   t=new Trip(destination,airportNOW,tripID);
			   Tt.add(t,ad);
		   }
	
		// throw new io.cucumber.java.PendingException();
	}

	@Given("these trips fullregistered")
	public void these_trips_fullregistered(io.cucumber.datatable.DataTable dataTable) {
	   
	}

	@Given("there is a user has ID {string} , name {string} , email {string} , address {string} ,postal code {string} , and city {string}")
	public void there_is_a_user_has_ID_name_email_address_postal_code_and_city(String id, String name, String email, String address, String postal, String city) {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		u=new User(id,name,email,address,postal,city);
	}

	@Given("there is a trip with destination {string} , airportNOW {string} and tripID {string}")
	public void there_is_a_trip_with_destination_airportNOW_and_tripID(String destination, String airportNOW, String tripID) {
	    // Write code here that turns the phrase above into concrete actions
		t=new Trip(destination,airportNOW,tripID);
	}

	@When("the user tries to register this trip")
	public void the_user_tries_to_register_this_trip() {
	    // Write code here that turns the phrase above into concrete actions
	   flag=Tt.register(t, u);
		// throw new io.cucumber.java.PendingException();
	}

	@Then("error massage {string} should display")
	public void error_massage_should_display(String string) {
	    // Write code here that turns the phrase above into concrete actions
     
		 assertFalse(flag);
}

	//@Given("there is a user has  ID {string} , name {string} , email {string} , address {string} ,postal code {string} , and city {string}")
	//public void there_is_a_user_has_ID_name_email_address_postal_code_and_city(String string, String string2, String string3, String string4, String string5, String string6)
	//{
	    // Write code here that turns the phrase above into concrete actions
     //    t.registered=true;	
//}

	@Given("the trip is fullRegistered")
	public void the_trip_is_full_registered() {
	    // Write code here that turns the phrase above into concrete actions
	   t.registered=true;
		// throw new io.cucumber.java.PendingException();
	}

	@Given("the trip is not fullRegistered")
	public void the_trip_is_not_full_registered() {
	    // Write code here that turns the phrase above into concrete actions
       t.registered=false;
}

	@Then("the regestering should success")
	public void the_regestering_should_success() {
	    // Write code here that turns the phrase above into concrete actions
assertTrue(flag);
assertTrue(t.registered);}

	@Given("this user has registered maximum trips")
	public void this_user_has_registered_maximum_trips() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		 List<Trip>x=Tt.trips;
		    System.out.println(x.size());
		    Tt.registered.put(u.userId, (ArrayList<Trip>) x);
	}
	
	
	
	
	
	
	
	
	
	@Given("a trip with tripID {string} is in the touristSystem")
	public void a_trip_with_code_is_in_the_touristSystem(String string) {
	    t1=new Trip("destination","airportNOW",string);
	    Tt.trips.add(t1);
	}

	@Given("trip with tripID {string} is in the touristSystem")
	public void trip_with_tripID_is_in_the_touristSystem(String string) {
	    t2=new Trip("destination2","airportNOW2",string);
	    Tt.trips.add(t2);
	}

	@When("the user registers the trip with tripID {string}")
	public void the_user_registers_the_trip_with_tripID(String string) {
	    Tt.register(t2, u);
	}

	@When("{int} day have passed")
	public void day_have_passed(Integer int1) {
	    t2.registeringDate=t2.registeringDate.minusDays(int1);
	    Tt.lateTripps(u, 21);
	}
	
	@When("the user register the trip with tripID {string}")
	public void the_user_register_the_trip_with_tripID(String string) {
	    flag=Tt.register(t1, u);
	}


	@Then("the trip with tripID {string} is not register by the user")
	public void the_trip_with_tripID_is_not_register_by_the_user(String string) {
		assertEquals(string,t1.tripID);
		
	    assertFalse(t1.registered);
     }

	@Then("error massage {string} is given")
	public void error_massage_is_given(String string) {
	    assertFalse(flag);
	}
 

	@Then("the user has to pay fine of {int} NIS")
	public void the_user_has_to_pay_fine_of_nis(Integer int1) {
//	    Tt.setFine(int1);
	    assertEquals(Tt.setFine(int1), u.countFine(int1));
	}
//	@When("the trip with tripID {string}")
//	public void the_trip_with_tripID(String string) {
//	    u.returnTrip(t2, Tt);
//	}

	@When("the user returns the trip with tripID {string}")
	public void the_user_returns_the_trip_with_tripID(String string) {
		  u.returnTrip(t2);	
		  }

}
