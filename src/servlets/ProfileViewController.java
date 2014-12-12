package servlets;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import src.*;

import java.util.*;

public class ProfileViewController extends HttpServlet {
	private static final long serialVersionUID = 145425026613626544L;
	public static final int REVIEW=0;
@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		   throws IOException, ServletException {
		int caller;
	    try{
	  	  caller=Integer.parseInt(request.getParameter("caller"));
	    }catch(Exception exc){
	  	  caller=-1;
	    }
	    User user;
	
		switch(caller){
		case REVIEW:
			int rating=Integer.parseInt(request.getParameter("rating"));
			String description=request.getParameter("review");
			String author=request.getParameter("author");
			Review r=new Review(rating,description,author);
			
			String uk =request.getParameter("userKey");

			DBManager db=DBManager.getInstance();
			ArrayList<Review> rs=db.getUserReviewTable().get(uk);
			rs.add(r);
			
			RequestDispatcher rd = request.getRequestDispatcher("profile_view.jsp");
			user = DBManager.getInstance().getUserTable().get(uk);
			request.setAttribute("user",user);
			rd.forward(request, response);
		break;
		default:
			String userKey=request.getParameter("userKey");
			//i can receive the use either via userId or via attribute (not so sure) (?)
			if(userKey != null){
				user = DBManager.getInstance().getUserTable().get(userKey);
			}
			else{
				user =(User)request.getAttribute("user");
			}
			RequestDispatcher rdd = request.getRequestDispatcher("profile_view.jsp");
			request.setAttribute("user",user);
			rdd.forward(request, response);
		}
   }

@Override
	public void doPost (HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void loadPage(HttpServletRequest request, HttpServletResponse response,String pagename)
			throws IOException, ServletException {
		RequestDispatcher rd = request.getRequestDispatcher(pagename);
		rd.forward(request, response);
	}
}