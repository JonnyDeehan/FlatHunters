package src;

import java.util.*;

public class DBManager {
	
	private static DBManager instance;

	  private HashMap<Integer, Flat> flatTable;
	  private HashMap<String, User> userTable;
	  
	  private HashMap<String,ArrayList<Review>> userReviewTable;
	  
	  private DBManager(){
		  initializeDatabases();
	  }

	  public static DBManager getInstance(){
	    if (instance == null)
	    	instance=new DBManager();
	    return instance;
	  }
	  
	  private void initializeDatabases(){
		  initializeUserTable();
		  initiliazeFlatTable();
		  initializeUserReviewTable();
	  }
	  
	private void initializeUserReviewTable() {
		userReviewTable= new HashMap<String,ArrayList<Review>>();
		
		  User u1=userTable.get("dr.watson@yahoo.com");
		  User u2=userTable.get("s.holmes@gmail.com");  
		  Review r4=new Review(85,"A real gentleman.",u1);
		  Review r5=new Review(70,"He always answers the phone.",u2);
		  ArrayList<Review> l3=new ArrayList<Review>();
		  l3.add(r4);
		  l3.add(r5);
		  ArrayList<Review> l4=new ArrayList<Review>();
		  l4.add(r5);
		  
		  userReviewTable.put("dr.watson@yahoo.com",l4);
		  userReviewTable.put("s.holmes@gmail.com",l3);
	}

/*	  
	private void initializeUserTable(){
		  ArrayList<Integer> f1=new ArrayList<Integer>();
		  ArrayList<Integer> f2=new ArrayList<Integer>();
		  
		  f1.add(0);
		  f1.add(1);
		  f1.add(2);
		  
		  f2.add(0);
		  f2.add(1);
		  f2.add(2);
		  
		  userTable = new HashMap<String, User>();
		  Landlord holmes=new Landlord("Sherlock","Holmes","s.holmes@gmail.com",
				  	"sh","221b Baker St London W1","12345",f1);
		  Tenant   watson=new Tenant  ("Dr","Watson","dr.watson@yahoo.com",
				  	"drw","4 Roman Rd London E1","7890",f2);
		  
		  userTable.put(holmes.getEmail(),holmes);
		  userTable.put(watson.getEmail(),watson); 
	  }
*/
	  
	  private void initiliazeFlatTable(){
		  
		  flatTable = new HashMap<Integer, Flat>();
		  
	      Flat f1 = new Flat(null, 1000,"412 Camden High Street");
	      Flat f2 = new Flat(null, 1200, "221B Baker Street");
	      Flat f3 = new Flat(null, 1500, "48 Doughty Street");
	      
	      f1.setDescription("Come live in this wonderful place! Near Camden market district," +
	      		"nice quiet neighborhood, right in front of a bus stop. Small room in flat for rent.");
	      f1.setAmenity(Flat.ALLOWS_PETS, true);
	      f1.setAmenity(Flat.INCLUDES_BILLS, true);
	      f1.setImageLink("resources/images/flat1.jpg");
	
	      f2.setDescription("Looking for a flatmat who's not incompetent or an imbecile" +
	      		"...which means most of you needn't bother contacting me. Must be alright with strange habits of a sociopathic individual.");
	      f2.setAmenity(Flat.ALLOWS_SMOKING, false);
	      f2.setAmenity(Flat.ALLOWS_PETS, false);
	      f2.setImageLink("resources/images/flat4.jpg");
	      
	      f3.setAmenity(Flat.ALLOWS_CHILDREN, false);
	      f3.setAmenity(Flat.ALLOWS_PETS, false);
	      f3.setAmenity(Flat.INCLUDES_BILLS, false);
	      f3.setImageLink("resources/images/flat3.jpg");
	      
		  //assigning owners to flats
	      f1.setOwner((Landlord)this.userTable.get("s.holmes@gmail.com"));
	      f2.setOwner((Landlord)this.userTable.get("s.holmes@gmail.com"));
	      f3.setOwner((Landlord)this.userTable.get("s.holmes@gmail.com"));
	      
	      //initializing flat reviews
	      User u1=userTable.get("dr.watson@yahoo.com");
		  User u2=userTable.get("s.holmes@gmail.com");
		  
		  Review r1=new Review(67,"This flat is quite good.",u1);
		  Review r2=new Review(1,"Too many mice!",u1);
		  Review r3=new Review(100,"Gorgeous! Love it. <3",u2);
		
		  f1.addReview(r1);
		  f1.addReview(r3);
		  f2.addReview(r2);
	      
	      flatTable.put(f1.getId(),f1);
		  flatTable.put(f2.getId(),f2);
		  flatTable.put(f3.getId(),f3);
	  }
	  
