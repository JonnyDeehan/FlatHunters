<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="src.*" %>

<% Flat f = (Flat) request.getAttribute("flat"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<meta HTTP-EQUIV="REFRESH" content="2; url=flat?id=<%= f.getId()%>">
<title>Welcome!</title>
</head>
<body>
<h3>
The flat has been correctly added to your interesting flats! <br />

If you're not redirected to the flat page within a few seconds, please click <a href="flat?id=<%= f.getId()%>">here</a>.

</h3>
</body>
</html>