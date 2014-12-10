package servlets;

import java.io.*;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.http.*;

import src.*;

public class FlatViewController extends HttpServlet {
	private static final long serialVersionUID = -859047787654753360L;
	private static final int FLAT=0;
	private static final int REVIEW=2;
	@Override
   public void doGet(HttpServletRequest request, HttpServletResponse response)
               throws IOException, ServletException {
      // Set the response message's MIME type
      response.setContentType("text/html;charset=UTF-8");
      // Allocate a output writer to write the response message into the network socket
      //PrintWriter out = response.getWriter();
      DBManager manager = DBManager.getInstance();
      
      int caller;
      try{
    	  caller=Integer.parseInt(request.getParameter("caller"));
      }catch(Exception exc){
    	  caller=-1;
      }
      Flat f;
      switch(caller){
      	  case REVIEW:
      		int rating=Integer.parseInt(request.getParameter("rating"));
			String description=request.getParameter("review");
			String author=request.getParameter("author");
			Review r=new Review(rating,description,author);
			int fk =Integer.parseInt(request.getParameter("flatKey"));


			DBManager db=DBManager.getInstance();
			db.getFlatTable().get(fk).addReview(r);
			
			RequestDispatcher rd = request.getRequestDispatcher("flatProfileView.jsp");
			f = DBManager.getInstance().getFlatTable().get(fk);
			request.setAttribute("flat",f);
			rd.forward(request, response);
      	  break;
	      case FLAT:
	    	  String p1=request.getParameter("interested");
	    	  String p2=request.getParameter("account");
	    	  
	    	  if(p2!=null)
	    		  loadPage(request,response,"account_view.jsp");
	    	  
	    	  if(p1!=null){
	    		User u=Session.getInstance().getUser();
	    	  	int new_id=Integer.parseInt(request.getParameter("id"));
	    	  	((Tenant)u).getInterestingFlats().add(new_id);
	    	  	f = manager.getFlatTable().get(Integer.parseInt(request.getParameter("id")));
		    	request.setAttribute("flat", f);
	    	  	loadPage(request,response,"flat_added.jsp");
	    	  }
	      break;
	      default:
		      // Process search if search query is sent
		      if(request.getParameter("id") != null){
		    	  f = manager.getFlatTable().get(Integer.parseInt(request.getParameter("id")));
		    	  request.setAttribute("flat", f);
		    	  
		    	  RequestDispatcher rdd = request.getRequestDispatcher("flatProfileView.jsp");
		    	  rdd.forward(request, response);
		      }
	   }
   }
   
   private void loadPage(HttpServletRequest request, HttpServletResponse response,String pagename)
			throws IOException, ServletException {
		RequestDispatcher rd = request.getRequestDispatcher(pagename);
		rd.forward(request, response);
	}
}