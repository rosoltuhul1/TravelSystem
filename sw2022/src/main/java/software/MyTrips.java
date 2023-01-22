package software;



import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.time.Duration;

public class MyTrips {
	final Logger logger = Logger.getLogger(MyTrips.class.getName());
    public List<Trip> trips =new ArrayList<>();
	protected static final List<User> registeredUsers = new ArrayList<>();
	protected static final Map<String, ArrayList<Trip>> registered = new HashMap<>();
	Trip bbb;
	Trip c;
	Trip d;
	int fine;
	
	
	
	public class DateServer {

		public LocalDate getDate() {
			return LocalDate.now();  
		}
		
			
	} 
	
	
	DateServer date=new DateServer();
	
	public void add(Trip b, Admin user) {
		if( !user.getLogState()) {
			logger.info("you can't add trips");
		}
		else {
			trips.add(b);
			
		}
	}

	public List<Trip> tripIDSearch(String string) {
		Trip b;
		ArrayList<Trip>results=new ArrayList<>();
		for(int i=0 ;i<trips.size();i++) {
			if(trips.get(i).tripID.contains(string)) {
				b=trips.get(i);
				results.add(b);
			}
			
			if(trips.get(i).airportNOW.contains(string)) {
				b=trips.get(i);
				results.add(b);
			}
			
			if(trips.get(i).destination.contains(string)) {
				b=trips.get(i);
				results.add(b);
			}
			
		}
		
		return results;

		
	}

	
	

	public boolean isContained(String string, String string2, String string3) {
		boolean found =false;
		for (int i=0;i<trips.size();i++) {
			if(trips.get(i).destination.equals(string) && trips.get(i).airportNOW.equals(string2) && trips.get(i).tripID.equals(string3) )
				found= true;
		
			else 
				found= false;
		}
		return found;
					
	}




public int setFine(int x) {
	
	fine=x;
	return fine;
}

public  int getFine() {
	return fine;
}

public boolean checkUser(User u) {
	
	for (int i=0;i<registeredUsers.size();i++) {
		if (registeredUsers.get(i).userId.equals(u.userId)) {
			
			return true;
		}
	}
		return false;
	
}

public boolean register(Trip b,User u) {
	
	boolean f=checkUser(u);
	if(f) {
		f=lateTripps(u, 21);
		if(!f) {
			if(u.countFine(getFine())!=0) {
				return false;
				}
	    	f=u.register(b, trips,registered,u);
			return f;
		}
		else return false;
	}
	
	else {	
		return f;
	}
}



public boolean lateTripps(User u,int day) {
	LocalDate today=date.getDate();
	Duration diff;
	long difference;
	ArrayList<Trip>x;
	if(registered.containsKey(u.userId)) {
		x=registered.get(u.userId);
		for(int i=0;i<x.size();i++) {
	diff=Duration.between( x.get(i).registeringDate.atStartOfDay(),today.atStartOfDay());	

	difference=diff.toDays();
			
			if(difference ==day || difference > day) {
				u.lateTrips++;
				return true;
			}
		}
	}
	
	return false;
	
}

public void unregister(Admin a,User u) {
a.unregisterUser(u, registeredUsers, registered);
	
}
}

