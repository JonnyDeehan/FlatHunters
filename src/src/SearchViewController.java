package src;

import java.io.*;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.http.*;
 
public class SearchViewController extends HttpServlet {
   @Override
   public void doGet(HttpServletRequest request, HttpServletResponse response)
               throws IOException, ServletException {
      // Set the response message's MIME type
      response.setContentType("text/html;charset=UTF-8");
      // Allocate a output writer to write the response message into the network socket
      PrintWriter out = response.getWriter();
      
      // Write the response message, in an HTML page
      /*try {
         out.println("<!DOCTYPE html>");
         out.println("<html><head>");
         out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
         out.println("<title>Hello, World</title></head>");
         out.println("<body>");
         out.println("<h1>Hello, world!</h1>");  // says Hello
         // Echo client's request information
         out.println("<p>Request URI: " + request.getRequestURI() + "</p>");
         out.println("<p>Protocol: " + request.getProtocol() + "</p>");
         out.println("<p>PathInfo: " + request.getPathInfo() + "</p>");
         out.println("<p>Remote Address: " + request.getRemoteAddr() + "</p>");
         // Generate a random number upon each request
         out.println("<p>A Random Number: <strong>" + Math.random() + "</strong></p>");
         out.println("</body>");
         out.println("</html>");

      } finally {
         out.close();  // Always close the output writer
      }*/
      
      /**** Dummy values ****/
      
      ArrayList<Flat> flatList = new ArrayList<Flat>();
      Flat f1 = new Flat("Margaret Thatcher", 1000,"412 Camden High Street");
      Flat f2 = new Flat("Sherlock Holmes", 1200, "221B Baker Street");
      Flat f3 = new Flat("Scrooge", 1500, "48 Doughty Street");
      
      f1.setDescription("Come live in this wonderful place! Near Camden market district," +
      		"nice quiet neighborhood, right in front of a bus stop. Small room in flat for rent.");
      f1.setAmenity(Flat.ALLOWS_PETS, Flat.YES);
      f1.setAmenity(Flat.INCLUDES_BILLS, Flat.YES);
      f1.setImageLink("resources/images/flat1.jpg");
      
      f2.setDescription("Looking for a flatmat who's not incompetent or an imbecile" +
      		"...which means most of you needn't bother contacting me. Must be alright with strange habits of a sociopathic individual.");
      f2.setAmenity(Flat.ALLOWS_SMOKING, Flat.NO);
      f2.setAmenity(Flat.ALLOWS_PETS, Flat.NO);
      f2.setImageLink("resources/images/flat4.jpg");
      
      f3.setAmenity(Flat.ALLOWS_CHILDREN, Flat.NO);
      f3.setAmenity(Flat.ALLOWS_PETS, Flat.NO);
      f3.setAmenity(Flat.INCLUDES_BILLS, Flat.NO);
      f3.setImageLink("resources/images/flat3.jpg");
      
      flatList.add(f1);
	  flatList.add(f2);
	  flatList.add(f3);
	  
      
      /******* DO WORK ********/
      
      
      // Process search if search query is sent
      if(request.getParameter("address") != null){
    	  System.out.println("it's a submission!");
    	  
    	  RequestDispatcher rd = request.getRequestDispatcher("searchResultsView.jsp");
    	   	  
    	  request.setAttribute("search_results", flatList);
    	  rd.forward(request, response);
      }
      // Default to 'home' search view
      else{
    	  RequestDispatcher rd = request.getRequestDispatcher("search.jsp");
    	  rd.forward(request, response);
      }
      
      

      
		
   }
}