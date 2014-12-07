<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration</title>
</head>
<body>

<h1>Register</h1><br />
<br />

<form action="login" method="GET">

<h3>First name:<br /></h3>
<input type="text" name="first_name" />

<h3>Last name:<br /></h3>
<input type="text" name="last_name" />

<h3>Email:<br /></h3>
<input type="text" name="email" />

<h3>Password:<br /></h3>
<input type="password" name="password" />

<h3>Confirm Password:<br /></h3>
<input type="password" name="password_2" />

<h3>Mobile number:<br /></h3>
<input type="text" name="password" />

<h3>Address:<br /></h3>
<input type="text" name="address_1" /><br />
<input type="text" name="address_2" /><br />
<input type="text" name="address_3" /><br />

<fieldset>
  <legend>Type of account:</legend>
  <select name="type" >
   <option value="tenant">Tenant account</option>
   <option value="landlord">Landlord account</option>
  </select>
 </fieldset>

<br />
<br />
<input type="submit" value="Create account" />

</form>
</body>
</html>