<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="src.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Profile</title>
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

<!--  PAGE CODE  -->
<% User user = (User) request.getAttribute("user"); 
	Profile profile = user.getProfile();
%>

<h2 align="center"><%=user.getFirstName()%> <%=user.getLastName()%></h2>

<h2>Personal Information:</h2>
Bio: <%= profile.getBio() %><br>
Email: <%=profile.getEmail() %><br>

<h2>Reviews</h2>

<h2>Flats</h2>

</body>
</html>


<!--
<tr>
			<td>
				<h1>general description</h1>
			</td>
		</tr>
		<tr>
			<td>
				<h1>general description</h1>
			</td>
		</tr>
-->