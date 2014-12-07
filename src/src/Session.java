package src;

public class Session{
  private static Session instance;

  private String first_name;
  private String last_name;
  private String email;
  private String password;
  private String phone_number;
  private String address;
  
  private Session(){
	  this.first_name	=new String("");
	  this.last_name	=new String("");
	  this.email		=new String("");
	  this.password		=new String("");
	  this.phone_number	=new String("");
	  this.address		=new String("");
  }

  public static Session getInstance(){
    if (instance == null)
    	instance=new Session();
    return instance;
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
	  this.phone_number=pn;
  }
  public String getPhoneNumber(){
	  return this.phone_number;
  }
  public void setAddress(String addr){
	  this.address=addr;
  }
  public String getAddress(){
	  return this.address;
  }
}
