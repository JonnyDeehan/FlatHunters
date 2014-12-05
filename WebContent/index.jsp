<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="java.sql.*" %>
<%@ page import="src.DBUtil" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<title>Inasdfasdfitle here</title>
</head>
<body>

<% 
Connection cnt = DBUtil.createConnection("com.mysql.jdbc.Driver","jdbc:mysql://localhost:3306/TEST","root","root"); 
%>

<h1 style="text-align: center">FlatFinders</h1>

<div class="container-fluid">
<div class="row">
	<p>Welcome to FlatFinders, where we hope to help you find your home away from home
	for your years at uni in London.</p>
</div>
<div class="row">
<div class="col-md-4">
	<img src="resources/images/flat3.jpg" class="img-rounded">
</div>
</div>
</div>

<div>
To get started, either create an account
<a href="/FlatHuntersProject/hello">here</a>,
or start by entering the name of your uni here:
<form role="form">
  <div class="form-group">
    <input type="address" class="form-control" id="uniaddress" placeholder="Enter uni">
  </div>

  <button type="submit" class="btn btn-default">Submit</button>
</form>
</div>
</body>
</html>