	  private void initializeUserTable(){
		  userTable = new HashMap<String, User>();
		  ArrayList<Integer> iflat=new ArrayList<Integer>();
		  ArrayList<Integer> flat=new ArrayList<Integer>();
		  
		  iflat.add(0);
		  iflat.add(1);
		  flat.add(0);
		  flat.add(1);
		  flat.add(2);

		  Tenant t=new Tenant("John", "Watson", "dr.watson@yahoo.com", "secret", "not yet", "020 1234 5678",iflat);
		  Landlord l=new Landlord("Sherlock", "Holmes", "s.holmes@gmail.com", "elementary", "221b Baker St London W1", "020 0987 6543",flat);
		  
		  this.userTable.put(t.getEmail(), t);
		  this.userTable.put(l.getEmail(), l);
		  
		  /*		  ArrayList<Integer> f1=new ArrayList<Integer>();
		  ArrayList<Integer> f2=new ArrayList<Integer>();
		  ArrayList<Integer> f3=new ArrayList<Integer>();
		  ArrayList<Integer> f4=new ArrayList<Integer>();
		  ArrayList<Integer> f5=new ArrayList<Integer>();
		  ArrayList<Integer> f6=new ArrayList<Integer>();
		  ArrayList<Integer> empty=new ArrayList<Integer>();
		  
		  //assigning the flats to the landlords
		  f1.add(0);
		  f1.add(1);
		  f2.add(2);
	
		  //assigning the interests to the tenants
		  f3.add(0);
		  f3.add(1);
		  f4.add(0);
		  f4.add(1);
		  f4.add(2);
		  f5.add(2);
		  f6.add(0);
		  f6.add(1);
		  
		  User u0 = new Tenant("Marilyn", "Monroe", "m.honeyboo@gmail.com", "cheeky", "333 Beverly Hills Road", "955-332-1102",f3);
		  User u1 = new Tenant("Katniss", "Everdeen", "k.everdeen@gmail.com", "2k50a52", "District 13 Road", "243-666-3890",f4);
		  User u2 = new Tenant("Peeta", "Mallarck", "breadwins@gmail.com", "katniss", "District 11 Road", "---",f5);
		  User u3 = new Landlord("Joffrey", "Baratheon", "iamtheking@gmail.com", "power", "111 King's Landing Street", "---",f1);
		  User u4 = new Tenant("Arya", "Stark", "arstark@gmail.com", "powertothepeople", "On-the-road Street", "---",f6);
		  User u5 = new Landlord("President", "Snow", "lord.snow@gmail.com", "crimson", "The Capitol Court", "352-999-1231",empty);
		  f3.addAll(f5);
		  User u6 = new Tenant("Sansa", "Stark", "littlyladyginger@gmail.com", "snowflake888", "---", "234-345-5747",f3);
		  User u7 = new Tenant("Ash", "Ketchum", "pikachuroks@gmail.com", "pikapika88", "222 Pallet Town", "234-121-4215",empty);
		  User u8 = new Landlord("Sherlock", "Holmes", "detectiveholmes@gmail.com", "coventry", "221B Baker Street", "352-999-1291",f2);
		  User u9 = new Landlord("Mary", "Poppins", "poppies@gmail.com", "cats", "Lovers Lane", "325-999-1291",empty);



		  String bio0 = "I love acting. :)";
		  u0.setProfile(new Profile(u0.getId(), u0.getFirstName()+ " " + u0.getLastName(), bio0, u0.getEmail(), u1.getPhoneNumber()));
		  userTable.put(u0.getEmail(), u0);

		  String bio1 = "I like arrows:)";
		  u1.setProfile(new Profile(u1.getId(), u1.getFirstName()+ " " + u1.getLastName(), bio1, u1.getEmail(), u1.getPhoneNumber()));
		  userTable.put(u1.getEmail(), u1);
		  
		  String bio2 = "I like bread. :)";
		  u2.setProfile(new Profile(u2.getId(), u2.getFirstName()+ " " + u2.getLastName(), bio2, u2.getEmail(), u2.getPhoneNumber()));
		  userTable.put(u2.getEmail(), u2);

		  String bio3 = "I hate everything.:)";
		  u3.setProfile(new Profile(u3.getId(), u3.getFirstName()+ " " + u3.getLastName(), bio3, u3.getEmail(), u3.getPhoneNumber()));
		  userTable.put(u3.getEmail(), u3);

		  String bio4 = "I love acting. :)";
		  u4.setProfile(new Profile(u4.getId(), u4.getFirstName()+ " " + u4.getLastName(), bio4, u4.getEmail(), u4.getPhoneNumber()));
		  userTable.put(u4.getEmail(), u4);
		  
		  String bio5 = "I love acting. :)";
		  u5.setProfile(new Profile(u5.getId(), u5.getFirstName()+ " " + u5.getLastName(), bio5, u5.getEmail(), u5.getPhoneNumber()));
		  userTable.put(u5.getEmail(), u5);

		  String bio6 = "I love acting. :)";
		  u6.setProfile(new Profile(u6.getId(), u6.getFirstName()+ " " + u6.getLastName(), bio6, u6.getEmail(), u6.getPhoneNumber()));
		  userTable.put(u6.getEmail(), u6);

		  String bio7 = "I love acting. :)";
		  u7.setProfile(new Profile(u7.getId(), u7.getFirstName()+ " " + u7.getLastName(), bio7, u7.getEmail(), u7.getPhoneNumber()));
		  userTable.put(u7.getEmail(), u7);

		  String bio8 = "I love acting. :)";
		  u8.setProfile(new Profile(u8.getId(), u8.getFirstName()+ " " + u8.getLastName(), bio8, u8.getEmail(), u8.getPhoneNumber()));
		  userTable.put(u8.getEmail(), u8);

		  String bio9 = "I love acting. :)";
		  u9.setProfile(new Profile(u9.getId(), u9.getFirstName()+ " " + u9.getLastName(), bio9, u9.getEmail(), u9.getPhoneNumber()));
		  userTable.put(u9.getEmail(), u9);
*/
	  }
	  
	  public HashMap<Integer, Flat> getFlatTable(){
		  return flatTable;
	  }
	  
	  public HashMap<String, User> getUserTable(){
		  return userTable;
	  }
	  
	  public HashMap<String,ArrayList<Review>> getUserReviewTable(){
		  return this.userReviewTable;
	  }

}
