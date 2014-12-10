package src;

import java.util.*;
public class Profile {

	private int ownerId;
	private String name;
	private String bio;
	private String email;
	private String phone;

	
	public Profile(int id) {
		ownerId = id;
	}
	
	public Profile(int id, String n, String b, String e, String ph){
		ownerId = id;
		name = n;
		bio = b;
		email = e;
		phone = ph;
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

}
