package src;

public class Review {

	private int rating;
	private String subject;
	private String reviewDescription;
	private User reviewer; 
	
	public Review(int rate, String sub, String desc, User rev) {
		rating = rate;
		subject= sub;
		reviewDescription = desc;
		reviewer = rev;
	}
	
	public int getRating(){
		return rating;
	}
	
	public void setRating(int rate){
		rating = rate;
	}
	
	public String getSubject(){
		return subject;
	}
	
	public void setSubject(String sub){
		subject = sub;
	}
	
	public String getReview(){
		return reviewDescription;
	}
	
	public void setReview(String rev){
		reviewDescription = rev;
	}
	
	public User getReviewer(){
		return reviewer;
	}
	
	public void setReviewer(User rev){
		reviewer = rev;
	}

}
