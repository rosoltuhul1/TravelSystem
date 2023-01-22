package software;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import software.MyTrips;
import software.Trip;
import software.User;

public class LateTrip {
	 User u=new User("1234567","Rosol","rosol@gmail.com ","Rr street","M5M2T5","Nablus");
	 //		| Palestine | Casablanka |T1 |

	 Trip b=new Trip( "Palestine","Casablanka","T1");
	 MyTrips Tt;
	 
	 int xx;
	 public LateTrip(MyTrips ll) {
		Tt=ll; 
	}
	 
	@Given("the user has registered a Trip")
	public void the_user_has_registered_a_Trip() {
	   Tt.trips.add(b);
	   Tt.registeredUsers.add(u);
	   Tt.register(b, u);
	}

	@Given("{int} days have passed")
	public void days_have_passed(Integer int1) {
		b.registeringDate=b.registeringDate.minusDays(int1);
		 xx=int1;
	}

	@Given("the fine for one late Trip is {int} NIS")
	public void the_fine_for_one_late_trip_is_nis(Integer int1) {
	    Tt.setFine(int1);
	   
	}

	@Then("the user has Late Trips")
	public void the_user_has_late_Trips() {
	   assertTrue(Tt.lateTripps(u, xx));
	   
	}

	@Then("the user has to pay a fine of {int} NIS")
	public void the_user_has_to_pay_a_fine_of_nis(Integer int1) {
	    Integer z=u.countFine(Tt.getFine());
	    assertEquals(z,int1); 
	}

}

