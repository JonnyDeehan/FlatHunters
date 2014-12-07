package src;

import java.util.ArrayList;

public class Tenant extends User {

	private ArrayList<Flat> iflats;
	
	public Tenant(int id, String first_name, String last_name, String email,
			String password, String address, String phone,ArrayList<Flat> fl) {
		super(id, first_name, last_name, email, password, address, phone);
		this.iflats=fl;
	}

	public Tenant(Tenant u) {
		super(u);
		this.iflats=u.getInterestingFlats();
	}

	private ArrayList<Flat> getInterestingFlats() {
		return this.iflats;
	}

}
