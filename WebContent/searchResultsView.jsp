<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="java.util.*, src.Flat"
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<title>FlatFinders</title>
</head>
<body>
<div>
<h1>Flat Listings</h1>
<% ArrayList<Flat> flatList = (ArrayList<Flat>) request.getAttribute("search_results"); %>
We found <b><%= flatList.size() %> </b> flats in this area!

<table class="table table-striped">
<% for(Flat f : flatList){
	%>
	
	<tr>
	<div class="row">
	<td>
	 
	<img src=<%=f.getImageLink()%> class="img-rounded"><br>
	 
	
	<b>Address: </b> <%= f.getAddress() %><br>
	<b>Property owner: </b> <%= f.getOwner() %><br>
	<b>Flat description: </b> <%= f.getDescription() %><br>
	<b>Price: </b> £<%= f.getPrice() %> per week<br>
	<b>Amenities included: </b><br>
	<% 
	HashMap<String, String> amenities = f.getAmenityList();
	for(String a : amenities.keySet()){
		if(!amenities.get(a).equals(Flat.UNDEFINED)){
			%>
			<row><%=a %> : <%=amenities.get(a) %><br>
			<%
		}
	}
	%>
	</div>
	</td>
	</tr>
	<%
}
%>
</table>
</div>
</body>
</html>