package servlets;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;
 
public class ProfileViewController extends HttpServlet {
	private static final long serialVersionUID = 145425026613626544L;

@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		   throws IOException, ServletException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String caller=getCaller(request);
		
		if(caller.equals("login_view.jsp")){
			if(authenticate(request.getParameter("email"),request.getParameter("password")))
				loadPage(request,response,"login_good.jsp");
			else
				loadPage(request,response,"login_bad.jsp");
		}else if(caller.equals("register_view.jsp")){
			
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
	private boolean updateDB(String query){
		return true;
	}
	private boolean authenticate(String username,String password){
		return true;
	}
}