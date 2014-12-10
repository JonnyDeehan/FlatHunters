package servlets;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;
import src.DBManager;
import src.User;
import src.Flat;
import java.util.*;

public class ProfileViewController extends HttpServlet {
	private static final long serialVersionUID = 145425026613626544L;

@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		   throws IOException, ServletException {
	DBManager manager = DBManager.getInstance();
	
	String userId = request.getParameter("userId");
	if(userId != null){
		HashMap<Integer, User> userList = manager.getUserTable();
		User user = userList.get(Integer.parseInt(userId));
		//request.setAttribute("user", user);
		RequestDispatcher rd = request.getRequestDispatcher("profile_view.jsp");
	   	request.setAttribute("user", user);
	   	rd.forward(request, response);
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