<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="java.sql.*" %>
<%@ page import="java.util.Enumeration" %>
<%@ page import="src.DBUtil" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

Dear <%= request.getParameter("first_name")%>: <br />

<%
Enumeration args=request.getParameterNames();

for(int i=0;args.hasMoreElements();i++){
	String name=(String)args.nextElement();
	String value=request.getParameter(name);
	
	if(name.equals("first_name") || name.equals("last_name"))
		continue;
	else
		out.println("You like "+name+".<br />");
}
%>


</body>
</html>