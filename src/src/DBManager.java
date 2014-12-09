package src;

import java.util.*;

public class DBManager {
	
	private static DBManager instance;

	  private HashMap<Integer, Flat> flatTable;
	  private HashMap<Integer, User> userTable;
	  
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
	  }
	  
	  private void initiliazeFlatTable(){
		  
		  flatTable = new HashMap<Integer, Flat>();
		  
	      Flat f1 = new Flat((Landlord) userTable.get(3), 1000,"412 Camden High Street");
	      Flat f2 = new Flat((Landlord) userTable.get(8), 1200, "221B Baker Street");
	      Flat f3 = new Flat((Landlord) userTable.get(3), 1500, "48 Doughty Street");
	      
	      f1.setDescription("Come live in this wonderful place! Near Camden market district," +
	      		"nice quiet neighborhood, right in front of a bus stop. Small room in flat for rent.");
	      f1.setAmenity(Flat.ALLOWS_PETS, Flat.YES);
	      f1.setAmenity(Flat.INCLUDES_BILLS, Flat.YES);
	      f1.setImageLink("resources/images/flat1.jpg");
	
	      f2.setDescription("Looking for a flatmat who's not incompetent or an imbecile" +
	      		"...which means most of you needn't bother contacting me. Must be alright with strange habits of a sociopathic individual.");
	      f2.setAmenity(Flat.ALLOWS_SMOKING, Flat.NO);
	      f2.setAmenity(Flat.ALLOWS_PETS, Flat.NO);
	      f2.setImageLink("resources/images/flat4.jpg");
	      
	      f3.setAmenity(Flat.ALLOWS_CHILDREN, Flat.NO);
	      f3.setAmenity(Flat.ALLOWS_PETS, Flat.NO);
	      f3.setAmenity(Flat.INCLUDES_BILLS, Flat.NO);
	      f3.setImageLink("resources/images/flat3.jpg");
	      
	      flatTable.put(f1.getId(),f1);
		  flatTable.put(f2.getId(),f2);
		  flatTable.put(f3.getId(),f3);
		  
	  }
	  
	  private void initializeUserTable(){
		  userTable = new HashMap<Integer, User>();
		  
		  User u0 = new Tenant("Marilyn", "Monroe", "m.honeyboo@gmail.com", "cheeky", "333 Beverly Hills Road", "955-332-1102");
		  User u1 = new Tenant("Katniss", "Everdeen", "k.everdeen@gmail.com", "2k50a52", "District 13 Road", "243-666-3890");
		  User u2 = new Tenant("Peeta", "Mallarck", "breadwins@gmail.com", "katniss", "District 11 Road", "---");
		  User u3 = new Landlord("Joffrey", "Baratheon", "iamtheking@gmail.com", "power", "111 King's Landing Street", "---");
		  User u4 = new Tenant("Arya", "Stark", "arstark@gmail.com", "powertothepeople", "On-the-road Street", "---");
		  User u5 = new Landlord("President", "Snow", "lord.snow@gmail.com", "crimson", "The Capitol Court", "352-999-1231");
		  User u6 = new Tenant("Sansa", "Stark", "littlyladyginger@gmail.com", "snowflake888", "---", "234-345-5747");
		  User u7 = new Tenant("Ash", "Ketchum", "pikachuroks@gmail.com", "pikapika88", "222 Pallet Town", "234-121-4215");
		  User u8 = new Landlord("Sherlock", "Holmes", "detectiveholmes@gmail.com", "coventry", "221B Baker Street", "352-999-1291");
		  User u9 = new Landlord("Mary", "Poppins", "poppies@gmail.com", "cats", "Lovers Lane", "325-999-1291");
		  
		  String bio0 = "I love acting. :)";
		  u0.setProfile(new Profile(u0.getId(), u0.getFirstName()+ " " + u0.getLastName(), bio0, u0.getEmail(), u1.getPhoneNumber()));
		  userTable.put(u0.getId(), u0);

		  String bio1 = "I like arrows:)";
		  u1.setProfile(new Profile(u1.getId(), u1.getFirstName()+ " " + u1.getLastName(), bio1, u1.getEmail(), u1.getPhoneNumber()));
		  userTable.put(u1.getId(), u1);
		  
		  String bio2 = "I like bread. :)";
		  u2.setProfile(new Profile(u2.getId(), u2.getFirstName()+ " " + u2.getLastName(), bio2, u2.getEmail(), u2.getPhoneNumber()));
		  userTable.put(u2.getId(), u2);

		  String bio3 = "I hate everything.:)";
		  u3.setProfile(new Profile(u3.getId(), u3.getFirstName()+ " " + u3.getLastName(), bio3, u3.getEmail(), u3.getPhoneNumber()));
		  userTable.put(u3.getId(), u3);

		  String bio4 = "I love acting. :)";
		  u4.setProfile(new Profile(u4.getId(), u4.getFirstName()+ " " + u4.getLastName(), bio4, u4.getEmail(), u4.getPhoneNumber()));
		  userTable.put(u4.getId(), u4);
		  
		  String bio5 = "I love acting. :)";
		  u5.setProfile(new Profile(u5.getId(), u5.getFirstName()+ " " + u5.getLastName(), bio5, u5.getEmail(), u5.getPhoneNumber()));
		  userTable.put(u5.getId(), u5);

		  String bio6 = "I love acting. :)";
		  u6.setProfile(new Profile(u6.getId(), u6.getFirstName()+ " " + u6.getLastName(), bio6, u6.getEmail(), u6.getPhoneNumber()));
		  userTable.put(u6.getId(), u6);

		  String bio7 = "I love acting. :)";
		  u7.setProfile(new Profile(u7.getId(), u7.getFirstName()+ " " + u7.getLastName(), bio7, u7.getEmail(), u7.getPhoneNumber()));
		  userTable.put(u7.getId(), u7);

		  String bio8 = "I love acting. :)";
		  u8.setProfile(new Profile(u8.getId(), u8.getFirstName()+ " " + u8.getLastName(), bio8, u8.getEmail(), u8.getPhoneNumber()));
		  userTable.put(u8.getId(), u8);

		  String bio9 = "I love acting. :)";
		  u9.setProfile(new Profile(u9.getId(), u9.getFirstName()+ " " + u9.getLastName(), bio9, u9.getEmail(), u9.getPhoneNumber()));
		  userTable.put(u9.getId(), u9);

	  }
	  
	  public HashMap<Integer, User> getUserTable(){
		  return userTable;
	  }
	  
	  public HashMap<Integer, Flat> getFlatTable(){
		  return flatTable;
	  }
	  
	  
	 

}
