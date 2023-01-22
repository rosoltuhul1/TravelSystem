package software;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.logging.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String []args) {
		List<User> registeredUsers= new ArrayList<>();
		final Logger logger = Logger.getLogger(Main.class.getName());
		MyTrips l=new MyTrips();
		
		
		User test=new User("1234567", "Rosol", "rosol@gmail.com", "Rr street", "H3H2T5", "Nablus");
		MyTrips.registeredUsers.add(test);
		test=new User("1478523", "Mohammd", "mohammd@gmail.com", "Mz", "S3S1T5", "Nablus");
		MyTrips.registeredUsers.add(test);
		
		Trip test2=new Trip("Palestine", "Casablanka", "T1" );
		l.trips.add(test2);
		test2=new Trip("Chicago", "Heathrow","T2" );
		l.trips.add(test2);
		User u=new User();
		Trip b=new Trip();
		Admin admin=new Admin();
		BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));  
		while(true) {
			logger.info("Please choose are you? "+"\n");
			logger.info("1- User"+"\n");
			logger.info("2- Admin "+"\n");
			logger.info("3- Exit "+"\n");
			try (Scanner choice = new Scanner(System.in)) {
				int a = choice.nextInt();
				if(a==2) {
					logger.info("Please Enter the password:"+"\n");
					String pass;
					pass=choice.next();
					if(admin.login(pass)) {
					while(true) {
							
				 	        logger.info("1- Register user "+"\n");
				 	        logger.info("2- Search for a trip "+"\n");
				 	        logger.info("3- Add a trip "+"\n");
				 	        logger.info("4- Unregister user "+"\n");
				 	        logger.info("5- print all registered user "+"\n");
				 	        logger.info("6- print all trips in the touristSystem "+"\n");
				 	        logger.info("7- Back to main menue "+"\n");
				 	       
				 	        int aa;
				 	        aa=choice.nextInt();
				 	        
				 	        switch(aa) {
				 	        
				 	        case 1:
				 	        	logger.info("please enter the user ID, name, email, address,postal code and city respectively and seperated by space:\n");
				 	        	try {
				 	        	String s=obj.readLine();
				 	        	String []ss=s.split(" ");
				 	        	u=new User(ss[0],ss[1],ss[2],ss[3],ss[4],ss[5]);
				 	        	if (admin.register(u).equals("user is already registered")) {
				 	        		  logger.info("user is alreay registered");
				 	       		}
				 	        	else { logger.info(admin.register(u));}
  	
				 	         }catch(Exception e) {
				 	        	 e.printStackTrace();
				 	         }
				 	        	break;
				 	        	
				 	        case 2:
				 	        	logger.info("enter the string to search by:\n");
				 	        	String st=choice.next();
				 	        	ArrayList<Trip>bb;
				 	        	bb=(ArrayList<Trip>) l.tripIDSearch(st);
				 	        	if(bb.isEmpty()) {
				 	        		logger.info("no trips were found");
				 	        	}
				 	        	else {
				 	        		logger.info("these trips are found:");
					 	        	for(int i=0; i<bb.size();i++) {
					 	        		logger.info(String.format("destination=%s airportNow=%s tripID=%s", bb.get(i).destination, bb.get(i).airportNOW, bb.get(i).tripID));
 
					 	        		
					 	        	}
				 	        	}
				 	       
				 	        break;
				 	        
				 	        case 3:
				 	        	
				 	        	logger.info("please enter trip destination,name of the airport you want to leave from and trip number respectively and seperated by space:\n");
				 	        	try {
				 	        		String tripSystem=obj.readLine();
				 	        		String []arrTrip=tripSystem.split(" ");
				 	        		b=new Trip(arrTrip[0],arrTrip[1],arrTrip[2]);
				 	        		l.add(b, admin);
				 	        		
				 	        	}catch(Exception e) {
				 	        		e.printStackTrace();
				 	        	}
				 	        	
				 	        	break;
				 	        	
				 	        case 4:
				 	        	logger.info("enter the user id:\n");
				 	        	String id=choice.next();
				 	        	u=new User(id,"","","","","");
				 	        	if(l.checkUser(u)) {
					 	        	for(int i=0;i<MyTrips.registeredUsers.size();i++) {
					 	        		if(MyTrips.registeredUsers.get(i).userId.equals(id))
					 	        			u=MyTrips.registeredUsers.get(i);
					 	        	}
					 	        	l.unregister(admin, u);
				 	        	}else logger.info("This user is not registered before in the TouristSystem");
				 	        		
				 	        	l.unregister(admin, u);
				 	        	break;
				 	        	
				 	        case 5:
				 	        	for(int i=0;i<MyTrips.registeredUsers.size();i++) {
				 	        		logger.info( true? String.format("%s %s %s %s %s %s", registeredUsers.get(i).userId, registeredUsers.get(i).userId, registeredUsers.get(i).email, registeredUsers.get(i).address, registeredUsers.get(i).postalCode, registeredUsers.get(i).city) : "");				 	        	}
				 	        	
				 	        	break;
				 	        	
				 	        case 6:
				 	        	for(int i=0;i<l.trips.size();i++){
				 	        		logger.info(String.format("destination=%s airportNow=%s code=%s", l.trips.get(i).destination, l.trips.get(i).airportNOW, l.trips.get(i).tripID));				 	        	}
				 	        	break;
				 	        	
				 	       case 7:
				 	    	   admin.setLogState(false);
				        	break ;
				        	default: logger.info("please try again :)");
				        	
				 	        }
						}
					}
				}else if(a==1) {
					try (Scanner choice2 = new Scanner(System.in)) {
						logger.info("Enter your ID"+"\n");
						 String id=choice2.next();
						 u=new User(id,"","","","","");
						 if(l.checkUser(u)) {
							 for(int i=0;i<MyTrips.registeredUsers.size();i++) {
								 if(MyTrips.registeredUsers.get(i).userId.equals(id))
									 u=MyTrips.registeredUsers.get(i);
							 }
							 
							while(true) {
									 logger.info("please choose a number:"+"\n");
									 logger.info("1- Register a TRip "+"\n");
						 	         logger.info("2- Return a Trip "+"\n");
						 	         logger.info("3- Search for a Trip "+"\n");
						 	        logger.info("4- show me all  trips i have registered for "+"\n");
						 	        logger.info("5- Back to main menue "+"\n");
						 	        
						      		 int x = choice2.nextInt();
							    switch (x) {
							    case 1:
							    	boolean r=false;
							    	logger.info("enter the tripID :\n");
							    	String code=choice2.next();
							    	for(int i=0;i<l.trips.size();i++) {
							    		if(l.trips.get(i).tripID.equals(code)) {
							    			r=true;
							    			b=l.trips.get(i);
							    		}	
							    	}
							    	if(r)
							    		b=new Trip("","",code);
							    	
							        l.register(b, u);
							        
							        break;
							        
							    case 2:
							    	logger.info("enter the trip number:\n");
							    	String codd=choice2.next();
							    	b=new Trip("","",codd);
							    	u.returnTrip(b);
							    	
							    	break;
							    	
							    case 3:
							    	logger.info("enter the string to search by:\n");
						        	String st=choice.next();
						        	ArrayList<Trip>bb;
						        	bb=(ArrayList<Trip>) l.tripIDSearch(st);
						        	if(bb.isEmpty()) {
						        		logger.info("no trips were found");
						        	}
						        	for (int i = 0; i < bb.size(); i++) {
						        	    if (!bb.isEmpty()) {
						        	        logger.info(String.format("destination=%s airportNOW=%s tripID=%s", bb.get(i).destination, bb.get(i).airportNOW, bb.get(i).tripID));
						        	    }
						        	}
						        	
						        	
						        	
						        	break;
						        	
							    case 4:
							    	ArrayList<Trip> z; 
							    	boolean f=MyTrips.registered.containsKey(u.userId);
							    	if(!f)
							    		logger.info("you dont have any registered trip yet :)");
							    	else {
							    		z=MyTrips.registered.get(u.userId);
								    	for(int i=0;i<z.size();i++) {
								    		 logger.info(String.format("destination=%s airportNOW=%s tripID=%s", z.get(i).destination, z.get(i).airportNOW, z.get(i).tripID));
								        
								    	}
							    	}
							    	break;
						        	
							    case 5:
							    	break ;
							    	
							    	default:logger.info("please try again");
							    }// had la switch 
							 }//while
							 
							 
							 
							 
						 }//user
						 else
							{logger.info("you are not part of our touristSystem yet please register "+"\n");
							}
					}
					
				}
				else if(a==3) {
					java.lang.System.exit(0);
				}
				else {
					logger.info("Invalid input please try again"+"\n");
						
				}
			}
 			
		}
	}

}

