package servlets;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import src.Flat;
import src.DBManager;
 
public class SearchViewController extends HttpServlet {
	public static final int FULL_SEARCH=0;
			
   @Override
   public void doGet(HttpServletRequest request, HttpServletResponse response)
               throws IOException, ServletException {
      // Set the response message's MIME type
      response.setContentType("text/html;charset=UTF-8");
      // Allocate a output writer to write the response message into the network socket
      PrintWriter out = response.getWriter();
    
      DBManager db=DBManager.getInstance();
      ArrayList<Flat> flat_list = new ArrayList<Flat>(db.getFlatTable().values());
      ArrayList<Flat> result=new ArrayList<Flat>();
      int caller;
      boolean ok=true;
      try{
			caller=Integer.parseInt(request.getParameter("caller"));
		}catch(Exception exc){
			caller=-1;
		}
      
      switch(caller){
      case FULL_SEARCH:
    	  String bills=request.getParameter("bills");
    	  String children=request.getParameter("children");
    	  String pets=request.getParameter("pets");
    	  String smoking=request.getParameter("smoking");
    	  String washer=request.getParameter("washer");
    	  boolean[] am=new boolean[5];
    	  
    	  am[Flat.INCLUDES_BILLS]=	(bills!=null)?(bills.equals("included")):(false);
    	  am[Flat.ALLOWS_CHILDREN]=	(children!=null)?(children.equals("allowed")):(false);
    	  am[Flat.ALLOWS_PETS]=		(pets!=null)?(pets.equals("allowed")):(false);
    	  am[Flat.ALLOWS_SMOKING]=	(smoking!=null)?(smoking.equals("allowed")):(false);
    	  am[Flat.INCLUDES_WASHER_DRYER]=(washer!=null)?(washer.equals("included")):(false);
    	  
    	  for(Flat f:flat_list){
    		  System.out.println("-------------------------------------");
    	  	  System.out.println(f.getAddress());
    		  ok=true;
    		  ok=ok && addressFilter(f,request.getParameter("address"));
        	  ok=ok && priceFilter(f,Integer.parseInt(request.getParameter("min")),
        			  				 Integer.parseInt(request.getParameter("max")));
        	  ok=ok && amenitiesFilter(f,am);
        	  ok=ok && averageRatingFilter(f,Integer.parseInt(request.getParameter("rating")));
        	  if(ok)
        		  result.add(f);
          }
    	  
    	  RequestDispatcher rd = request.getRequestDispatcher("searchResultsView.jsp"); 	  
    	  request.setAttribute("search_results", result);
    	  rd.forward(request, response);
      break;
      default:
	      // Show the full view of search
	      if(request.getParameter("full") != null && request.getParameter("full").equals("true")){
	    	  RequestDispatcher rd1 = request.getRequestDispatcher("search.jsp");
	    	  rd1.forward(request, response);
	      }
	      // Process search if search query is sent
	      else if(request.getParameter("address") != null){
	          for(Flat f:flat_list){
	        	  ok=true;
	        	  ok=ok && addressFilter(f,request.getParameter("address"));
	        	  if(ok)
	        		  result.add(f);
	          }
	    	  RequestDispatcher rd2 = request.getRequestDispatcher("searchResultsView.jsp"); 	  
	    	  request.setAttribute("search_results", result);
	    	  rd2.forward(request, response);
	      }
	      // Default to 'home' search view
	      else{
	    	  RequestDispatcher rd3 = request.getRequestDispatcher("search.jsp");
	    	  rd3.forward(request, response);
	      }
      }
	
   }

private boolean averageRatingFilter(Flat f,int min) {
	System.out.println("RATING FILTER: "+(f.getRating()>=min));
	return f.getRating()>=min;
}

private boolean amenitiesFilter(Flat f,boolean[]as) {
	boolean ok=true;
	for(int i=0;i<as.length;i++){
		System.out.println("checking for amenity: "+Flat.amenities_name[i]);
		System.out.println("FLAT: "+f.getAmenities()[i]+", QUERY: "+as[i]);
		
		ok= ok && f.hasAmenity(i)==as[i];
	}
	System.out.println("AMENITY FILTER: "+ok);
	return ok;
}

private boolean priceFilter(Flat f,int min,int max) {
	System.out.println("PRICE FILTER"+(f.getPrice()>=min && f.getPrice()<=max));
	return f.getPrice()>=min && f.getPrice()<=max;
}

private boolean addressFilter(Flat f,String addr) {
	System.out.println("Flat address: "+f.getAddress());
	System.out.println("Query address: "+addr);
	System.out.println("ADDR FILTER: "+((addr!="")?(f.getAddress().contains(addr)):(true)));
	return (addr!="")?(f.getAddress().contains(addr)):(true);
}


}