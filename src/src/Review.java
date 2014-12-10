package src;

public class Review {

	private int rating;
	private String reviewDescription;
	private String reviewer; 
	
	public Review(int rate, String desc, User rev) {
		rating = rate;
		reviewDescription = desc;
		reviewer = rev.getFirstName()+" "+rev.getLastName();
	}
	
	public Review(int rate, String desc, String rev) {
		rating = rate;
		reviewDescription = desc;
		reviewer = rev;
	}
	
	public int getRating(){
		return rating;
	}
	
	public void setRating(int rate){
		rating = rate;
	}
	
	public String getReview(){
		return reviewDescription;
	}
	
	public void setReview(String rev){
		reviewDescription = rev;
	}
	
	public String getReviewer(){
		return reviewer;
	}
	
	public void setReviewer(String rev){
		reviewer = rev;
	}
	
	public String toHTML(){
		String str=new String();
		str+="<h3>Rating: "+this.getRating()+"</h3><br />";
		str+=this.getReview()+"<br />";//£"+this.getPrice()+"<br />";
		str+="Author: "+this.getReviewer()+"<br />";
		return str;
	}
}
