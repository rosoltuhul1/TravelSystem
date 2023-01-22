package software;
import java.time.LocalDate;


public class Trip  {
	String destination;
	String airportNOW;
	String tripID;
	boolean registered;
	LocalDate registeringDate;
	

	  
	public Trip() {
		
	}
	public Trip(String d,String a,String tripId) {
		destination=d;
		airportNOW=a;
		tripID=tripId;
		registered =false;
	    registeringDate=LocalDate.now();
	}
	
}

