package src;

import java.util.*;

public class DBManager {
	
	private static DBManager instance;

	  private HashMap<Integer, Flat> flatTable;
	  
	  private DBManager(){
		  
		  initializeDatabases();
	  }

	  public static DBManager getInstance(){
	    if (instance == null)
	    	instance=new DBManager();
	    return instance;
	  }
	  
	  private void initializeDatabases(){
		  initiliazeFlatTable();
	  }
	  
	  private void initiliazeFlatTable(){
		  
		  flatTable = new HashMap<Integer, Flat>();
		  
	      Flat f1 = new Flat("Margaret Thatcher", 1000,"412 Camden High Street");
	      Flat f2 = new Flat("Sherlock Holmes", 1200, "221B Baker Street");
	      Flat f3 = new Flat("Scrooge", 1500, "48 Doughty Street");
	      
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
	  
	  public HashMap<Integer, Flat> getFlatTable(){
		  return flatTable;
	  }
	  
	  
	 

}
