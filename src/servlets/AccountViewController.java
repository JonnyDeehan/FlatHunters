package servlets;

import java.io.*;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.*;
import javax.servlet.http.*;

import src.*;

public class AccountViewController extends HttpServlet {
	private static final long serialVersionUID = -4831167340033631399L;
	private static final int MAIN	=0;
	private static final int EDIT	=1;
	private static final int REMOVE	=3;
	private static final int ADD	=4;
	
@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		User u=Session.getInstance().getUser();
		boolean landlord=u instanceof Landlord;
		int caller;
		
		try{
			caller= Integer.parseInt(request.getParameter("caller"));
		}catch(Exception exc){
			caller=-1;
		}
		
		switch(caller){
			case MAIN:
				String edit	  =request.getParameter("edit");
				String profile=request.getParameter("profile");
				String add	  =request.getParameter("add");
				
				if(edit!=null)
					loadPage(request,response,"account_edit.jsp");
				if(profile!=null){
					RequestDispatcher rd = request.getRequestDispatcher("profile_view.jsp");
					request.setAttribute("user",u);
					rd.forward(request, response);
				}
				if(add!=null)
					loadPage(request,response,"flat_edit.jsp");
				
			break;
			case EDIT:
				u.setFirstName(request.getParameter("first_name"));
				u.setLastName( request.getParameter("last_name"));
				u.setEmail(	   request.getParameter("email"));
				u.setPassword( request.getParameter("password"));
				u.setAddress(  request.getParameter("address"));
				u.setPhoneNumber(request.getParameter("phone"));
				u.setBio(	   request.getParameter("bio"));
				loadPage(request,response,"account_view.jsp");
			break;
			case REMOVE:
				int id=Integer.parseInt(request.getParameter("flat_id"));
				
				//if it's a landlord, remove the flat from the db
				if(landlord)
					DBManager.getInstance().getFlatTable().remove(id);
				//if it's a tenant, remove the flat from the personal list
				else
					removeInterestingFlat((Tenant)u,id);
				
				loadPage(request,response,"account_view.jsp");
			break;
			case ADD:
				Map<Integer,Flat> flatTable=DBManager.getInstance().getFlatTable();
				Flat f=new Flat((Landlord)u);
				((Landlord)u).getFlatList().add(f.getId());
				f.setAddress(request.getParameter("address"));
				f.setDescription(request.getParameter("description"));
				f.setPrice(Integer.parseInt(request.getParameter("price")));
				f.setImageLink("resources/images/default.jpg");
				flatTable.put(f.getId(),f);
				//TODO add the rest of attributes (amenity and image)
				//TODO implement image uploading here.
				uploadImage();
				loadPage(request,response,"account_view.jsp");
			break;
			default:
				loadPage(request,response,"account_view.jsp");
		}
		
	}

	private void uploadImage(){
		
	}

	private void removeInterestingFlat(Tenant u,int id){
		ArrayList<Integer> iflats=u.getInterestingFlats();
		
		for(int i=0;i<iflats.size();i++){
			if(id==iflats.get(i)){
				iflats.remove(i);
				return;
			}
		}
	}
	private void loadPage(HttpServletRequest request, HttpServletResponse response,String pagename)
			throws IOException, ServletException {
		RequestDispatcher rd = request.getRequestDispatcher(pagename);
		rd.forward(request, response);
	}
	
}
