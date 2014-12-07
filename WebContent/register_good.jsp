<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<meta HTTP-EQUIV="REFRESH" content="3; url=account.jsp">
<title>Welcome!</title>
</head>
<body>
<h3>
<%= request.getParameter("first_name")%> <%= request.getParameter("last_name")%>, welcome to FlatHunter!  <br />

If you're not redirected to your account page within a few seconds, please click <a href="account.jsp">here</a>.
</h3>
</body>
</html>