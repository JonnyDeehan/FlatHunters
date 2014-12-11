<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*, src.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<title>Flat Profile</title>
</head>
<body>
<!--  NAVIGATION BAR -->
<nav class="navbar navbar-default" role="navigation">
  <div class="container-fluid">
    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li class="active"><a href="search">Home <span class="sr-only">(current)</span></a></li>
        <li><a href="search?full=true">Search</a></li>
        <% 
      	if(Session.hasSession())
      		out.println("<li><a href=\"account\">My Account</a></li>");
      	%>
      </ul>
      <!-- 
      <form class="navbar-form navbar-left" role="search">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="Search">
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
      </form>
      -->
      <ul class="nav navbar-nav navbar-right">
      <% 
      	if(!Session.hasSession()){
      		out.println("<li><a href=\"login?caller=0&type=login\">Login</a></li>");
      		out.println("<li><a href=\"login?caller=0&type=register\">Register</a></li>");
      	}
      	if(Session.hasSession())
      		out.println("<li><a href=\"login?caller=0&type=logout\">Logout</a></li>");
      %>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>

<!--  PAGE CODE -->

<% 
Flat f = (Flat) request.getAttribute("flat");
%>

<h1 style="text-align:center"><%=f.getAddress() %></h1>
<div class="row text-center">
<img src=<%=f.getImageLink()%> class="img-rounded"><br>
</div>


<div>
<b>Overall rating: </b><%= f.getRating() %><br>
<b>Address: </b><%= f.getAddress() %><br>
	<b>Property owner: </b> <a href="/FlatHuntersProject/profile?userKey=<%=f.getOwner().getEmail()%>">
	<%= f.getOwner().getFirstName() %> 
	<%= f.getOwner().getLastName() %></a><br>
	<b>Flat description: </b> <%= f.getDescription() %><br>
	<b>Price: </b> £<%= f.getPrice() %> per week<br>
	<b>Amenities included: </b><br>
<% 
	boolean[] amenities = f.getAmenities();
	for(int i=0;i<amenities.length;i++){
			%>
			<row><%=f.amenities_name[i] %> : <%=(amenities[i])?("Yes"):("No") %><br>
			<%
	}
	%>
	

<%
	out.println("<form action=\"flat\" align=\"left\" method=\"GET\">");
	if(Session.hasSession()){
		User user=Session.getInstance().getUser();
		boolean landlord=user instanceof Landlord;
		if(!landlord)
			out.println("<input type=\"submit\" name=\"interested\" 	value=\"I'm interested!\" />");
	}
	out.println("<input type=\"hidden\" name=\"caller\" value=\"0\">"+
			"<input type=\"hidden\" name=\"id\" value=\""+f.getId()+"\">"+
			"</form>");

	//displaying the reviews
	for(Review r:f.getReviewList()){
		out.println(r.toHTML());
		out.println("<hr>");
	}
%>

<h2>Reviews</h2>

<form action="flat" method="get">
<input type="hidden" name="flatKey" value="<%= f.getId() %>" /><br />
<input type="hidden" name="caller" value="2" /><br />
<b>Your Rating</b> <input type="text" size="2" name="rating" value="0"/><br />
<textarea name="review" rows="5" cols="50">Write a review here.</textarea><br />
Author: <input type="text" size="20" name="author" /><br />
<input type="submit" name="add" value="Add a Review" /><br />
</form>

</div>
</body>
</html>