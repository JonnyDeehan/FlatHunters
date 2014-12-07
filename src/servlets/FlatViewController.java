package servlets;

import java.io.*;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.http.*;
import src.DBManager;
import src.Flat;

public class FlatViewController extends HttpServlet {
   @Override
   public void doGet(HttpServletRequest request, HttpServletResponse response)
               throws IOException, ServletException {
      // Set the response message's MIME type
      response.setContentType("text/html;charset=UTF-8");
      // Allocate a output writer to write the response message into the network socket
      PrintWriter out = response.getWriter();
      DBManager manager = DBManager.getInstance();
      
      
      // Process search if search query is sent
      if(request.getParameter("id") != null){
    	  Flat f = manager.getFlatTable().get(Integer.parseInt(request.getParameter("id")));
    	  request.setAttribute("flat", f);
    	  RequestDispatcher rd = request.getRequestDispatcher("flatProfileView.jsp");
    	  rd.forward(request, response);
      }
		
   }
}