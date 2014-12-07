package servlets;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import src.Session;
 
public class LoginViewController extends HttpServlet {
	private static final long serialVersionUID = -7682619775594735721L;

@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		   throws IOException, ServletException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String caller=getCaller(request);
		
		if(caller.equals("login_view.jsp")){
			if(authenticate(request.getParameter("email"),request.getParameter("password"))){
				Session ssn=loadSessionFromDB();
				loadPage(request,response,"login_good.jsp");
			}
			else
				loadPage(request,response,"login_bad.jsp");
		}else if(caller.equals("register_view.jsp")){
			Session s=Session.getInstance();
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
		}else{
			
		}
   }

@Override
	public void doPost (HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	
	private String getCaller(HttpServletRequest request){
		String[] tmp=request.getHeader("Referer").split("/");
		return new String(tmp[tmp.length-1]);
	}
	
	private void loadPage(HttpServletRequest request, HttpServletResponse response,String pagename)
			throws IOException, ServletException {
		RequestDispatcher rd = request.getRequestDispatcher(pagename);
		rd.forward(request, response);
	}
	
	private Session loadSessionFromDB(){
		Session s=Session.getInstance();
		//TODO dummy method.
		s.setFirstName("Sherlock");
		s.setLastName("Holmes");
		s.setPassword("supersecret");
		s.setPhoneNumber("000 1234");
		s.setEmail("s.holmes@gmail.com");
		s.setAddress("221b Baker St\nLondon\nNW1 6XE");
		return s;
	}
	private boolean updateDB(String query){
		return true;
	}
	private boolean authenticate(String username,String password){
		return true;
	}
}