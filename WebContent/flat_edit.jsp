<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <%@ page import="java.util.*, src.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add a new flat</title>
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
<%!
User user=Session.getInstance().getUser();
boolean landlord=user instanceof Landlord;
%>

<form align="center" action="account"  method="get" enctype="multipart/form-data">
<h3>Image: </h3><input align="center" type="file" name="image" size="20" /><!-- TODO: GET RID OF THIS IF WE DON'T IMPLEMENT IMAGE UPLOAD -->
<h3>Address: </h3><input type=text size="25" name="address" value="" /><br>
	<h3>Flat description: </h3> <textarea cols="30" rows="7" name="description"></textarea>
	<h3>Price: </h3>£<input type=text size="5" name="price" value="0" /> per week<br>
	<h3>Amenities included:</h3>
	<b>Bills included:</b><input name="bills" type="checkbox" value="included" 	checked="checked"/><br>
	<b>Washing Machine:</b><input name="washer" type="checkbox" value="included" checked="checked"/><br>
	<b>Pets allowed:</b><input name="pets" type="checkbox" value="allowed" 	checked="checked"/><br>
	<b>Children allowed:</b><input name="children" type="checkbox" value="allowed" checked="checked"/><br>
	<b>Smoking Allowed:</b><input name="smoking" type="checkbox" value="allowed"  checked="checked"/><br><br>
	<input type="hidden" name="caller" value="4">
	<input type="submit" name="profile" value="Submit" />
	
<!-- TODO add list of amenities and add image upload -->
</form>
</body>
</html>