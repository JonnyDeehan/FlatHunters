package src;

import java.util.ArrayList;

public class Landlord extends User {

	private ArrayList<Flat> flats;
	
	public Landlord(int id, String first_name, String last_name, String email,
			String password, String address, String phone,ArrayList<Flat> flats) {
		super(id, first_name, last_name, email, password, address, phone);
		this.flats=new ArrayList<Flat>(flats);
	}

	public Landlord(Landlord l) {
		super(l);
		this.flats=l.getFlatList();
	}

	public ArrayList<Flat> getFlatList() {
		return this.flats;
	}
}
