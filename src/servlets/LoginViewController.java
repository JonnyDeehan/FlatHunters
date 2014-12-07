package servlets;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import src.Session;
import src.User;
 
public class LoginViewController extends HttpServlet {
	private static final long serialVersionUID = -7682619775594735721L;

	private static final int SEARCH		=0;
	private static final int LOGIN		=1;
	private static final int REGISTER	=2;
	
@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		   throws IOException, ServletException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		int caller=getCaller(request);

		switch(caller){
			case LOGIN:
				if(authenticate(request.getParameter("email"),request.getParameter("password"))){
					loadPage(request,response,"login_good.jsp");
				}
				else
					loadPage(request,response,"login_bad.jsp");
			break;
			case REGISTER:
				User s=Session.getInstance().getUser();
				s.setAddress(request.getParameter("address_1")+"\n"+
						request.getParameter("address_2")+"\n"+
						request.getParameter("address_3")
				);
				s.setEmail(request.getParameter("email"));
				s.setFirstName(request.getParameter("first_name"));
				s.setLastName(request.getParameter("last_name"));
				s.setPassword(request.getParameter("password"));
				s.setPhoneNumber(request.getParameter("password"));
				
				loadPage(request,response,"register_good.jsp");
			break;
			case SEARCH:
				String type=request.getParameter("type");
				if(type.equals("login"))
					loadPage(request,response,"login_view.jsp");
				else if(type.equals("register"))
					loadPage(request,response,"register_view.jsp");
			break;
			default:
				System.out.println("ERROR!");
		}
		
   }

@Override
	public void doPost (HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	
	private int getCaller(HttpServletRequest request){
		return Integer.parseInt(request.getParameter("caller"));
	}
	
	private void loadPage(HttpServletRequest request, HttpServletResponse response,String pagename)
			throws IOException, ServletException {
		RequestDispatcher rd = request.getRequestDispatcher(pagename);
		rd.forward(request, response);
	}
	
	private void loadSessionFromDB(){
		User s=Session.getInstance().getUser();
		//TODO dummy method.
		s.setFirstName("Sherlock");
		s.setLastName("Holmes");
		s.setPassword("supersecret");
		s.setPhoneNumber("000 1234");
		s.setEmail("s.holmes@gmail.com");
		s.setAddress("221b Baker St\nLondon\nNW1 6XE");
		
		//return Session.getInstance().setUser(s);
	}
	private boolean authenticate(String username,String password){
		//TODO dummy method
		return false;
	}
}