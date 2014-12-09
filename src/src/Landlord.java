package src;

import java.util.ArrayList;

public class Landlord extends User {

	private ArrayList<Flat> flats;
	
	public Landlord(String first_name, String last_name, String email,
			String password, String address, String phone) {
		super(first_name, last_name, email, password, address, phone);
		this.flats=new ArrayList<Flat>();
	}

	public Landlord(Landlord l) {
		super(l);
		this.flats=l.getFlatList();
	}

	public ArrayList<Flat> getFlatList() {
		return this.flats;
	}
}
