<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="src.Session" %>
<html>
<head>
<meta HTTP-EQUIV="REFRESH" content="3; url=profile">
<title>Welcome!</title>
</head>
<body>
<h3>
<%= Session.getInstance().getFirstName()%> <%= Session.getInstance().getLastName()%>, welcome to FlatHunter!  <br />

If you're not redirected to your account page within a few seconds, please click <a href="profile">here</a>.
</h3>
</body>
</html>