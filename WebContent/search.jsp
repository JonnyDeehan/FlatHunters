<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="java.sql.*" %>
<%@ page import="src.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<title>FlatHunters</title>
</head>
<body>
<% 
Connection cnt = DBUtil.createConnection("com.mysql.jdbc.Driver","jdbc:mysql://localhost:3306/TEST","root","root"); 
%>
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

<!-- PAGE CODE -->
<h1 style="text-align: center">FlatHunters</h1>

<div class="container-fluid">
<div class="row">
	<h4 align="center">Welcome to FlatHunters, where we hope to help you find your home away from home
	for your years at uni in London.</h4>
</div>
<div class="row">
<div class="span4">
<div class="row text-center">
  <img src="resources/images/flat3.jpg" class="img-rounded">
</div>
</div>
</div>
</div>

<div>
To get started, either create an account
<a href="login">here</a>,
or start by entering the name of your uni here:
<form role="form" action="search" method="get">
  <div class="form-group">
    
    <input type="address" class="form-control" name="address" placeholder="Enter address here">
  </div>

<%	if(request.getParameter("full") != null && request.getParameter("full").equals("true")){ %>
	<input name="caller" type="hidden" value="0"/><br>
	<b>Minimum rating:</b><input name="rating" type="text" value="-1" size="2"/><br>
	<b>Price range: from </b><input name="min" type="text" value="0" size="5"/> to <input name="max" type="text" value="5000" size="5"/>per week.<br>
	<b>Bills included:</b><input name="bills" type="checkbox" value="included" 	checked="checked"/><br>
	<b>Washing Machine:</b><input name="washer" type="checkbox" value="included" checked="checked"/><br>
	<b>Pets allowed:</b><input name="pets" type="checkbox" value="allowed" 	checked="checked"/><br>
	<b>Children allowed:</b><input name="children" type="checkbox" value="allowed" checked="checked"/><br>
	<b>Smoking Allowed:</b><input name="smoking" type="checkbox" value="allowed"  checked="checked"/><br><br>
<%}%>
  <button type="submit" class="btn btn-default">Submit</button>
</form>
</div>
</body>
</html>