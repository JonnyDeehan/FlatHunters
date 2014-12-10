package src;

import java.util.*;
public class Profile {

	private int ownerId;
	private String name;
	private String bio;
	private String email;
	private String phone;
	private ArrayList<Review> reviews;
	
	public Profile(int id) {
		ownerId = id;
	}
	
	public Profile(User u){
		reviews=DBManager.getInstance().getUserReviewTable().get(u.getEmail());
		ownerId = u.getId();
		name = u.getFirstName()+" "+u.getLastName();
		bio = u.getBio();
		email = u.getEmail();
		phone = u.getPhoneNumber();
	}

	public String getBio(){
		return bio;
	}
	
	public String getName(){
		return name;
	}
	
	public String getEmail(){
		return email;
	}
	
	public String getPhone(){
		return phone;
	}
	
	public int getOwnerId(){
		return ownerId;
	}
	public ArrayList<Review> getReviews(){
		return this.reviews;
	}
}
