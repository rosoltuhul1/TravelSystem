package software;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.time.LocalDate;
import java.util.ArrayList;

public class User {
	
	String userId;
	String userName;
	String email;
	String address;
	String postalCode;
	String city;
	int lateTrips;
	final Logger logger = Logger.getLogger(User.class.getName());
	
	
	public User() {
		 
	}
	
	public User(String id,String name,String e,String add,String postal,String c) {
		userId=id;
		userName=name;
		email=e;
		address=add;
		postalCode=postal;
		city=c;
		lateTrips=0;
	}
	
	
	public class DateServer {

		public LocalDate getDate() {
			return LocalDate.now();  
			
		}
		
			
	} 
	
	public boolean register(Trip t,List<Trip> trips,Map<String, ArrayList<Trip>> registered,User u) {
		
		boolean tripSys=false;
		DateServer d=new  DateServer();
		Trip xx;
		
			for(int i=0;i<trips.size();i++) {
				xx=trips.get(i);
       			if(t.tripID.equals(xx.tripID)) {
				tripSys=true;
				break;
			}
			}
			if(!tripSys||t.registered) {
				return false;
			}
			 ArrayList<Trip>tt=new ArrayList<>();
					if(!registered.containsKey(u.userId)) {
						tt.add(t);
						registered.put(u.userId, tt);
						t.registered=true;
						t.registeringDate=d.getDate();

						return true;
					}
					
						tt=registered.get(u.userId);
						if(tt.size()==5) {
							return false;
						}
						else {
						tt.add(t);
						registered.put(u.userId, tt);
						t.registered=true;
						t.registeringDate=d.getDate();
						return true;
					
					
				}
					
			}
	
	
	
	public String returnTrip(Trip b) {
	    ArrayList<Trip> w;
	    for (int i = 0; i < MyTrips.registeredUsers.size(); i++) {
	        if (this.userId.equals(MyTrips.registeredUsers.get(i).userId)) {
	            if (MyTrips.registered.containsKey(this.userId)) {
	                w = MyTrips.registered.get(this.userId);
	                if (hasTrip(w, b)) {
	                    w.remove(i);
	                    b.registered = false;
	                    MyTrips.registered.put(this.userId, w);
	                    return "user returned the trip successfully";
	                }
	                return "this trip is not registered by you";
	            }
	            else return "";
	        }
	    }
	    return "this user is not registered";
	}
	
	private boolean hasTrip(List<Trip> trips, Trip b) {
	    for (int j = 0; j < trips.size(); j++) {
	        if (b.tripID.equals(trips.get(j).tripID)) {
	            return true;
	        }
	    }
	    return false;
	}
	
	public int countFine(int x) {
		return lateTrips*x;
		
	}
	}



	



