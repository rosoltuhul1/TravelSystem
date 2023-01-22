package software;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import software.Admin;
import software.MyTrips;
import software.Trip;


public class SearchSteps {
	
	public MyTrips Tt;
	public Trip t;
	public Admin user=new Admin();
	String destination ,airportNOW,tripID;
	
	boolean resultFlag=false;
	
	ArrayList<Trip> Result=new ArrayList<Trip>();
	
	public SearchSteps(MyTrips a, Admin aa) {
		System.out.println("search feature");
		Tt=a;
		user=aa;
	}
	
	@Given("these trips are contained in the touristOffice")
	public void these_trips_are_contained_in_the_touristOffice(io.cucumber.datatable.DataTable dataTable) {
		  for(int i=0; i<4;i++) {
			   destination=dataTable.cell(i,0);
			   airportNOW=dataTable.cell(i,1);
			   tripID=dataTable.cell(i,2);
			   
			   t=new Trip(destination,airportNOW,tripID);
			   Tt.add(t,user);
		   }
	//    Tt.print();
	}

	@When("the user searches for the text {string}")
	public void the_user_searches_for_the_text(String string) {
	      Result=(ArrayList<Trip>) Tt.tripIDSearch(string);
	}
	

	@Then("the trip with tripID {string} is found")
	public void the_trip_with_tripID_is_found(String string) {
	    // assertTrue(Result.size()==1);
		assertEquals(string, Result.get(0).tripID);
	     /*System.out.println(Result.size());
			for(int i=0;i<Result.size();i++) {
				System.out.println(Result.get(i));
				
			}*/ 
	     
	}

	@Then("no trips are found")
	public void no_trips_are_found() {
		assertTrue(Result.isEmpty());
	   
	}

	@Then("the trips with tripID {string} and {string} are found")
	public void the_trips_with_tripID_and_are_found(String string, String string2) {
		// assertTrue(Result.size()==2);
		/*System.out.println(Result.size());
		for(int i=0;i<Result.size();i++) {
			System.out.println(Result.get(i).code);
			
		}*/
	     assertTrue(Result.get(0).tripID.equals(string) && Result.get(1).tripID.equals(string2));
	}

}

