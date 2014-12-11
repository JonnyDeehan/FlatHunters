package src;

import java.util.*;

public class Flat {
	
	public static final int INCLUDES_BILLS 			= 0;
	public static final int INCLUDES_WASHER_DRYER 	= 1;
	public static final int ALLOWS_PETS 			= 2;
	public static final int ALLOWS_CHILDREN 		= 3;
	public static final int ALLOWS_SMOKING 			= 4;
	public static final String[] amenities_name = {
			"Bills included","Washer dryer","Pets allowed","Children allowed","Smoking allowed"
	};
	
	public static int flatIdCount = 0;
	
	private int price;
	private String address;
	private Landlord owner;
	private String description;
	private boolean[] amenities;
	private String imageLink;
	private int flatId;
	private ArrayList<Review> reviewList;
	private int rating;
	
	
	public Flat(Landlord own){
		flatId = flatIdCount;
		price = -1;
		address = "";
		owner = own;
		description = "";
		amenities=new boolean[5];
		imageLink = "";
		rating = -1;
		reviewList=new ArrayList<Review>();
		
		for(int i=0;i<amenities.length;i++)
			amenities[i]=false;
		
		flatIdCount++;
	}
	
	public Flat(Landlord own, int p, String addr){
		flatId = flatIdCount;
		price = p;
		address = addr;
		owner = own;
		description = "";
		amenities=new boolean[5];
		imageLink = "";
		rating = -1;
		reviewList=new ArrayList<Review>();
		
		for(int i=0;i<amenities.length;i++)
			amenities[i]=false;
			
		flatIdCount++;
	}
	public int getId(){
		return flatId;
	}
	
	public int getPrice(){
		return price;
	}
	
	public void setPrice(int p){
		price = p;
	}
	
	public String getAddress(){
		return address;
	}
	
	public void setAddress(String addr){
		address = addr;
	}
	
	public Landlord getOwner(){
		return owner;
	}
	
	public void setOwner(Landlord own){
		owner = own;
	}
	
	public String getDescription(){
		return description;
	}
	
	public void setDescription(String desc){
		description = desc;
	}
	
	public void setAmenity(int i,boolean a){
		this.amenities[i]=a;
	}
	
	public boolean hasAmenity(int i){
		return this.amenities[i];
	}
	
	public void setAminities(boolean[] a){
		for(int i=0;i<amenities.length;i++)
			amenities[i]=a[i];		
	}
	
	public boolean[] getAmenities(){
		return this.amenities;
	}
	
	public String getImageLink(){
		return imageLink;
	}
	
	public void setImageLink(String il){
		imageLink = il;
	}
	
	public String toHTML(){
		String str=new String();
		
		str= "<table width=\"100%\" border=\"0\"><tr><td>";
		str+="<h3>Flat #"+this.getId()+"</h3><br />";
		str+=this.getAddress()+"<br />";//£"+this.getPrice()+"<br />";
		str+="</td><td>";
		str+="<img align=\"left\" src="+this.getImageLink()+" class=\"img-rounded\">";
		str+="</td></tr></table>";
		return str;
	}

	public void addReview(Review r){
		rating = (rating*reviewList.size() + r.getRating())/(reviewList.size()+1);
		reviewList.add(r);
	}
	
	public ArrayList<Review> getReviewList(){
		return reviewList;
	}
	
	public int getRating(){
		return rating;
	}

}
