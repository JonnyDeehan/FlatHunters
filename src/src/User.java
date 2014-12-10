package src;

public abstract class User {

	private int	   id;
	private String first_name;
	private String last_name;
	private String email;
	private String password;
	private String address;
	private String phone;
	private Profile profile;
	private static int userIdCount = 0;

	
	protected User(){
		this.id=userIdCount;
		this.first_name="";
		this.last_name="";
		this.email="";
		this.password="";
		this.address="";
		this.phone="";
		userIdCount++;
	}

	protected User(String first_name,String last_name,
			String email,String password,String address,String phone){
		
		this.id=userIdCount;
		this.first_name=first_name;
		this.last_name=last_name;
		this.email=email;
		this.password=password;
		this.address=address;
		this.phone=phone;
		userIdCount++;
	}
	
	protected User(User u){
		this.id=userIdCount;
		this.first_name=u.getFirstName();
		this.last_name=u.getLastName();
		this.email=u.getEmail();
		this.password=u.getPassword();
		this.address=u.getAddress();
		this.phone=u.getPhoneNumber();
		userIdCount++;
	}
	
	private int generateId(){
		int x=User.idcount;
		User.idcount++;
		return x;
	}
	public int getId(){
		return this.id;
	}
	
	public void setFirstName(String fn){
		this.first_name=fn;
	}
	
	public String getFirstName(){
		return this.first_name;
	}
	
	public void setLastName(String ln){
		this.last_name=ln;
	}
	
	public String getLastName(){
		return this.last_name;
	}
	
	public void setEmail(String em){
		this.email=em;
	}
	
	public String getEmail(){
		return this.email;
	}
	
	public void setPassword(String pwd){
		this.password=pwd;
	}
	
	public String getPassword(){
		return this.password;
	}
	
	public void setPhoneNumber(String pn){
		this.phone=pn;
	}
	
	public String getPhoneNumber(){
		return this.phone;
	}
	
	public void setAddress(String addr){
		this.address=addr;
	}
	
	public String getAddress(){
		return this.address;
	}
	
	public void setProfile(Profile p){
		profile = p;
	}
	
	public Profile getProfile(){
		return profile;
	}
}
